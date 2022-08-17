package ViewFarmacia;

import Conexao.Conector;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class FarmaciaUi extends JFrame {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textTelefone;
	private Conector conector = new Conector();
	private JTextField textNomeProduto;
	private JTextField textValorProduto;
	private JTextField textTipoProduto;
	private JTextField textQtdProduto;
	private JTextField textAlterarNome;
	private JTextField textID;
	private JTextField textAlterarEndereco;
	private JTextField textAlterarTelefone;
	private JTextField textAlterarValorProduto;
	private JTextField textAlterarQtdProduto;
	private JTextField textAlterarIdProduto;
	private JTextField textIdClienteVenda;
	private JTextField textIdProdutoVenda;
	private JTextField textQtdVenda;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmaciaUi frame = new FarmaciaUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FarmaciaUi() {
		setTitle("Desafio IBM by Gama Academy T1-G3");
		conector.conectar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 394);
		getContentPane().setLayout(null);
		tabbedPane.setToolTipText("Clientes");
		tabbedPane.setBounds(0, 0, 648, 355);
		getContentPane().add(tabbedPane);

		JPanel panelClientes = new JPanel();
		panelClientes.setToolTipText("Clientes");
		tabbedPane.addTab("Clientes", null, panelClientes, null);
		panelClientes.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: *");
		lblNewLabel.setBounds(10, 52, 45, 24);
		panelClientes.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setBounds(47, 74, 267, 20);
		panelClientes.add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço: *");
		lblNewLabel_1.setBounds(10, 124, 72, 14);
		panelClientes.add(lblNewLabel_1);

		textEndereco = new JTextField();
		textEndereco.setBounds(47, 149, 267, 20);
		panelClientes.add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone: *");
		lblNewLabel_2.setBounds(10, 185, 71, 14);
		panelClientes.add(lblNewLabel_2);

		textTelefone = new JTextField();
		textTelefone.setBounds(47, 210, 152, 20);
		panelClientes.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNome.getText().isEmpty() && !textEndereco.getText().isEmpty()
						&& !textTelefone.getText().isEmpty()) {

					conector.inserirCliente(textNome.getText(), textEndereco.getText(), textTelefone.getText());
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
				} else {
					// System.out.println("Todos os campos sï¿½o obrigatï¿½rios");
					JOptionPane.showMessageDialog(null, " Todos os campos são obrigatórios ");
				}
			}
		});
		btnNewButton.setBounds(47, 277, 105, 23);
		panelClientes.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Listar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tModel = new DefaultTableModel();

				tModel.addColumn("ID");
				tModel.addColumn("Nome");
				tModel.addColumn("Endereço");
				tModel.addColumn("Telefone");
				try {
					ResultSet rs = conector.listaClientes();
					while (rs.next()) {

						tModel.addRow(new Object[] { rs.getString("cliente_id"), rs.getString("nome"),
								rs.getString("endereco"), rs.getString("telefone") });

						table.setModel(tModel);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(178, 277, 105, 23);
		panelClientes.add(btnNewButton_2);

		JLabel lblNewLabel_7_1 = new JLabel("Campos obrigatórios (*)");
		lblNewLabel_7_1.setBounds(10, 11, 166, 14);
		panelClientes.add(lblNewLabel_7_1);

		JList list = new JList();
		list.setBounds(639, 126, -180, -121);
		panelClientes.add(list);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(324, 0, 319, 327);
		panelClientes.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		JPanel panelAlterarCliente = new JPanel();
		tabbedPane.addTab("Alterar Cliente", null, panelAlterarCliente, null);
		panelAlterarCliente.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Campos obrigatórios (*)");
		lblNewLabel_7.setBounds(10, 11, 166, 14);
		panelAlterarCliente.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Nome: ");
		lblNewLabel_8.setBounds(10, 71, 45, 24);
		panelAlterarCliente.add(lblNewLabel_8);

		textAlterarNome = new JTextField();
		textAlterarNome.setColumns(10);
		textAlterarNome.setBounds(35, 106, 267, 20);
		panelAlterarCliente.add(textAlterarNome);

		JLabel lblNewLabel_9 = new JLabel("ID: *");
		lblNewLabel_9.setBounds(10, 46, 46, 14);
		panelAlterarCliente.add(lblNewLabel_9);

		textID = new JTextField();
		textID.setBounds(48, 43, 62, 20);
		panelAlterarCliente.add(textID);
		textID.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Endereço: ");
		lblNewLabel_1_1.setBounds(10, 146, 72, 14);
		panelAlterarCliente.add(lblNewLabel_1_1);

		textAlterarEndereco = new JTextField();
		textAlterarEndereco.setColumns(10);
		textAlterarEndereco.setBounds(35, 173, 267, 20);
		panelAlterarCliente.add(textAlterarEndereco);

		JLabel lblNewLabel_2_1 = new JLabel("Telefone: ");
		lblNewLabel_2_1.setBounds(10, 210, 71, 14);
		panelAlterarCliente.add(lblNewLabel_2_1);

		textAlterarTelefone = new JTextField();
		textAlterarTelefone.setColumns(10);
		textAlterarTelefone.setBounds(35, 235, 152, 20);
		panelAlterarCliente.add(textAlterarTelefone);

		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textID.getText().isEmpty()) {
					// System.out.println("Campo de ID nao pode ficar em Branco!");
					JOptionPane.showMessageDialog(null, "Campo de ID nao pode ficar em Branco! ");
					return;
				}
				if (!textAlterarNome.getText().isEmpty()) {
					conector.editarNomeCliente(Integer.parseInt(textID.getText()), textAlterarNome.getText());
					JOptionPane.showMessageDialog(null, "Nome alterado com sucesso! ");
				}
				if (!textAlterarEndereco.getText().isEmpty()) {
					conector.editarEnderecoCliente(Integer.parseInt(textID.getText()), textAlterarEndereco.getText());
					JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso! ");

				}
				if (!textAlterarTelefone.getText().isEmpty()) {
					conector.editarTelefoneCliente(Integer.parseInt(textID.getText()), textAlterarTelefone.getText());
					JOptionPane.showMessageDialog(null, "Telefone alterado com sucesso! ");
				}

			}
		});
		btnNewButton_3.setBounds(35, 293, 105, 23);
		panelAlterarCliente.add(btnNewButton_3);

		JButton btnNewButton_7 = new JButton("Pesquisar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Campo de ID nao pode ficar em Branco! ");
					return;
				}
				try {
					ResultSet rs = conector.buscarCliente(Integer.parseInt(textID.getText()));
					if (rs.next()) {
						textAlterarNome.setText(rs.getString("nome"));
						textAlterarEndereco.setText(rs.getString("endereco"));
						textAlterarTelefone.setText(rs.getString("telefone"));

					} else {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setBounds(120, 42, 105, 23);
		panelAlterarCliente.add(btnNewButton_7);

		JPanel panelProdutos = new JPanel();
		panelProdutos.setToolTipText("Produtos");
		tabbedPane.addTab("Produtos", null, panelProdutos, null);
		panelProdutos.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nome  do Produto: *");
		lblNewLabel_3.setBounds(10, 28, 118, 14);
		panelProdutos.add(lblNewLabel_3);

		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(33, 53, 255, 20);
		panelProdutos.add(textNomeProduto);
		textNomeProduto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor R$: *");
		lblNewLabel_4.setBounds(10, 104, 100, 14);
		panelProdutos.add(lblNewLabel_4);

		textValorProduto = new JTextField();
		textValorProduto.setBounds(81, 101, 86, 20);
		panelProdutos.add(textValorProduto);
		textValorProduto.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tipo: *");
		lblNewLabel_5.setBounds(10, 159, 57, 14);
		panelProdutos.add(lblNewLabel_5);

		textTipoProduto = new JTextField();
		textTipoProduto.setBounds(20, 184, 109, 20);
		panelProdutos.add(textTipoProduto);
		textTipoProduto.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Generico");
		rdbtnNewRadioButton.setBounds(154, 183, 118, 23);
		panelProdutos.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_6 = new JLabel("Quantidade: *");
		lblNewLabel_6.setBounds(10, 227, 100, 14);
		panelProdutos.add(lblNewLabel_6);

		textQtdProduto = new JTextField();
		textQtdProduto.setBounds(20, 252, 86, 20);
		panelProdutos.add(textQtdProduto);
		textQtdProduto.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(69, 293, 109, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(rdbtnNewRadioButton.isSelected());
				if (!textNomeProduto.getText().isEmpty() && !textValorProduto.getText().isEmpty()
						&& !textTipoProduto.getText().isEmpty() && !textQtdProduto.getText().isEmpty()) {
					conector.inserirProduto(textNomeProduto.getText(), Double.parseDouble(textValorProduto.getText()),
							textTipoProduto.getText(), rdbtnNewRadioButton.isSelected(),
							Integer.parseInt(textQtdProduto.getText()));
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso! ");
				} else {
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios! ");
				}

			}
		});
		panelProdutos.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("Listar ");
		btnNewButton_4.setBounds(205, 293, 109, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tModel = new DefaultTableModel();

				tModel.addColumn("ID");
				tModel.addColumn("Nome");
				tModel.addColumn("Valor");
				tModel.addColumn("Tipo");
				tModel.addColumn("Generico");
				tModel.addColumn("Quantidade");
				try {
					ResultSet rs = conector.listaProdutos();
					while (rs.next()) {

						tModel.addRow(new Object[] { rs.getString("produto_id"), rs.getString("nome"),
								rs.getString("valor"), rs.getString("flag_tipo"), rs.getString("flag_generico"),
								rs.getString("qtd_disponivel") });

						table_1.setModel(tModel);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelProdutos.add(btnNewButton_4);

		JLabel lblNewLabel_7_1_1 = new JLabel("Campos obrigatórios (*)");
		lblNewLabel_7_1_1.setBounds(10, 3, 166, 14);
		panelProdutos.add(lblNewLabel_7_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(635, 320, -291, -320);
		panelProdutos.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(324, 3, 319, 324);
		panelProdutos.add(scrollPane_2);

		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);

		JPanel panelAlterarProduto = new JPanel();
		tabbedPane.addTab("Alterar Produto", null, panelAlterarProduto, null);
		panelAlterarProduto.setLayout(null);

		JLabel lblNewLabel_7_2 = new JLabel("Campos obrigatórios (*)");
		lblNewLabel_7_2.setBounds(10, 11, 166, 14);
		panelAlterarProduto.add(lblNewLabel_7_2);

		JLabel lblNewLabel_4_1 = new JLabel("Valor R$: ");
		lblNewLabel_4_1.setBounds(10, 80, 100, 14);
		panelAlterarProduto.add(lblNewLabel_4_1);

		textAlterarValorProduto = new JTextField();
		textAlterarValorProduto.setColumns(10);
		textAlterarValorProduto.setBounds(73, 77, 86, 20);
		panelAlterarProduto.add(textAlterarValorProduto);

		JLabel lblNewLabel_6_1 = new JLabel("Quantidade: ");
		lblNewLabel_6_1.setBounds(10, 122, 100, 14);
		panelAlterarProduto.add(lblNewLabel_6_1);

		textAlterarQtdProduto = new JTextField();
		textAlterarQtdProduto.setColumns(10);
		textAlterarQtdProduto.setBounds(90, 119, 86, 20);
		panelAlterarProduto.add(textAlterarQtdProduto);

		JButton btnNewButton_5 = new JButton("Alterar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAlterarIdProduto.getText().isEmpty()) {
					// System.out.println("Id do produto obrigatï¿½rio!");
					JOptionPane.showMessageDialog(null, "Id do produto obrigatório!");
					return;

				}
				if (!textAlterarValorProduto.getText().isEmpty()) {

					conector.editarValorProduto(Integer.parseInt(textAlterarIdProduto.getText()),
							Double.parseDouble(textAlterarValorProduto.getText()));
					JOptionPane.showMessageDialog(null, "Valor do produto alterado com sucesso! ");

				}
				if (!textAlterarQtdProduto.getText().isEmpty()) {
					conector.editarQuantidadeProduto(Integer.parseInt(textAlterarIdProduto.getText()),
							Integer.parseInt(textAlterarQtdProduto.getText()));
					JOptionPane.showMessageDialog(null, "Quantidade do produto alterado com sucesso! ");
				}

			}
		});
		btnNewButton_5.setBounds(247, 293, 109, 23);
		panelAlterarProduto.add(btnNewButton_5);

		JLabel lblNewLabel_10 = new JLabel("ID: *");
		lblNewLabel_10.setBounds(10, 39, 46, 14);
		panelAlterarProduto.add(lblNewLabel_10);

		textAlterarIdProduto = new JTextField();
		textAlterarIdProduto.setBounds(48, 36, 46, 20);
		panelAlterarProduto.add(textAlterarIdProduto);
		textAlterarIdProduto.setColumns(10);

		JButton btnNewButton_8 = new JButton("Pesquisar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAlterarIdProduto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Id do produto obrigatório!");
					return;
				}
				try {
					ResultSet rs = conector.buscarProduto(Integer.parseInt(textAlterarIdProduto.getText()));
					if (rs.next()) {
						textAlterarValorProduto.setText(rs.getString("valor"));
						textAlterarQtdProduto.setText(rs.getString("qtd_disponivel"));

					} else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado!");
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_8.setBounds(102, 35, 100, 23);
		panelAlterarProduto.add(btnNewButton_8);

		JButton btnNewButton_10 = new JButton("Deletar");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textAlterarIdProduto.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Id do produto obrigatório!");
					return;

				}
				try {
					if (conector.buscarValor(Integer.parseInt(textAlterarIdProduto.getText())) != -1) {
						conector.deletaProduto(Integer.parseInt(textAlterarIdProduto.getText()));
						JOptionPane.showMessageDialog(null, "Deletado com sucesso! ");
					}else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_10.setBounds(134, 293, 109, 23);
		panelAlterarProduto.add(btnNewButton_10);

		JPanel panelVendas = new JPanel();
		tabbedPane.addTab("Vendas", null, panelVendas, null);
		panelVendas.setLayout(null);

		JLabel lblNewLabel_7_2_1 = new JLabel("Campos obrigatórios (*)");
		lblNewLabel_7_2_1.setBounds(10, 11, 166, 14);
		panelVendas.add(lblNewLabel_7_2_1);

		textIdClienteVenda = new JTextField();
		textIdClienteVenda.setBounds(104, 46, 86, 20);
		panelVendas.add(textIdClienteVenda);
		textIdClienteVenda.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("ID do cliente: *");
		lblNewLabel_11.setBounds(10, 49, 96, 14);
		panelVendas.add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("ID do produto: *");
		lblNewLabel_11_1.setBounds(10, 77, 96, 14);
		panelVendas.add(lblNewLabel_11_1);

		textIdProdutoVenda = new JTextField();
		textIdProdutoVenda.setColumns(10);
		textIdProdutoVenda.setBounds(104, 74, 86, 20);
		panelVendas.add(textIdProdutoVenda);

		JLabel lblNewLabel_6_2 = new JLabel("Quantidade: *");
		lblNewLabel_6_2.setBounds(10, 119, 100, 14);
		panelVendas.add(lblNewLabel_6_2);

		textQtdVenda = new JTextField();
		textQtdVenda.setColumns(10);
		textQtdVenda.setBounds(104, 116, 86, 20);
		panelVendas.add(textQtdVenda);

		JButton btnNewButton_6 = new JButton("Gerar Venda");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textIdClienteVenda.getText().isEmpty() && !textIdProdutoVenda.getText().isEmpty()
						&& !textQtdVenda.getText().isEmpty()) {
					try {
						if (!conector.clienteExiste(Integer.parseInt(textIdClienteVenda.getText()))) {
							JOptionPane.showMessageDialog(null, "O cliente não existe! ");
							return;
						}

						if (conector.buscarValor(Integer.parseInt(textIdProdutoVenda.getText())) == -1) {
							JOptionPane.showMessageDialog(null, "O produto não existe! ");
							return;
						}

						if (Integer.parseInt(textQtdVenda.getText()) > conector
								.qtdDisponivel(Integer.parseInt(textIdProdutoVenda.getText()))) {
							JOptionPane.showMessageDialog(null, "Quantidade indisponivel! ");
							return;
						}
						conector.inserirVenda(Integer.parseInt(textIdClienteVenda.getText()),
								Integer.parseInt(textIdProdutoVenda.getText()),
								Integer.parseInt(textQtdVenda.getText()));
						JOptionPane.showMessageDialog(null, "Venda feita com sucesso! ");
					} catch (Exception ex) {
						System.out.println("Erro: " + ex.getMessage());
					}

				} else {
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios! ");
				}
			}
		});
		btnNewButton_6.setBounds(10, 293, 109, 23);
		panelVendas.add(btnNewButton_6);

		JButton btnNewButton_6_1 = new JButton("Relatório");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tModel = new DefaultTableModel();

				tModel.addColumn("Venda ID");
				tModel.addColumn("Cliente ID");
				tModel.addColumn("Produtos ID");
				tModel.addColumn("Quantidade");
				tModel.addColumn("Valor Total");

				try {
					ResultSet rs = conector.listaVendas();
					while (rs.next()) {

						tModel.addRow(new Object[] { rs.getString("venda_id"), rs.getString("cliente_id"),
								rs.getString("produto_id"), rs.getString("qtd_vendida"), rs.getString("valor_total") });

						table_2.setModel(tModel);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6_1.setBounds(139, 293, 109, 23);
		panelVendas.add(btnNewButton_6_1);

		JPanel panel = new JPanel();
		panel.setBounds(258, 11, 375, 305);
		panelVendas.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 375, 305);
		panel.add(scrollPane_3);

		table_2 = new JTable();
		scrollPane_3.setViewportView(table_2);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Histórico de Vendas", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(371, 11, 262, 305);
		panel_1.add(scrollPane_4);

		table_3 = new JTable();
		scrollPane_4.setViewportView(table_3);

		JButton btnNewButton_9 = new JButton("Histórico");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tModel = new DefaultTableModel();

				tModel.addColumn("Histórico ID");
				tModel.addColumn("Venda ID");
				tModel.addColumn("Data");

				try {
					ResultSet rs = conector.listaHistorico();
					while (rs.next()) {

						tModel.addRow(new Object[] { rs.getString("historico_id"), rs.getString("venda_id"),
								rs.getString("data") });

						table_3.setModel(tModel);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_9.setBounds(263, 293, 89, 23);
		panel_1.add(btnNewButton_9);
	}
}
