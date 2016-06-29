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

	public void tuHorario () {
		//super.setHorario("09:00 a 18:00");
		super.getHorario();
	}
	
	public int getRadioCercania(){
		return 100;
	}
}
