package tpanual.factory;

import tpanual.main.ComunicacionServiciosExternos;
import tpanual.main.IComunicacionServiciosExternos;

public class InterfacesExternasFactory {
	
	private static IComunicacionServiciosExternos iComunicacionServiciosExternos;
	
	public static IComunicacionServiciosExternos getComunicacionServiciosExternos(){
		if (iComunicacionServiciosExternos==null){
			iComunicacionServiciosExternos=new ComunicacionServiciosExternos();
		}
		return iComunicacionServiciosExternos;
	}
}
