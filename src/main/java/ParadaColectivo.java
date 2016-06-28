
public class ParadaColectivo extends TipoPuntoInteres {
Integer cercania = 100;
	public ParadaColectivo() {
		// TODO Auto-generated constructor stub
	}

	public void tuHorario () {
		//super.setHorario("09:00 a 18:00");
		super.getHorario();
		}

	public Integer getCercania() {
		return cercania;
	}

	public void setCercania(Integer cercania) {
		this.cercania = cercania;
	}
	
	}
