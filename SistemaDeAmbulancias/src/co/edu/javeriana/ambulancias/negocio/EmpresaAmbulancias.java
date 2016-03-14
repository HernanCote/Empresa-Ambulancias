/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author Hern�n Cote y Juan Pablo Pe�aloza
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

	/**
	 * This method adds a new IPS to the system
	 * @param nombre
	 * @param tipoAtencion
	 * @param tipoDireccion
	 * @param calle
	 * @param carrera
	 * @param numero
	 */
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero)
	{
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		
		this.setIps(ips);
		
		System.out.println("----------------------------------------");
		System.out.println("         IPS Agragada correcamente      ");
		System.out.println("----------------------------------------");
	}
	
	/**
	 * This method adds a new Ambulance to the System
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 */
	public void agregarAmbulancia(int codigo, String placa, String tipoDotacion)
	{
		Ambulancia ambulancia = new Ambulancia(codigo, placa, tipoDotacion);
		
		this.setAmbulancias(ambulancia);
		
		System.out.println("-----------------------------------------------");
		System.out.println("         Ambulancia Agragada correcamente      ");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * This method prints to the user the ambulances available in the system 
	 */
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
	
	/**
	 * This method let the user register the position of an ambulance
	 * @param codigo
	 * @param horaPosicion
	 * @param posicionCalle
	 * @param posicionCarrera
	 * @return
	 */
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
	
	/**
	 * This method assigns an IPS and an Ambulance to a service  
	 * @param codigo
	 * @return
	 */
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
		System.out.println("El c�digo ingresado no existe o ya ha sido asignado ");
		System.out.println("----------------------------------------------------");
		return message;
	}
	
	/**
	 * This method builds a list of available ambulances
	 * depending of the kind of services that the service needs
	 * @param servicio
	 * @return
	 */
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
	
	
	/**
	 * This method returns the nearest ambulance to an specific service
	 * @param ambulancias
	 * @param calle
	 * @param carrera
	 * @return
	 */
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
	
	/**
	 * this method return the nearest IPS to an specific service
	 * @param calle
	 * @param carrera
	 * @return
	 */
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
	
	
	/**
	 * this method calculates the distance between two points (x1,y1) and (x2,y2)
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private int calcularDistancia(int x1, int y1, int x2, int y2)
	{
		int x = Math.abs(x1-x2);
		int y = Math.abs(y1-y2);
		return x + y;
	}
	
	/**
	 * Terminate an Asigned service
	 * @param codigo
	 * @return
	 */
	public boolean finalizarUnServicio(int codigo)
	{
		boolean isTerminated = false;
		for(Servicio servicios : this.serviciosList)
		{
			if(servicios.getCodigo() == codigo)
			{
				if(servicios.getEstado().equals("ASIGNADO"))
				{
					servicios.setEstado("FINALIZDO");
					servicios.getAmbulancia().setEstado(false);
					servicios.getAmbulancia().setServicioActual(0);
					System.out.println("Exito al finalizar el servicio con c�digo " + servicios.getCodigo());
					isTerminated = true;
					return isTerminated;
				}
				else
				{
					System.out.println("--------------------------------------------------------------");
					System.out.println("El c�digo del servicio ingresado no est� en estado NO_ASIGNADO");
					System.out.println("--------------------------------------------------------------");
					return isTerminated;
				}
			}
		}
		System.out.println("------------------------------------------");
		System.out.println("El codigo del servicio ingresado no existe");
		System.out.println("------------------------------------------");
		return isTerminated;
	}
	
	
	/**
	 * For each element of the list of serviciosList prints it 
	 * with the method provided bellow. 
	 */
	
	public void imprimirTodosLosrServicios () {
		for (int i = 0; i < this.serviciosList.size(); i++) {
			generarReporteDeServicio (this.serviciosList.get(i));
		}
	}
	
	/**
	 * Takes a single service and prints its content according to 
	 * to its attributes.
	 * @param serv
	 */
	
	private void generarReporteDeServicio (Servicio serv) {
		System.out.println();
		System.out.println("SERVICIO:");
		System.out.println("Codigo \t HoraSolicitud \t Paciente \t TipoServicio \t Telefono \t Direccion \t \t Estado");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		serv.printSelfAll();	
		
		System.out.println();
		System.out.println();
		
		if (serv.getIps() == null) {
			System.out.println("IPS asignada: ");
			System.out.println("nombre                           tipoAtencion                      direccion");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			System.out.println("No Se Ha Asignado");
		} else {
			System.out.println("IPS asignada: ");
			System.out.println("nombre                           tipoAtencion                      direccion");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			serv.getIps().printSelf();
		}
		
		System.out.println();
		System.out.println();
		
		if (serv.getAmbulancia() == null) {
			System.out.println("Ambulancia asignada:");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			System.out.println("No Se Ha Asignado");
		} else {
			System.out.println("Ambulancia asignada:");
			System.out.println(" codigo       placa     tipoDotacion  	horaPosicion  		posicionCalle 		posicionCarrera");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			serv.getAmbulancia().printSelf();
			System.out.println();
		}
		
	}	
	
	public void reporteIpsYServicios() {
	}
}
