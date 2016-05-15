package co.edu.javeriana.ambulancias.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import co.edu.javeriana.ambulancias.controllers.Controller;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.entidades.IServiciosAmbulancias;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Controller controller; 
	private PanelPrincipal panelPrincipal;
	private IServiciosAmbulancias empresaAmbulancias;

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
		this.setEmpresaAmbulancias(new EmpresaAmbulancias("Ambulancias Penalosa y Cote"));
		this.setController(new Controller(this));
		
		setTitle("Sistema de Ambulancias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 50, 770, 628);
		
		setPanelPrincipal(new PanelPrincipal(this));
		getPanelPrincipal().setVisible(true);
		this.setContentPane(getPanelPrincipal());
		setResizable(false);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public EmpresaAmbulancias getEmpresaAmbulancias() {
		return (EmpresaAmbulancias)empresaAmbulancias;
	}

	public void setEmpresaAmbulancias(IServiciosAmbulancias empresaAmbulancias) {
		this.empresaAmbulancias = empresaAmbulancias;
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

}
