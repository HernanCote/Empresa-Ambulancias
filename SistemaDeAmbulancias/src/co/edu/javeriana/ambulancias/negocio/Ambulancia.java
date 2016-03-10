/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * @author Hernan y Juan Pablo Peñaloza
 *
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
	private boolean estado;
	
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
	
	public void setServicios(Servicio servicio)
	{
		this.servicios.add(servicio);
		this.estado = true;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getPlaca() 
	{
		return placa;
	}
	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}
	
	public String getTipoDotacion()
	{
		return tipoDotacion;
	}
	public void setTipoDotacion(String tipoDotacion) 
	{
		this.tipoDotacion = tipoDotacion;
	}
	
	public GregorianCalendar getHoraPosicion() 
	{
		return horaPosicion;
	}
	public void setHoraPosicion(GregorianCalendar horaPosicion) 
	{
		this.horaPosicion = horaPosicion;
	}
	
	public int getPosicionCalle() 
	{
		return posicionCalle;
	}
	public void setPosicionCalle(int posicionCalle) 
	{
		this.posicionCalle = posicionCalle;
	}
	
	public int getPosicionCarrera() 
	{
		return posicionCarrera;
	}
	public void setPosicionCarrera(int posicionCarrera) 
	{
		this.posicionCarrera = posicionCarrera;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void printSelf()
	{	
		if(this.horaPosicion != null)
		{
			System.out.format("%6s%7s%14s%14s%15s%17s%n", this.codigo, this.placa, this.tipoDotacion
						,Utils.formatoHora(this.horaPosicion), this.posicionCalle, this.posicionCarrera);			
		}
		else
		{
			System.out.format("%6s%7s%14s%14s%15s%17s%n", this.codigo, this.placa,this.tipoDotacion
					,"NA",this.posicionCalle,this.posicionCarrera);
		}
	}
}
