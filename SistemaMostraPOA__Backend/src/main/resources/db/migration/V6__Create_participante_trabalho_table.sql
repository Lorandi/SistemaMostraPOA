DROP TABLE IF EXISTS participante_trabalho;

CREATE TABLE IF NOT EXISTS participante_trabalho (
    id                  BIGINT AUTO_INCREMENT,
    trabalho_id         BIGINT,
    name                VARCHAR(100),
    email               VARCHAR(50),
    cpf                 VARCHAR(15),
    phone               VARCHAR(15),
    tipo_participante   VARCHAR(50),
    PRIMARY KEY (id)
    );