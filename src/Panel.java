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

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel lblDadosDoSacado;
	private JButton btnGerarBoleto;

	/**
	 * Create the panel.
	 */
	public Panel() {

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
		btnGerarBoleto.setBounds(298, 241, 119, 23);
		btnGerarBoleto.setBackground(Color.DARK_GRAY);
		btnGerarBoleto.setForeground(Color.WHITE);
		setLayout(null);
		add(lblDadosDoSacado);
		add(btnGerarBoleto);

		JLabel lblNome = new JLabel("CPF");
		lblNome.setBounds(10, 90, 46, 14);
		add(lblNome);

		JLabel label = new JLabel("Nome");
		label.setBounds(10, 70, 46, 14);
		add(label);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 130, 46, 14);
		add(lblUf);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 110, 64, 14);
		add(lblEndereo);

		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(10, 210, 46, 14);
		add(lblNmero);

		JLabel lblLocalidade = new JLabel("Localidade");
		lblLocalidade.setBounds(10, 150, 64, 14);
		add(lblLocalidade);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 170, 46, 14);
		add(lblCep);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 190, 46, 14);
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

		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(76, 110, 86, 20);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(76, 130, 86, 20);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(76, 150, 86, 20);
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
		textField_5.setBounds(76, 170, 86, 20);
		add(textField_5);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_6.setColumns(10);
		textField_6.setBounds(76, 190, 86, 20);
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
		textField_7.setBounds(76, 210, 86, 20);
		add(textField_7);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escolha seu banco");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "Bradesco", "Ita\u00FA", "Banco do Brasil", "HSBC", "Caixa Econ\u00F4mica Federal"}));
		comboBox.setBounds(210, 10, 100, 26);
		add(comboBox);

		JLabel lblEscolhaOBanco = new JLabel("Escolha o Banco:");
		lblEscolhaOBanco.setBounds(100, 15, 110, 16);
		add(lblEscolhaOBanco);

		JLabel lblDadosDoCedente = new JLabel("Dados do cedente");
		lblDadosDoCedente.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoCedente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoCedente.setForeground(Color.BLACK);
		lblDadosDoCedente.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoCedente.setBackground((Color) null);
		lblDadosDoCedente.setBounds(280, 45, 134, 14);
		add(lblDadosDoCedente);

		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(264, 70, 46, 14);
		add(label_1);

		JLabel label_2 = new JLabel("N\u00FAmero");
		label_2.setBounds(264, 210, 46, 14);
		add(label_2);

		JLabel label_3 = new JLabel("Bairro");
		label_3.setBounds(264, 190, 46, 14);
		add(label_3);

		JLabel label_4 = new JLabel("CEP");
		label_4.setBounds(264, 170, 46, 14);
		add(label_4);

		JLabel label_5 = new JLabel("Localidade");
		label_5.setBounds(264, 150, 64, 14);
		add(label_5);

		JLabel label_6 = new JLabel("UF");
		label_6.setBounds(264, 130, 46, 14);
		add(label_6);

		JLabel label_7 = new JLabel("Endere\u00E7o");
		label_7.setBounds(264, 110, 64, 14);
		add(label_7);

		JLabel label_8 = new JLabel("CPF");
		label_8.setBounds(264, 90, 46, 14);
		add(label_8);

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
		textField_8.setBounds(331, 70, 86, 20);
		add(textField_8);

		textField_9 = new JTextField();
		textField_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_9.getText().length()==0) {
					textField_9.setForeground(Color.LIGHT_GRAY);
					textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_9.setText("Digite o CPF");
				}	else {
					String sem_ponto_e_sem_traco = textField_9.getText().replace(".", "");
					sem_ponto_e_sem_traco = sem_ponto_e_sem_traco.replace("-", "");
					if(!StringUtils.isNumeric(sem_ponto_e_sem_traco)) {
						textField_9.setBackground(Color.RED);
						textField_9.setForeground(Color.WHITE);
						textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_9.setToolTipText("Digite somente números");
					}	else if(sem_ponto_e_sem_traco.length()!=11){
						textField_9.setBackground(Color.RED);
						textField_9.setForeground(Color.WHITE);
						textField_9.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_9.setToolTipText("Digite um CPF válido");
					}	else{
						textField_9.setBackground(Color.WHITE);
						textField_9.setForeground(Color.BLACK);
						textField_9.setText(formatar_textfield_CPF(textField_9.getText()));
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
				if(textField_9.getText().equals("Digite o CPF")) {
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
		textField_9.setBounds(331, 90, 86, 20);
		add(textField_9);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_10.setColumns(10);
		textField_10.setBounds(331, 110, 86, 20);
		add(textField_10);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_11.setColumns(10);
		textField_11.setBounds(331, 130, 86, 20);
		add(textField_11);

		textField_12 = new JTextField();
		textField_12.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_12.setColumns(10);
		textField_12.setBounds(331, 150, 86, 20);
		add(textField_12);

		textField_13 = new JTextField();
		textField_13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_13.getText().length()==0) {
					textField_13.setForeground(Color.LIGHT_GRAY);
					textField_13.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_13.setText("Digite o CEP");
				}	else {
					String sem_traco = textField_13.getText().replace("-", "");
					if(!StringUtils.isNumeric(sem_traco)) {
						textField_13.setBackground(Color.RED);
						textField_13.setForeground(Color.WHITE);
						textField_13.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_13.setToolTipText("Digite somente números");
					}	else if(sem_traco.length()!=8){
						textField_13.setBackground(Color.RED);
						textField_13.setForeground(Color.WHITE);
						textField_13.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_13.setToolTipText("Digite um CEP válido");
					}	else{
						textField_13.setBackground(Color.WHITE);
						textField_13.setForeground(Color.BLACK);
						textField_13.setText(formatar_textfield_CEP(textField_13.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_13.getBackground() == Color.RED) {
					textField_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_13.setBackground(Color.WHITE);
					textField_13.setForeground(Color.BLACK);
					textField_13.selectAll();
				}
				if(textField_13.getText().equals("Digite o CEP")) {
					textField_13.setText("");
					textField_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_13.setBackground(Color.WHITE);
					textField_13.setForeground(Color.BLACK);
					textField_13.selectAll();
				}
			}
		});
		textField_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_13.setColumns(10);
		textField_13.setBounds(331, 170, 86, 20);
		add(textField_13);

		textField_14 = new JTextField();
		textField_14.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_14.setColumns(10);
		textField_14.setBounds(331, 190, 86, 20);
		add(textField_14);

		textField_15 = new JTextField();
		textField_15.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_15.getText().length()==0) {
					textField_15.setForeground(Color.LIGHT_GRAY);
					textField_15.setFont(new Font("SansSerif", Font.ITALIC, 10));
					textField_15.setText("Digite o Número");
				}	else {
					String sem_numero = textField_15.getText().replace("s/n", "0");
					sem_numero = textField_15.getText().replace("sn", "0");
					if(!StringUtils.isNumeric(sem_numero)) {
						textField_15.setBackground(Color.RED);
						textField_15.setForeground(Color.WHITE);
						textField_15.setFont(new Font("SansSerif", Font.ITALIC, 10));
						textField_15.setToolTipText("Digite somente números");
					}else{
						textField_15.setBackground(Color.WHITE);
						textField_15.setForeground(Color.BLACK);
						textField_15.setText(formatar_textfield_numero(textField_15.getText()));
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_15.getBackground() == Color.RED) {
					textField_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_15.setBackground(Color.WHITE);
					textField_15.setForeground(Color.BLACK);
					textField_15.selectAll();
				}
				if(textField_15.getText().equals("Digite o Número")) {
					textField_15.setText("");
					textField_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
					textField_15.setBackground(Color.WHITE);
					textField_15.setForeground(Color.BLACK);
					textField_15.selectAll();
				}
			}
		});
		textField_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_15.setColumns(10);
		textField_15.setBounds(331, 210, 86, 20);
		add(textField_15);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13, textField_14, textField_15, btnGerarBoleto}));

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
