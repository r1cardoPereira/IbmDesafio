<h1 align="center">Desafio If Black, Then Code <br> T1 Grupo 3</h1>
<p align="center"><i><br>Repositório e documentação do projeto para a criação do CRUD<br></i></p>

Esse Repositório é usado como base para mostrar o funcionamento do CRUD e a criação do banco de dados. O mesmo tem o objetivo em realizar alguns métodos como: listar, incluir, excluir e alterar. Tais métodos foram desenvolvidos por participantes do projeto If Black, Then Code! da Gama Academy e da IBM.<br>
 
### Tecnologias
<p display="inline-block">
  <img width="80" src="https://cdn-icons-png.flaticon.com/512/226/226777.png"/>
</p>
                                                                                                  
### Ferramentas utilizadas para o desenvolvimento
<p display="inline-block">
 <img width="100" src="https://hospedagem10.com.br/wp-content/uploads/2022/04/mysql-logo-600x409.png"/>
  <img width="70" src="https://user-images.githubusercontent.com/11943860/46922575-7017cf80-cfe1-11e8-845a-0cd198fb546c.png"/>
</p>


## Como executar?

1. Clonar o repositório:
```sh
git clone https://github.com/r1cardoPereira/IbmDesafio.git
```
## Banco de dados

O banco de dados utilizado é um MySQL. Execute o comando a seguir para criar as tabelas:

1. Rodar Script para ciração de tabelas no MySQL Workbench:
```create table cliente(
	cliente_id int not null primary key auto_increment,
    nome varchar(30) not null,
    endereco varchar(30) not null,
    telefone varchar(11) not null
);

CREATE TABLE `produto` (
	`produto_id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(30) NOT NULL,
	`valor` float NOT NULL,
	`flag_tipo` varchar(20) NOT NULL,
	`flag_generico` BOOLEAN NOT NULL,
    `qtd_disponivel` int not null,
	PRIMARY KEY (`produto_id`)
);

CREATE TABLE `venda` (
	`venda_id` INT NOT NULL AUTO_INCREMENT,
	`cliente_id` INT NOT NULL,
	`produto_id` INT NOT NULL,
	`qtd_vendida` INT NOT NULL,
	`valor_total` float,
	PRIMARY KEY (`venda_id`)
);
ALTER TABLE `venda` ADD CONSTRAINT `venda_fk0` FOREIGN KEY (`cliente_id`) REFERENCES `cliente`(`cliente_id`);
ALTER TABLE `venda` ADD CONSTRAINT `venda_fk1` FOREIGN KEY (`produto_id`) REFERENCES `produto`(`produto_id`);

create table historico(
	historico_id int not null primary key auto_increment,
    venda_id int not null,
    data date,
    foreign key (venda_id) references venda(venda_id)
);

DELIMITER $$
create trigger trg_venda_insert after insert on venda
for each row
begin
		insert into historico() values(null,NEW.venda_id,curdate());
        update produto set qtd_disponivel = qtd_disponivel - NEW.qtd_vendida where produto_id = NEW.produto_id;
end$$

