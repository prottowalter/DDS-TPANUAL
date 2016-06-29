package tpanual.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Mapa {
	
	private List<PuntoDeInteres> puntos;
	
	public Mapa() {
		// TODO Auto-generated constructor stub
	}
	
	
	//public static void main (String[] args) throws java.lang.Exception
	//{
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
	//}

	public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);	
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	//sebas
	public boolean esCercano(PuntoDeInteres punto, int latitud, int longitud, int comunaId){
		return true;
	}
	//marce
	/*public boolean estaDisponible(Momento momento, String x){
	 * return true;
	}
	*/
	/**
	 * Recibe un texto libre, busca en los puntos de interes almacenados en el mapa, aquellos que cumplan coincidencia con el texto y los devuelve.
	 */
	public List<PuntoDeInteres> obtenerPuntosDeInteres(String x){
		List<PuntoDeInteres> listaADevolver=new ArrayList<PuntoDeInteres>();
		Iterator<PuntoDeInteres> it=puntos.iterator();
		while (it.hasNext()){
			PuntoDeInteres punto=it.next();
			if (punto.buscarCoincidencia(x)) listaADevolver.add(punto);
		}
		return listaADevolver;
	}
	
}