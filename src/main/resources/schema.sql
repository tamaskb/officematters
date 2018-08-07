CREATE TABLE IF NOT EXISTS requests (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(36) NOT NULL,
    email VARCHAR(64) NOT NULL,
    subject VARCHAR(36),
    description VARCHAR(255)
    );