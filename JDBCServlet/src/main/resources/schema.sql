-- Dumping database structure for makenbaccon
CREATE SCHEMA IF NOT EXISTS `makenbaccon`;
USE `makenbaccon`;
-- Dumping structure for table makenbaccon.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `employeeId` INTEGER NOT NULL AUTO_INCREMENT(1,10),
  `name` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `supervisors` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`employeeId`)
) ;
-- Dumping data for table makenbaccon.employees: ~3 rows (approximately)
INSERT INTO `employees` (`employeeId`, `name`, `phoneNumber`, `supervisors`) VALUES
	(1, 'Long Nguyen', '949-322-3452', 'Long Nguyen'),
	(2, 'Kevin Pethtel ', '949-322-2564', 'Long Nguyen'),
	(3, 'Nghia ''Sam'' Phan', '714-435-5564', 'Kevin Pethel'); 