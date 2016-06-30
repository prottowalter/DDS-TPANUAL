package tpanual.main;

public abstract class TipoPuntoInteres {
	String horario;

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public abstract boolean estaDisponible(Dias dia, int hora, String x);
	abstract public int getRadioCercania();
	public abstract boolean coincidencia(String x);
}