package tpanual.main;

public class LibreriaEscolar extends Rubro {
	
	private HorarioDeAtencion horario = new HorarioDeAtencion();
	
	public LibreriaEscolar (){
		for (Dias dia:Dias.values()){ //Agrega el horario de atencion lunes a viernes de 9:00 a 17:00
			if (dia!=Dias.DOMINGO&&dia!=Dias.SABADO)
				horario.addRangoDia(900, 1700, dia);
		}
	}
	
	public int tuRadioDeCercania() {
		return 500;
	}
	
	public HorarioDeAtencion getHorario(){
		return horario;
	}
}