package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaNoMedicalizada extends Ambulancia{
	public static final String LABEL_TIPO_AMBULANCIA = "NoMedicalizada";
	private String enfermero;

	public AmbulanciaNoMedicalizada(int codigo, String placa, String enfermero) {
		super(codigo, placa);
		this.enfermero = enfermero;
	}

	public String getEnfermo() {
		return enfermero;
	}

	public void setEnfermo(String enfermo) {
		this.enfermero = enfermo;
	}

	@Override
	public long calcularTarifa() {
		return super.calcularTarifa();
	}

	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%16s%9s%10s%18s%36s%10s%10s%16s%n", LABEL_TIPO_AMBULANCIA, this.codigo, this.placa,  this.enfermero, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));
	}
}
