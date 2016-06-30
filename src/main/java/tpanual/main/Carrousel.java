package tpanual.main;

public class Carrousel extends Rubro {
	
	HorarioDeAtencion horas = new HorarioDeAtencion();
	
	public Carrousel (String a){
		super(a);
		for (int i=1;i<7;i++){ //Agrega el horario de atencion lunes a sabado de 10:00 a 13:00
			horas.addRangoDia(1700, 2030, i);// y de 17:00 a 20:30
			horas.addRangoDia(1000, 1300, i);
		}
	}
	
	public int tuRadioDeCercania() {
		return 200;
	}
}
