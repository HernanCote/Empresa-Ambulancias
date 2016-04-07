package co.edu.javeriana.ambulancias.ambulancias;

public abstract class AmbulanciaMedicalizada extends Ambulancia{
	protected String medico;

	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
	}

	@Override
	public long calcularTarifa() {
		return super.calcularTarifa();
	}

}
