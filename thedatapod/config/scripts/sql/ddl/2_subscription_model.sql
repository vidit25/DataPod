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
  domain_id INT,
  CONSTRAINT subscription_pk PRIMARY KEY(subscription_id),
  CONSTRAINT subscription_type_id_fk FOREIGN KEY (subscription_type_id) REFERENCES datapoddb.subscription_type(subscription_type_id) ON DELETE CASCADE,
  CONSTRAINT address_fk FOREIGN KEY (address) REFERENCES datapoddb.address(address_id) ON DELETE CASCADE,
  CONSTRAINT sub_domain_id_fk FOREIGN KEY (domain_id) REFERENCES datapoddb.domains(domain_id) ON DELETE CASCADE
)ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS datapoddb.subscription_sub_domain_rel (
  subscription_id INT NOT NULL,
  sub_domain_id  INT NOT NULL,  
  CONSTRAINT subscription_sub_domain_pk PRIMARY KEY(subscription_id,sub_domain_id),
  CONSTRAINT subscription_id FOREIGN KEY (subscription_id) REFERENCES datapoddb.user_subscription(subscription_id) ON DELETE CASCADE,
  CONSTRAINT sub_scr_domain_id_fk FOREIGN KEY (sub_domain_id) REFERENCES datapoddb.sub_domains(sub_domain_id) ON DELETE CASCADE
)ENGINE=InnoDB;




CREATE TABLE IF NOT EXISTS datapoddb.account (
  account_id INT NOT NULL AUTO_INCREMENT,
  organization_name VARCHAR(100),
  organization_description VARCHAR(255),
  phone VARCHAR(10),
  subscription_id INT,
  calculated_cost DOUBLE,
  status VARCHAR(15),
  creation_date DATETIME,
  last_modified_date DATETIME,
  address INT,
  account_num VARCHAR(255),
  CONSTRAINT account_pk PRIMARY KEY(account_id),
  CONSTRAINT subscription_id_fk FOREIGN KEY (subscription_id) REFERENCES datapoddb.subscription_type(subscription_type_id) ON DELETE CASCADE,
  CONSTRAINT user_address_fk FOREIGN KEY (address) REFERENCES datapoddb.address(address_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.job_type (
  job_type_id INT NOT NULL AUTO_INCREMENT,
  job_name VARCHAR(100),
  job_description VARCHAR(255), 
  CONSTRAINT job_type_pk PRIMARY KEY(job_type_id)
)ENGINE=InnoDB;


CREATE TABLE datapoddb.authority (
   id  INT NOT NULL,
   name VARCHAR(255),
   PRIMARY KEY (id)
);

ALTER TABLE datapoddb.authority ADD CONSTRAINT authority_name UNIQUE (NAME);

CREATE TABLE IF NOT EXISTS datapoddb.dp_user (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NULL,
  last_name VARCHAR(250) NULL,
  phone VARCHAR(25) NULL,
  password VARCHAR(250) NOT NULL,
  last_login DATETIME NULL,
  account_expired BOOLEAN,
  account_locked BOOLEAN,
  credentials_expired BOOLEAN,
  enabled BOOLEAN,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC))
ENGINE = InnoDB;

ALTER TABLE  datapoddb.dp_user ADD CONSTRAINT user_name UNIQUE (email);


CREATE TABLE datapoddb.user_authorities (
   user_id INT NOT NULL,
   authority_id INT NOT NULL,
   PRIMARY KEY (user_id, authority_id)
);

ALTER TABLE  datapoddb.user_authorities ADD CONSTRAINT user_authorities_authority FOREIGN KEY (authority_id) REFERENCES datapoddb.authority (id);

ALTER TABLE  datapoddb.user_authorities ADD CONSTRAINT user_authorities_user_ FOREIGN KEY (user_id) REFERENCES datapoddb.dp_user (id);

ALTER TABLE  datapoddb.dp_user ADD COLUMN account_id INT ;
ALTER TABLE  datapoddb.dp_user ADD CONSTRAINT dp_user_acc_id_fk FOREIGN KEY (account_id) REFERENCES datapoddb.account (account_id);



CREATE TABLE `datapoddb`.`dp_cde` (
  `data_element_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(250) NULL,
  `sub_domain_id` INT NULL,
  PRIMARY KEY (`data_element_id`),
  INDEX `sub_domain_id_idx` (`sub_domain_id` ASC) VISIBLE,
  CONSTRAINT `sub_domain_id`
    FOREIGN KEY (`sub_domain_id`)
    REFERENCES `datapoddb`.`sub_domains` (`sub_domain_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
	ENGINE = InnoDB;

