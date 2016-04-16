package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaBasica extends AmbulanciaMedicalizada {
	
	public static final double INCREMENTO_TARIFA = 1.2;

	public AmbulanciaBasica(int codigo, String placa, String medico) {
		super(codigo, placa, medico);
		this.tipo = "BASICA";
	}

	@Override
	public long calcularTarifa() {
		return (long) (Ambulancia.TARIFA_BASE * INCREMENTO_TARIFA);
	}

	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%8s%17s%10s%24s%30s%10s%10s%16s%n", this.tipo, codigo, this.placa, this.medico, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));	
	}
	
	
	
}
