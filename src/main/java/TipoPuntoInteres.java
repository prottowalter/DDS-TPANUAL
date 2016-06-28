
public abstract class TipoPuntoInteres {
	String horario;
	Integer cercania;
	
	public Integer getCercania() {
		return cercania;
	}

	public void setCercania(Integer cercania) {
		this.cercania = cercania;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public TipoPuntoInteres() {
		// TODO Auto-generated constructor stub
	}
	
	abstract public void tuHorario();

}
