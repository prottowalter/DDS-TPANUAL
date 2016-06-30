package tpanual.main;

public abstract class Rubro {
	protected String nombre;
	
	public String getNombre() {
		return nombre;
	}

	abstract public int tuRadioDeCercania();
	
	abstract public HorarioDeAtencion getHorario();
}
