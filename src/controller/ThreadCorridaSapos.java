package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;




public class ThreadCorridaSapos extends Thread {
	private JLabel lblSapo;
	private String Nome;
	private JButton btnIniciar;
	private JButton btnReiniciar;
	int distanciaCorrida = 0;		// dist�ncia j� corrida pelo sapo
	int distanciaTotalCorrida=70;	// dist�ncia a ser corrida pelo sapo
	int pulo = 0;					// pulo do sapo em cm
	int pulos = 0;					// quantidades de pulos dados na corrida
	static int colocacao = 0;		// coloca��o do sapo ao final da corrida
	final static int PULO_MAXIMO = 7; // pulo m�ximo em cm que um sapo pode dar
	
	//VencedorDragRacer Vencedor=new VencedorDragRacer();
	
	public ThreadCorridaSapos(JLabel lblSapo,String Nome, JButton btnIniciar, JButton btnReiniciar) {

		this.lblSapo=lblSapo;
		this.Nome=Nome;
		this.btnIniciar=btnIniciar;
		this.btnReiniciar=btnReiniciar;
		btnIniciar.setEnabled(true);
		btnReiniciar.setEnabled(false);
	
	}
	public void Limpar() {
		Rectangle dimensoes = lblSapo.getBounds();
		distanciaCorrida = 0;	
		distanciaTotalCorrida=0;	
		colocacao = 0;	
		dimensoes.x=66;
		lblSapo.setBounds(dimensoes);
	   btnIniciar.setEnabled(true);
		btnReiniciar.setEnabled(false);
		
	}
	

	public void sapoImprimindoSituacao () {
		System.out.println("O " + Nome +  " pulou " + pulo + " e já percorreu " +
							distanciaCorrida + "m");
	}
	

	public void sapoPulando() {
		btnIniciar.setEnabled(false);
	
	
		Rectangle dimensoes = lblSapo.getBounds();
		dimensoes = lblSapo.getBounds();
		pulos++;
		pulo = (int) (Math.random() * PULO_MAXIMO);
		distanciaCorrida += pulo;
    	dimensoes.x += distanciaCorrida;			
    	lblSapo.setBounds(dimensoes);
    	try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
	}

	public void sapoDescansando () {
		// Método que passa vez a outras threads */
		yield();
	}
	
	public void Colocacao () {
		colocacao++;
		System.out.println(Nome + " foi o " + colocacao + 
							"° colocado com " + pulos + " pulos");
	}
	

	public void run () {
		while (distanciaCorrida < distanciaTotalCorrida) {
			sapoPulando();
			sapoImprimindoSituacao();
			sapoDescansando();
		}
		Colocacao();
		
		
		btnIniciar.setEnabled(false);
		btnReiniciar.setEnabled(true);
	
	}
	
}
