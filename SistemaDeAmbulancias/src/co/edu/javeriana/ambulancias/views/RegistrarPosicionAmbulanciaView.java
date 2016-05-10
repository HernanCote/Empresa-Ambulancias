package co.edu.javeriana.ambulancias.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import co.edu.javeriana.ambulancias.controllers.RegistrarPosicionAmbulanciaController;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPosicionAmbulanciaView extends JPanel 
{

	private static final long serialVersionUID = 1L;
	
	private JButton btnActualizar, btnRegistrar;
	private JPanel panelSouth;
	private JLabel lblCalle;
	private JTextField textFieldCalle;
	private JLabel lblCarrera;
	private JTextField textFieldCarrera;
	private JPanel panelNorth;
	private JLabel lblNewLabel;
	private JTable tableAmbulancias;
	private String [] tableLabels = {"Codigo","Tipo","Placa","Tipo UCI","Hora Posicion", "Calle", "Carrera"};
	private String [][] tableCont = {{"Codigo","Tipo","Placa","Tipo UCI","Hora Posicion", "Calle", "Carrera"}
			};
	
	
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

	public RegistrarPosicionAmbulanciaView() 
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		panelSouth = new JPanel();
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new RegistrarPosicionAmbulanciaController(this));
		btnRegistrar = new JButton("Registrar");
		panelSouth.add(btnActualizar);
		panelSouth.add(btnRegistrar);
		add(panelSouth, BorderLayout.SOUTH);
		
		lblCalle = new JLabel("Calle:");
		panelSouth.add(lblCalle);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setToolTipText("Calle en la que está la ambulancia.\n");
		panelSouth.add(textFieldCalle);
		textFieldCalle.setColumns(5);
		
		lblCarrera = new JLabel("Carrera:");
		panelSouth.add(lblCarrera);
		
		textFieldCarrera = new JTextField();
		textFieldCarrera.setToolTipText("Carrera en la que está la ambulancia.");
		panelSouth.add(textFieldCarrera);
		textFieldCarrera.setColumns(5);
		
		panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Ambulancias");
		panelNorth.add(lblNewLabel);
		
		
		tableAmbulancias = new JTable(tableCont,tableLabels);
		tableAmbulancias.setBounds(50,50,200,200);
		tableAmbulancias.setVisible(true);
		add(new JScrollPane(tableAmbulancias));
		
		
	}
}
