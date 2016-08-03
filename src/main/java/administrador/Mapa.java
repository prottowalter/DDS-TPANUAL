package administrador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import administrador.adaptadores.AdaptadorServicioExterno;
import administrador.adaptadores.AdaptadorServicioExternoBancos;
import administrador.adaptadores.AdaptadorServicioExternoCGP;

import tpanual.main.Dias;
import tpanual.main.poi.PuntoDeInteres;

public class Mapa {
	
	private List<PuntoDeInteres> puntos;
	private List<AdaptadorServicioExterno> adaptadores;

	private static Mapa instance;
	
	public static Mapa getInstance(){
		if (instance==null)
			instance=new Mapa();
		return instance;
	}
	
	private Mapa() {
		puntos=new ArrayList<PuntoDeInteres>();
		adaptadores=new ArrayList<AdaptadorServicioExterno>();
		adaptadores.add(new AdaptadorServicioExternoBancos());
		adaptadores.add(new AdaptadorServicioExternoCGP());
	}
	
	public void agregarPunto(PuntoDeInteres punto){
		puntos.add(punto);
	}
	
	public PuntoDeInteres eliminarPunto(int id){
		return puntos.remove(id);
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
		List<PuntoDeInteres> listaExterna=buscarEnFuentesExternas(x);
		agregarAMemoria(listaExterna);
		listaADevolver.addAll(listaExterna);
		return listaADevolver;
	}
	
	public PuntoDeInteres obtenerPuntoDeInteres(int id){
		return puntos.get(id);
	}
	/**
	 * Busca en las todas las fuentes de POI externas consultando la lista de adaptadores de fuentes externas.
	 * @param x
	 * @return
	 */
	
	private List<PuntoDeInteres> buscarEnFuentesExternas(String x){
		Iterator<AdaptadorServicioExterno> i=adaptadores.iterator();
		List<PuntoDeInteres> lista=new ArrayList<PuntoDeInteres>();
		while (i.hasNext()){
			AdaptadorServicioExterno adaptador=i.next();
			lista.addAll(adaptador.buscar(x));
		}
		return lista;
	}
	
	/**
	 * Agrega a la lista de POI en memoria la lista que recibe por parámetro
	 * @param lista
	 */
	
	private void agregarAMemoria(List<PuntoDeInteres> lista){
		Iterator<PuntoDeInteres> i=lista.iterator();
		while (i.hasNext()){
			agregarPunto(i.next());
		}
	}
}
