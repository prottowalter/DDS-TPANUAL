package tpanual.main;

import java.util.ArrayList;
import java.util.List;

public class HorarioDeAtencion {
	List<int[]> lunes = new ArrayList<int[]>();
	List<int[]> martes = new ArrayList<int[]>();
	List<int[]> miercoles = new ArrayList<int[]>();
	List<int[]> jueves = new ArrayList<int[]>();
	List<int[]> viernes = new ArrayList<int[]>();
	List<int[]> sabado = new ArrayList<int[]>();
	List<int[]> domingo = new ArrayList<int[]>();

	public void addRangoDia(int desde, int hasta, Dias dia) {
		switch (dia) {
		case LUNES:
			lunes.add(0, new int[] { desde, hasta });
			break;
		case MARTES:
			martes.add(0, new int[] { desde, hasta });
			break;
		case MIERCOLES:
			miercoles.add(0, new int[] { desde, hasta });
			break;
		case JUEVES:
			jueves.add(0, new int[] { desde, hasta });
			break;
		case VIERNES:
			viernes.add(0, new int[] { desde, hasta });
			break;
		case SABADO:
			sabado.add(0, new int[] { desde, hasta });
			break;
		case DOMINGO:
			domingo.add(0, new int[] { desde, hasta });
			break;
		}
	}

	public boolean estaEnHorarioDeAtencion(Dias dia, int hora) {
		switch (dia) {
		case LUNES:
			return estaEnRangoHorario(lunes,hora);
		case MARTES:
			return estaEnRangoHorario(martes,hora);
		case MIERCOLES:
			return estaEnRangoHorario(miercoles,hora);
		case JUEVES:
			return estaEnRangoHorario(jueves,hora);
		case VIERNES:
			return estaEnRangoHorario(viernes,hora);
		case SABADO:
			return estaEnRangoHorario(sabado,hora);
		case DOMINGO:
			return estaEnRangoHorario(domingo,hora);
		default:
			return false;
		}
	}
	
	public boolean estaEnRangoHorario (List<int[]> dia, int hora){
		for (int[] horas:dia){
			if (horas[0]<=hora&&hora<horas[1])
				return true;
		}
		return false;
	}
}
