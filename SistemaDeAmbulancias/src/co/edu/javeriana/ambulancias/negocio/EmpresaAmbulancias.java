/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import co.edu.javeriana.ambulancias.ambulancias.Ambulancia;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaBasica;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaUCI;
import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * EmpresaAmbulancias.java
 * --------------------------------------------
 * This is the business class where it contains 
 * all the IPS, all the Servicios and all the 
 * Ambulancias. 
 * @author Hernan Cote and Juan Pablo Penaloza
 *
 */
public class EmpresaAmbulancias implements IServiciosAmbulancias
{
	public static final String LINE_SEPARATOR = "-----------------------------------------------------------------------------------------------------------------------------";
	
	public static final String TAG_AMBULANCIA_BASICA = "BASICA";
	public static final String TAG_AMBULANCIA_UCI = "UCI";
	public static final String TAG_AMBULANCIA_NO_MEDICALIZADA = "NOMEDICALIZADA";
	private HashMap<String, IPS> ipsList;
	//private ArrayList<IPS> ipsList; This will no longer work for part 2 of the project. Replaced with HashMap
	private ArrayList<Servicio> serviciosList;
	//private ArrayList<Ambulancia> ambulanciasList;
	private HashMap <Integer, Ambulancia> ambulanciasList;
	private String nombre;

	public EmpresaAmbulancias(String nombre)
	{
		this.nombre = nombre;
		this.ipsList = new HashMap<String, IPS>();
		this.serviciosList = new ArrayList<Servicio>();
		this.ambulanciasList = new HashMap<Integer, Ambulancia>();
	}
	/**
	 * Gets the name of the company.
	 * @return
	 */
	public String getNombre() 
	{
		return nombre;
	}
	/**
	 * Sets the name of the company.
	 * @param nombre
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	/**
	 * Gets the list of IPS
	 * @return
	 */
	public HashMap<String, IPS> getIps() {
		return ipsList;
	}
	/**
	 * Add an IPS to the IPS list
	 * @param ips
	 */
	public void setIps(IPS ips) 
	{
		this.ipsList.put(ips.getNombre(), ips);
	}
	/**
	 * Gets the list of Servicios 
	 * @return
	 */
	public ArrayList<Servicio> getServicios() 
	{
		return serviciosList;
	}
	/**
	 * Sets the list of Servicios
	 * @param servicios
	 */
	public void setServicios(ArrayList<Servicio> servicios) 
	{
		this.serviciosList = servicios;
	}
	/**
	 * Gets the list of ambulances  
	 * @return
	 */
	public HashMap<Integer, Ambulancia> getAmbulancias()
	{
		return this.ambulanciasList;
	}
	/**
	 * Adds an ambulance to the list of ambulances
	 * @param ambulancias
	 */

	public void setAmbulancias(Ambulancia ambulancias) 
	{
		this.ambulanciasList.put(ambulancias.getCodigo(),ambulancias);
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
	public void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero, String tipoUCI) // Change parameters to match new requirements
	{
		Ambulancia ambulancia = null; 
		
		if (tipoAmbulancia.equals(TAG_AMBULANCIA_BASICA)) {
			ambulancia = new AmbulanciaBasica (codigo, placa, medicoEnfermero);
		}
		
		if (tipoAmbulancia.equals(TAG_AMBULANCIA_UCI)) {
			ambulancia = new AmbulanciaUCI (codigo, placa, medicoEnfermero, tipoUCI);
		}
		
		if (tipoAmbulancia.equals(TAG_AMBULANCIA_NO_MEDICALIZADA)) {
			ambulancia = new AmbulanciaNoMedicalizada (codigo, placa, medicoEnfermero);
		}
		
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
		ArrayList <Integer> code = new ArrayList <Integer>();
		if(!ambulanciasList.isEmpty())
		{
			System.out.println(LINE_SEPARATOR);
			System.out.format("%6s%18s%7s%27s%15s%17s%10s%10s%10s%n", "tipoAmbu", "codigo", "placa","medico/enfermero", "tipoUCI", "horaPosicion", 
					"Calle", "Carrera", "tarifa");
			System.out.println(LINE_SEPARATOR);
			
			for (Entry<Integer, Ambulancia> entry : ambulanciasList.entrySet()) {
				code.add(entry.getKey());
			}
			
			Collections.sort(code);
			for (int i = 0; i < code.size(); i++) {
				this.getAmbulanciaByCodigo(code.get(i)).printSelf();
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
	public boolean registrarPosicionAmbulancia(int codigo, GregorianCalendar horaPosicion,int posicionCalle, int posicionCarrera)
	{
		Iterator<Integer> it = ambulanciasList.keySet().iterator();
		//for(Ambulancia ambulancia : ambulanciasList)
		while (it.hasNext())
		{
			Integer key = it.next();
			Ambulancia ambulancia = ambulanciasList.get(key);
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
	public void registrarServicio (Servicio serv) 
	{
		serviciosList.add(serv);
	}
	
	/**
	 * This method assigns an IPS and an Ambulance to a service  
	 * @param codigo
	 * @return
	 */
	public String asignarUnServicio(int codigo) // 
	{
		String message = null;
		for(Servicio servicio : serviciosList)
		{
			
			if(servicio.getCodigo() == codigo && servicio.getEstado().equals("NO_ASIGNADO"))
			{
				ArrayList<Ambulancia> ambulanciasDisponibles = construirAmbulanciasDisponibles(servicio);
				if(!ambulanciasDisponibles.isEmpty())
				{
					if(servicio.getTipoServicio().equals("EMERGENCIA") || servicio.getTipoServicio().equals("URGENCIA"))
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
					else if(servicio.getTipoServicio().equals("DOMICILIO"))
					{
						Ambulancia ambulanciaMasCercana = calcularAmbulanciaMasCercana(ambulanciasDisponibles,
								servicio.getDireccion().getCalle(), 
								servicio.getDireccion().getCarrera());
						
						servicio.setEstado("ASIGNADO");
						
						servicio.setAmbulancia(ambulanciaMasCercana);
						
						ambulanciaMasCercana.setServicios(servicio);
						ambulanciaMasCercana.setEstado(true);		
						return "Al servicio " + servicio.getCodigo() + " le fue asignada la ambulancia " + servicio.getAmbulancia().getCodigo();
					}					
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
		System.out.println("El codigo ingresado no existe o ya ha sido asignado ");
		System.out.println("----------------------------------------------------");
		return message;
	}
	
	/**
	 * This method builds a list of available ambulances
	 * depending of the kind of services that the service needs
	 * @param servicio
	 * @return
	 */
	private ArrayList<Ambulancia> construirAmbulanciasDisponibles(Servicio servicio) // Verificar Este Metodo Para que funcuione para la segunda entrega.
	{
		ArrayList<Ambulancia> ambulanciasDisponibles = new ArrayList<Ambulancia>();		
		
		if(servicio.getTipoServicio().equals("EMERGENCIA"))
		{
			for (Entry<Integer, Ambulancia> entry : ambulanciasList.entrySet())
			{
				Ambulancia ambulancia = entry.getValue();
				if (ambulancia instanceof AmbulanciaUCI) {
					if(((AmbulanciaUCI) ambulancia).getTipoUCI().equals("ALTA_UCI") && (!ambulancia.isEstado()))
					{
						ambulanciasDisponibles.add(ambulancia);
					}
				}
				
			}
		}
		else
		{
			for (Entry<Integer, Ambulancia> entry : ambulanciasList.entrySet())
			{
				Ambulancia ambulancia = entry.getValue();
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
		
		Iterator <String> ipsIterator = ipsList.keySet().iterator();
		
		//for(IPS ipsMasCercana : ipsList) Change this for an iterator to go through the map of IPS.
		while (ipsIterator.hasNext())
		{
			String key = ipsIterator.next();
			IPS ipsMasCercana = ipsList.get(key);
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
					System.out.println("Exito al finalizar el servicio con codigo " + servicios.getCodigo());
					isTerminated = true;
					return isTerminated;
				}
				else
				{
					System.out.println("--------------------------------------------------------------");
					System.out.println("El codigo del servicio ingresado no esta en estado NO_ASIGNADO");
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
	

	

	/**
	 * Report of the IPS with associated Services
	 */
	public void reporteIpsYServicios()
	{
		System.out.println("\t------------------------------------------");
		System.out.println("\tREPORTE DE LAS IPS CON SERVICIOS ASOCIADOS");
		System.out.println("\t------------------------------------------");
		if(!this.ipsList.isEmpty())
		{
			
			SortedSet <String> keySet = new TreeSet <String>(); 
			for (Map.Entry<String, IPS> entry: ipsList.entrySet())
				keySet.add(entry.getKey());
			
			Iterator<String> ipsIterator = keySet.iterator();
			while (ipsIterator.hasNext())
			{	
				String keyActual = (String) ipsIterator.next();
				IPS ips = ipsList.get(keyActual);
				System.out.println("IPS: ");
				System.out.format("%10s%32s%19s%n","nombre","Tipo de atencion","Direccion");
				System.out.println("-------------------------------------------------------------");
				System.out.format("%10s%24s%29s%n%n", ips.getNombre(),ips.getTipoAtencion(), ips.getDireccion().toString());
				System.out.println("SERVICIOS: ");
			
				if(!ips.getServicios().isEmpty())
				{
					System.out.format("\t%7s%15s%17s%14s%10s%12s%21s%17s%n","Codigo"
							,"horaSolicitud","paciente","tipoServicio","Telefono"
							,"Direcci�n","Estado","Ambulancia");
					System.out.println("\t----------------------------------------------------------"
							+ "-------------------------------------------------------");
					ips.sortServicios(); // NEW
					for(Servicio servicios : ips.getServicios())
					{
						System.out.format("\t%7d%15s%17s%14s%10s%24s%11s%10s%n",servicios.getCodigo()
								,Utils.formatoMes(servicios.getHoraSolicitud()),servicios.getPaciente()
								,servicios.getTipoServicio(),servicios.getTelefono(), servicios.getDireccion().toString()
								,servicios.getEstado(), servicios.getAmbulancia().getCodigo());
					}
				}
				else
				{
					System.out.println("No hay servicios asignados a esta IPS");
					System.out.println("-------------------------------------");
				}
			}
		}
		else
		{
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("La base de datos del sistema no tiene IPS registradas para hacer el reporte");
			System.out.println("---------------------------------------------------------------------------");
		}		
	}
	
	private Ambulancia getAmbulanciaByCodigo (int codigo) {
		for (Entry<Integer, Ambulancia> entry : ambulanciasList.entrySet()) {
			Ambulancia ambu = entry.getValue();
			if (ambu.getCodigo() == codigo) return ambu;
		}
		return null;
	}
}
