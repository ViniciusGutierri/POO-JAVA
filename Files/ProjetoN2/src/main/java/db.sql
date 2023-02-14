create database pizzaria;
use pizzaria;


create table CLIENTE (
	cpf_cli varchar(11) NOT NULL,
	nome varchar(50) NOT NULL,
	celular varchar(13) NOT NULL,
	cep varchar(8) NOT NULL,
	bairro varchar(50) NOT NULL,
	rua varchar(50) NOT NULL,
	numero varchar(4) NOT NULL,
	comp varchar(4) NOT NULL
);

ALTER TABLE CLIENTE ADD CONSTRAINT PK_CLIENTE PRIMARY KEY (cpf_cli);

INSERT INTO CLIENTE VALUES ("12345678900", "Joselindo Pereira", "(11)123456789", "09876543", "Bairro legal", "Rua do bairro", "100", "21");

INSERT INTO CLIENTE VALUES ("09876543211", "Afonso Gomes", "(11)049167455", "08456325", "Pinheiros", "Rua Costa Carvalho", "455", "11");




create table FUNCIONARIO (
	id_func int PRIMARY KEY auto_increment,
	cpf varchar(11) NOT NULL,
	nome varchar(50) NOT NULL,
	cargo varchar(15) NOT NULL,
	celular varchar(13) NOT NULL,
	data_nasc varchar(11) NOT NULL
);

INSERT INTO FUNCIONARIO (cpf, nome, cargo, celular, data_nasc) VALUES ("95461420075", "Cléber Junior", "Garçom", "(11)921230044", "01/02/1998");

INSERT INTO FUNCIONARIO (cpf, nome, cargo, celular, data_nasc) VALUES ("47415935741", "Ferdinando de Souza", "Recepcionista", "(11)975359522", "15/06/2001");




create table PIZZA (
	id_pizza int PRIMARY KEY auto_increment,
	sabor varchar(30) NOT NULL,
	descricao varchar(150) NOT NULL,
	tamanho varchar(1) NOT NULL,
	valor DECIMAL(8,2) NOT NULL
);

INSERT INTO PIZZA (sabor, descricao, tamanho, valor) VALUES ("Muçarela", "Molho de tomate, Queijo muçarela, Tomate, Orégano", "G", 40.90);

INSERT INTO PIZZA (sabor, descricao, tamanho, valor) VALUES ("Calabresa", "Molho de tomate, Calabresa, Cebola, Azeitona, Orégano", "M", 35.90);




create table FORNECEDOR (
	id_forn int PRIMARY KEY auto_increment,
	cnpj varchar(14) NOT NULL,
	nome varchar(30) NOT NULL,
	sede varchar(100) NOT NULL,
	produtos varchar(150) NOT NULL
);

INSERT INTO FORNECEDOR (cnpj, nome, sede, produtos) VALUES ("12345678900000", "Sadia", "São Paulo, São Paulo", "Queijo Muçarela");

INSERT INTO FORNECEDOR (cnpj, nome, sede, produtos) VALUES ("00001234567890", "Perdigão", "Videira, Santa Catarina", "Calabresa");




create table PEDIDO (
	id_pedido int PRIMARY KEY auto_increment,
	id_func int not null,
	sabor varchar(30) not null,
	valorUnit DECIMAL(8,2) not null,
	qtde int NOT NULL,
	descricao varchar(100) not null,
	valorTotal DECIMAL(8,2) not null,
	cpf_cli varchar(11) not null,
	cep varchar(8) not null,
	bairro varchar(50) not null,
	rua varchar(50) not null,
	numero varchar(4) not null,
	comp varchar(4) not null
);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_0 FOREIGN KEY (id_func) REFERENCES FUNCIONARIO (id_func);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_1 FOREIGN KEY (cpf_cli) REFERENCES CLIENTE (cpf_cli);



INSERT INTO PEDIDO (id_func, sabor, valorUnit, qtde, descricao, valorTotal, cpf_cli, cep, bairro, rua, numero, comp) VALUES (1, "Muçarela", 40.90, 2, "Molho de tomate, Queijo muçarela, Tomate, Orégano", 81.80, "12345678900", "09876543", "Bairro legal", "Rua do bairro", "100", "21");

INSERT INTO PEDIDO (id_func, sabor, valorUnit, qtde, descricao, valorTotal, cpf_cli, cep, bairro, rua, numero, comp) VALUES (2, "Calabresa", 35.90, 1, "Molho de tomate, Calabresa, Cebola, Azeitona, Orégano", 35.90, "09876543211", "08456325", "Pinheiros", "Rua Costa Carvalho", "455", "11");