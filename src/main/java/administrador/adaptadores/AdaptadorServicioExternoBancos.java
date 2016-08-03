package administrador.adaptadores;

import java.util.List;

import tpanual.factory.InterfacesExternasFactory;
import tpanual.main.poi.PuntoDeInteres;

public class AdaptadorServicioExternoBancos implements AdaptadorServicioExterno {

	//TODO verificar que este criterio de busquedas a banco sea correcto
	public List<PuntoDeInteres> buscar(String x) {
		return InterfacesExternasFactory.getComunicacionServiciosExternos().obtenerBancosPorNombreYServicio(x, x);
	}

}
