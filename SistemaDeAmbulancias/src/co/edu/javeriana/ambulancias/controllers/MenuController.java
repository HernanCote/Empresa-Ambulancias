package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.MenuView;

public class MenuController implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	
	public MenuController(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object object = e.getSource();
		
		if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnRegistrarPosAmbulancia()))
		{			
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(2);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnFinalizarServicio()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(5);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnRegistrarServicio()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(3);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnReporteServiciosAsignados()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(6);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnAsignarServicio()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(4);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnReporteServiciosAsociados()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(7);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnIngresarIPSAmb()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(1);
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnGuardarDatos()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().guardarDatos();
		}
		else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnCargarDatos()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().cargarDatos();
		}
	}
}
