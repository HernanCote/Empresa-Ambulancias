package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;
import co.edu.javeriana.ambulancias.views.IngresarIpsYAmbulanciasView;

public class IngresarIpsYAmbulanciasController implements ActionListener
{
	private IngresarIpsYAmbulanciasView ingresarIpsYAmbulanciasView;
	private EmpresaAmbulancias empresaAmbulancias;
	
	public IngresarIpsYAmbulanciasController(IngresarIpsYAmbulanciasView ingresarIpsYAmbulanciasView
			, EmpresaAmbulancias empresaAmbulancias) 
	{
		
		this.ingresarIpsYAmbulanciasView = ingresarIpsYAmbulanciasView;
		this.empresaAmbulancias = empresaAmbulancias;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object object = e.getSource();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + File.separator));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if(object.equals(ingresarIpsYAmbulanciasView.getBtnRegresar()))
		{
			ingresarIpsYAmbulanciasView.getTabbedPane().setSelectedIndex(0);
		}
		else if(object.equals(ingresarIpsYAmbulanciasView.getBtnSeleccionarIps())) 
		{			
			fileChooser.setDialogTitle("Escoga un archivo para cargar las IPS");			
			if(fileChooser.showOpenDialog(ingresarIpsYAmbulanciasView) == JFileChooser.APPROVE_OPTION)
			{
				String AbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();
				boolean cargaDeInfo = false;
				cargaDeInfo = ManejoArchivos.leerIPS(AbsolutePath, empresaAmbulancias);
				if(cargaDeInfo)
				{
					JOptionPane.showMessageDialog(ingresarIpsYAmbulanciasView, 
							"Se cargaron " + empresaAmbulancias.getIps().size() + " IPS al sistema");
				}
				else
				{
					JOptionPane.showMessageDialog(ingresarIpsYAmbulanciasView, "Error al cargar las IPS, "
							+ "puede que el archivo este corrupto o no se haya encontrado el archivo");
				}
			}
		}
		else if(object.equals(ingresarIpsYAmbulanciasView.getBtnSeleccionarAmbulancia())) 
		{			
			if(fileChooser.showOpenDialog(ingresarIpsYAmbulanciasView) == JFileChooser.APPROVE_OPTION)
			{
				String AbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();
				boolean cargaDeInfo = false;
				cargaDeInfo = ManejoArchivos.leerAmbulancias(AbsolutePath, empresaAmbulancias);
				if(cargaDeInfo)
				{
					JOptionPane.showMessageDialog(ingresarIpsYAmbulanciasView, 
							"Se cargaron " + empresaAmbulancias.getAmbulancias().size() + " Ambulancias al sistema");
				}
				else
				{
					JOptionPane.showMessageDialog(ingresarIpsYAmbulanciasView, "Error al cargar las Ambulancias, "
							+ "puede que el archivo este corrupto o no se haya encontrado el archivo");
				}
			}			
			
		}
	}
}
