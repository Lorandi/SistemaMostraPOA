DROP TABLE IF EXISTS horario_disponibilidade;

CREATE TABLE IF NOT EXISTS disponibilidade_horario (
    id                  BIGINT AUTO_INCREMENT,
    data                DATE,
    dia_semana          VARCHAR(50),
    turno               VARCHAR(50),
    PRIMARY KEY (id)
    );