package co.edu.javeriana.ambulancias.ambulancias;

public class AmbulanciaUCI extends AmbulanciaMedicalizada{

	private String tipoUCI;
	
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
	}

	public String getTipoUCI() {
		return tipoUCI;
	}
	
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}
}
