import java.util.ArrayList;

/*
 * Se crea una huerta y varias plantas. Se invoca el método planta de la huerta con
las plantas. Se invoca abona de la huerta con las distintas plantas. Se invoca
recolecta de la huerta. Se muestra por pantalla el resultado de cada acción.
 */
public class P08 {

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
		
		while(huerto.getHuerto()[0][5].getFrutos()[1]==null) {
			System.out.println("Abona nogal: "+huerto.abona(2, "nogal"));
			System.out.println("Abona nogal: "+huerto.abona(2, "nogal"));
			System.out.println("Abona peral: "+huerto.abona(3, "peral"));
			System.out.println("Abona peral: "+huerto.abona(3, "peral"));
			System.out.println("Abona manzano: "+huerto.abona(1, "manzano"));
			System.out.println("Abona manzano: "+huerto.abona(2, "manzano"));
		}
		
		ArrayList<Fruto> recogidos1=new ArrayList<Fruto>();
		ArrayList<Fruto> recogidos2=new ArrayList<Fruto>();
		ArrayList<Fruto> recogidos3=new ArrayList<Fruto>();
		recogidos1=huerto.recolecta("pera");
		for(int i=0;i<recogidos1.size();i++) {
			System.out.println("Fruto: "+recogidos1.get(i).getNombre()+" Estado: "+recogidos1.get(i).getEstado()+" Peso: "+recogidos1.get(i).getPeso());
		}
		recogidos2=huerto.recolecta("nuez");
		for(int i=0;i<recogidos2.size();i++) {
			System.out.println("Fruto: "+recogidos2.get(i).getNombre()+" Estado: "+recogidos2.get(i).getEstado()+" Peso: "+recogidos2.get(i).getPeso());
		}
		recogidos3=huerto.recolecta("manzana");
		for(int i=0;i<recogidos3.size();i++) {
			System.out.println("Fruto: "+recogidos3.get(i).getNombre()+" Estado: "+recogidos3.get(i).getEstado()+" Peso: "+recogidos3.get(i).getPeso());
		}
	}

}
