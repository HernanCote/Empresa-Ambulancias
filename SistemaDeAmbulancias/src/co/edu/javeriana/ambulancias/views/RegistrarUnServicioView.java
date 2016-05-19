package co.edu.javeriana.ambulancias.views;

import java.awt.Color;

import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.entidades.Direccion;
import co.edu.javeriana.ambulancias.entidades.Servicio;
import co.edu.javeriana.ambulancias.enums.TipoDireccion;
import co.edu.javeriana.ambulancias.enums.TipoServicio;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RegistrarUnServicioView extends JPanel 
{

	private VentanaPrincipal ventanaPrincipal;
	
	private JTextField txtPaciente;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtCarrera;
	private JTextField txtNumero;
	private JComboBox<TipoServicio> comboTipoServicio;
	private JComboBox<TipoDireccion> comboTipoDireccion;
	private JButton btnRegistrar;
	private JButton btnRegresar;
	
	/**
	 * Create the panel.
	 */
	public RegistrarUnServicioView(VentanaPrincipal ventanaPrincipal)
	{
		this.ventanaPrincipal = ventanaPrincipal;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(220, 152, 79, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Servicio");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(197, 189, 102, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(253, 226, 55, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de direcci\u00F3n");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(180, 264, 119, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Calle");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(253, 298, 46, 14);
		add(lblNewLabel_4);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarrera.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblCarrera.setBounds(253, 329, 46, 14);
		add(lblCarrera);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNmero.setBounds(235, 363, 64, 14);
		add(lblNmero);
		
		JLabel lblNewLabel_5 = new JLabel("Registrar un servicio");
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 11, 264, 30);
		add(lblNewLabel_5);
		
		JLabel lblRegistreLosDatos = new JLabel("Registre los datos del nuevo servicio");
		lblRegistreLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistreLosDatos.setForeground(Color.LIGHT_GRAY);
		lblRegistreLosDatos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblRegistreLosDatos.setBounds(197, 86, 337, 26);
		add(lblRegistreLosDatos);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(343, 150, 171, 20);
		add(txtPaciente);
		txtPaciente.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(343, 224, 171, 20);
		add(txtTelefono);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(343, 296, 171, 20);
		add(txtCalle);
		
		txtCarrera = new JTextField();
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(343, 327, 171, 20);
		add(txtCarrera);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(343, 361, 171, 20);
		add(txtNumero);
		
		comboTipoServicio = new JComboBox<TipoServicio>(TipoServicio.values());
		comboTipoServicio.setBackground(Color.WHITE);
		comboTipoServicio.setBounds(343, 187, 171, 20);
		add(comboTipoServicio);
		
		comboTipoDireccion = new JComboBox<TipoDireccion>(TipoDireccion.values());
		comboTipoDireccion.setBackground(Color.WHITE);
		comboTipoDireccion.setBounds(343, 262, 171, 20);
		add(comboTipoDireccion);
		
		setBtnRegistrar(new JButton("Registrar"));
		getBtnRegistrar().setForeground(Color.GRAY);
		getBtnRegistrar().setBackground(new Color(50, 205, 50));
		getBtnRegistrar().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		getBtnRegistrar().setBounds(420, 416, 94, 30);
		getBtnRegistrar().addActionListener(ventanaPrincipal.getController().getRegistrarUnServicioController());
		add(getBtnRegistrar());
		
		setBtnRegresar(new JButton("Regresar"));
		getBtnRegresar().setForeground(Color.GRAY);
		getBtnRegresar().setBackground(new Color(178, 34, 34));
		getBtnRegresar().setBounds(316, 417, 94, 30);
		btnRegresar.addActionListener(this.ventanaPrincipal.getController().getRegistrarUnServicioController());
		add(getBtnRegresar());
		
		init();
	}
	
	public void init()
	{
		getBtnRegistrar().setEnabled(true);
	}
	
	public void saveServicio()
	{
		try 
		{
			String paciente = txtPaciente.getText();
			TipoServicio tipoServicio = (TipoServicio) comboTipoServicio.getSelectedItem();
			String telefono = txtTelefono.getText();
			TipoDireccion tipoDireccion = (TipoDireccion) comboTipoDireccion.getSelectedItem();
			int calle = Integer.parseInt(txtCalle.getText());
			int carrera = Integer.parseInt(txtCarrera.getText());
			int numero = Integer.parseInt(txtNumero.getText());
			
			Direccion direccion = new Direccion(tipoDireccion, calle, carrera, numero);
			Servicio servicio = new Servicio(paciente, tipoServicio, telefono, direccion);
			
			
			ventanaPrincipal.getEmpresaAmbulancias().registrarServicio(servicio);
			ventanaPrincipal.getController().getAsignarServicioController().actualizarContServicios();
			ventanaPrincipal.getController().getFinalizarServicioController().actualizarContServicios();
			ventanaPrincipal.getController().getReporteServiciosAsignados().actualizarContServicios();
			ventanaPrincipal.getPanelPrincipal().getTabMenuServicios().getBtnGuardarDatos().setEnabled(true);
			JOptionPane.showMessageDialog(ventanaPrincipal
					, "Servicio ingresado exitosamente al sistema!"
					, "�xito!"
					, JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(ventanaPrincipal
					, "Ingrese datos v�lidos al sistema"
					, "Error"
					, JOptionPane.ERROR_MESSAGE);
			
		}
		finally
		{
			clearFields();
		}		
		
	}
	
	private void clearFields()
	{
		txtPaciente.setText(null);
		comboTipoDireccion.setSelectedIndex(0);
		txtPaciente.setText(null);
		txtTelefono.setText(null);
		comboTipoServicio.setSelectedIndex(0);
		txtCalle.setText(null);
		txtCarrera.setText(null);
		txtNumero.setText(null);
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
		btnRegresar.setIcon(new ImageIcon("iconos/hospital-2.png"));
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
		btnRegistrar.setIcon(new ImageIcon("iconos/electrocardiogram.png"));
	}
}
