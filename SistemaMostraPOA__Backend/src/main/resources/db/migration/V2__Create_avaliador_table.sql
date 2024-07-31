DROP TABLE IF EXISTS avaliador;

CREATE TABLE IF NOT EXISTS avaliador (
    id                          BIGINT AUTO_INCREMENT,
    name                        VARCHAR(100),
    email                       VARCHAR(50),
    cpf                         VARCHAR(15),
    phone                       VARCHAR(15),
    institutional_affiliation   VARCHAR(255),
    lattes                      VARCHAR(255),
    PRIMARY KEY (id)
    );