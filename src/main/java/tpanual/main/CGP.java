package tpanual.main;

import java.util.ArrayList;
import java.util.Iterator;

public class CGP extends TipoPuntoInteres{
	
	ArrayList<Servicio> servicios;
	private int comunaId;
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public int getComunaId() {
		return comunaId;
	}

	public CGP(ArrayList<Servicio> servicios, int comundaId) {
		this.servicios=servicios;
	}
	
	public int getRadioCercania(){
		return 0;
	}

	@Override
	public void tuHorario() {
		
	}
	
	public boolean coincidencia(String x){
		Iterator<Servicio> it=servicios.iterator();
		boolean aparicion=false;
		while (it.hasNext() && !aparicion){
			if (it.next().getNombre().indexOf(x) != -1) 
				aparicion=true;
		}
		return aparicion;
	}
}