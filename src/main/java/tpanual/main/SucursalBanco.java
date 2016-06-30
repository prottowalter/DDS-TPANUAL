package tpanual.main;

public class SucursalBanco extends TipoPuntoInteres {

	HorarioDeAtencion horario = new HorarioDeAtencion();

	public SucursalBanco() {
		for (Dias dia : Dias.values()) { // Agrega el horario de atencion lunes a viernes de 10:00 a 15:00
			if (dia != Dias.DOMINGO && dia != Dias.SABADO)
				horario.addRangoDia(1000, 1500, dia);
		}
	}

	@Override
	public int getRadioCercania() {
		return 500;
	}

	@Override
	public boolean estaDisponible(Dias dia, int hora, String x) {
		return horario.estaEnHorarioDeAtencion(dia, hora);
	}

	@Override
	public boolean coincidencia(String x) {
		return false;
	}

}
