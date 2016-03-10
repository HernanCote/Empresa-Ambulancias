/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;

/**
 * @author v-heco
 *
 */
public class IPS 
{
	private String nombre;
	private String tipoAtencion;
	private Direccion direccion;
	private ArrayList<Servicio> servicios;
	
	public IPS(String nombre,String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero)
	{
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero);
		this.servicios = new ArrayList<Servicio>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoAtencion() {
		return tipoAtencion;
	}

	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}

	
	public Direccion getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(Direccion direccion) 
	{
		this.direccion = direccion;
	}

	
	public ArrayList<Servicio> getServicios()
	{
		return servicios;
	}

	public void setServicios(Servicio servicios)
	{
		this.servicios.add(servicios);
	}

	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero)
	{
		setDireccion(new Direccion(tipoDireccion, calle, carrera, numero));
	}
	
	public void printSelf()
	{		
		System.out.format("%6s%7s%14s%n", this.nombre, this.tipoAtencion, this.direccion);
	}
		
}
