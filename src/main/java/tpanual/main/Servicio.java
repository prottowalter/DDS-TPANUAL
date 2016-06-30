package tpanual.main;

public class Servicio {
	private String nombre;
	private HorarioDeAtencion horario;
	
	public Servicio(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public HorarioDeAtencion getHorario(){
		return horario;
	}
	
	public void setHorario(HorarioDeAtencion horario){
		this.horario = horario;
	}
}

