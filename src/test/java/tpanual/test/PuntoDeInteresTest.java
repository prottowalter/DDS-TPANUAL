package tpanual.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tpanual.factory.PuntoDeInteresFactory;
import tpanual.main.Direccion;
import tpanual.main.Mapa;
import tpanual.main.PuntoDeInteres;

public class PuntoDeInteresTest {

	@Test
	public void puntoCercanoACoordenadaTest(){
		Mapa mapa = Mapa.getInstance();
		//Creo la dirección
		Direccion direccionDeLaSucursal= new Direccion.DireccionBuilder().barrio("Villa Urquiza").callePrincipal("Av. Triunvirato").numero("5201").crearDireccion();
		ArrayList<String> palabrasClave = new ArrayList<String>();
		palabrasClave.add("Nunca tiene plata");
		
		PuntoDeInteres puntoFactory = PuntoDeInteresFactory.getSucursal(-34.573001D, -58.490937D, "Banco Francés", direccionDeLaSucursal, palabrasClave);
								
		assertFalse(mapa.esCercano(puntoFactory, -34.568459D, -58.486106D, 12));
		assertTrue(mapa.esCercano(puntoFactory, -34.570581D, -58.489611D, 12));
	}

}
