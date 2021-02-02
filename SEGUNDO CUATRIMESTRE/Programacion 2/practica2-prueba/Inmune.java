import java.util.*;

public class Inmune extends Persona{

	private Vehiculo vehiculo;
	
	public Inmune(String n) {
		super(n);
	}
	
	public boolean planta(Planta planta, Huerta huerta) {
		boolean ret=false;
		
		if(planta instanceof Trifido) {
			Planta p_nueva= new Planta(planta.getNombre(), planta.getFruto(), planta.getFrutos().length);
			p_nueva.setEstado(planta.getEstado());
			p_nueva.setFrutos(planta.getFrutos());
			p_nueva.setPlantada(planta.getPlantada());
			
			if(huerta.planta(p_nueva)) {
				ret=true;
			}
		}
		else {
			if(huerta.planta(planta)) {
				ret=true;
			}
		}
		
		return ret;
	}

	
	public ArrayList<Planta> malasHierbas(){
		ArrayList<Planta> ret=new ArrayList<>();
		
		if(this.getHuerta()!=null) {
			Planta[][] h=this.getHuerta().getHuerto();
		
			for(int i=0;i<h.length;i++) {
				for(int j=0;j<h[i].length;j++) {
					if(h[i][j]!=null && h[i][j] instanceof Trifido) {
						ret.add(h[i][j]);
						h[i][j].arranca();
						h[i][j]=null;
					}
				}
			}
		}
		
		return ret;
	}
	
	
	public int abona(int abono, String cadena) {
		int cont=0;
		Planta[][] h=this.getHuerta().getHuerto();
		
		if(abono>0) {
			for(int i=0;i<h.length;i++) {
				for(int j=0;j<h[i].length;j++) {
					if(h[i][j]!=null && h[i][j].getFruto().equals(cadena)) {
						if(h[i][j].abona(abono)) {
							cont++;
						}
					}
				}
			}
		}
		
		return cont;
	}
	
	
	public boolean apropia(Vehiculo coche) {
		boolean ret=false;
		
		if(this.vehiculo==null && coche.getOcupante()==null) {
			vehiculo=coche;
			coche.setOcupante(this);
			ret=true;
		}
		
		return ret;
	}
	
	
	public boolean abandona() {
		boolean ret=false;
		
		if(vehiculo!=null) {
			vehiculo.setOcupante(null);
			vehiculo=null;
			ret=true;
		}
		
		return ret;
	}
	
	public ArrayList<String> repostaje(){
		ArrayList<String> ret= new ArrayList<>();
		
		if(this.getHuerta()!=null) {
			for(int i=0;i<getHuerta().getHuerto().length;i++) {
				for(int j=0;j<this.getHuerta().getHuerto()[i].length;j++) {
					if(this.getHuerta().getHuerto()[i][j]!=null) {
						
						ArrayList<Fruto> aux=this.getHuerta().getHuerto()[i][j].recolecta();
						
						for(int s=0;s<aux.size();s++) {
							ret.add(aux.get(i).getNombre());
						}
					}
				}
			}
		}
		
		Collections.sort(ret); // con la clase Collections y el metodo sort, se te ordena el array 
		
		return ret;
	}
	
	
	public int paseo(Coordenada coor) { // ESTA SIN HACER, HAY QUE HACERLO
		int ret=0;
		// Tienes que hacer traslada de vehiculo a todas las huertas localizadas consumiendo combustible y luego, volviendo a la
		// huerta inicial sin gastar combustible
		Huerta inicial=this.getHuerta();
		if(coor!=null && vehiculo!=null) {
			for(int i=0;i<Huerta.getLocalizadas().size();i++) {
				if(Huerta.getLocalizadas().get(i).getLocalizacion().equals(coor)) {
					if(this.getVehiculo().traslada(coor)) {
						ArrayList<Planta> aux=this.malasHierbas();
						ret=ret+aux.size();
						if(this.getHuerta().getCuidador()!=null && this.getHuerta().getCuidador() instanceof Zombie) {
							this.getHuerta().setCuidador(null);
						}
					}
				}
			}
			this.setHuerta(inicial);
		}
		
		return ret;
	}
	
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo v) {
		vehiculo=v;
	}
	
}