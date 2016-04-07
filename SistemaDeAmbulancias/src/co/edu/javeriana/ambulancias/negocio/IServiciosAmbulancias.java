package co.edu.javeriana.ambulancias.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.ambulancias.Ambulancia;

public interface IServiciosAmbulancias {
	
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero);
	public void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero, String tipoUCI);
	public boolean registrarPosicionAmbulancia(int codigo, GregorianCalendar horaPosicion,int posicionCalle, int posicionCarrera);
	public void registrarServicio (Servicio serv);
	public String asignarUnServicio(int codigo);
	public boolean finalizarUnServicio(int codigo);
	public ArrayList<Servicio> getServicios();
	public ArrayList<Ambulancia> getAmbulancias();
	
}
