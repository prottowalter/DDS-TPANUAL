package administrador.adaptadores;

import java.util.List;

import tpanual.factory.InterfacesExternasFactory;
import tpanual.main.poi.PuntoDeInteres;

public class AdaptadorServicioExternoCGP implements AdaptadorServicioExterno {

	public List<PuntoDeInteres> buscar(String x) {
		return InterfacesExternasFactory.getComunicacionServiciosExternos().obtenerCGPEnCalleOZona(x);
	}

}
