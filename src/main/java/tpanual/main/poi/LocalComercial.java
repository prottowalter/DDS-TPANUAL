package tpanual.main.poi;

import administrador.Mapa;
import tpanual.Rubro.RubroFW;
import tpanual.main.Dias;
import tpanual.main.HorarioDeAtencion;

public class LocalComercial extends TipoPuntoInteres {

	private RubroFW rubro;
	private HorarioDeAtencion horario = new HorarioDeAtencion();
	
	public LocalComercial(RubroFW rubro){
		this.rubro=rubro;
		for (Dias dia:Dias.values()){ //Agrega el horario de atencion lunes a domingo de 9:00 a 14:00
			horario.addRangoDia(1700, 2030, dia);// y de 17:00 a 20:30
			horario.addRangoDia(900, 1400, dia);
		}
	}
	
	@Override
	public boolean estaDisponible(Dias dia, int hora, String x) {
		return horario.estaEnHorarioDeAtencion(dia, hora);
	}

	public int getRadioCercania() {
		return rubro.getCercania();
	}

	@Override
	public boolean coincidencia(String x) {	
		
		return rubro.getNombre().toUpperCase().indexOf(x.toUpperCase())!=-1;
	}

	@Override
	public boolean cercanoEntre(double latitudPunto, double longitudPunto, double latitudCoordenada,
			double longitudCoordenada, int comunaId) {

		return (this.getRadioCercania()) >= (int) (PuntoDeInteres.distance(latitudPunto,longitudPunto,latitudCoordenada,longitudCoordenada,"K") * 1000);
	}
	public boolean equals(Object o){
		if (!(o instanceof LocalComercial))
			return false;
		LocalComercial lc=(LocalComercial) o;
		return ((rubro!=null && rubro.equals(lc.rubro) || rubro==null && lc.rubro==null) && 
				(horario!=null && horario.equals(lc.horario) || horario==null && lc.horario==null) && super.equals(o));
	}
}
