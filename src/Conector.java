import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conector {

	private Connection connection = null;
	private java.sql.Statement statement = null;
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

				System.out.println("id " + meuID);
				System.out.println("nome " + meuNome);
				System.out.println("endereco " + meuEndereco);
				System.out.println("telefone " + meuTelefone);

			}

		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());

		}
	}

	public void inserirCliente(String nome, String endereco, String telefone) {
		try {

			String query = "insert into cliente() values(null,'" + nome + "','" + endereco + "','" + telefone + "');";

			System.out.println("Cliente cadastrado com sucesso!");
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	public void editarNomeCliente(int id, String nome) {

		try {

			String query = "update cliente set nome='" + nome + "'where cliente_id=" + id + ";";
			System.out.println("Nome alterado com sucesso!");
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarEnderecoCliente(int id, String endereco) {

		try {

			String query = "update cliente set endereco='" + endereco + "'where cliente_id=" + id + ";";
			System.out.println("Endereco alterado com sucesso!");
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarTelefoneCliente(int id, String telefone) {

		try {

			String query = "update cliente set telefone='" + telefone + "'where cliente_id=" + id + ";";
			System.out.println("Telefone alterado com sucesso!");
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void deletaCliente(int id) {

		try {
			String query = "delete from cliente where cliente_id=" + id + ";";
			System.out.println("Cliente deletado com sucesso!");
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
