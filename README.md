<h1 align="center">Desafio If Black, Then Code <br> T1 Grupo 3</h1>
<p align="center"><i><br>Repositório e documentação do projeto para a criação do CRUD<br></i></p>

Esse Repositório é usado como base para mostrar o funcionamento do CRUD e a criação do banco de dados. O mesmo tem o objetivo em realizar alguns métodos como: listar, incluir, excluir e alterar. Tais métodos foram desenvolvidos por participantes do projeto If Black, Then Code! da Gama Academy e da IBM.<br>

## Documentação
```sh
https://github.com/r1cardoPereira/IbmDesafio/wiki
```
 
## Tecnologias
<p display="inline-block">
  <img width="80" src="https://cdn-icons-png.flaticon.com/512/226/226777.png"/>
</p>
                                                                                                  
## Ferramentas utilizadas para o desenvolvimento
<p display="inline-block">
 <img width="100" src="https://hospedagem10.com.br/wp-content/uploads/2022/04/mysql-logo-600x409.png"/>
  <img width="70" src="https://user-images.githubusercontent.com/11943860/46922575-7017cf80-cfe1-11e8-845a-0cd198fb546c.png"/>
</p>




## Como executar?

1. Clonar o repositório:
```sh
git clone https://github.com/r1cardoPereira/IbmDesafio.git
```
## Endpoints
1. Conexão
```sh
public class Conector {

	private Connection connection = null;
	private java.sql.Statement statement;
	private ResultSet resultset = null;

	public void conectar() {

		String servidor = "jdbc:mysql://localhost/desafio";

		String usuario = "root";

		String senha = "root";

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());

		}

	}
```
## Cliente
2. Listando Cliente
```sh
public ResultSet listaClientes() throws SQLException {
	}

```
2.1. Buscando Cliente
```sh
public ResultSet buscarCliente(int id) throws SQLException {
	}
```

2.2. Inserindo Cliente
```sh
public void inserirCliente(String nome, String endereco, String telefone) {
	}
```

2.3. Editando Nome Cliente
```sh
public void editarNomeCliente(int id, String nome) {
	}
```

2.4. Editando Endereço Cliente
```sh
public void editarEnderecoCliente(int id, String endereco) {
	}
```

2.5. Editando Telefone Cliente
```sh
public void editarTelefoneCliente(int id, String telefone) {
	}
```

2.6.  Verificar se o cliente existe
```sh
public boolean clienteExiste(int clienteId) throws SQLException {
	}
```



## Produto

3.. Incluir Produto
```sh
public void inserirProduto(String nome, Double valor, String flagTipo, Boolean flagGenerico, int qtd) {
	}
```
3.1. Incluir Produto
```sh
public void inserirProduto(String nome, Double valor, String flagTipo, Boolean flagGenerico, int qtd) {
	}
```
3.2. Excluir Produto
```sh
public void deletaProduto(int id) {
	}
```
3.3. Listar Produto
```sh
public ResultSet listaProdutos() throws SQLException {
	}
```
3.4. Buscar Produto
```sh
public ResultSet buscarProduto(int id) throws SQLException {
	}
```
3.5. Editar Valor Produto
```sh
public void editarValorProduto(int id, double valor) {
	}

```

3.6. Editar Tipo Produto
```sh
public void editarTipoProduto(int id, String meuFlagTipo) {
	}

```
3.7. Editar Generico Produto
```sh
public void editarGenericoProduto(int id, String meuFlagGenerico) {
	}

```
3.8. Editar Quantidade Produto
```sh
public void editarQuantidadeProduto(int id, int meuQtd) {
	}

```
3.9. Buscar Valor Produto
```sh
public float buscarValor(int produtoId) throws Exception {
	}

```

## Venda
4. Inserir Venda
```sh
public void inserirVenda(int clienteId, int produtoId, int qtdVendida) throws Exception {
	}

```

4.1. Listar Venda
```sh
public ResultSet listaVendas() throws SQLException {
	}

```

## Histório
4. Listar Histórico
```sh
public ResultSet listaHistorico() throws SQLException {
     }

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


