
--  V1.1__create_paciente_table.sql

CREATE TABLE IF NOT EXISTS paciente (
  id_paciente           BIGINT(20)  NOT NULL AUTO_INCREMENT,
  nascimento_paciente   DATE        NOT NULL,
  nome_paciente         VARCHAR(64) NOT NULL,
  telefone_paciente     VARCHAR(11) DEFAULT NULL,
  medico_id             BIGINT(20)  NOT NULL,
  PRIMARY KEY (id_paciente),
  FOREIGN KEY (medico_id) REFERENCES medico(id_medico)
);
