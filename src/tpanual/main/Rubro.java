package tpanual.main;

public abstract class Rubro {
	Integer cercania;

	public Integer getCercania() {
		return cercania;
	}

	public void setCercania(Integer cercania) {
		this.cercania = cercania;
	}
	
	abstract public Integer tuRadioDeCercania();
}
