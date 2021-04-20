CREATE TABLE `sf_attraction` (
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `zipcode` int(11) NOT NULL,
  PRIMARY KEY (`name`,`zipcode`,`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8