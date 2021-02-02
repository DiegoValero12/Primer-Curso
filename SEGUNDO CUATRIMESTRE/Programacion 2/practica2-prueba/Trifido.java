import java.util.ArrayList;

public class Trifido extends Planta{
	private int[] posicion;
	//cuando creamos un NUEVO ZOMBIE hay que crear un nuevo objeto de la clase zombie peroconlos mismos atributos
	//que tenia la persona
	public Trifido(String n_planta, String n_frutos, int num) {
		super(n_planta, n_frutos, num);
		posicion=null;
	}
	
	
	public boolean abona(int abono) {
		boolean ret=false;
		boolean producido=false;
		
		if(this.getPlantada()!=null) {
			if(!(this.getPlantada().getCuidador() instanceof Inmune) && this.getPlantada().getCuidador()!=null) {
				if(this.getEstado().equals("adulta")) {
					//transormar los frutos que ya tenia
					for(int i=0;i<this.getFrutos().length;i++) {
						if(this.getFrutos()[i]!=null) {
							this.getFrutos()[i].transforma(abono);
						}
					}
				}
				else {
					this.setEstado("adulta");
				}
			
			
				Fruto f1=new Fruto(this.getFruto());
				Fruto f2=new Fruto(this.getFruto());
				boolean f11=false, f22=false; //booleanos para saber que se han plantado
				for(int i=0;i<this.getFrutos().length;i++) {
					if(this.getFrutos()[i]==null && f11==false) { //si se puede plantar y no se ha plantado f1
						this.getFrutos()[i]=f1;
						f11=true;
					}
					if(this.getFrutos()[i]==null && f22==false) { //si se puede plantar y no se ha plantado f2
						this.getFrutos()[i]=f2;
						f22=true;
					}
				
				}
				if(!(this.getPlantada().getCuidador() instanceof Zombie)) {
					Zombie zombie = new Zombie(this.getPlantada().getCuidador());
				}
				//creamos el zombie
				//si se tiene que hacer al zombie cuidador de la huerta donde esta plantado el trifido
				//no se si se tiene que hacer un setPlantada en Persona
				
				
				ret=true;
			}
			else {
				for(int i=0;i<this.getFrutos().length;i++) {
					if(this.getFrutos()[i]!=null) {
						producido=true;
					}
				}
				if(producido) {
					for(int i=0;i<this.getFrutos().length;i++) {
						this.getFrutos()[i]=null;
					}
				Huerta huer_actual=null;
				if(this.getPlantada().getLocalizacion()!=null) {//busca la que tenga menos distancia
					Double dist_actual=Double.MAX_VALUE;
					dist_actual=999999999999999999999999999999999999999.0;
					for(int i=0; i<Huerta.getLocalizadas().size();i++) {
						if(dist_actual>this.getPlantada().getLocalizacion().distancia(Huerta.getLocalizadas().get(i).getLocalizacion())&&
								!(this.getPlantada().equals(Huerta.getLocalizadas().get(i)))) {
							dist_actual=this.getPlantada().getLocalizacion().distancia(Huerta.getLocalizadas().get(i).getLocalizacion());
							huer_actual=Huerta.getLocalizadas().get(i);
						}
					}
				}
				if(huer_actual!=null) {
					this.getPlantada().getHuerto()[posicion[0]][posicion[1]]=null;
					this.setPlantada(huer_actual);//que pasa si no encuentra sitio
					for(int i=0;i<huer_actual.getHuerto().length&&!ret;i++) {
						for(int j=0;j<huer_actual.getHuerto()[i].length&&!ret;j++) {
							if(huer_actual.getHuerto()[i][j]==null) {
								huer_actual.getHuerto()[i][j]=this;
								posicion[0]=i;
								posicion[1]=j;
								ret=true;
							}
						}
					}
				}
				}
			}
		}
		
		return ret;
	}
	
	
	public ArrayList<Fruto> recolecta(){
		ArrayList<Fruto> ret=new ArrayList<>();
		boolean salir=false;
		for(int i=0;i<this.getFrutos().length&&salir==false;i++) {
			if(this.getFrutos()[i]!=null) {
				salir=true;
			}
		}
		
		if(salir) {
			if(this.getPlantada()!=null && Huerta.getLocalizadas().contains(this.getPlantada())) { // si la huerta esta localizada
				Huerta huer_actual=null;
				if(this.getPlantada().getLocalizacion()!=null) {//busca la que tenga menos distancia
					Double dist_actual=Double.MAX_VALUE;
					dist_actual=999999999999999999999999999999999999999.0;
					for(int i=0; i<Huerta.getLocalizadas().size();i++) {
						if(dist_actual>this.getPlantada().getLocalizacion().distancia(Huerta.getLocalizadas().get(i).getLocalizacion())&&
								!(this.getPlantada().equals(Huerta.getLocalizadas().get(i)))) {
							dist_actual=this.getPlantada().getLocalizacion().distancia(Huerta.getLocalizadas().get(i).getLocalizacion());
							huer_actual=Huerta.getLocalizadas().get(i);
						}
					}
				}
				if(huer_actual!=null) { // si ha encontrado una huerta localizada
					this.getPlantada().getHuerto()[posicion[0]][posicion[1]]=null;//borra al trifido de la huerta
					this.setPlantada(huer_actual);
					if(this.getPlantada().getHuerto()[0][0]!=null) {//si en 0,0 encuentra algo
						
							for(int i=0;i<this.getPlantada().getHuerto()[0][0].getFrutos().length;i++) {
								if(this.getPlantada().getHuerto()[0][0].getFrutos()[i]!=null) {
									ret.add(this.getPlantada().getHuerto()[0][0].getFrutos()[i]);//mete los frutos
								}
							}
							Fruto aux;
							for(int i=1;i<ret.size();i++) {
								for(int j=ret.size()-1;j>=i;j--) {
									if(ret.get(j-1).getPeso()<ret.get(j).getPeso()) {
										aux=ret.get(j-1);
										ret.set(j-1, ret.get(j));
										ret.set(j, aux);
									}
								}
							}
							//ahora tiene que borrar a la planta y dejar al trifido
							this.getPlantada().getHuerto()[0][0]=this;
							posicion[0]=0;
							posicion[1]=0;
						
						
					}
					else { // si en la posicion 0,0 no encuentra nada
						ret=null;
					}
				}
			}
			else {
				Fruto aux;
				for(int i=0;i<this.getFrutos().length;i++) {
					if(this.getFrutos()[i]!=null) // los arrays que son null no se puede poner un punto para mensaje	
						ret.add(getFrutos()[i]);
						getFrutos()[i]=null;					
				}
				
				for(int i=1;i<ret.size();i++) {
					for(int j=ret.size()-1;j>=i;j--) {
						if(ret.get(j-1).getPeso()>ret.get(j).getPeso()) {
							aux=ret.get(j-1);
							ret.set(j-1, ret.get(j));
							ret.set(j, aux);
						}
					}
				}
			}
		}
		
		return ret;
	}
	
	
	public void arranca() {
		if(this.getPlantada()!=null && this.getPlantada().getCuidador()!=null) {
			if(this.getPlantada().getCuidador() instanceof Inmune) {
				this.getPlantada().getHuerto()[posicion[0]][posicion[1]]=null;
				((Planta)this).setPlantada(null);
				posicion=null;
			}
			else {
				if(!(this.getPlantada().getCuidador() instanceof Zombie)){
					Zombie zombie = new Zombie(this.getPlantada().getCuidador()); //creamos el zombie
					//si se tiene que hacer al zombie cuidador de la huerta donde esta plantado el trifido
				}
			
			}
		}
	}
	
	
	public void setPlantada(Huerta huerta) {
		boolean salir=false;
		
		super.setPlantada(huerta);
		if(huerta!=null) {
			for(int i=0;i<huerta.getHuerto().length && salir==false;i++) {
				for(int j=0;j<huerta.getHuerto()[i].length && salir==false;j++) {
					if(huerta.getHuerto()[i][j]!=null&&huerta.getHuerto()[i][j]==this) {
						posicion=new int[2];
						posicion[0]=i;
						posicion[1]=j;
						salir=true;
					}
				}
			}
		}
	}
	
	
	public boolean otea() {
		boolean ret=false;
		
		if(this.getPlantada()==null) {
			for(int i=0;i<Huerta.getLocalizadas().size();i++) {
				if(Huerta.getLocalizadas().get(i).getCuidador()==null) {
					Huerta huer=Huerta.getLocalizadas().get(i);
					for(int s=0;s<huer.getHuerto().length&&ret==false;s++) {
						for(int j=0;j<huer.getHuerto()[i].length&&ret==false;j++) {
							if(huer.getHuerto()[s][j]==null) {
								huer.getHuerto()[s][j]=this;
								this.setPlantada(huer);
								//posicion[0]=i;
								//posicion[1]=j;
								this.setEstado("adulta");
								ret=true;
							}
						}
					}
				}
			}
		}
		
		return ret;
	}
	
	
	public int abona() {
		int ret=0;
		
		if(this.getPlantada()!=null) {
			
		
			int p1=posicion[0];
			int p2=posicion[1];
		
		
			
		
			if(p1-1>=0&&p1-1<this.getPlantada().getHuerto().length&&p2>=0&&p2<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1-1][p2]!=null) {
				if(!(this.getPlantada().getHuerto()[p1-1][p2] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1-1][p2]=null;
					ret++;
				}
			}
			if(p1-1>=0&&p1-1<this.getPlantada().getHuerto().length&&p2+1>=0&&p2+1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1-1][p2+1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1-1][p2+1] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1-1][p2+1]=null;
					ret++;
				}
			}
			if(p1>=0&&p1<this.getPlantada().getHuerto().length&&p2+1>=0&&p2+1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1][p2+1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1][p2+1] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1][p2+1]=null;
					ret++;
				}
			}
			if(p1+1>=0&&p1+1<this.getPlantada().getHuerto().length&&p2+1>=0&&p2+1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1+1][p2+1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1+1][p2+1] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1+1][p2+1]=null;
					ret++;
				}
			}
			if(p1+1>=0&&p1+1<this.getPlantada().getHuerto().length&&p2>=0&&p2<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1+1][p2]!=null) {
				if(!(this.getPlantada().getHuerto()[p1+1][p2] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1+1][p2]=null;
					ret++;
				}
			}
			if(p1+1>=0&&p1+1<this.getPlantada().getHuerto().length&&p2-1>=0&&p2-1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1+1][p2-1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1+1][p2-1] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1+1][p2-1]=null;
					ret++;
				}
			}
			if(p1>=0&&p1<this.getPlantada().getHuerto().length&&p2-1>=0&&p2-1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1][p2-1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1][p2-1] instanceof Trifido)){
					this.getPlantada().getHuerto()[p1][p2-1]=null;
					ret++;
				}
			}
			if(p1-1>=0&&p1-1<this.getPlantada().getHuerto().length&&p2-1>=0&&p2-1<this.getPlantada().getHuerto()[1].length&&this.getPlantada().getHuerto()[p1-1][p2-1]!=null) {
				if(!(this.getPlantada().getHuerto()[p1-1][p2-1] instanceof Trifido)) {
					this.getPlantada().getHuerto()[p1-1][p2-1]=null;
					ret++;
				}
			}
			
			
			int cont=ret;
		
			if(!this.getEstado().equals("adulta")) {
				this.setEstado("adulta");
				cont--;
			}
		
			
			for(int i=1;i<=cont;i++) {
				boolean salir=false;
				Fruto fruto=new Fruto(this.getFruto());
				for(int j=0;j<this.getFrutos().length&&salir==false;j++) {
					if(this.getFrutos()[j]==null) {
						this.getFrutos()[j]=fruto;
						salir=true;
					}
				}
			}
		}
		return ret;
	}
	
	
	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}


	public int[] getPosicion() {
		return posicion;
	}
	
	
}
