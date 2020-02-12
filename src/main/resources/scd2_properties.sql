-- How to do scd2 in snowflake articles
--https://community.snowflake.com/s/article/Building-a-Type-2-Slowly-Changing-Dimension-in-Snowflake-Using-Streams-and-Tasks-Part-1
--https://community.snowflake.com/s/article/Building-a-Type-2-Slowly-Changing-Dimension-in-Snowflake-Using-Streams-and-Tasks-Part-2

-- Example of the tables to be created before acquisition starts
-- Main Table where modifications happen
create or replace table customer (
  C_CUSTKEY NUMBER, 
  C_NAME varchar2(1000), 
  C_ADDRESS varchar2(2000), 
  C_NATIONKEY varchar2(2000), 
  C_PHONE varchar2(15), 
  C_ACCTBAL NUMBER, 
  C_MKTSEGMENT varchar2(1000),	
  C_COMMENT varchar2(4000),
  update_timestamp timestamp_ntz default to_timestamp_ntz(current_timestamp()));

-- table with history 
create or replace table customer_history (
  C_CUSTKEY NUMBER, 
  C_NAME varchar2(1000), 
  C_ADDRESS varchar2(2000), 
  C_NATIONKEY varchar2(2000), 
  C_PHONE varchar2(15), 
  C_ACCTBAL NUMBER, 
  C_MKTSEGMENT varchar2(1000),	
  C_COMMENT varchar2(4000),
  start_time timestamp_ntz,
  end_time timestamp_ntz,
  current_flag int);
  };

-- stream on main table
create or replace stream customer_data_changes_stream on table customer;

-- create view on stream and history table
CREATE OR replace VIEW customer_data_change_view 
AS 
  -- This subquery figures out what to do when data is inserted into the NATION table 
  -- An insert to the NATION table results in an INSERT to the NATION_HISTORY table 
  SELECT c_custkey, 
         c_name, 
         c_address, 
         c_nationkey, 
         c_phone, 
         c_acctbal, 
         c_mktsegment, 
         c_comment, 
         start_time, 
         end_time, 
         current_flag, 
         'I' AS dml_type 
  FROM   (SELECT c_custkey, 
                 c_name, 
                 c_address, 
                 c_nationkey, 
                 c_phone, 
                 c_acctbal, 
                 c_mktsegment, 
                 c_comment, 
                 update_timestamp                    AS start_time, 
                 Lag(update_timestamp) 
                   over ( 
                     PARTITION BY c_custkey 
                     ORDER BY update_timestamp DESC) AS end_time_raw, 
                 CASE 
                   WHEN end_time_raw IS NULL THEN '9999-12-31' :: timestamp_ntz 
                   ELSE end_time_raw 
                 END                                 AS end_time, 
                 CASE 
                   WHEN end_time_raw IS NULL THEN 1 
                   ELSE 0 
                 END                                 AS current_flag 
          FROM   (SELECT c_custkey, 
                         c_name, 
                         c_address, 
                         c_nationkey, 
                         c_phone, 
                         c_acctbal, 
                         c_mktsegment, 
                         c_comment, 
                         update_timestamp 
                  FROM   customer_data_changes_stream 
                  WHERE  metadata$action = 'INSERT' 
                         AND metadata$isupdate = 'FALSE')) 
  UNION 
  -- This subquery figures out what to do when data is updated in the NATION table 
  -- An update to the NATION table results in an update AND an insert to the NATION_HISTORY table 
  -- The subquery below generates two records, each with a different dml_type 
  SELECT c_custkey, 
         c_name, 
         c_address, 
         c_nationkey, 
         c_phone, 
         c_acctbal, 
         c_mktsegment, 
         c_comment, 
         start_time, 
         end_time, 
         current_flag, 
         dml_type 
  FROM   (SELECT c_custkey, 
                 c_name, 
                 c_address, 
                 c_nationkey, 
                 c_phone, 
                 c_acctbal, 
                 c_mktsegment, 
                 c_comment, 
                 update_timestamp                    AS start_time, 
                 Lag(update_timestamp) 
                   over ( 
                     PARTITION BY c_custkey 
                     ORDER BY update_timestamp DESC) AS end_time_raw, 
                 CASE 
                   WHEN end_time_raw IS NULL THEN '9999-12-31' :: timestamp_ntz 
                   ELSE end_time_raw 
                 END                                 AS end_time, 
                 CASE 
                   WHEN end_time_raw IS NULL THEN 1 
                   ELSE 0 
                 END                                 AS current_flag, 
                 dml_type 
          FROM   (-- Identify data to insert into nation_history table 
                 SELECT c_custkey, 
                        c_name, 
                        c_address, 
                        c_nationkey, 
                        c_phone, 
                        c_acctbal, 
                        c_mktsegment, 
                        c_comment, 
                        update_timestamp, 
                        'I' AS dml_type 
                 FROM   customer_data_changes_stream 
                 WHERE  metadata$action = 'INSERT' 
                        AND metadata$isupdate = 'TRUE' 
                  UNION 
                  -- Identify data in NATION_HISTORY table that needs to be updated 
                  SELECT c_custkey, 
                         NULL, 
                         NULL, 
                         NULL, 
                         NULL,
                         NULL,
                         NULL,
                         NULL,
                         start_time, 
                         'U' AS dml_type 
                  FROM   customer_history 
                  WHERE  c_custkey IN (SELECT DISTINCT c_custkey 
                                       FROM   customer_data_changes_stream 
                                       WHERE  metadata$action = 'INSERT' 
                                              AND metadata$isupdate = 'TRUE') 
                         AND current_flag = 1)) 
  UNION 
  -- This subquery figures out what to do when data is deleted from the NATION table 
  -- A deletion from the NATION table results in an update to the NATION_HISTORY table 
  SELECT cs.c_custkey, 
         NULL, 
         NULL, 
         NULL, 
         NULL,
         NULL,
         NULL,
         NULL,
         ch.start_time, 
         Current_timestamp() :: timestamp_ntz, 
         NULL, 
         'D' 
  FROM   customer_history ch 
         inner join customer_data_changes_stream cs 
                 ON ch.c_custkey = cs.c_custkey 
  WHERE  cs.metadata$action = 'DELETE' 
         AND cs.metadata$isupdate = 'FALSE' 
         AND ch.current_flag = 1; 

-- merge query to do scd2
merge into customer_history ch -- Target table to merge changes from customer into
-- customer_data_change_view is a view that holds the logic that determines what to insert/update into the NATION_HISTORY table.
using customer_data_change_view v 
-- n_nationkey and start_time determine whether there is a unique record in the NATION_HISTORY table
   on  ch.c_custkey = v.c_custkey 
   and ch.start_time = v.start_time
-- Indicates the record has been updated and is no longer current and the end_time needs to be stamped
when matched and v.dml_type = 'U' then update
    set ch.end_time = v.end_time,
        ch.current_flag = 0
-- Deletes are essentially logical deletes. The record is stamped and no newer version is inserted
when matched and v.dml_type = 'D' then update
    set ch.end_time = v.end_time,
        ch.current_flag = 0
-- Inserting a new n_nationkey and updating an existing one both result in an insert
when not matched and v.dml_type = 'I' then insert 
           (c_custkey, 
                 c_name, 
                 c_address, 
                 c_nationkey, 
                 c_phone, 
                 c_acctbal, 
                 c_mktsegment, 
                 c_comment, start_time, end_time, current_flag)
    values (v.c_custkey, 
                 v.c_name, 
                 v.c_address, 
                 v.c_nationkey, 
                 v.c_phone, 
                 v.c_acctbal, 
                 v.c_mktsegment, 
                 v.c_comment, v.start_time, v.end_time, v.current_flag);

                 
-- To create task to run the above query every minute
--Set up TASKADMIN role
use role securityadmin;
create role taskadmin;
-- Set the active role to ACCOUNTADMIN before granting the EXECUTE TASK privilege to TASKADMIN
use role accountadmin;
grant execute task on account to role taskadmin;

-- Set the active role to SECURITYADMIN to show that this role can grant a role to another role 
use role securityadmin;
grant role taskadmin to role sysadmin;
use role sysadmin;
create warehouse if not exists task_warehouse with warehouse_size = 'XSMALL' auto_suspend = 120;

create or replace task populate_customer_history warehouse = task_warehouse schedule = '1 minute' when system$stream_has_data('customer_data_changes_stream')
as merge into customer_history ch -- Target table to merge changes from customer into
-- customer_data_change_view is a view that holds the logic that determines what to insert/update into the NATION_HISTORY table.
using customer_data_change_view v 
-- n_nationkey and start_time determine whether there is a unique record in the NATION_HISTORY table
   on  ch.c_custkey = v.c_custkey 
   and ch.start_time = v.start_time
-- Indicates the record has been updated and is no longer current and the end_time needs to be stamped
when matched and v.dml_type = 'U' then update
    set ch.end_time = v.end_time,
        ch.current_flag = 0
-- Deletes are essentially logical deletes. The record is stamped and no newer version is inserted
when matched and v.dml_type = 'D' then update
    set ch.end_time = v.end_time,
        ch.current_flag = 0
-- Inserting a new n_nationkey and updating an existing one both result in an insert
when not matched and v.dml_type = 'I' then insert 
           (c_custkey, 
                 c_name, 
                 c_address, 
                 c_nationkey, 
                 c_phone, 
                 c_acctbal, 
                 c_mktsegment, 
                 c_comment, start_time, end_time, current_flag)
    values (v.c_custkey, 
                 v.c_name, 
                 v.c_address, 
                 v.c_nationkey, 
                 v.c_phone, 
                 v.c_acctbal, 
                 v.c_mktsegment, 
                 v.c_comment, v.start_time, v.end_time, v.current_flag);

-- TODO Have to change to merge  query in copy command, will have to programatically generate this query
MERGE INTO foo USING
(SELECT $1 barKey,
 $2 newVal,
 $3 newStatus,
 ...
FROM @my_stage( FILE_FORMAT => 'csv', PATTERN => '.*my_pattern.*')
) bar ON foo.fooKey = bar.barKey
WHEN MATCHED THEN
 UPDATE SET val = bar.newVal, status = bar.newStatusWHEN NOT MATCHED THEN
 INSERT
 (val, status
 ) VALUES
 (bar.newVal, bar.newStatus
 );