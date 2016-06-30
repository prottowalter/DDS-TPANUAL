package tpanual.main;

public class LocalComercial extends TipoPuntoInteres {

	private Rubro rubro;

	public LocalComercial(Rubro rubro) {
		this.rubro = rubro;
	}

	@Override
	public boolean estaDisponible(Dias dia, int hora, String x) {
		return rubro.getHorario().estaEnHorarioDeAtencion(dia, hora);
	}

	public int getRadioCercania() {
		return rubro.tuRadioDeCercania();
	}

	@Override
	public boolean coincidencia(String x) {
		return rubro.getNombre().indexOf(x) != -1;
	}

}
