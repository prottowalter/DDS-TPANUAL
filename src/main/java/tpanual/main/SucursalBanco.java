package tpanual.main;

public class SucursalBanco extends TipoPuntoInteres{

	public SucursalBanco(){
	}
	
	@Override
	public int getRadioCercania() {
		return 500;
	}

	@Override
	public void tuHorario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean coincidencia(String x) {
		return false;
	}

	@Override
	public boolean cercanoEntre(double latitudPunto, double longitudPunto, double latitudCoordenada,
			double longitudCoordenada, int comunaId) {

		Mapa map1 = Mapa.getInstance();
		return (this.getRadioCercania()) >= (int) (map1.distance(latitudPunto,longitudPunto,latitudCoordenada,longitudCoordenada,"K") * 1000);
	}
	
	
}
