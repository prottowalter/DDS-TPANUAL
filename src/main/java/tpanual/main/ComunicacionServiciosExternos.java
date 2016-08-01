package tpanual.main;

import java.net.URL;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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

			return null;
		} 
		catch (Exception e) 
		{
			return null;
		}

	}

	@Override
	public List<PuntoDeInteres> obtenerBancosPorNombreYServicio(
			String nombreBanco, String nombreServicioOfrecido) {
		// TODO Auto-generated method stub
		return null;
	}

}
