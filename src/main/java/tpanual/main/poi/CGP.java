package tpanual.main.poi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tpanual.main.Servicio;
import tpanual.utilitarios.Constantes;

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
	
	public int getRadioCercania(){
		return Constantes.CGP_CERCANIA;
	}

	@Override
	public boolean estaDisponible() {
		return Constantes.CGP_COMERCIAL_DISPONIBILIDAD;
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
