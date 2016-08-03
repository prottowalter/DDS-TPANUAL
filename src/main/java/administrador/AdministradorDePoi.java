package administrador;

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
		return Mapa.getInstance().buscarPuntosDeInteres(x);
	}
}
