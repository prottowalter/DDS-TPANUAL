package tpanual.main;

import java.util.ArrayList;

public class CGP extends TipoPuntoInteres{
	
	ArrayList<Servicio> servicios;
	private int comunaId;
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public int getComunaId() {
		return comunaId;
	}

	public CGP(ArrayList<Servicio> servicios, int comundaId) {
		this.servicios=servicios;
	}
	
	public int getRadioCercania(){
		return 0;
	}

	@Override
	public void tuHorario() {
		
	}
}
