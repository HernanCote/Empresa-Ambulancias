package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import co.edu.javeriana.ambulancias.controllers.MenuController;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

import javax.swing.JButton;

public class MenuView extends JPanel 
{

	
	private VentanaPrincipal ventanaPrincipal;
	
	private JButton btnRegistrarPosAmbulancia;
	private JButton btnFinalizarServicio;
	private JButton btnRegistrarServicio;
	private JButton btnReporteServiciosAsignados;
	private JButton btnAsignarServicio;
	private JButton btnReporteServiciosAsociados;
	private JButton btnIngresarIPSAmb;
	
	
	/**
	 * Create the panel.
	 */
	public MenuView(VentanaPrincipal ventanaPrincipal) 
	{
		this.setVentanaPrincipal(ventanaPrincipal);
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("SERVICIOS DEL SISTEMA DE AMBULANCIAS");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(219, 50, 317, 14);
		add(lblNewLabel);
		
		setBtnRegistrarPosAmbulancia(new JButton("Registrar la posicion actual de una ambulancia"));
		getBtnRegistrarPosAmbulancia().setBackground(Color.WHITE);
		getBtnRegistrarPosAmbulancia().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnRegistrarPosAmbulancia().setBounds(40, 142, 317, 49);
		getBtnRegistrarPosAmbulancia().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnRegistrarPosAmbulancia());
		
		setBtnFinalizarServicio(new JButton("Finalizar Un Servicio"));
		getBtnFinalizarServicio().setBackground(Color.WHITE);
		getBtnFinalizarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnFinalizarServicio().setBounds(367, 142, 317, 49);
		getBtnFinalizarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnFinalizarServicio());
		
		setBtnRegistrarServicio(new JButton("Registrar un Servicio"));
		getBtnRegistrarServicio().setBackground(Color.WHITE);
		getBtnRegistrarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnRegistrarServicio().setBounds(40, 222, 317, 50);
		getBtnRegistrarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnRegistrarServicio());
		
		setBtnReporteServiciosAsignados(new JButton("Reporte de servicios con IPS y ambulancias asignados"));
		getBtnReporteServiciosAsignados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsignados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsignados().setBounds(367, 222, 317, 50);
		getBtnReporteServiciosAsignados().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnReporteServiciosAsignados());
		
		setBtnAsignarServicio(new JButton("Asignar a un servicio una ambulancias y una IPS"));
		getBtnAsignarServicio().setBackground(Color.WHITE);
		getBtnAsignarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnAsignarServicio().setBounds(40, 303, 317, 47);
		getBtnAsignarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnAsignarServicio());
		
		setBtnReporteServiciosAsociados(new JButton("Reporte de las IPS con servicios asociados"));
		getBtnReporteServiciosAsociados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsociados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsociados().setBounds(367, 303, 317, 47);
		getBtnReporteServiciosAsociados().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnReporteServiciosAsociados());
		
		setBtnIngresarIPSAmb(new JButton("Ingresar IPS y ambulancias"));
		getBtnIngresarIPSAmb().setBackground(new Color(64, 224, 208));
		getBtnIngresarIPSAmb().setBounds(155, 408, 202, 41);
		getBtnIngresarIPSAmb().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnIngresarIPSAmb());
	}
	
	
	
	public JButton getBtnRegistrarPosAmbulancia()
	{
		return btnRegistrarPosAmbulancia;
	}
	
	public void setBtnRegistrarPosAmbulancia(JButton btnRegistrarPosAmbulancia) 
	{
		this.btnRegistrarPosAmbulancia = btnRegistrarPosAmbulancia;
	}



	public JButton getBtnFinalizarServicio() 
	{
		return btnFinalizarServicio;
	}



	public void setBtnFinalizarServicio(JButton btnFinalizarServicio)
	{
		this.btnFinalizarServicio = btnFinalizarServicio;
	}



	public JButton getBtnRegistrarServicio() 
	{
		return btnRegistrarServicio;
	}



	public void setBtnRegistrarServicio(JButton btnRegistrarServicio) 
	{
		this.btnRegistrarServicio = btnRegistrarServicio;
	}



	public JButton getBtnReporteServiciosAsignados()
	{
		return btnReporteServiciosAsignados;
	}



	public void setBtnReporteServiciosAsignados(JButton btnReporteServiciosAsignados)
	{
		this.btnReporteServiciosAsignados = btnReporteServiciosAsignados;
	}



	public JButton getBtnAsignarServicio() 
	{
		return btnAsignarServicio;
	}



	public void setBtnAsignarServicio(JButton btnAsignarServicio)
	{
		this.btnAsignarServicio = btnAsignarServicio;
	}



	public JButton getBtnReporteServiciosAsociados() 
	{
		return btnReporteServiciosAsociados;
	}



	public void setBtnReporteServiciosAsociados(JButton btnReporteServiciosAsociados) 
	{
		this.btnReporteServiciosAsociados = btnReporteServiciosAsociados;
	}



	public JButton getBtnIngresarIPSAmb()
	{
		return btnIngresarIPSAmb;
	}



	public void setBtnIngresarIPSAmb(JButton btnIngresarIPSAmb) 
	{
		this.btnIngresarIPSAmb = btnIngresarIPSAmb;
	}



	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}



	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
}
