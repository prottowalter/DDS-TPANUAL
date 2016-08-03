package administrador;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import tpanual.utilitarios.Constantes;

public class Busqueda {
	private DateTime fechaDeBusqueda;
	private String stringBuscado;
	private int[] idsEncontrados;
	
	public Busqueda(String stringBuscado, int[] idsEncontrados){
		this.stringBuscado=stringBuscado;
		this.idsEncontrados=idsEncontrados;
		this.fechaDeBusqueda=new DateTime();
	}
	
	public DateTime getFechaDeBusqueda() {
		return fechaDeBusqueda;
	}
	public String getStringBuscado() {
		return stringBuscado;
	}
	public int[] getIdsEncontrados() {
		return idsEncontrados;
	}
	
	public boolean coincideBusqueda(String x){
		return x.indexOf(stringBuscado)!=1 && Busqueda.fechaValida(fechaDeBusqueda);
	}

	public static boolean fechaValida(DateTime fecha){
		DateTime horaActual=new DateTime();
		Duration duracion=new Duration(fecha, horaActual);
		return duracion.getStandardHours()>Constantes.INTERVALO_DEHORAS_CONSIDERA_BUSQUEDA_RECIENTE;
	}	
}
