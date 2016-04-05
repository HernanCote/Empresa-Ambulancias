
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * Ambulancia.java
 * ----------------------------------------------------------
 * The Ambulancia class makes a real life approximation
 * of a real world ambulance. In the program it can be 
 * assigned to different services. 
 * @author JuanPablo and Hernan Cote
 * @version 2.0
 */

public class Ambulancia 
{
	private int codigo;
	private String placa;
	private String tipoDotacion;
	private GregorianCalendar horaPosicion;
	private int posicionCalle;
	private int posicionCarrera;
	private ArrayList<Servicio> servicios;
	private long servicioActual;
	private boolean estado;
	
	/**
	 * Constructs an Ambulancia with three different parameters 
	 * that are the code, placa and type of ambulance. 
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 * @return Ambulancia
	 */
	public Ambulancia(int codigo, String placa, String tipoDotacion)
	{	
		this.setEstado(false);
		this.servicios = new ArrayList<Servicio>();
		this.codigo = codigo;
		this.placa = placa;
		this.tipoDotacion = tipoDotacion;
		this.horaPosicion = null;
		this.posicionCalle = 1;
		this.posicionCarrera = 1;		
	}
	/**
	 * Gets the list of services.
	 * @return ArrayList<Servicio> 
	 */
	public ArrayList<Servicio> getServicios()
	{
		if(!servicios.isEmpty())
		{
			return servicios;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Adds a service to the list of services 
	 * of the ambulance.
	 * @param servicio new val
	 */
	public void setServicios(Servicio servicio)
	{
		this.servicios.add(servicio);
		this.setServicioActual(servicio.getCodigo());
		this.estado = true;
	}
	/**
	 * Returns the code of the ambulance.
	 * @return code of the ambulance. 
	 */
	public int getCodigo() 
	{
		return codigo;
	}
	/**
	 * Sets a new value for the code.
	 * @param codigo
	 */
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	/**
	 * Returns the placa of the ambulance.
	 * @return String Placa
	 */
	public String getPlaca() 
	{
		return placa;
	}
	/**
	 * Sets a new value for the placa.
	 * @param placa
	 */
	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}
	/**
	 * Returns the type of ambulance.
	 * @return the type of ambulance
	 */
	public String getTipoDotacion()
	{
		return tipoDotacion;
	}
	/**
	 * Sets the value type of ambulance to a new one. 
	 * @param tipoDotacion
	 */
	public void setTipoDotacion(String tipoDotacion) 
	{
		this.tipoDotacion = tipoDotacion;
	}
	/**
	 * Gets the last hour of position of the ambulance
	 * @return GregorianCalendar last hour of position
	 */
	public GregorianCalendar getHoraPosicion() 
	{
		return horaPosicion;
	}
	/**
	 * Sets the last hour of position to a new value.
	 * @param horaPosicion The new value for horaPosicion
	 */
	
	public void setHoraPosicion(GregorianCalendar horaPosicion) 
	{
		this.horaPosicion = horaPosicion;
	}
	
	/**
	 * Gets the value for calle
	 * @return The street of the ambulance
	 */
	public int getPosicionCalle() 
	{
		return posicionCalle;
	}
	/**
	 * Sets the value of the street to a new value.
	 * @param posicionCalle new value of the street.
	 */
	public void setPosicionCalle(int posicionCalle) 
	{
		this.posicionCalle = posicionCalle;
	}
	
	/**
	 * Gets the position of avenue 
	 * @return value of carrera
	 */
	
	public int getPosicionCarrera() 
	{
		return posicionCarrera;
	}
	/**
	 * Sets the value of the avenue to a new value.
	 * @param posicionCarrera new value of the avenue.
	 */
	public void setPosicionCarrera(int posicionCarrera) 
	{
		this.posicionCarrera = posicionCarrera;
	}
	/**
	 * Returns the code of service that the ambulance is currently 
	 * Attending.
	 * @return servicioActual
	 */
	public long getServicioActual() 
	{
		return servicioActual;
	}
	/**
	 * Sets the value of servicioActual to a new one.
	 * @param servicioActual
	 */
	public void setServicioActual(long servicioActual) 
	{
		this.servicioActual = servicioActual;
	}
	/**
	 * Returns the state of the ambulance.
	 * @return
	 */
	public boolean isEstado() 
	{
		return estado;
	}
	/**
	 * Sets the state of the ambulance.
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
	 * Print information about the service in format that matches the project
	 */
	public void printSelf()
	{	
		@SuppressWarnings("unused")
		String actualService = null;
		if(this.getServicioActual() == 0)
		{
			actualService = "NA";
		}
		else
		{
			actualService = Integer.toString((int)this.getServicioActual());
		}
		
		if(this.horaPosicion != null)
		{
			System.out.format("%6s%7s%14s%11s%10s%18s%14s%n", this.codigo, this.placa, this.tipoDotacion
					,Utils.formatoHora(this.horaPosicion), this.posicionCalle, this.posicionCarrera, actualService);					
		}
		else
		{
			System.out.format("%6s%7s%14s%11s%10s%18s%14s%n", this.codigo, this.placa,this.tipoDotacion
					,"NA",this.posicionCalle,this.posicionCarrera, actualService);
		}
	}
	
	
}