package co.edu.javeriana.ambulancias.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelPrincipal panelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() 
	{
		setTitle("Sistema de Ambulancias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 628);
		
		panelPrincipal = new PanelPrincipal();
		panelPrincipal.setVisible(true);
		this.setContentPane(panelPrincipal);
		setResizable(false);
	}

}
