package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.javeriana.ambulancias.views.MenuView;

public class MenuController implements ActionListener
{
	private MenuView menuView;
	
	public MenuController(MenuView menuView) 
	{
		this.menuView = menuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object object = e.getSource();
		
		if(object.equals(menuView.getBtnRegistrarPosAmbulancia()))
		{		
			menuView.getTabbedPane().setSelectedIndex(2);
		}
		else if(object.equals(menuView.getBtnFinalizarServicio()))
		{
			menuView.getTabbedPane().setSelectedIndex(5);
		}
		else if(object.equals(menuView.getBtnRegistrarServicio()))
		{
			menuView.getTabbedPane().setSelectedIndex(3);
		}
		else if(object.equals(menuView.getBtnReporteServiciosAsignados()))
		{
			menuView.getTabbedPane().setSelectedIndex(6);
		}
		else if(object.equals(menuView.getBtnAsignarServicio()))
		{
			menuView.getTabbedPane().setSelectedIndex(4);
		}
		else if(object.equals(menuView.getBtnReporteServiciosAsociados()))
		{
			menuView.getTabbedPane().setSelectedIndex(7);
		}
		else if(object.equals(menuView.getBtnIngresarIPSAmb()))
		{
			menuView.getTabbedPane().setSelectedIndex(1);
		}
	}
}
