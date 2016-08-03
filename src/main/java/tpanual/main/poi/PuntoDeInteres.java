package tpanual.main.poi;

import java.lang.reflect.Field;
import java.util.List;

import tpanual.main.Dias;
import tpanual.main.Direccion;
import tpanual.utilitarios.Utilitarios;

public class PuntoDeInteres {
	private int id;
	private double latitud;
	private double longitud;
	private String nombre;
	private Direccion direccion;
	private TipoPuntoInteres tipo;
	private List<String> palabrasClaves;
	
	//Para modificar POI
	private static String[] fieldsModificables={"latitud", "longitud", "nombre", "direccion", "tipo", "palabrasClaves"};
	
	private static int maxId=0;
	
	public PuntoDeInteres(double latitud, double longitud, String nombre, Direccion direccion, List<String> palabrasClaves, TipoPuntoInteres tipo) {
		this.id=++maxId;
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

	public boolean estaDisponible(Dias dia, int hora, String x) {
		return tipo.estaDisponible(dia, hora, x);
	}

	public int getId() {
		return id;
	}
	
	public boolean afectarCambios(PuntoDeInteres poi) {
		Class<?> clase=this.getClass();
		for (int a=0;a<fieldsModificables.length;a++){
			try{
				Field f=clase.getDeclaredField(fieldsModificables[a]);
				Object s1=f.get(poi);
				Object s2=f.get(this);
				if (s1.equals(s2))
					f.set(this, s2);
			}catch(NoSuchFieldException nsfe){
				nsfe.printStackTrace();
				System.out.println("Error, no existe el field " + fieldsModificables[a] + " en la clase " + clase.getCanonicalName());
				return false;
			}catch(IllegalAccessException iae){
				iae.printStackTrace();
				System.out.println("Error, no se puede acceder a " + fieldsModificables[a] + " en la clase " + clase.getCanonicalName());
				return false;
			}
			
		}
		return true;
	}

}

