/**
 * 
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;

/**
 * @author v-heco
 *
 */
public class TestAmbulancia 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpresaAmbulancias empresaAmbulancias = new EmpresaAmbulancias("Ambu S.A.");
		String opcion = null;
		
		while(opcion != "0")
		{
			opcion = Utils.printMenu(empresaAmbulancias.getNombre());
			switch (opcion) 
			{
				case "1":
					Utils.agregarIPS(empresaAmbulancias);
					break;
				case "2":	
					Utils.agregarAmbulancias(empresaAmbulancias);
					break;
				case "3":					
					break;
				case "4":					
					break;
				case "5":
					empresaAmbulancias.reporteDeAmbulancias();
					break;
				case "6":					
					break;
				case "7":					
					break;
				case "8":					
					break;
				case "9":					
					break;
				case "10":					
					break;
				default: 
					System.out.println("------------------------------------");
					System.out.println("Por favor ingrese una opci�n v�lida.");
					System.out.println("------------------------------------");
					break;
			}
		}

	}

}
