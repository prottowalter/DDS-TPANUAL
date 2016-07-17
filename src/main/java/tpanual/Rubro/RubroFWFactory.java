package tpanual.Rubro;

import java.util.Iterator;
import java.util.List;

import tpanual.main.HorarioDeAtencion;

public class RubroFWFactory {
	private List<RubroFW> rubros;
	
	public RubroFW getRubro(String nombre, HorarioDeAtencion hda, int radioCercania){
		Iterator<RubroFW> it=rubros.iterator();
		while (it.hasNext()){
			RubroFW ocur=it.next();
			if (ocur.esIgual(nombre, hda, radioCercania)){
				return ocur;
			}			
		}
		RubroFW nuevoRubro=new RubroConcreteFW(hda, nombre, radioCercania);
		rubros.add(nuevoRubro);
		return nuevoRubro;
	}
}
