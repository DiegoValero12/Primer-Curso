import java.util.*;

public class Zombie extends Persona{
	
	public Zombie(Persona pers) {
		super(pers.getNombre());
		this.setHuerta(pers.getHuerta());
		if(this.getHuerta()!=null)
			this.getHuerta().setCuidador(this);
		pers.setHuerta(null);
		
	}
	
	public boolean planta(Planta planta, Huerta huerta) {
		boolean ret=false;
		
		if(planta!=null && huerta!=null && this.getHuerta().equals(huerta)) {
			if(planta instanceof Trifido) {
				ret=super.planta(planta, huerta);
			}
			else {
				Trifido trif=new Trifido(planta.getNombre(), planta.getFruto(), planta.getFrutos().length);
				trif.setEstado(planta.getEstado());
				trif.setFrutos(planta.getFrutos());
				trif.setPlantada(planta.getPlantada());
				
				ret=super.planta(trif, huerta);
					
			}
		}
		
		return ret;
	}
	
	
	public Coordenada paseo() {
		Coordenada ret=null;
		
		if(this.getHuerta()!=null) {
			ret=this.getHuerta().getLocalizacion();
		}
		
		return ret;
	}
	
	
	public ArrayList<Planta> malasHierbas(){
		ArrayList<Planta> ret=new ArrayList<>();
		
		if(this.getHuerta()!=null) {
			for(int i=0;i<this.getHuerta().getHuerto().length;i++) {
				for(int j=0;j<this.getHuerta().getHuerto()[i].length;j++) {
					Planta p=this.getHuerta().getHuerto()[i][j];
					if(p!=null && p.getEstado().equals("adulta") && !(p instanceof Trifido)) {
						ret.add(p);
						this.getHuerta().getHuerto()[i][j]=null;
						p.arranca();
						p=null;
					}
				}
			}
		}
		
		return ret;
	}
	
	public int abona(int abono, String cadena) {
		int ret=0;
		
		if(this.getHuerta()!=null) {
			for(int i=0;i<this.getHuerta().getHuerto().length;i++) {
				for(int j=0;j<this.getHuerta().getHuerto()[i].length;j++) {
					Planta p=this.getHuerta().getHuerto()[i][j];
					if(p!=null && p instanceof Trifido) {
						if(((Trifido)p).abona(abono)) {
							ret++;
						}
					}
				}
			}
		}
		
		return ret;
	}
	
	
	public int abona() {
		int ret=0;
		
		if(this.getHuerta()!=null) {
			for(int i=0;i<this.getHuerta().getHuerto().length;i++) {
				for(int j=0;j<this.getHuerta().getHuerto()[i].length;j++) {
					Planta p=this.getHuerta().getHuerto()[i][j];
					if(p!=null && p instanceof Trifido) {
						ret=ret+((Trifido)p).abona();
					}
				}
			}
		}
		
		return ret;
	}
	
	
	
}
