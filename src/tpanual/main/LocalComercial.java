package tpanual.main;

public class LocalComercial extends TipoPuntoInteres {
Integer cercania;
//Rubro unRubro;
	public void tuHorario () {
		//super.setHorario("09:00 a 18:00");
		super.getHorario();
		}

	public Integer getCercania() {
		return cercania;
	}

	public void setCercania(Rubro unRubro) {
		this.cercania = unRubro.tuRadioDeCercania();
	}
	
}
