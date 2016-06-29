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
}