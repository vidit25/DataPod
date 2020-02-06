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

CREATE TABLE `datapoddb`.`dp_meta_tablename` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tablename` VARCHAR(250) NULL,
  `account_id` INT NULL,
  CONSTRAINT dp_meta_tablename_pk PRIMARY KEY(id),
  CONSTRAINT `meta_tablename_account_fk` FOREIGN KEY (`account_id`) REFERENCES `datapoddb`.`account` (`account_id`)  
  	ON DELETE NO ACTION 
  	ON UPDATE NO ACTION)
	ENGINE = InnoDB;	
	
CREATE TABLE `datapoddb`.`dp_meta_columnname` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `columnname` VARCHAR(250) NULL,
  `tablename_id` INT NULL,
  CONSTRAINT dp_meta_columnname_pk PRIMARY KEY(id),
  CONSTRAINT `meta_columnname_tablename_fk` FOREIGN KEY (`tablename_id`) REFERENCES `datapoddb`.`dp_meta_tablename` (`id`)  
  	ON DELETE NO ACTION 
  	ON UPDATE NO ACTION)
	ENGINE = InnoDB;
	
