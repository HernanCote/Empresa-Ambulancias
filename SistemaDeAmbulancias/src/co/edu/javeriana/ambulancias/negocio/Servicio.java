package co.edu.javeriana.ambulancias.negocio;

import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * 
 * @author Hern�n Cote y Juan Pablo Pe�aloza
 *
 */
public class Servicio 
{
	private IPS ips;
	private Ambulancia ambulancia;
	private static long CONSECUTIVO = 0;
	private long codigo;
	private GregorianCalendar horaSolicitud;
	private String paciente;
	private String tipoServicio;
	private String telefono;
	private String estado;
	private Direccion direccion;
	
	
	public Servicio(String paciente,String tipoServicio, String telefono,Direccion direccion)
	{			
		CONSECUTIVO++;
		this.setCodigo(CONSECUTIVO);
		horaSolicitud = new GregorianCalendar();
		this.paciente = paciente;
		this.tipoServicio = tipoServicio;
		this.telefono = telefono;
		this.estado = "NO_ASIGNADO";
		this.direccion = direccion;
		this.setIps(null);
		this.setAmbulancia(null);
	}
	
	public IPS getIps() {
		return ips;
	}

	public void setIps(IPS ips) {
		this.ips = ips;
	}

	public Ambulancia getAmbulancia() {
		return ambulancia;
	}

	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}

	public GregorianCalendar getHoraSolicitud()
	{
		return horaSolicitud;
	}
	public void setHoraSolicitud(GregorianCalendar horaSolicitud)
	{
		this.horaSolicitud = horaSolicitud;
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getPaciente() 
	{
		return paciente;
	}
	public void setPaciente(String paciente) 
	{
		this.paciente = paciente;
	}
	
	public String getTipoServicio() 
	{
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio)
	{
		this.tipoServicio = tipoServicio;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String getEstado()
	{
		return estado;
	}
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
	
	public Direccion getDireccion()
	{
		return direccion;
	}
	public void setDireccion(Direccion direccion)
	{
		this.direccion = direccion;
	}
	
	
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero)
	{
		setDireccion(new Direccion(tipoDireccion, calle, carrera, numero));
	}
	
	
	public void printSelfAll()
	{	
		System.out.format("%4s%19s%9s%15s%13s%24s%10s%n", this.getCodigo(),Utils.formatoMes(this.horaSolicitud), 
			("     " + this.paciente), this.tipoServicio, this.telefono, this.direccion.toString(), ("    " + this.estado));	
	}
	
	/**
	 * 
	 */
	
	
	public void printAsignados()
	{
		System.out.format("%1s%21s%7s%28s%n", this.getCodigo(), this.getPaciente()
				, this.getAmbulancia().getCodigo(), this.getIps().getNombre());
	}
	
}