package co.edu.javeriana.ambulancias.ambulancias;

public class AmbulanciaNoMedicalizada extends Ambulancia{

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
}
