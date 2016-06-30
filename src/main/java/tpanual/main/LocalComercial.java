package tpanual.main;

public class LocalComercial extends TipoPuntoInteres {

	private Rubro rubro;
	
	public LocalComercial(Rubro rubro){
		this.rubro=rubro;
	}
	
	public boolean estaDisponible () {
		//super.setHorario("09:00 a 18:00");
			return false;
		}

	public int getRadioCercania() {
		return rubro.tuRadioDeCercania();
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
