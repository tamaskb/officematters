CREATE TABLE IF NOT EXISTS requests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(36) NOT NULL,
    email VARCHAR(64) NOT NULL,
    subject VARCHAR(36),
    description VARCHAR(255),
    progress INT,
    priority INT
    );
    
CREATE TABLE IF NOT EXISTS comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
	comment VARCHAR(255),
	requestid INT
	);