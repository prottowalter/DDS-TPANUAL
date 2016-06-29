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
	
	
}
