package tpanual.Rubro;

import tpanual.main.HorarioDeAtencion;

public interface RubroFW {
	public HorarioDeAtencion getHorarioDeAtencion();
	public int getCercania();
	public String getNombre();
	public boolean esIgual(String nombre, HorarioDeAtencion hda, int cercania);
}
