CREATE DATABASE IF NOT EXISTS cab;
USE cab;

CREATE TABLE IF NOT EXISTS customers(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS drivers(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone VARCHAR(20),
    vehicle VARCHAR(100),
    plate VARCHAR(50),
    status VARCHAR(50),
    rating DOUBLE
);

CREATE TABLE IF NOT EXISTS rides(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    driver_id BIGINT,
    pickup VARCHAR(255),
    drop_location VARCHAR(255),
    distance DOUBLE,
    fare DOUBLE,
    status VARCHAR(50),
    booked_at DATETIME
);
