CREATE SCHEMA IF NOT EXISTS `datapoddb`;

CREATE TABLE `datapoddb`.`oauth_client_details` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `RESOURCE_IDS` varchar(255) DEFAULT NULL,
  `CLIENT_SECRET` varchar(255) DEFAULT NULL,
  `SCOPE` varchar(255) DEFAULT NULL,
  `AUTHORIZED_GRANT_TYPES` varchar(255) DEFAULT NULL,
  `WEB_SERVER_REDIRECT_URI` varchar(255) DEFAULT NULL,
  `AUTHORITIES` varchar(255) DEFAULT NULL,
  `ACCESS_TOKEN_VALIDITY` int(11) DEFAULT NULL,
  `REFRESH_TOKEN_VALIDITY` int(11) DEFAULT NULL,
  `ADDITIONAL_INFORMATION` varchar(4096) DEFAULT NULL,
  `AUTOAPPROVE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS datapoddb.oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS datapoddb.oauth_code (
  code VARCHAR(255),
  authentication BLOB
);

CREATE TABLE IF NOT EXISTS datapoddb.oauth_approvals (
  userid VARCHAR(255),
  clientid VARCHAR(255),
  scope VARCHAR(255),
  status VARCHAR(10),
  expiresat TIMESTAMP,
  lastmodifiedat TIMESTAMP
)ENGINE = InnoDB;

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
  password VARCHAR(250) NULL,
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
