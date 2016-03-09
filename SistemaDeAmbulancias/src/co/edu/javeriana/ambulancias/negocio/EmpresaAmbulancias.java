/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author v-heco
 *
 */
public class EmpresaAmbulancias 
{
	private ArrayList<IPS> ipsList;
	private ArrayList<Servicio> serviciosList;
	private ArrayList<Ambulancia> ambulanciasList;
	
	private String nombre;

	public EmpresaAmbulancias(String nombre)
	{
		this.nombre = nombre;
		this.ipsList = new ArrayList<IPS>();
		this.serviciosList = new ArrayList<Servicio>();
		this.ambulanciasList = new ArrayList<Ambulancia>();
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public ArrayList<IPS> getIps() {
		return ipsList;
	}

	public void setIps(IPS ips) 
	{
		this.ipsList.add(ips);
	}
	
	public ArrayList<Servicio> getServicios() 
	{
		return serviciosList;
	}

	public void setServicios(ArrayList<Servicio> servicios) 
	{
		this.serviciosList = servicios;
	}

	public ArrayList<Ambulancia> getAmbulancias()
	{
		return ambulanciasList;
	}

	public void setAmbulancias(Ambulancia ambulancias) 
	{
		this.ambulanciasList.add(ambulancias);
	}

	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero)
	{
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		
		this.setIps(ips);
		
		System.out.println("----------------------------------------");
		System.out.println("         IPS Agragada correcamente      ");
		System.out.println("----------------------------------------");
	}
	
	public void agregarAmbulancia(int codigo, String placa, String tipoDotacion)
	{
		Ambulancia ambulancia = new Ambulancia(codigo, placa, tipoDotacion);
		
		this.setAmbulancias(ambulancia);
		
		System.out.println("-----------------------------------------------");
		System.out.println("         Ambulancia Agragada correcamente      ");
		System.out.println("-----------------------------------------------");
	}

	public void reporteDeAmbulancias()
	{
		if(!ambulanciasList.isEmpty())
		{
			//TODO Falta Implementar el servicio!!!
			System.out.println("------------------------------------------------"
					+ "-------------------------");
			System.out.format("%6s%7s%14s%14s%15s%17s%n", "codigo", "placa", "tipoDotacion"
					,"horaPosicion", "posicionCalle", "posicionCarrera");
			System.out.println("------------------------------------------------"
					+ "-------------------------");
			for(Ambulancia ambulancia : ambulanciasList)
			{
				ambulancia.printSelf();
			}
		}
		else
		{
			System.out.println("--------------------------------------------");
			System.out.println(" No hay ambulancias registradas en el sitema");
			System.out.println("--------------------------------------------");
		}
	}
	
	public boolean registrarPosicionAmbulancia(int codigo, GregorianCalendar horaPosicion
												,int posicionCalle, int posicionCarrera)
	{
		for(Ambulancia ambulancia : ambulanciasList)
		{
			if(ambulancia.getCodigo() == codigo)
			{
				ambulancia.setHoraPosicion(horaPosicion);
				ambulancia.setPosicionCalle(posicionCalle);
				ambulancia.setPosicionCarrera(posicionCarrera);
				return true;
			}
		}
		return false;
	}
}
