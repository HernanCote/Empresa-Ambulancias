package co.edu.javeriana.ambulancias.entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import co.edu.javeriana.ambulancias.ambulancias.Ambulancia;
import co.edu.javeriana.ambulancias.enums.TipoDireccion;
import co.edu.javeriana.ambulancias.enums.TipoUCI;

public interface IServiciosAmbulancias {
	
	public void agregarIPS(String nombre, String tipoAtencion, TipoDireccion tipoDireccion, int calle, int carrera, int numero);
	public void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero, TipoUCI tipoUCI);
	public boolean registrarPosicionAmbulancia(int codigo, GregorianCalendar horaPosicion,int posicionCalle, int posicionCarrera);
	public void registrarServicio (Servicio serv);
	public String asignarUnServicio(int codigo);
	public boolean finalizarUnServicio(int codigo);
	public ArrayList<Servicio> getServicios();
	public HashMap<Integer, Ambulancia> getAmbulancias();
	public Servicio getServicioById(int id);
}
