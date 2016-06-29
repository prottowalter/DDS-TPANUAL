package tpanual.factory;

import java.util.ArrayList;
import java.util.List;

import tpanual.main.CGP;
import tpanual.main.Direccion;
import tpanual.main.LocalComercial;
import tpanual.main.ParadaColectivo;
import tpanual.main.PuntoDeInteres;
import tpanual.main.Rubro;
import tpanual.main.Servicio;
import tpanual.main.SucursalBanco;

public class PuntoDeInteresFactory {
	public static PuntoDeInteres getGCP(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClave, ArrayList<Servicio> servicios, int comunaId){
		CGP gcp=new CGP(servicios, comunaId);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, palabrasClave, gcp);
		return punto;
	}
	public static PuntoDeInteres getLocalComercial(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClave, Rubro rubro){
		LocalComercial l=new LocalComercial(rubro);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, palabrasClave, l);
		return punto;
	}
	public static PuntoDeInteres getParadaDeColectivo(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClave, String linea){
		ParadaColectivo bondi=new ParadaColectivo(linea);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, palabrasClave, bondi);
		return punto;
	}
	public static PuntoDeInteres getSucursal(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClave){
		SucursalBanco sucursal=new SucursalBanco();
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, palabrasClave, sucursal);
		return punto;
	}	
}
