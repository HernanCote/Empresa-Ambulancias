package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.webkit.ThemeClient;

import co.edu.javeriana.ambulancias.controllers.MenuController;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MenuView extends JPanel 
{

	
	private VentanaPrincipal ventanaPrincipal;
	
	private JButton btnRegistrarPosAmbulancia;
	private JButton btnFinalizarServicio;
	private JButton btnRegistrarServicio;
	private JButton btnReporteServiciosAsignados;
	private JButton btnAsignarServicio;
	private JButton btnReporteServiciosAsociados;
	private JButton btnIngresarIPSAmb;
	private JButton btnGuardarDatos;
	private JButton btnCargarDatos;
	
	
	/**
	 * Create the panel.
	 */
	public MenuView(VentanaPrincipal ventanaPrincipal) 
	{
		this.setVentanaPrincipal(ventanaPrincipal);
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("SERVICIOS DEL SISTEMA DE AMBULANCIAS");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(219, 50, 317, 14);
		add(lblNewLabel);
		
		setBtnRegistrarPosAmbulancia(new JButton("Registrar la posicion actual de una ambulancia"));
		getBtnRegistrarPosAmbulancia().setBackground(Color.WHITE);
		getBtnRegistrarPosAmbulancia().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnRegistrarPosAmbulancia().setBounds(40, 142, 317, 49);
		getBtnRegistrarPosAmbulancia().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnRegistrarPosAmbulancia());
		
		setBtnFinalizarServicio(new JButton("Finalizar Un Servicio"));
		getBtnFinalizarServicio().setBackground(Color.WHITE);
		getBtnFinalizarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnFinalizarServicio().setBounds(367, 142, 317, 49);
		getBtnFinalizarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnFinalizarServicio());
		
		setBtnRegistrarServicio(new JButton("Registrar un Servicio"));
		getBtnRegistrarServicio().setBackground(Color.WHITE);
		getBtnRegistrarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnRegistrarServicio().setBounds(40, 222, 317, 50);
		getBtnRegistrarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnRegistrarServicio());
		
		setBtnReporteServiciosAsignados(new JButton("Reporte de servicios con IPS y ambulancias asignados"));
		getBtnReporteServiciosAsignados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsignados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsignados().setBounds(367, 222, 317, 50);
		getBtnReporteServiciosAsignados().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnReporteServiciosAsignados());
		
		setBtnAsignarServicio(new JButton("Asignar a un servicio una ambulancias y una IPS"));
		getBtnAsignarServicio().setBackground(Color.WHITE);
		getBtnAsignarServicio().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnAsignarServicio().setBounds(40, 303, 317, 47);
		getBtnAsignarServicio().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnAsignarServicio());
		
		setBtnReporteServiciosAsociados(new JButton("Reporte de las IPS con servicios asociados"));
		getBtnReporteServiciosAsociados().setBackground(Color.WHITE);
		getBtnReporteServiciosAsociados().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		getBtnReporteServiciosAsociados().setBounds(367, 303, 317, 47);
		getBtnReporteServiciosAsociados().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnReporteServiciosAsociados());
		
		setBtnIngresarIPSAmb(new JButton("Ingresar IPS y ambulancias"));
		getBtnIngresarIPSAmb().setBackground(new Color(64, 224, 208));
		getBtnIngresarIPSAmb().setBounds(155, 408, 202, 41);
		getBtnIngresarIPSAmb().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnIngresarIPSAmb());
		
		setBtnGuardarDatos(new JButton("Guardar datos del sistema"));
		getBtnGuardarDatos().setBackground(SystemColor.textHighlight);
		getBtnGuardarDatos().setBounds(367, 408, 202, 41);
		getBtnGuardarDatos().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnGuardarDatos());
	
	
		setBtnCargarDatos(new JButton("Cargar datos del sistema"));
		getBtnCargarDatos().setBackground(SystemColor.textHighlight);
		getBtnCargarDatos().setBounds(367, 460, 202, 41);
		getBtnCargarDatos().addActionListener(this.getVentanaPrincipal().getController().getMenuController());
		add(getBtnCargarDatos());
		
		btnGuardarDatos.setEnabled(false);
	}
	
	public void habilitarBtnGuardar()
	{
		btnGuardarDatos.setEnabled(true);
	}
	
	public void guardarDatos()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Especifique el nombre para guardar el archivo sin extensión");
		fileChooser.setCurrentDirectory(new File("."));
		
		int userSelection = fileChooser.showSaveDialog(ventanaPrincipal);
		if(userSelection == JFileChooser.APPROVE_OPTION)
		{
			boolean IsSuccess = false;
			String fileToSave = fileChooser.getSelectedFile() + ".txt";
			
			IsSuccess = ManejoArchivos.saveContext(fileToSave, ventanaPrincipal.getEmpresaAmbulancias());
			
			if(IsSuccess)
			{
				JOptionPane.showMessageDialog(ventanaPrincipal, "Se ha guardado con éxito los datos!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "Error al guardar los datos en el sistema :("
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void cargarDatos()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Especifique el archivo que desea abrir");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT file", "txt");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File("."));
		
		if(fileChooser.showOpenDialog(ventanaPrincipal) == JFileChooser.APPROVE_OPTION)
		{
			String AbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();
			EmpresaAmbulancias empresaAmbulanciasTemp = ManejoArchivos.loadContext(AbsolutePath);
			
			if (empresaAmbulanciasTemp != null)
			{
				this.ventanaPrincipal.setEmpresaAmbulancias(empresaAmbulanciasTemp);
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "Se han cargado con éxito los datos!"
						, "Éxito"
						, JOptionPane.INFORMATION_MESSAGE);
				
				ventanaPrincipal.getController().getRegistrarPosicionAmbulanciaController().actualizarTabla();
				ventanaPrincipal.getController().getAsignarServicioController().actualizarContAmbulancias();
				ventanaPrincipal.getController().getAsignarServicioController().actualizarContIPS();
				ventanaPrincipal.getController().getAsignarServicioController().actualizarContServicios();
				ventanaPrincipal.getController().getFinalizarServicioController().actualizarContServicios();
				
				habilitarBtnGuardar();
			}
			else 
			{
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "Error al cargar los datos en el sistema :("
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public JButton getBtnRegistrarPosAmbulancia()
	{
		return btnRegistrarPosAmbulancia;
	}
	
	public void setBtnRegistrarPosAmbulancia(JButton btnRegistrarPosAmbulancia) 
	{
		this.btnRegistrarPosAmbulancia = btnRegistrarPosAmbulancia;
	}



	public JButton getBtnFinalizarServicio() 
	{
		return btnFinalizarServicio;
	}



	public void setBtnFinalizarServicio(JButton btnFinalizarServicio)
	{
		this.btnFinalizarServicio = btnFinalizarServicio;
	}



	public JButton getBtnRegistrarServicio() 
	{
		return btnRegistrarServicio;
	}



	public void setBtnRegistrarServicio(JButton btnRegistrarServicio) 
	{
		this.btnRegistrarServicio = btnRegistrarServicio;
	}



	public JButton getBtnReporteServiciosAsignados()
	{
		return btnReporteServiciosAsignados;
	}



	public void setBtnReporteServiciosAsignados(JButton btnReporteServiciosAsignados)
	{
		this.btnReporteServiciosAsignados = btnReporteServiciosAsignados;
	}



	public JButton getBtnAsignarServicio() 
	{
		return btnAsignarServicio;
	}



	public void setBtnAsignarServicio(JButton btnAsignarServicio)
	{
		this.btnAsignarServicio = btnAsignarServicio;
	}



	public JButton getBtnReporteServiciosAsociados() 
	{
		return btnReporteServiciosAsociados;
	}



	public void setBtnReporteServiciosAsociados(JButton btnReporteServiciosAsociados) 
	{
		this.btnReporteServiciosAsociados = btnReporteServiciosAsociados;
	}



	public JButton getBtnIngresarIPSAmb()
	{
		return btnIngresarIPSAmb;
	}



	public void setBtnIngresarIPSAmb(JButton btnIngresarIPSAmb) 
	{
		this.btnIngresarIPSAmb = btnIngresarIPSAmb;
	}



	public VentanaPrincipal getVentanaPrincipal() {
		return this.ventanaPrincipal;
	}



	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}



	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}



	public void setBtnGuardarDatos(JButton btnGuardarDatos) {
		this.btnGuardarDatos = btnGuardarDatos;
	}



	public JButton getBtnCargarDatos() {
		return btnCargarDatos;
	}



	public void setBtnCargarDatos(JButton btnCargarDatos) {
		this.btnCargarDatos = btnCargarDatos;
	}
}
