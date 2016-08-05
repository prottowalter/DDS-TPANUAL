package administrador;

import java.util.ArrayList;
import java.util.List;

import tpanual.main.poi.PuntoDeInteres;

public class AdministradorDePoi {
	public boolean modificarPoi(PuntoDeInteres poi){
		PuntoDeInteres aModificar=Mapa.getInstance().obtenerPuntoDeInteres(poi.getId());
		if (aModificar!=null)
			return aModificar.afectarCambios(poi);
		return false;
	}
	
	public void agregarPoi(PuntoDeInteres poi){
		Mapa.getInstance().agregarPunto(poi);
	}
	public boolean eliminarPoi(PuntoDeInteres poi){
		return (Mapa.getInstance().eliminarPunto(poi.getId()) != null);
	}
	
	public List<PuntoDeInteres> busquedaDePuntosDeInteres(String x){
		return busquedaDePuntosDeInteres(x, false);
	}
	
	public List<PuntoDeInteres> busquedaDePuntosDeInteres(String x, boolean test){
		Busqueda busqueda=AdministradorDeBusquedas.getInstance().getBusquedaAnterior(x);
		List<PuntoDeInteres> lista;
		if (busqueda!=null){
			try{
				this.devolverPoiPorIds(busqueda.getIdsEncontrados());
			}catch(PuntoDeInteresNoEncontradoException e){
				lista= buscarEfectivamente(x);
				AdministradorDeBusquedas.getInstance().agregarBusqueda(x, lista);
				return lista;
			}
		}
		lista=buscarEfectivamente(x, test);
		AdministradorDeBusquedas.getInstance().agregarBusqueda(x, lista);
		return lista;
	}
	
	private List<PuntoDeInteres> devolverPoiPorIds(int... id) throws PuntoDeInteresNoEncontradoException{
		List<PuntoDeInteres> lista=new ArrayList<PuntoDeInteres>();
		for (int i=0;i<id.length;i++){
			PuntoDeInteres poi=Mapa.getInstance().obtenerPuntoDeInteres(id[i]);
			if (poi==null)
				throw new PuntoDeInteresNoEncontradoException("Uno de los ids de la busqueda ya no se encuentra en memoria.");
			lista.add(poi);
		
		}
		return lista;
	}
	
	private List<PuntoDeInteres> buscarEfectivamente(String x, boolean test){
		return Mapa.getInstance().buscarPuntosDeInteres(x, test);
	}
	
	private List<PuntoDeInteres> buscarEfectivamente(String x){
		return Mapa.getInstance().buscarPuntosDeInteres(x, false);
	}
}
