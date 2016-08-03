package tpanual.Rubro;

public class RubroConcreteFW implements RubroFW{
	private String nombre;
	private int cercania;

	
	public RubroConcreteFW(String nombre, int cercania){
		this.nombre=nombre;
		this.cercania=cercania;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getCercania() {
		return cercania;
	}
	
	public boolean esIgual(String nombre, int cercania){
		return (cercania==this.cercania && 
				(nombre!=null && nombre.equals(this.nombre) || nombre==null));  		
	}
	
	public boolean equals(Object o){
		if (!(o instanceof RubroConcreteFW))
			return false;
		RubroConcreteFW rc=(RubroConcreteFW) o;
		return rc.esIgual(nombre, cercania);
	}
	
}
