package tpanual.main;

import tpanual.utilitarios.Constantes;



public class ParadaColectivo extends TipoPuntoInteres {
	
	private String linea;
	
	public String getLinea() {
		return linea;
	}

	public ParadaColectivo(String linea) {
		this.linea=linea;
	}

	public boolean estaDisponible () {
		//super.setHorario("09:00 a 18:00");
		return Constantes.PARADA_DE_COLECTIVO_DISPONIBILIDAD; //Una parada de colectivos siempre está dispnible
	}
	
	public int getRadioCercania(){
		return Constantes.PARADA_DE_COLECTIVO_RADIO_DE_CERCANIA;
	}

	@Override
	public boolean coincidencia(String x) {
		return linea.toUpperCase().indexOf(x.toUpperCase()) != -1;
	}

	@Override
	public boolean cercanoEntre(double latitudPunto, double longitudPunto, double latitudCoordenada,
			double longitudCoordenada, int comunaId) {
		Mapa map1 = Mapa.getInstance();
		return (this.getRadioCercania()) >= (int) (map1.distance(latitudPunto,longitudPunto,latitudCoordenada,longitudCoordenada,"K") * 1000);
		
	}
}
