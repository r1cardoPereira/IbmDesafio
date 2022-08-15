package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public void listaClientes() {

		try {

			String query = "Select * from cliente";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			while (this.resultset.next()) {
				String meuID = resultset.getString("cliente_id");
				String meuNome = resultset.getString("nome");
				String meuEndereco = resultset.getString("endereco");
				String meuTelefone = resultset.getString("telefone");

				System.out.println("Id: " + meuID);
				System.out.println("Nome: " + meuNome);
				System.out.println("Endereco: " + meuEndereco);
				System.out.println("Telefone: " + meuTelefone);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());

		}
	}

	public void inserirCliente(String nome, String endereco, String telefone) {
		try {

			String query = "insert into cliente() values(null,'" + nome + "','" + endereco + "','" + telefone + "');";
			this.statement.executeUpdate(query);
			System.out.println("Cliente cadastrado com sucesso!");
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

			String query = "update cliente set endereco='" + endereco + "'where cliente_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Endereco alterado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarTelefoneCliente(int id, String telefone) {

		try {

			String query = "update cliente set telefone='" + telefone + "'where cliente_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Telefone alterado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void deletaCliente(int id) {

		try {
			String query = "delete from cliente where cliente_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Cliente deletado com sucesso!");
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
			String query = "delete from produto where produto_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Cliente deletado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void listaProdutos() {

		try {

			String query = "Select * from produto";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			while (this.resultset.next()) {
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

		}
	}

	public void editarValorProduto(int id, String valor) {

		try {

			String query = "update produto set valor='" + valor + "'where produto_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Valor do produto alterado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarTipoProduto(int id, String meuFlagTipo) {

		try {

			String query = "update produto set meuFlagTipo='" + meuFlagTipo + "'where produto_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Tipo do produto alterado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarGenericoProduto(int id, String meuFlagGenerico) {

		try {

			String query = "update produto set meuFlagGenerico='" + meuFlagGenerico + "'where produto_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Tipo Generico do produto alterado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarQuantidadeProduto(int id, String meuQtd) {

		try {

			String query = "update produto set meuQtd='" + meuQtd + "'where produto_id=" + id + ";";
			this.statement.executeUpdate(query);
			System.out.println("Quantidade do produto alterado!");
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
}
