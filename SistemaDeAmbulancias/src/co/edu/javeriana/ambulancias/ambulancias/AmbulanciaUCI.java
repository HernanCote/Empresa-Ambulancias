package co.edu.javeriana.ambulancias.ambulancias;

import java.text.DecimalFormat;

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

	@Override
	public void printSelf() {
		DecimalFormat format = new DecimalFormat("##,###.0");
		System.out.format("%5s%20s%10s%23s%20s%11s%10s%10s%16s%n", this.tipo, codigo, this.placa,  this.medico, this.tipoUCI, Utils.formatoHora(this.horaPosicion), 
				this.posicionCalle, this.posicionCarrera, "$" + format.format(this.calcularTarifa()));
	}
	
	
}
