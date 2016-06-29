package tpanual.main;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuntoDeInteres punto1 =  new PuntoDeInteres();
		punto1.latitud = -34.61460;
		punto1.longitud = -58.368552;
		punto1.setDireccion("Paseo Colón,746"); 
		punto1.setTipo(new CGP());
		punto1.tipo.setHorario("09:00 a 18:00");
		punto1.setNombre("Comuna 12");
		//otro punto
		PuntoDeInteres punto2 =  new PuntoDeInteres();
		punto2.latitud = -34.615717;
		punto2.longitud = -58.368421;
		punto2.setDireccion("Paseo Colón,746"); 
		punto2.setTipo(new CGP());
		punto2.tipo.setHorario("09:00 a 18:00");
		punto2.setNombre("Comuna 13");
		//Mapa map1 = new Mapa();
		//muestra por consola
		System.out.println (punto1.coordenadas());
		//System.out.println (map1.distance(punto1.getLatitud(),punto1.getLongitud(),punto2.getLatitud(),punto2.getLongitud(),"K"));
		//System.out.println (punto1.getDireccion());
		//System.out.println (punto1.tipo.getHorario());
		//System.out.println (punto1.getNombre());
		//muestra por ventana
		//JOptionPane.showMessageDialog(null, punto1.coordenadas());
		//JOptionPane.showMessageDialog(null, punto1.cercanoA(130,punto2));
		
		//otro punto
		PuntoDeInteres punto3 = new PuntoDeInteres();
		punto3.latitud = -34.615482;//-34.612984;//-34.615130;
		punto3.longitud = -58.369029;//-58.369196;//-58.369024;
		punto3.setDireccion("Paseo Colón,646"); 
		punto3.setTipo(new ParadaColectivo());
		//punto3.tipo.setCercania(cercania);
		punto3.setNombre("Comuna 13");
		
		
		System.out.println (punto3.sosValido());
		System.out.println (punto2.sosValido());
		System.out.println (punto2.cercanoA(punto3.tipo.getRadioCercania(), punto3));
		
	}
}
