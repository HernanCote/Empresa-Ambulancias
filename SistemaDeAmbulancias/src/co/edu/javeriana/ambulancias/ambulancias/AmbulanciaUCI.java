package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.enums.TipoUCI;
import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * Represents an ambulance with a doctor on board.
 * Inheres methods and attributes of AmbulanciaMedicalizada.
 * @author JuanPablo and Hernan Cote
 *
 */
public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private TipoUCI tipoUCI;
	
	/**
	 * Constructs an Ambulance with the attributes that enter in the parameters.
	 * @param codigo
	 * @param placa
	 * @param medico
	 * @param tipoUCI
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, TipoUCI tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
	}

	/**
	 * Gets the type of ICU
	 * @return
	 */
	public TipoUCI getTipoUCI() {
		return tipoUCI;
	}
	
	/**
	 * Sets the type of ICU with the value that enters in the parameter.
	 * @param tipoUCI
	 */
	public void setTipoUCI(TipoUCI tipoUCI) {
		this.tipoUCI = tipoUCI;
	}

	/**
	 * Calculates the total amount to pay for the ambulance.
	 */
	@Override
	public long calcularTarifa() {
		long total = 0;
		if(this.tipoUCI.equals(TipoUCI.CARDIOVASCULAR))
		{
			total = TARIFA_BASE + (long)(TARIFA_BASE * 0.5);
		}
		else if(this.tipoUCI.equals(TipoUCI.PEDIATRICA))
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
		System.out.format("%5s%20s%10s%23s%20s%11s%10s%10s%16s%n", "UCI", codigo, this.placa,  this.medico, this.tipoUCI, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));
	}
	
	
}
