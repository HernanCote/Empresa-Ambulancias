package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.AsignarServicioView;

public class AsignarServicioController implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	
	

	public AsignarServicioController(VentanaPrincipal ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		AsignarServicioView ventanaAsigServ = ventanaPrincipal.getPanelPrincipal().getTabAsignarServicio();
		if (e.getSource().equals(ventanaAsigServ.getBtnAssignarServicio())){
			int codigoServ = ventanaAsigServ.getSelectedRowCodeServicio();
			if (!ventanaPrincipal.getEmpresaAmbulancias().isAsignado(ventanaAsigServ.getSelectedRowCodeServicio())) {
				ventanaPrincipal.getEmpresaAmbulancias().asignarUnServicio(ventanaAsigServ.getSelectedRowCodeServicio());
				actualizarContServicios();
			} else {
				JOptionPane.showMessageDialog(ventanaPrincipal, "El Servicio Ya Fue Asignado", "ERROR",JOptionPane.ERROR_MESSAGE);
			}		
		}
		
		if (e.getSource().equals(ventanaAsigServ.getBtnRegresar())) {
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		
	}
	
	public void actualizarContAmbulancias () {
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableAmbulancias();
		ventanaPrincipal.getPanelPrincipal().getTabAsignarServicio().addRowToTableAmbulancia(temp);
	}
	
	public void actualizarContIPS () {
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableIPS();
		ventanaPrincipal.getPanelPrincipal().getTabAsignarServicio().addRowToTableIPS(temp);
	}
	
	public void actualizarContServicios () {
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableServicios();
		ventanaPrincipal.getPanelPrincipal().getTabAsignarServicio().addRowToTableServicios(temp);
	}

}
