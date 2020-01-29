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

