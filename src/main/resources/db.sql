DROP DATABASE bus_tickets;
CREATE DATABASE bus_tickets;
USE bus_tickets;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(50) NOT NULL,
                       last_name VARCHAR(50) NOT NULL,
                       patronymic VARCHAR(50),
                       login VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL
);

-- Таблица администраторов
CREATE TABLE admins (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        position VARCHAR(50) NOT NULL,
                        user_id INT UNIQUE NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Таблица клиентов
CREATE TABLE clients (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         email VARCHAR(255) NOT NULL,
                         phone VARCHAR(20) NOT NULL,
                         user_id INT UNIQUE NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES users(id)
);