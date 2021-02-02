import java.util.ArrayList;

/*
 * Se crea una huerta y una planta. Se invoca el método planta de la huerta con
la planta. Se invoca abona de la planta hasta que genere frutos y se invoca el
método recolecta de la planta. Se muestra por pantalla el resultado de cada
acción
 */
public class P07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomplanta="manzano";
		String nomfruto="manzana";
		int valor=7;
		
		Huerta huerto=new Huerta(3,4);
		Planta planta=new Planta(nomplanta, nomfruto, valor);
		
		System.out.println("Plantada: "+huerto.planta(planta));
		
		while(planta.getFrutos()[valor-1]==null) {
			System.out.println(planta.abona(4));
		}
			
		ArrayList<Fruto> recogidos=new ArrayList<Fruto>();
		recogidos=planta.recolecta();
		for(int i=0;i<recogidos.size();i++) {
			System.out.println("Fruto: "+recogidos.get(i).getNombre()+" Estado: "+recogidos.get(i).getEstado()+" Peso: "+recogidos.get(i).getPeso());
		}
		
	}

}
