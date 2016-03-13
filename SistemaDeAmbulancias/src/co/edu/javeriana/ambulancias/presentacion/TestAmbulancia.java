/**
 * 
 */
package co.edu.javeriana.ambulancias.presentacion;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;

/**
 * @author Hernan Cote and Juan Pablo Peñaloza
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
					// Added this option on the switch. 
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
					// Implementar 
					break;
				case "8":
					// TODO Juan Pablo
					empresaAmbulancias.imprimirTodosLosrServicios();
					break;
				case "9":
					// TODO Hernan 
					break;
				case "10":
					break;
				default: 
					System.out.println("------------------------------------");
					System.out.println("Por favor ingrese una opci�n v�lida.");
					System.out.println("------------------------------------");
					break;
			}
		} while (!opcion.equals("10"));

	}

}
