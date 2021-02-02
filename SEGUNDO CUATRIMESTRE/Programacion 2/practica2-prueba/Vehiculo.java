import java.util.ArrayList;

public class Vehiculo {

	private Persona ocupante;
	private boolean[] combustible;
	
	public Vehiculo(int tam) {
		if(tam<2) {
			tam=2;
		}
		combustible=new boolean[tam];
		ocupante=null;
	}
	
	
	public boolean traslada(Coordenada coor) {
		boolean ret=false;
		boolean encontrada=false;
		
		if(ocupante!=null && ocupante.getHuerta()!=null && coor!=null) {
			for(int i=0;i<Huerta.getLocalizadas().size();i++) { // buscamos en las localizadas
				Huerta h=Huerta.getLocalizadas().get(i); // asigno a h la huerta por la que voy
				if(h.getLocalizacion().equals(coor)) {
					encontrada=true; //ha encontrado al menos una huerta
					if(!(h.equals(ocupante.getHuerta()))) {
						int distancia=((int) ocupante.getHuerta().getLocalizacion().distancia(coor));
						if(Huerta.getLocalizadas().get(i).getLocalizacion().distancia(coor)>=0 && 
								this.getNumCombustible()>=distancia) { // comprobamos distancia y combustible
							for(int s=combustible.length-1;s>=0 && distancia>0;s--) {
								if(combustible[s]!=false) { // vamos restando el combustible
									combustible[s]=false;
									distancia--;
								}
							}
							ocupante.getHuerta().setCuidador(null);
							ocupante.setHuerta(h); // ponemos al ocupante la huerta
							ret=true;
						}
					}
				}
				
			}
			if(!encontrada) { //si no se ha encontrado ninguna huerta con las coordenadas en el ArrayList
				ocupante.getHuerta().setLocalizacion(coor); // actualizamos la localizacion de la huerta
				ret=true;
			}
		}
		
		return ret;
	}
	
	public int repostaje(ArrayList<Fruto> frutos) {
		int ret=0;
		double suma=0;
		
		for(int i=0;i<frutos.size();i++) {
			suma=suma+frutos.get(i).valorCalorico();
		}
		
		int total=(int) suma;
		
		
		for(int i=0;i<combustible.length && total>0;i++) {
			if(combustible[i]==false) {
				combustible[i]=true;
				total--;
				ret++;
			}
		}
		
		return ret;
	}
	
	
	public boolean sube(Persona pers) {
		boolean ret=false;
		
		if(ocupante==null && (pers instanceof Inmune)) {	
			if(((Inmune)pers).getVehiculo()==null) {
				ret=((Inmune)pers).apropia(this);
			}
		}
		
		return ret;
	}
	
	
	public boolean baja() {
		boolean ret=false;
		
		if(ocupante!=null) {
			ret=((Inmune)ocupante).abandona();
		}
		
		return ret;
	}
	
	public Persona getOcupante() {
		return ocupante;
	}
	
	public void setOcupante(Inmune p) {
		ocupante=p;
	}
	
	public boolean[] getCombustible() {
		return combustible;
	}
	
	public int getNumCombustible() {
		int ret=0;
		
		for(int i=0;i<combustible.length;i++) {
			if(combustible[i]) {
				ret++;
			}
		}
		
		return ret;
	}
}
