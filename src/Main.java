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

public class Main {

	private JFrame frame;

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
		painel_inicial.setBounds(0, 0, 560, 545);
		frame.getContentPane().add(painel_inicial);
		painel_inicial.setLayout(null);
		
		JButton botao_novo_boleto = new JButton("Novo Boleto");
		botao_novo_boleto.setBounds(422, 454, 110, 23);
		painel_inicial.add(botao_novo_boleto);
		
		JButton botao_sair = new JButton("Sair");
		botao_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		botao_sair.setBounds(422, 496, 110, 23);
		painel_inicial.add(botao_sair);
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
