package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import co.edu.javeriana.ambulancias.controllers.IngresarIpsYAmbulanciasController;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;

public class IngresarIpsYAmbulanciasView extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IngresarIpsYAmbulanciasController ingresarIpsYAmbulanciasController;
	
	private JTabbedPane tabbedPane;
	
	private JButton btnRegresar;
	private JButton btnSeleccionarIps;
	private JButton btnSeleccionarAmbulancia;
	
	/**
	 * Create the panel.
	 */
	public IngresarIpsYAmbulanciasView(JTabbedPane tabbedPane, EmpresaAmbulancias empresaAmbulancias) 
	{
		
		setTabbedPane(tabbedPane);
		ingresarIpsYAmbulanciasController = new IngresarIpsYAmbulanciasController(this, empresaAmbulancias);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Ingresar IPS y Ambulancias");
		lblTitle.setForeground(new Color(139, 0, 0));
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTitle.setBounds(29, 22, 275, 29);
		add(lblTitle);
		
		setBtnRegresar(new JButton("Regresar"));
		getBtnRegresar().setForeground(new Color(245, 245, 220));
		getBtnRegresar().setBackground(new Color(178, 34, 34));
		getBtnRegresar().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		getBtnRegresar().setBounds(583, 444, 104, 41);
		getBtnRegresar().addActionListener(ingresarIpsYAmbulanciasController);
		add(getBtnRegresar());
		
		setBtnSeleccionarIps(new JButton("Seleccionar archivo de IPS"));
		getBtnSeleccionarIps().setBackground(new Color(245, 245, 245));
		getBtnSeleccionarIps().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnSeleccionarIps().setBounds(186, 154, 400, 46);
		getBtnSeleccionarIps().addActionListener(ingresarIpsYAmbulanciasController);
		add(getBtnSeleccionarIps());
		
		setBtnSeleccionarAmbulancia(new JButton("Seleccionar archivo de ambulancias"));
		getBtnSeleccionarAmbulancia().setBackground(new Color(245, 245, 245));
		getBtnSeleccionarAmbulancia().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnSeleccionarAmbulancia().setBounds(186, 265, 400, 46);
		getBtnSeleccionarAmbulancia().addActionListener(ingresarIpsYAmbulanciasController);
		add(getBtnSeleccionarAmbulancia());
	}
	
	
	public JTabbedPane getTabbedPane() 
	{
		return tabbedPane;
	}
	
	public void setTabbedPane(JTabbedPane tabbedPane) 
	{
		this.tabbedPane = tabbedPane;
	}

	

	public JButton getBtnRegresar() {
		return btnRegresar;
	}


	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}


	public JButton getBtnSeleccionarIps() {
		return btnSeleccionarIps;
	}


	public void setBtnSeleccionarIps(JButton btnSeleccionarIps) {
		this.btnSeleccionarIps = btnSeleccionarIps;
	}


	public JButton getBtnSeleccionarAmbulancia() {
		return btnSeleccionarAmbulancia;
	}


	public void setBtnSeleccionarAmbulancia(JButton btnSeleccionarAmbulancia) {
		this.btnSeleccionarAmbulancia = btnSeleccionarAmbulancia;
	}
}
