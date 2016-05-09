package co.edu.javeriana.ambulancias.presentacion;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTabbedPane;

import co.edu.javeriana.ambulancias.controllers.MenuController;
import co.edu.javeriana.ambulancias.views.*;

public class PanelPrincipal extends JPanel 
{

	private JTabbedPane tabbedPane;
	private MenuView tabMenuServicios;
	private IngresarIpsYAmbulanciasView tabIngresarIpsAmbulancias;
	private RegistrarPosicionAmbulanciaView tabRegistrarPosicionAmbulancia;
	private RegistrarUnServicioView tabRegistrarUnServicio;
	private AsignarServicioView tabAsignarServicio;
	private FinalizarServicioView tabFinalizarServicio;
	private ReporteServiciosAsignados tabReporteServiciosConIpsYAmbulanciasAsignados;
	private ReporteServiciosAsociados tabReporteDeIpsConServiciosAsociados;
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() 
	{		
		setBounds(100, 100, 670, 528);
		setBackground(Color.WHITE);
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 740, 578);
		add(tabbedPane);
		
		//----------------------------------------------------
		//----------------------------------------------------
		
		tabMenuServicios = new MenuView(tabbedPane);		
		tabbedPane.addTab("Menu de Servicios", null, tabMenuServicios, null);
		
		//------------------------------------------------------------------------------		
		
					
		tabIngresarIpsAmbulancias = new IngresarIpsYAmbulanciasView();		
		tabbedPane.addTab("Ingresar IPS y Ambulancias", null, tabIngresarIpsAmbulancias, null);
		
		//----------------------------------------------------------------------------------
		
		tabRegistrarPosicionAmbulancia = new RegistrarPosicionAmbulanciaView();		
		tabbedPane.addTab("Registrar posicion de ambulancias", null, tabRegistrarPosicionAmbulancia, null);
		
		
		//---------------------------------------------------------------------------------
		
		tabRegistrarUnServicio = new RegistrarUnServicioView();		
		tabbedPane.addTab("Registrar un servicio", null, tabRegistrarUnServicio, null);
		
		//-------------------------------------------------------------------
		
		tabAsignarServicio = new AsignarServicioView();
		tabbedPane.addTab("Asignar a servicio una ambulancias y una IPS", null, tabAsignarServicio, null);
		
		//-----------------------------------------------------------------------
		
		tabFinalizarServicio = new FinalizarServicioView();
		tabbedPane.addTab("Finalizar un servicio", null, tabFinalizarServicio, null);
		
		//-----------------------------------------------------------------------
		
		tabReporteServiciosConIpsYAmbulanciasAsignados = new ReporteServiciosAsignados();
		tabbedPane.addTab("Reporte servicios con IPS y ambulancias asignados", null, tabReporteServiciosConIpsYAmbulanciasAsignados, null);
		
		//-----------------------------------------------------------------------
		
		tabReporteDeIpsConServiciosAsociados = new ReporteServiciosAsociados();		
		tabbedPane.addTab("Reporte de IPS con servicios asociados", null, tabReporteDeIpsConServiciosAsociados, null);
	}
}
