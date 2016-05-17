package co.edu.javeriana.ambulancias.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;

public class ReporteServiciosAsignados extends JPanel {
	private static final long serialVersionUID = 1L;

	private VentanaPrincipal ventanaPrincipal;	
	
	private GridLayout gridContent; 
	private JPanel southButtons;
	
	private JButton btnMostrar;
	private JButton btnRegresar;
	
	private JTable tablaServicios;
	private JTable tablaIPS;
	private JTable tablaAmbulancia;
	
	private TableModel modelTablaServicios;
	private TableModel modelTablaIPS;
	private TableModel modelTablaAmbulancia;
	
	private String [] tableLabelsAmbulancia = {"Codigo","Tipo","Tipo UCI","Placa", "Medico / Enfermero","Hora Posicion", "Calle", "Carrera", "Tarifa"};
	private String [][] tableContAmbulancias = {};
	
	private String [] tableLabelsIPS = {"Nombre" , "Tipo Atencion" , "Direccion"};
	private String [][] tableContIPS = {};
	
	private String [] tableLabelsServicios = {"Codigo","Hora","Paciente", "Tipo Servicio","Telefono","Direccion","Estado","IPS","Ambulancia","Valor"};
	private String [][] tableContServicios = {};
	
	
	public ReporteServiciosAsignados(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
		
		setBackground(Color.WHITE);
		gridContent = new GridLayout(8,1);
		setLayout(gridContent);
		setUpTittle();
		setUpTableServicios ();
		setUpButtons();
		setUpTableIPS();
		setUpTableAmbulancia();
	}
	
	
	public void setUpTableServicios () {
		
		
		JLabel lblNewLabel = new JLabel("Servicios");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		
		modelTablaServicios = new DefaultTableModel(tableContServicios,tableLabelsServicios);
		tablaServicios = new JTable(modelTablaServicios);
		tablaServicios.setVisible(true);
		JScrollPane scrollPane = new JScrollPane(tablaServicios);
		scrollPane.setBounds(0, 128, 345, -128);
		add(scrollPane);
	}
	
	public int getSelectedRowCodeServicio () {
		int numRow = tablaServicios.getSelectedRow();
		String tempCode = (String) tablaServicios.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}
	
	public void addRowToTableIPS (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsIPS);
		tablaIPS.setModel(modelTemp);
	}
	
	public void addRowToTableAmbulancias (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsAmbulancia);
		tablaAmbulancia.setModel(modelTemp);
	}
	
	public void addRowToTableServicios (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabelsServicios);
		tablaServicios.setModel(modelTemp);
	}
	
	public void setUpTableIPS () {
		JLabel lblNewLabel = new JLabel("IPS");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		
		modelTablaIPS = new DefaultTableModel(tableContIPS, tableLabelsIPS);
		tablaIPS = new JTable(modelTablaIPS);
		tablaIPS.setVisible(true);
		JScrollPane scrollPane = new JScrollPane(tablaIPS);
		add(scrollPane);
	}
	
	public void setUpTableAmbulancia () {
		JLabel lblNewLabel = new JLabel("Ambulancia");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel);
		
		modelTablaAmbulancia = new DefaultTableModel(tableContAmbulancias, tableLabelsAmbulancia);
		tablaAmbulancia = new JTable(modelTablaAmbulancia);
		tablaAmbulancia.setVisible(true);
		JScrollPane scrollPane = new JScrollPane(tablaAmbulancia);
		add(scrollPane);
	}
	
	public void setUpButtons () {
		southButtons = new JPanel(new GridBagLayout());
		southButtons.setBackground(Color.WHITE);
		btnMostrar = new JButton("Mostrar");
		btnRegresar = new JButton("Regresar");
		
		btnMostrar.addActionListener(new ReporteServiciosAsignadosController (ventanaPrincipal));
		btnRegresar.addActionListener(new ReporteServiciosAsignadosController (ventanaPrincipal) );
		southButtons.add(btnMostrar);
		southButtons.add(btnRegresar);
		add(southButtons);
	}
	
	public void setUpTittle () {
		JLabel lblNewLabel_5 = new JLabel("Reporte Servicios Con IPS Y Ambulancias Asignados");
		lblNewLabel_5.setForeground(new Color(139, 0, 0));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 11, 264, 30);
		add(lblNewLabel_5);
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public JTable getTableServicios() {
		return tablaServicios;
	}

	public void setTableServicios(JTable tableServicios) {
		this.tablaServicios = tableServicios;
	}

	public JTable getTablaIPS() {
		return tablaIPS;
	}

	public void setTablaIPS(JTable tablaIPS) {
		this.tablaIPS = tablaIPS;
	}

	public JTable getTablaAmbulancia() {
		return tablaAmbulancia;
	}

	public void setTablaAmbulancia(JTable tablaAmbulancia) {
		this.tablaAmbulancia = tablaAmbulancia;
	}

	public TableModel getModelTablaServicios() {
		return modelTablaServicios;
	}

	public void setModelTablaServicios(TableModel modelTablaServicios) {
		this.modelTablaServicios = modelTablaServicios;
	}

	public TableModel getModelTablaIPS() {
		return modelTablaIPS;
	}

	public void setModelTablaIPS(TableModel modelTablaIPS) {
		this.modelTablaIPS = modelTablaIPS;
	}

	public TableModel getModelTablaAmbulancia() {
		return modelTablaAmbulancia;
	}

	public void setModelTablaAmbulancia(TableModel modelTablaAmbulancia) {
		this.modelTablaAmbulancia = modelTablaAmbulancia;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public void setBtnMostrar(JButton btnMostrar) {
		this.btnMostrar = btnMostrar;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
