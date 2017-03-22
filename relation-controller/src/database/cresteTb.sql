/*[17:37:32][426 ms]*/ CREATE TABLE `relation`.`user`( `id` INT(25) NOT NULL AUTO_INCREMENT, `userName` VARCHAR(255), `passWord` VARCHAR(255), `actualName` VARCHAR(255), PRIMARY KEY (`id`) );
/*[17:37:37][0 ms]*/ SHOW FULL TABLES FROM `relation` WHERE table_type = 'BASE TABLE'; 
/*[17:37:37][0 ms]*/ SHOW FULL TABLES FROM `relation` WHERE table_type = 'BASE TABLE'; 
/*[17:37:37][0 ms]*/ SHOW CHARSET; 
/*[17:37:37][1 ms]*/ SHOW TABLE STATUS FROM `relation` LIKE 'user'; 
/*[17:37:37][0 ms]*/ SHOW CHARSET; 
/*[17:37:37][0 ms]*/ SHOW FULL FIELDS FROM `relation`.`user`; 
/*[17:37:37][0 ms]*/ SHOW KEYS FROM `relation`.`user` ; 
/*[17:37:37][1 ms]*/ SHOW COLLATION; 
/*[18:05:33][53 ms]*/ CREATE TABLE `relation`.`rs_account`( `id` INT(50) NOT NULL AUTO_INCREMENT, `balance` DECIMAL(20,2), `accumulat_increase` DECIMAL(20,2), `accumulat_decrease` DECIMAL(20,2), `create_date` DATETIME NOT NULL DEFAULT 'now()', `modify_date` DATETIME, `operater` VARCHAR(255), `last_balance` DECIMAL(20,2), `rs_name` VARCHAR(255), `re_num` VARCHAR(255), `version` INT(50), PRIMARY KEY (`id`) ); 
/*[18:06:26][2 ms]*/ CREATE TABLE `relation`.`rs_account`( `id` INT(50) NOT NULL AUTO_INCREMENT, `balance` DECIMAL(20,2), `accumulat_increase` DECIMAL(20,2), `accumulat_decrease` DECIMAL(20,2), `create_date` DATETIME NOT NULL DEFAULT 'comment', `modify_date` DATETIME, `operater` VARCHAR(255), `last_balance` DECIMAL(20,2), `rs_name` VARCHAR(255), `re_num` VARCHAR(255), `version` INT(50), PRIMARY KEY (`id`) ); 
/*[18:06:49][2 ms]*/ CREATE TABLE `relation`.`rs_account`( `id` INT(50) NOT NULL AUTO_INCREMENT, `balance` DECIMAL(20,2), `accumulat_increase` DECIMAL(20,2), `accumulat_decrease` DECIMAL(20,2), `create_date` DATETIME NOT NULL DEFAULT 'CURRENT_TIMESTAMP', `modify_date` DATETIME, `operater` VARCHAR(255), `last_balance` DECIMAL(20,2), `rs_name` VARCHAR(255), `re_num` VARCHAR(255), `version` INT(50), PRIMARY KEY (`id`) ); 
/*[18:07:00][120 ms]*/ DESCRIBE `relation`.`user`; 
/*[18:07:00][1 ms]*/ SHOW INDEX FROM `relation`.`user`; 
/*[18:07:01][1 ms]*/ DESCRIBE `relation`.`user`; 
/*[18:07:01][1 ms]*/ SHOW INDEX FROM `relation`.`user`; 
/*[18:07:03][2 ms]*/ CREATE TABLE `relation`.`rs_account`( `id` INT(50) NOT NULL AUTO_INCREMENT, `balance` DECIMAL(20,2), `accumulat_increase` DECIMAL(20,2), `accumulat_decrease` DECIMAL(20,2), `create_date` DATETIME NOT NULL DEFAULT 'CURRENT_TIMESTAMP', `modify_date` DATETIME, `operater` VARCHAR(255), `last_balance` DECIMAL(20,2), `rs_name` VARCHAR(255), `re_num` VARCHAR(255), `version` INT(50), PRIMARY KEY (`id`) ); 
/*[18:07:35][276 ms]*/ CREATE TABLE `relation`.`rs_account`( `id` INT(50) NOT NULL AUTO_INCREMENT, `balance` DECIMAL(20,2), `accumulat_increase` DECIMAL(20,2), `accumulat_decrease` DECIMAL(20,2), `create_date` DATETIME NOT NULL, `modify_date` DATETIME, `operater` VARCHAR(255), `last_balance` DECIMAL(20,2), `rs_name` VARCHAR(255), `re_num` VARCHAR(255), `version` INT(50), PRIMARY KEY (`id`) ); 
/*[18:07:38][1 ms]*/ SHOW TABLE STATUS FROM `relation` LIKE 'rs_account'; 
/*[18:07:38][0 ms]*/ SHOW CHARSET; 
/*[18:07:38][1 ms]*/ SHOW FULL FIELDS FROM `relation`.`rs_account`; 
/*[18:07:38][0 ms]*/ SHOW KEYS FROM `relation`.`rs_account` ; 
/*[18:07:38][1 ms]*/ SHOW COLLATION; 
/*[18:07:38][0 ms]*/ SHOW FULL TABLES FROM `relation` WHERE table_type = 'BASE TABLE'; 
/*[18:07:39][1 ms]*/ DESCRIBE `relation`.`rs_account`; 
/*[18:07:39][0 ms]*/ SHOW INDEX FROM `relation`.`rs_account`; 
/*[18:07:56][0 ms]*/ SHOW TABLE STATUS FROM `relation` LIKE 'rs_account'; 
/*[18:07:56][0 ms]*/ SHOW CHARSET; 
/*[18:07:56][1 ms]*/ SHOW FULL FIELDS FROM `relation`.`rs_account`; 
/*[18:07:56][0 ms]*/ SHOW KEYS FROM `relation`.`rs_account` ; 
/*[18:07:56][1 ms]*/ SHOW COLLATION; 
/*[18:08:39][18 ms]*/ ALTER TABLE `relation`.`rs_account` CHANGE `create_date` `create_date` DATETIME DEFAULT 'CURRENT_TIMESTAMP' NOT NULL; 
/*[18:08:59][74 ms]*/ ALTER TABLE `relation`.`rs_account` CHANGE `create_date` `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ; 
/*[18:09:11][1 ms]*/ SELECT * FROM `relation`.`rs_account` LIMIT 0, 30; 
/*[18:09:11][0 ms]*/ SHOW CREATE TABLE `relation`.`rs_account`; 
/*[18:09:11][1 ms]*/ SHOW FULL FIELDS FROM `relation`.`rs_account`; 
/*[18:09:11][0 ms]*/ SHOW KEYS FROM `relation`.`rs_account`; 
/*[18:09:25][65 ms]*/ INSERT INTO `relation`.`rs_account` (`id`, `balance`, `accumulat_increase`, `accumulat_decrease`, `create_date`, `modify_date`, `operater`, `last_balance`, `rs_name`, `re_num`, `version`) VALUES (NULL, '1', '123', '3', CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL, NULL); 
/*[18:09:28][1 ms]*/ SELECT * FROM `relation`.`rs_account` LIMIT 0, 30; 
/*[18:09:28][0 ms]*/ SHOW CREATE TABLE `relation`.`rs_account`; 
/*[18:09:28][0 ms]*/ SHOW FULL FIELDS FROM `relation`.`rs_account`; 
/*[18:09:28][11 ms]*/ SHOW KEYS FROM `relation`.`rs_account`; 
/*[18:09:54][173 ms]*/ DELETE FROM `relation`.`rs_account` WHERE `id` = '1'; 








CREATE TABLE relation.transaction_flow
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rs_name VARCHAR(255),
    rs_num LONG,
    operateAmount DECIMAL(20,2),
    date_create TIMESTAMP NOT NULL,
    description VARCHAR(255)
);
ALTER TABLE relation.transaction_flow ADD status BOOLEAN NOT NULL;

