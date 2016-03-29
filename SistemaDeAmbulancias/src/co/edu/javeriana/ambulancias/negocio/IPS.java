/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;



/**
 * IPS.java
 * ------------------------------------------
 * This Class contains the attributes necessary to 
 * describe a hospital or clinic.  
 * @author Hernan Cote and Juan Pablo Penaloza
 *
 */
public class IPS 
{
	private String nombre;
	private String tipoAtencion;
	private Direccion direccion;
	private ArrayList<Servicio> servicios;
	
	/**
	 * Constructs an object IPS with the values that are passed as parameters.  
	 * @param nombre
	 * @param tipoAtencion
	 * @param tipoDireccion
	 * @param calle
	 * @param carrera
	 * @param numero
	 */
	public IPS(String nombre,String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero)
	{
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero);
		this.servicios = new ArrayList<Servicio>();
	}
	
	/**
	 * Gets the name of the IPS
	 * @return name
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Sets the name of the IPS
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Gets the type of care that the IPS can hold 
	 * @return tipoAtencion 
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	/**
	 * Sets the value for the type of care that the IPS can hold.
	 * @param tipoAtencion
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}

	/**
	 * Gets the value of the address.
	 * @return direccion 
	 */
	public Direccion getDireccion() 
	{
		return this.direccion;
	}
	/**
	 * Sets the value for the address
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion) 
	{
		this.direccion = direccion;
	}
	/**
	 * Gets the list of services
	 * @return
	 */
	
	public ArrayList<Servicio> getServicios()
	{
		return servicios;
	}
	/**
	 * Adds a service to the list of services.
	 * @param servicios
	 */
	public void setServicios(Servicio servicios)
	{
		this.servicios.add(servicios);
	}
	/**
	 * Assigns a new value for the address of the IPS
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
	 * This method prints the content of an object of this 
	 * class.
	 */
	
	public void printSelf() {
		System.out.format("%10s%30s%30s%n", this.nombre, this.tipoAtencion, this.direccion);
	}
	
	
		
}
