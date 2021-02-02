/*
 * Se crea una huerta y una planta. Se invoca el metodo planta de la huerta con
la planta. Se invoca abona de la planta hasta que genere su maximo numero de
frutos. Se muestra por pantalla el resultado de cada acción.
 */

import java.text.*;
import java.util.*;
public class P06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomplanta="manzano";
		String nomfruto="manzana";
		int valor=7;
		
		Huerta huerto=new Huerta(3,4);
		Planta planta=new Planta(nomplanta, nomfruto, valor);
		
		huerto.planta(planta);
		
		for(int i=0;planta.getFrutos()[6]==null;i++) {
			System.out.println(planta.abona(4));
		}
		for(int i=0;i<planta.getFrutos().length;i++) {
			if(planta.getFrutos()[i]!=null)
				System.out.println("i: "+i+": "+planta.getFrutos()[i].getNombre());
			else
				System.out.println("i: "+i+": null");
		}
	}
		
}


