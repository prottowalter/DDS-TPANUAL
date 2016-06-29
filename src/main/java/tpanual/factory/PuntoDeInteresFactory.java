package tpanual.factory;

import java.util.ArrayList;

import tpanual.main.CGP;
import tpanual.main.Direccion;
import tpanual.main.LocalComercial;
import tpanual.main.ParadaColectivo;
import tpanual.main.PuntoDeInteres;
import tpanual.main.Rubro;
import tpanual.main.Servicio;
import tpanual.main.SucursalBanco;

public class PuntoDeInteresFactory {
	public static PuntoDeInteres getGCP(double latitud, double longitud, String nombre, Direccion direccion, ArrayList<Servicio> servicios, int comunaId){
		CGP gcp=new CGP(servicios, comunaId);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, gcp);
		return punto;
	}
	public static PuntoDeInteres getLocalComercial(double latitud, double longitud, String nombre, Direccion direccion, Rubro rubro){
		LocalComercial l=new LocalComercial(rubro);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, l);
		return punto;
	}
	public static PuntoDeInteres getParadaDeColectivo(double latitud, double longitud, String nombre, Direccion direccion, String linea){
		ParadaColectivo bondi=new ParadaColectivo(linea);
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, bondi);
		return punto;
	}
	public static PuntoDeInteres getSucursal(double latitud, double longitud, String nombre, Direccion direccion){
		SucursalBanco sucursal=new SucursalBanco();
		PuntoDeInteres punto=new PuntoDeInteres(latitud, longitud, nombre, direccion, sucursal);
		return punto;
	}	
}
