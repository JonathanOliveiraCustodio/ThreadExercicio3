package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CorridaSapoController;
import controller.ThreadCorridaSapos;


public class PrincipalCorridaSapos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSapo1 = new JLabel("Sapo 1");
	private JLabel lblSapo2 = new JLabel("Sapo 2");
	private JLabel lblSapo3 = new JLabel("Sapo 3");
	private JLabel lblSapo4 = new JLabel("Sapo 4");
	private	JLabel lblSapo5 = new JLabel("Sapo 5");
	private String Nome1="Sapo 1";
	private String Nome2="Sapo 2";
	private String Nome3="Sapo 3";
	private String Nome4="Sapo 4";
	private String Nome5="Sapo 5";
	private JButton btnReiniciar = new JButton("Reiniciar");
	private JButton btnIniciar = new JButton("Iniciar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCorridaSapos frame = new PrincipalCorridaSapos();
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
	public PrincipalCorridaSapos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent evt) {
	               dispose();

	            }
	        });
		
		setBounds(100, 100, 1213, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imgSapo = new ImageIcon("Sapo.png");
		lblSapo1.setIcon(imgSapo);
		lblSapo1.setBounds(32, 52, 64, 55);
		contentPane.add(lblSapo1);
		
		
		lblSapo2.setIcon(imgSapo);
		lblSapo2.setBounds(32, 131, 64, 55);
		contentPane.add(lblSapo2);
		
		lblSapo3.setIcon(imgSapo);
		lblSapo3.setBounds(32, 210, 64, 55);
		contentPane.add(lblSapo3);
		
		lblSapo4.setIcon(imgSapo);
		lblSapo4.setBounds(32, 290, 64, 55);
		contentPane.add(lblSapo4);
		
		lblSapo5.setIcon(imgSapo);
		lblSapo5.setBounds(32, 371, 64, 55);
		contentPane.add(lblSapo5);
		
		
		btnIniciar.setBounds(874, 11, 89, 23);
		contentPane.add(btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent args0) {
				CorridaSapoController Randomizar = new CorridaSapoController(lblSapo1,
						lblSapo2,lblSapo3,lblSapo4,lblSapo5,Nome1,Nome2,Nome3,Nome4,Nome5,btnIniciar,btnReiniciar);
				Randomizar.actionPerformed(null);	

			}

		});
		btnReiniciar.setEnabled(false);
	
		
		
		btnReiniciar.setBounds(973, 11, 89, 23);
		contentPane.add(btnReiniciar);
		
		JLabel label = new JLabel("<html>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|<br>|</html>");
		label.setVisible(false);
		label.setEnabled(false);
		label.setToolTipText("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(731, 44, 23, 401);
		contentPane.add(label);
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				ThreadCorridaSapos Limpar1 = new ThreadCorridaSapos(lblSapo1, Nome1, btnIniciar, btnReiniciar);
				ThreadCorridaSapos Limpar2 = new ThreadCorridaSapos(lblSapo2, Nome2, btnIniciar, btnReiniciar);
				ThreadCorridaSapos Limpar3 = new ThreadCorridaSapos(lblSapo3, Nome3, btnIniciar, btnReiniciar);
				ThreadCorridaSapos Limpar4 = new ThreadCorridaSapos(lblSapo4, Nome4, btnIniciar, btnReiniciar);
				ThreadCorridaSapos Limpar5 = new ThreadCorridaSapos(lblSapo5, Nome5, btnIniciar, btnReiniciar);
				
				Limpar1.Limpar();
				Limpar2.Limpar();
				Limpar3.Limpar();
				Limpar4.Limpar();
				Limpar5.Limpar();
			
			}

		});
		
	}
}
