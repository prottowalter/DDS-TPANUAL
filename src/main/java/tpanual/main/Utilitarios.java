package tpanual.main;

import java.util.Iterator;
import java.util.List;

public class Utilitarios {
	public static boolean buscarPalabraEnUnaLista(String x, List<String> lista){
		Iterator<String> it=lista.iterator();
		boolean aparicion=false;
		while (it.hasNext() && !aparicion){
			if (it.next().indexOf(x) != -1) 
				aparicion=true;
		}
		return aparicion;
	}
}
