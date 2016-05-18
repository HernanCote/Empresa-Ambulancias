package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class ReporteServiciosAsociadosController implements ActionListener 
{
	private VentanaPrincipal ventanaPrincipal;
	public ReporteServiciosAsociadosController(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Object object = arg0.getSource();
		if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabReporteDeIpsConServiciosAsociados().getBtnRegresar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		else 
		{
			ventanaPrincipal.getPanelPrincipal().getTabReporteDeIpsConServiciosAsociados().cambioComboBoxIps();
		}
	}

}
