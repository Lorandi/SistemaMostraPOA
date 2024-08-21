DROP TABLE IF EXISTS voluntario_disponibilidade;

CREATE TABLE IF NOT EXISTS voluntario_disponibilidade (
    voluntario_id               BIGINT,
    disponibilidade_horario_id  BIGINT,
    PRIMARY KEY (voluntario_id)
    );