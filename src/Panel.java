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
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField sacado_nome_textField;
	private JTextField sacado_CPF_textField;
	private JTextField sacado_numero_textField;
	private JTextField sacado_bairro_textField;
	private JTextField sacado_CEP_textField;
	private JTextField sacado_localidade_textField;
	private JTextField cedente_nome_textField;
	private JTextField cedente_CNPJ_textField;
	private JLabel sacado_titulo_label;
	private JButton btnGerarBoleto;
	private JTextField avalista_nome_textField;
	private JTextField avalista_CPF_textField;
	private JTextField sacado_logradouro_textField;
	private JTextField conta_numero_textField;
	private JTextField conta_tipo_carteira_textField;
	private JTextField conta_nome_agencia_textField;
	private JTextField conta_numero_agencia_textField;
	private JTextField avalista_localidade_textField;
	private JTextField avalista_CEP_textField;
	private JTextField avalista_bairro_textField;
	private JTextField avalista_logradouro_textField;
	private JTextField avalista_numero_textField;
	private JTextField titulo_numero_documento_textField;
	private JTextField titulo_nosso_numero_textField;
	private JTextField titulo_aceite_textField;
	private JTextField titulo_tipo_documento_textField;
	private JTextField titulo_data_vencimento_textField;
	private JTextField titulo_data_documento_textField;
	private JTextField titulo_valor_textField;
	private JTextField titulo_digito_nosso_numero_textField;
	private JTextField titulo_desconto_textField;
	private JTextField titulo_deducao_textField;
	private JTextField titulo_mora_textField;
	private JTextField titulo_acrescimo_textField;
	private JTextField titulo_valor_cobrado_textField;
	private JTextField boleto_local_pagamento_textField;
	private JTextField boleto_instrucao_sacado_textField;
	private JTextField boleto_instrucao1_textField;
	private JTextField boleto_instrucao2_textField;
	private JTextField boleto_instrucao3_textField;
	private JTextField boleto_instrucao4_textField;
	private JTextField boleto_instrucao5_textField;
	private JTextField boleto_instrucao6_textField;
	private JTextField boleto_instrucao7_textField;
	private JTextField boleto_instrucao8_textField;

	/**
	 * Create the panel.
	 */
	public Panel() {
		setFocusCycleRoot(true);

		sacado_titulo_label = new JLabel("Dados do sacado");
		sacado_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		sacado_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		sacado_titulo_label.setForeground(Color.BLACK);
		sacado_titulo_label.setBounds(10, 45, 152, 14);
		sacado_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		sacado_titulo_label.setBackground(UIManager.getColor("Button.darkShadow"));

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
		add(sacado_titulo_label);
				
						JLabel sacado_nome_label = new JLabel("Nome");
						sacado_nome_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
						sacado_nome_label.setBounds(10, 70, 46, 14);
						add(sacado_nome_label);
		
				JLabel sacado_cpf_label = new JLabel("CPF");
				sacado_cpf_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
				sacado_cpf_label.setBounds(10, 90, 46, 14);
				add(sacado_cpf_label);
				
						JLabel sacado_endereco_label = new JLabel("Endere\u00E7o");
						sacado_endereco_label.setForeground(Color.LIGHT_GRAY);
						sacado_endereco_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
						sacado_endereco_label.setBounds(10, 110, 64, 14);
						add(sacado_endereco_label);
		
				JLabel sacado_UF_label = new JLabel("UF");
				sacado_UF_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
				sacado_UF_label.setBounds(10, 124, 46, 14);
				add(sacado_UF_label);
				
						JLabel sacado_localidade_label = new JLabel("Localidade");
						sacado_localidade_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
						sacado_localidade_label.setBounds(10, 144, 64, 14);
						add(sacado_localidade_label);
				
						JLabel sacado_CEP_label = new JLabel("CEP");
						sacado_CEP_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
						sacado_CEP_label.setBounds(10, 164, 46, 14);
						add(sacado_CEP_label);
				
						JLabel sacado_bairro_label = new JLabel("Bairro");
						sacado_bairro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
						sacado_bairro_label.setBounds(10, 184, 46, 14);
						add(sacado_bairro_label);
		
				JLabel sacado_numero_label = new JLabel("N\u00FAmero");
				sacado_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
				sacado_numero_label.setBounds(10, 224, 46, 14);
				add(sacado_numero_label);
		
		JLabel sacado_logradouro_label = new JLabel("Logradouro");
		sacado_logradouro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_logradouro_label.setBounds(10, 204, 64, 14);
		add(sacado_logradouro_label);
		add(btnGerarBoleto);

		sacado_nome_textField = new JTextField();
		sacado_nome_textField.addFocusListener(new FocusAdapter() {
			// Verificador de nome; nome não pode conter números, nome deve começar com letra maiúscula (caso não comece, capitalizar automaticamente); espaços disnecessários também serão removidos
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_nome_textField.getText().length()==0) {
					sacado_nome_textField.setForeground(Color.LIGHT_GRAY);
					sacado_nome_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_nome_textField.setText("Digite o nome");

				}	else {
					String sem_espacos = sacado_nome_textField.getText().replace(" ", "");

					if(!sem_espacos.chars().allMatch(Character::isLetter)) {
						sacado_nome_textField.setBackground(Color.RED);
						sacado_nome_textField.setForeground(Color.WHITE);
						sacado_nome_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_nome_textField.setToolTipText("Somente letras podem ser usadas no nome.");
					}	else {
						sacado_nome_textField.setBackground(Color.WHITE);
						sacado_nome_textField.setForeground(Color.BLACK);
						sacado_nome_textField.setText(formatar_textfield_nome(sacado_nome_textField.getText()));
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_nome_textField.getBackground() == Color.RED) {
					sacado_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_nome_textField.setBackground(Color.WHITE);
					sacado_nome_textField.setForeground(Color.BLACK);
					sacado_nome_textField.selectAll();
				}
				if(sacado_nome_textField.getText().equals("Digite o nome")) {
					sacado_nome_textField.setText("");
					sacado_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_nome_textField.setBackground(Color.WHITE);
					sacado_nome_textField.setForeground(Color.BLACK);
					sacado_nome_textField.selectAll();
				}
			}
		});
		sacado_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_nome_textField.setBounds(76, 70, 86, 20);
		sacado_nome_textField.setColumns(10);
		add(sacado_nome_textField);

		sacado_CPF_textField = new JTextField();
		sacado_CPF_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_CPF_textField.getText().length()==0) {
					sacado_CPF_textField.setForeground(Color.LIGHT_GRAY);
					sacado_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_CPF_textField.setText("Digite o CPF");
				}	else {
					String sem_ponto_e_sem_traco = sacado_CPF_textField.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						sacado_CPF_textField.setBackground(Color.RED);
						sacado_CPF_textField.setForeground(Color.WHITE);
						sacado_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_CPF_textField.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()!=11){
						sacado_CPF_textField.setBackground(Color.RED);
						sacado_CPF_textField.setForeground(Color.WHITE);
						sacado_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_CPF_textField.setToolTipText("Digite um CPF válido");
					}	else{
						sacado_CPF_textField.setBackground(Color.WHITE);
						sacado_CPF_textField.setForeground(Color.BLACK);
						sacado_CPF_textField.setText(formatar_textfield_CPF(sacado_CPF_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_CPF_textField.getBackground() == Color.RED) {
					sacado_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_CPF_textField.setBackground(Color.WHITE);
					sacado_CPF_textField.setForeground(Color.BLACK);
					sacado_CPF_textField.selectAll();
				}
				if(sacado_CPF_textField.getText().equals("Digite o CPF")) {
					sacado_CPF_textField.setText("");
					sacado_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_CPF_textField.setBackground(Color.WHITE);
					sacado_CPF_textField.setForeground(Color.BLACK);
					sacado_CPF_textField.selectAll();
				}
			}
		});
		sacado_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_CPF_textField.setColumns(10);
		sacado_CPF_textField.setBounds(76, 90, 86, 20);
		add(sacado_CPF_textField);

		sacado_localidade_textField = new JTextField();
		sacado_localidade_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_localidade_textField.setColumns(10);
		sacado_localidade_textField.setBounds(76, 144, 86, 20);
		add(sacado_localidade_textField);

		sacado_CEP_textField = new JTextField();
		sacado_CEP_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_CEP_textField.getText().length()==0) {
					sacado_CEP_textField.setForeground(Color.LIGHT_GRAY);
					sacado_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_CEP_textField.setText("Digite o CEP");
				}	else {
					String sem_traco = sacado_CEP_textField.getText().replace("-", "");
					if(!StringUtils.isNumeric(sem_traco)) {
						sacado_CEP_textField.setBackground(Color.RED);
						sacado_CEP_textField.setForeground(Color.WHITE);
						sacado_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_CEP_textField.setToolTipText("Digite somente números");
					}	else if(sem_traco.length()!=8){
						sacado_CEP_textField.setBackground(Color.RED);
						sacado_CEP_textField.setForeground(Color.WHITE);
						sacado_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_CEP_textField.setToolTipText("Digite um CEP válido");
					}	else{
						sacado_CEP_textField.setBackground(Color.WHITE);
						sacado_CEP_textField.setForeground(Color.BLACK);
						sacado_CEP_textField.setText(formatar_textfield_CEP(sacado_CEP_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_CEP_textField.getBackground() == Color.RED) {
					sacado_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_CEP_textField.setBackground(Color.WHITE);
					sacado_CEP_textField.setForeground(Color.BLACK);
					sacado_CEP_textField.selectAll();
				}
				if(sacado_CEP_textField.getText().equals("Digite o CEP")) {
					sacado_CEP_textField.setText("");
					sacado_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_CEP_textField.setBackground(Color.WHITE);
					sacado_CEP_textField.setForeground(Color.BLACK);
					sacado_CEP_textField.selectAll();
				}
			}
		});
		sacado_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_CEP_textField.setColumns(10);
		sacado_CEP_textField.setBounds(76, 164, 86, 20);
		add(sacado_CEP_textField);

		sacado_bairro_textField = new JTextField();
		sacado_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_bairro_textField.setColumns(10);
		sacado_bairro_textField.setBounds(76, 184, 86, 20);
		add(sacado_bairro_textField);

		sacado_numero_textField = new JTextField();
		sacado_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_numero_textField.getText().length()==0) {
					sacado_numero_textField.setForeground(Color.LIGHT_GRAY);
					sacado_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_numero_textField.setText("Digite o Número");
				}	else {
					String sem_numero = sacado_numero_textField.getText().replace("s/n", "0");
					sem_numero = sacado_numero_textField.getText().replace("sn", "0");
					if(!StringUtils.isNumeric(sem_numero)) {
						sacado_numero_textField.setBackground(Color.RED);
						sacado_numero_textField.setForeground(Color.WHITE);
						sacado_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_numero_textField.setToolTipText("Digite somente números");
					}else{
						sacado_numero_textField.setBackground(Color.WHITE);
						sacado_numero_textField.setForeground(Color.BLACK);
						sacado_numero_textField.setText(formatar_textfield_numero(sacado_numero_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_numero_textField.getBackground() == Color.RED) {
					sacado_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_numero_textField.setBackground(Color.WHITE);
					sacado_numero_textField.setForeground(Color.BLACK);
					sacado_numero_textField.selectAll();
				}
				if(sacado_numero_textField.getText().equals("Digite o Número")) {
					sacado_numero_textField.setText("");
					sacado_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_numero_textField.setBackground(Color.WHITE);
					sacado_numero_textField.setForeground(Color.BLACK);
					sacado_numero_textField.selectAll();
				}
			}
		});
		sacado_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_numero_textField.setColumns(10);
		sacado_numero_textField.setBounds(76, 224, 86, 20);
		add(sacado_numero_textField);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escolha seu banco");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Bradesco", "Ita\u00FA", "Banco do Brasil", "HSBC", "Caixa Econ\u00F4mica Federal"}));
		comboBox.setBounds(291, 11, 100, 26);
		add(comboBox);

		JLabel lblEscolhaOBanco = new JLabel("Escolha o Banco:");
		lblEscolhaOBanco.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblEscolhaOBanco.setBounds(181, 16, 110, 16);
		add(lblEscolhaOBanco);

		JLabel cedente_titulo_label = new JLabel("Dados do cedente");
		cedente_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		cedente_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		cedente_titulo_label.setForeground(Color.BLACK);
		cedente_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		cedente_titulo_label.setBackground((Color) null);
		cedente_titulo_label.setBounds(372, 45, 176, 14);
		add(cedente_titulo_label);

		JLabel cedente_nome_label = new JLabel("Nome da Empresa");
		cedente_nome_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		cedente_nome_label.setBounds(372, 70, 94, 14);
		add(cedente_nome_label);

		JLabel cedente_CNPJ_label = new JLabel("CNPJ");
		cedente_CNPJ_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		cedente_CNPJ_label.setBounds(372, 90, 46, 14);
		add(cedente_CNPJ_label);

		cedente_nome_textField = new JTextField();
		cedente_nome_textField.addFocusListener(new FocusAdapter() {
			// Verificador de nome; nome não pode conter números, nome deve começar com letra maiúscula (caso não comece, capitalizar automaticamente); espaços disnecessários também serão removidos
			@Override
			public void focusLost(FocusEvent e) {
				if(cedente_nome_textField.getText().length()==0) {
					cedente_nome_textField.setForeground(Color.LIGHT_GRAY);
					cedente_nome_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					cedente_nome_textField.setText("Digite o nome");
				}	else {
					String sem_espacos = cedente_nome_textField.getText().replace(" ", "x");

					if(!sem_espacos.chars().allMatch(Character::isLetter)) {
						cedente_nome_textField.setBackground(Color.RED);
						cedente_nome_textField.setForeground(Color.WHITE);
						cedente_nome_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						cedente_nome_textField.setToolTipText("Somente letras podem ser usadas no nome.");
					}	else {
						cedente_nome_textField.setBackground(Color.WHITE);
						cedente_nome_textField.setForeground(Color.BLACK);
						cedente_nome_textField.setText(formatar_textfield_nome(cedente_nome_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(cedente_nome_textField.getBackground() == Color.RED) {
					cedente_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					cedente_nome_textField.setBackground(Color.WHITE);
					cedente_nome_textField.setForeground(Color.BLACK);
					cedente_nome_textField.selectAll();
				}
				if(cedente_nome_textField.getText().equals("Digite o nome")) {
					cedente_nome_textField.setText("");
					cedente_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					cedente_nome_textField.setBackground(Color.WHITE);
					cedente_nome_textField.setForeground(Color.BLACK);
					cedente_nome_textField.selectAll();
				}
			}
		});
		cedente_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		cedente_nome_textField.setColumns(10);
		cedente_nome_textField.setBounds(468, 70, 102, 20);
		add(cedente_nome_textField);

		cedente_CNPJ_textField = new JTextField();
		cedente_CNPJ_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cedente_CNPJ_textField.getText().length()==0) {
					cedente_CNPJ_textField.setForeground(Color.LIGHT_GRAY);
					cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					cedente_CNPJ_textField.setText("Digite o CNPJ");
				}	else {
					String sem_ponto_e_sem_traco = cedente_CNPJ_textField.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("/", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						cedente_CNPJ_textField.setBackground(Color.RED);
						cedente_CNPJ_textField.setForeground(Color.WHITE);
						cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						cedente_CNPJ_textField.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()!=14){
						cedente_CNPJ_textField.setBackground(Color.RED);
						cedente_CNPJ_textField.setForeground(Color.WHITE);
						cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						cedente_CNPJ_textField.setToolTipText("Digite um CNPJ válido");
					}	else{
						cedente_CNPJ_textField.setBackground(Color.WHITE);
						cedente_CNPJ_textField.setForeground(Color.BLACK);
						cedente_CNPJ_textField.setText(formatar_textfield_CNPJ(cedente_CNPJ_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(cedente_CNPJ_textField.getBackground() == Color.RED) {
					cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					cedente_CNPJ_textField.setBackground(Color.WHITE);
					cedente_CNPJ_textField.setForeground(Color.BLACK);
					cedente_CNPJ_textField.selectAll();
				}
				if(cedente_CNPJ_textField.getText().equals("Digite o CNPJ")) {
					cedente_CNPJ_textField.setText("");
					cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					cedente_CNPJ_textField.setBackground(Color.WHITE);
					cedente_CNPJ_textField.setForeground(Color.BLACK);
					cedente_CNPJ_textField.selectAll();
				}
			}
		});
		cedente_CNPJ_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		cedente_CNPJ_textField.setColumns(10);
		cedente_CNPJ_textField.setBounds(468, 90, 102, 20);
		add(cedente_CNPJ_textField);
		
		JLabel avalista_titulo_label = new JLabel("Dados do Sacado Avalista");
		avalista_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		avalista_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		avalista_titulo_label.setForeground(Color.BLACK);
		avalista_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		avalista_titulo_label.setBackground(SystemColor.controlDkShadow);
		avalista_titulo_label.setBounds(193, 45, 152, 14);
		add(avalista_titulo_label);
		
		JLabel avalista_nome_label = new JLabel("Nome");
		avalista_nome_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_nome_label.setBounds(193, 70, 46, 14);
		add(avalista_nome_label);
		
		avalista_nome_textField = new JTextField();
		avalista_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_nome_textField.setColumns(10);
		avalista_nome_textField.setBounds(259, 70, 86, 20);
		add(avalista_nome_textField);
		
		JLabel avalista_CPF_label = new JLabel("CPF");
		avalista_CPF_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CPF_label.setBounds(193, 90, 46, 14);
		add(avalista_CPF_label);
		
		avalista_CPF_textField = new JTextField();
		avalista_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CPF_textField.setColumns(10);
		avalista_CPF_textField.setBounds(259, 90, 86, 20);
		add(avalista_CPF_textField);
		
		sacado_logradouro_textField = new JTextField();
		sacado_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_logradouro_textField.setColumns(10);
		sacado_logradouro_textField.setBounds(76, 204, 86, 20);
		add(sacado_logradouro_textField);
		
		JLabel conta_titulo_label = new JLabel("Dados da Conta Banc\u00E1ria");
		conta_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		conta_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		conta_titulo_label.setForeground(Color.BLACK);
		conta_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		conta_titulo_label.setBackground(SystemColor.controlDkShadow);
		conta_titulo_label.setBounds(372, 118, 176, 14);
		add(conta_titulo_label);
		
		conta_numero_textField = new JTextField();
		conta_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_textField.setColumns(10);
		conta_numero_textField.setBounds(462, 144, 108, 20);
		add(conta_numero_textField);
		
		JLabel conta_numero_label = new JLabel("N\u00FAmero da Conta");
		conta_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_label.setBounds(372, 146, 86, 14);
		add(conta_numero_label);
		
		JLabel conta_tipo_carteira_label = new JLabel("Tipo de Carteira");
		conta_tipo_carteira_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_tipo_carteira_label.setBounds(372, 166, 86, 14);
		add(conta_tipo_carteira_label);
		
		conta_tipo_carteira_textField = new JTextField();
		conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_tipo_carteira_textField.setColumns(10);
		conta_tipo_carteira_textField.setBounds(462, 164, 108, 20);
		add(conta_tipo_carteira_textField);
		
		JLabel conta_nome_agencia_label = new JLabel("Nome");
		conta_nome_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_nome_agencia_label.setBounds(372, 205, 64, 14);
		add(conta_nome_agencia_label);
		
		conta_nome_agencia_textField = new JTextField();
		conta_nome_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_nome_agencia_textField.setColumns(10);
		conta_nome_agencia_textField.setBounds(462, 204, 108, 20);
		add(conta_nome_agencia_textField);
		
		conta_numero_agencia_textField = new JTextField();
		conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_agencia_textField.setColumns(10);
		conta_numero_agencia_textField.setBounds(462, 224, 108, 20);
		add(conta_numero_agencia_textField);
		
		JLabel conta_numero_agencia_label = new JLabel("N\u00FAmero");
		conta_numero_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_agencia_label.setBounds(372, 225, 46, 14);
		add(conta_numero_agencia_label);
		
		JLabel conta_dados_da_agencia_label = new JLabel("Dados da Ag\u00EAncia");
		conta_dados_da_agencia_label.setForeground(Color.LIGHT_GRAY);
		conta_dados_da_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_dados_da_agencia_label.setBounds(372, 190, 94, 14);
		add(conta_dados_da_agencia_label);
		
		JLabel avalista_endereco_label = new JLabel("Endere\u00E7o");
		avalista_endereco_label.setForeground(Color.LIGHT_GRAY);
		avalista_endereco_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_endereco_label.setBounds(193, 110, 64, 14);
		add(avalista_endereco_label);
		
		JLabel avalista_UF_label = new JLabel("UF");
		avalista_UF_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_UF_label.setBounds(193, 124, 46, 14);
		add(avalista_UF_label);
		
		avalista_localidade_textField = new JTextField();
		avalista_localidade_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_localidade_textField.setColumns(10);
		avalista_localidade_textField.setBounds(259, 144, 86, 20);
		add(avalista_localidade_textField);
		
		JLabel avalista_localidade_label = new JLabel("Localidade");
		avalista_localidade_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_localidade_label.setBounds(193, 144, 64, 14);
		add(avalista_localidade_label);
		
		JLabel avalista_CEP_label = new JLabel("CEP");
		avalista_CEP_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CEP_label.setBounds(193, 164, 46, 14);
		add(avalista_CEP_label);
		
		avalista_CEP_textField = new JTextField();
		avalista_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CEP_textField.setColumns(10);
		avalista_CEP_textField.setBounds(259, 164, 86, 20);
		add(avalista_CEP_textField);
		
		avalista_bairro_textField = new JTextField();
		avalista_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_bairro_textField.setColumns(10);
		avalista_bairro_textField.setBounds(259, 184, 86, 20);
		add(avalista_bairro_textField);
		
		JLabel avalista_bairro_label = new JLabel("Bairro");
		avalista_bairro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_bairro_label.setBounds(193, 184, 46, 14);
		add(avalista_bairro_label);
		
		JLabel avalista_logradouro_label = new JLabel("Logradouro");
		avalista_logradouro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_logradouro_label.setBounds(193, 204, 64, 14);
		add(avalista_logradouro_label);
		
		avalista_logradouro_textField = new JTextField();
		avalista_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_logradouro_textField.setColumns(10);
		avalista_logradouro_textField.setBounds(259, 204, 86, 20);
		add(avalista_logradouro_textField);
		
		avalista_numero_textField = new JTextField();
		avalista_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_numero_textField.setColumns(10);
		avalista_numero_textField.setBounds(259, 224, 86, 20);
		add(avalista_numero_textField);
		
		JLabel avalista_numero_label = new JLabel("N\u00FAmero");
		avalista_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_numero_label.setBounds(193, 224, 46, 14);
		add(avalista_numero_label);
		
		JLabel titulo_titulo_label = new JLabel("Dados do T\u00EDtulo");
		titulo_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		titulo_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_titulo_label.setForeground(Color.BLACK);
		titulo_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		titulo_titulo_label.setBackground(SystemColor.controlDkShadow);
		titulo_titulo_label.setBounds(10, 255, 200, 14);
		add(titulo_titulo_label);
		
		JLabel titulo_numero_documento_label = new JLabel("N\u00FAmero do Documento");
		titulo_numero_documento_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_numero_documento_label.setBounds(10, 280, 110, 14);
		add(titulo_numero_documento_label);
		
		JLabel titulo_nosso_numero_label = new JLabel("Nosso N\u00FAmero");
		titulo_nosso_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_nosso_numero_label.setBounds(10, 300, 110, 14);
		add(titulo_nosso_numero_label);
		
		titulo_numero_documento_textField = new JTextField();
		titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_numero_documento_textField.setColumns(10);
		titulo_numero_documento_textField.setBounds(128, 280, 86, 20);
		add(titulo_numero_documento_textField);
		
		titulo_nosso_numero_textField = new JTextField();
		titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_nosso_numero_textField.setColumns(10);
		titulo_nosso_numero_textField.setBounds(128, 300, 86, 20);
		add(titulo_nosso_numero_textField);
		
		JLabel titulo_digito_nosso_numero_label = new JLabel("Digito do Nosso N\u00FAmero");
		titulo_digito_nosso_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_digito_nosso_numero_label.setBounds(10, 320, 119, 14);
		add(titulo_digito_nosso_numero_label);
		
		JLabel titulo_valor_label = new JLabel("Valor");
		titulo_valor_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_label.setBounds(10, 340, 110, 14);
		add(titulo_valor_label);
		
		JLabel titulo_data_documento_label = new JLabel("Data do Documento");
		titulo_data_documento_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_data_documento_label.setBounds(10, 360, 110, 14);
		add(titulo_data_documento_label);
		
		JLabel titulo_data_vencimento_label = new JLabel("Data do Vencimento");
		titulo_data_vencimento_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_data_vencimento_label.setBounds(10, 380, 110, 14);
		add(titulo_data_vencimento_label);
		
		JLabel titulo_tipo_documento_label = new JLabel("Tipo de Documento");
		titulo_tipo_documento_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_tipo_documento_label.setBounds(10, 400, 110, 14);
		add(titulo_tipo_documento_label);
		
		JLabel titulo_aceite_label = new JLabel("Aceite");
		titulo_aceite_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_aceite_label.setBounds(10, 420, 46, 14);
		add(titulo_aceite_label);
		
		titulo_aceite_textField = new JTextField();
		titulo_aceite_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_aceite_textField.setColumns(10);
		titulo_aceite_textField.setBounds(128, 420, 86, 20);
		add(titulo_aceite_textField);
		
		titulo_tipo_documento_textField = new JTextField();
		titulo_tipo_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_tipo_documento_textField.setColumns(10);
		titulo_tipo_documento_textField.setBounds(128, 400, 86, 20);
		add(titulo_tipo_documento_textField);
		
		titulo_data_vencimento_textField = new JTextField();
		titulo_data_vencimento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_data_vencimento_textField.setColumns(10);
		titulo_data_vencimento_textField.setBounds(128, 380, 86, 20);
		add(titulo_data_vencimento_textField);
		
		titulo_data_documento_textField = new JTextField();
		titulo_data_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_data_documento_textField.setColumns(10);
		titulo_data_documento_textField.setBounds(128, 360, 86, 20);
		add(titulo_data_documento_textField);
		
		titulo_valor_textField = new JTextField();
		titulo_valor_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_textField.setColumns(10);
		titulo_valor_textField.setBounds(128, 340, 86, 20);
		add(titulo_valor_textField);
		
		titulo_digito_nosso_numero_textField = new JTextField();
		titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_digito_nosso_numero_textField.setColumns(10);
		titulo_digito_nosso_numero_textField.setBounds(128, 320, 86, 20);
		add(titulo_digito_nosso_numero_textField);
		
		JLabel titulo_desconto_label = new JLabel("Desconto");
		titulo_desconto_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_desconto_label.setBounds(10, 440, 64, 14);
		add(titulo_desconto_label);
		
		titulo_desconto_textField = new JTextField();
		titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_desconto_textField.setColumns(10);
		titulo_desconto_textField.setBounds(128, 440, 86, 20);
		add(titulo_desconto_textField);
		
		JLabel titulo_deducao_label = new JLabel("Dedu\u00E7\u00E3o");
		titulo_deducao_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_deducao_label.setBounds(10, 460, 46, 14);
		add(titulo_deducao_label);
		
		titulo_deducao_textField = new JTextField();
		titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_deducao_textField.setColumns(10);
		titulo_deducao_textField.setBounds(128, 460, 86, 20);
		add(titulo_deducao_textField);
		
		JLabel titulo_mora_label = new JLabel("Mora");
		titulo_mora_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_mora_label.setBounds(10, 480, 46, 14);
		add(titulo_mora_label);
		
		titulo_mora_textField = new JTextField();
		titulo_mora_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_mora_textField.setColumns(10);
		titulo_mora_textField.setBounds(128, 480, 86, 20);
		add(titulo_mora_textField);
		
		JLabel titulo_acrescimo_label = new JLabel("Acr\u00E9scimo");
		titulo_acrescimo_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_acrescimo_label.setBounds(10, 500, 64, 14);
		add(titulo_acrescimo_label);
		
		titulo_acrescimo_textField = new JTextField();
		titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_acrescimo_textField.setColumns(10);
		titulo_acrescimo_textField.setBounds(128, 500, 86, 20);
		add(titulo_acrescimo_textField);
		
		JLabel titulo_valor_cobrado_label = new JLabel("Valor Cobrado");
		titulo_valor_cobrado_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_cobrado_label.setBounds(10, 520, 110, 14);
		add(titulo_valor_cobrado_label);
		
		titulo_valor_cobrado_textField = new JTextField();
		titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_cobrado_textField.setColumns(10);
		titulo_valor_cobrado_textField.setBounds(128, 520, 86, 20);
		add(titulo_valor_cobrado_textField);
		
		JLabel boleto_titulo_label = new JLabel("Dados do Boleto");
		boleto_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		boleto_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		boleto_titulo_label.setForeground(Color.BLACK);
		boleto_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		boleto_titulo_label.setBackground(SystemColor.controlDkShadow);
		boleto_titulo_label.setBounds(236, 255, 200, 14);
		add(boleto_titulo_label);
		
		JLabel boleto_local_pagamento_label = new JLabel("Local Pagamento");
		boleto_local_pagamento_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_local_pagamento_label.setBounds(236, 280, 110, 14);
		add(boleto_local_pagamento_label);
		
		boleto_local_pagamento_textField = new JTextField();
		boleto_local_pagamento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_local_pagamento_textField.setColumns(10);
		boleto_local_pagamento_textField.setBounds(350, 280, 220, 20);
		add(boleto_local_pagamento_textField);
		
		boleto_instrucao_sacado_textField = new JTextField();
		boleto_instrucao_sacado_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao_sacado_textField.setColumns(10);
		boleto_instrucao_sacado_textField.setBounds(350, 300, 220, 20);
		add(boleto_instrucao_sacado_textField);
		
		JLabel boleto_instrucao_sacado_label = new JLabel("Instru\u00E7\u00E3o ao Sacado");
		boleto_instrucao_sacado_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao_sacado_label.setBounds(236, 300, 110, 14);
		add(boleto_instrucao_sacado_label);
		
		JLabel boleto_instrucao1_label = new JLabel("Instru\u00E7\u00E3o 1");
		boleto_instrucao1_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao1_label.setBounds(236, 320, 119, 14);
		add(boleto_instrucao1_label);
		
		boleto_instrucao1_textField = new JTextField();
		boleto_instrucao1_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao1_textField.setColumns(10);
		boleto_instrucao1_textField.setBounds(350, 320, 220, 20);
		add(boleto_instrucao1_textField);
		
		boleto_instrucao2_textField = new JTextField();
		boleto_instrucao2_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao2_textField.setColumns(10);
		boleto_instrucao2_textField.setBounds(350, 340, 220, 20);
		add(boleto_instrucao2_textField);
		
		JLabel boleto_instrucao2_label = new JLabel("Instru\u00E7\u00E3o 2");
		boleto_instrucao2_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao2_label.setBounds(236, 340, 110, 14);
		add(boleto_instrucao2_label);
		
		JLabel boleto_instrucao3_label = new JLabel("Instru\u00E7\u00E3o 3");
		boleto_instrucao3_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao3_label.setBounds(236, 360, 110, 14);
		add(boleto_instrucao3_label);
		
		boleto_instrucao3_textField = new JTextField();
		boleto_instrucao3_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao3_textField.setColumns(10);
		boleto_instrucao3_textField.setBounds(350, 360, 220, 20);
		add(boleto_instrucao3_textField);
		
		JLabel boleto_instrucao4_label = new JLabel("Instru\u00E7\u00E3o 4");
		boleto_instrucao4_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao4_label.setBounds(236, 380, 110, 14);
		add(boleto_instrucao4_label);
		
		boleto_instrucao4_textField = new JTextField();
		boleto_instrucao4_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao4_textField.setColumns(10);
		boleto_instrucao4_textField.setBounds(350, 380, 220, 20);
		add(boleto_instrucao4_textField);
		
		JLabel boleto_instrucao5_label = new JLabel("Instru\u00E7\u00E3o 5");
		boleto_instrucao5_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao5_label.setBounds(236, 400, 110, 14);
		add(boleto_instrucao5_label);
		
		boleto_instrucao5_textField = new JTextField();
		boleto_instrucao5_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao5_textField.setColumns(10);
		boleto_instrucao5_textField.setBounds(350, 400, 220, 20);
		add(boleto_instrucao5_textField);
		
		JLabel boleto_instrucao6_label = new JLabel("Instru\u00E7\u00E3o 6");
		boleto_instrucao6_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao6_label.setBounds(236, 420, 86, 14);
		add(boleto_instrucao6_label);
		
		boleto_instrucao6_textField = new JTextField();
		boleto_instrucao6_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao6_textField.setColumns(10);
		boleto_instrucao6_textField.setBounds(350, 420, 220, 20);
		add(boleto_instrucao6_textField);
		
		JLabel boleto_instrucao7_label = new JLabel("Instru\u00E7\u00E3o 7");
		boleto_instrucao7_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao7_label.setBounds(236, 440, 64, 14);
		add(boleto_instrucao7_label);
		
		boleto_instrucao7_textField = new JTextField();
		boleto_instrucao7_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao7_textField.setColumns(10);
		boleto_instrucao7_textField.setBounds(350, 440, 220, 20);
		add(boleto_instrucao7_textField);
		
		JLabel boleto_instrucao8_label = new JLabel("Instru\u00E7\u00E3o 8");
		boleto_instrucao8_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao8_label.setBounds(236, 460, 74, 14);
		add(boleto_instrucao8_label);
		
		boleto_instrucao8_textField = new JTextField();
		boleto_instrucao8_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao8_textField.setColumns(10);
		boleto_instrucao8_textField.setBounds(350, 460, 220, 20);
		add(boleto_instrucao8_textField);
		
		JComboBox sacado_UF_comboBox = new JComboBox();
		sacado_UF_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_UF_comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if(sacado_UF_comboBox.getSelectedIndex()== -1) {
					sacado_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
					sacado_UF_comboBox.setSelectedIndex(0);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				sacado_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
			}
		});
		sacado_UF_comboBox.setName(" ");
		sacado_UF_comboBox.setBackground(Color.WHITE);
		sacado_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		sacado_UF_comboBox.setToolTipText("Escolha a UF");
		sacado_UF_comboBox.setBounds(76, 124, 86, 20);
		add(sacado_UF_comboBox);
		
		JComboBox avalista_UF_comboBox = new JComboBox();
		avalista_UF_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_UF_comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if(avalista_UF_comboBox.getSelectedIndex()== -1) {
					avalista_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
					avalista_UF_comboBox.setSelectedIndex(0);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				avalista_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
			}
		});
		avalista_UF_comboBox.setToolTipText("Escolha a UF");
		avalista_UF_comboBox.setName(" ");
		avalista_UF_comboBox.setBackground(Color.WHITE);
		avalista_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		sacado_UF_comboBox.setToolTipText("Escolha a UF");
		avalista_UF_comboBox.setBounds(259, 124, 86, 20);
		add(avalista_UF_comboBox);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, sacado_nome_textField, sacado_CPF_textField, sacado_localidade_textField, sacado_CEP_textField, sacado_bairro_textField, sacado_numero_textField, cedente_nome_textField, cedente_CNPJ_textField, btnGerarBoleto}));

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
