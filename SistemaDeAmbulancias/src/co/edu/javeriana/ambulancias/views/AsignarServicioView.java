package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.javeriana.ambulancias.controllers.AsignarServicioController;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import javax.swing.ImageIcon;

public class AsignarServicioView extends JPanel {
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventaPrincipal;
	private GridLayout gridContent; 
	private JPanel southButtons;
	
	private JButton btnAssignarServicio;
	private JButton btnRegresar;
	
	private TableModel modeloTablaIPS;
	private TableModel modeloTablaAmbulancias;
	private TableModel modeloTablaServicios;
	
	private JTable tablaIPS;
	private JTable tablaAmbulancias;
	private JTable tablaServicios;
	
	private String [] tableLabelsAmbulancia = {"Codigo","Tipo","Tipo UCI","Placa", "Medico / Enfermero","Hora Posicion", "Calle", "Carrera"};
	private String [][] tableContAmbulancias = {};
	
	private String [] tableLabelsIPS = {"Nombre" , "Tipo Atencion" , "Direccion"};
	private String [][] tableContIPS = {};
	
	private String [] tableLabelsServicios = {"Codigo","Hora","Paciente", "Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia"};
	private String [][] tableContServicios = {};
	
	

	/**
	 * Create the panel.
	 */
	public AsignarServicioView(VentanaPrincipal ventanaPrinc) 
	{
		setVentaPrincipal(ventanaPrinc);
		setBackground(Color.WHITE);
		gridContent = new GridLayout(7,1);
		setLayout(gridContent);
		
		setSouthButtons ();
		setUpTableAmbulancia ();
		setUpTableIPS ();
		setUpTableServicios ();
		
	}
	
	public int getSelectedRowCodeServicio () {
		int numRow = tablaServicios.getSelectedRow();
		String tempCode = (String) tablaServicios.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}

	public void setUpTableAmbulancia () {
		JLabel lblNewLabel = new JLabel("Ambulancias");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		modeloTablaAmbulancias = new DefaultTableModel(tableContAmbulancias,tableLabelsAmbulancia);
		tablaAmbulancias = new JTable(modeloTablaAmbulancias);
		add(new JScrollPane(tablaAmbulancias));
	}
	
	public void setUpTableIPS () {
		JLabel lblNewLabel = new JLabel("IPS");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		modeloTablaIPS = new DefaultTableModel(tableContIPS,tableLabelsIPS);
		tablaIPS = new JTable(modeloTablaIPS);
		add(new JScrollPane(tablaIPS));
	}
	
	public void setUpTableServicios () {
		JLabel lblNewLabel = new JLabel("Servicios");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		modeloTablaServicios = new DefaultTableModel(tableContServicios,tableLabelsServicios);
		tablaServicios = new JTable(modeloTablaServicios);
		add(new JScrollPane(tablaServicios));
	}
	
	public void addRowToTableAmbulancia (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsAmbulancia);
		tablaAmbulancias.setModel(modelTemp);
	}
	
	public void addRowToTableIPS (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsIPS);
		tablaIPS.setModel(modelTemp);
	}
	
	public void addRowToTableServicios (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsServicios);
		tablaServicios.setModel(modelTemp);
	}
	
	public void setSouthButtons () {
		JLabel lblNewLabel_5 = new JLabel("Asignar Un Servicio");
		lblNewLabel_5.setForeground(new Color(139, 0, 0));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 11, 264, 30);		
		southButtons = new JPanel();
		southButtons.setBackground(Color.WHITE);
		btnRegresar = new JButton("Regresar");
		btnRegresar.setIcon(new ImageIcon("iconos/back.png"));
		btnRegresar.addActionListener(new AsignarServicioController(ventaPrincipal));
		btnAssignarServicio = new JButton("Asignar Servicio");
		btnAssignarServicio.setIcon(new ImageIcon("iconos/hospital-2.png"));
		btnAssignarServicio.addActionListener(new AsignarServicioController(ventaPrincipal));
		southButtons.add(btnRegresar);
		southButtons.add(lblNewLabel_5);
		southButtons.add(btnAssignarServicio);
		southButtons.setVisible(true);
		add(southButtons);
	}
	
	public VentanaPrincipal getVentaPrincipal() {
		return ventaPrincipal;
	}

	public void setVentaPrincipal(VentanaPrincipal ventaPrincipal) {
		this.ventaPrincipal = ventaPrincipal;
	}

	public GridLayout getGridContent() {
		return gridContent;
	}

	public void setGridContent(GridLayout gridContent) {
		this.gridContent = gridContent;
	}

	public TableModel getModeloTablaIPS() {
		return modeloTablaIPS;
	}

	public void setModeloTablaIPS(TableModel modeloTablaIPS) {
		this.modeloTablaIPS = modeloTablaIPS;
	}

	public TableModel getModeloTablaAmbulancias() {
		return modeloTablaAmbulancias;
	}

	public void setModeloTablaAmbulancias(TableModel modeloTablaAmbulancias) {
		this.modeloTablaAmbulancias = modeloTablaAmbulancias;
	}

	public TableModel getModeloTablaServicios() {
		return modeloTablaServicios;
	}

	public void setModeloTablaServicios(TableModel modeloTablaServicios) {
		this.modeloTablaServicios = modeloTablaServicios;
	}

	public JTable getTablaIPS() {
		return tablaIPS;
	}

	public void setTablaIPS(JTable tablaIPS) {
		this.tablaIPS = tablaIPS;
	}

	public JTable getTablaAmbulancias() {
		return tablaAmbulancias;
	}

	public void setTablaAmbulancias(JTable tablaAmbulancias) {
		this.tablaAmbulancias = tablaAmbulancias;
	}

	public JTable getTablaServicios() {
		return tablaServicios;
	}

	public void setTablaServicios(JTable tablaServicios) {
		this.tablaServicios = tablaServicios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JPanel getSouthButtons() {
		return southButtons;
	}


	public void setSouthButtons(JPanel southButtons) {
		this.southButtons = southButtons;
	}


	public JButton getBtnAssignarServicio() {
		return btnAssignarServicio;
	}


	public void setBtnAssignarServicio(JButton btnAssignarServicio) {
		this.btnAssignarServicio = btnAssignarServicio;
	}


	public JButton getBtnRegresar() {
		return btnRegresar;
	}


	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}


	public String[] getTableLabelsAmbulancia() {
		return tableLabelsAmbulancia;
	}


	public void setTableLabelsAmbulancia(String[] tableLabelsAmbulancia) {
		this.tableLabelsAmbulancia = tableLabelsAmbulancia;
	}


	public String[][] getTableContAmbulancias() {
		return tableContAmbulancias;
	}


	public void setTableContAmbulancias(String[][] tableContAmbulancias) {
		this.tableContAmbulancias = tableContAmbulancias;
	}


	public String[] getTableLabelsIPS() {
		return tableLabelsIPS;
	}


	public void setTableLabelsIPS(String[] tableLabelsIPS) {
		this.tableLabelsIPS = tableLabelsIPS;
	}


	public String[][] getTableContIPS() {
		return tableContIPS;
	}


	public void setTableContIPS(String[][] tableContIPS) {
		this.tableContIPS = tableContIPS;
	}


	public String[] getTableLabelsServicios() {
		return tableLabelsServicios;
	}


	public void setTableLabelsServicios(String[] tableLabelsServicios) {
		this.tableLabelsServicios = tableLabelsServicios;
	}


	public String[][] getTableContServicios() {
		return tableContServicios;
	}


	public void setTableContServicios(String[][] tableContServicios) {
		this.tableContServicios = tableContServicios;
	}
	
	
	
	
}
