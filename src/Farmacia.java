
public class Farmacia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conector conector = new Conector();
		conector.conectar();
		
		//conector.inserirCliente("Ricardo", "Rua Zero", "12345678909");
		//conector.deletaCliente(1);
		conector.listaClientes();
		//conector.editarNomeCliente(2, "Rafael");
		//conector.editarEnderecoCliente(2, "rua sao jose");

	}

}