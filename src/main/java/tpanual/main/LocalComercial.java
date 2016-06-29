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
		return rubro.getNombre().indexOf(x)!=-1;
	}
	
}
