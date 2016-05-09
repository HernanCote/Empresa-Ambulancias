package co.edu.javeriana.ambulancias.presentacion;

import co.edu.javeriana.ambulancias.entidades.EmpresaAmbulancias;

/**
 * TestAmbulancia.java
 * ------------------------------------------
 * This is a program that administrate the assignment of 
 * ambulances to services based on the proximity of 
 * a fleet of ambulances. This class just presents 
 * the menu of the program.
 * @author Hernan Cote and Juan Pablo Penaloza
 * @version 2.0
 *
 */
public class TestAmbulancia 
{

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpresaAmbulancias empresaAmbulancias = new EmpresaAmbulancias("Ambu S.A.");
		String opcion = null;
		
		do
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
					Utils.registrarPosicion(empresaAmbulancias);
					break;
				case "4":
					Utils.registrarServicio(empresaAmbulancias);
					break;
				case "5":
					empresaAmbulancias.reporteDeAmbulancias();
					break;
				case "6":
					String message = Utils.asignarUnServicio(empresaAmbulancias);
					if(message != null)
					{
						System.out.println("---------------------------------"
								+ "----------------------------------------");
						System.out.println(message);
						System.out.println("---------------------------------"
								+ "----------------------------------------");
					}
					else 
					{
						System.out.println("Error al asignar el servicio");
					}
					break;
				case "7":
					Utils.imprimirServiciosAsignados(empresaAmbulancias);
					break;
				case "8":
					empresaAmbulancias.imprimirTodosLosrServicios();
					break;
				case "9":					
					empresaAmbulancias.reporteIpsYServicios();
					break;
				case "10":
					empresaAmbulancias.estadisticaAmbulanciasDisponibles();
					break;
				case "11":
					Utils.pacientesAtendidos(empresaAmbulancias);
					break;
				case "12":
					System.out.println("Sistema Terminado!!");
					break;
				default: 
					System.out.println("------------------------------------");
					System.out.println("Por favor ingrese una opcion valida.");
					System.out.println("------------------------------------");
					break;
			}
		} while (!opcion.equals("12"));

	}
	
}
