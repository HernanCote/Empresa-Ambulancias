package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.FinalizarServicioView;

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
		FinalizarServicioView tabFinalizarView = ventanaPrincipal.getPanelPrincipal().getTabFinalizarServicio();
		if(object.equals(tabFinalizarView.getBtnRegresar()))
		{			
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		else if(object.equals(tabFinalizarView.getBtnFinalizarServicioSeleccionado()))
		{
			int codigoServicio = tabFinalizarView.getSelectedRowCodeServicio();
			System.out.println(codigoServicio);
			tabFinalizarView.finalizarServicio(codigoServicio);
			ventanaPrincipal.getController().getReporteServiciosAsignados().actualizarContServicios();
			ventanaPrincipal.getController().getAsignarServicioController().actualizarContServicios();
			ventanaPrincipal.getEmpresaAmbulancias().finalizarUnServicio(codigoServicio);
		}
	}
	
	public void actualizarContServicios () {
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableServicios();
		ventanaPrincipal.getPanelPrincipal().getTabFinalizarServicio().addRowToTableServicios(temp);
	}

}
