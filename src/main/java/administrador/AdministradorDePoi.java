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
		String listaStrings[] = {x};
		Busqueda busqueda=AdministradorDeBusquedas.getInstance().getBusquedaAnterior(listaStrings);
		List<PuntoDeInteres> lista;
		if (busqueda!=null){
			try{
				this.devolverPoiPorIds(busqueda.getIdsEncontrados());
			}catch(PuntoDeInteresNoEncontradoException e){
				//Se invalida la busqueda anterior y se procede a buscar normalmente
			}
		}
		lista=Mapa.getInstance().buscarPuntosDeInteresEnMemoria(x);
		lista.addAll(Mapa.getInstance().buscarEnFuentesExternas(x, test));
		AdministradorDeBusquedas.getInstance().agregarBusqueda(listaStrings, lista);
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

	
	public List<PuntoDeInteres> buscarBancos(String banco, String servicio, boolean test){
		String listaStrings[] = {banco, servicio};
		Busqueda busqueda=AdministradorDeBusquedas.getInstance().getBusquedaAnterior(listaStrings);
		List<PuntoDeInteres> lista;
		if (busqueda!=null){
			try{
				this.devolverPoiPorIds(busqueda.getIdsEncontrados());
			}catch(PuntoDeInteresNoEncontradoException e){
				//Se invalida la busqueda anterior y se procede a buscar normalmente
			}
		}
		lista=Mapa.getInstance().buscarPuntosDeInteresEnMemoria(banco);
		lista.addAll(Mapa.getInstance().buscarPuntosDeInteresEnMemoria(servicio));
		lista.addAll(Mapa.getInstance().buscarBancos(banco, servicio));
		AdministradorDeBusquedas.getInstance().agregarBusqueda(listaStrings, lista);
		return lista;
	}
	
}
