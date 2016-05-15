package co.edu.javeriana.ambulancias.views;

import java.awt.Color;

import javax.swing.JPanel;

import co.edu.javeriana.ambulancias.presentacion.VentanaPrincipal;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RegistrarUnServicioView extends JPanel 
{

	private VentanaPrincipal ventanaPrincipal;
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
		lblNewLabel_2.setBounds(253, 226, 46, 14);
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
	}
}
