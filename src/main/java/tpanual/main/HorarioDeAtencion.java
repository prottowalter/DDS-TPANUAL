package tpanual.main;

import java.util.ArrayList;
import java.util.List;

public class HorarioDeAtencion {
	List<int[]> domingo = new ArrayList<int[]>();
	List<int[]> lunes = new ArrayList<int[]>();
	List<int[]> martes = new ArrayList<int[]>();
	List<int[]> miercoles = new ArrayList<int[]>();
	List<int[]> jueves = new ArrayList<int[]>();
	List<int[]> viernes = new ArrayList<int[]>();
	List<int[]> sabado = new ArrayList<int[]>();
	
	public void addRangoDia(int desde, int hasta,int dia){
		switch(dia){
			case 0:
				domingo.add(0,new int[] {desde,hasta});
				break;
			case 1:
				lunes.add(0,new int[] {desde,hasta});
				break;
			case 2:
				martes.add(0,new int[] {desde,hasta});
				break;
			case 3:
				miercoles.add(0,new int[] {desde,hasta});
				break;
			case 4:
				jueves.add(0,new int[] {desde,hasta});
				break;
			case 5:
				viernes.add(0,new int[] {desde,hasta});
				break;
			case 6:
				sabado.add(0,new int[] {desde,hasta});
				break;
		}
	}
	/**
	 * Implementar correctamente para de true cuando dos horarios de atencion son iguales
	 */
	
	public boolean equals(Object o){
		return false;
	}
}
