create database `assimilate_dec18`;
use `assimilate_dec18`;
CREATE TABLE `assimilate_dec18`.`employee` (
  `employee_id` INT NOT NULL,
  `employee_name` VARCHAR(45) NULL,
  `salary` INT NULL,
  `department` VARCHAR(45) NULL,
  PRIMARY KEY (`employee_id`));



CREATE TABLE `assimilate_dec18`.`user` (
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `mobile_number` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `user_name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));


