-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_barbearia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_barbearia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_barbearia` DEFAULT CHARACTER SET utf8 ;
USE `db_barbearia` ;

-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_categoria_fun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_barbearia`.`tbl_categoria_fun` (
  `n_id_categoriafun` INT NOT NULL AUTO_INCREMENT,
  `c_nome_categoriafun` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`n_id_categoriafun`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_barbearia`.`tbl_funcionario` (
  `n_id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `c_nome_funcionario` VARCHAR(155) NOT NULL,
  `c_email_funcionario` VARCHAR(100) NOT NULL,
  `c_cpf_funcionario` VARCHAR(14) NOT NULL,
  `c_senha_funcionario` VARCHAR(50) NOT NULL,
  `f_salario_funcionario` FLOAT(6,2) NOT NULL,
  `n_id_categoriafun` INT NOT NULL,
  PRIMARY KEY (`n_id_funcionario`),
  INDEX `fk_fun_categoria_idx` (`n_id_categoriafun` ASC) ,
  CONSTRAINT `fk_tbl_funcionario_tbl_categoria_fun1`
    FOREIGN KEY (`n_id_categoriafun`)
    REFERENCES `db_barbearia`.`tbl_categoria_fun` (`n_id_categoriafun`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_barbearia`.`tbl_cliente` (
  `n_id_cliente` INT NOT NULL AUTO_INCREMENT,
  `c_nome_cliente` VARCHAR(155) NOT NULL,
  `c_email_cliente` VARCHAR(50) NOT NULL,
  `c_cpf_cliente` VARCHAR(14) NOT NULL,
  `c_usuario_cliente` VARCHAR(30) NOT NULL,
  `c_senha_cliente` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`n_id_cliente`),
  UNIQUE INDEX `c_cpf_cliente_UNIQUE` (`c_cpf_cliente` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_barbearia`.`tbl_agendamento` (
  `n_id_agendamento` INT NOT NULL AUTO_INCREMENT,
  `d_data_agendamento` DATE NOT NULL,
  `d_hora_agendamento` TIME NOT NULL,
  `f_total_agendamento` FLOAT (5,2) NOT NULL,
  `n_id_funcionario` INT  NOT NULL,
  `n_id_cliente` INT NOT NULL,
  `n_id_servico` INT NOT NULL,
  PRIMARY KEY (`n_id_agendamento`),
  INDEX `fk_tbl_agendamento_tbl_funcionario_idx` (`n_id_funcionario` ASC) ,
  INDEX `fk_tbl_agendamento_tbl_cliente1_idx` (`n_id_cliente` ASC) ,
  CONSTRAINT `fk_tbl_agendamento_tbl_funcionario`
    FOREIGN KEY (`n_id_funcionario`)
    REFERENCES `db_barbearia`.`tbl_funcionario` (`n_id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_agendamento_tbl_cliente1`
    FOREIGN KEY (`n_id_cliente`)
    REFERENCES `db_barbearia`.`tbl_cliente` (`n_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
	FOREIGN KEY(`n_id_servico`) 
    REFERENCES `db_barbearia`.`tbl_servico`(`n_id_servico`)
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_barbearia`.`tbl_servico` (
  `n_id_servico` INT AUTO_INCREMENT,
  `c_nome_servico` VARCHAR(45) NOT NULL,
  `c_desc_servico` VARCHAR(100) NOT NULL,
  `f_preco_servico` FLOAT(5,2) NOT NULL,
  PRIMARY KEY (`n_id_servico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_barbearia`.`tbl_servico_utilizados`
-- -----------------------------------------------------


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;





INSERT INTO `db_barbearia`.`tbl_cliente` 
(`c_nome_cliente`, `c_email_cliente`, `c_cpf_cliente`, `c_usuario_cliente`, `c_senha_cliente`)
VALUES 
('João Silva', 'joao.silva@example.com', '12345678901', 'joao123', 'senha123'),
('Maria Santos', 'maria.santos@example.com', '98765432109', 'maria456', '456senha'),
('Pedro Oliveira', 'pedro.oliveira@example.com', '56789012345', 'pedro789', 'oliveira789');






INSERT INTO `db_barbearia`.`tbl_categoria_fun` (`c_nome_categoriafun`) VALUES
('Barbeiro'),
('Cabeleireiro'),
('Esteticista'),
('Manicure'),
('Depiladora');

INSERT INTO `db_barbearia`.`tbl_servico` (`n_id_servico`, `c_nome_servico`, `c_desc_servico`, `f_preco_servico`)
VALUES
(1, 'Corte de Cabelo Masculino', 'Corte de cabelo tradicional para homens', 30.00),
(2, 'Corte de Cabelo Feminino', 'Corte de cabelo moderno para mulheres', 50.00),
(3, 'Barba', 'Serviço de barbearia para cuidar da barba', 25.00),
(4, 'Coloração de Cabelo', 'Técnica de coloração para mudar a cor do cabelo', 80.00),
(5, 'Design de Sobrancelhas', 'Modelagem de sobrancelhas para realçar o olhar', 20.00),
(6, 'Manicure Simples', 'Cuidados básicos para as unhas', 15.00),
(7, 'Manicure Completa', 'Cuidados avançados para as unhas', 30.00),
(8, 'Pedicure Simples', 'Cuidados básicos para os pés', 20.00),
(9, 'Pedicure Completa', 'Cuidados avançados para os pés', 40.00),
(10, 'Limpeza de Pele', 'Tratamento facial para limpar a pele', 60.00),
(11, 'Massagem Relaxante', 'Massagem para relaxamento do corpo', 70.00),
(12, 'Depilação com Cera', 'Remoção de pelos com cera', 40.00),
(13, 'Depilação com Linha', 'Remoção de pelos com linha', 50.00),
(14, 'Depilação a Laser', 'Remoção permanente de pelos com laser', 150.00),
(15, 'Corte Infantil', 'Corte de cabelo para crianças', 25.00),
(16, 'Penteado para Eventos', 'Penteado sofisticado para ocasiões especiais', 60.00),
(17, 'Escova Progressiva', 'Tratamento capilar para alisamento dos fios', 120.00),
(18, 'Maquiagem', 'Maquiagem profissional para ocasiões especiais', 80.00),
(19, 'Unhas em Gel', 'Aplicação de unhas de gel', 70.00),
(20, 'Alongamento de Cílios', 'Aplicação de cílios postiços', 90.00);


INSERT INTO `db_barbearia`.`tbl_funcionario` (`c_nome_funcionario`, `c_email_funcionario`, `c_cpf_funcionario`, `c_senha_funcionario`, `f_salario_funcionario`, `n_id_categoriafun`) VALUES
('João Silva', 'joao.silva@ademircortes.com.br', '123.456.789-00', 'senha123', 2500.00, 1),
('Maria Souza', 'maria.souza@ademircortes.com.br', '987.654.321-00', 'senha456', 2800.00, 2),
('Pedro Santos', 'pedro.santos@ademircortes.com.br', '111.222.333-00', 'senha789', 2200.00, 1),
('Ana Oliveira', 'ana.oliveira@ademircortes.com.br', '444.555.666-00', 'senhaabc', 2600.00, 3),
('Luiz Costa', 'luiz.costa@ademircortes.com.br', '777.888.999-00', 'senhadef', 2400.00, 2),
('Carla Rodrigues', 'carla.rodrigues@ademircortes.com.br', '222.333.444-00', 'senha123', 2700.00, 1),
('Mariana Almeida', 'mariana.almeida@ademircortes.com.br', '555.666.777-00', 'senha456', 2900.00, 2),
('Ricardo Nunes', 'ricardo.nunes@ademircortes.com.br', '999.888.777-00', 'senha789', 2300.00, 1),
('Fernanda Lima', 'fernanda.lima@ademircortes.com.br', '666.555.444-00', 'senhaabc', 2500.00, 3),
('Gabriel Castro', 'gabriel.castro@ademircortes.com.br', '111.222.333-00', 'senhadef', 2700.00, 2);

