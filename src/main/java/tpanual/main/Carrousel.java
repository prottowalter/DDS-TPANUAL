package tpanual.main;

public class Carrousel extends Rubro {
	
	private HorarioDeAtencion horario = new HorarioDeAtencion();
	
	public Carrousel (){
		for (Dias dia:Dias.values()){ //Agrega el horario de atencion lunes a sabado de 10:00 a 13:00
			if (dia!=Dias.DOMINGO){
				horario.addRangoDia(1700, 2030, dia);// y de 17:00 a 20:30
				horario.addRangoDia(1000, 1300, dia);
			}
		}
	}
	
	public HorarioDeAtencion getHorario(){
		return horario;
	}
	
	public int tuRadioDeCercania() {
		return 200;
	}
}
