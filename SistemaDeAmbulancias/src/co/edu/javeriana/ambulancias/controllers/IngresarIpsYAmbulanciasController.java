package co.edu.javeriana.ambulancias.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.entidades.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import co.edu.javeriana.ambulancias.views.IngresarIpsYAmbulanciasView;

public class IngresarIpsYAmbulanciasController implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	
	public IngresarIpsYAmbulanciasController(VentanaPrincipal ventanaPrincipal)
	{		
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object object = e.getSource();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + File.separator));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabIngresarIpsAmbulancias().getBtnRegresar()))
		{
			ventanaPrincipal.getPanelPrincipal().getTabbedPane().setSelectedIndex(0);
		}
		else {		
			if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabIngresarIpsAmbulancias().getBtnSeleccionarIps())) 
			{			
				fileChooser.setDialogTitle("Escoga un archivo para cargar las IPS");			
				if(fileChooser.showOpenDialog(ventanaPrincipal) == JFileChooser.APPROVE_OPTION)
				{
					String AbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();
					boolean cargaDeInfo = false;
					cargaDeInfo = ManejoArchivos.leerIPS(AbsolutePath,ventanaPrincipal.getEmpresaAmbulancias());
					if(cargaDeInfo)
					{
						JOptionPane.showMessageDialog(ventanaPrincipal, 
								"Se cargaron " + ventanaPrincipal.getEmpresaAmbulancias().getIps().size() + " IPS al sistema"
								,"Exito!",JOptionPane.INFORMATION_MESSAGE);
						ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnGuardarDatos().setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(ventanaPrincipal, "Error al cargar las IPS, "
								+ "puede que el archivo este corrupto o no se haya encontrado el archivo"
								,"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if(object.equals(ventanaPrincipal.getPanelPrincipal().getTabIngresarIpsAmbulancias().getBtnSeleccionarAmbulancia())) 
			{			
				if(fileChooser.showOpenDialog(ventanaPrincipal) == JFileChooser.APPROVE_OPTION)
				{
					String AbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();
					boolean cargaDeInfo = false;
					cargaDeInfo = ManejoArchivos.leerAmbulancias(AbsolutePath, (EmpresaAmbulancias)ventanaPrincipal.getEmpresaAmbulancias());
					if(cargaDeInfo)
					{
						JOptionPane.showMessageDialog(ventanaPrincipal, 
								"Se cargaron " + ventanaPrincipal.getEmpresaAmbulancias().getAmbulancias().size() + " Ambulancias al sistema"
								,"Exito!",JOptionPane.INFORMATION_MESSAGE);
						ventanaPrincipal.getController().getRegistrarPosicionAmbulanciaController().actualizarTabla();
						ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnGuardarDatos().setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(ventanaPrincipal, "Error al cargar las Ambulancias, "
								+ "puede que el archivo este corrupto o no se haya encontrado el archivo"
								,"Error",JOptionPane.ERROR_MESSAGE);
					}
				}			
				
			}
		}
	}

	
}
