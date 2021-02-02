/*
 * Se crea una huerta y varias plantas. Se invoca el método planta de la huerta
con las plantas. Se invoca abona de la huerta con las distintas plantas. Se invoca arranca de la huerta con distintos valores. Se invoca abona de las plantas
arrancadas. Se muestra por pantalla el resultado de cada acción.
 */
public class P09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomplanta="manzano";
		String nomfruto="manzana";
		int valor=4;
		
		Valores.add("nuez", 1);
		Valores.add("pera", 0.5);
		Valores.add("manzana", 2);
		
		Huerta huerto=new Huerta(3,6);
		Planta planta1=new Planta(nomplanta, nomfruto, valor);
		Planta planta2=new Planta("nogal", "nuez", 3);
		Planta planta3=new Planta("peral", "pera", 2);
		Planta planta4=new Planta("peral", "pera", 2);
		Planta planta5=new Planta("nogal", "nuez", 3);
		
		System.out.println("Plantada: "+huerto.planta(planta1));
		System.out.println("Plantada: "+huerto.planta(planta2));
		System.out.println("Plantada: "+huerto.planta(planta3));
		System.out.println("Plantada: "+huerto.planta(planta4));
		System.out.println("Plantada: "+huerto.planta(planta5));
		
		for(int i=0;i<huerto.getHuerto().length;i++) {
			System.out.print("\n[ "+i+" ] :");
			for(int j=0;j<huerto.getHuerto()[i].length;j++) {
				if(huerto.getHuerto()[i][j]!=null) {
					System.out.print(" "+huerto.getHuerto()[i][j].getNombre());
				}
				else
					System.out.print(" null");
			}
			System.out.println(" ");
		}
		//abonar
		while(huerto.getHuerto()[1][5].getEstado().equals("adulta")==false) {
			System.out.println("Abona nogal: "+huerto.abona(3, "nogal"));
			System.out.println("Abona nogal: "+huerto.abona(3, "nogal"));
		}
		
		while(huerto.getHuerto()[0][5].getFrutos()[1]==null) {
			System.out.println("Abona peral: "+huerto.abona(3, "peral"));
			System.out.println("Abona peral: "+huerto.abona(3, "peral"));
			System.out.println("Abona manzano: "+huerto.abona(1, "manzano"));
			System.out.println("Abona manzano: "+huerto.abona(2, "manzano"));
		}
		//arrancar con diferentes valores
		Planta arrancada1, arrancada2, arrancada3, arrancada4;
		arrancada1=huerto.arranca("nogal", 1, 2);
		arrancada2=huerto.arranca("nogal", 0, 5);
		arrancada3=huerto.arranca("nogal", 1, 5);
		arrancada4=huerto.arranca("nogal", 1, 4);
		
		if(arrancada1!=null) {
			System.out.println("Planta arrancada1: "+arrancada1.getNombre());
		}
		else
			System.out.println("Planta arrancada1: null");
		if(arrancada2!=null) {
			System.out.println("Planta arrancada2: "+arrancada2.getNombre());
		}
		else
			System.out.println("Planta arrancada2: null");
		if(arrancada3!=null) {
			System.out.println("Planta arrancada3: "+arrancada3.getNombre());	
		}
		else
			System.out.println("Planta arrancada3: null");
		if(arrancada4!=null) {
			System.out.println("Planta arrancada4: "+arrancada4.getNombre());
		}
		else
			System.out.println("Planta arrancada4: null");
		
		//abona plantas arrancadas
		if(arrancada1!=null) {
			System.out.println("Abonar arrancada1: "+arrancada1.abona(3));
		}
		else
			System.out.println("Abonar arrancada1: null");
		if(arrancada2!=null) {
			System.out.println("Abonar arrancada2: "+arrancada2.abona(3));
		}
		else
			System.out.println("Abonar arrancada2: null");
		if(arrancada3!=null) {
			System.out.println("Abonar arrancada3: "+arrancada3.abona(3));
		}
		else
			System.out.println("Abonar arrancada3: null");
		if(arrancada4!=null) {
			System.out.println("Abonar arrancada4: "+arrancada4.abona(3));
		}
		else
			System.out.println("Abonar arrancada4: null");
	}

}
