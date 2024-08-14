DROP TABLE IF EXISTS trabalho;

CREATE TABLE IF NOT EXISTS trabalho (
    id              BIGINT AUTO_INCREMENT,
    titulo          VARCHAR(100),
    apresentacao    VARCHAR(50),
    tematica        VARCHAR(50),
    observacao      VARCHAR(500),
    link_resumo     VARCHAR(255),
    aceite          BOOLEAN,
    PRIMARY KEY (id)
    );