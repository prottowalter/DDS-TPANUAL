package tpanual.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tpanual.main.poi.PuntoDeInteres;

public class Mapa {
	
	private List<PuntoDeInteres> puntos = new ArrayList<PuntoDeInteres>();

	private static Mapa instance;
	
	public static Mapa getInstance(){
		if (instance==null)
			instance=new Mapa();
		return instance;
	}
	
	private Mapa() {
		puntos=new ArrayList<PuntoDeInteres>();
	}
	
	public void agregarPunto(PuntoDeInteres punto){
		puntos.add(punto);
	}
	
	public boolean esCercano(PuntoDeInteres punto, double latitud, double longitud, int comunaId){
		
		return (punto.cercanoA(latitud,longitud,comunaId));

	}
	
	public boolean estaDisponible(PuntoDeInteres punto, Dias dia, int hora, String x){
		  return punto.estaDisponible(dia, hora , x);
	}
	
	/**
	 * Recibe un texto libre, busca en los puntos de interes almacenados en el mapa, aquellos que cumplan coincidencia con el texto y los devuelve.
	 */
	public List<PuntoDeInteres> buscarPuntosDeInteres(String x){
		List<PuntoDeInteres> listaADevolver=new ArrayList<PuntoDeInteres>();
		Iterator<PuntoDeInteres> it=puntos.iterator();
		while (it.hasNext()){
			PuntoDeInteres punto=it.next();
			if (punto.buscarCoincidencia(x)) listaADevolver.add(punto);
		}
		return listaADevolver;
	}
	
	public PuntoDeInteres obtenerPuntoDeInteres(int id){
		return puntos.get(id);
	}
	
}
