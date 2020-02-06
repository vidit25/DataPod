
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

CREATE TABLE `datapoddb`.`dp_meta_data_cde` (
  `meta_data_id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `data_element_id` INT NULL,
  PRIMARY KEY (`meta_data_id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  INDEX `data_element_id_idx` (`data_element_id` ASC) VISIBLE,
  CONSTRAINT `account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `datapoddb`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `data_element_id`
    FOREIGN KEY (`data_element_id`)
    REFERENCES `datapoddb`.`dp_cde` (`data_element_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
	ENGINE = InnoDB;
