package tpanual.main;

import java.util.ArrayList;

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
		return true; //Una parada de colectivos siempre está dispnible
	}
	
	public int getRadioCercania(){
		return 100;
	}

	@Override
	public boolean coincidencia(String x) {
		return linea.indexOf(x) != -1;
	}
}
