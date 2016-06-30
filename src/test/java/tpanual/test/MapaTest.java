package tpanual.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import tpanual.factory.PuntoDeInteresFactory;
import tpanual.main.Direccion;
import tpanual.main.Kiosko;
import tpanual.main.Mapa;
import tpanual.main.Muebleria;
import tpanual.main.PuntoDeInteres;
import tpanual.main.Rubro;
import tpanual.main.Servicio;



public class MapaTest {

	private static Mapa mapa;
	
	@Test
	public void buscarParadaDeColectivoTest(){
		
		/**
		 * Esta linea de colectivo esta en la lista de puntos de interes
		 */
		String criterio="114";
		
		List<PuntoDeInteres> lista=mapa.obtenerPuntosDeInteres(criterio);
		Iterator<PuntoDeInteres> i = lista.iterator();
		
		boolean aparicion=false;		
		while(i.hasNext()){
			
			PuntoDeInteres n=i.next();
			if (n.getNombre().equals("Parada de la linea ciento catorce")) aparicion=true;
			
		}
		assertTrue(aparicion);
		
		/**
		 * Esta linea NO esta en la lista
		 */		
		
		criterio="113";
		List<PuntoDeInteres> lista2=mapa.obtenerPuntosDeInteres(criterio);		
		
		assertTrue(lista2.isEmpty());		
	}
	
	@Test
	public void buscarLocalesPorRubroTest(){
		
		/**
		 * Busco en minuscula, deberia encontrar aunque este en mayúscula en el punto de interes
		 */
		String criterio="muebleria";
		
		List<PuntoDeInteres> lista=mapa.obtenerPuntosDeInteres(criterio);
		Iterator<PuntoDeInteres> i = lista.iterator();
		
		boolean aparicion1=false;
		boolean aparicion2=false;
		while(i.hasNext()){
			
			PuntoDeInteres n=i.next();
			if (n.getNombre().equals("Muebleria los dos hermanos")) aparicion1=true;
			if (n.getNombre().equals("Muebleria somos la contra de los dos hermanos")) aparicion2=true;
			if (n.getNombre().equals("Kiosko no se fia ni al cura parroco")) assertFalse(true);
			
		}
		assertTrue(aparicion1 && aparicion2);
		
		/**
		 * Esta linea NO esta en la lista
		 */		
		
		criterio="panaderia";
		List<PuntoDeInteres> lista2=mapa.obtenerPuntosDeInteres(criterio);		
		
		assertTrue(lista2.isEmpty());		
	}	

	@Test
	public void buscarPalabrasClaveTest(){
		
		String criterio="mala atencion";
		
		List<PuntoDeInteres> lista=mapa.obtenerPuntosDeInteres(criterio);
		
		assertTrue(lista.size()==2);
		
		Iterator<PuntoDeInteres> i = lista.iterator();
		
		boolean aparicion1=false;
		boolean aparicion2=false;
		while(i.hasNext()){
			
			PuntoDeInteres n=i.next();
			if (n.getNombre().equals("Muebleria somos la contra de los dos hermanos")) aparicion1=true;
			if (n.getNombre().equals("Sucursal 49")) aparicion2=true;
			
		}
		assertTrue(aparicion1 && aparicion2);
		
		criterio="una palabra clave que no esta";
		List<PuntoDeInteres> lista2=mapa.obtenerPuntosDeInteres(criterio);		
		
		assertTrue(lista2.isEmpty());		
	}	
	@Test
	public void buscarServicios(){
		
		String criterio="Denuncias";
		
		List<PuntoDeInteres> lista=mapa.obtenerPuntosDeInteres(criterio);
		
		assertTrue(lista.size()==1);
		
		Iterator<PuntoDeInteres> i = lista.iterator();
		
		boolean aparicion1=false;
		while(i.hasNext()){
			
			PuntoDeInteres n=i.next();
			if (n.getNombre().equals("GCP Comuna 1")) aparicion1=true;
			
		}
		assertTrue(aparicion1);
		
		criterio="Un servicio que no existe";
		List<PuntoDeInteres> lista2=mapa.obtenerPuntosDeInteres(criterio);		
		
		assertTrue(lista2.isEmpty());		
	}	
		
	
	@Test
	public void testEsCercanoACgp(){
		Mapa mapa = Mapa.getInstance();
		//Creo la dirección
		Direccion direccionCGP = new Direccion.DireccionBuilder().barrio("Villa Urquiza").callePrincipal("Miller").numero("2751").crearDireccion();
		ArrayList<String> palabrasClave = new ArrayList<String>();
		palabrasClave.add("CGP");
		List<Servicio> servicios=Servicio.getListaServicios("Registro Civil");
		
		PuntoDeInteres puntoFactory = PuntoDeInteresFactory.getCGP(-34.568574D, -58.482842D, "CGP 12", direccionCGP, palabrasClave, servicios, 12);
				
		assertTrue(mapa.esCercano(puntoFactory, -34.571896D, -58.490224D, 12));
		
	}

	@Test
	public void testEsCercanoAUnaParada(){
		Mapa mapa = Mapa.getInstance();
		//Creo la dirección
		Direccion direccionDeLaParada = new Direccion.DireccionBuilder().barrio("Villa Urquiza").callePrincipal("DR. Ignacio Rivera").numero("1889").crearDireccion();
		ArrayList<String> palabrasClave = new ArrayList<String>();
		palabrasClave.add("Cerca a una Plaza");
		
		PuntoDeInteres puntoFactory = PuntoDeInteresFactory.getParadaDeColectivo(-34.572426D, -58.489022D,"Parada Línea 176", direccionDeLaParada, palabrasClave, "176");
				
		assertTrue(mapa.esCercano(puntoFactory, -34.572713D, -58.488448D, 12));
		
	}

	/**
	 * Este metodo deberia ser usado por los demas test para que este centralizado la creacion del Mapa con puntos adentro
	 * @return
	 */
	
	@BeforeClass
	public static void setUp(){
		mapa=Mapa.getInstance() ;
		
		Direccion direccion=new Direccion.DireccionBuilder().callePrincipal("Pueyrredon").numero("545").barrio("Once").codigoPostal("1701").pais("Argentina")
		.provincia("Ciudad de Buenos Aires").crearDireccion();
		List<String> palabras=new ArrayList<String>();
		palabras.add("Vende Falopa");
		palabras.add("Mala Atencion");
		
		List<String> palabras2=new ArrayList<String>();
		palabras.add("CGP");
		palabras.add("Zona peligrosa");
		
		List<Servicio> servicios=Servicio.getListaServicios("Registro Civil", "Denuncias", "Pensiones");
		List<Servicio> servicios2=Servicio.getListaServicios("Venta de chicles", "Asesoramiento legal");
		Rubro rubro1=new Muebleria("Muebleria");
		Rubro rubro2=new Kiosko("Kiosko");

		PuntoDeInteres pdi=PuntoDeInteresFactory.getCGP(2500D, 3200D, "GCP Comuna 1", direccion, palabras2, servicios, 25);
		PuntoDeInteres pdi2=PuntoDeInteresFactory.getCGP(2500D, 3200D, "GCP Comuna 2", direccion, palabras2, servicios2, 25);
		PuntoDeInteres pdi3=PuntoDeInteresFactory.getParadaDeColectivo(600, 1200, "Parada de la linea ciento catorce", direccion, palabras2, "114");
		PuntoDeInteres pdi4=PuntoDeInteresFactory.getLocalComercial(-50D, 3000D, "Muebleria los dos hermanos", direccion, palabras2, rubro1);
		PuntoDeInteres pdi5=PuntoDeInteresFactory.getLocalComercial(-5D, 3001D, "Muebleria somos la contra de los dos hermanos", direccion, palabras, rubro1);
		PuntoDeInteres pdi6=PuntoDeInteresFactory.getLocalComercial(-654D, 1286D, "Kiosko no se fia ni al cura parroco", direccion, palabras2, rubro2);
		PuntoDeInteres pdi7=PuntoDeInteresFactory.getSucursal(-600D, 1023589D, "Sucursal 49", direccion, palabras);
		
		
		mapa.agregarPunto(pdi);
		mapa.agregarPunto(pdi2);
		mapa.agregarPunto(pdi3);
		mapa.agregarPunto(pdi4);
		mapa.agregarPunto(pdi5);
		mapa.agregarPunto(pdi6);
		mapa.agregarPunto(pdi7);
		
	}

}

