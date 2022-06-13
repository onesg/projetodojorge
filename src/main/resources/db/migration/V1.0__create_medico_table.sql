
--  V1.0__create_medico_table.sql

CREATE TABLE IF NOT EXISTS medico (
  id_medico             BIGINT(20)  NOT NULL AUTO_INCREMENT,
  crm_medico            VARCHAR(9)  NOT NULL,
  especialidade_medico  VARCHAR(64) NOT NULL,
  nome_medico           VARCHAR(64) NOT NULL,
  telefone_medico       VARCHAR(11) DEFAULT NULL,
  PRIMARY KEY (id_medico)
);
