import java.lang.Math;

public class Coordenada {
	private double latitud;
	private double longitud;

	public Coordenada(double latitud, double longitud) {
		if (latitud>=-90.0 && latitud<=90.0)
			this.latitud=latitud; // this hace referencia al atributo y sirve para solventar la ambiguedad
		else
			this.latitud=0;
		if (longitud>=-180.0 && longitud<=180.0)
			this.longitud=longitud; // tambien se podria dar otro nombre a los parametros del metodo
		else
			this.longitud=0;
	}
	
	public boolean iguales(Coordenada coor) {
		boolean igual=false;
		if (coor!=null) {
			if(latitud == coor.latitud && longitud == coor.longitud) {
				igual=true;
			}
		}
		return igual;
	}
	
	public double distancia(Coordenada coor) {
		double distancia=-1, x, y;
		if(coor!=null) {
			x=latitud-coor.latitud;
			y=longitud-coor.longitud;
			distancia=Math.sqrt(Math.pow((x),2)+Math.pow((y), 2));
		}
		return distancia;
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

}
