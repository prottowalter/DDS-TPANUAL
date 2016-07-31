package tpanual.main;

import java.util.List;

import tpanual.main.poi.PuntoDeInteres;

public interface IComunicacionServiciosExternos {
	/**
	 * Recibe nombre de una calle o de una zona y devuelve la lista de CGPs que matchean, segun el servicio REST correspondiente.
	 * ATENCION: Respuesta lenta
	 * @param
	 * @return Lista de CGP (puntos de interes)
	 */
	public List<PuntoDeInteres> obtenerCGPEnCalleOZona (String calleOZona);
	
	/**
	 * Recibe nombre de banco, algun servicio ofrecido por el mismo	y devuelve la lista de Bancos que matchea 7yn con ambos, segun el servicio REST correspondiente.
	 * ATENCION: Servicio pago por cantidad de pegadas
	 * @param
	 * @return Lista de Bancos (puntos de interes)
	 */
	public List<PuntoDeInteres> obtenerBancosPorNombreYServicio (String nombreBanco, String nombreServicioOfrecido);
}
