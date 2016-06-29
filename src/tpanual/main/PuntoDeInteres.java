package tpanual.main;


import javax.swing.JOptionPane;

public class PuntoDeInteres {
	double latitud;
	double longitud;
	String nombre;
	String direccion;
	TipoPuntoInteres tipo;
	
	
	public PuntoDeInteres(double latitud, double longitud, String nombre, String direccion) {
		// TODO Auto-generated constructor stub
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoPuntoInteres getTipo() {
		return tipo;
	}

	public void setTipo(TipoPuntoInteres tipo) {
		this.tipo = tipo;
	}

	
	public String coordenadas(){
		return this.latitud + "," + this.longitud;
	}
	
	//Si usamos primitivas no es necesario validar, haces un constructor que reciba como parametro las coordenadas y sabes que siempre va a haber un valor, a lo sumo un 0
	public boolean sosValido() {
			
		//if ((!this.latitud.isNaN()) && (!this.longitud.isNaN()) ) {
		//}
		//return (this.nombre != null && this.latitud != null && this.longitud != null);
		//return ((!this.latitud.isNaN()) && (!this.longitud.isNaN()) && this.nombre != null);//(!this.nombre.isEmpty()));
		return true;
	}

	public Boolean cercanoA(int metros,PuntoDeInteres otroPoi){
		Mapa map1 = new Mapa();
		//Double distancia;
		return metros >= (int) (map1.distance(this.getLatitud(),this.getLongitud(),otroPoi.getLatitud(),otroPoi.getLongitud(),"K") * 1000);
	//	return true;
		
	}
}

