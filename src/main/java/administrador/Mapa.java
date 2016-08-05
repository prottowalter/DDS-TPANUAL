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
		puntos.add( punto);
	}
	
	public PuntoDeInteres eliminarPunto(int id){
		
		Iterator<PuntoDeInteres> i=puntos.iterator();
		int c=0;
		while (i.hasNext()){
			PuntoDeInteres p=i.next();
			if (p.getId()== id)
				return puntos.remove(c);
			c++;
		}
		return null;
		
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
	public List<PuntoDeInteres> buscarPuntosDeInteres(String x, boolean test){
		List<PuntoDeInteres> listaADevolver=new ArrayList<PuntoDeInteres>();
		Iterator<PuntoDeInteres> it=puntos.iterator();
		while (it.hasNext()){
			PuntoDeInteres punto=it.next();
			if (punto.buscarCoincidencia(x)) listaADevolver.add(punto);
		}
		List<PuntoDeInteres> listaExterna=buscarEnFuentesExternas(x, test);
		agregarAMemoria(listaExterna);
		listaADevolver.addAll(listaExterna);
		return listaADevolver;
	}
	public List<PuntoDeInteres> buscarPuntosDeInteres(String x){
		return buscarPuntosDeInteres(x, false);
	}
	
	
	public PuntoDeInteres obtenerPuntoDeInteres(int id){
		
		Iterator<PuntoDeInteres> pdi=puntos.iterator();
		while (pdi.hasNext()){
			PuntoDeInteres p=pdi.next();
			if (p.getId()==id)
				return p;
		}
		return null;
	}
	/**
	 * Busca en las todas las fuentes de POI externas consultando la lista de adaptadores de fuentes externas.
	 * @param x
	 * @return
	 */
	
	private List<PuntoDeInteres> buscarEnFuentesExternas(String x, boolean test){
		Iterator<AdaptadorServicioExterno> i=adaptadores.iterator();
		List<PuntoDeInteres> lista=new ArrayList<PuntoDeInteres>();
		while (i.hasNext()){
			AdaptadorServicioExterno adaptador=i.next();
			if (!test){
				List<PuntoDeInteres> ll=adaptador.buscar(x);
				if (ll!=null)
					lista.addAll(ll);
			}else{
				//llamar al mock
			}
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
