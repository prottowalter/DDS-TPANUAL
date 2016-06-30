package tpanual.main;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
	private String nombre;
	
	public Servicio(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static List<Servicio> getListaServicios(String... s){
		List<Servicio> l=new ArrayList<Servicio>();
		for (int a=0;a<s.length;a++){
			l.add(new Servicio(s[a]));
		}
		return l;
	}
}

