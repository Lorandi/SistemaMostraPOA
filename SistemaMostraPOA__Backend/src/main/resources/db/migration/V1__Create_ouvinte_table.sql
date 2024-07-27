DROP TABLE IF EXISTS ouvinte;

CREATE TABLE IF NOT EXISTS ouvinte (
    id                  BIGINT AUTO_INCREMENT,
    name                VARCHAR(100),
    email               VARCHAR(50),
    cpf                 VARCHAR(15),
    phone               VARCHAR(15),
    PRIMARY KEY (id)
    );