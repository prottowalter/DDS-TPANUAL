package tpanual.main;

public class Kiosko extends Rubro {

	private HorarioDeAtencion horario = new HorarioDeAtencion();
	
	public Kiosko (){
		for (Dias dia:Dias.values()){ //Agrega el horario de atencion lunes a domingo de 9:00 a 14:00
			horario.addRangoDia(1700, 2030, dia);// y de 17:00 a 20:30
			horario.addRangoDia(900, 1400, dia);
		}
	}
	
	public int tuRadioDeCercania() {
		return 200;
	}
	
	public HorarioDeAtencion getHorario(){
		return horario;
	}
}
