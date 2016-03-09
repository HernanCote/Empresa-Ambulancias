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

import org.omg.PortableInterceptor.USER_EXCEPTION;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

/**
 * @author v-heco
 *
 */
public class Utils 
{
	public static String formatoHora(GregorianCalendar hora)
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm a");
		return formatoHora.format(hora);
	}
	
	public static String formatoMes(GregorianCalendar hora)
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("MMM-dd HH:mm");
		return formatoHora.format(hora);
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
		System.out.print("Ingrese la opción que desea acceder: ");
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
}
