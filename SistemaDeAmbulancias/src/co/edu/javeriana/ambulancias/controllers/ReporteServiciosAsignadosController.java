package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.ambulancias.Ambulancia;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaBasica;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaMedicalizada;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaUCI;
import co.edu.javeriana.ambulancias.entidades.IPS;
import co.edu.javeriana.ambulancias.entidades.Servicio;
import co.edu.javeriana.ambulancias.enums.TipoServicio;
import co.edu.javeriana.ambulancias.presentacion.Utils;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.ReporteServiciosAsignados;

public class ReporteServiciosAsignadosController implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;

	public ReporteServiciosAsignadosController(VentanaPrincipal ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ReporteServiciosAsignados ventanaAsigServ = ventanaPrincipal.getPanelPrincipal().getTabReporteServiciosConIpsYAmbulanciasAsignados();
		try {
			if (e.getSource().equals(ventanaAsigServ.getBtnMostrar())) {
				actualizarContIPS();
			}
		} catch (Exception exp) {
			JOptionPane.showMessageDialog(ventanaPrincipal, "El Servicio No Se Ha Asignado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		if (e.getSource().equals(ventanaAsigServ.getBtnRegresar())) {
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
	}
	
	public void actualizarContServicios () {
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableServicios();
		ventanaPrincipal.getPanelPrincipal().getTabReporteServiciosConIpsYAmbulanciasAsignados().addRowToTableServicios(temp);
	}
	
	public void actualizarContIPS () {
		int codigo = 0;
		
		try {
			codigo = ventanaPrincipal.getPanelPrincipal().getTabReporteServiciosConIpsYAmbulanciasAsignados().getSelectedRowCodeServicio();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(ventanaPrincipal, "Seleccione Un Servicio", "ERROR", JOptionPane.ERROR_MESSAGE);
			actualizarContServicios();
			return;
		}
		
		System.out.println("CODIGO: " + codigo);
		
		Servicio servTemp = ventanaPrincipal.getEmpresaAmbulancias().getServicioById(codigo);
			
		
		IPS ipsTemp = servTemp.getIps();
		Ambulancia tempAmbu = servTemp.getAmbulancia();
		String addIPS [][] = new String [1][3];
		String addAmbulancia [][] = ambuToMatrix(tempAmbu);
		if (servTemp.getTipoServicio() != TipoServicio.DOMICILIO) {
			addIPS[0][0] = ipsTemp.getNombre();
			addIPS[0][1] = ipsTemp.getTipoAtencion();
			addIPS[0][2] = ipsTemp.getDireccion().toString();
		} else {
			addIPS[0][0] = " ";
			addIPS[0][1] = " ";
			addIPS[0][2] = " ";
		}
		ventanaPrincipal.getPanelPrincipal().getTabReporteServiciosConIpsYAmbulanciasAsignados().addRowToTableAmbulancias(addAmbulancia);
		ventanaPrincipal.getPanelPrincipal().getTabReporteServiciosConIpsYAmbulanciasAsignados().addRowToTableIPS(addIPS);
		System.out.println(addIPS[0][0]);
	}
	
	public String [][] ambuToMatrix (Ambulancia ambu) {
		String addAmbulancia [][] = new String [1][9];
		addAmbulancia[0][0] = String.valueOf(ambu.getCodigo());
		if (ambu instanceof AmbulanciaUCI) {
			addAmbulancia[0][1] ="UCI";
		}
		if (ambu instanceof AmbulanciaBasica) {
			addAmbulancia[0][1] ="Basica";
		}
		if (ambu instanceof AmbulanciaNoMedicalizada) {
			addAmbulancia[0][1] ="NoMedicalizada";
		}
		
		
		
		if (ambu instanceof AmbulanciaUCI) {
			addAmbulancia[0][2] = (((AmbulanciaUCI) ambu)).getTipoUCI() ;
		} else {
			addAmbulancia[0][2] ="NA";
		}
		addAmbulancia[0][3] =ambu.getPlaca();
		
		if (ambu instanceof AmbulanciaMedicalizada) {
			addAmbulancia[0][4] =((AmbulanciaMedicalizada) ambu).getMedico();
		}
		
		if (ambu instanceof AmbulanciaNoMedicalizada) {
			addAmbulancia[0][4] = ((AmbulanciaNoMedicalizada) ambu).getEnfermo();
		}
		
		addAmbulancia[0][5] = (Utils.formatoHora(ambu.getHoraPosicion()));
		addAmbulancia[0][6] = String.valueOf(ambu.getPosicionCalle());
		addAmbulancia[0][7] = String.valueOf(ambu.getPosicionCarrera());
		addAmbulancia[0][8] = String.valueOf(ambu.calcularTarifa());
		
		return addAmbulancia;
	}

}
