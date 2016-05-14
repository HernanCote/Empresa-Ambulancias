package co.edu.javeriana.ambulancias.controllers;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class Controller 
{
	private VentanaPrincipal ventanaPrincipal;
	
	private MenuController menuController;
	private IngresarIpsYAmbulanciasController ingresarIpsYAmbulanciasController;
	private RegistrarPosicionAmbulanciaController registrarPosicionAmbulanciaController;
	
	
	public Controller(VentanaPrincipal ventanaPrincipal)
	{
		this.setVentanaPrincipal(ventanaPrincipal);
		
		this.menuController = new MenuController(ventanaPrincipal);
		this.ingresarIpsYAmbulanciasController = new IngresarIpsYAmbulanciasController(ventanaPrincipal);
		this.registrarPosicionAmbulanciaController = new RegistrarPosicionAmbulanciaController(ventanaPrincipal);
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
	
	
}
