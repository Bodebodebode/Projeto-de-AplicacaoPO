import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
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
import javax.swing.border.BevelBorder;

public class Main {

	private JFrame frame;
	private JTextField txtSistemaParaGerao;
	private JTextField txtRodrigoBorges;
	private JTextField txtAlunos;
	private JTextField txtProf;
	private JTextField txtProfessorarenatabraga;
	private JTextField txtGithubcombodebodebode;
	private JTextField txtGithubcomarturfrazao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 594, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel painel_inicial = new JPanel();
		painel_inicial.setBackground(UIManager.getColor("Panel.background"));
		painel_inicial.setBounds(0, 0, 588, 545);
		frame.getContentPane().add(painel_inicial);
		painel_inicial.setLayout(null);
		
		JButton botao_novo_boleto = new JButton("Novo Boleto");
		botao_novo_boleto.setFont(new Font("DejaVu Sans Condensed", Font.ITALIC, 22));
		botao_novo_boleto.setBounds(189, 388, 208, 61);
		painel_inicial.add(botao_novo_boleto);
		
		JButton botao_sair = new JButton("Sair");
		botao_sair.setFont(new Font("DejaVu Sans Condensed", Font.ITALIC, 22));
		botao_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		botao_sair.setBounds(189, 460, 208, 61);
		painel_inicial.add(botao_sair);
		
		txtSistemaParaGerao = new JTextField();
		txtSistemaParaGerao.setFont(new Font("DejaVu Sans", Font.BOLD, 21));
		txtSistemaParaGerao.setHorizontalAlignment(SwingConstants.CENTER);
		txtSistemaParaGerao.setEditable(false);
		txtSistemaParaGerao.setText("Sistema para gera\u00E7\u00E3o de Boletos Banc\u00E1rios");
		txtSistemaParaGerao.setBounds(10, 10, 559, 87);
		painel_inicial.add(txtSistemaParaGerao);
		txtSistemaParaGerao.setColumns(10);
		
		txtRodrigoBorges = new JTextField();
		txtRodrigoBorges.setBackground(new Color(255, 255, 204));
		txtRodrigoBorges.setEditable(false);
		txtRodrigoBorges.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtRodrigoBorges.setText("Rodrigo Borges");
		txtRodrigoBorges.setBounds(32, 259, 282, 30);
		painel_inicial.add(txtRodrigoBorges);
		txtRodrigoBorges.setColumns(10);
		
		txtAlunos = new JTextField();
		txtAlunos.setBackground(new Color(255, 255, 204));
		txtAlunos.setEditable(false);
		txtAlunos.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtAlunos.setText("Alunos: Artur Fraz\u00E3o");
		txtAlunos.setBounds(32, 208, 282, 30);
		painel_inicial.add(txtAlunos);
		txtAlunos.setColumns(10);
		
		txtProf = new JTextField();
		txtProf.setBackground(new Color(255, 255, 204));
		txtProf.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtProf.setEditable(false);
		txtProf.setText("Prof: Dr.\u00AA Renata Dutra Braga");
		txtProf.setBounds(32, 155, 282, 30);
		painel_inicial.add(txtProf);
		txtProf.setColumns(10);
		
		txtProfessorarenatabraga = new JTextField();
		txtProfessorarenatabraga.setEditable(false);
		txtProfessorarenatabraga.setBackground(new Color(255, 255, 0));
		txtProfessorarenatabraga.setHorizontalAlignment(SwingConstants.LEFT);
		txtProfessorarenatabraga.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtProfessorarenatabraga.setText("github.com/professorarenatabraga");
		txtProfessorarenatabraga.setBounds(144, 184, 291, 25);
		painel_inicial.add(txtProfessorarenatabraga);
		txtProfessorarenatabraga.setColumns(10);
		
		txtGithubcombodebodebode = new JTextField();
		txtGithubcombodebodebode.setEditable(false);
		txtGithubcombodebodebode.setForeground(new Color(0, 0, 0));
		txtGithubcombodebodebode.setBackground(new Color(255, 255, 0));
		txtGithubcombodebodebode.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtGithubcombodebodebode.setText("github.com/bodebodebode");
		txtGithubcombodebodebode.setHorizontalAlignment(SwingConstants.LEFT);
		txtGithubcombodebodebode.setBounds(144, 288, 291, 23);
		painel_inicial.add(txtGithubcombodebodebode);
		txtGithubcombodebodebode.setColumns(10);
		
		txtGithubcomarturfrazao = new JTextField();
		txtGithubcomarturfrazao.setEditable(false);
		txtGithubcomarturfrazao.setBackground(new Color(255, 255, 0));
		txtGithubcomarturfrazao.setHorizontalAlignment(SwingConstants.LEFT);
		txtGithubcomarturfrazao.setFont(new Font("DejaVu Serif", Font.BOLD, 15));
		txtGithubcomarturfrazao.setText("github.com/arturfrazao");
		txtGithubcomarturfrazao.setBounds(144, 237, 291, 23);
		painel_inicial.add(txtGithubcomarturfrazao);
		txtGithubcomarturfrazao.setColumns(10);
		painel_inicial.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{botao_novo_boleto, botao_sair}));
		
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botao_novo_boleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				painel_inicial.setVisible(false);
				Panel painel_gerar_boleto = new Panel();
				painel_gerar_boleto.setBounds(0, 0, 1280, 720);
				painel_gerar_boleto.setVisible(true);
				frame.getContentPane().add(painel_gerar_boleto);
				frame.repaint();
			}
		});
		
	}
}
