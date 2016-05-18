package co.edu.javeriana.ambulancias.controllers;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class Controller 
{
	private VentanaPrincipal ventanaPrincipal;
	
	private MenuController menuController;
	private IngresarIpsYAmbulanciasController ingresarIpsYAmbulanciasController;
	private RegistrarPosicionAmbulanciaController registrarPosicionAmbulanciaController;
	private RegistrarUnServicioController registrarUnServicioController;
	private AsignarServicioController asignarServicioController;
	private ReporteServiciosAsignadosController reporteServiciosAsignados;
	private ReporteServiciosAsociadosController reporteServiciosAsociadosController;
	
	
	private FinalizarServicioController finalizarServicioController;
	
	
	public Controller(VentanaPrincipal ventanaPrincipal)
	{
		this.setVentanaPrincipal(ventanaPrincipal);
		
		this.menuController = new MenuController(ventanaPrincipal);
		this.ingresarIpsYAmbulanciasController = new IngresarIpsYAmbulanciasController(ventanaPrincipal);
		this.registrarPosicionAmbulanciaController = new RegistrarPosicionAmbulanciaController(ventanaPrincipal);
		this.registrarUnServicioController = new RegistrarUnServicioController(ventanaPrincipal);
		this.finalizarServicioController = new FinalizarServicioController(ventanaPrincipal);
		this.asignarServicioController = new AsignarServicioController(ventanaPrincipal);
		this.reporteServiciosAsignados = new ReporteServiciosAsignadosController(ventanaPrincipal);
		this.setReporteServiciosAsociadosController(new ReporteServiciosAsociadosController(ventanaPrincipal));
	}
	
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	public RegistrarPosicionAmbulanciaController getRegistrarPosicionAmbulanciaController() {
		return registrarPosicionAmbulanciaController;
	}

	public void setRegistrarPosicionAmbulanciaController(RegistrarPosicionAmbulanciaController registrarPosicionAmbulanciaController) {
		this.registrarPosicionAmbulanciaController = registrarPosicionAmbulanciaController;
	}

	public IngresarIpsYAmbulanciasController getIngresarIpsYAmbulanciasController() {
		return ingresarIpsYAmbulanciasController;
	}

	public void setIngresarIpsYAmbulanciasController(IngresarIpsYAmbulanciasController ingresarIpsYAmbulanciasController) {
		this.ingresarIpsYAmbulanciasController = ingresarIpsYAmbulanciasController;
	}


	public RegistrarUnServicioController getRegistrarUnServicioController() {
		return registrarUnServicioController;
	}


	public void setRegistrarUnServicioController(RegistrarUnServicioController registrarUnServicioController) {
		this.registrarUnServicioController = registrarUnServicioController;
	}	

	public AsignarServicioController getAsignarServicioController() {
		return asignarServicioController;
	}


	public void setAsignarServicioController(AsignarServicioController asignarServicioController) {
		this.asignarServicioController = asignarServicioController;
	}
	
	public FinalizarServicioController getFinalizarServicioController() {
		return finalizarServicioController;
	}


	public void setFinalizarServicioController(FinalizarServicioController finalizarServicioController) {
		this.finalizarServicioController = finalizarServicioController;
	}


	public ReporteServiciosAsignadosController getReporteServiciosAsignados() {
		return reporteServiciosAsignados;
	}


	public void setReporteServiciosAsignados(ReporteServiciosAsignadosController reporteServiciosAsignados) {
		this.reporteServiciosAsignados = reporteServiciosAsignados;
	}


	public ReporteServiciosAsociadosController getReporteServiciosAsociadosController() {
		return reporteServiciosAsociadosController;
	}


	public void setReporteServiciosAsociadosController(ReporteServiciosAsociadosController reporteServiciosAsociadosController) {
		this.reporteServiciosAsociadosController = reporteServiciosAsociadosController;
	}
	
}
