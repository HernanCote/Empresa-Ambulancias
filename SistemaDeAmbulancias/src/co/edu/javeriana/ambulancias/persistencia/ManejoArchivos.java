package co.edu.javeriana.ambulancias.persistencia;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.sun.glass.ui.Window.Level;

import co.edu.javeriana.ambulancias.ambulancias.Ambulancia;
import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.entidades.Servicio;
import co.edu.javeriana.ambulancias.enums.TipoDireccion;
import co.edu.javeriana.ambulancias.enums.TipoUCI;

/**
 * ManejoArchivos.java
 * ------------------------------------------------------------------
 * This class drives all the archives methods to add data to the system.
 * @author Hernan Cote y Juan Pablo Penaloza
 *
 */
public class ManejoArchivos 
{
	private static BufferedReader bReader;
	  
	/**
	 * This method lets the user read a file to add IPS to the system
	 * @param fileName
	 * @param empresaAmbulancias
	 * @return
	 */
	  public static boolean leerIPS(String fileName, EmpresaAmbulancias empresaAmbulancias)
	  {	  
		boolean archivoLeido = false;  
	    File dir = new File(fileName);
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
	          
	          
	          if(tipoDireccion.equals("CARRERA"))
	          {
	        	  empresaAmbulancias.agregarIPS(nombre, tipoAtencion, TipoDireccion.CARRERA, calle, carrera, numero);  
	          }
	          else if(tipoDireccion.equals("CALLE"))
	          {
	        	  empresaAmbulancias.agregarIPS(nombre, tipoAtencion, TipoDireccion.CALLE, calle, carrera, numero);
	          }
	          else
	          {
	        	  System.out.println("Error al ingresar la IPS");
	          }
	          
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
	  
	  /**
	   * This method lets the user read a file to add Ambulances to the system
	   * @param fileName
	   * @param empresaAmbulancias
	   * @return
	   */
	  public static boolean leerAmbulancias(String fileName, EmpresaAmbulancias empresaAmbulancias)
	  {	  
		boolean archivoLeido = false;  
	    File dir = new File(fileName);
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
	          fileRead = bReader.readLine();
	          fileRead = bReader.readLine();
	        }
	        while (!fileRead.matches("0"))
	        {	        	
	          String[] tokens = fileRead.split(",");
	          String tipoAmbulancia = tokens[0].trim();
	          int codigo = Integer.parseInt(tokens[1].trim());
	          String placa = tokens[2].trim();
	          String medicoEnfermero = tokens[3].trim();
	          String tipoDotacion = tokens[4].trim();
	          
	          if(tipoDotacion.equals("CARDIOVASCULAR"))
	          {	          
	        	  empresaAmbulancias.agregarAmbulancia(tipoAmbulancia, codigo, placa, medicoEnfermero, TipoUCI.CARDIOVASCULAR);
	          }
	          else if(tipoDotacion.equals("PEDIATRICA"))
	          {
	        	  empresaAmbulancias.agregarAmbulancia(tipoAmbulancia, codigo, placa, medicoEnfermero, TipoUCI.PEDIATRICA);
	          }
	          else 
	          {
	        	  empresaAmbulancias.agregarAmbulancia(tipoAmbulancia, codigo, placa, medicoEnfermero, null);
	          }
	          
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
	  
	  /**
	   * 
	   * @param fileName
	   * @param empresaAmbulancias
	   * @return
	   */
	  public static boolean saveContext(String fileName, EmpresaAmbulancias empresaAmbulancias)
	  {
		 boolean IsCreated = false;
		  
		 try 
		 {
			 ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			 outputStream.writeObject(empresaAmbulancias);
				
			 outputStream.flush();
			 outputStream.close();
			 IsCreated = true;
		 } 
		 catch (IOException e) 
		 {				
			 System.out.println("Error al guardar!");
		 }	
		
		 return IsCreated;
	  }
	  
	  /**
	   * 
	   * @param fileName
	   * @return
	   */
	  public static EmpresaAmbulancias loadContext(String fileName)
	  {		  
		  try(InputStream file = new FileInputStream(fileName);
			  InputStream buffer = new BufferedInputStream(file);
			  ObjectInput input = new ObjectInputStream(buffer);) 
		  {
			  EmpresaAmbulancias empresaAmbulancias = (EmpresaAmbulancias)input.readObject();
			  
			  for(Servicio servicio : empresaAmbulancias.getServicios())
			  {
				  System.out.println("Servicio: " + servicio.getPaciente());
			  }
			  
			  return empresaAmbulancias;
		  } 
		  catch (FileNotFoundException e) 
		  {			
			  System.out.println("No se puede encontrar el archivo especificado");
		  } 
		  catch (IOException e1) 
		  {			
			  System.out.println("No se puede hacer el ingreso de datos. Puede que los datos no sean consistentes.");
		  } 
		  catch (ClassNotFoundException e) 
		  {			
			  System.out.println("No se puede hacer el ingreso de datos. La clase no fue encontrada.");
		  }
		  return null;
	  }
}
