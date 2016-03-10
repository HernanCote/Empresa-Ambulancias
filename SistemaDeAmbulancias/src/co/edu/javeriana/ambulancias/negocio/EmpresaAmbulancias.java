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
			System.out.format("%6s%7s%14s%14s%15s%17s%10s%n", "codigo", "placa", "tipoDotacion"
					,"horaPosicion", "posicionCalle", "posicionCarrera", "servicio");
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
	/**
	 * This method adds an object of type Servicio and 
	 * adds it to the arrayList of this class.
	 * @param serv
	 */
	public void agregarServicio (Servicio serv) 
	{
		serviciosList.add(serv);
	}
	
	public String asignarUnServicio(int codigo)
	{
		String message = null;
		for(Servicio servicio : serviciosList)
		{
			if(servicio.getCodigo() == codigo && servicio.getEstado().equals("NO_ASIGNADO"))
			{
				ArrayList<Ambulancia> ambulanciasDisponibles = construirAmbulanciasDisponibles(servicio);
				if(!ambulanciasDisponibles.isEmpty())
				{
					Ambulancia ambulanciaMasCercana = calcularAmbulanciaMasCercana(ambulanciasDisponibles,
																servicio.getDireccion().getCalle(), 
																servicio.getDireccion().getCarrera());
					
					IPS ipsMasCercana = calcularIPSMasCercana(servicio.getDireccion().getCalle(), 
																servicio.getDireccion().getCarrera());
					servicio.setEstado("ASIGNADO");
					
					servicio.setAmbulancia(ambulanciaMasCercana);
					
					ambulanciaMasCercana.setServicios(servicio);
					ambulanciaMasCercana.setEstado(true);				
					
					servicio.setIps(ipsMasCercana);	
					ipsMasCercana.setServicios(servicio);	
					return "Al servicio " + servicio.getCodigo() + " le fue asignada la ambulancia " + servicio.getAmbulancia().getCodigo()
							+ " y la IPS " + servicio.getIps().getNombre();
				}				
				else
				{
					System.out.println("-------------------------------------------------------");
					System.out.println("No hay ambulancias disponibles para atender el servicio");
					System.out.println("-------------------------------------------------------");
					return null;
				}
			}			
		}		
		System.out.println("----------------------------------------------------");
		System.out.println("El código ingresado no existe o ya ha sido asignado ");
		System.out.println("----------------------------------------------------");
		return message;
	}
	
	private ArrayList<Ambulancia> construirAmbulanciasDisponibles(Servicio servicio)
	{
		ArrayList<Ambulancia> ambulanciasDisponibles = new ArrayList<Ambulancia>();		
		
		if(servicio.getTipoServicio().equals("EMERGENCIA"))
		{
			for(Ambulancia ambulancia : ambulanciasList)
			{
				if(ambulancia.getTipoDotacion().equals("ALTA_UCI") && (!ambulancia.isEstado()))
				{
					ambulanciasDisponibles.add(ambulancia);
				}				
			}
		}
		else
		{
			for(Ambulancia ambulancia : ambulanciasList)
			{
				if(!ambulancia.isEstado())
				{
					ambulanciasDisponibles.add(ambulancia);
				}				
			}
		}
		return ambulanciasDisponibles;						
	}
	
	private Ambulancia calcularAmbulanciaMasCercana(ArrayList<Ambulancia> ambulancias, int calle, int carrera)
	{
		Ambulancia ambulanciaCercana = null;
		int auxiliar = 2000000;
		int z=200000;
		for(Ambulancia ambuMasCercana : ambulancias)
		{
			
			z = calcularDistancia(ambuMasCercana.getPosicionCalle(),ambuMasCercana.getPosicionCarrera(), calle, carrera);
			if(auxiliar > z)
			{
				ambulanciaCercana = ambuMasCercana;
				auxiliar = z;
			}
		}
		return ambulanciaCercana;
	}
	
	private IPS calcularIPSMasCercana( int calle, int carrera)
	{
		IPS ipsCercana = null;
		int auxiliar = 2000000;
		int z=200000;
		for(IPS ipsMasCercana : ipsList)
		{
			z = calcularDistancia(ipsMasCercana.getDireccion().getCalle(), ipsMasCercana.getDireccion().getCarrera(),calle ,carrera);
			if(auxiliar > z)
			{
				ipsCercana = ipsMasCercana;
				auxiliar = z;
			}
		}
		return ipsCercana;
	}
	
	private int calcularDistancia(int x1, int y1, int x2, int y2)
	{
		int x = Math.abs(x1-x2);
		int y = Math.abs(y1-y2);
		return x + y;
	}
}
