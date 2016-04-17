package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * Represents an ambulance with a doctor on board.
 * Inheres methods and attributes of AmbulanciaMedicalizada.
 * @author JuanPablo and Hernan Cote
 *
 */
public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	
	/**
	 * Constructs an Ambulance with the attributes that enter in the parameters.
	 * @param codigo
	 * @param placa
	 * @param medico
	 * @param tipoUCI
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
		this.tipo = "UCI";
	}

	/**
	 * Gets the type of ICU
	 * @return
	 */
	public String getTipoUCI() {
		return tipoUCI;
	}
	
	/**
	 * Sets the type of ICU with the value that enters in the parameter.
	 * @param tipoUCI
	 */
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}

	/**
	 * Calculates the total amount to pay for the ambulance.
	 */
	@Override
	public long calcularTarifa() {
		long total = 0;
		if(this.tipoUCI.equals("CARDIOVASCULAR"))
		{
			total = TARIFA_BASE + (long)(TARIFA_BASE * 0.5);
		}
		else if(this.tipoUCI.equals("PEDIATRICA"))
		{
			total = TARIFA_BASE + (long)(TARIFA_BASE * 0.6);
		}
		return total;
	}

	/**
	 * Prints the ambulance in the required format.
	 */
	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%5s%20s%10s%23s%20s%11s%10s%10s%16s%n", this.tipo, codigo, this.placa,  this.medico, this.tipoUCI, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));
	}
	
	
}
