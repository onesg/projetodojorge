
------------------------------------------
-- TODOS OS SCRIPTS UTILIZADOS NO BANCO --
------------------------------------------



---- >>  CRIANDO BANCO DE DADOS MYSQL db_consulta  << ----

--  (opicional)
CREATE DATABASE IF NOT EXISTS db_consulta
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;



---- >>  CRIANDO A TABELA medico  << ----

--  V1.0__create_medico_table.sql
CREATE TABLE IF NOT EXISTS medico (
  id_medico             BIGINT(20)  NOT NULL AUTO_INCREMENT,
  crm_medico            VARCHAR(9)  NOT NULL,
  especialidade_medico  VARCHAR(64) NOT NULL,
  nome_medico           VARCHAR(64) NOT NULL,
  telefone_medico       VARCHAR(11) DEFAULT NULL,
  PRIMARY KEY (id_medico)
);



---- >>  CRIANDO A TABELA paciente  << ----

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



---- >>  INSERINDO REGISTROS NA TABELA medico  << ----

--  V1.2__populate_medico_table.sql
INSERT INTO medico
(nome_medico, crm_medico, especialidade_medico, telefone_medico) VALUES
('Jheniffer', 922374759, 'Pediatria', '3152295104'),
('Gustavo', 294857956, 'Dermatologia', '2883050410'),
('Saulo', 465133456, 'Cardiologia', '5091737667'),
('Pollyana', 686683605, 'Ginecologia', '9181557965'),
('Gervásio', 484045053, 'Ortopedia', '2597518125'),
('Big T', 887294932, 'Urologia', '9747691701'),
('Tiago', 613511821, 'Epidemiologia', null),
('Jorge Careca', 866350978, 'Urologia', '4481416059'),
('Guilherme', 521100934, 'Oftalmologia', '3597530243'),
('Aryeli', 343667426, 'Neurologia', null);



---- >>  INSERINDO REGISTROS NA TABELA paciente  << ----

--  V1.3__populate_paciente_table.sql
INSERT INTO paciente
(nome_paciente, nascimento_paciente, telefone_paciente, medico_id) VALUES
('Theo Gabriel Campos', '2000-03-07', '27998127408', 1),
('Alana Rosângela Manuela Baptista', '1980-05-02', '69997846466', 1),
('Yasmin Elaine Assunção', '1991-01-10', '47996391247', 2),
('Olivia Analu Marlene Silveira', '1999-03-28', '85981441959', 5),
('Paulo Yuri da Costa', '2006-07-10', '95989537559', 6),
('Rafael Emanuel Mendes', '1990-01-09', '35988673502', 8),
('Ester Jaqueline Novaes', '1991-09-05', '62994943031', 8),
('Luís Kevin Hugo da Mota', '2012-06-10', '79995197143', 3),
('Lavínia Josefa Jesus', '2008-05-28', '65999462799', 5),
('Sarah Priscila Moura', '1987-01-24', '86981960438', 2);
