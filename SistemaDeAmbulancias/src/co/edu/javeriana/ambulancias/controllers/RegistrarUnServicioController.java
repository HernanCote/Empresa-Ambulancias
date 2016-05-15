package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class RegistrarUnServicioController implements ActionListener {

	
	private VentanaPrincipal ventanaPrincipal;
	
	public RegistrarUnServicioController(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object object = e.getSource();
		
		if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabRegistrarUnServicio().getBtnRegresar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabRegistrarUnServicio().getBtnRegistrar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabRegistrarUnServicio().saveServicio();
		}
	}
}
