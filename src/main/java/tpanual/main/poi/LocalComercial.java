package tpanual.main.poi;

import tpanual.Rubro.RubroFW;
import tpanual.main.Mapa;
import tpanual.utilitarios.Constantes;

public class LocalComercial extends TipoPuntoInteres {

	private RubroFW rubro;
	
	public LocalComercial(RubroFW rubro){
		this.rubro=rubro;
	}
	
	public boolean estaDisponible () {
		//super.setHorario("09:00 a 18:00");
			return Constantes.LOCAL_COMERCIAL_DISPONIBILIDAD;
		}

	public int getRadioCercania() {
		return rubro.getCercania();
	}

	@Override
	public boolean coincidencia(String x) {
		
		return rubro.getNombre().toUpperCase().indexOf(x.toUpperCase())!=-1;
	}

	@Override
	public boolean cercanoEntre(double latitudPunto, double longitudPunto, double latitudCoordenada,
			double longitudCoordenada, int comunaId) {

		Mapa map1 = Mapa.getInstance();
		return (this.getRadioCercania()) >= (int) (map1.distance(latitudPunto,longitudPunto,latitudCoordenada,longitudCoordenada,"K") * 1000);
	}
	
}
