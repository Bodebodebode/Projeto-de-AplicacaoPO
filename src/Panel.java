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

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;

import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyBoundsListener;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Rectangle;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

import org.jdesktop.swingx.JXDatePicker;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {

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
	private JTextField conta_digito_agencia_textField;
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
		setLayout(null);

		JLabel lblEscolhaOBanco = new JLabel("Escolha o Banco:");
		lblEscolhaOBanco.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblEscolhaOBanco.setBounds(10, 16, 110, 16);
		add(lblEscolhaOBanco);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("Escolha seu banco");
		comboBox.setModel(new DefaultComboBoxModel(BancosSuportados.values()));
		comboBox.setBounds(103, 11, 303, 26);
		add(comboBox);
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
		sacado_endereco_label.setForeground(Color.GRAY);
		sacado_endereco_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_endereco_label.setBounds(10, 108, 64, 14);
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

		JLabel sacado_logradouro_label = new JLabel("Logradouro");
		sacado_logradouro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_logradouro_label.setBounds(10, 204, 64, 14);
		add(sacado_logradouro_label);

		JLabel sacado_numero_label = new JLabel("N\u00FAmero");
		sacado_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_numero_label.setBounds(10, 224, 46, 14);
		add(sacado_numero_label);

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
		sacado_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		sacado_UF_comboBox.setToolTipText("Escolha a UF");
		sacado_UF_comboBox.setBounds(76, 124, 86, 20);
		add(sacado_UF_comboBox);
		sacado_UF_comboBox.setToolTipText("Escolha a UF");

		sacado_localidade_textField = new JTextField();
		sacado_localidade_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_localidade_textField.getText().length()==0) {
					sacado_localidade_textField.setForeground(Color.LIGHT_GRAY);
					sacado_localidade_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					sacado_localidade_textField.setText("Digite a localidade");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_localidade_textField.getText().equals("Digite a localidade")) {
					sacado_localidade_textField.setText("");
					sacado_localidade_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_localidade_textField.setBackground(Color.WHITE);
					sacado_localidade_textField.setForeground(Color.BLACK);
					sacado_localidade_textField.selectAll();
				}
			}
		});
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
		sacado_bairro_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_bairro_textField.getText().length()==0) {
					sacado_bairro_textField.setForeground(Color.LIGHT_GRAY);
					sacado_bairro_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_bairro_textField.setText("Digite o bairro");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_bairro_textField.getText().equals("Digite o bairro")) {
					sacado_bairro_textField.setText("");
					sacado_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_bairro_textField.setBackground(Color.WHITE);
					sacado_bairro_textField.setForeground(Color.BLACK);
					sacado_bairro_textField.selectAll();
				}
			}
		});
		sacado_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_bairro_textField.setColumns(10);
		sacado_bairro_textField.setBounds(76, 184, 86, 20);
		add(sacado_bairro_textField);

		sacado_logradouro_textField = new JTextField();
		sacado_logradouro_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_logradouro_textField.getText().length()==0) {
					sacado_logradouro_textField.setForeground(Color.LIGHT_GRAY);
					sacado_logradouro_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					sacado_logradouro_textField.setText("Digite o logradouro");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_logradouro_textField.getText().equals("Digite o logradouro")) {
					sacado_logradouro_textField.setText("");
					sacado_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_logradouro_textField.setBackground(Color.WHITE);
					sacado_logradouro_textField.setForeground(Color.BLACK);
					sacado_logradouro_textField.selectAll();
				}
			}
		});
		sacado_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		sacado_logradouro_textField.setColumns(10);
		sacado_logradouro_textField.setBounds(76, 204, 86, 20);
		add(sacado_logradouro_textField);

		sacado_numero_textField = new JTextField();
		sacado_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(sacado_numero_textField.getText().length()==0) {
					sacado_numero_textField.setForeground(Color.LIGHT_GRAY);
					sacado_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					sacado_numero_textField.setText("Digite o número");
				}	else {
					String sem_numero = "";
					sem_numero = sacado_numero_textField.getText().replace("sn", "0");
					sem_numero = sacado_numero_textField.getText().replace("s/n", "0");
					if(!StringUtils.isNumeric(sem_numero)) {
						sacado_numero_textField.setBackground(Color.RED);
						sacado_numero_textField.setForeground(Color.WHITE);
						sacado_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						sacado_numero_textField.setToolTipText("Digite somente números");
					}else{
						sacado_numero_textField.setBackground(Color.WHITE);
						sacado_numero_textField.setForeground(Color.BLACK);
						sacado_numero_textField.setText(formatar_textfield_numero(sem_numero));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(sacado_numero_textField.getBackground() == Color.RED) {
					sacado_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					sacado_numero_textField.setBackground(Color.WHITE);
					sacado_numero_textField.setForeground(Color.BLACK);
					sacado_numero_textField.setText("");
					sacado_numero_textField.selectAll();
				}
				if(sacado_numero_textField.getText().equals("Digite o número")) {
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

		JLabel avalista_CPF_label = new JLabel("CPF/CNPJ");
		avalista_CPF_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CPF_label.setBounds(193, 90, 64, 14);
		add(avalista_CPF_label);

		JLabel avalista_endereco_label = new JLabel("Endere\u00E7o");
		avalista_endereco_label.setForeground(Color.GRAY);
		avalista_endereco_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_endereco_label.setBounds(193, 108, 64, 14);
		add(avalista_endereco_label);

		JLabel avalista_UF_label = new JLabel("UF");
		avalista_UF_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_UF_label.setBounds(193, 124, 46, 14);
		add(avalista_UF_label);

		JLabel avalista_localidade_label = new JLabel("Localidade");
		avalista_localidade_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_localidade_label.setBounds(193, 144, 64, 14);
		add(avalista_localidade_label);

		JLabel avalista_CEP_label = new JLabel("CEP");
		avalista_CEP_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CEP_label.setBounds(193, 164, 46, 14);
		add(avalista_CEP_label);

		JLabel avalista_bairro_label = new JLabel("Bairro");
		avalista_bairro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_bairro_label.setBounds(193, 184, 46, 14);
		add(avalista_bairro_label);

		JLabel avalista_logradouro_label = new JLabel("Logradouro");
		avalista_logradouro_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_logradouro_label.setBounds(193, 204, 64, 14);
		add(avalista_logradouro_label);

		JLabel avalista_numero_label = new JLabel("N\u00FAmero");
		avalista_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_numero_label.setBounds(193, 224, 46, 14);
		add(avalista_numero_label);

		avalista_nome_textField = new JTextField();
		avalista_nome_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_nome_textField.getText().length()==0) {
					avalista_nome_textField.setForeground(Color.LIGHT_GRAY);
					avalista_nome_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					avalista_nome_textField.setText("Digite o nome");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_nome_textField.getText().equals("Digite o nome")) {
					avalista_nome_textField.setText("");
					avalista_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_nome_textField.setBackground(Color.WHITE);
					avalista_nome_textField.setForeground(Color.BLACK);
					avalista_nome_textField.selectAll();
				}
			}
		});
		avalista_nome_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_nome_textField.setColumns(10);
		avalista_nome_textField.setBounds(259, 70, 86, 20);
		add(avalista_nome_textField);

		avalista_CPF_textField = new JTextField();
		avalista_CPF_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_CPF_textField.getText().length()==0) {
					avalista_CPF_textField.setForeground(Color.LIGHT_GRAY);
					avalista_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					avalista_CPF_textField.setText("Digite o CPF/CNPJ");
				}	else {
					String sem_ponto_e_sem_traco = avalista_CPF_textField.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("/", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						avalista_CPF_textField.setBackground(Color.RED);
						avalista_CPF_textField.setForeground(Color.WHITE);
						avalista_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						avalista_CPF_textField.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()==11){
						avalista_CPF_textField.setBackground(Color.WHITE);
						avalista_CPF_textField.setForeground(Color.BLACK);
						avalista_CPF_textField.setText(formatar_textfield_CPF(avalista_CPF_textField.getText()));
					}	else if(sem_ponto_e_sem_traco.length()==14) {
						avalista_CPF_textField.setBackground(Color.WHITE);
						avalista_CPF_textField.setForeground(Color.BLACK);
						avalista_CPF_textField.setText(formatar_textfield_CNPJ(avalista_CPF_textField.getText()));
					}	else{
						avalista_CPF_textField.setBackground(Color.RED);
						avalista_CPF_textField.setForeground(Color.WHITE);
						avalista_CPF_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						avalista_CPF_textField.setToolTipText("Digite um CPF/CNPJ válido");
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_CPF_textField.getBackground() == Color.RED) {
					avalista_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_CPF_textField.setBackground(Color.WHITE);
					avalista_CPF_textField.setForeground(Color.BLACK);
					avalista_CPF_textField.selectAll();
				}
				if(avalista_CPF_textField.getText().equals("Digite o CPF/CNPJ")) {
					avalista_CPF_textField.setText("");
					avalista_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_CPF_textField.setBackground(Color.WHITE);
					avalista_CPF_textField.setForeground(Color.BLACK);
					avalista_CPF_textField.selectAll();
				}
			}
		});
		avalista_CPF_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CPF_textField.setColumns(10);
		avalista_CPF_textField.setBounds(259, 90, 86, 20);
		add(avalista_CPF_textField);

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
		avalista_UF_comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Acre (AC)", "Alagoas (AL)", "Amazonas (AM)", "Amap\u00E1 (AP)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		avalista_UF_comboBox.setBounds(259, 124, 86, 20);
		add(avalista_UF_comboBox);

		avalista_localidade_textField = new JTextField();
		avalista_localidade_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_localidade_textField.getText().length()==0) {
					avalista_localidade_textField.setForeground(Color.LIGHT_GRAY);
					avalista_localidade_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					avalista_localidade_textField.setText("Digite a localidade");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_localidade_textField.getText().equals("Digite a localidade")) {
					avalista_localidade_textField.setText("");
					avalista_localidade_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_localidade_textField.setBackground(Color.WHITE);
					avalista_localidade_textField.setForeground(Color.BLACK);
					avalista_localidade_textField.selectAll();
				}
			}
		});
		avalista_localidade_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_localidade_textField.setColumns(10);
		avalista_localidade_textField.setBounds(259, 144, 86, 20);
		add(avalista_localidade_textField);

		avalista_CEP_textField = new JTextField();
		avalista_CEP_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_CEP_textField.getText().length()==0) {
					avalista_CEP_textField.setForeground(Color.LIGHT_GRAY);
					avalista_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					avalista_CEP_textField.setText("Digite o CEP");
				}	else {
					String sem_traco = avalista_CEP_textField.getText().replace("-", "");
					if(!StringUtils.isNumeric(sem_traco)) {
						avalista_CEP_textField.setBackground(Color.RED);
						avalista_CEP_textField.setForeground(Color.WHITE);
						avalista_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						avalista_CEP_textField.setToolTipText("Digite somente números");
					}	else if(sem_traco.length()!=8){
						avalista_CEP_textField.setBackground(Color.RED);
						avalista_CEP_textField.setForeground(Color.WHITE);
						avalista_CEP_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						avalista_CEP_textField.setToolTipText("Digite um CEP válido");
					}	else{
						avalista_CEP_textField.setBackground(Color.WHITE);
						avalista_CEP_textField.setForeground(Color.BLACK);
						avalista_CEP_textField.setText(formatar_textfield_CEP(avalista_CEP_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_CEP_textField.getBackground() == Color.RED) {
					avalista_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_CEP_textField.setBackground(Color.WHITE);
					avalista_CEP_textField.setForeground(Color.BLACK);
					avalista_CEP_textField.selectAll();
				}
				if(avalista_CEP_textField.getText().equals("Digite o CEP")) {
					avalista_CEP_textField.setText("");
					avalista_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_CEP_textField.setBackground(Color.WHITE);
					avalista_CEP_textField.setForeground(Color.BLACK);
					avalista_CEP_textField.selectAll();
				}
			}
		});
		avalista_CEP_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_CEP_textField.setColumns(10);
		avalista_CEP_textField.setBounds(259, 164, 86, 20);
		add(avalista_CEP_textField);

		avalista_bairro_textField = new JTextField();
		avalista_bairro_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_bairro_textField.getText().length()==0) {
					avalista_bairro_textField.setForeground(Color.LIGHT_GRAY);
					avalista_bairro_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					avalista_bairro_textField.setText("Digite o bairro");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_bairro_textField.getText().equals("Digite o bairro")) {
					avalista_bairro_textField.setText("");
					avalista_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_bairro_textField.setBackground(Color.WHITE);
					avalista_bairro_textField.setForeground(Color.BLACK);
					avalista_bairro_textField.selectAll();
				}
			}
		});
		avalista_bairro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_bairro_textField.setColumns(10);
		avalista_bairro_textField.setBounds(259, 184, 86, 20);
		add(avalista_bairro_textField);

		avalista_logradouro_textField = new JTextField();
		avalista_logradouro_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_logradouro_textField.getText().length()==0) {
					avalista_logradouro_textField.setForeground(Color.LIGHT_GRAY);
					avalista_logradouro_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					avalista_logradouro_textField.setText("Digite o logradouro");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_logradouro_textField.getText().equals("Digite o logradouro")) {
					avalista_logradouro_textField.setText("");
					avalista_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_logradouro_textField.setBackground(Color.WHITE);
					avalista_logradouro_textField.setForeground(Color.BLACK);
					avalista_logradouro_textField.selectAll();
				}
			}
		});
		avalista_logradouro_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_logradouro_textField.setColumns(10);
		avalista_logradouro_textField.setBounds(259, 204, 86, 20);
		add(avalista_logradouro_textField);

		avalista_numero_textField = new JTextField();
		avalista_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(avalista_numero_textField.getText().length()==0) {
					avalista_numero_textField.setForeground(Color.LIGHT_GRAY);
					avalista_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					avalista_numero_textField.setText("Digite o número");
				}	else {
					String sem_numero = avalista_numero_textField.getText().replace("s/n", "0");
					sem_numero = avalista_numero_textField.getText().replace("sn", "0");
					if(!StringUtils.isNumeric(sem_numero)) {
						avalista_numero_textField.setBackground(Color.RED);
						avalista_numero_textField.setForeground(Color.WHITE);
						avalista_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						avalista_numero_textField.setToolTipText("Digite somente números");
					}else{
						avalista_numero_textField.setBackground(Color.WHITE);
						avalista_numero_textField.setForeground(Color.BLACK);
						avalista_numero_textField.setText(formatar_textfield_numero(avalista_numero_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(avalista_numero_textField.getBackground() == Color.RED) {
					avalista_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_numero_textField.setBackground(Color.WHITE);
					avalista_numero_textField.setForeground(Color.BLACK);
					avalista_numero_textField.selectAll();
				}
				if(avalista_numero_textField.getText().equals("Digite o número")) {
					avalista_numero_textField.setText("");
					avalista_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					avalista_numero_textField.setBackground(Color.WHITE);
					avalista_numero_textField.setForeground(Color.BLACK);
					avalista_numero_textField.selectAll();
				}
			}
		});
		avalista_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		avalista_numero_textField.setColumns(10);
		avalista_numero_textField.setBounds(259, 224, 86, 20);
		add(avalista_numero_textField);

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

		JLabel conta_titulo_label = new JLabel("Dados da Conta Banc\u00E1ria");
		conta_titulo_label.setVerticalAlignment(SwingConstants.TOP);
		conta_titulo_label.setHorizontalAlignment(SwingConstants.CENTER);
		conta_titulo_label.setForeground(Color.BLACK);
		conta_titulo_label.setFont(new Font("SansSerif", Font.BOLD, 12));
		conta_titulo_label.setBackground(SystemColor.controlDkShadow);
		conta_titulo_label.setBounds(372, 118, 176, 14);
		add(conta_titulo_label);

		JLabel conta_numero_label = new JLabel("N\u00FAmero da Conta");
		conta_numero_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_label.setBounds(372, 146, 86, 14);
		add(conta_numero_label);

		JLabel conta_tipo_carteira_label = new JLabel("Tipo de Carteira");
		conta_tipo_carteira_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_tipo_carteira_label.setBounds(372, 166, 86, 14);
		add(conta_tipo_carteira_label);

		JLabel conta_dados_agencia_label = new JLabel("Dados da Ag\u00EAncia");
		conta_dados_agencia_label.setForeground(Color.GRAY);
		conta_dados_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_dados_agencia_label.setBounds(372, 185, 94, 14);
		add(conta_dados_agencia_label);

		JLabel conta_digito_agencia_label = new JLabel("D\u00EDgito");
		conta_digito_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_digito_agencia_label.setBounds(372, 205, 64, 14);
		add(conta_digito_agencia_label);

		JLabel conta_numero_agencia_label = new JLabel("N\u00FAmero");
		conta_numero_agencia_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_agencia_label.setBounds(372, 225, 46, 14);
		add(conta_numero_agencia_label);

		conta_numero_textField = new JTextField();
		conta_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(conta_numero_textField.getText().length()==0) {
					conta_numero_textField.setForeground(Color.LIGHT_GRAY);
					conta_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					conta_numero_textField.setText("Digite o número da conta");
				}	else {
					String sem_traco = conta_numero_textField.getText().replace("-", "");
					if(!StringUtils.isNumeric(sem_traco)) {
						conta_numero_textField.setBackground(Color.RED);
						conta_numero_textField.setForeground(Color.WHITE);
						conta_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						conta_numero_textField.setToolTipText("Digite somente números");
					}else if(sem_traco.length()==7){
						conta_numero_textField.setBackground(Color.WHITE);
						conta_numero_textField.setForeground(Color.BLACK);
						conta_numero_textField.setText(formatar_textfield_numero_conta(sem_traco));
					} else{					{
						conta_numero_textField.setBackground(Color.RED);
						conta_numero_textField.setForeground(Color.WHITE);
						conta_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						conta_numero_textField.setToolTipText("Digite uma conta válida");
					}
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(conta_numero_textField.getBackground() == Color.RED) {
					conta_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_numero_textField.setBackground(Color.WHITE);
					conta_numero_textField.setForeground(Color.BLACK);
					conta_numero_textField.selectAll();
				}
				if(conta_numero_textField.getText().equals("Digite o número da conta")) {
					conta_numero_textField.setText("");
					conta_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_numero_textField.setBackground(Color.WHITE);
					conta_numero_textField.setForeground(Color.BLACK);
					conta_numero_textField.selectAll();
				}
			}
		});
		conta_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_textField.setColumns(10);
		conta_numero_textField.setBounds(462, 144, 108, 20);
		add(conta_numero_textField);

		conta_tipo_carteira_textField = new JTextField();
		conta_tipo_carteira_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(conta_tipo_carteira_textField.getText().length()==0) {
					conta_tipo_carteira_textField.setForeground(Color.LIGHT_GRAY);
					conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					conta_tipo_carteira_textField.setText("Digite o tipo");
				}else{
					if(!StringUtils.isNumeric(conta_tipo_carteira_textField.getText()) ||
							conta_tipo_carteira_textField.getText().length()!=2){
						conta_tipo_carteira_textField.setBackground(Color.RED);
						conta_tipo_carteira_textField.setForeground(Color.WHITE);
						conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						conta_tipo_carteira_textField.setToolTipText("Digite somente n�meros");
					}
					conta_tipo_carteira_textField.setBackground(Color.WHITE);
					conta_tipo_carteira_textField.setForeground(Color.BLACK);
				}

			}
			@Override
			public void focusGained(FocusEvent e) {
				if(conta_tipo_carteira_textField.getBackground() == Color.RED) {
					conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_tipo_carteira_textField.setBackground(Color.WHITE);
					conta_tipo_carteira_textField.setForeground(Color.BLACK);
					conta_tipo_carteira_textField.selectAll();
				}
				if(conta_tipo_carteira_textField.getText().equals("Digite o tipo")) {
					conta_tipo_carteira_textField.setText("");
					conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_tipo_carteira_textField.setBackground(Color.WHITE);
					conta_tipo_carteira_textField.setForeground(Color.BLACK);
					conta_tipo_carteira_textField.selectAll();
				}
			}
		});
		conta_tipo_carteira_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_tipo_carteira_textField.setColumns(10);
		conta_tipo_carteira_textField.setBounds(462, 164, 108, 20);
		add(conta_tipo_carteira_textField);

		conta_digito_agencia_textField = new JTextField();
		conta_digito_agencia_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(conta_digito_agencia_textField.getText().length()==0) {
					conta_digito_agencia_textField.setForeground(Color.LIGHT_GRAY);
					conta_digito_agencia_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					conta_digito_agencia_textField.setText("Digite o digito");
				}	else {

					if(!StringUtils.isNumeric(conta_digito_agencia_textField.getText()) || conta_digito_agencia_textField.getText().length()>1) {
						conta_digito_agencia_textField.setBackground(Color.RED);
						conta_digito_agencia_textField.setForeground(Color.WHITE);
						conta_digito_agencia_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						conta_digito_agencia_textField.setToolTipText("Digite somente números");
					}else{
						conta_digito_agencia_textField.setBackground(Color.WHITE);
						conta_digito_agencia_textField.setForeground(Color.BLACK);
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(conta_digito_agencia_textField.getBackground() == Color.RED) {
					conta_digito_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_digito_agencia_textField.setBackground(Color.WHITE);
					conta_digito_agencia_textField.setForeground(Color.BLACK);
					conta_digito_agencia_textField.selectAll();
				}
				if(conta_digito_agencia_textField.getText().equals("Digite o digito")) {
					conta_digito_agencia_textField.setText("");
					conta_digito_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_digito_agencia_textField.setBackground(Color.WHITE);
					conta_digito_agencia_textField.setForeground(Color.BLACK);
					conta_digito_agencia_textField.selectAll();
				}
			}
		});
		conta_digito_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_digito_agencia_textField.setColumns(10);
		conta_digito_agencia_textField.setBounds(462, 204, 108, 20);
		add(conta_digito_agencia_textField);

		conta_numero_agencia_textField = new JTextField();
		conta_numero_agencia_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(conta_numero_agencia_textField.getText().length()==0) {
					conta_numero_agencia_textField.setForeground(Color.LIGHT_GRAY);
					conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					conta_numero_agencia_textField.setText("Digite o número");
				}	else {
					String sem_numero = conta_numero_agencia_textField.getText().replace("s/n", "0");
					sem_numero = conta_numero_agencia_textField.getText().replace("sn", "0");
					if(!StringUtils.isNumeric(sem_numero) || conta_numero_agencia_textField.getText().length()!=4) {
						conta_numero_agencia_textField.setBackground(Color.RED);
						conta_numero_agencia_textField.setForeground(Color.WHITE);
						conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						conta_numero_agencia_textField.setToolTipText("Digite somente números");
					}else{
						conta_numero_agencia_textField.setBackground(Color.WHITE);
						conta_numero_agencia_textField.setForeground(Color.BLACK);
						conta_numero_agencia_textField.setText(formatar_textfield_numero(conta_numero_agencia_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(conta_numero_agencia_textField.getBackground() == Color.RED) {
					conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_numero_agencia_textField.setBackground(Color.WHITE);
					conta_numero_agencia_textField.setForeground(Color.BLACK);
					conta_numero_agencia_textField.selectAll();
				}
				if(conta_numero_agencia_textField.getText().equals("Digite o número")) {
					conta_numero_agencia_textField.setText("");
					conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					conta_numero_agencia_textField.setBackground(Color.WHITE);
					conta_numero_agencia_textField.setForeground(Color.BLACK);
					conta_numero_agencia_textField.selectAll();
				}
			}
		});
		conta_numero_agencia_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		conta_numero_agencia_textField.setColumns(10);
		conta_numero_agencia_textField.setBounds(462, 224, 108, 20);
		add(conta_numero_agencia_textField);

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

		JLabel titulo_desconto_label = new JLabel("Desconto");
		titulo_desconto_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_desconto_label.setBounds(10, 440, 64, 14);
		add(titulo_desconto_label);

		JLabel titulo_deducao_label = new JLabel("Dedu\u00E7\u00E3o");
		titulo_deducao_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_deducao_label.setBounds(10, 460, 46, 14);
		add(titulo_deducao_label);

		JLabel titulo_mora_label = new JLabel("Mora");
		titulo_mora_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_mora_label.setBounds(10, 480, 46, 14);
		add(titulo_mora_label);

		JLabel titulo_acrescimo_label = new JLabel("Acr\u00E9scimo");
		titulo_acrescimo_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_acrescimo_label.setBounds(10, 500, 64, 14);
		add(titulo_acrescimo_label);

		JLabel titulo_valor_cobrado_label = new JLabel("Valor Cobrado");
		titulo_valor_cobrado_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_cobrado_label.setBounds(10, 520, 110, 14);
		add(titulo_valor_cobrado_label);

		titulo_numero_documento_textField = new JTextField();
		titulo_numero_documento_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_numero_documento_textField.getText().length()==0) {
					titulo_numero_documento_textField.setForeground(Color.LIGHT_GRAY);
					titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					titulo_numero_documento_textField.setText("Digite o número");
				}	else {
					if(!StringUtils.isNumeric(titulo_numero_documento_textField.getText())) {
						titulo_numero_documento_textField.setBackground(Color.RED);
						titulo_numero_documento_textField.setForeground(Color.WHITE);
						titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_numero_documento_textField.setToolTipText("Digite somente números");
					}else{
						titulo_numero_documento_textField.setBackground(Color.WHITE);
						titulo_numero_documento_textField.setForeground(Color.BLACK);
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_numero_documento_textField.getBackground() == Color.RED) {
					titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_numero_documento_textField.setBackground(Color.WHITE);
					titulo_numero_documento_textField.setForeground(Color.BLACK);
					titulo_numero_documento_textField.selectAll();
				}
				if(titulo_numero_documento_textField.getText().equals("Digite o número")) {
					titulo_numero_documento_textField.setText("");
					titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_numero_documento_textField.setBackground(Color.WHITE);
					titulo_numero_documento_textField.setForeground(Color.BLACK);
					titulo_numero_documento_textField.selectAll();
				}
			}
		});
		titulo_numero_documento_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_numero_documento_textField.setColumns(10);
		titulo_numero_documento_textField.setBounds(128, 280, 86, 20);
		add(titulo_numero_documento_textField);

		titulo_nosso_numero_textField = new JTextField();
		titulo_nosso_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_nosso_numero_textField.getText().length()==0)  {
					titulo_nosso_numero_textField.setForeground(Color.LIGHT_GRAY);
					titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					titulo_nosso_numero_textField.setText("Digite o número");
				}	else {
					if(titulo_nosso_numero_textField.getText().length()!=10 &&
							titulo_nosso_numero_textField.getText().length()!=7 &&
							titulo_nosso_numero_textField.getText().length()!=11 &&
							titulo_nosso_numero_textField.getText().length()!=17 &&
							titulo_nosso_numero_textField.getText().length()!=6) {

					}	else if(!StringUtils.isNumeric(titulo_nosso_numero_textField.getText())) {
						titulo_nosso_numero_textField.setBackground(Color.RED);
						titulo_nosso_numero_textField.setForeground(Color.WHITE);
						titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_nosso_numero_textField.setToolTipText("Digite somente números");
					}else{
						titulo_nosso_numero_textField.setBackground(Color.WHITE);
						titulo_nosso_numero_textField.setForeground(Color.BLACK);
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_nosso_numero_textField.getBackground() == Color.RED) {
					titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_nosso_numero_textField.setBackground(Color.WHITE);
					titulo_nosso_numero_textField.setForeground(Color.BLACK);
					titulo_nosso_numero_textField.selectAll();
				}
				if(titulo_nosso_numero_textField.getText().equals("Digite o número")) {
					titulo_nosso_numero_textField.setText("");
					titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_nosso_numero_textField.setBackground(Color.WHITE);
					titulo_nosso_numero_textField.setForeground(Color.BLACK);
					titulo_nosso_numero_textField.selectAll();
				}
			}
		});
		titulo_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_nosso_numero_textField.setColumns(10);
		titulo_nosso_numero_textField.setBounds(128, 300, 86, 20);
		add(titulo_nosso_numero_textField);

		titulo_digito_nosso_numero_textField = new JTextField();
		titulo_digito_nosso_numero_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_digito_nosso_numero_textField.getText().length()==0) {
					titulo_digito_nosso_numero_textField.setForeground(Color.LIGHT_GRAY);
					titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					titulo_digito_nosso_numero_textField.setText("Digite o digito");
				}	else {
					if(!StringUtils.isNumeric(titulo_digito_nosso_numero_textField.getText())) {
						titulo_digito_nosso_numero_textField.setBackground(Color.RED);
						titulo_digito_nosso_numero_textField.setForeground(Color.WHITE);
						titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_digito_nosso_numero_textField.setToolTipText("Digite somente números");
					}else{
						titulo_digito_nosso_numero_textField.setBackground(Color.WHITE);
						titulo_digito_nosso_numero_textField.setForeground(Color.BLACK);
						titulo_digito_nosso_numero_textField.setText(formatar_textfield_numero(titulo_digito_nosso_numero_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_digito_nosso_numero_textField.getBackground() == Color.RED) {
					titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_digito_nosso_numero_textField.setBackground(Color.WHITE);
					titulo_digito_nosso_numero_textField.setForeground(Color.BLACK);
					titulo_digito_nosso_numero_textField.selectAll();
				}
				if(titulo_digito_nosso_numero_textField.getText().equals("Digite o digito")) {
					titulo_digito_nosso_numero_textField.setText("");
					titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_digito_nosso_numero_textField.setBackground(Color.WHITE);
					titulo_digito_nosso_numero_textField.setForeground(Color.BLACK);
					titulo_digito_nosso_numero_textField.selectAll();
				}
			}
		});
		titulo_digito_nosso_numero_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_digito_nosso_numero_textField.setColumns(10);
		titulo_digito_nosso_numero_textField.setBounds(128, 320, 86, 20);
		add(titulo_digito_nosso_numero_textField);

		titulo_valor_textField = new JTextField();
		titulo_valor_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_valor_textField.getText().length()==0) {
					titulo_valor_textField.setForeground(Color.LIGHT_GRAY);
					titulo_valor_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					titulo_valor_textField.setText("Digite o valor");
				}	else {
					titulo_valor_textField.setText(titulo_valor_textField.getText().replace("$", ""));
					titulo_valor_textField.setText(titulo_valor_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_valor_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_valor_textField.getText(), "."); i++) {
							if((titulo_valor_textField.getText().length()-3) == titulo_valor_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_valor_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_valor_textField.getText().length()-2)==titulo_valor_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_valor_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_valor_textField.setText(titulo_valor_textField.getText().substring(0, titulo_valor_textField.getText().indexOf("."))+titulo_valor_textField.getText().substring((titulo_valor_textField.getText().indexOf(".")+1),titulo_valor_textField.getText().length()));
						}
					}
					titulo_valor_textField.setText(titulo_valor_textField.getText().replace(",","."));				
					String somente_numeros= titulo_valor_textField.getText().replace(".", "");

					if(titulo_valor_textField.getText().length()<3) {
						titulo_valor_textField.setText("00"+titulo_valor_textField.getText());
					}
					if(StringUtils.countMatches(titulo_valor_textField.getText(), ".")==1) {
						if(titulo_valor_textField.getText().indexOf(".") == (titulo_valor_textField.getText().length()-2)){
							titulo_valor_textField.setText(titulo_valor_textField.getText()+"0");
						}
						if(titulo_valor_textField.getText().indexOf(".") == (titulo_valor_textField.getText().length()-1)){
							titulo_valor_textField.setText(titulo_valor_textField.getText()+"00");
						}
					}	else {
						titulo_valor_textField.setText(titulo_valor_textField.getText()+".00");
					}
					titulo_valor_textField.setText(StringUtils.stripStart(titulo_valor_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_valor_textField.getText().substring((titulo_valor_textField.getText().length()-3), titulo_valor_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_valor_textField.getText(), ".")>1) {
						titulo_valor_textField.setText(somente_numeros);
						titulo_valor_textField.setBackground(Color.RED);
						titulo_valor_textField.setForeground(Color.WHITE);
						titulo_valor_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_valor_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_valor_textField.getText().contains(".")) {
							titulo_valor_textField.setText(titulo_valor_textField.getText()+",00");
						}	else {
							titulo_valor_textField.setText(titulo_valor_textField.getText().replace(".",","));	
						}
						titulo_valor_textField.setBackground(Color.WHITE);
						titulo_valor_textField.setForeground(Color.BLACK);
						titulo_valor_textField.setText(formatar_textfield_valor_dinheiro(titulo_valor_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_valor_textField.getBackground() == Color.RED) {
					titulo_valor_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_valor_textField.setBackground(Color.WHITE);
					titulo_valor_textField.setForeground(Color.BLACK);
					titulo_valor_textField.selectAll();
				}	else {

					if(titulo_valor_textField.getText().length()>0) {
						if(titulo_valor_textField.getText().substring(0, 2).equals("R$")) {
							titulo_valor_textField.setText(titulo_valor_textField.getText().substring(3, titulo_valor_textField.getText().length()));
							titulo_valor_textField.setText(titulo_valor_textField.getText().replace(".", ""));
							titulo_valor_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_valor_textField.setBackground(Color.WHITE);
							titulo_valor_textField.setForeground(Color.BLACK);
							titulo_valor_textField.selectAll();
						}	else if(titulo_valor_textField.getText().equals("Digite o valor")) {
							titulo_valor_textField.setText("");
							titulo_valor_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_valor_textField.setBackground(Color.WHITE);
							titulo_valor_textField.setForeground(Color.BLACK);
							titulo_valor_textField.selectAll();
						}
					}
				}
			}
		});
		titulo_valor_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_valor_textField.setColumns(10);
		titulo_valor_textField.setBounds(128, 340, 86, 20);
		add(titulo_valor_textField);

		JXDatePicker titulo_data_documento_picker = new JXDatePicker();
		titulo_data_documento_picker.setBounds(128, 360, 86, 20);
		titulo_data_documento_picker.getEditor().setEditable(false);
		titulo_data_documento_picker.setFont(new Font("SansSerif", Font.PLAIN, 9));
		titulo_data_documento_picker.setDate(Calendar.getInstance().getTime());
		titulo_data_documento_picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		add(titulo_data_documento_picker);

		JXDatePicker titulo_data_vencimento_picker = new JXDatePicker();
		titulo_data_vencimento_picker.setBounds(128, 380, 86, 20);
		titulo_data_vencimento_picker.getEditor().setEditable(false);
		titulo_data_vencimento_picker.setFont(new Font("SansSerif", Font.PLAIN, 9));
		titulo_data_vencimento_picker.setDate(Calendar.getInstance().getTime());
		titulo_data_vencimento_picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		add(titulo_data_vencimento_picker);

		JPanel gambiarra_panel = new JPanel();
		gambiarra_panel.setBounds(214, 400, 20, 20);
		add(gambiarra_panel);
<<<<<<< HEAD


		JComboBox titulo_tipo_documento_comboBox = new JComboBox();
		titulo_tipo_documento_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 9));
		titulo_tipo_documento_comboBox.setBounds(128, 400, 106, 20);
		titulo_tipo_documento_comboBox.getComponent(0).setVisible(false);
=======
		
        
        JComboBox titulo_tipo_documento_comboBox = new JComboBox();
        titulo_tipo_documento_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 9));
        titulo_tipo_documento_comboBox.setBounds(128, 400, 86, 20);
        titulo_tipo_documento_comboBox.getComponent(0).setVisible(false);
>>>>>>> 5aa93f00f16a579ca4a81ead271579ee63895e31
		titulo_tipo_documento_comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
				titulo_tipo_documento_comboBox.setBounds(128, 400, 106, 20);
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				gambiarra_panel.setBounds(214, 400, 20, 20);
				titulo_tipo_documento_comboBox.setBounds(128, 400, 106, 20);
				if(titulo_tipo_documento_comboBox.getSelectedIndex()== -1) {
					titulo_tipo_documento_comboBox.setModel(new DefaultComboBoxModel(TipoDeTitulo.values()));
					titulo_tipo_documento_comboBox.setSelectedIndex(0);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				gambiarra_panel.setBounds(214, 400, 0, 0);
				titulo_tipo_documento_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 9));
				titulo_tipo_documento_comboBox.setBounds(128, 400, 250, 20);
				titulo_tipo_documento_comboBox.repaint();
			}
		});
		titulo_tipo_documento_comboBox.setName(" ");
		titulo_tipo_documento_comboBox.setBackground(Color.WHITE);
		titulo_tipo_documento_comboBox.setModel(new DefaultComboBoxModel(TipoDeTitulo.values()));
		titulo_tipo_documento_comboBox.setToolTipText("Escolha o tipo de documento");
		add(titulo_tipo_documento_comboBox);
		titulo_tipo_documento_comboBox.setToolTipText("Escolha o tipo de documento");

		JComboBox titulo_aceite_comboBox = new JComboBox();
		titulo_aceite_comboBox.setFont(new Font("SansSerif", Font.PLAIN, 9));
		titulo_aceite_comboBox.setName(" ");
		titulo_aceite_comboBox.setBackground(Color.WHITE);
		titulo_aceite_comboBox.setModel(new DefaultComboBoxModel(EnumAceite.values()));
		titulo_aceite_comboBox.setBounds(128, 420, 86, 20);
		add(titulo_aceite_comboBox);
		titulo_aceite_comboBox.setToolTipText("Escolha o tipo de documento");

		titulo_desconto_textField = new JTextField();
		titulo_desconto_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_desconto_textField.getText().length()==0) {
					titulo_desconto_textField.setForeground(Color.LIGHT_GRAY);
					titulo_desconto_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
<<<<<<< HEAD
					titulo_desconto_textField.setText("Digite o desconto");
=======
					titulo_desconto_textField.setText("Digite a dedução");
>>>>>>> 5aa93f00f16a579ca4a81ead271579ee63895e31
				}	else {
					titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace("$", ""));
					titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_desconto_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_desconto_textField.getText(), "."); i++) {
							if((titulo_desconto_textField.getText().length()-3) == titulo_desconto_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_desconto_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_desconto_textField.getText().length()-2)==titulo_desconto_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_desconto_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_desconto_textField.setText(titulo_desconto_textField.getText().substring(0, titulo_desconto_textField.getText().indexOf("."))+titulo_desconto_textField.getText().substring((titulo_desconto_textField.getText().indexOf(".")+1),titulo_desconto_textField.getText().length()));
						}
					}
					titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace(",","."));				
					String somente_numeros= titulo_desconto_textField.getText().replace(".", "");

					if(titulo_desconto_textField.getText().length()<3) {
						titulo_desconto_textField.setText("00"+titulo_desconto_textField.getText());
					}
					if(StringUtils.countMatches(titulo_desconto_textField.getText(), ".")==1) {
						if(titulo_desconto_textField.getText().indexOf(".") == (titulo_desconto_textField.getText().length()-2)){
							titulo_desconto_textField.setText(titulo_desconto_textField.getText()+"0");
						}
						if(titulo_desconto_textField.getText().indexOf(".") == (titulo_desconto_textField.getText().length()-1)){
							titulo_desconto_textField.setText(titulo_desconto_textField.getText()+"00");
						}
					}	else {
						titulo_desconto_textField.setText(titulo_desconto_textField.getText()+".00");
					}
					titulo_desconto_textField.setText(StringUtils.stripStart(titulo_desconto_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_desconto_textField.getText().substring((titulo_desconto_textField.getText().length()-3), titulo_desconto_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_desconto_textField.getText(), ".")>1) {
						titulo_desconto_textField.setText(somente_numeros);
						titulo_desconto_textField.setBackground(Color.RED);
						titulo_desconto_textField.setForeground(Color.WHITE);
						titulo_desconto_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_desconto_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_desconto_textField.getText().contains(".")) {
							titulo_desconto_textField.setText(titulo_desconto_textField.getText()+",00");
						}	else {
							titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace(".",","));	
						}
						titulo_desconto_textField.setBackground(Color.WHITE);
						titulo_desconto_textField.setForeground(Color.BLACK);
						titulo_desconto_textField.setText(formatar_textfield_valor_dinheiro(titulo_desconto_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_desconto_textField.getBackground() == Color.RED) {
					titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_desconto_textField.setBackground(Color.WHITE);
					titulo_desconto_textField.setForeground(Color.BLACK);
					titulo_desconto_textField.selectAll();
				}	else {
<<<<<<< HEAD

					if(titulo_desconto_textField.getText().length()>0) {
						if(titulo_desconto_textField.getText().substring(0, 2).equals("R$")) {
							titulo_desconto_textField.setText(titulo_desconto_textField.getText().substring(3, titulo_desconto_textField.getText().length()));
							titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace(".", ""));
							titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_desconto_textField.setBackground(Color.WHITE);
							titulo_desconto_textField.setForeground(Color.BLACK);
							titulo_desconto_textField.selectAll();
						}	else if(titulo_desconto_textField.getText().equals("Digite o desconto")) {
							titulo_desconto_textField.setText("");
							titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_desconto_textField.setBackground(Color.WHITE);
							titulo_desconto_textField.setForeground(Color.BLACK);
							titulo_desconto_textField.selectAll();
						}
=======
					
				if(titulo_desconto_textField.getText().length()>0) {
					if(titulo_desconto_textField.getText().substring(0, 2).equals("R$")) {
						titulo_desconto_textField.setText(titulo_desconto_textField.getText().substring(3, titulo_desconto_textField.getText().length()));
						titulo_desconto_textField.setText(titulo_desconto_textField.getText().replace(".", ""));
						titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_desconto_textField.setBackground(Color.WHITE);
						titulo_desconto_textField.setForeground(Color.BLACK);
						titulo_desconto_textField.selectAll();
					}	else if(titulo_desconto_textField.getText().equals("Digite a dedução")) {
						titulo_desconto_textField.setText("");
						titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_desconto_textField.setBackground(Color.WHITE);
						titulo_desconto_textField.setForeground(Color.BLACK);
						titulo_desconto_textField.selectAll();
>>>>>>> 5aa93f00f16a579ca4a81ead271579ee63895e31
					}
				}
			}
		});
		titulo_desconto_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_desconto_textField.setColumns(10);
		titulo_desconto_textField.setBounds(128, 440, 86, 20);
		add(titulo_desconto_textField);

		titulo_deducao_textField = new JTextField();
		titulo_deducao_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_deducao_textField.getText().length()==0) {
					titulo_deducao_textField.setForeground(Color.LIGHT_GRAY);
					titulo_deducao_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					titulo_deducao_textField.setText("Digite a dedução");
				}	else {
					titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace("$", ""));
					titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_deducao_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_deducao_textField.getText(), "."); i++) {
							if((titulo_deducao_textField.getText().length()-3) == titulo_deducao_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_deducao_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_deducao_textField.getText().length()-2)==titulo_deducao_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_deducao_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_deducao_textField.setText(titulo_deducao_textField.getText().substring(0, titulo_deducao_textField.getText().indexOf("."))+titulo_deducao_textField.getText().substring((titulo_deducao_textField.getText().indexOf(".")+1),titulo_deducao_textField.getText().length()));
						}
					}
					titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace(",","."));				
					String somente_numeros= titulo_deducao_textField.getText().replace(".", "");

					if(titulo_deducao_textField.getText().length()<3) {
						titulo_deducao_textField.setText("00"+titulo_deducao_textField.getText());
					}
					if(StringUtils.countMatches(titulo_deducao_textField.getText(), ".")==1) {
						if(titulo_deducao_textField.getText().indexOf(".") == (titulo_deducao_textField.getText().length()-2)){
							titulo_deducao_textField.setText(titulo_deducao_textField.getText()+"0");
						}
						if(titulo_deducao_textField.getText().indexOf(".") == (titulo_deducao_textField.getText().length()-1)){
							titulo_deducao_textField.setText(titulo_deducao_textField.getText()+"00");
						}
					}	else {
						titulo_deducao_textField.setText(titulo_deducao_textField.getText()+".00");
					}
					titulo_deducao_textField.setText(StringUtils.stripStart(titulo_deducao_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_deducao_textField.getText().substring((titulo_deducao_textField.getText().length()-3), titulo_deducao_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_deducao_textField.getText(), ".")>1) {
						titulo_deducao_textField.setText(somente_numeros);
						titulo_deducao_textField.setBackground(Color.RED);
						titulo_deducao_textField.setForeground(Color.WHITE);
						titulo_deducao_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_deducao_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_deducao_textField.getText().contains(".")) {
							titulo_deducao_textField.setText(titulo_deducao_textField.getText()+",00");
						}	else {
							titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace(".",","));	
						}
						titulo_deducao_textField.setBackground(Color.WHITE);
						titulo_deducao_textField.setForeground(Color.BLACK);
						titulo_deducao_textField.setText(formatar_textfield_valor_dinheiro(titulo_deducao_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_deducao_textField.getBackground() == Color.RED) {
					titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_deducao_textField.setBackground(Color.WHITE);
					titulo_deducao_textField.setForeground(Color.BLACK);
					titulo_deducao_textField.selectAll();
				}	else {
<<<<<<< HEAD

					if(titulo_deducao_textField.getText().length()>0) {
						if(titulo_deducao_textField.getText().substring(0, 2).equals("R$")) {
							titulo_deducao_textField.setText(titulo_deducao_textField.getText().substring(3, titulo_deducao_textField.getText().length()));
							titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace(".", ""));
							titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_deducao_textField.setBackground(Color.WHITE);
							titulo_deducao_textField.setForeground(Color.BLACK);
							titulo_deducao_textField.selectAll();
						}	else if(titulo_deducao_textField.getText().equals("Digite a dedu��o")) {
							titulo_deducao_textField.setText("");
							titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_deducao_textField.setBackground(Color.WHITE);
							titulo_deducao_textField.setForeground(Color.BLACK);
							titulo_deducao_textField.selectAll();
						}
=======
					
				if(titulo_deducao_textField.getText().length()>0) {
					if(titulo_deducao_textField.getText().substring(0, 2).equals("R$")) {
						titulo_deducao_textField.setText(titulo_deducao_textField.getText().substring(3, titulo_deducao_textField.getText().length()));
						titulo_deducao_textField.setText(titulo_deducao_textField.getText().replace(".", ""));
						titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_deducao_textField.setBackground(Color.WHITE);
						titulo_deducao_textField.setForeground(Color.BLACK);
						titulo_deducao_textField.selectAll();
					}	else if(titulo_deducao_textField.getText().equals("Digite a dedução")) {
						titulo_deducao_textField.setText("");
						titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_deducao_textField.setBackground(Color.WHITE);
						titulo_deducao_textField.setForeground(Color.BLACK);
						titulo_deducao_textField.selectAll();
>>>>>>> 5aa93f00f16a579ca4a81ead271579ee63895e31
					}
				}
			}
		});
		titulo_deducao_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_deducao_textField.setColumns(10);
		titulo_deducao_textField.setBounds(128, 460, 86, 20);
		add(titulo_deducao_textField);

		titulo_mora_textField = new JTextField();
		titulo_mora_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_mora_textField.getText().length()==0) {
					titulo_mora_textField.setForeground(Color.LIGHT_GRAY);
					titulo_mora_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					titulo_mora_textField.setText("Digite a mora/multa");
				}	else {
					titulo_mora_textField.setText(titulo_mora_textField.getText().replace("$", ""));
					titulo_mora_textField.setText(titulo_mora_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_mora_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_mora_textField.getText(), "."); i++) {
							if((titulo_mora_textField.getText().length()-3) == titulo_mora_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_mora_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_mora_textField.getText().length()-2)==titulo_mora_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_mora_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_mora_textField.setText(titulo_mora_textField.getText().substring(0, titulo_mora_textField.getText().indexOf("."))+titulo_mora_textField.getText().substring((titulo_mora_textField.getText().indexOf(".")+1),titulo_mora_textField.getText().length()));
						}
					}
					titulo_mora_textField.setText(titulo_mora_textField.getText().replace(",","."));				
					String somente_numeros= titulo_mora_textField.getText().replace(".", "");

					if(titulo_mora_textField.getText().length()<3) {
						titulo_mora_textField.setText("00"+titulo_mora_textField.getText());
					}
					if(StringUtils.countMatches(titulo_mora_textField.getText(), ".")==1) {
						if(titulo_mora_textField.getText().indexOf(".") == (titulo_mora_textField.getText().length()-2)){
							titulo_mora_textField.setText(titulo_mora_textField.getText()+"0");
						}
						if(titulo_mora_textField.getText().indexOf(".") == (titulo_mora_textField.getText().length()-1)){
							titulo_mora_textField.setText(titulo_mora_textField.getText()+"00");
						}
					}	else {
						titulo_mora_textField.setText(titulo_mora_textField.getText()+".00");
					}
					titulo_mora_textField.setText(StringUtils.stripStart(titulo_mora_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_mora_textField.getText().substring((titulo_mora_textField.getText().length()-3), titulo_mora_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_mora_textField.getText(), ".")>1) {
						titulo_mora_textField.setText(somente_numeros);
						titulo_mora_textField.setBackground(Color.RED);
						titulo_mora_textField.setForeground(Color.WHITE);
						titulo_mora_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_mora_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_mora_textField.getText().contains(".")) {
							titulo_mora_textField.setText(titulo_mora_textField.getText()+",00");
						}	else {
							titulo_mora_textField.setText(titulo_mora_textField.getText().replace(".",","));	
						}
						titulo_mora_textField.setBackground(Color.WHITE);
						titulo_mora_textField.setForeground(Color.BLACK);
						titulo_mora_textField.setText(formatar_textfield_valor_dinheiro(titulo_mora_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_mora_textField.getBackground() == Color.RED) {
					titulo_mora_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_mora_textField.setBackground(Color.WHITE);
					titulo_mora_textField.setForeground(Color.BLACK);
					titulo_mora_textField.selectAll();
				}	else {

					if(titulo_mora_textField.getText().length()>0) {
						if(titulo_mora_textField.getText().substring(0, 2).equals("R$")) {
							titulo_mora_textField.setText(titulo_mora_textField.getText().substring(3, titulo_mora_textField.getText().length()));
							titulo_mora_textField.setText(titulo_mora_textField.getText().replace(".", ""));
							titulo_mora_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_mora_textField.setBackground(Color.WHITE);
							titulo_mora_textField.setForeground(Color.BLACK);
							titulo_mora_textField.selectAll();
						}	else if(titulo_mora_textField.getText().equals("Digite a mora/multa")) {
							titulo_mora_textField.setText("");
							titulo_mora_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_mora_textField.setBackground(Color.WHITE);
							titulo_mora_textField.setForeground(Color.BLACK);
							titulo_mora_textField.selectAll();
						}
					}
				}
			}
		});
		titulo_mora_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_mora_textField.setColumns(10);
		titulo_mora_textField.setBounds(128, 480, 86, 20);
		add(titulo_mora_textField);

		titulo_acrescimo_textField = new JTextField();
		titulo_acrescimo_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_acrescimo_textField.getText().length()==0) {
					titulo_acrescimo_textField.setForeground(Color.LIGHT_GRAY);
					titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.ITALIC, 9));
					titulo_acrescimo_textField.setText("Digite o acréscimo");
				}	else {
					titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace("$", ""));
					titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_acrescimo_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_acrescimo_textField.getText(), "."); i++) {
							if((titulo_acrescimo_textField.getText().length()-3) == titulo_acrescimo_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_acrescimo_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_acrescimo_textField.getText().length()-2)==titulo_acrescimo_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_acrescimo_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().substring(0, titulo_acrescimo_textField.getText().indexOf("."))+titulo_acrescimo_textField.getText().substring((titulo_acrescimo_textField.getText().indexOf(".")+1),titulo_acrescimo_textField.getText().length()));
						}
					}
					titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace(",","."));				
					String somente_numeros= titulo_acrescimo_textField.getText().replace(".", "");

					if(titulo_acrescimo_textField.getText().length()<3) {
						titulo_acrescimo_textField.setText("00"+titulo_acrescimo_textField.getText());
					}
					if(StringUtils.countMatches(titulo_acrescimo_textField.getText(), ".")==1) {
						if(titulo_acrescimo_textField.getText().indexOf(".") == (titulo_acrescimo_textField.getText().length()-2)){
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText()+"0");
						}
						if(titulo_acrescimo_textField.getText().indexOf(".") == (titulo_acrescimo_textField.getText().length()-1)){
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText()+"00");
						}
					}	else {
						titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText()+".00");
					}
					titulo_acrescimo_textField.setText(StringUtils.stripStart(titulo_acrescimo_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_acrescimo_textField.getText().substring((titulo_acrescimo_textField.getText().length()-3), titulo_acrescimo_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_acrescimo_textField.getText(), ".")>1) {
						titulo_acrescimo_textField.setText(somente_numeros);
						titulo_acrescimo_textField.setBackground(Color.RED);
						titulo_acrescimo_textField.setForeground(Color.WHITE);
						titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_acrescimo_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_acrescimo_textField.getText().contains(".")) {
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText()+",00");
						}	else {
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace(".",","));	
						}
						titulo_acrescimo_textField.setBackground(Color.WHITE);
						titulo_acrescimo_textField.setForeground(Color.BLACK);
						titulo_acrescimo_textField.setText(formatar_textfield_valor_dinheiro(titulo_acrescimo_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_acrescimo_textField.getBackground() == Color.RED) {
					titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_acrescimo_textField.setBackground(Color.WHITE);
					titulo_acrescimo_textField.setForeground(Color.BLACK);
					titulo_acrescimo_textField.selectAll();
				}	else {
<<<<<<< HEAD

					if(titulo_acrescimo_textField.getText().length()>0) {
						if(titulo_acrescimo_textField.getText().substring(0, 2).equals("R$")) {
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().substring(3, titulo_acrescimo_textField.getText().length()));
							titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace(".", ""));
							titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_acrescimo_textField.setBackground(Color.WHITE);
							titulo_acrescimo_textField.setForeground(Color.BLACK);
							titulo_acrescimo_textField.selectAll();
						}	else if(titulo_acrescimo_textField.getText().equals("Digite o acr�scimo")) {
							titulo_acrescimo_textField.setText("");
							titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_acrescimo_textField.setBackground(Color.WHITE);
							titulo_acrescimo_textField.setForeground(Color.BLACK);
							titulo_acrescimo_textField.selectAll();
						}
=======
					
				if(titulo_acrescimo_textField.getText().length()>0) {
					if(titulo_acrescimo_textField.getText().substring(0, 2).equals("R$")) {
						titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().substring(3, titulo_acrescimo_textField.getText().length()));
						titulo_acrescimo_textField.setText(titulo_acrescimo_textField.getText().replace(".", ""));
						titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_acrescimo_textField.setBackground(Color.WHITE);
						titulo_acrescimo_textField.setForeground(Color.BLACK);
						titulo_acrescimo_textField.selectAll();
					}	else if(titulo_acrescimo_textField.getText().equals("Digite o acréscimo")) {
						titulo_acrescimo_textField.setText("");
						titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
						titulo_acrescimo_textField.setBackground(Color.WHITE);
						titulo_acrescimo_textField.setForeground(Color.BLACK);
						titulo_acrescimo_textField.selectAll();
>>>>>>> 5aa93f00f16a579ca4a81ead271579ee63895e31
					}
				}
			}
		});
		titulo_acrescimo_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		titulo_acrescimo_textField.setColumns(10);
		titulo_acrescimo_textField.setBounds(128, 500, 86, 20);
		add(titulo_acrescimo_textField);

		titulo_valor_cobrado_textField = new JTextField();
		titulo_valor_cobrado_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(titulo_valor_cobrado_textField.getText().length()==0) {
					titulo_valor_cobrado_textField.setForeground(Color.LIGHT_GRAY);
					titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
					titulo_valor_cobrado_textField.setText("Digite o valor");
				}	else {
					titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().replace("$", ""));
					titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().replace("R", ""));
					if(StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), ".")>1) {
						for(int i=-1; i<StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), "."); i++) {
							if((titulo_valor_cobrado_textField.getText().length()-3) == titulo_valor_cobrado_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), ".")==1) {
									break;
								}	
							}else if((titulo_valor_cobrado_textField.getText().length()-2)==titulo_valor_cobrado_textField.getText().indexOf(".")) {
								if(StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), ".")==1) {
									break;
								}
							}
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().substring(0, titulo_valor_cobrado_textField.getText().indexOf("."))+titulo_valor_cobrado_textField.getText().substring((titulo_valor_cobrado_textField.getText().indexOf(".")+1),titulo_valor_cobrado_textField.getText().length()));
						}
					}
					titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().replace(",","."));				
					String somente_numeros= titulo_valor_cobrado_textField.getText().replace(".", "");

					if(titulo_valor_cobrado_textField.getText().length()<3) {
						titulo_valor_cobrado_textField.setText("00"+titulo_valor_cobrado_textField.getText());
					}
					if(StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), ".")==1) {
						if(titulo_valor_cobrado_textField.getText().indexOf(".") == (titulo_valor_cobrado_textField.getText().length()-2)){
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText()+"0");
						}
						if(titulo_valor_cobrado_textField.getText().indexOf(".") == (titulo_valor_cobrado_textField.getText().length()-1)){
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText()+"00");
						}
					}	else {
						titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText()+".00");
					}
					titulo_valor_cobrado_textField.setText(StringUtils.stripStart(titulo_valor_cobrado_textField.getText(), "0"));
					if(!StringUtils.isNumeric(somente_numeros) || 
							(!titulo_valor_cobrado_textField.getText().substring((titulo_valor_cobrado_textField.getText().length()-3), titulo_valor_cobrado_textField.getText().length()-2).equals(".")) 
							|| StringUtils.countMatches(titulo_valor_cobrado_textField.getText(), ".")>1) {
						titulo_valor_cobrado_textField.setText(somente_numeros);
						titulo_valor_cobrado_textField.setBackground(Color.RED);
						titulo_valor_cobrado_textField.setForeground(Color.WHITE);
						titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.ITALIC, 10));
						titulo_valor_cobrado_textField.setToolTipText("Digite somente números");
					}else{
						if(!titulo_valor_cobrado_textField.getText().contains(".")) {
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText()+",00");
						}	else {
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().replace(".",","));	
						}
						titulo_valor_cobrado_textField.setBackground(Color.WHITE);
						titulo_valor_cobrado_textField.setForeground(Color.BLACK);
						titulo_valor_cobrado_textField.setText(formatar_textfield_valor_dinheiro(titulo_valor_cobrado_textField.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(titulo_valor_cobrado_textField.getBackground() == Color.RED) {
					titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
					titulo_valor_cobrado_textField.setBackground(Color.WHITE);
					titulo_valor_cobrado_textField.setForeground(Color.BLACK);
					titulo_valor_cobrado_textField.selectAll();
				}	else {

					if(titulo_valor_cobrado_textField.getText().length()>0) {
						if(titulo_valor_cobrado_textField.getText().substring(0, 2).equals("R$")) {
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().substring(3, titulo_valor_cobrado_textField.getText().length()));
							titulo_valor_cobrado_textField.setText(titulo_valor_cobrado_textField.getText().replace(".",""));
							titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_valor_cobrado_textField.setBackground(Color.WHITE);
							titulo_valor_cobrado_textField.setForeground(Color.BLACK);
							titulo_valor_cobrado_textField.selectAll();
						}	else if(titulo_valor_cobrado_textField.getText().equals("Digite o valor")) {
							titulo_valor_cobrado_textField.setText("");
							titulo_valor_cobrado_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
							titulo_valor_cobrado_textField.setBackground(Color.WHITE);
							titulo_valor_cobrado_textField.setForeground(Color.BLACK);
							titulo_valor_cobrado_textField.selectAll();
						}
					}
				}
			}
		});
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

		JLabel boleto_instrucao_sacado_label = new JLabel("Instru\u00E7\u00E3o ao Sacado");
		boleto_instrucao_sacado_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao_sacado_label.setBounds(236, 300, 110, 14);
		add(boleto_instrucao_sacado_label);

		JLabel boleto_instrucao1_label = new JLabel("Instru\u00E7\u00E3o 1");
		boleto_instrucao1_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao1_label.setBounds(236, 320, 119, 14);
		add(boleto_instrucao1_label);

		JLabel boleto_instrucao2_label = new JLabel("Instru\u00E7\u00E3o 2");
		boleto_instrucao2_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao2_label.setBounds(236, 340, 110, 14);
		add(boleto_instrucao2_label);

		JLabel boleto_instrucao3_label = new JLabel("Instru\u00E7\u00E3o 3");
		boleto_instrucao3_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao3_label.setBounds(236, 360, 110, 14);
		add(boleto_instrucao3_label);

		JLabel boleto_instrucao4_label = new JLabel("Instru\u00E7\u00E3o 4");
		boleto_instrucao4_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao4_label.setBounds(236, 380, 110, 14);
		add(boleto_instrucao4_label);

		JLabel boleto_instrucao5_label = new JLabel("Instru\u00E7\u00E3o 5");
		boleto_instrucao5_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao5_label.setBounds(236, 400, 110, 14);
		add(boleto_instrucao5_label);

		JLabel boleto_instrucao6_label = new JLabel("Instru\u00E7\u00E3o 6");
		boleto_instrucao6_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao6_label.setBounds(236, 420, 86, 14);
		add(boleto_instrucao6_label);

		JLabel boleto_instrucao7_label = new JLabel("Instru\u00E7\u00E3o 7");
		boleto_instrucao7_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao7_label.setBounds(236, 440, 64, 14);
		add(boleto_instrucao7_label);

		JLabel boleto_instrucao8_label = new JLabel("Instru\u00E7\u00E3o 8");
		boleto_instrucao8_label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao8_label.setBounds(236, 460, 74, 14);
		add(boleto_instrucao8_label);

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

		boleto_instrucao3_textField = new JTextField();
		boleto_instrucao3_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao3_textField.setColumns(10);
		boleto_instrucao3_textField.setBounds(350, 360, 220, 20);
		add(boleto_instrucao3_textField);

		boleto_instrucao4_textField = new JTextField();
		boleto_instrucao4_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao4_textField.setColumns(10);
		boleto_instrucao4_textField.setBounds(350, 380, 220, 20);
		add(boleto_instrucao4_textField);

		boleto_instrucao5_textField = new JTextField();
		boleto_instrucao5_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao5_textField.setColumns(10);
		boleto_instrucao5_textField.setBounds(350, 400, 220, 20);
		add(boleto_instrucao5_textField);

		boleto_instrucao6_textField = new JTextField();
		boleto_instrucao6_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao6_textField.setColumns(10);
		boleto_instrucao6_textField.setBounds(350, 420, 220, 20);
		add(boleto_instrucao6_textField);

		boleto_instrucao7_textField = new JTextField();
		boleto_instrucao7_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao7_textField.setColumns(10);
		boleto_instrucao7_textField.setBounds(350, 440, 220, 20);
		add(boleto_instrucao7_textField);

		boleto_instrucao8_textField = new JTextField();
		boleto_instrucao8_textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		boleto_instrucao8_textField.setColumns(10);
		boleto_instrucao8_textField.setBounds(350, 460, 220, 20);
		add(boleto_instrucao8_textField);

		btnGerarBoleto = new JButton("Gerar Boleto");
		btnGerarBoleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// criando sacado
				boolean sacado_ok = false;
				if(sacado_nome_textField.getText().length()>0 && !sacado_nome_textField.getText().equals("Digite o nome") && sacado_nome_textField.getBackground()!= Color.RED) {
					if(sacado_CPF_textField.getText().length()>0 && !sacado_CPF_textField.getText().equals("Digite o nome") && sacado_CPF_textField.getBackground()!= Color.RED) {
						if(sacado_UF_comboBox.getSelectedItem().toString().length()>0) {
							if(sacado_localidade_textField.getText().length()>0 && !sacado_localidade_textField.getText().equals("Digite a localidade") && sacado_localidade_textField.getBackground()!= Color.RED) {
								if(sacado_CEP_textField.getText().length()>0 && !sacado_CEP_textField.getText().equals("Digite o CEP") && sacado_CEP_textField.getBackground()!= Color.RED) {
									if(sacado_bairro_textField.getText().length()>0 && !sacado_bairro_textField.getText().equals("Digite o bairro") && sacado_bairro_textField.getBackground()!= Color.RED) {
										if(sacado_logradouro_textField.getText().length()>0 && !sacado_logradouro_textField.getText().equals("Digite o bairro") && sacado_logradouro_textField.getBackground()!= Color.RED) {
											if(sacado_numero_textField.getText().length()>0 && !sacado_numero_textField.getText().equals("Digite o bairro") && sacado_numero_textField.getBackground()!= Color.RED) {
												sacado_ok=true;
											}
										}					
									}
								}
							}
						}
					}
				}

				boolean avalista_ok = false;
				if(avalista_nome_textField.getText().length()>0 && !avalista_nome_textField.getText().equals("Digite o nome") && avalista_nome_textField.getBackground()!= Color.RED) {
					if(avalista_CPF_textField.getText().length()>0 && !avalista_CPF_textField.getText().equals("Digite o CPF") && avalista_CPF_textField.getBackground()!= Color.RED) {
						if(avalista_UF_comboBox.getSelectedItem().toString().length()>0) {
							if(avalista_localidade_textField.getText().length()>0 && !avalista_localidade_textField.getText().equals("Digite a localidade") && avalista_localidade_textField.getBackground()!= Color.RED) {
								if(avalista_CEP_textField.getText().length()>0 && !avalista_CEP_textField.getText().equals("Digite o CEP") && avalista_CEP_textField.getBackground()!= Color.RED) {
									if(avalista_bairro_textField.getText().length()>0 && !avalista_bairro_textField.getText().equals("Digite o bairro") && avalista_bairro_textField.getBackground()!= Color.RED) {
										if(avalista_logradouro_textField.getText().length()>0 && !avalista_logradouro_textField.getText().equals("Digite o bairro") && avalista_logradouro_textField.getBackground()!= Color.RED) {
											if(avalista_numero_textField.getText().length()>0 && !avalista_numero_textField.getText().equals("Digite o bairro") && avalista_numero_textField.getBackground()!= Color.RED) {
												avalista_ok=true;
											}
										}					
									}
								}
							}
						}
					}
				}
				boolean cedente_ok = false;
				if(cedente_nome_textField.getText().length()>0 && !cedente_nome_textField.getText().equals("Digite o nome") && cedente_nome_textField.getBackground()!= Color.RED) {
					if(cedente_CNPJ_textField.getText().length()>0 && !cedente_CNPJ_textField.getText().equals("Digite o CNPJ") && cedente_CNPJ_textField.getBackground()!= Color.RED) {
						cedente_ok=true;
					}
				}

				boolean conta_ok = false;
				if(conta_numero_textField.getText().length()>0 && !avalista_nome_textField.getText().equals("Digite o n�mero da conta") && avalista_nome_textField.getBackground()!= Color.RED) {
					if(conta_tipo_carteira_textField.getText().length()>0 && !conta_tipo_carteira_textField.getText().equals("Digite o tipo") && conta_tipo_carteira_textField.getBackground()!= Color.RED) {
						if(conta_digito_agencia_textField.getText().length()>0 && !conta_digito_agencia_textField.getText().equals("Digite o digito") && conta_digito_agencia_textField.getBackground()!= Color.RED) {
							if(conta_numero_agencia_textField.getText().length()>0 && !conta_numero_agencia_textField.getText().equals("Digite o n�mero") && conta_numero_agencia_textField.getBackground()!= Color.RED) {
								conta_ok=true;
							}
						}
					}
				}

				boolean titulo_ok = false;
				if(titulo_numero_documento_textField.getText().length()>0 && !titulo_numero_documento_textField.getText().equals("Digite o n�mero") && titulo_numero_documento_textField.getBackground()!= Color.RED) {
					if(titulo_nosso_numero_textField.getText().length()>0 && !titulo_nosso_numero_textField.getText().equals("Digite o n�mero") && titulo_nosso_numero_textField.getBackground()!= Color.RED) {
						if(titulo_digito_nosso_numero_textField.getText().length()>0 && !titulo_digito_nosso_numero_textField.getText().equals("Digite o digito") && titulo_digito_nosso_numero_textField.getBackground()!= Color.RED) {
							if(titulo_valor_textField.getText().length()>0 && !titulo_valor_textField.getText().equals("Digite o valor") && titulo_valor_textField.getBackground()!= Color.RED) {
								if(titulo_data_documento_picker.getEditor().getText().length()>0) {					
									if(titulo_data_vencimento_picker.getEditor().getText().length()>0) {					
										if(titulo_desconto_textField.getText().length()>0 && !titulo_desconto_textField.getText().equals("Digite o desconto") && titulo_desconto_textField.getBackground()!= Color.RED) {
											if(titulo_deducao_textField.getText().length()>0 && !titulo_deducao_textField.getText().equals("Digite a dedu��o") && titulo_deducao_textField.getBackground()!= Color.RED) {
												if(titulo_mora_textField.getText().length()>0 && !titulo_mora_textField.getText().equals("Digite a mora/multa") && titulo_mora_textField.getBackground()!= Color.RED) {
													if(titulo_acrescimo_textField.getText().length()>0 && !titulo_acrescimo_textField.getText().equals("Digite o acr�scimo") && titulo_acrescimo_textField.getBackground()!= Color.RED) {
														if(titulo_valor_cobrado_textField.getText().length()>0 && !titulo_valor_cobrado_textField.getText().equals("Digite o valor") && titulo_valor_cobrado_textField.getBackground()!= Color.RED) {
															titulo_ok=true;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if(sacado_ok && avalista_ok && cedente_ok && conta_ok && titulo_ok) {

					Sacado sacado = new Sacado(sacado_nome_textField.getText(), sacado_CPF_textField.getText());
					Endereco enderecoSac = new Endereco();
					System.out.println(sacado_UF_comboBox.getSelectedItem().toString().substring((sacado_UF_comboBox.getSelectedItem().toString().length()-3),(sacado_UF_comboBox.getSelectedItem().toString().length()-1)));
					enderecoSac.setUF(UnidadeFederativa.valueOfSigla(sacado_UF_comboBox.getSelectedItem().toString().substring((sacado_UF_comboBox.getSelectedItem().toString().length()-3),(sacado_UF_comboBox.getSelectedItem().toString().length()-1))));
					enderecoSac.setLocalidade(sacado_localidade_textField.getText());
					enderecoSac.setCep(new CEP(sacado_CEP_textField.getText()));
					enderecoSac.setBairro(sacado_bairro_textField.getText());
					enderecoSac.setLogradouro(sacado_logradouro_textField.getText());
					enderecoSac.setNumero(sacado_numero_textField.getText());
					sacado.addEndereco(enderecoSac);

					SacadorAvalista sacadorAvalista = new SacadorAvalista(avalista_nome_textField.getText(), avalista_CPF_textField.getText());
					Endereco enderecoSacAval = new Endereco();
					enderecoSacAval.setUF(UnidadeFederativa.valueOfSigla(avalista_UF_comboBox.getSelectedItem().toString().substring((avalista_UF_comboBox.getSelectedItem().toString().length()-3),(avalista_UF_comboBox.getSelectedItem().toString().length()-1))));
					enderecoSacAval.setLocalidade(avalista_localidade_textField.getText());
					enderecoSacAval.setCep(new CEP(avalista_CEP_textField.getText()));
					enderecoSacAval.setBairro(avalista_bairro_textField.getText());
					enderecoSacAval.setLogradouro(avalista_logradouro_textField.getText());
					enderecoSacAval.setNumero(avalista_numero_textField.getText());
					sacadorAvalista.addEndereco(enderecoSacAval);

					Cedente cedente = new Cedente(cedente_nome_textField.getText(), cedente_CNPJ_textField.getText());

					ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.valueOf(comboBox.getSelectedItem().toString()).create());
					contaBancaria.setNumeroDaConta(new NumeroDaConta(Integer.parseInt(conta_numero_textField.getText().substring(0, 6)), conta_numero_textField.getText().substring(7, 8)));
					contaBancaria.setCarteira(new Carteira(Integer.parseInt(conta_tipo_carteira_textField.getText())));
					contaBancaria.setAgencia(new Agencia(Integer.parseInt(conta_numero_agencia_textField.getText()), conta_digito_agencia_textField.getText()));

					Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
					titulo.setNumeroDoDocumento(titulo_numero_documento_textField.getText());
					titulo.setNossoNumero(titulo_nosso_numero_textField.getText());
					titulo.setDigitoDoNossoNumero(titulo_digito_nosso_numero_textField.getText());
					titulo.setValor(BigDecimal.valueOf(Double.parseDouble(((titulo_valor_textField.getText().substring(3, titulo_valor_textField.getText().length()).replace(".", "").replace(",","."))))));
					titulo.setDataDoDocumento(titulo_data_documento_picker.getDate());
					titulo.setDataDoVencimento(titulo_data_vencimento_picker.getDate());
					titulo.setTipoDeDocumento(TipoDeTitulo.valueOf(titulo_tipo_documento_comboBox.getSelectedItem().toString()));
					titulo.setAceite(EnumAceite.valueOf(titulo_aceite_comboBox.getSelectedItem().toString()));
					titulo.setDesconto(BigDecimal.valueOf(Double.parseDouble(((titulo_desconto_textField.getText().substring(3, titulo_desconto_textField.getText().length()).replace(".", "").replace(",","."))))));
					titulo.setDeducao(BigDecimal.valueOf(Double.parseDouble(((titulo_deducao_textField.getText().substring(3, titulo_deducao_textField.getText().length()).replace(".", "").replace(",","."))))));
					titulo.setMora(BigDecimal.valueOf(Double.parseDouble(((titulo_mora_textField.getText().substring(3, titulo_mora_textField.getText().length()).replace(".", "").replace(",","."))))));
					titulo.setAcrecimo(BigDecimal.valueOf(Double.parseDouble(((titulo_acrescimo_textField.getText().substring(3, titulo_acrescimo_textField.getText().length()).replace(".", "").replace(",","."))))));
					titulo.setValorCobrado(BigDecimal.valueOf(Double.parseDouble(((titulo_valor_cobrado_textField.getText().substring(3, titulo_valor_cobrado_textField.getText().length()).replace(".", "").replace(",","."))))));

					Boleto boleto = new Boleto(titulo);

					boleto.setLocalPagamento(boleto_local_pagamento_textField.getText());
					boleto.setInstrucaoAoSacado(boleto_instrucao_sacado_textField.getText());
					boleto.setInstrucao1(boleto_instrucao1_textField.getText());
					boleto.setInstrucao2(boleto_instrucao2_textField.getText());
					boleto.setInstrucao3(boleto_instrucao3_textField.getText());
					boleto.setInstrucao4(boleto_instrucao4_textField.getText());
					boleto.setInstrucao5(boleto_instrucao5_textField.getText());
					boleto.setInstrucao6(boleto_instrucao6_textField.getText());
					boleto.setInstrucao7(boleto_instrucao7_textField.getText());
					boleto.setInstrucao8(boleto_instrucao8_textField.getText());

					BoletoViewer boletoViewer = new BoletoViewer(boleto);

					File arquivoPdf = boletoViewer.getPdfAsFile("MeuPrimeiroBoleto.pdf");
					mostreBoletoNaTela(arquivoPdf);
				}

			}
		});
		btnGerarBoleto.setBounds(429, 496, 119, 23);
		btnGerarBoleto.setBackground(Color.DARK_GRAY);
		btnGerarBoleto.setForeground(Color.WHITE);
		add(btnGerarBoleto);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, sacado_nome_textField, sacado_CPF_textField, sacado_UF_comboBox, sacado_localidade_textField, sacado_CEP_textField, sacado_bairro_textField, sacado_logradouro_textField, sacado_numero_textField, avalista_nome_textField, avalista_CPF_textField, avalista_UF_comboBox, avalista_localidade_textField, avalista_CEP_textField, avalista_bairro_textField, avalista_logradouro_textField, avalista_numero_textField, cedente_nome_textField, cedente_CNPJ_textField, conta_numero_textField, conta_tipo_carteira_textField, conta_digito_agencia_textField, conta_numero_agencia_textField, titulo_numero_documento_textField, titulo_nosso_numero_textField, titulo_digito_nosso_numero_textField, titulo_valor_textField, titulo_data_documento_picker, titulo_data_vencimento_picker, titulo_tipo_documento_comboBox, titulo_aceite_comboBox, titulo_desconto_textField, titulo_deducao_textField, titulo_mora_textField, titulo_acrescimo_textField, titulo_valor_cobrado_textField, boleto_local_pagamento_textField, boleto_instrucao_sacado_textField, boleto_instrucao1_textField, boleto_instrucao2_textField, boleto_instrucao3_textField, boleto_instrucao4_textField, boleto_instrucao5_textField, boleto_instrucao6_textField, boleto_instrucao7_textField, boleto_instrucao8_textField, btnGerarBoleto}));

	}

	public JButton getBtnGerarBoleto() {
		return btnGerarBoleto;
	}

	public void setBtnGerarBoleto(JButton btnGerarBoleto) {
		this.btnGerarBoleto = btnGerarBoleto;
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

	private String formatar_textfield_numero_conta(String textfield_text) {
		textfield_text = textfield_text.substring(0, (textfield_text.length()-1)) + "-" + textfield_text.substring((textfield_text.length()-1), textfield_text.length());
		return textfield_text;
	}

	private String formatar_textfield_valor_dinheiro(String textfield_text) {
		if(textfield_text.substring((textfield_text.length()-3), (textfield_text.length()-2)).equals(",")){
			textfield_text = textfield_text.substring(0, (textfield_text.length()-3))+textfield_text.substring((textfield_text.length()-2), textfield_text.length());
		}	else {
			textfield_text = textfield_text + "00";
		}
		double quantidade_de_pontos = (textfield_text.length()-2)%3;
		if(quantidade_de_pontos==0) {
			quantidade_de_pontos = ((textfield_text.length()-2)/3)-1;
		}	else {
			quantidade_de_pontos = Math.abs(((textfield_text.length()-2)/3));
		}

		for(int i=0; i<quantidade_de_pontos;i++) {
			textfield_text = textfield_text.substring(0,(textfield_text.length()-2-i-((i+1)*3)))+"."+textfield_text.substring((textfield_text.length()-2-i-((i+1)*3)), textfield_text.length());
		}
		textfield_text = textfield_text.substring(0,(textfield_text.length()-2))+","+textfield_text.substring((textfield_text.length()-2), textfield_text.length());;
		if(Double.parseDouble(StringUtils.replace(textfield_text.replace(".", ""), ",", "."))<1) {
			textfield_text = "0"+textfield_text;
		}
		return "R$ "+textfield_text;
	}

	private static void mostreBoletoNaTela(File arquivoBoleto) {

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try {
			desktop.open(arquivoBoleto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
