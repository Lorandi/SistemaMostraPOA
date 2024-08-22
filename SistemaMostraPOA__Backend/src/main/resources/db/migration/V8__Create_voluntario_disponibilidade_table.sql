DROP TABLE IF EXISTS voluntario_disponibilidade;

CREATE TABLE IF NOT EXISTS voluntario_disponibilidade (
    id                          BIGINT AUTO_INCREMENT,
    voluntario_id               BIGINT,
    disponibilidade_horario_id  BIGINT,
    PRIMARY KEY (id)
    );