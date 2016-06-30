package tpanual.main;

public class Muebleria extends Rubro {
	
	private HorarioDeAtencion horario = new HorarioDeAtencion();
	
	public Muebleria(String nombre) {
		super(nombre);
		for (Dias dia:Dias.values()){ //Agrega el horario de atencion lunes a viernes de 9:00 a 18:00
			if (dia!=Dias.DOMINGO)
				horario.addRangoDia(900, 1800, dia);
		}
	}

	public int tuRadioDeCercania() {
		return 700;
	}

	@Override
	public HorarioDeAtencion getHorario() {
		return horario;
	}
}
