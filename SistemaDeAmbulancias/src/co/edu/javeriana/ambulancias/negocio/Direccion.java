package co.edu.javeriana.ambulancias.negocio;

/**
 * Direccion.java
 * --------------------------------------------
 * Emulates the real life concept of an 
 * used in this project with streets and avenues 
 * that can be associated with a concept of 
 * X and Y coordinates. 
 * @author Hernan Cote and Juan Pablo Penaloza
 *
 */
public class Direccion 
{
	private String tipoDireccion;
	private int calle;
	private int carrera;
	private int numero;
	
	/**
	 * Constructs a new object of type Direccion with 
	 * the values that enter asparameters.
	 * @param tipoDireccion
	 * @param calle
	 * @param carrera
	 * @param numero
	 */
	
	public Direccion(String tipoDireccion, int calle, int carrera, int numero) 
	{
		this.tipoDireccion = tipoDireccion;
		this.calle = calle;
		this.carrera = carrera;
		this.numero = numero;
	}
	
	/**
	 * Gets the value of the type of address.
	 * @return tipoDireccion
	 */
	public String getTipoDireccion() 
	{
		return tipoDireccion;
	}
	/**
	 * Sets the value of type of address to a new value
	 * that enters as a parameter
	 * @param tipoDireccion
	 */
	public void setTipoDireccion(String tipoDireccion) 
	{
		this.tipoDireccion = tipoDireccion;
	}
	/**
	 * Gets the value of street
	 * @return
	 */
	public int getCalle() 
	{
		return calle;
	}
	/**
	 * Sets a the value of street to new value that 
	 * enters as a parameter 
	 * @param calle
	 */
	public void setCalle(int calle) 
	{
		this.calle = calle;
	}
	/**
	 * Gets the value of avenue.
	 * @return
	 */
	public int getCarrera() 
	{
		return carrera;
	}
	/**
	 * Sets the value of avenue to a new value
	 * that enters as parameter.
	 * @param carrera
	 */
	public void setCarrera(int carrera) 
	{
		this.carrera = carrera;
	}
	/**
	 * Gets the value of numero.
	 * @return
	 */
	public int getNumero() 
	{
		return numero;
	}
	/**
	 * Sets the value of numero to the value that enters
	 * as a parameter.
	 * @param numero
	 */
	public void setNumero(int numero) 
	{
		this.numero = numero;
	}
	
	/**
	 * returns a string of the address.
	 * @return 
	 */
	public String toString() 
	{
		return (this.getTipoDireccion().equals("CARRERA")) ? 
				(String) ("CARRERA " + this.getCarrera() + " # " + this.getCalle() 
						+ " - " + this.getNumero()) : "CALLE " + this.getCalle() 
						+ " # " + this.getCarrera() + " - " + this.getNumero();
	}
}
