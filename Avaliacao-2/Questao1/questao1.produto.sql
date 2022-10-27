CREATE SCHEMA questao1;
CREATE TABLE questao1.produto (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50),
  descricao VARCHAR(100),
  quantidade INT,
  preco DECIMAL(10,2),
  PRIMARY KEY (id));