package co.edu.javeriana.ambulancias.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

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
			String [][] temp = EmpresaAmbulancias.getInstance().getTableAmbulancias();
			viewRegistrarPosicionAmbulancia.setTableCont(temp);
			viewRegistrarPosicionAmbulancia.getTableAmbulancias().repaint();
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[i].length; j++) {
					System.out.println(temp[i][j]);
				}
			}
			
			viewRegistrarPosicionAmbulancia.update(viewRegistrarPosicionAmbulancia.getGraphics());
			System.out.println("Update");
		}

	}

}
