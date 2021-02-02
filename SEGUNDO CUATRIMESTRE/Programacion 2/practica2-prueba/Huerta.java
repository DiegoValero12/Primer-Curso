import java.util.ArrayList;

public class Huerta {
	private Planta[][] huerto;
	private Persona cuidador;
	private Coordenada localizacion;
	private static ArrayList<Huerta> localizadas = new ArrayList<>();
	
	public Huerta(int filas, int columnas) {
		if (filas>0 && columnas>0) 
			this.huerto=new Planta[filas][columnas];
		else {
			if (filas<=0 && columnas>0)
				this.huerto=new Planta[2][columnas];
			if (filas>0 && columnas<=0)
				this.huerto=new Planta[filas][2];
			if (filas<=0 && columnas<=0)
				this.huerto=new Planta[2][2];
		}
		cuidador=null;
		localizacion=null;
	}
	
	public boolean planta(Planta planta) {
		boolean ret=false, repetido=false, plantada=false;
		if(planta!=null) {
			if(planta.getPlantada()==null && planta.getEstado().equals("semilla")) { 
				for(int i=huerto.length-1;i>=0&&plantada==false;i--) { // empezamos los iteradores en length-1 hasta 0 para ocupar todo el rango del vector
					repetido=false;
					for(int j=huerto[i].length-1;j>=0 && repetido==false && plantada==false;j--) { //si encuentra un nombre igual, salta a la siguiente fila 
						for(int s=0;s<huerto[i].length;s++) {										
							
							if(huerto[i][s]!=null) {
								if(!huerto[i][s].getNombre().equals(planta.getNombre())) {
									repetido=true;
								}	
							}
						}
						if(repetido==false && huerto[i][j]==null) {
							huerto[i][j]=planta;
							planta.setPlantada(this);
							ret=true;
							plantada=true;
						}
					}
					
				}
			}
		
		}
		return ret;
	}
	
	public ArrayList<Fruto> recolecta(String cadena){
		ArrayList<Fruto> frutos=new ArrayList<>();
		ArrayList<Fruto> aux=new ArrayList<>();
		
		for(int i=0;i<huerto.length;i++) {
			for(int j=0;j<huerto[i].length;j++) {
				if(huerto[i][j]!=null) {
					if(huerto[i][j].getFruto().equalsIgnoreCase(cadena)) {
						aux=huerto[i][j].recolecta();
						for(int s=0;s<aux.size();s++) {
							frutos.add(aux.get(s));
						}
					} 
				}
			}
		}
		
		return frutos;
	}
	
	public int abona (int abono, String cadena) {
		int cantidad=0;
		if(abono>0 && cadena!=null) {
			for(int i=0;i<huerto.length;i++) {
				for(int j=0; j<huerto[i].length;j++) {
					if(huerto[i][j]!=null) {
						if(huerto[i][j].getNombre().equalsIgnoreCase(cadena)) {
							if(huerto[i][j].abona(abono)) {
								cantidad+=1;
							}
						}
					}
				}
			}
		}
		return cantidad;
	}
	
	public String consulta(int f, int c) {
		String ret=null;
		for(int i=0;i<huerto.length;i++) {
			for(int j=0;j<huerto[i].length;j++) {
				if(huerto[i][j]!=null && f==i && c==j) {
					ret=new String(huerto[i][j].getNombre());
				}
			}
		}
		return ret;
	}
	
	public Planta arranca(String cadena, int f, int  c) {		
		Planta ret=null;
		for(int i=0;i<huerto.length;i++) {
			for(int j=0;j<huerto[i].length;j++) {
				if(huerto[i][j]!=null && f==i && c==j) {
					if(huerto[i][j].getNombre().equalsIgnoreCase(cadena)) {
						if(this.getCuidador() instanceof Zombie) {
							if(!(huerto[i][j] instanceof Trifido)) {
								ret=huerto[i][j];
								huerto[i][j].arranca();
								huerto[i][j]=null;
							}
						}
						else {
							ret=huerto[i][j];
							huerto[i][j].arranca();
							huerto[i][j]=null;
						}
					}
				}
			}
		}
		return ret;
	}
	
	public void localiza(double lat, double lon) {
		if(localizacion==null) {
			localizacion=new Coordenada(lat, lon);
			Huerta.localizadas.add(this);
		}
	}
	
	public ArrayList<String> getAdultas (){
		ArrayList<String> adultas=new ArrayList<>();
		int repetido=0;
		for(int i=0;i<huerto.length;i++) {
			for(int j=0;j<huerto[i].length;j++) {
				if(huerto[i][j]!=null) {
					if(huerto[i][j].getEstado().equalsIgnoreCase("adulta")) {
						if(adultas.isEmpty()) {
							adultas.add(huerto[i][j].getNombre());
						}
						else {
							for(int s=0;s<adultas.size();s++) {
								if(adultas.get(s).equalsIgnoreCase(huerto[i][j].getNombre())) {
									repetido=1;
								}
							}
							if(repetido==0) {
								adultas.add(huerto[i][j].getNombre());
							}
							repetido=0;
						}
					}
				}
			}
		}
		
		return adultas;
	}
	
	public Coordenada getLocalizacion() {
		return localizacion;
	}
	
	public static ArrayList<Huerta> getLocalizadas(){
		return localizadas;
	}
	
	public Persona getCuidador() {
		return cuidador;
	}
	
	public void setCuidador(Persona cuidador) {
		this.cuidador=cuidador;
	}
	
	public Planta[][] getHuerto(){
		return huerto;
	}

	public void setHuerto(Planta[][] huerto) {
		this.huerto = huerto;
	}

	public void setLocalizacion(Coordenada localizacion) {
		this.localizacion = localizacion;
	}

	public static void setLocalizadas(ArrayList<Huerta> localizadas) {
		Huerta.localizadas = localizadas;
	}
}
