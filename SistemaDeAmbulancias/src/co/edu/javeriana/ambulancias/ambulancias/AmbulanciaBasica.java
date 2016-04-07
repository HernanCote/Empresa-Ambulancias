package co.edu.javeriana.ambulancias.ambulancias;

public class AmbulanciaBasica extends AmbulanciaMedicalizada {
	
	public static final double INCREMENTO_TARIFA = 1.2;

	public AmbulanciaBasica(int codigo, String placa, String medico) {
		super(codigo, placa, medico);
	}



	@Override
	public long calcularTarifa() {
		return (long) (super.calcularTarifa() * INCREMENTO_TARIFA);
	}
	
	
}
