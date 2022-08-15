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

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(10, 11, 45, 24);
		panelClientes.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setBounds(47, 39, 267, 20);
		panelClientes.add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o: ");
		lblNewLabel_1.setBounds(10, 95, 72, 14);
		panelClientes.add(lblNewLabel_1);

		textEndereco = new JTextField();
		textEndereco.setBounds(47, 120, 267, 20);
		panelClientes.add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone: ");
		lblNewLabel_2.setBounds(10, 159, 71, 14);
		panelClientes.add(lblNewLabel_2);

		textTelefone = new JTextField();
		textTelefone.setBounds(47, 193, 152, 20);
		panelClientes.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				conector.inserirCliente(textNome.getText(), textEndereco.getText(), textTelefone.getText());
			}
		});
		btnNewButton.setBounds(47, 277, 105, 23);
		panelClientes.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Produtos");
		tabbedPane.addTab("Produtos", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nome  do Produto: ");
		lblNewLabel_3.setBounds(10, 21, 118, 14);
		panel_1.add(lblNewLabel_3);
		
		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(20, 45, 341, 20);
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
				//System.out.println(rdbtnNewRadioButton.isSelected());
				conector.inserirProduto(textNomeProduto.getText(), Double.parseDouble(textValorProduto.getText()),textTipoProduto.getText(),rdbtnNewRadioButton.isSelected(),Integer.parseInt(textQtdProduto.getText()));
			}
		});
		btnNewButton_1.setBounds(69, 293, 109, 23);
		panel_1.add(btnNewButton_1);
	}
}
