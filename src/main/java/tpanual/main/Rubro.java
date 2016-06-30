package tpanual.main;

public abstract class Rubro {
	protected String nombre;
	
	public Rubro(String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	abstract public int tuRadioDeCercania();
	
	abstract public HorarioDeAtencion getHorario();
}
