import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 1287, 798);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel painel_inicial = new JPanel();
		painel_inicial.setBounds(0, 211, 1271, 547);
		frame.getContentPane().add(painel_inicial);
		painel_inicial.setLayout(null);
		
		JButton botao_novo_boleto = new JButton("Novo Boleto");
		botao_novo_boleto.setBounds(920, 211, 317, 136);
		painel_inicial.add(botao_novo_boleto);
		
		JButton botao_sair = new JButton("Sair");
		botao_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		botao_sair.setBounds(920, 400, 317, 136);
		painel_inicial.add(botao_sair);
		painel_inicial.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{botao_novo_boleto, botao_sair}));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 1271, 725);
		frame.getContentPane().add(panel);
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botao_novo_boleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				painel_inicial.setVisible(false);
				JOptionPane.showMessageDialog(null,"aehooo", "", 0);
			}
		});
		
	}
}
