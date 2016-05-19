package co.edu.javeriana.ambulancias.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.javeriana.ambulancias.entidades.Servicio;
import co.edu.javeriana.ambulancias.enums.EstadoServicio;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class FinalizarServicioView extends JPanel 
{
	
	private VentanaPrincipal ventanaPrincipal;
	
	private JTable table;
	
	private JButton btnFinalizarServicioSeleccionado;
	private JButton btnRegresar;
	
	private TableModel modeloServicios;
	
	private String [] tableLabelsServicios = {"Codigo","Hora","Paciente", "Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia"};
	private String [][] tableContServicios = {};
	
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
		
		
		modeloServicios = new DefaultTableModel(tableContServicios, tableLabelsServicios);
		setTable(new JTable(modeloServicios));
		scrollPane.setViewportView(getTable());
		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				enableBtnFinalizar();
			}
		});
		setBtnFinalizarServicioSeleccionado(new JButton("Finalizar servicio seleccionado"));
		getBtnFinalizarServicioSeleccionado().setBackground(SystemColor.textHighlight);
		getBtnFinalizarServicioSeleccionado().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnFinalizarServicioSeleccionado().setBounds(220, 338, 288, 36);
		getBtnFinalizarServicioSeleccionado().addActionListener(ventanaPrincipal.getController().getFinalizarServicioController());
		add(getBtnFinalizarServicioSeleccionado());
		btnFinalizarServicioSeleccionado.setEnabled(false);
		
		setBtnRegresar(new JButton("Regresar"));
		getBtnRegresar().setForeground(Color.GRAY);
		getBtnRegresar().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getBtnRegresar().setBackground(new Color(128, 0, 0));
		getBtnRegresar().setBounds(578, 448, 116, 36);
		getBtnRegresar().addActionListener(ventanaPrincipal.getController().getFinalizarServicioController());
		add(getBtnRegresar());
	}

	public void addRowToTableServicios (Object newCont [][]) 
	{
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsServicios);
		getTable().setModel(modelTemp);
	}
	
	public int getSelectedRowCodeServicio () {
		int numRow = table.getSelectedRow();
		String tempCode = (String) table.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}
	
	public void finalizarServicio(int codigo)
	{
		Servicio servicio = ventanaPrincipal.getEmpresaAmbulancias().getServicioById(codigo);
		if(servicio  != null)
		{
			if(servicio.getEstado() == EstadoServicio.ASIGNADO)
			{
				//servicio.setEstado(EstadoServicio.FINALIZADO);
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "El servicio se ha finalizado exitosamente!"
						, "Exito"
						, JOptionPane.INFORMATION_MESSAGE);
				
				ventanaPrincipal.getController().getAsignarServicioController().actualizarContServicios();
				ventanaPrincipal.getController().getFinalizarServicioController().actualizarContServicios();
				ventanaPrincipal.getEmpresaAmbulancias().finalizarUnServicio(codigo); // NEW
			}
			else if(servicio.getEstado() == EstadoServicio.NO_ASIGNADO)
			{
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "El servicio especificado no ha sido asignado por lo que no puede ser finalizado!"
						, "ATENCION"
						, JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(ventanaPrincipal
						, "El servicio especificado ya ha sido finalizado"
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(ventanaPrincipal
					, "El c�digo del servicio no existe!"
					, "Error"
					, JOptionPane.ERROR_MESSAGE);
		}
		disableBtnFinalizar();
	}
	
	public void enableBtnFinalizar()
	{
		this.btnFinalizarServicioSeleccionado.setEnabled(true);
	}
	
	public void disableBtnFinalizar()
	{
		this.btnFinalizarServicioSeleccionado.setEnabled(false);
	}
	public JButton getBtnFinalizarServicioSeleccionado() {
		return btnFinalizarServicioSeleccionado;
	}

	public void setBtnFinalizarServicioSeleccionado(JButton btnFinalizarServicioSeleccionado) {
		this.btnFinalizarServicioSeleccionado = btnFinalizarServicioSeleccionado;
		btnFinalizarServicioSeleccionado.setIcon(new ImageIcon("iconos/pencil.png"));
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar)
	{
		this.btnRegresar = btnRegresar;
		btnRegresar.setIcon(new ImageIcon("iconos/hospital-1.png"));
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
