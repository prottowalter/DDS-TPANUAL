package tpanual.main;


public class PuntoDeInteres {
	double latitud;
	double longitud;
	String nombre;
	Direccion direccion;
	TipoPuntoInteres tipo;
	
	public PuntoDeInteres(double latitud, double longitud, String nombre, Direccion direccion, TipoPuntoInteres tipo) {
		this.latitud=latitud;
		this.longitud=longitud;
		this.nombre=nombre;
		this.direccion=direccion;
		this.tipo=tipo;
	}

	public double getLatitud() {
		return latitud;
	}


	public double getLongitud() {
		return longitud;
	}

	public String getNombre() {
		return nombre;
	}


	public Direccion getDireccion() {
		return direccion;
	}

	public TipoPuntoInteres getTipo() {
		return tipo;
	}

	
	public String coordenadas(){
		return this.latitud + "," + this.longitud;
	}
	

	public boolean cercanoA(int metros, PuntoDeInteres otroPoi){
		Mapa map1 = new Mapa();
		//Double distancia;
		return metros >= (int) (map1.distance(this.getLatitud(),this.getLongitud(),otroPoi.getLatitud(),otroPoi.getLongitud(),"K") * 1000);
	//	return true;
		
	}
	
	
}

