DROP TABLE IF EXISTS voluntario;

CREATE TABLE IF NOT EXISTS voluntario (
    id                          BIGINT AUTO_INCREMENT,
    name                        VARCHAR(100),
    email                       VARCHAR(50),
    cpf                         VARCHAR(15),
    phone                       VARCHAR(15),
    course                      VARCHAR(255),
    PRIMARY KEY (id)
    );