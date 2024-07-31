DROP TABLE IF EXISTS tematica_avaliador;

CREATE TABLE IF NOT EXISTS tematica_avaliador (
    id                          BIGINT AUTO_INCREMENT,
    avaliador_id                BIGINT,
    tematica                    VARCHAR(50),
    PRIMARY KEY (id)
    );