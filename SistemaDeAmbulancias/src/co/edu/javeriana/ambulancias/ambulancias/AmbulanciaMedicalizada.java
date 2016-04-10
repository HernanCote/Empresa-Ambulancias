package co.edu.javeriana.ambulancias.ambulancias;

import co.edu.javeriana.ambulancias.presentacion.Utils;

public abstract class AmbulanciaMedicalizada extends Ambulancia{
	protected String tipo;
	protected String medico;

	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
	}

	@Override
	public long calcularTarifa() {
		return super.calcularTarifa();
	}

	@Override
	public void printSelf() {
		//String actualService = null;
		//if(this.getServicioActual() == 0) actualService = "NA";
		//else  actualService = Integer.toString((int)this.getServicioActual());
		
		System.out.format("%5s%15s%15s%14s%24s%20s%20s%23s%n", tipo,codigo, this.placa, this.medico, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, this.calcularTarifa());			
		
	}

}
