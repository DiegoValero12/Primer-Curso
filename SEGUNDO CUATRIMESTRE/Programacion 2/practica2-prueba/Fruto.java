public class Fruto {
	private boolean estado;
	private double peso;
	private String nombre;
	
	public Fruto(String nombre) {
		int repetido=0;
		int pitaya=0;
		if(nombre==null ||  nombre.equals("")) {
			nombre="pitaya";
		}
		if(Valores.getNombres().isEmpty()) {
			Valores.add("pitaya", 0);
			this.nombre="pitaya";
		}
		else {
			for(int i=0;i<Valores.getNombres().size() && repetido==0;i++) {
				if(nombre.equals(Valores.getNombres().get(i))) {
					repetido=1;
				}
			}
			
			for(int i=0;i<Valores.getNombres().size() && pitaya==0;i++) {
				if(Valores.getNombres().get(i).equals("pitaya")) {
					pitaya=1;
				}
			}
			
			if(repetido==0) {
				if(pitaya==0)
					Valores.add("pitaya", 0);
					this.nombre="pitaya";
			}
			else {
				this.nombre=nombre;
			}
		}
		
		this.peso=0;
		this.estado=false;
	}
	
	public boolean transforma(int num) {
		boolean ret=false, inicio;
		
		inicio=this.estado;
		if(num>0) {
			this.peso=this.peso+(num*0.2);
		}
		if(this.peso>=0.3) {
			this.estado=true;
		}
		if(inicio!=this.estado) {
			ret=true;
		}
		return ret;
	}
	
	public double valorCalorico() {
		double valorCalorico=0;
		valorCalorico=this.peso*Valores.consulta(this.nombre);
		return valorCalorico;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getEstado() {
		if(this.estado==true) {
			return "comestible";
		}
		else {
			return "inmaduro";
		}
	}
	
	public double getPeso() {
		return peso;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
