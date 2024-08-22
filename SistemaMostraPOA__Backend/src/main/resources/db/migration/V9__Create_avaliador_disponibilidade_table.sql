DROP TABLE IF EXISTS avaliador_disponibilidade;

CREATE TABLE IF NOT EXISTS avaliador_disponibilidade (
    id                          BIGINT AUTO_INCREMENT,
    avaliador_id               BIGINT,
    disponibilidade_horario_id  BIGINT,
    PRIMARY KEY (id)
    );