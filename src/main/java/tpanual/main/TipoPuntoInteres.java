package tpanual.main;



public abstract class TipoPuntoInteres {
	String horario;

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	abstract public void tuHorario();
	abstract public int getRadioCercania();
	public abstract boolean coincidencia(String x);
	public abstract boolean cercanoEntre(double latitudPunto,double longitudPunto,double latitudCoordenada,double longitudCoordenada, int comunaId);
}