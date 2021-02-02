import java.util.ArrayList;

public class pruebaInmunePaseo {

	public static void main(String[] args) {
		Huerta h1=new Huerta(3,3);
		Huerta h2=new Huerta(4,4);
		Inmune i1=new Inmune("inmune");
		Persona pers1=new Persona("persona");
		Zombie zomb=new Zombie(pers1);
		
		h1.localiza(3, 4);
		h2.localiza(6, 7);
		System.out.println("Cuidador de la huerta 2: "+h2.getCuidador());
		System.out.println("Huerta del zombie: "+zomb.getHuerta());
		System.out.println(((Persona)i1).paseo());
		System.out.println(((Persona)zomb).paseo());
		
		System.out.println("Cuidador de la huerta 2: "+h2.getCuidador());
		
		System.out.println("\nPlantamos plantas en la huerta 1\n");
		
		for(int i=1;i<=9;i++) {
			Planta plantita=new Planta("peral", "pera", 5);
			pers1.planta(plantita, h1);
		}
		System.out.println("Huerto 1-----");
		mostrarHuertos(h1);
		System.out.println("Huerto 2-----");
		mostrarHuertos(h2);
		
		System.out.println("\nAbonamos las plantas del huerto 1 y recargamos el combustible\n");
		
		for(int i=1;i<=8;i++) {
			h1.abona(i, "peral");
		}
		
		ArrayList<Fruto> repostaje=h1.recolecta("pera");
		
		Vehiculo vehiculo=new Vehiculo(50);
		vehiculo.sube(i1);
		System.out.println("Combustible del vehiculo: "+vehiculo.getNumCombustible());
		vehiculo.repostaje(repostaje);
		System.out.println("Repostamos");
		System.out.println("Combustible del vehiculo: "+vehiculo.getNumCombustible());

		System.out.println("\nPlantamos los trifidos en la huerta 2\n");
		
		Trifido t1=new Trifido("naranjo", "naranja", 5);
		Trifido t2=new Trifido("naranjo", "naranja", 5);
		
		pers1.planta(t1, h2);
		pers1.planta(t2, h2);
		
		System.out.println("Huerto 1-----");
		mostrarHuertos(h1);
		System.out.println("Huerto 2-----");
		mostrarHuertos(h2);
		
		System.out.println("\nEl inmune con paseo ha recogido "+i1.paseo(h2.getLocalizacion())+" trifidos\n");
		System.out.println("Combustible despues de hacer paseo: "+vehiculo.getNumCombustible());
		System.out.println("Huerto 1-----");
		mostrarHuertos(h1);
		System.out.println("Huerto 2-----");
		mostrarHuertos(h2);
		
		System.out.println("Cuidador de la huerta 2: "+h2.getCuidador());
	}

	
	public static void mostrarHuertos(Huerta huerto) {
		for(int i=0;i<huerto.getHuerto().length;i++) {
			System.out.print("\n[ "+i+" ] :");
			for(int j=0;j<huerto.getHuerto()[i].length;j++) {
				if(huerto.getHuerto()[i][j]!=null) {
					System.out.print(" "+huerto.getHuerto()[i][j].getNombre());
					if(huerto.getHuerto()[i][j] instanceof Trifido)
						System.out.print("(T)");
				}
				else
					System.out.print(" null");
			}
		}
		System.out.println("\n");
	}
}
