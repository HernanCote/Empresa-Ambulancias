package co.edu.javeriana.ambulancias.ambulancias;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
		this.tipo = "UCI";
	}

	public String getTipoUCI() {
		return tipoUCI;
	}
	
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}

	@Override
	public void printSelf() {
		System.out.format("%5s%20s%10s%23s%20s%11s%10s%10s%13s%n", this.tipo, codigo, this.placa,  this.medico, this.tipoUCI, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, this.calcularTarifa());
	}
	
	
}
