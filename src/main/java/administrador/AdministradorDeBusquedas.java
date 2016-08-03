package administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import tpanual.main.poi.PuntoDeInteres;
import tpanual.utilitarios.Constantes;

public class AdministradorDeBusquedas {
	
	private List<Busqueda> busquedas;
	private static AdministradorDeBusquedas instance;
	
	private AdministradorDeBusquedas(){
		busquedas=new ArrayList<Busqueda>();
	}
	
	public static AdministradorDeBusquedas getInstance(){
		if (instance==null)
			instance=new AdministradorDeBusquedas();
		return instance;
	}
	
	public Busqueda getBusquedaAnterior(String x){
		Iterator<Busqueda> it = busquedas.iterator();
		while (it.hasNext()){
			Busqueda b=it.next();
			if (b.coincideBusqueda(x)) 
				return b;
		}
		return null;
	}
	
	public void agregarBusqueda(String x, List<PuntoDeInteres> lista){
		int[] ints=new int[0];
		Iterator<PuntoDeInteres> i=lista.iterator();
		
		while (i.hasNext()){
			PuntoDeInteres poi=i.next();
			agregarElemento(ints, poi.getId());
		}
		Busqueda b=new Busqueda(x, ints);
		busquedas.add(b);
	}
		
	private int[] agregarElemento(int[] lista, int ele){
		int c=0;
		for (int y=0;y<lista.length;y++){
			c++;
		}
		int[] nuevo=new int[c+1];
		for (int a=0;a<lista.length;a++){
			nuevo[a]=lista[a];
		}		
		nuevo[c]=ele;
		return nuevo;
	}
}
