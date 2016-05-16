package co.edu.javeriana.ambulancias.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.javeriana.ambulancias.controllers.RegistrarPosicionAmbulanciaController;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.entidades.IServiciosAmbulancias;
import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import java.awt.Font;

public class RegistrarPosicionAmbulanciaView extends JPanel 
{

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	
	private VentanaPrincipal ventanaPrincipal;
	
	private JButton btnActualizar, btnRegistrar;
	private JPanel panelSouth;
	private JLabel lblCalle;
	private JTextField textFieldCalle;
	private JLabel lblCarrera;
	private JTextField textFieldCarrera;
	private JPanel panelNorth;
	private JLabel lblNewLabel;
	private JTable tableAmbulancias;

	

	private TableModel modelAmbulancias;
	private String [] tableLabels = {"Codigo","Tipo","Tipo UCI","Placa", "Medico / Enfermero","Hora Posicion", "Calle", "Carrera"};
	private String [][] tableCont = {};
	private JButton btnRegresar;

	public RegistrarPosicionAmbulanciaView(VentanaPrincipal ventanaPrincipal) 
	{
		this.ventanaPrincipal = ventanaPrincipal;
		setTabbedPane(tabbedPane);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		panelSouth = new JPanel();
		panelSouth.setBackground(new Color(255, 255, 255));
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(102, 205, 170));
		btnActualizar.addActionListener(ventanaPrincipal.getController().getRegistrarPosicionAmbulanciaController());
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(50, 205, 50));
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(ventanaPrincipal.getController().getRegistrarPosicionAmbulanciaController());
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBackground(new Color(128, 0, 0));
		panelSouth.add(btnRegresar);
		panelSouth.add(btnActualizar);
		panelSouth.add(btnRegistrar);
		btnRegresar.addActionListener(ventanaPrincipal.getController().getRegistrarPosicionAmbulanciaController());
		add(panelSouth, BorderLayout.SOUTH);
		
		setLabels ();
		
		modelAmbulancias = new DefaultTableModel(tableCont,tableLabels);
		tableAmbulancias = new JTable(modelAmbulancias);
		tableAmbulancias.setBackground(new Color(255, 255, 255));
		tableAmbulancias.setBounds(50,50,200,200);
		tableAmbulancias.setVisible(true);
		tableAmbulancias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				enableButons(); 
			}
		});
		
		add(new JScrollPane(tableAmbulancias));
	}

	public void addRowToTable (Object newCont [][]) {
		DefaultTableModel modelTemp = new DefaultTableModel(newCont,tableLabels);
		tableAmbulancias.setModel(modelTemp);
	}
	
	public int getSelectedRowCode () {
		int numRow = tableAmbulancias.getSelectedRow();
		String tempCode = (String) tableAmbulancias.getValueAt(numRow, 0);
		int code = Integer.parseInt(tempCode);
		return code;
	}

	
	public void enableButons () {
		btnRegistrar.setEnabled(true);
		textFieldCalle.setEnabled(true);
		textFieldCarrera.setEnabled(true);
	}
	
	public void setLabels () {
		lblCalle = new JLabel("Calle:");
		panelSouth.add(lblCalle);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setEnabled(false);
		textFieldCalle.setToolTipText("Calle en la que está la ambulancia.\n");
		panelSouth.add(textFieldCalle);
		textFieldCalle.setColumns(5);
		
		lblCarrera = new JLabel("Carrera:");
		panelSouth.add(lblCarrera);
		
		textFieldCarrera = new JTextField();
		textFieldCarrera.setEnabled(false);
		textFieldCarrera.setToolTipText("Carrera en la que está la ambulancia.");
		panelSouth.add(textFieldCarrera);
		textFieldCarrera.setColumns(5);
		
		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(255, 255, 255));
		add(panelNorth, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Ambulancias disponibles en el sistema");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panelNorth.add(lblNewLabel);
	}
	
	public String[][] getTableCont() {
		return tableCont;
	}

	public void setTableCont(String[][] tableCont) {
		this.tableCont = tableCont;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JLabel getLblCalle() {
		return lblCalle;
	}

	public void setLblCalle(JLabel lblCalle) {
		this.lblCalle = lblCalle;
	}

	public JTextField getTextFieldCalle() {
		return textFieldCalle;
	}

	public void setTextFieldCalle(JTextField textFieldCalle) {
		this.textFieldCalle = textFieldCalle;
	}

	public JLabel getLblCarrera() {
		return lblCarrera;
	}

	public void setLblCarrera(JLabel lblCarrera) {
		this.lblCarrera = lblCarrera;
	}

	public JTextField getTextFieldCarrera() {
		return textFieldCarrera;
	}

	public void setTextFieldCarrera(JTextField textFieldCarrera) {
		this.textFieldCarrera = textFieldCarrera;
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JTable getTableAmbulancias() {
		return tableAmbulancias;
	}

	public void setTableAmbulancias(JTable tableAmbulancias) {
		this.tableAmbulancias = tableAmbulancias;
	}

	public String[] getTableLabels() {
		return tableLabels;
	}

	public void setTableLabels(String[] tableLabels) {
		this.tableLabels = tableLabels;
	}

	public TableModel getModelAmbulancias() {
		return modelAmbulancias;
	}

	public void setModelAmbulancias(TableModel modelAmbulancias) {
		this.modelAmbulancias = modelAmbulancias;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	
	
	
}
