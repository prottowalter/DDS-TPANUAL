package tpanual.main;

public class SucursalBanco extends TipoPuntoInteres{

	HorarioDeAtencion horas = new HorarioDeAtencion();

	public SucursalBanco(){
		for (int i=1;i<6;i++) //Agrega el horario de atencion lunes a viernes de 10:00 a 15:00
			horas.addRangoDia(1000, 1500, i);
	}

	@Override
	public int getRadioCercania() {
		return 500;
	}

	@Override
	public boolean estaDisponible() {
		// TODO Auto-generated method stub
		return false;
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
