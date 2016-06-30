package tpanual.main;

import java.util.Iterator;
import java.util.List;

public class CGP extends TipoPuntoInteres{
	
	List<Servicio> servicios;
	
	private int comunaId;
	
	public List<Servicio> getServicios() {
		return servicios;
	}

	public int getComunaId() {
		return comunaId;
	}

	public CGP(List<Servicio> servicios, int comundaIid) {
		this.servicios=servicios;
		this.comunaId = comundaIid;
	}

	public int getRadioCercania() {
		return 0;
	}

	@Override
	public boolean estaDisponible(Dias dia, int hora, String x) {
		return false;
	}
	
	public boolean coincidencia(String x){
		Iterator<Servicio> it=servicios.iterator();
		boolean aparicion=false;
		while (it.hasNext() && !aparicion){
			if (it.next().getNombre().toUpperCase().indexOf(x.toUpperCase()) != -1) 
				aparicion=true;
		}
		return aparicion;
	}

	@Override
	public boolean cercanoEntre(double latitudPunto, double longitudPunto, double latitudCoordenada,
			double longitudCoordenada, int comunaId) {
		
		return this.comunaId == comunaId;

	}
	/**
	 * Recibe un servicio y te dice si esta en la lista de servicios del CGP
	 * @param x
	 * @return
	 */
	public boolean estaEnLaListaDeServicios(String x){
		Iterator<Servicio> i=servicios.iterator();
		while (i.hasNext()){
			if (i.next().getNombre().toUpperCase().indexOf(x.toUpperCase())!= -1) return true;
		}
		return false;
	}
}
