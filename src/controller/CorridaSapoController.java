package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CorridaSapoController implements ActionListener {

	private JLabel lblSapo1;
	private JLabel lblSapo2;
	private JLabel lblSapo3;
	private JLabel lblSapo4;
	private JLabel lblSapo5;
	private String Nome1;
	private String Nome2;
	private String Nome3;
	private String Nome4;
	private String Nome5;
	private JButton btnIniciar;
	private JButton btnReiniciar;


	public CorridaSapoController(JLabel lblSapo1,JLabel lblSapo2,JLabel lblSapo3,
			JLabel lblSapo4,JLabel lblSapo5,
			String Nome1,String Nome2,String Nome3,
			String Nome4,String Nome5, JButton btnIniciar, JButton btnReiniciar) {
	
		this.lblSapo1=lblSapo1;
		this.lblSapo2=lblSapo2;
		this.lblSapo3=lblSapo3;
		this.lblSapo4=lblSapo4;
		this.lblSapo5=lblSapo5;
		this.Nome1=Nome1;
		this.Nome2=Nome2;
		this.Nome3=Nome3;
		this.Nome4=Nome4;
		this.Nome5=Nome5;
		this.btnIniciar=btnIniciar;
		this.btnReiniciar=btnReiniciar;
	}

	
	private  void chamaThreads() {

		Thread t1 = new ThreadCorridaSapos(lblSapo1,Nome1,btnIniciar,btnReiniciar);
		Thread t2 = new ThreadCorridaSapos(lblSapo2,Nome2,btnIniciar,btnReiniciar);
		Thread t3 = new ThreadCorridaSapos(lblSapo3,Nome3,btnIniciar,btnReiniciar);
		Thread t4 = new ThreadCorridaSapos(lblSapo4,Nome4,btnIniciar,btnReiniciar);
		Thread t5 = new ThreadCorridaSapos(lblSapo5,Nome5,btnIniciar,btnReiniciar);	
		
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
 	}
	

	public void actionPerformed(ActionEvent arg0) {
		chamaThreads();

	}

}
