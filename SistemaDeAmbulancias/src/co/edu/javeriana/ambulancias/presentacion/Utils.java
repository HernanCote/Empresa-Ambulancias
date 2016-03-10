/**
 * 
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

import co.edu.javeriana.ambulancias.negocio.Direccion;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

/**
 * @author v-heco
 *
 */
public class Utils  {
	
	public static String formatoHora(GregorianCalendar hora)
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm a");
		return formatoHora.format(hora.getTime());
	}
	
	public static String formatoMes(GregorianCalendar hora)
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("MMM-dd HH:mm");
		return formatoHora.format(hora.getTime());
	}
	
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
		System.out.println("opcion 10: terminar");
		System.out.println("---------------------------------------------------------------");
		System.out.print("Ingrese la opci�n que desea acceder: ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String opcion = sc.nextLine();
		
		return opcion;
		
	}
	
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
	
	public static void  registrarPosicion(EmpresaAmbulancias empresaAmbulancias)
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
				System.out.println("-------------------------------------------------------------------");
				System.out.println("El c�digo de la ambulancia no est� registrado en el sistema existe.");
				System.out.println("-------------------------------------------------------------------");
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
	
	public static void registrarServicio (EmpresaAmbulancias empresaAmbulancias) {
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader (isr);
		String nomPaciente = null;
		String tipoServ = null;
		String telefono = null;
		String tipoDireccion = null;
		int calle = 0;
		int carrera = 0;
		int numero = 0;
		try {
			System.out.print("Nombre Paciente: ");
			nomPaciente = br.readLine();
			System.out.print("Tipo Servicio: ");
			tipoServ = br.readLine(); 
			System.out.print("Telefono: ");
			telefono = br.readLine();
			System.out.print("Tipo Dirección: ");
			tipoDireccion = br.readLine();
			if (tipoDireccion.equals("CARRERA")) {
				System.out.print("Carrera: ");
				carrera = Integer.parseInt(br.readLine());
				System.out.print("Calle: ");
				calle = Integer.parseInt(br.readLine());
				System.out.print("Numero: ");
				numero = Integer.parseInt(br.readLine());
			} else {
				System.out.print("Calle: ");
				calle = Integer.parseInt(br.readLine());
				System.out.print("Carrera: ");
				carrera = Integer.parseInt(br.readLine());
				System.out.print("Numero: ");
				numero = Integer.parseInt(br.readLine());
			}
		} catch (Exception e) {
			System.out.println("Error En La Creación Del Servicio");
		}
		
		Direccion tempDir = new Direccion (tipoDireccion, calle, carrera, numero);
		Servicio tempServ = new Servicio (nomPaciente,tipoServ, telefono, tempDir);
		
		empresaAmbulancias.agregarServicio(tempServ);
		
		System.out.println("El nuevo Servicio tiene codigo: " + tempServ.getCodigo());
		
		
	}
	
}
