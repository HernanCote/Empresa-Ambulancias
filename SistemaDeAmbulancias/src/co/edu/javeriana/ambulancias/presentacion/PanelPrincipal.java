package co.edu.javeriana.ambulancias.presentacion;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import co.edu.javeriana.ambulancias.views.AsignarServicioView;
import co.edu.javeriana.ambulancias.views.FinalizarServicioView;
import co.edu.javeriana.ambulancias.views.IngresarIpsYAmbulanciasView;
import co.edu.javeriana.ambulancias.views.MenuView;
import co.edu.javeriana.ambulancias.views.RegistrarPosicionAmbulanciaView;
import co.edu.javeriana.ambulancias.views.RegistrarUnServicioView;
import co.edu.javeriana.ambulancias.views.ReporteServiciosAsignados;
import co.edu.javeriana.ambulancias.views.ReporteServiciosAsociados;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel 
{

	@SuppressWarnings("unused")
	private VentanaPrincipal ventanaPrincipal;
	
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
	 * Create the panel.
	 */
	public PanelPrincipal(VentanaPrincipal ventanaPrincipal) 
	{		
		this.ventanaPrincipal = ventanaPrincipal;
		
		setBounds(100, 100, 670, 528);
		setBackground(Color.WHITE);
		setLayout(null);
		
		setTabbedPane(new JTabbedPane(JTabbedPane.TOP));
		getTabbedPane().setBounds(10, 11, 740, 578);
		add(getTabbedPane());
		
		//----------------------------------------------------
		//----------------------------------------------------
		
		setTabMenuServicios(new MenuView(ventanaPrincipal));		
		getTabbedPane().addTab("Menu de Servicios", null, getTabMenuServicios(), null);
		
		//------------------------------------------------------------------------------		
		
					
		setTabIngresarIpsAmbulancias(new IngresarIpsYAmbulanciasView(ventanaPrincipal));		
		getTabbedPane().addTab("Ingresar IPS y Ambulancias", null, getTabIngresarIpsAmbulancias(), null);
		
		//----------------------------------------------------------------------------------
		
		setTabRegistrarPosicionAmbulancia(new RegistrarPosicionAmbulanciaView(ventanaPrincipal));		
		getTabbedPane().addTab("Registrar posicion de ambulancias", null, getTabRegistrarPosicionAmbulancia(), null);
		
		
		//---------------------------------------------------------------------------------
		
		setTabRegistrarUnServicio(new RegistrarUnServicioView(ventanaPrincipal));		
		getTabbedPane().addTab("Registrar un servicio", null, getTabRegistrarUnServicio(), null);
		
		//-------------------------------------------------------------------
		
		tabAsignarServicio = new AsignarServicioView(ventanaPrincipal);
		getTabbedPane().addTab("Asignar a servicio una ambulancias y una IPS", null, tabAsignarServicio, null);
		
		//-----------------------------------------------------------------------
		
		setTabFinalizarServicio(new FinalizarServicioView(ventanaPrincipal));
		getTabbedPane().addTab("Finalizar un servicio", null, getTabFinalizarServicio(), null);
		
		//-----------------------------------------------------------------------
		
		tabReporteServiciosConIpsYAmbulanciasAsignados = new ReporteServiciosAsignados(ventanaPrincipal);
		getTabbedPane().addTab("Reporte servicios con IPS y ambulancias asignados", null, tabReporteServiciosConIpsYAmbulanciasAsignados, null);
		
		//-----------------------------------------------------------------------
		
		tabReporteDeIpsConServiciosAsociados = new ReporteServiciosAsociados();		
		getTabbedPane().addTab("Reporte de IPS con servicios asociados", null, tabReporteDeIpsConServiciosAsociados, null);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public MenuView getTabMenuServicios() {
		return tabMenuServicios;
	}

	public void setTabMenuServicios(MenuView tabMenuServicios) {
		this.tabMenuServicios = tabMenuServicios;
	}

	public IngresarIpsYAmbulanciasView getTabIngresarIpsAmbulancias() {
		return tabIngresarIpsAmbulancias;
	}

	public void setTabIngresarIpsAmbulancias(IngresarIpsYAmbulanciasView tabIngresarIpsAmbulancias) {
		this.tabIngresarIpsAmbulancias = tabIngresarIpsAmbulancias;
	}

	public RegistrarPosicionAmbulanciaView getTabRegistrarPosicionAmbulancia() {
		return tabRegistrarPosicionAmbulancia;
	}

	public void setTabRegistrarPosicionAmbulancia(RegistrarPosicionAmbulanciaView tabRegistrarPosicionAmbulancia) {
		this.tabRegistrarPosicionAmbulancia = tabRegistrarPosicionAmbulancia;
	}

	public RegistrarUnServicioView getTabRegistrarUnServicio() {
		return tabRegistrarUnServicio;
	}

	public void setTabRegistrarUnServicio(RegistrarUnServicioView tabRegistrarUnServicio) {
		this.tabRegistrarUnServicio = tabRegistrarUnServicio;
	}


	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public AsignarServicioView getTabAsignarServicio() {
		return tabAsignarServicio;
	}

	public void setTabAsignarServicio(AsignarServicioView tabAsignarServicio) {
		this.tabAsignarServicio = tabAsignarServicio;
	}


	public FinalizarServicioView getTabFinalizarServicio() {
		return tabFinalizarServicio;
	}

	public void setTabFinalizarServicio(FinalizarServicioView tabFinalizarServicio) {
		this.tabFinalizarServicio = tabFinalizarServicio;
	}

	public ReporteServiciosAsignados getTabReporteServiciosConIpsYAmbulanciasAsignados() {
		return tabReporteServiciosConIpsYAmbulanciasAsignados;
	}

	public void setTabReporteServiciosConIpsYAmbulanciasAsignados(
			ReporteServiciosAsignados tabReporteServiciosConIpsYAmbulanciasAsignados) {
		this.tabReporteServiciosConIpsYAmbulanciasAsignados = tabReporteServiciosConIpsYAmbulanciasAsignados;
	}

	public ReporteServiciosAsociados getTabReporteDeIpsConServiciosAsociados() {
		return tabReporteDeIpsConServiciosAsociados;
	}

	public void setTabReporteDeIpsConServiciosAsociados(ReporteServiciosAsociados tabReporteDeIpsConServiciosAsociados) {
		this.tabReporteDeIpsConServiciosAsociados = tabReporteDeIpsConServiciosAsociados;
	}
}
