import java.util.ArrayList;

public class Planta {
	private String estado;
	private String nombre;
	private String fruto;
	private Huerta plantada;
	private Fruto[] frutos;
	
	public Planta(String nombre, String nombre_fruto, int num_frutos) {
		if(nombre==null || nombre.equals("")) {
			this.nombre="vegetal";
		}
		else {
			this.nombre=nombre;
		}
		if(nombre_fruto==null || nombre_fruto.equals("")) {
			this.fruto="pitaya";
		}
		else {
			this.fruto=nombre_fruto;
		}
		if(num_frutos<1) {
			frutos=new Fruto[1];
		}
		else {
			frutos=new Fruto[num_frutos];
		}
		this.estado="semilla";
		this.plantada=null;
	}
	
	public boolean abona(int abono) {
		boolean ret=false;
		if(plantada!=null) {
			if(estado.equals("semilla")) {
				estado="germinado"; // cambio de semilla a germinado
				ret=true;
			}
			else {
				if(estado.equals("germinado")) {
					estado="brote"; // cambio de germinado a brote
					ret=true;
				}
				else {
					if(estado.equals("brote")) {
						estado="adulta"; // cambio de brote a adulta
						ret=true;
					}
					else {
						if(estado.equals("adulta")) {
							Fruto fruto=new Fruto(this.fruto); // crea el objeto fruto
							boolean salir=false;
							int pos=frutos.length+1;
							for(int i=0;i<frutos.length && salir==false;i++) { // recorre para ver donde puede meter fruto
								if(frutos[i]==null) {
									frutos[i]=fruto;
									ret=true;
									salir=true;
									pos=i;
								}
							}
							for(int i=0;i<frutos.length;i++) {
								if(frutos[i]!=null&&i!=pos) // comprobamos que no se tranforma el fruto que se acaba de meter
									if(frutos[i].transforma(abono)) { // si esto se cumple, el fruto ha pasado a 
										ret=true; 						// comestible
									}
								if(frutos[i]!=null&&i!=pos)
									if(frutos[i].getPeso()>abono) { // cosa a comprobar, no se si es abono
										frutos[i]=null;
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
	
	public ArrayList<Fruto> recolecta() {
		ArrayList<Fruto> ret=new ArrayList<>();
		Fruto aux;
		for(int i=0;i<frutos.length;i++) {
			if(frutos[i]!=null) // los arrays que son null no se puede poner un punto para mensaje
				if(frutos[i].getEstado().equals("comestible")) {
					ret.add(frutos[i]);
					frutos[i]=null;
				}
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

		return ret;
	}
	
	public void arranca() {
		this.plantada=null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public Huerta getPlantada() {
		return plantada;
	}
	
	public void setPlantada(Huerta huerta) {
		this.plantada=huerta;
	}
	
	public Fruto[] getFrutos() {
		return frutos;
	}
	
	public String getFruto() {
		return fruto;
	}
	
	protected void setEstado(String cadena) {
		this.estado=cadena;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFruto(String fruto) {
		this.fruto = fruto;
	}


	protected void setHuerta(Huerta huerta) {
		this.plantada=huerta;
	}

	public void setFrutos(Fruto[] frutos) {
		this.frutos = frutos;
	}
}
