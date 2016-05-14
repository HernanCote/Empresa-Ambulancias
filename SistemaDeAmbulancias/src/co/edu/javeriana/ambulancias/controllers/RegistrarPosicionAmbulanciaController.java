package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.views.RegistrarPosicionAmbulanciaView;

public class RegistrarPosicionAmbulanciaController implements ActionListener {
	
	private RegistrarPosicionAmbulanciaView viewRegistrarPosicionAmbulancia; 
	
	

	public RegistrarPosicionAmbulanciaController(RegistrarPosicionAmbulanciaView viewRegistrarPosicionAmbulancia) {
		this.viewRegistrarPosicionAmbulancia = viewRegistrarPosicionAmbulancia;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(viewRegistrarPosicionAmbulancia.getBtnActualizar())) {
			String [][] temp = ((EmpresaAmbulancias)EmpresaAmbulancias.getInstance()).getTableAmbulancias();
			viewRegistrarPosicionAmbulancia.addRowToTable(temp);
			
		}
		
		if (e.getSource().equals(viewRegistrarPosicionAmbulancia.getBtnRegistrar())) {
			int calle = 0;
			int carrera = 0;
			try {
				calle = Integer.parseInt(viewRegistrarPosicionAmbulancia.getTextFieldCalle().getText());
			    carrera = Integer.parseInt(viewRegistrarPosicionAmbulancia.getTextFieldCarrera().getText());
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(viewRegistrarPosicionAmbulancia, "Error En Valores Ingresados.", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
			GregorianCalendar date = new GregorianCalendar();
			int codigo = viewRegistrarPosicionAmbulancia.getSelectedRowCode();
			((EmpresaAmbulancias)EmpresaAmbulancias.getInstance()).registrarPosicionAmbulancia(codigo, date, calle, carrera);
			
		}
		
		if(e.getSource().equals(viewRegistrarPosicionAmbulancia.getBtnRegresar()))
		{
			viewRegistrarPosicionAmbulancia.getTabbedPane().setSelectedIndex(0);
		}

	}

}
