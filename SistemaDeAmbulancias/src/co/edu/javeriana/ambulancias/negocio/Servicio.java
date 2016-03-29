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
	/**
	 * Gets the IPS
	 * @return
	 */
	public IPS getIps() {
		return ips;
	}
	/**
	 * Sets the value of the IPS
	 * @param ips
	 */
	public void setIps(IPS ips) {
		this.ips = ips;
	}
	/**
	 * Gets the ambulance assigned to the service.
	 * @return
	 */
	public Ambulancia getAmbulancia() {
		return ambulancia;
	}
	/**
	 * Assigns an ambulance to the service.
	 * @param ambulancia
	 */
	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}
	/**
	 * Gets the hour the service was applied.
	 * @return
	 */
	public GregorianCalendar getHoraSolicitud()
	{
		return horaSolicitud;
	}
	/**
	 * Sets the the hour the service was applied.
	 * @param horaSolicitud
	 */
	public void setHoraSolicitud(GregorianCalendar horaSolicitud)
	{
		this.horaSolicitud = horaSolicitud;
	}
	
	/**
	 * Gets the code of the service
	 * @return
	 */
	
	public long getCodigo() {
		return codigo;
	}
	/**
	 * Set the value of the code.
	 * @param codigo
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	/**
	 * Gets the name of the paciente.
	 * @return
	 */
	public String getPaciente() 
	{
		return paciente;
	}
	/**
	 * Sets the name of the paciente.
	 * @param paciente
	 */
	public void setPaciente(String paciente) 
	{
		this.paciente = paciente;
	}
	/**
	 * Gets the type of service
	 * @return
	 */
	public String getTipoServicio() 
	{
		return tipoServicio;
	}
	/**
	 * Sets the type of service.
	 * @param tipoServicio
	 */
	public void setTipoServicio(String tipoServicio)
	{
		this.tipoServicio = tipoServicio;
	}
	/**
	 * Gets the phone number.
	 * @return
	 */
	public String getTelefono()
	{
		return telefono;
	}
	/**
	 * Sets the phone number 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	/**
	 * Gets the state of the service.
	 * @return
	 */
	public String getEstado()
	{
		return estado;
	}
	/**
	 * Sets the state of the service.
	 * @param estado
	 */
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
	/**
	 * Gets the address.
	 * @return
	 */
	public Direccion getDireccion()
	{
		return direccion;
	}
	/**
	 * Sets the address
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion)
	{
		this.direccion = direccion;
	}
	
	/**
	 * Assigns the address.
	 * @param tipoDireccion
	 * @param calle
	 * @param carrera
	 * @param numero
	 */
	
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero)
	{
		setDireccion(new Direccion(tipoDireccion, calle, carrera, numero));
	}
	/**
	 * Prints the content of the IPS in a format that matches the style
	 * of the platform. 
	 */
	
	public void printSelfAll()
	{	
		System.out.format("%4s%19s%9s%15s%13s%24s%10s%n", this.getCodigo(),Utils.formatoMes(this.horaSolicitud), 
			("     " + this.paciente), this.tipoServicio, this.telefono, this.direccion.toString(), ("    " + this.estado));	
	}
	
	/**
	 * Prints the content of the IPS in a format that matches the style
	 * of the platform. 
	 */
	
	public void printAsignados()
	{
		System.out.format("%1s%21s%7s%28s%n", this.getCodigo(), this.getPaciente()
				, this.getAmbulancia().getCodigo(), this.getIps().getNombre());
	}
	
}