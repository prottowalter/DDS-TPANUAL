package tpanual.Rubro;

import tpanual.main.HorarioDeAtencion;

public class RubroConcreteFW implements RubroFW{
	private HorarioDeAtencion hda;
	private String nombre;
	private int cercania;

	
	public RubroConcreteFW(HorarioDeAtencion hda, String nombre, int cercania){
		this.hda=hda;
		this.nombre=nombre;
		this.cercania=cercania;
	}
	
	public RubroConcreteFW(String nombre, int cercania){
		this(null, nombre, cercania);
	}	
	
	public String getNombre() {
		return nombre;
	}
	public int getCercania() {
		return cercania;
	}

	public HorarioDeAtencion getHorarioDeAtencion() {
		return hda;
	}
	
	public boolean esIgual(String nombre, HorarioDeAtencion hda, int cercania){
		return (cercania==this.cercania && nombre!=null && nombre.equals(this.nombre) && 
				( hda==null && this.hda==null || hda != null && this.hda!=null && hda.equals(this.hda) )
				);  		
	}
	
}
