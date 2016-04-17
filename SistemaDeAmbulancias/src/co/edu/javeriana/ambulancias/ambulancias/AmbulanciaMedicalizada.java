package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * An abstract class to represent shared functionalities
 * and attributes of other ambulances. 
 * @author JuanPablo and Hernan Cote
 *
 */

public abstract class AmbulanciaMedicalizada extends Ambulancia
{
	protected String tipo;
	protected String medico;

	/**
	 * Constructs a AmbulanciaMedicalizada with the values 
	 * that enter as parameters.
	 * @param codigo
	 * @param placa
	 * @param medico
	 */
	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
	}
	
	/**
	 * Gets the type of ambulance
	 * @return type of amnulance
	 */
	public String getTipo()
	{
		return tipo;
	}
	
	/**
	 * Calculates the amount to pay for the ambulance.
	 */
	@Override
	public abstract long calcularTarifa();

	/**
	 * Sets the type of the ambulance to the value that enters 
	 * as parameters.
	 * @param newVal
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the name of the doctor in charge of the ambulance.
	 * @return
	 */
	public String getMedico() {
		return medico;
	}
	
	/**
	 * Sets the doctor to a new value that enters via parameter 
	 * @param medico
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	/**
	 * Prints the information of the Ambulance in the format requiered.
	 */

	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%5s%15s%15s%14s%24s%20s%20s%26s%n", tipo,codigo, this.placa, this.medico, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));			
		
	}

}
