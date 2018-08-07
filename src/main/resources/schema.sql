CREATE TABLE IF NOT EXISTS requests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(36) NOT NULL,
    email VARCHAR(64) NOT NULL,
    subject VARCHAR(36),
    description VARCHAR(255)
    );