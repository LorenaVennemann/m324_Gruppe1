CREATE DATABASE IF NOT EXISTS `flights_db`;
USE `flights_db`;

DROP TABLE IF EXISTS `flights`;
CREATE TABLE `flights` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `departure_airport_code` varchar(3) NOT NULL,
    `arrival_airport_code` varchar(3) NOT NULL,
    `departure_datetime` datetime NOT NULL,
    `arrival_datetime` datetime NOT NULL,
    `aircraft_type` varchar(50) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    CHECK (`departure_airport_code` != `arrival_airport_code`),
    CHECK (`arrival_datetime` > `departure_datetime`),
    CHECK (LENGTH(`departure_airport_code`) = 3),
    CHECK (LENGTH(`arrival_airport_code`) = 3)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;