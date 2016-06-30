package tpanual.main;

public class ParadaColectivo extends TipoPuntoInteres {

	private String linea;

	public String getLinea() {
		return linea;
	}

	public ParadaColectivo(String linea) {
		this.linea = linea;
	}

	public boolean estaDisponible(Dias dia, int hora, String x) {
		return true; // Una parada de colectivos siempre está dispnible
	}

	public int getRadioCercania() {
		return 100;
	}

	@Override
	public boolean coincidencia(String x) {
		return linea.indexOf(x) != -1;
	}
}
