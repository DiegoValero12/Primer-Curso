import java.util.ArrayList;

public class Valores {
	private static class Relacion{
		// implementacion de la clase relacion
		private String nombre;
		private double valor;
		
		// constructor de relacion
		public Relacion(String nombre, double valor) {
			if (valor>0) {
				this.valor=valor;
			}
			else {
				this.valor=0.5;
			}
			if (nombre!=null && nombre.equals("")==false) {
				this.nombre=nombre;
			}
			else {
				this.nombre="pitaya";
			}
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}
		
	}
	
	// construccion del arraylist de clasificacion
	private static ArrayList<Relacion> clasificacion = new ArrayList<>();
	
	// resto de los metodos de la clase Valores 
	
	public static boolean add(String cadena, double numero) {
		boolean ret=false;
		int repetido=0;	
		Relacion relacion = new Relacion(cadena, numero);
		if(clasificacion.isEmpty()) { // si el arraylist esta vacio, siempre se va a meter la relacion porque no va a haber nunca una igual
			clasificacion.add(relacion);
			ret=true;
		}
		else {
			for(int i=0;i<clasificacion.size() && ret==false;i++) {
				if(clasificacion.get(i).nombre!=null && clasificacion.get(i).nombre.equalsIgnoreCase(relacion.nombre)) {
					repetido=1;
				}
			}
			if(repetido!=1) {
				clasificacion.add(relacion);
				ret=true;
			}
		repetido=0;
		}	
		return ret;
	}
	
	public static double consulta(String cadena) {
		double numero=-1;
		for(int i=0;i<clasificacion.size() && numero==-1;i++) {
			if(clasificacion.get(i).nombre.equalsIgnoreCase(cadena)) {
				numero=clasificacion.get(i).valor;
			}
		}
		return numero;
	}
	
	public static ArrayList<String> getNombres(){
		ArrayList<String> nombres = new ArrayList<>();
		if(!clasificacion.isEmpty()) {
			for(int i=0;i<clasificacion.size();i++) {
				nombres.add(clasificacion.get(i).nombre);
			}
		}
		
		return nombres;
	}
	
	public static ArrayList<Relacion> getClasificacion() {
		return clasificacion;
	}
	
	public static ArrayList<Double> getValores(){
		ArrayList<Double> valores = new ArrayList<>();
		if(!clasificacion.isEmpty()) {
			for(int i=0;i<clasificacion.size();i++) {
				valores.add(clasificacion.get(i).valor);
			}
		}
		return valores;
	}
}// cierre de la clase Valores
