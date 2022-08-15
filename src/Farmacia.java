import Conexao.Conector;

public class Farmacia {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Conector conector = new Conector();
		conector.conectar();

		//conector.inserirCliente("Rica44rdo", "Rua Zeasro", "1234567809");
		// conector.deletaCliente(1);
		conector.listaClientes();
		// conector.editarNomeCliente(2, "Rafael");
		// conector.editarEnderecoCliente(2, "rua sao jose");
		// conector.inserirProduto("Abacavir", 20.5, "n sei", true, 10);
		// conector.deletaProduto(4);
		// conector.listaProdutos();
		//conector.inserirVenda(1, 3, 3);
	}

}
