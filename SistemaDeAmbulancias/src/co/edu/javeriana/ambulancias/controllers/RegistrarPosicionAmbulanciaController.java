package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.RegistrarPosicionAmbulanciaView;

public class RegistrarPosicionAmbulanciaController implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal; 
	

	public RegistrarPosicionAmbulanciaController(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getBtnActualizar())) {
			actualizarTabla();			
		}		
		else if (e.getSource().equals(ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getBtnRegistrar())) {
			int calle = 0;
			int carrera = 0;
			try {
				calle = Integer.parseInt(ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getTextFieldCalle().getText());
			    carrera = Integer.parseInt(ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getTextFieldCarrera().getText());
			    
			    GregorianCalendar date = new GregorianCalendar();
				int codigo = ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getSelectedRowCode();
				ventanaPrincipal.getEmpresaAmbulancias().registrarPosicionAmbulancia(codigo, date, calle, carrera);
				
				actualizarTabla();
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(ventanaPrincipal, "Ingrese valores numéricos.", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}		
		else if(e.getSource().equals(ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().getBtnRegresar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
	}
	
	public void actualizarTabla()
	{
		String [][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableAmbulancias();
		ventanaPrincipal.getPanelPrincipal().getTabRegistrarPosicionAmbulancia().addRowToTable(temp);
	}

}
