package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * 
 * Represents an ambulance that has no doctor but has 
 * a nourse.
 * @author JuanPablo and Hernan Cote
 *
 */

public class AmbulanciaNoMedicalizada extends Ambulancia{
	public static final String LABEL_TIPO_AMBULANCIA = "NO MEDICALIZADA";
	private String enfermero;

	/**
	 * Constructs an ambulance of this type 
	 * @param codigo
	 * @param placa
	 * @param enfermero
	 */
	public AmbulanciaNoMedicalizada(int codigo, String placa, String enfermero) {
		super(codigo, placa);
		this.enfermero = enfermero;
	}

	/**
	 * Gets the attribute of the nurse.
	 * @return
	 */
	public String getEnfermo() {
		return enfermero;
	}

	/**
	 * Sets the attribute of the name of the nurse to a new value that enters 
	 * in the parameters.
	 * @param enfermo
	 */
	public void setEnfermo(String enfermo) {
		this.enfermero = enfermo;
	}

	/**
	 * Returns the amout to pay for the ambulance.
	 */
	@Override
	public long calcularTarifa() {
		return Ambulancia.TARIFA_BASE;
	}

	/**
	 * Prints the ambulance in the required format.
	 */
	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%16s%9s%10s%18s%36s%10s%10s%16s%n", LABEL_TIPO_AMBULANCIA, this.codigo, this.placa,  this.enfermero, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));
	}
}
