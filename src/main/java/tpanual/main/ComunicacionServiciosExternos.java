package tpanual.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import tpanual.main.Direccion;
import tpanual.main.HorarioDeAtencion;
import tpanual.main.IComunicacionServiciosExternos;
import tpanual.main.Servicio;
import tpanual.main.poi.CGP;
import tpanual.main.poi.PuntoDeInteres;

public class ComunicacionServiciosExternos implements
		IComunicacionServiciosExternos {

	@Override
	public List<PuntoDeInteres> obtenerCGPEnCalleOZona(String calleOZona) {
		try {
			Client client = Client.create();
			String strUrl = String.format("http://trimatek.org/Consultas/centro?zona=%s", "Boedo");
			WebResource webResource = client.resource(strUrl);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			String s = response.getEntity(String.class);
			JsonParser parser = new JsonParser();
			
			JsonArray jsonArray = (JsonArray)parser.parse(s);
			
			
			List<PuntoDeInteres> listaPois = new ArrayList<PuntoDeInteres>();
			
			for(JsonElement unPoiJsonElement : jsonArray){
				
				JsonObject unPoiJsonObject = unPoiJsonElement.getAsJsonObject();
				listaPois.add(GenerarPoiAPartirDeDatosExternos(unPoiJsonObject));
			}

			return listaPois;
		} 
		catch (Exception e) 
		{
			return null;
		}

	}

	private PuntoDeInteres GenerarPoiAPartirDeDatosExternos(JsonObject unPoiJsonObject) {
		CGP tipoPoi = new CGP(
						getServiciosCGP(unPoiJsonObject.get("servicios").getAsJsonArray()),
						unPoiJsonObject.get("comuna").getAsInt());
		
		Direccion direccion = parsearDireccion(unPoiJsonObject.get("direccion").getAsString());
		PuntoDeInteres poi = 
				new PuntoDeInteres(
						0,
						0,
						"",
						direccion,
						new ArrayList<String>(),
						tipoPoi);
		
		return poi;
	}

	private Direccion parsearDireccion(String direccionSerealizada) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Servicio> getServiciosCGP(JsonArray serviciosJsonArray) {
		List<Servicio> listServicios = new ArrayList<Servicio>();
		
		for(JsonElement unServicioJsonElement : serviciosJsonArray){
			JsonObject unServicioJsonObject = unServicioJsonElement.getAsJsonObject();
			
			Servicio servicio = new Servicio(
					unServicioJsonObject.get("nombre").getAsString());
			
			List<HorarioDeAtencion> horarios = getHorariosServicio(unServicioJsonObject.get("horarios").getAsJsonArray());
			
			for(HorarioDeAtencion unHorario : horarios){
				servicio.setHorario(unHorario);
			}
			
			listServicios.add(servicio);
		}
		return listServicios;
	}

	private List<HorarioDeAtencion> getHorariosServicio(JsonArray asJsonArray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PuntoDeInteres> obtenerBancosPorNombreYServicio(
			String nombreBanco, String nombreServicioOfrecido) {
		// TODO Auto-generated method stub
		return null;
	}

}
