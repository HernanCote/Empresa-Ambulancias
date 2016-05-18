package co.edu.javeriana.ambulancias.views;

import java.awt.Color;

import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ReporteServiciosAsociadosView extends JPanel {

	private VentanaPrincipal ventanaPrincipal;
	
	private JComboBox<String> comboIPS;
	
	private JTable table;
	private JLabel lblIPS;
	
	private String [] tableLabelsIPS = {"Código" , "Hora Solicitud", "Paciente", "Tipo Servicio", "Teléfono", "Direccion", "Estado", "Ambulancia" };
	private String [][] tableContIPS = {};
	
	private TableModel modelTablaIPS;
	
	private JButton btnRegresar;
	
	/**
	 * Create the panel.
	 */
	public ReporteServiciosAsociadosView(VentanaPrincipal ventanaPrincipal)
	{
		this.ventanaPrincipal = ventanaPrincipal;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de IPS con servicios asociados");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 11, 343, 25);
		add(lblNewLabel);
		
		JLabel lblSeleccionIps = new JLabel("Seleccione una IPS:");
		lblSeleccionIps.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccionIps.setForeground(Color.GRAY);
		lblSeleccionIps.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSeleccionIps.setBounds(231, 109, 198, 19);
		add(lblSeleccionIps);
		
		comboIPS = new JComboBox<String>();
		comboIPS.setBackground(Color.WHITE);
		getComboIPS().setBounds(452, 108, 252, 20);
		comboIPS.addItem("Seleccione una opcion");
		comboIPS.addActionListener(ventanaPrincipal.getController().getReporteServiciosAsociadosController());
		add(getComboIPS());
		
		modelTablaIPS = new DefaultTableModel(tableContIPS, tableLabelsIPS);
		table = new JTable(modelTablaIPS);
		table.setVisible(true);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 246, 669, 143);
		add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Servicios Asignados a la IPS :");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 189, 234, 31);
		add(lblNewLabel_1);
		
		lblIPS = new JLabel("");
		lblIPS.setForeground(Color.LIGHT_GRAY);
		lblIPS.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblIPS.setBounds(274, 189, 343, 31);
		add(lblIPS);
		
		setBtnRegresar(new JButton("Regresar"));
		getBtnRegresar().setBackground(new Color(139, 0, 0));
		getBtnRegresar().setForeground(new Color(255, 255, 255));
		getBtnRegresar().setBounds(603, 452, 101, 31);
		btnRegresar.addActionListener(ventanaPrincipal.getController().getReporteServiciosAsociadosController());
		add(getBtnRegresar());
	}
	

	public void cambioComboBoxIps() 
	{		
		int num = comboIPS.getItemCount();
		int seleccion = comboIPS.getSelectedIndex();

		if (seleccion < num && seleccion > -1) 
		{
			String nombreIps = comboIPS.getSelectedItem().toString();
			if(nombreIps.equals("Seleccione una opcion"))
			{
				this.lblIPS.setText(null);
			}
			else
			{
				this.lblIPS.setText(nombreIps);
			}
			
			String[][] temp = ventanaPrincipal.getEmpresaAmbulancias().getTableServiciosByIps(nombreIps);			
			addRowToTableIPS(temp);			
		}
	}
	
	public void addRowToTableIPS (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsIPS);
		table.setModel(modelTemp);
	}
	
	public void actualizarComboIps(String nombreIps)
	{
		this.comboIPS.addItem(nombreIps);
	}

	public JComboBox<String> getComboIPS() 
	{
		return comboIPS;
	}

	public String [] getTableLabelsIPS() {
		return tableLabelsIPS;
	}

	public void setTableLabelsIPS(String [] tableLabelsIPS) {
		this.tableLabelsIPS = tableLabelsIPS;
	}

	public String [][] getTableContIPS() {
		return tableContIPS;
	}

	public void setTableContIPS(String [][] tableContIPS) {
		this.tableContIPS = tableContIPS;
	}

	public TableModel getModelTablaIPS() {
		return modelTablaIPS;
	}

	public void setModelTablaIPS(TableModel modelTablaIPS) {
		this.modelTablaIPS = modelTablaIPS;
	}


	public JLabel getLblIPS() {
		return lblIPS;
	}


	public void setLblIPS(JLabel lblIPS) {
		this.lblIPS = lblIPS;
	}


	public JButton getBtnRegresar() {
		return btnRegresar;
	}


	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}


	
}
