package tpanual.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import administrador.AdministradorDePoi;
import administrador.Mapa;
import tpanual.factory.PuntoDeInteresFactory;
import tpanual.main.Direccion;
import tpanual.main.Servicio;
import tpanual.main.poi.PuntoDeInteres;

public class AdministradorDePoisTest {

	//public AdministradorDePoisTest() {
		// TODO Auto-generated constructor stub
//	}
	
	/*
	 * ABMC entrega 2
	 * Revisar luego de que se completen los metodos, recordar crear el admin
	 */
	Mapa mapa=Mapa.getInstance() ;
	
	@Test
	public void eliminarPoiTest(){
	AdministradorDePoi administrador = new AdministradorDePoi();
	
	List<PuntoDeInteres> lista= mapa.buscarPuntosDeInteres("");
	assertTrue(lista.size()==7);
	
	Iterator<PuntoDeInteres> i = lista.iterator();
	boolean aparicion1=false;
	while(i.hasNext()){	
		PuntoDeInteres n=i.next();
		if (n.getNombre().equals("Sucursal 49")) aparicion1=true;
	}
	
	assertTrue(aparicion1);
	
	lista.clear();
	
	lista=mapa.buscarPuntosDeInteres("Sucursal 49");
	
	i = lista.iterator();
	while(i.hasNext()){	
		PuntoDeInteres n=i.next();
		administrador.eliminarPoi(n); 
	}
	
	lista.clear();
	lista=mapa.buscarPuntosDeInteres("Sucursal 49");
	assertTrue(lista.size()==0);
	
	lista=mapa.buscarPuntosDeInteres("");
	assertTrue(lista.size()==6);
	
	}
	

	
	
	@Test
	public void agregarPoiTest(){
		
	AdministradorDePoi administrador = new AdministradorDePoi();
		
	List<PuntoDeInteres> lista=mapa.buscarPuntosDeInteres("");
	assertTrue(lista.size()==7);
	
	Iterator<PuntoDeInteres> i = lista.iterator();
	boolean aparicion1=false;
	while(i.hasNext()){	
		PuntoDeInteres n=i.next();
		if (n.getNombre().equals("Sucursal 42")) aparicion1=true;
	}
	
	assertFalse(aparicion1);
	
	lista.clear();
	
	Direccion direccion=new Direccion.DireccionBuilder().callePrincipal("Pueyrredon").numero("545").barrio("Once").codigoPostal("1701").pais("Argentina")
			.provincia("Ciudad de Buenos Aires").crearDireccion();
			List<String> palabras=new ArrayList<String>();
			palabras.add("Servicio de cafeteria");
			List<Servicio> servicios2=Servicio.getListaServicios("Venta de chicles", "Asesoramiento legal");
			PuntoDeInteres pdiAAgregar=PuntoDeInteresFactory.getSucursal(-600D, 1023589D, "Sucursal 42", direccion, palabras, servicios2);
	
	administrador.agregarPoi(pdiAAgregar);
	
	lista=mapa.buscarPuntosDeInteres("");
	assertTrue(lista.size()==8);
	
	Iterator<PuntoDeInteres> j = lista.iterator();
	aparicion1=false;
	while(j.hasNext()){	
		PuntoDeInteres n=j.next();
		if (n.getNombre().equals("Sucursal 42")) aparicion1=true;
		}

	}
	


	@Test
	public void modificarPoiTest(){
		
	AdministradorDePoi administrador = new AdministradorDePoi();
	
	List<PuntoDeInteres> lista=mapa.buscarPuntosDeInteres("");
	assertTrue(lista.size()==7);
	
	Iterator<PuntoDeInteres> i = lista.iterator();
	boolean aparicion1=false;
	boolean aparicion2=false;
	while(i.hasNext()){	
		PuntoDeInteres n=i.next();
		if (n.getNombre().equals("Sucursal 49")&&n.buscarCoincidencia("No Coincidencia")) aparicion1=true;
		if (n.getNombre().equals("Sucursal 49")&&n.buscarCoincidencia("Mala Atencion")) aparicion2=true;
	}

	assertFalse(aparicion1);
	assertTrue(aparicion2);
	
	int idAGuardar = 0;
	PuntoDeInteres poiAMod;
	
	Iterator<PuntoDeInteres> j = lista.iterator();
	while(j.hasNext()){	
		poiAMod=j.next();
		if (poiAMod.getNombre().equals("Sucursal 49")&&poiAMod.buscarCoincidencia("Mala Atencion")) idAGuardar=poiAMod.getId();
	}
	
	/*
	 * creo un nuevo poi con los cambios a realizar y le cambio el id para que sea igual al anterior 
	 */
	
	Direccion direccion=new Direccion.DireccionBuilder().callePrincipal("Pueyrredon").numero("545").barrio("Once").codigoPostal("1701").pais("Argentina")
			.provincia("Ciudad de Buenos Aires").crearDireccion();
			List<String> palabras=new ArrayList<String>();
			palabras.add("No Coincidencia");
	List<Servicio> servicios3=Servicio.getListaServicios("Depositos", "Extracciones");
	PuntoDeInteres pdiNuevo=PuntoDeInteresFactory.getSucursal(-600D, 1023589D, "Sucursal 49", direccion, palabras, servicios3);
	//pdiNuevo.setId(idAGuardar);
	
	administrador.modificarPoi(pdiNuevo);
	
	Iterator<PuntoDeInteres> p = lista.iterator();
	aparicion1=false;
	aparicion2=false;
	while(p.hasNext()){	
		PuntoDeInteres n=i.next();
		if (n.getNombre().equals("Sucursal 49")&&n.buscarCoincidencia("No Coincidencia")) aparicion1=true;
		if (n.getNombre().equals("Sucursal 49")&&n.buscarCoincidencia("Mala Atencion")) aparicion2=true;
	}

	assertTrue(aparicion1);
	assertFalse(aparicion2);
	
	
	}
	

}
