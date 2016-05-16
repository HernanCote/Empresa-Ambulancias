package co.edu.javeriana.ambulancias.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;

public class FinalizarServicioView extends JPanel 
{
	
	private VentanaPrincipal ventanaPrincipal;
	
	private JTable table;
	
	private JButton btnFinalizarServicioSeleccionado;
	private JButton btnRegresar;
	
	/**
	 * Create the panel.
	 */
	public FinalizarServicioView(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Finalizar un servicio");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 266, 25);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 66, 650, 210);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setBtnFinalizarServicioSeleccionado(new JButton("Finalizar servicio seleccionado"));
		getBtnFinalizarServicioSeleccionado().setBackground(SystemColor.textHighlight);
		getBtnFinalizarServicioSeleccionado().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnFinalizarServicioSeleccionado().setBounds(220, 338, 288, 36);
		getBtnFinalizarServicioSeleccionado().addActionListener(ventanaPrincipal.getController().getFinalizarServicioController());
		add(getBtnFinalizarServicioSeleccionado());
		btnFinalizarServicioSeleccionado.setEnabled(false);
		
		setBtnRegresar(new JButton("Regresar"));
		getBtnRegresar().setForeground(new Color(255, 255, 255));
		getBtnRegresar().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnRegresar().setBackground(new Color(128, 0, 0));
		getBtnRegresar().setBounds(578, 448, 116, 36);
		getBtnRegresar().addActionListener(ventanaPrincipal.getController().getFinalizarServicioController());
		add(getBtnRegresar());
	}

	public void enableBtnFinalizar()
	{
		this.btnFinalizarServicioSeleccionado.setEnabled(true);
	}
	public JButton getBtnFinalizarServicioSeleccionado() {
		return btnFinalizarServicioSeleccionado;
	}

	public void setBtnFinalizarServicioSeleccionado(JButton btnFinalizarServicioSeleccionado) {
		this.btnFinalizarServicioSeleccionado = btnFinalizarServicioSeleccionado;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar)
	{
		this.btnRegresar = btnRegresar;
	}
}
