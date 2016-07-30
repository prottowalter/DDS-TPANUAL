package tpanual.main.poi;

//import java.util.Iterator;
import java.util.List;

import tpanual.main.Direccion;
import tpanual.utilitarios.Utilitarios;



public class PuntoDeInteres {
	double latitud;
	double longitud;
	String nombre;
	Direccion direccion;
	TipoPuntoInteres tipo;
	List<String> palabrasClaves;
	
	public PuntoDeInteres(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClaves, TipoPuntoInteres tipo) {
		this.latitud=latitud;
		this.longitud=longitud;
		this.nombre=nombre;
		this.direccion=direccion;
		this.tipo=tipo;
		this.palabrasClaves=palabrasClaves;
	}

	public double getLatitud() {
		return latitud;
	}


	public double getLongitud() {
		return longitud;
	}

	public String getNombre() {
		return nombre;
	}


	public Direccion getDireccion() {
		return direccion;
	}

	public TipoPuntoInteres getTipo() {
		return tipo;
	}

	
	public String coordenadas(){
		return this.latitud + "," + this.longitud;
	}
	
	public boolean cercanoA(double unaLatitud, double unaLongitud, int comunaId){
		
		return this.tipo.cercanoEntre(this.latitud, this.longitud, unaLatitud, unaLongitud, comunaId);
}
	

	public boolean buscarCoincidencia(String x){
		
		return Utilitarios.buscarPalabraEnUnaLista(x, palabrasClaves) || tipo.coincidencia(x)|| (nombre.indexOf(x) != -1);

	}
	
}

