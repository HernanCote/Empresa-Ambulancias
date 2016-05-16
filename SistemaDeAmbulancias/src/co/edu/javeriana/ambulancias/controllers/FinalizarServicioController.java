package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class FinalizarServicioController implements ActionListener 
{

	private VentanaPrincipal ventanaPrincipal;

	public FinalizarServicioController(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		Object object = e.getSource();
		if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabFinalizarServicio().getBtnRegresar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabFinalizarServicio().getBtnFinalizarServicioSeleccionado()))
		{
			
		}
	}

}
