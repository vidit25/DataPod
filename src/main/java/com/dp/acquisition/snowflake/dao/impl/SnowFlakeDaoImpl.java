package com.dp.acquisition.snowflake.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dp.acquisition.snowflake.dao.SnowFlakeDao;

@Repository
public class SnowFlakeDaoImpl implements SnowFlakeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(SnowFlakeDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void useDatabase(String database) {
		String dbSwitchSql = "USE " + database;
		LOGGER.info("Sql for DB Switch: {}", dbSwitchSql);
		jdbcTemplate.execute(dbSwitchSql);
		LOGGER.info("Switched to DB: {}", database);
	}

	@Override
	public void useWarehouse(String warehouse) {
		String whSwitchSql = "USE WAREHOUSE " + warehouse;
		LOGGER.info("Sql for Warehouse Switch: {}", whSwitchSql);
		jdbcTemplate.execute(whSwitchSql);
		LOGGER.info("Switched to Warehouse: {}", warehouse);
	}

	@Override
	public void alterWarehouse(String warehouse, boolean toResume) {
		String alterWhSql = "ALTER WAREHOUSE " + warehouse + (toResume ? " RESUME IF SUSPENDED" : " SUSPEND");
		LOGGER.info("Sql to " + (toResume ? " RESUME" : " SUSPEND") + " Warehouse: {}", alterWhSql);
		jdbcTemplate.execute(alterWhSql);
		LOGGER.info("{} {} Warehouse", (toResume ? " RESUMED" : " SUSPENDED"), warehouse);
	}

	@Override
	public void stageFiles(String file, String stageName) {
		String stageFileSql = "PUT file://" + file + " @" + stageName + " AUTO_COMPRESS=TRUE";
		LOGGER.info("Sql to stage files: {}", stageFileSql);
		jdbcTemplate.execute(stageFileSql);
		LOGGER.info("Staged file {} to stage {}", file, stageName);
	}

	// TODO Have to change the logic here to a merge query conditionally if there is a key else regular insert.
	//https://support.snowflake.net/s/article/how-to-perform-a-mergeupsert-from-a-flat-file-staged-on-s3
	@Override
	public void moveFromStageToTable(String tableName, String stageName, String file) {
		String stageFileSql = "COPY INTO " + tableName + " from @" + stageName + "/" + file + " FILE_FORMAT=(TYPE=CSV FIELD_DELIMITER=',' SKIP_HEADER=1, FIELD_OPTIONALLY_ENCLOSED_BY='\"') ON_ERROR = ABORT_STATEMENT";
		LOGGER.info("Sql to stage files: {}", stageFileSql);
		jdbcTemplate.execute(stageFileSql);
		LOGGER.info("Loaded file {} to table {} from stage {}", file, tableName, stageName);
	}

	@Override
	public void testDbConnection() {
		LOGGER.info("Create test table");
		jdbcTemplate.execute("create or replace table test(c1 string)");
		LOGGER.info("Done creating test table\n");

		LOGGER.info("Insert 'hello world'");
		jdbcTemplate.execute("insert into test values ('hello world')");
		LOGGER.info("Done inserting 'hello world'\n");

		LOGGER.info("Query test");
		jdbcTemplate.query("select * from test", this::printResult);
	}

	private void printResult(ResultSet rs) throws SQLException {
		LOGGER.info("Metadata:");
		LOGGER.info("================================");

		// fetch metadata
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		LOGGER.info("Number of columns=" + resultSetMetaData.getColumnCount());
		for (int colIdx = 0; colIdx < resultSetMetaData.getColumnCount(); colIdx++) {
			LOGGER.info("Column " + colIdx + ": type=" + resultSetMetaData.getColumnTypeName(colIdx + 1));
		}

		// fetch data
		LOGGER.info("\nData:");
		LOGGER.info("================================");
		int rowIdx = 0;
		while (rs.next()) {
			LOGGER.info("row " + rowIdx + ", column 0: " + rs.getString(1));
		}
	}

}
