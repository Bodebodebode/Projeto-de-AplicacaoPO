import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.Rectangle;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblDadosDoSacado;
	private JButton btnGerarBoleto;
	private JTextField textField_16;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_2;
	private JTextField textField_13;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;

	/**
	 * Create the panel.
	 */
	public Panel() {
		setFocusCycleRoot(true);

		lblDadosDoSacado = new JLabel("Dados do sacado");
		lblDadosDoSacado.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoSacado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoSacado.setForeground(Color.BLACK);
		lblDadosDoSacado.setBounds(10, 45, 134, 14);
		lblDadosDoSacado.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoSacado.setBackground(UIManager.getColor("Button.darkShadow"));

		btnGerarBoleto = new JButton("Gerar Boleto");
		btnGerarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boleto boleto = null;
				BoletoViewer boletoViewer = new BoletoViewer(boleto);
				boletoViewer.setTemplate("C:\\Users\\FZ\\eclipse-workspace\\Boleto\\src\\templates\\B001_BoletoEstiloFatura.pdf");	
				File arquivoPdf = boletoViewer.getPdfAsFile("B001_BoletoEstiloFaturaGerado.pdf");
				mostreBoletoNaTela(arquivoPdf);
			}

			private void mostreBoletoNaTela(File arquivoBoleto) {

				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				try {
					desktop.open(arquivoBoleto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnGerarBoleto.setBounds(429, 496, 119, 23);
		btnGerarBoleto.setBackground(Color.DARK_GRAY);
		btnGerarBoleto.setForeground(Color.WHITE);
		setLayout(null);
		add(lblDadosDoSacado);
		add(btnGerarBoleto);

		JLabel lblNome = new JLabel("CPF");
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNome.setBounds(10, 90, 46, 14);
		add(lblNome);

		JLabel label = new JLabel("Nome");
		label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label.setBounds(10, 70, 46, 14);
		add(label);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblUf.setBounds(10, 124, 46, 14);
		add(lblUf);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.LIGHT_GRAY);
		lblEndereo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblEndereo.setBounds(10, 110, 64, 14);
		add(lblEndereo);

		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNmero.setBounds(10, 224, 46, 14);
		add(lblNmero);

		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblLocalidade.setBounds(10, 144, 64, 14);
		add(lblLocalidade);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblCep.setBounds(10, 164, 46, 14);
		add(lblCep);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblBairro.setBounds(10, 184, 46, 14);
		add(lblBairro);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			// Verificador de nome; nome não pode conter números, nome deve começar com letra maiúscula (caso não comece, capitalizar automaticamente); espaços disnecessários também serão removidos
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length()==0) {
					textField.setForeground(Color.LIGHT_GRAY);
					textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField.setText("Digite o nome");

				}	else {
					String sem_espacos = textField.getText().replace(" ", "");

					if(!sem_espacos.chars().allMatch(Character::isLetter)) {
						textField.setBackground(Color.RED);
						textField.setForeground(Color.WHITE);
						textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField.setToolTipText("Somente letras podem ser usadas no nome.");
					}	else {
						textField.setBackground(Color.WHITE);
						textField.setForeground(Color.BLACK);
						textField.setText(formatar_textfield_nome(textField.getText()));
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getBackground() == Color.RED) {
					textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField.setBackground(Color.WHITE);
					textField.setForeground(Color.BLACK);
					textField.selectAll();
				}
				if(textField.getText().equals("Digite o nome")) {
					textField.setText("");
					textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField.setBackground(Color.WHITE);
					textField.setForeground(Color.BLACK);
					textField.selectAll();
				}
			}
		});
		textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField.setBounds(76, 70, 86, 20);
		textField.setColumns(10);
		add(textField);

		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().length()==0) {
					textField_1.setForeground(Color.LIGHT_GRAY);
					textField_1.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_1.setText("Digite o CPF");
				}	else {
					String sem_ponto_e_sem_traco = textField_1.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						textField_1.setBackground(Color.RED);
						textField_1.setForeground(Color.WHITE);
						textField_1.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_1.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()!=11){
						textField_1.setBackground(Color.RED);
						textField_1.setForeground(Color.WHITE);
						textField_1.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_1.setToolTipText("Digite um CPF válido");
					}	else{
						textField_1.setBackground(Color.WHITE);
						textField_1.setForeground(Color.BLACK);
						textField_1.setText(formatar_textfield_CPF(textField_1.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_1.getBackground() == Color.RED) {
					textField_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_1.setBackground(Color.WHITE);
					textField_1.setForeground(Color.BLACK);
					textField_1.selectAll();
				}
				if(textField_1.getText().equals("Digite o CPF")) {
					textField_1.setText("");
					textField_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_1.setBackground(Color.WHITE);
					textField_1.setForeground(Color.BLACK);
					textField_1.selectAll();
				}
			}
		});
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(76, 90, 86, 20);
		add(textField_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(76, 124, 86, 20);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(76, 144, 86, 20);
		add(textField_4);

		textField_5 = new JTextField();
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_5.getText().length()==0) {
					textField_5.setForeground(Color.LIGHT_GRAY);
					textField_5.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_5.setText("Digite o CEP");
				}	else {
					String sem_traco = textField_5.getText().replace("-", "");
					if(!StringUtils.isNumeric(sem_traco)) {
						textField_5.setBackground(Color.RED);
						textField_5.setForeground(Color.WHITE);
						textField_5.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_5.setToolTipText("Digite somente números");
					}	else if(sem_traco.length()!=8){
						textField_5.setBackground(Color.RED);
						textField_5.setForeground(Color.WHITE);
						textField_5.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_5.setToolTipText("Digite um CEP válido");
					}	else{
						textField_5.setBackground(Color.WHITE);
						textField_5.setForeground(Color.BLACK);
						textField_5.setText(formatar_textfield_CEP(textField_5.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_5.getBackground() == Color.RED) {
					textField_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_5.setBackground(Color.WHITE);
					textField_5.setForeground(Color.BLACK);
					textField_5.selectAll();
				}
				if(textField_5.getText().equals("Digite o CEP")) {
					textField_5.setText("");
					textField_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_5.setBackground(Color.WHITE);
					textField_5.setForeground(Color.BLACK);
					textField_5.selectAll();
				}
			}
		});
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_5.setColumns(10);
		textField_5.setBounds(76, 164, 86, 20);
		add(textField_5);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_6.setColumns(10);
		textField_6.setBounds(76, 184, 86, 20);
		add(textField_6);

		textField_7 = new JTextField();
		textField_7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_7.getText().length()==0) {
					textField_7.setForeground(Color.LIGHT_GRAY);
					textField_7.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_7.setText("Digite o Número");
				}	else {
					String sem_numero = textField_7.getText().replace("s/n", "0");
					sem_numero = textField_7.getText().replace("sn", "0");
					if(!StringUtils.isNumeric(sem_numero)) {
						textField_7.setBackground(Color.RED);
						textField_7.setForeground(Color.WHITE);
						textField_7.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_7.setToolTipText("Digite somente números");
					}else{
						textField_7.setBackground(Color.WHITE);
						textField_7.setForeground(Color.BLACK);
						textField_7.setText(formatar_textfield_numero(textField_7.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_7.getBackground() == Color.RED) {
					textField_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_7.setBackground(Color.WHITE);
					textField_7.setForeground(Color.BLACK);
					textField_7.selectAll();
				}
				if(textField_7.getText().equals("Digite o Número")) {
					textField_7.setText("");
					textField_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_7.setBackground(Color.WHITE);
					textField_7.setForeground(Color.BLACK);
					textField_7.selectAll();
				}
			}
		});
		textField_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_7.setColumns(10);
		textField_7.setBounds(76, 224, 86, 20);
		add(textField_7);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escolha seu banco");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Bradesco", "Ita\u00FA", "Banco do Brasil", "HSBC", "Caixa Econ\u00F4mica Federal"}));
		comboBox.setBounds(210, 10, 100, 26);
		add(comboBox);

		JLabel lblEscolhaOBanco = new JLabel("Escolha o Banco:");
		lblEscolhaOBanco.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblEscolhaOBanco.setBounds(100, 15, 110, 16);
		add(lblEscolhaOBanco);

		JLabel lblDadosDoCedente = new JLabel("Dados do cedente");
		lblDadosDoCedente.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoCedente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoCedente.setForeground(Color.BLACK);
		lblDadosDoCedente.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoCedente.setBackground((Color) null);
		lblDadosDoCedente.setBounds(372, 45, 176, 14);
		add(lblDadosDoCedente);

		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa");
		lblNomeDaEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNomeDaEmpresa.setBounds(372, 70, 94, 14);
		add(lblNomeDaEmpresa);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblCnpj.setBounds(372, 90, 46, 14);
		add(lblCnpj);

		textField_8 = new JTextField();
		textField_8.addFocusListener(new FocusAdapter() {
			// Verificador de nome; nome não pode conter números, nome deve começar com letra maiúscula (caso não comece, capitalizar automaticamente); espaços disnecessários também serão removidos
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_8.getText().length()==0) {
					textField_8.setForeground(Color.LIGHT_GRAY);
					textField_8.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_8.setText("Digite o nome");
				}	else {
					String sem_espacos = textField_8.getText().replace(" ", "x");

					if(!sem_espacos.chars().allMatch(Character::isLetter)) {
						textField_8.setBackground(Color.RED);
						textField_8.setForeground(Color.WHITE);
						textField_8.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_8.setToolTipText("Somente letras podem ser usadas no nome.");
					}	else {
						textField_8.setBackground(Color.WHITE);
						textField_8.setForeground(Color.BLACK);
						textField_8.setText(formatar_textfield_nome(textField_8.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_8.getBackground() == Color.RED) {
					textField_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_8.setBackground(Color.WHITE);
					textField_8.setForeground(Color.BLACK);
					textField_8.selectAll();
				}
				if(textField_8.getText().equals("Digite o nome")) {
					textField_8.setText("");
					textField_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_8.setBackground(Color.WHITE);
					textField_8.setForeground(Color.BLACK);
					textField_8.selectAll();
				}
			}
		});
		textField_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_8.setColumns(10);
		textField_8.setBounds(468, 70, 102, 20);
		add(textField_8);

		textField_9 = new JTextField();
		textField_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_9.getText().length()==0) {
					textField_9.setForeground(Color.LIGHT_GRAY);
					textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_9.setText("Digite o CNPJ");
				}	else {
					String sem_ponto_e_sem_traco = textField_9.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("/", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						textField_9.setBackground(Color.RED);
						textField_9.setForeground(Color.WHITE);
						textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_9.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()!=14){
						textField_9.setBackground(Color.RED);
						textField_9.setForeground(Color.WHITE);
						textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_9.setToolTipText("Digite um CNPJ válido");
					}	else{
						textField_9.setBackground(Color.WHITE);
						textField_9.setForeground(Color.BLACK);
						textField_9.setText(formatar_textfield_CNPJ(textField_9.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_9.getBackground() == Color.RED) {
					textField_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_9.setBackground(Color.WHITE);
					textField_9.setForeground(Color.BLACK);
					textField_9.selectAll();
				}
				if(textField_9.getText().equals("Digite o CNPJ")) {
					textField_9.setText("");
					textField_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_9.setBackground(Color.WHITE);
					textField_9.setForeground(Color.BLACK);
					textField_9.selectAll();
				}
			}
		});
		textField_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_9.setColumns(10);
		textField_9.setBounds(468, 90, 102, 20);
		add(textField_9);
		
		JLabel lblDadosDoSacado_1 = new JLabel("Dados do Sacado Avalista");
		lblDadosDoSacado_1.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoSacado_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoSacado_1.setForeground(Color.BLACK);
		lblDadosDoSacado_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoSacado_1.setBackground(SystemColor.controlDkShadow);
		lblDadosDoSacado_1.setBounds(193, 45, 152, 14);
		add(lblDadosDoSacado_1);
		
		JLabel label_8 = new JLabel("Nome");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_8.setBounds(193, 70, 46, 14);
		add(label_8);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_16.setColumns(10);
		textField_16.setBounds(259, 70, 86, 20);
		add(textField_16);
		
		JLabel label_9 = new JLabel("CPF");
		label_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_9.setBounds(193, 90, 46, 14);
		add(label_9);
		
		textField_23 = new JTextField();
		textField_23.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_23.setColumns(10);
		textField_23.setBounds(259, 90, 86, 20);
		add(textField_23);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblLogradouro.setBounds(10, 204, 64, 14);
		add(lblLogradouro);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_24.setColumns(10);
		textField_24.setBounds(76, 204, 86, 20);
		add(textField_24);
		
		JLabel lblDadosDaConta = new JLabel("Dados da Conta Banc\u00E1ria");
		lblDadosDaConta.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDaConta.setForeground(Color.BLACK);
		lblDadosDaConta.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDaConta.setBackground(SystemColor.controlDkShadow);
		lblDadosDaConta.setBounds(372, 118, 176, 14);
		add(lblDadosDaConta);
		
		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblBanco.setBounds(372, 140, 46, 14);
		add(lblBanco);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_10.setColumns(10);
		textField_10.setBounds(462, 138, 108, 20);
		add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_11.setColumns(10);
		textField_11.setBounds(462, 158, 108, 20);
		add(textField_11);
		
		JLabel lblNmeroDaConta = new JLabel("N\u00FAmero da Conta");
		lblNmeroDaConta.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNmeroDaConta.setBounds(372, 160, 86, 14);
		add(lblNmeroDaConta);
		
		JLabel lblTipoDeCarteira = new JLabel("Tipo de Carteira");
		lblTipoDeCarteira.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblTipoDeCarteira.setBounds(372, 180, 86, 14);
		add(lblTipoDeCarteira);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_12.setColumns(10);
		textField_12.setBounds(462, 178, 108, 20);
		add(textField_12);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNome_1.setBounds(372, 206, 64, 14);
		add(lblNome_1);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_14.setColumns(10);
		textField_14.setBounds(462, 204, 108, 20);
		add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_15.setColumns(10);
		textField_15.setBounds(462, 224, 108, 20);
		add(textField_15);
		
		JLabel lblNmero_1 = new JLabel("N\u00FAmero");
		lblNmero_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNmero_1.setBounds(372, 226, 46, 14);
		add(lblNmero_1);
		
		JLabel lblDadosDaAgncia = new JLabel("Dados da Ag\u00EAncia");
		lblDadosDaAgncia.setForeground(Color.LIGHT_GRAY);
		lblDadosDaAgncia.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDadosDaAgncia.setBounds(372, 194, 94, 14);
		add(lblDadosDaAgncia);
		
		JLabel label_1 = new JLabel("Endere\u00E7o");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_1.setBounds(193, 110, 64, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("UF");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_2.setBounds(193, 124, 46, 14);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(259, 124, 86, 20);
		add(textField_2);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_13.setColumns(10);
		textField_13.setBounds(259, 144, 86, 20);
		add(textField_13);
		
		JLabel label_3 = new JLabel("Localidade");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_3.setBounds(193, 144, 64, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("CEP");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_4.setBounds(193, 164, 46, 14);
		add(label_4);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_17.setColumns(10);
		textField_17.setBounds(259, 164, 86, 20);
		add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_18.setColumns(10);
		textField_18.setBounds(259, 184, 86, 20);
		add(textField_18);
		
		JLabel label_5 = new JLabel("Bairro");
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_5.setBounds(193, 184, 46, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Logradouro");
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_6.setBounds(193, 204, 64, 14);
		add(label_6);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_19.setColumns(10);
		textField_19.setBounds(259, 204, 86, 20);
		add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_20.setColumns(10);
		textField_20.setBounds(259, 224, 86, 20);
		add(textField_20);
		
		JLabel label_7 = new JLabel("N\u00FAmero");
		label_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_7.setBounds(193, 224, 46, 14);
		add(label_7);
		
		JLabel lblDadosDoTtulo = new JLabel("Dados do T\u00EDtulo");
		lblDadosDoTtulo.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoTtulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoTtulo.setForeground(Color.BLACK);
		lblDadosDoTtulo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoTtulo.setBackground(SystemColor.controlDkShadow);
		lblDadosDoTtulo.setBounds(10, 255, 200, 14);
		add(lblDadosDoTtulo);
		
		JLabel lblNmeroDoDocumento = new JLabel("N\u00FAmero do Documento");
		lblNmeroDoDocumento.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNmeroDoDocumento.setBounds(10, 280, 110, 14);
		add(lblNmeroDoDocumento);
		
		JLabel lblNossoNmero = new JLabel("Nosso N\u00FAmero");
		lblNossoNmero.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNossoNmero.setBounds(10, 300, 110, 14);
		add(lblNossoNmero);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_21.setColumns(10);
		textField_21.setBounds(128, 280, 86, 20);
		add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_22.setColumns(10);
		textField_22.setBounds(128, 300, 86, 20);
		add(textField_22);
		
		JLabel lblDigitoDoNosso = new JLabel("Digito do Nosso N\u00FAmero");
		lblDigitoDoNosso.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDigitoDoNosso.setBounds(10, 320, 119, 14);
		add(lblDigitoDoNosso);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblValor.setBounds(10, 340, 110, 14);
		add(lblValor);
		
		JLabel lblDataDoDocumento = new JLabel("Data do Documento");
		lblDataDoDocumento.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDataDoDocumento.setBounds(10, 360, 110, 14);
		add(lblDataDoDocumento);
		
		JLabel lblDataDoVencimento = new JLabel("Data do Vencimento");
		lblDataDoVencimento.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDataDoVencimento.setBounds(10, 380, 110, 14);
		add(lblDataDoVencimento);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
		lblTipoDeDocumento.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblTipoDeDocumento.setBounds(10, 400, 110, 14);
		add(lblTipoDeDocumento);
		
		JLabel lblAceite = new JLabel("Aceite");
		lblAceite.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblAceite.setBounds(10, 420, 46, 14);
		add(lblAceite);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_25.setColumns(10);
		textField_25.setBounds(128, 420, 86, 20);
		add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_26.setColumns(10);
		textField_26.setBounds(128, 400, 86, 20);
		add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_27.setColumns(10);
		textField_27.setBounds(128, 380, 86, 20);
		add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_28.setColumns(10);
		textField_28.setBounds(128, 360, 86, 20);
		add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_29.setColumns(10);
		textField_29.setBounds(128, 340, 86, 20);
		add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_30.setColumns(10);
		textField_30.setBounds(128, 320, 86, 20);
		add(textField_30);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDesconto.setBounds(10, 440, 64, 14);
		add(lblDesconto);
		
		textField_31 = new JTextField();
		textField_31.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_31.setColumns(10);
		textField_31.setBounds(128, 440, 86, 20);
		add(textField_31);
		
		JLabel lblDeduo = new JLabel("Dedu\u00E7\u00E3o");
		lblDeduo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDeduo.setBounds(10, 460, 46, 14);
		add(lblDeduo);
		
		textField_32 = new JTextField();
		textField_32.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_32.setColumns(10);
		textField_32.setBounds(128, 460, 86, 20);
		add(textField_32);
		
		JLabel lblMora = new JLabel("Mora");
		lblMora.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblMora.setBounds(10, 480, 46, 14);
		add(lblMora);
		
		textField_33 = new JTextField();
		textField_33.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_33.setColumns(10);
		textField_33.setBounds(128, 480, 86, 20);
		add(textField_33);
		
		JLabel lblAcrscimo = new JLabel("Acr\u00E9scimo");
		lblAcrscimo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblAcrscimo.setBounds(10, 500, 64, 14);
		add(lblAcrscimo);
		
		textField_34 = new JTextField();
		textField_34.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_34.setColumns(10);
		textField_34.setBounds(128, 500, 86, 20);
		add(textField_34);
		
		JLabel lblValorCobrado = new JLabel("Valor Cobrado");
		lblValorCobrado.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblValorCobrado.setBounds(10, 520, 110, 14);
		add(lblValorCobrado);
		
		textField_35 = new JTextField();
		textField_35.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_35.setColumns(10);
		textField_35.setBounds(128, 520, 86, 20);
		add(textField_35);
		
		JLabel lblDadosDoBoleto = new JLabel("Dados do Boleto");
		lblDadosDoBoleto.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoBoleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoBoleto.setForeground(Color.BLACK);
		lblDadosDoBoleto.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoBoleto.setBackground(SystemColor.controlDkShadow);
		lblDadosDoBoleto.setBounds(236, 255, 200, 14);
		add(lblDadosDoBoleto);
		
		JLabel lblLocalPagamento = new JLabel("Local Pagamento");
		lblLocalPagamento.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblLocalPagamento.setBounds(236, 280, 110, 14);
		add(lblLocalPagamento);
		
		textField_36 = new JTextField();
		textField_36.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_36.setColumns(10);
		textField_36.setBounds(350, 280, 220, 20);
		add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_37.setColumns(10);
		textField_37.setBounds(350, 300, 220, 20);
		add(textField_37);
		
		JLabel lblInstruoAoSacado = new JLabel("Instru\u00E7\u00E3o ao Sacado");
		lblInstruoAoSacado.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruoAoSacado.setBounds(236, 300, 110, 14);
		add(lblInstruoAoSacado);
		
		JLabel lblInstruo = new JLabel("Instru\u00E7\u00E3o 1");
		lblInstruo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo.setBounds(236, 320, 119, 14);
		add(lblInstruo);
		
		textField_38 = new JTextField();
		textField_38.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_38.setColumns(10);
		textField_38.setBounds(350, 320, 220, 20);
		add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_39.setColumns(10);
		textField_39.setBounds(350, 340, 220, 20);
		add(textField_39);
		
		JLabel lblInstruo_1 = new JLabel("Instru\u00E7\u00E3o 2");
		lblInstruo_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_1.setBounds(236, 340, 110, 14);
		add(lblInstruo_1);
		
		JLabel lblInstruo_2 = new JLabel("Instru\u00E7\u00E3o 3");
		lblInstruo_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_2.setBounds(236, 360, 110, 14);
		add(lblInstruo_2);
		
		textField_40 = new JTextField();
		textField_40.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_40.setColumns(10);
		textField_40.setBounds(350, 360, 220, 20);
		add(textField_40);
		
		JLabel lblInstruo_3 = new JLabel("Instru\u00E7\u00E3o 4");
		lblInstruo_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_3.setBounds(236, 380, 110, 14);
		add(lblInstruo_3);
		
		textField_41 = new JTextField();
		textField_41.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_41.setColumns(10);
		textField_41.setBounds(350, 380, 220, 20);
		add(textField_41);
		
		JLabel lblInstruo_4 = new JLabel("Instru\u00E7\u00E3o 5");
		lblInstruo_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_4.setBounds(236, 400, 110, 14);
		add(lblInstruo_4);
		
		textField_42 = new JTextField();
		textField_42.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_42.setColumns(10);
		textField_42.setBounds(350, 400, 220, 20);
		add(textField_42);
		
		JLabel lblInstruo_5 = new JLabel("Instru\u00E7\u00E3o 6");
		lblInstruo_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_5.setBounds(236, 420, 86, 14);
		add(lblInstruo_5);
		
		textField_43 = new JTextField();
		textField_43.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_43.setColumns(10);
		textField_43.setBounds(350, 420, 220, 20);
		add(textField_43);
		
		JLabel lblInstruo_6 = new JLabel("Instru\u00E7\u00E3o 7");
		lblInstruo_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_6.setBounds(236, 440, 64, 14);
		add(lblInstruo_6);
		
		textField_44 = new JTextField();
		textField_44.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_44.setColumns(10);
		textField_44.setBounds(350, 440, 220, 20);
		add(textField_44);
		
		JLabel lblInstruo_7 = new JLabel("Instru\u00E7\u00E3o 8");
		lblInstruo_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblInstruo_7.setBounds(236, 460, 74, 14);
		add(lblInstruo_7);
		
		textField_45 = new JTextField();
		textField_45.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_45.setColumns(10);
		textField_45.setBounds(350, 460, 220, 20);
		add(textField_45);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, textField, textField_1, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, btnGerarBoleto}));

	}

	private String formatar_textfield_nome(String textfield_text) {
		if(textfield_text.substring(0, 1).equals(" ")) {
			while(true) {
				textfield_text = (textfield_text.substring(1, textfield_text.length()));
				if(textfield_text.length()==0) {
					break;
				}
				if(!textfield_text.substring(0, 1).equals(" ")) {
					break;
				}
			}
		}
		if(textfield_text.length()>0) {
			for(int i=-1; (i = textfield_text.indexOf(" ", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else if(textfield_text.substring(i+1, i+2).equals(" ")) {
					textfield_text = textfield_text.substring(0, i+1) + textfield_text.substring(i+2, textfield_text.length());
					i=-1;
				}
			}
		}
		textfield_text = WordUtils.capitalizeFully(textfield_text);
		return textfield_text;
	}

	private String formatar_textfield_CPF(String textfield_text) {
		if(textfield_text.length()>0) {
			for(int i=-1; (i = textfield_text.indexOf(".", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
			for(int i=-1; (i = textfield_text.indexOf("-", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
		}
		textfield_text = textfield_text.substring(0,3)+"."+textfield_text.substring(3,6)+"."+textfield_text.substring(6,9)+"-"+textfield_text.substring(9,11);
		return textfield_text;
	}
	
	private String formatar_textfield_CNPJ(String textfield_text) {
		if(textfield_text.length()>0) {
			for(int i=-1; (i = textfield_text.indexOf(".", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
			for(int i=-1; (i = textfield_text.indexOf("-", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
			for(int i=-1; (i = textfield_text.indexOf("/", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
		}
		textfield_text = textfield_text.substring(0,2)+"."+textfield_text.substring(2,5)+"."+textfield_text.substring(5,8)+"/"+textfield_text.substring(8,12)+"-"+textfield_text.substring(12,14);
		return textfield_text;
	}

	private String formatar_textfield_CEP(String textfield_text) {
		if(textfield_text.length()>0) {
			for(int i=-1; (i = textfield_text.indexOf("-", i + 1)) != -1; i++) {
				if(i==(textfield_text.length()-1)) {
					textfield_text = textfield_text.substring(0, i);
				}	else {
					textfield_text = textfield_text.substring(0, i) + textfield_text.substring(i+1, textfield_text.length());
					i=-1;
				}
			}
		}
		textfield_text = textfield_text.substring(0,5)+"-"+textfield_text.substring(5,8);
		return textfield_text;
	}

	private String formatar_textfield_numero(String textfield_text) {
		if(textfield_text.length()>0) {
			if(textfield_text.equals("0")) {
				textfield_text = "s/n";
			}
		}
		return textfield_text;
	}
}
