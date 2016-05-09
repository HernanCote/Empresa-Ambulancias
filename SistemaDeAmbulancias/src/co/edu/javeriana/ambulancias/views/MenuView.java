package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import co.edu.javeriana.ambulancias.controllers.MenuController;

import javax.swing.JButton;

public class MenuView extends JPanel 
{

	private MenuController menuController;
	
	private JTabbedPane tabbedPane;
	
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
	public MenuView(JTabbedPane tabbedPane) 
	{
		this.setTabbedPane(tabbedPane);
		
		menuController = new MenuController(this);
		
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
		getBtnRegistrarPosAmbulancia().addActionListener(menuController);
		add(getBtnRegistrarPosAmbulancia());
		
		setBtnFinalizarServicio(new JButton("Finalizar Un Servicio"));
		getBtnFinalizarServicio().setBackground(Color.WHITE);
		getBtnFinalizarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnFinalizarServicio().setBounds(367, 142, 317, 49);
		getBtnFinalizarServicio().addActionListener(menuController);
		add(getBtnFinalizarServicio());
		
		setBtnRegistrarServicio(new JButton("Registrar un Servicio"));
		getBtnRegistrarServicio().setBackground(Color.WHITE);
		getBtnRegistrarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnRegistrarServicio().setBounds(40, 222, 317, 50);
		getBtnRegistrarServicio().addActionListener(menuController);
		add(getBtnRegistrarServicio());
		
		setBtnReporteServiciosAsignados(new JButton("Reporte de servicios con IPS y ambulancias asignados"));
		getBtnReporteServiciosAsignados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsignados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsignados().setBounds(367, 222, 317, 50);
		getBtnReporteServiciosAsignados().addActionListener(menuController);
		add(getBtnReporteServiciosAsignados());
		
		setBtnAsignarServicio(new JButton("Asignar a un servicio una ambulancias y una IPS"));
		getBtnAsignarServicio().setBackground(Color.WHITE);
		getBtnAsignarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnAsignarServicio().setBounds(40, 303, 317, 47);
		getBtnAsignarServicio().addActionListener(menuController);
		add(getBtnAsignarServicio());
		
		setBtnReporteServiciosAsociados(new JButton("Reporte de las IPS con servicios asociados"));
		getBtnReporteServiciosAsociados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsociados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsociados().setBounds(367, 303, 317, 47);
		getBtnReporteServiciosAsociados().addActionListener(menuController);
		add(getBtnReporteServiciosAsociados());
		
		setBtnIngresarIPSAmb(new JButton("Ingresar IPS y ambulancias"));
		getBtnIngresarIPSAmb().setBackground(new Color(64, 224, 208));
		getBtnIngresarIPSAmb().setBounds(155, 408, 202, 41);
		getBtnIngresarIPSAmb().addActionListener(menuController);
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



	public JTabbedPane getTabbedPane() 
	{
		return tabbedPane;
	}



	public void setTabbedPane(JTabbedPane tabbedPane) 
	{
		this.tabbedPane = tabbedPane;
	}
}
