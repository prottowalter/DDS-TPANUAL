import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tpanual.factory.PuntoDeInteresFactory;
import tpanual.main.Direccion;
import tpanual.main.Mapa;
import tpanual.main.PuntoDeInteres;
import tpanual.main.Servicio;

public class MapaTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void buscarParadaDeColectivoTest(){

		
	}
	
	/**
	 * Este metodo deberia ser usado por los demas test para que este centralizado la creacion del Mapa con puntos adentro
	 * @return
	 */
	
	public Mapa getMapaConPuntosDeInteres(){
		Mapa mapa=Mapa.getInstance();
		Direccion direccion=new Direccion.DireccionBuilder().callePrincipal("Pueyrredon").numero("545").barrio("Once").codigoPostal("1701").pais("Argentina")
		.provincia("Ciudad de Buenos Aires").crearDireccion();
		List<String> palabras=new ArrayList<String>();
		palabras.add("CGP");
		palabras.add("Zona peligrosa");
		List<Servicio> servicios=Servicio.getListaServicios("Registro Civil", "Denuncias", "Pensiones");
		PuntoDeInteres pdi=PuntoDeInteresFactory.getGCP(2500D, 3200D, "GCP Comuna 1", direccion, palabras, servicios, 25);
		mapa.agregarPunto(pdi);
		return mapa;
	}

}
