package tpanual.main;

public class LocalComercial extends TipoPuntoInteres {

	private Rubro rubro;
	
	public LocalComercial(Rubro rubro){
		this.rubro=rubro;
	}
	
	public void tuHorario () {
		//super.setHorario("09:00 a 18:00");
		super.getHorario();
		}

	public int getRadioCercania() {
		return rubro.tuRadioDeCercania();
	}
	
}
