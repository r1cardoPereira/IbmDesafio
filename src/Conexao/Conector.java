package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Conector {

	private Connection connection = null;
	private java.sql.Statement statement;
	private ResultSet resultset = null;

	public void conectar() {

		String servidor = "jdbc:mysql://localhost/desafio";

		String usuario = "root";

		String senha = "mysql";

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());

		}

	}

	public ResultSet listaClientes() throws SQLException {

	

			String query = "Select * from cliente";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			return this.resultset;
			
	}

	public ResultSet buscarCliente(int id) throws SQLException {
		String query = "select * from cliente where cliente_id=" + id + ";";
		this.resultset = this.statement.executeQuery(query);
		this.statement = this.connection.createStatement();
		return this.resultset;
	}

	public void inserirCliente(String nome, String endereco, String telefone) {
		try {

			String query = "insert into cliente() values(null,'" + nome + "','" + endereco + "','" + telefone + "');";
			this.statement.executeUpdate(query);
			// System.out.println("Cliente cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	public void editarNomeCliente(int id, String nome) {

		try {

			String query = "update cliente set nome='" + nome + "'where cliente_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Nome alterado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarEnderecoCliente(int id, String endereco) {

		try {

			if (clienteExiste(id)) {
				String query = "update cliente set endereco='" + endereco + "'where cliente_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Endereco alterado com sucesso!");
			} else {
				System.out.println("Cliente não existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarTelefoneCliente(int id, String telefone) {

		try {
			if (clienteExiste(id)) {
				String query = "update cliente set telefone='" + telefone + "'where cliente_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Telefone alterado com sucesso!");
			} else {
				System.out.println("Cliente não existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void deletaCliente(int clienteId) {
		try {
			if (clienteExiste(clienteId)) {
				String query = "delete from cliente where cliente_id=" + clienteId + ";";
				this.statement.executeUpdate(query);
				System.out.println("Cliente deletado com sucesso!");
			} else {
				System.out.println("Cliente não existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void inserirProduto(String nome, Double valor, String flagTipo, Boolean flagGenerico, int qtd) {
		try {

			String query = "insert into produto() values(null,'" + nome + "'," + valor + ",'" + flagTipo + "',"
					+ flagGenerico + "," + qtd + ");";

			this.statement.executeUpdate(query);
			System.out.println("Produto cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	public void deletaProduto(int id) {

		try {
			if (buscarValor(id) != -1) {
				String query = "delete from produto where produto_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Produto deletado com sucesso!");
			} else {
				System.out.println("Produto nao existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ResultSet listaProdutos() throws SQLException {

		//try {

			String query = "Select * from produto";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			return this.resultset;

			/*while (this.resultset.next()) {
				String meuID = resultset.getString("produto_id");
				String meuNome = resultset.getString("nome");
				String meuValor = resultset.getString("valor");
				String meuFlagTipo = resultset.getString("flag_tipo");
				String meuFlagGenerico = resultset.getString("flag_generico");
				String meuQtd = resultset.getString("qtd_disponivel");

				System.out.println("Id: " + meuID);
				System.out.println("Nome: " + meuNome);
				System.out.println("Valor: " + meuValor);
				System.out.println("Tipo: " + meuFlagTipo);
				System.out.println("Generico: " + meuFlagGenerico);
				System.out.println("Quantidade: " + meuQtd);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());

		}*/
	}

	public ResultSet buscarProduto(int id) throws SQLException {
		String query = "select * from produto where produto_id=" + id + ";";
		this.resultset = this.statement.executeQuery(query);
		this.statement = this.connection.createStatement();
		return this.resultset;
	}

	public void editarValorProduto(int id, double valor) {

		try {
			if (buscarValor(id) != -1) {
				String query = "update produto set valor='" + valor + "'where produto_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Valor do produto alterado!");
			} else {
				System.out.println("Produto nao existe");

			}

		} catch (

		Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarTipoProduto(int id, String meuFlagTipo) {

		try {
			if (buscarValor(id) != -1) {
				String query = "update produto set meuFlagTipo='" + meuFlagTipo + "'where produto_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Tipo do produto alterado!");
			} else {
				System.out.println("Produto nao existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarGenericoProduto(int id, String meuFlagGenerico) {

		try {
			if (buscarValor(id) != -1) {
				String query = "update produto set meuFlagGenerico='" + meuFlagGenerico + "'where produto_id=" + id
						+ ";";
				this.statement.executeUpdate(query);
				System.out.println("Tipo Generico do produto alterado!");
			} else {
				System.out.println("Produto nao existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarQuantidadeProduto(int id, int meuQtd) {

		try {
			if (buscarValor(id) != -1) {
				String query = "update produto set qtd_disponivel=" + meuQtd + " where produto_id=" + id + ";";
				this.statement.executeUpdate(query);
				System.out.println("Quantidade do produto alterado!");
			} else {
				System.out.println("Produto nao existe");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void inserirVenda(int clienteId, int produtoId, int qtdVendida) throws Exception {
		float valorProduto = buscarValor(produtoId);
		if (valorProduto != -1) {
			float valorTotal = qtdVendida * buscarValor(produtoId);
			String query = "insert into venda() values(null," + clienteId + "," + produtoId + "," + qtdVendida + ","
					+ valorTotal + ");";
			this.statement.executeUpdate(query);
			System.out.println("Venda feita com sucesso!");
		} else {
			System.out.println("O produto nao existe");
		}

	}

	public float buscarValor(int produtoId) throws Exception {

		String queryProdutoValor = "select valor from produto where produto_id=" + produtoId + ";";
		this.resultset = this.statement.executeQuery(queryProdutoValor);
		this.statement = this.connection.createStatement();

		if (resultset.next()) {
			return Float.parseFloat(resultset.getString("valor"));
		} else {
			return -1;
		}

	}

	public boolean clienteExiste(int clienteId) throws SQLException {
		String query = "select cliente_id from cliente where cliente_id =" + clienteId + ";";
		this.resultset = this.statement.executeQuery(query);
		this.statement = this.connection.createStatement();

		return resultset.next();
	}
}
