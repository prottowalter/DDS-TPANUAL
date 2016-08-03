package administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import tpanual.utilitarios.Constantes;

public class AdministradorDeBusquedas {
	
	private static List<Busqueda> busquedas=new ArrayList<Busqueda>();
	
	public boolean seRealizoLaBusquedaAnteriormente(String x){
		Iterator<Busqueda> it = busquedas.iterator();
		while (it.hasNext()){
			Busqueda b=it.next();
			if (b.coincideBusqueda(x)) 
				return true;
		}
		return false;
	}

}
