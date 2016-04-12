package co.edu.javeriana.ambulancias.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaMedicalizada;
import co.edu.javeriana.ambulancias.ambulancias.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.negocio.Direccion;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

/**
 * Utils.java
 * --------------------------------------------------
 * This class is created to have useful utilities to 
 * help the printing of menus, date formating and
 * more methods.
 * @author Hernan Cote y Juan Pablo Penaloza
 *
 */

public class Utils  {
	
	/**
	 * This method returns an hour format (hh:mm a) from a GregorianCalendar object
	 * @param hora
	 * @return
	 */
	public static String formatoHora(GregorianCalendar hora) {
		if (hora == null) return "NA";
		SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm a");
		return formatoHora.format(hora.getTime());
	}
	
	/**
	 * This method returns a time format in the form "Month-day Hour-minutes" from a GregorianCalendar object 
	 * @param hora
	 * @return
	 */
	public static String formatoMes(GregorianCalendar hora)
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("MMM-dd HH:mm");
		return formatoHora.format(hora.getTime());
	}
	
	/**
	 * This method prints the menu of all the features that the system is capable to do
	 * @param nombre
	 * @return
	 */
	public static String printMenu(String nombre)
	{
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("                           "+nombre+"                          ");
		System.out.println("---------------------------------------------------------------");
		System.out.println("opcion 1: Ingresas las IPS al sistema");
		System.out.println("opcion 2: Ingresas las ambulancias al sistema");
		System.out.println("opcion 3: Registrar la posicion actual de una ambulancia");
		System.out.println("opcion 4: Registrar un servicio");
		System.out.println("opcion 5: Reporte de ambulancias");
		System.out.println("opcion 6: Asignar a un servicio una ambulancia y una IPS");
		System.out.println("opcion 7: Finalizar un servicio");
		System.out.println("opcion 8: Reporte de servicios con IPS y ambulancias asignados");
		System.out.println("opcion 9: Reporte de las IPS con servicios asociados");
		System.out.println("opcion 10: Estadisticas de las ambulancias disponibles");
		System.out.println("opcion 11: Pacientes atendidos");
		System.out.println("opcion 12: Terminar");
		System.out.println("---------------------------------------------------------------");
		System.out.print("Ingrese la opcion que desea acceder: ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String opcion = sc.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * add IPS to the system
	 * @param empresaAmbulancias
	 */
	public static void agregarIPS(EmpresaAmbulancias empresaAmbulancias)
	{
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String nombreArchivo = null;
		System.out.print("Ingrese el nombre del archivo que contiene las IPS: ");
		try 
		{
			nombreArchivo = bufferedReader.readLine();
		}
		catch (IOException e) 
		{
			System.out.println("Error al leer el comando ingresado.");			
		}
		if(nombreArchivo != null)
		{
			ManejoArchivos.leerIPS(nombreArchivo, empresaAmbulancias);
		}
	}
	
	/**
	 * add an ambulance to the system
	 * @param empresaAmbulancias
	 */
	public static void agregarAmbulancias(EmpresaAmbulancias empresaAmbulancias)
	{
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String nombreArchivo = null;
		System.out.print("Ingrese el nombre del archivo que contiene las Ambulancias: ");
		try 
		{
			nombreArchivo = bufferedReader.readLine();
		}
		catch (IOException e) 
		{
			System.out.println("Error al leer el comando ingresado.");			
		}
		if(nombreArchivo != null)
		{
			ManejoArchivos.leerAmbulancias(nombreArchivo, empresaAmbulancias);
		}
	}
	/**
	 * Register the position of an ambulance
	 * @param empresaAmbulancias
	 */
	public static void registrarPosicion(EmpresaAmbulancias empresaAmbulancias)
	{
		boolean isExito = false;
		
		if(!empresaAmbulancias.getAmbulancias().isEmpty())
		{
			System.out.println("--Registrar Posicion de ambulancia indique: codigo calle carrera");
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			int codigo = -1, calle = -1, carrera = -1;
			try 
			{
				codigo = Integer.parseInt(bufferedReader.readLine());
				calle = Integer.parseInt(bufferedReader.readLine());
				carrera = Integer.parseInt(bufferedReader.readLine());
			} 
			catch (NumberFormatException | IOException e) 
			{
				System.out.println("Por favor ingrese datos v�lidos.");
			}
			
			GregorianCalendar horaPosicion = new GregorianCalendar();
			
			isExito = empresaAmbulancias.registrarPosicionAmbulancia(codigo, horaPosicion, calle, carrera);
			
			if(isExito)
			{
				System.out.println("-------------------------------------------------------------");
				System.out.println("La posici�n de la ambulancia ha sido actualizada exitosamente");
				System.out.println("-------------------------------------------------------------");
			}
			else
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("El c�digo de la ambulancia no est� registrado en el sistema");
				System.out.println("-----------------------------------------------------------");
			}
		}
		else
		{
			System.out.println("--------------------------------------------");
			System.out.println("No hay ambulancias registradas en el sistema");
			System.out.println("--------------------------------------------");
		}
	}
	
	/**
	 * Gets the name, phone, type of service, address, and all the 
	 * data needed to create an object of type Direccion and an object
	 * of type Servicio. Then it calls a method of EmpresaAmbulancias 
	 * for it to add the Servicio to it's list of Servicio. 
	 * @param empresaAmbulancias
	 */	
	public static void registrarServicio (EmpresaAmbulancias empresaAmbulancias)
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader (isr);
		String nomPaciente = null;
		String tipoServ = null;
		String telefono = null;
		String tipoDireccion = null;
		int calle = 0;
		int carrera = 0;
		int numero = 0;
		try 
		{
			System.out.print("Nombre Paciente: ");
			nomPaciente = br.readLine();
			System.out.print("Tipo Servicio (URGENCIA, EMERGENCIA o DOMICILIO): ");
			tipoServ = br.readLine().toUpperCase(); 
			System.out.print("Telefono: ");
			telefono = br.readLine();
			System.out.print("Tipo Direccion CARRERA o CALLE: ");
			tipoDireccion = br.readLine().toUpperCase();
			if (tipoDireccion.equals("CARRERA")) 
			{
				System.out.print("Carrera: ");
				carrera = Integer.parseInt(br.readLine());
				System.out.print("Calle: ");
				calle = Integer.parseInt(br.readLine());
				System.out.print("Numero: ");
				numero = Integer.parseInt(br.readLine());
			}
			else 
			{
				System.out.print("Calle: ");
				calle = Integer.parseInt(br.readLine());
				System.out.print("Carrera: ");
				carrera = Integer.parseInt(br.readLine());
				System.out.print("Numero: ");
				numero = Integer.parseInt(br.readLine());
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error En La Creacion Del Servicio");
		}
		
		Direccion tempDir = new Direccion (tipoDireccion, calle, carrera, numero);
		Servicio tempServ = new Servicio (nomPaciente,tipoServ, telefono, tempDir);
		
		empresaAmbulancias.registrarServicio(tempServ);
		
		System.out.println("El nuevo Servicio tiene codigo: " + tempServ.getCodigo());
	}
	
	
	/**
	 * Assign a service to an IPS and an Ambulance
	 * @param empresaAmbulancias
	 * @return
	 */
	public static String asignarUnServicio(EmpresaAmbulancias empresaAmbulancias)
	{
		if(empresaAmbulancias.getServicios().isEmpty())
		{
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("No hay servicios registrados en el sistema, ingrese uno antes de continuar");
			System.out.println("--------------------------------------------------------------------------");
			
		}
		if(empresaAmbulancias.getAmbulancias().isEmpty())
		{
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("No hay ambulancias registradas en el sistema, ingrese una antes de continuar");
			System.out.println("----------------------------------------------------------------------------");
			
		}
		if(empresaAmbulancias.getIps().isEmpty())
		{
			System.out.println("--------------------------------------------------------------------");
			System.out.println("No hay IPS registradas en el sistema, ingrese una antes de continuar");
			System.out.println("--------------------------------------------------------------------");
			
		}
		
		if((!empresaAmbulancias.getIps().isEmpty()) && (!empresaAmbulancias.getAmbulancias().isEmpty())
													&& (!empresaAmbulancias.getServicios().isEmpty()))
		{		
			
			System.out.println("----------------------------------------------");
			System.out.println("Asignar un servicio a una IPS y una ambulancia");
			System.out.println("Se muestran los servicios del sistema sin asignar:");
			
			System.out.println("--------------------------------------------"
					+ "----------------------------------------");
			System.out.format("%4s%17s%15s%15s%13s%12s%n", "Codigo","horaSolicitud",
					"paciente", "tipoServicio", "telefono", "direccion");
			System.out.println("--------------------------------------------"
					+ "----------------------------------------");
			int cont = 0;
			for(Servicio servicio : empresaAmbulancias.getServicios())
			{
				if(servicio.getEstado().equals("NO_ASIGNADO"))
				{
					servicio.printNoAsignados();
					cont++;
				}
			}
			if( cont >= 1)
			{				
				System.out.print("\nIngrese el codigo del servicio que desea asignar: ");
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				int codigo = Integer.parseInt(scanner.nextLine());
				String message = empresaAmbulancias.asignarUnServicio(codigo);
				return message;
			}
			else
			{
				System.out.println("Todos los servicios registrados en el sistema han sido asignados");
				System.out.println("----------------------------------------------------------------");
			}			
		}
		return null;
	}
	
	/**
	 * prints all assigned services
	 * @param empresaAmbulancias
	 */
	public static void imprimirServiciosAsignados(EmpresaAmbulancias empresaAmbulancias)
	{
		System.out.println("	---------------------");
		System.out.println("	FINALIZAR UN SERVICIO");
		System.out.println("	---------------------");
		System.out.println("Servicios en el sistema asignados:");
		System.out.println("-----------------------------------------------------------");
		System.out.format("%6s%12s%16s%6s%n", "codigo", "paciente", "ambulancia", "IPS");
		System.out.println("-----------------------------------------------------------");
		int cont = 0;
		
		for(Servicio servicios : empresaAmbulancias.getServicios())
		{
			if(servicios.getEstado().equals("ASIGNADO"))
			{
				servicios.printAsignados();
				cont++;
			}
		}
		if(cont >= 1)
		{
			System.out.print("Ingrese el codigo del servicio que desea finalizar: ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int codigo = Integer.parseInt(scanner.nextLine());
			boolean isTerminated = empresaAmbulancias.finalizarUnServicio(codigo);
			if(!isTerminated)
			{
				System.out.println("Error al finalizar el servicio.");
				System.out.println("-------------------------------");
			}
		}
		else
		{
			System.out.println("No hay servicios que esten en estado asignado para finalizar");
			System.out.println("------------------------------------------------------------");
		}	
	}
	
	public static void pacientesAtendidos (EmpresaAmbulancias emresaAmbulancias) {
		ArrayList <Servicio> listaServicios = emresaAmbulancias.getServicios();
		Collections.sort(listaServicios, new Comparator <Servicio> () {
			@Override
			public int compare(Servicio o1, Servicio o2) {
				return o1.getHoraSolicitud().compareTo(o2.getHoraSolicitud());
			}
		});
		System.out.println(EmpresaAmbulancias.LINE_SEPARATOR);
		System.out.format("%4s%19s%20s%15s%20s%17s%25s%n", "HoraSolicitud","Paciente","TipoServicio","Telefono","Direccion","Estado","MedicoEnfermero");
		for (Servicio serv : listaServicios) {
			if (serv.getEstado().equals(Servicio.TAG_ASIGNADO)) {
				String medicoEnfermero = "NO_ASIGNADO";
				if (serv.getAmbulancia() instanceof AmbulanciaMedicalizada)
					medicoEnfermero = ((AmbulanciaMedicalizada) serv.getAmbulancia()).getMedico();
				else
					medicoEnfermero = ((AmbulanciaNoMedicalizada) serv.getAmbulancia()).getEnfermo();
				System.out.format("%4s%26s%15s%20s%25s%13s%23s%n", Utils.formatoHora(serv.getHoraSolicitud()), 
						serv.getPaciente(), serv.getTipoServicio(), serv.getTelefono(), 
						serv.getDireccion().toString(), serv.getEstado(), medicoEnfermero);
			} else {
				String medicoEnfermero = "NA"; 
				System.out.format("%4s%26s%15s%20s%25s%13s%23s%n", Utils.formatoHora(serv.getHoraSolicitud()), 
						serv.getPaciente(), serv.getTipoServicio(), serv.getTelefono(), 
						serv.getDireccion().toString(), serv.getEstado(), medicoEnfermero);
			}
		}
	}
	
}
