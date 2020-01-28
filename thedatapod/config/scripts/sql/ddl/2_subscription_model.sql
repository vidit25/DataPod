drop table datapoddb.subscription_sub_domain_rel;
drop table datapoddb.user_subscription;
drop table datapoddb.address;
drop table datapoddb.subscription_type;
drop table datapoddb.domains_sub_domain_rel;
drop table datapoddb.sub_domains;
drop table datapoddb.domains;


CREATE TABLE IF NOT EXISTS datapoddb.domains (
  domain_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100),
  description VARCHAR(255),
  status VARCHAR(20),
  CONSTRAINT domain_pk PRIMARY KEY(domain_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.sub_domains (
  sub_domain_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100),
  description VARCHAR(255),
  status VARCHAR(20),
  CONSTRAINT sub_domain_pk PRIMARY KEY(sub_domain_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.domains_sub_domain_rel (
  domain_id INT NOT NULL,
  sub_domain_id INT NOT NULL,
  CONSTRAINT sub_domain_rel_pk PRIMARY KEY(domain_id,sub_domain_id),
  CONSTRAINT domains_sub_domain_rel_domain_fk FOREIGN KEY (sub_domain_id) REFERENCES datapoddb.sub_domains(sub_domain_id) ON DELETE CASCADE,
  CONSTRAINT domains_domain_rel_domain_fk FOREIGN KEY (domain_id) REFERENCES datapoddb.domains(domain_id) ON DELETE CASCADE
  )ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.feature (
  feature_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100),
  description VARCHAR(255),
  CONSTRAINT feature_pk PRIMARY KEY(feature_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.subscription_type (
  subscription_type_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100),
  description VARCHAR(255),
  domain_id INT NOT NULL,
  cost DECIMAL,
  data_min_usage VARCHAR(15),
  data_max_usage VARCHAR(15),
  time_min_usage VARCHAR(15),
  time_max_usage VARCHAR(15),
  status VARCHAR(20),
  creation_date DATETIME,
  last_modified_date DATETIME,
  CONSTRAINT subscription_type_pk PRIMARY KEY(subscription_type_id),
  CONSTRAINT domain_id_fk FOREIGN KEY (domain_id) REFERENCES datapoddb.domains(domain_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.subscription_feature_rel (
  subscription_type_id INT NOT NULL,
  feature_id  INT NOT NULL,  
  CONSTRAINT subscription_feature_rel_pk PRIMARY KEY(subscription_type_id,feature_id),
  CONSTRAINT subscription_type_id_rel_fk FOREIGN KEY (subscription_type_id) REFERENCES datapoddb.subscription_type(subscription_type_id) ON DELETE CASCADE,
  CONSTRAINT feature_id__rel_fk FOREIGN KEY (feature_id) REFERENCES datapoddb.feature(feature_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.address (
  address_id INT NOT NULL AUTO_INCREMENT,
  address_line_1 VARCHAR(100),
  address_line_2 VARCHAR(100),
  city VARCHAR(50),
  state VARCHAR(50),
  country VARCHAR(20),
  pincode VARCHAR(10),
  CONSTRAINT address_pk PRIMARY KEY(address_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.user_subscription (
  subscription_id INT NOT NULL AUTO_INCREMENT,
  organization_name VARCHAR(100),
  organization_desc VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(15),
  user_name VARCHAR(100),
  subscription_type_id INT,
  status VARCHAR(20),
  creation_date DATETIME,
  last_modified_date DATETIME,
  address INT,
  CONSTRAINT subscription_pk PRIMARY KEY(subscription_id),
  CONSTRAINT subscription_type_id_fk FOREIGN KEY (subscription_type_id) REFERENCES datapoddb.subscription_type(subscription_type_id) ON DELETE CASCADE,
  CONSTRAINT address_fk FOREIGN KEY (address) REFERENCES datapoddb.address(address_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.subscription_sub_domain_rel (
  subscription_id INT NOT NULL,
  sub_domain_id  INT NOT NULL,  
  CONSTRAINT subscription_sub_domain_pk PRIMARY KEY(subscription_id,sub_domain_id),
  CONSTRAINT subscription_id FOREIGN KEY (subscription_id) REFERENCES datapoddb.user_subscription(subscription_id) ON DELETE CASCADE,
  CONSTRAINT sub_domain_id_fk FOREIGN KEY (sub_domain_id) REFERENCES datapoddb.sub_domains(sub_domain_id) ON DELETE CASCADE
)ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS datapoddb.account (
  account_id VARCHAR(255),
  organization_name VARCHAR(255),
  organization_description VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  user_name VARCHAR(255),
  subscription_id VARCHAR(255),
  calculated_cost VARCHAR(255),
  status VARCHAR(255),
  creation_date VARCHAR(255),
  last_modified_date VARCHAR(255),
  address VARCHAR(255),
  CONSTRAINT account_pk PRIMARY KEY(account_id),
  CONSTRAINT subscription_id_fk FOREIGN KEY (subscription_id) REFERENCES datapoddb.subscription(subscription_id) ON DELETE CASCADE,
  CONSTRAINT address_fk FOREIGN KEY (address_id) REFERENCES datapoddb.address(address_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.job_type (
  job_type_id VARCHAR(255),
  job_name VARCHAR(255),
  job_description VARCHAR(255), 
  CONSTRAINT job_type_pk PRIMARY KEY(job_type_id)
)ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS datapoddb.user (
  user_id VARCHAR(255),
  user_name VARCHAR(255),
  login VARCHAR(255),
  password_hash VARCHAR(255),
  phone VARCHAR(255),
  email VARCHAR(255),
  job_type_id VARCHAR(255),
  account_id VARCHAR(255),
  address_id VARCHAR(255),
  status VARCHAR(255),
  creation_date VARCHAR(255),
  last_modified_date VARCHAR(255),  
  CONSTRAINT user_pk PRIMARY KEY(user_id),
  CONSTRAINT job_type_id_fk FOREIGN KEY (job_type_id) REFERENCES datapoddb.job_type(job_type_id) ON DELETE CASCADE,
  CONSTRAINT address_fk FOREIGN KEY (address_id) REFERENCES datapoddb.address(address_id) ON DELETE CASCADE,
  CONSTRAINT account_fk FOREIGN KEY (account_id) REFERENCES datapoddb.account(account_id) ON DELETE CASCADE
)ENGINE=InnoDB;
