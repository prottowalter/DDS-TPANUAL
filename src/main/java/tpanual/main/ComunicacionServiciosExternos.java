package tpanual.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ComunicacionServiciosExternos implements
		IComunicacionServiciosExternos {

	@Override
	public List<PuntoDeInteres> obtenerCGPEnCalleOZona(String calleOZona) {
		String uri = "http://localhost:8080/CustomerService/rest/customers/1";
		URL url;
		try {
			Client client = Client.create();
			String strUrl = String.format("http://trimatek.org/Consultas/centro?zona=%s", "Boedo");
			WebResource webResource = client.resource(strUrl);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			String s = response.getEntity(String.class);
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(s);
			JsonArray jsonArray = (JsonArray)obj;

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
