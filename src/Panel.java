import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JList;
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
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Panel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Create the panel.
	 */
	public Panel() {
		
		JLabel lblDadosDoSacado = new JLabel("Dados do sacado");
		lblDadosDoSacado.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDadosDoSacado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDoSacado.setForeground(Color.BLACK);
		lblDadosDoSacado.setBounds(10, 45, 134, 14);
		lblDadosDoSacado.setVerticalAlignment(SwingConstants.TOP);
		lblDadosDoSacado.setBackground(UIManager.getColor("Button.darkShadow"));
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField.setBounds(76, 70, 86, 20);
		textField.setColumns(10);
		
		JButton btnGerarBoleto = new JButton("Gerar Boleto");
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
		btnGerarBoleto.setBounds(321, 266, 119, 23);
		btnGerarBoleto.setBackground(Color.DARK_GRAY);
		btnGerarBoleto.setForeground(Color.WHITE);
		setLayout(null);
		add(lblDadosDoSacado);
		add(textField);
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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(76, 90, 86, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(76, 130, 86, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(76, 110, 86, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_4.setColumns(10);
		textField_4.setBounds(76, 210, 86, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_5.setColumns(10);
		textField_5.setBounds(76, 190, 86, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_6.setColumns(10);
		textField_6.setBounds(76, 170, 86, 20);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_7.setColumns(10);
		textField_7.setBounds(76, 150, 86, 20);
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
		textField_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_8.setColumns(10);
		textField_8.setBounds(331, 70, 86, 20);
		add(textField_8);
		
		textField_9 = new JTextField();
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
		textField_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textField_15.setColumns(10);
		textField_15.setBounds(331, 210, 86, 20);
		add(textField_15);

	}
}
