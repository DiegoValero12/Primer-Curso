import java.util.ArrayList;

public class Persona {
	private String nombre;
	private Huerta huerta;
	
	public Persona(String cadena) {
		if(cadena!=null && cadena!="") {
			this.nombre=cadena;
		}
		else {
			this.nombre="John Doe";
		}
		this.huerta=null;
	}
	
	public boolean planta(Planta planta, Huerta huerta) {
		boolean ret=false;
		if(planta!=null && huerta!=null) {
			ret=huerta.planta(planta);
		}
		return ret;
	}
	
	public Coordenada paseo() {
		Coordenada ret=null;
		boolean salir=false;
		if(huerta!=null) {
			ret=this.huerta.getLocalizacion();
		}
		if(huerta==null) {
			if(!Huerta.getLocalizadas().isEmpty()) {
				for(int i=0;i<Huerta.getLocalizadas().size()&&salir==false;i++) {
					if(Huerta.getLocalizadas().get(i).getCuidador()==null) {
						this.huerta=Huerta.getLocalizadas().get(i);
						this.huerta.setCuidador(this);
						ret=this.huerta.getLocalizacion();
						salir=true;
					}
				}
			}
		}
		return ret;
	}
	
	public ArrayList<Planta> malasHierbas(){
		ArrayList<Planta> plantas=new ArrayList<>();
		int vacio=0;
		if(huerta!=null) {
			for(int i=0;i<huerta.getHuerto().length;i++) {
				for(int j=0;j<huerta.getHuerto()[i].length;j++) {
					if(huerta.getHuerto()[i][j]!=null) {
						if(huerta.getHuerto()[i][j].getEstado().equals("adulta")) {
							for(int s=0;s<huerta.getHuerto()[i][j].getFrutos().length && vacio==0;s++) {
								if(huerta.getHuerto()[i][j].getFrutos()[s]!=null) {
									vacio=1;
								}
							}
							if(vacio==0) {
								plantas.add(huerta.getHuerto()[i][j]);
								huerta.getHuerto()[i][j].arranca();
								huerta.getHuerto()[i][j]=null;
							}
							vacio=0;
						}
					}
				}
			}
		}
		return plantas;
	}
	
	public int abona(int abono, String cadena) {
		int cantidad=0;
		
		if(cadena!=null && this.huerta!=null)
			cantidad=huerta.abona(abono, cadena);
					
		return cantidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Huerta getHuerta() {
		return this.huerta;
	}
	
	public void setPlantada(Huerta huer) {
		if(huer!=null) {
			this.huerta=huer;
		}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setHuerta(Huerta huerta) {
		this.huerta = huerta;
	}
	
}
