package ViewFarmacia;

import Conexao.Conector;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o: *");
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
					// System.out.println("Todos os campos são obrigatórios");
					JOptionPane.showMessageDialog(null, " Todos os campos são obrigatórios ");
				}
			}
		});
		btnNewButton.setBounds(47, 277, 105, 23);
		panelClientes.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Listar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				conector.listaClientes();
			}
		});
		btnNewButton_2.setBounds(178, 277, 105, 23);
		panelClientes.add(btnNewButton_2);

		JLabel lblNewLabel_7_1 = new JLabel("Campos obrigatorios (*)");
		lblNewLabel_7_1.setBounds(10, 11, 166, 14);
		panelClientes.add(lblNewLabel_7_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Alterar Cliente", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Campos obrigatorios (*)");
		lblNewLabel_7.setBounds(10, 11, 166, 14);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Nome: ");
		lblNewLabel_8.setBounds(10, 71, 45, 24);
		panel_2.add(lblNewLabel_8);

		textAlterarNome = new JTextField();
		textAlterarNome.setColumns(10);
		textAlterarNome.setBounds(35, 106, 267, 20);
		panel_2.add(textAlterarNome);

		JLabel lblNewLabel_9 = new JLabel("ID: *");
		lblNewLabel_9.setBounds(10, 46, 46, 14);
		panel_2.add(lblNewLabel_9);

		textID = new JTextField();
		textID.setBounds(48, 43, 62, 20);
		panel_2.add(textID);
		textID.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Endere\u00E7o: ");
		lblNewLabel_1_1.setBounds(10, 146, 72, 14);
		panel_2.add(lblNewLabel_1_1);

		textAlterarEndereco = new JTextField();
		textAlterarEndereco.setColumns(10);
		textAlterarEndereco.setBounds(35, 173, 267, 20);
		panel_2.add(textAlterarEndereco);

		JLabel lblNewLabel_2_1 = new JLabel("Telefone: ");
		lblNewLabel_2_1.setBounds(10, 210, 71, 14);
		panel_2.add(lblNewLabel_2_1);

		textAlterarTelefone = new JTextField();
		textAlterarTelefone.setColumns(10);
		textAlterarTelefone.setBounds(35, 235, 152, 20);
		panel_2.add(textAlterarTelefone);

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
		panel_2.add(btnNewButton_3);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Produtos");
		tabbedPane.addTab("Produtos", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nome  do Produto: ");
		lblNewLabel_3.setBounds(10, 21, 118, 14);
		panel_1.add(lblNewLabel_3);

		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(33, 46, 341, 20);
		panel_1.add(textNomeProduto);
		textNomeProduto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valor R$: ");
		lblNewLabel_4.setBounds(10, 104, 100, 14);
		panel_1.add(lblNewLabel_4);

		textValorProduto = new JTextField();
		textValorProduto.setBounds(81, 101, 86, 20);
		panel_1.add(textValorProduto);
		textValorProduto.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tipo: ");
		lblNewLabel_5.setBounds(10, 159, 57, 14);
		panel_1.add(lblNewLabel_5);

		textTipoProduto = new JTextField();
		textTipoProduto.setBounds(20, 184, 208, 20);
		panel_1.add(textTipoProduto);
		textTipoProduto.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Generico");
		rdbtnNewRadioButton.setBounds(238, 183, 109, 23);
		panel_1.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_6 = new JLabel("Quantidade: ");
		lblNewLabel_6.setBounds(10, 227, 100, 14);
		panel_1.add(lblNewLabel_6);

		textQtdProduto = new JTextField();
		textQtdProduto.setBounds(20, 252, 86, 20);
		panel_1.add(textQtdProduto);
		textQtdProduto.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cadastrar");
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
		btnNewButton_1.setBounds(69, 293, 109, 23);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("Listar ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conector.listaProdutos();
			}
		});
		btnNewButton_4.setBounds(205, 293, 109, 23);
		panel_1.add(btnNewButton_4);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alterar Produto", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_7_2 = new JLabel("Campos obrigat\u00F3rios (*)");
		lblNewLabel_7_2.setBounds(10, 11, 166, 14);
		panel_3.add(lblNewLabel_7_2);

		JLabel lblNewLabel_4_1 = new JLabel("Valor R$: ");
		lblNewLabel_4_1.setBounds(10, 80, 100, 14);
		panel_3.add(lblNewLabel_4_1);

		textAlterarValorProduto = new JTextField();
		textAlterarValorProduto.setColumns(10);
		textAlterarValorProduto.setBounds(73, 77, 86, 20);
		panel_3.add(textAlterarValorProduto);

		JLabel lblNewLabel_6_1 = new JLabel("Quantidade: ");
		lblNewLabel_6_1.setBounds(10, 122, 100, 14);
		panel_3.add(lblNewLabel_6_1);

		textAlterarQtdProduto = new JTextField();
		textAlterarQtdProduto.setColumns(10);
		textAlterarQtdProduto.setBounds(90, 119, 86, 20);
		panel_3.add(textAlterarQtdProduto);

		JButton btnNewButton_5 = new JButton("Alterar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAlterarIdProduto.getText().isEmpty()) {
					// System.out.println("Id do produto obrigatório!");
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
		panel_3.add(btnNewButton_5);

		JLabel lblNewLabel_10 = new JLabel("ID: *");
		lblNewLabel_10.setBounds(10, 39, 46, 14);
		panel_3.add(lblNewLabel_10);

		textAlterarIdProduto = new JTextField();
		textAlterarIdProduto.setBounds(48, 36, 86, 20);
		panel_3.add(textAlterarIdProduto);
		textAlterarIdProduto.setColumns(10);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Vendas", null, panel, null);
	}
}
