/**
 * 
 */
package co.edu.javeriana.ambulancias.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> origin/dev
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;

/**
 * @author v-heco
 *
 */
public class ManejoArchivos 
{
	private static String path = System.getProperty("user.dir") + File.separator;
	private static BufferedReader bReader;
	  
	  public static boolean leerIPS(String fileName, EmpresaAmbulancias empresaAmbulancias)
	  {	  
		boolean archivoLeido = false;  
	    File dir = new File(path + fileName);
	    if (dir.exists()) 
	    {
	      try
	      {
	        bReader = new BufferedReader(new FileReader(dir));
	        String fileRead = null;
	        if (bReader.ready())
	        {
	          fileRead = bReader.readLine();
	          fileRead = bReader.readLine();
	        }
	        while (!fileRead.matches("0"))
	        {
	          String[] tokens = fileRead.split(",");
	          String nombre = tokens[0].trim();
	          String tipoAtencion = tokens[1].trim();
	          String tipoDireccion = tokens[2].trim();
	          int calle = Integer.parseInt(tokens[3].trim());
	          int carrera = Integer.parseInt(tokens[4].trim());
	          int numero = Integer.parseInt(tokens[5].trim());
	          
	          empresaAmbulancias.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
	          
	          if (bReader.ready())
	          {	        	  
	            fileRead = bReader.readLine();
	          }
	        }
	        archivoLeido = true;
	        //TODO devolver lo que se supone...
	        return archivoLeido;
	      }
	      catch (FileNotFoundException e)
	      {
	        System.out.println("El archivo no fue encontrado.");
	        return archivoLeido;
	      }
	      catch (IOException e)
	      {
	        System.out.println("Error al abrir el archivo.");
	        return archivoLeido;
	      }
	    }
	    System.out.println("El archivo " + fileName + " no existe.");
	    return archivoLeido;
	  }
	  
	  public static boolean leerAmbulancias(String fileName, EmpresaAmbulancias empresaAmbulancias)
	  {	  
		boolean archivoLeido = false;  
	    File dir = new File(path + fileName);
	    if (dir.exists()) 
	    {
	      try
	      {
	        bReader = new BufferedReader(new FileReader(dir));
	        String fileRead = null;
	        if (bReader.ready())
	        {
	          fileRead = bReader.readLine();
	          fileRead = bReader.readLine();
	        }
	        while (!fileRead.matches("0"))
	        {
	          String[] tokens = fileRead.split(",");
	          
	          int codigo = Integer.parseInt(tokens[0].trim());
	          String placa = tokens[1].trim();
	          String tipoDotacion = tokens[2].trim();
	          
	          empresaAmbulancias.agregarAmbulancia(codigo, placa, tipoDotacion);
	          
	          if (bReader.ready())
	          {	        	  
	            fileRead = bReader.readLine();
	          }
	        }
	        archivoLeido = true;
	        return archivoLeido;
	      }
	      catch (FileNotFoundException e)
	      {
	        System.out.println("El archivo no fue encontrado.");
	        return archivoLeido;
	      }
	      catch (IOException e)
	      {
	        System.out.println("Error al abrir el archivo.");
	        return archivoLeido;
	      }
	    }
	    System.out.println("El archivo " + fileName + " no existe.");
	    return archivoLeido;
	  }
	  
	
}
