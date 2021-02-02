//import p2pr1.*;
import java.util.ArrayList;

public class prueb2{

	public static void infoPlanta(Planta plantota){
		System.out.print("  Nombre:"+plantota.getNombre());
		System.out.print("  Fruto:"+plantota.getFruto());
		System.out.println("    Estado:"+plantota.getEstado());
		if(plantota instanceof Trifido){
			System.out.print("  Trifido: SI");
			Trifido plantotatrif;
			plantotatrif = (Trifido)plantota;
			if(plantotatrif.getPosicion() != null){
				System.out.println("         Posicion:"+plantotatrif.getPosicion()[0]
					+" "+plantotatrif.getPosicion()[1]);
			}
			else{
				System.out.println("         Posicion: vacia");
			}
		}
		else{
			System.out.print("  Trifido: NO");
		}
		// System.out.println("  Huerta:"+plantota.getPlantada()+"    ");
		if(plantota.getPlantada()!=null)
			System.out.println("  Plantada: SI");
		else
			System.out.println("  Plantada: NO");
		Fruto[] frutos = plantota.getFrutos();
		for(int i=0 ; i<frutos.length ; i++){
			System.out.print("   ["+i+"]");
			if(frutos[i] != null){
				System.out.println(";nombre:"+frutos[i].getNombre()+
					" ;estado:"+frutos[i].getEstado()+" ;"+
					frutos[i].getPeso());
			}
			else{
				System.out.println(";vacio");
			}
		}
		
	}
	public static void infoPersona(Persona p){
		System.out.print("  Nombre:"+p.getNombre());
		// System.out.print("    Cuida una Huerta:");
		// if(p.getHuerta() != null){
		// 	System.out.println("SI");
		// }
		// else
		// 	System.out.println("NO");
		if(p instanceof Inmune){
			System.out.print("  Inmune: SI");
			Inmune inm = (Inmune)p;
			if(inm.getVehiculo() != null){
				System.out.println("    Vehiculo: SI");
				impCombustible(inm.getVehiculo());
			}
			else
				System.out.println("    Vehiculo: NO");
		}
		if(p instanceof Zombie){
			System.out.println("  Zombie: SI");
		}
	}
	public static void impArrayListPlanta(ArrayList<Planta> arr){
		for(int i=0 ; i<arr.size() ; i++){
			System.out.print("-get("+i+")");
			System.out.println((arr.get(i).getNombre()));
		}
	}
	public static void mostrarHuerto(Huerta huertilla){
		for(int i=0 ; i<huertilla.getHuerto().length ; i++){
			System.out.print("  |");
			for(int j=0 ; j<huertilla.getHuerto()[0].length ; j++){
				if(huertilla.getHuerto()[i][j] == null){
					System.out.print("vacio      |");
				}
				else{
					System.out.print(huertilla.getHuerto()[i][j].getNombre()+" |");
				}
			}
			System.out.println();
		}
		System.out.print("    Cuidador de la huerta:");
		if(huertilla.getCuidador() == null )
			System.out.println("sin cuidador");
		else{
			infoPersona(huertilla.getCuidador());
				// " /"+huertilla.getCuidador());
		}
		// System.out.println("    Memoria:"+huertilla);
		if(huertilla.getLocalizacion() != null){
			System.out.println("    Localizada: SI ");/*en:"+huertilla.getLocalizacion().getLatitud()
				+" "+huertilla.getLocalizacion().getLongitud());*/
		}else{
			System.out.println("    Localizada en: null");
		}
	}
	public static void impCombustible(Vehiculo v){
		System.out.print("    Combustible: ");
		for(int i=0 ; i<v.getCombustible().length ; i++){
			if(v.getCombustible()[i] == true)
				System.out.print("|");
			else
				System.out.print("-");
		}
		System.out.println();
	}
	public static void infoPosHuerto(int n1, int n2, Huerta huertilla){
		Planta[][] arraplant = huertilla.getHuerto();
		System.out.println("  Info de la planta en "+n1+" "+n2);
		if(arraplant[n1][n2] != null)
		infoPlanta(arraplant[n1][n2]);
		else
			System.out.println("   vacio");
	}
	public static void sacameLaInfo1(Trifido t, Huerta h1, Huerta h2){
		System.out.println("****INFO ACTUAL****");
		System.out.println(" ---Trifido0---");
		infoPlanta(t);
		System.out.println(" ---Huerta1---");
		mostrarHuerto(h1);

		System.out.println(" ---Huerta2---");
		mostrarHuerto(h2);

		System.out.println();
	}
	public static void sacameLaInfo2(Trifido t, Huerta h1, Huerta h2){
		System.out.println("****INFO ACTUAL****");
		System.out.println(" ---Trifido1---");
		infoPlanta(t);
		System.out.println(" ---Huerta3---");
		mostrarHuerto(h1);

		System.out.println(" ---Huerta2---");
		mostrarHuerto(h2);

		System.out.println();
	}
	public static void main(String[] args) {
			
		Valores.add("patata",1);
		Valores.add("kiwi",4);
		Valores.add("mora",8);
		Valores.add("pera",6);

		Planta plantapera0 = new Planta("plantapera","pera",9);
		Planta plantapera1 = new Planta("plantapera","pera",9);
		Planta plantapera2 = new Planta("plantapera","pera",9);
		Planta plantapera3 = new Planta("plantapera","pera",9);
		Planta plantapera4 = new Planta("plantapera","pera",9);
		Planta plantapera5 = new Planta("plantapera","pera",9);
		Planta plantapera6 = new Planta("plantapera","pera",9);
		Planta plantapera7 = new Planta("plantapera","pera",9);
		Planta plantapera8 = new Planta("plantapera","pera",9);
		Planta plantapera9 = new Planta("plantapera","pera",9);
		Planta plantapera10 = new Planta("plantapera","pera",9);
		Planta plantapera11 = new Planta("plantapera","pera",9);


		Planta plantamora0 = new Planta("plantamora","mora",5);
		Planta plantamora1 = new Planta("plantamora","mora",5);
		Planta plantamora2 = new Planta("plantamora","mora",5);
		Planta plantamora3 = new Planta("plantamora","mora",5);

		Planta plantamora4 = new Planta("plantamora","mora",5);
		Planta plantamora5 = new Planta("plantamora","mora",5);
		Planta plantamora6 = new Planta("plantamora","mora",5);
		Planta plantamora7 = new Planta("plantamora","mora",5);

		Planta plantakiwi0 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi1 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi2 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi3 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi4 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi5 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi6 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi7 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi8 = new Planta("plantakiwi","kiwi",12);

		Planta plantakiwi9 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi10 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi11 = new Planta("plantakiwi","kiwi",12);
		Planta plantakiwi12 = new Planta("plantakiwi","kiwi",12); 

		Trifido trif0 = new Trifido("Patatero0_","patata",5);
		Trifido trif1 = new Trifido("Patatero1_","patata",4);
		Trifido trif2 = new Trifido("Patatero2 ","patata",3);
		Trifido trif3 = new Trifido("Patatero3 ","patata",6);

		Persona paco = new Persona("Paco");
		Persona bill = new Persona("Bill");
		Persona kate = new Persona("Kate");

		Inmune fiera = new Inmune("Fiera");

		Huerta hu01 = new Huerta(3,3);
		Huerta hu02 = new Huerta(3,3);

		
		// Huerta hu04 = new Huerta(3,3);

		Vehiculo rayoMcQueen = new Vehiculo(70);

		hu01.localiza(0,1);
		hu02.localiza(0,2);

		// hu03.localiza(0,3);
		// hu04.localiza(0,4);

		hu02.planta(plantakiwi0);
		hu02.planta(plantakiwi1);
		hu02.planta(plantakiwi2);//
		hu02.planta(plantakiwi3);
		hu02.planta(plantakiwi4);
		hu02.planta(plantakiwi5);//
		hu02.planta(plantakiwi6);

		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Devuelve falso porque Trifido0 no tiene ni Huerto ni Frutos");

		System.out.println("Plantamos Trifido0 en hu01: "+hu01.planta(trif0));
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Devuelve falso porque Trifido0 no tiene Frutos");

		System.out.println("Vamos a ponerle un cuidador");
		paco.paseo();
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Ahora el cuidador de hu01 es Zombie y Trifido0 ha generado 2 frutos y su estado es Adulta");
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Volvemos a abonar");
		System.out.println("  Trifido0 genera 2 frutos mas");
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Volvemos a abonar");
		System.out.println("  Trifido0 genera 1 fruto mas porque no hay mas espacio");
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		sacameLaInfo1(trif0,hu01,hu02);
		
		
		
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Devuelve falso porque el cuidador ya es Zombie");
		
		System.out.println("Ahora vamos a eliminar el cuidador de la Huerta1 y le ponemos un Inmune");
		hu01.setCuidador(null);// no se si vale esto
		hu01.setCuidador(fiera);
		sacameLaInfo1(trif0,hu01,hu02);
		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Devuelve falso porque Huerta2 no tiene cuidador");
		System.out.println("Vamos a darle cuidador a una hu02 con kate.paseo()");
		kate.paseo();
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Devuelve falso porque el Trifido ha eliminado sus frutos previamente en un intento de desplazarse");
		System.out.println("Vamos a generarle un fruto con abona()");
		System.out.println("  Plantamos una plantamora en Huerta1:"+hu01.planta(plantamora0));
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Invocamos abona() de Trifido0, ha devorado: "+trif0.abona()+" fruto");
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Invocamos abona(int) de Trifido0: "+trif0.abona(10));
		System.out.println("  Trifido0 se ha desplazado a hu02 en su poscion 0 0");
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Ahora invocamos abona() para que Trifido0 vuelva a tener frutos");
		System.out.println("Invocamos abona() de Trifido0");
		System.out.println("  Trifido0 se ha comido "+trif0.abona()+" plantas adyacentes y tiene 2 frutos");
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Arrancamos Trifido0 de hu02, pero como nuestro Cuidador no es Inmune, es Convertido en Zombie");
		trif0.arranca();
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Ponemos a un Inmune de Cuidador y Arrancamos Trifido0 de hu02, con arranca(cad,coord,coord) de Huerta");
		Inmune crack = new Inmune("Crack");
		hu02.setCuidador(null);
		hu02.setCuidador(crack);
		// trif0.arranca();
		hu02.arranca("Patatero0_",0,0);
		sacameLaInfo1(trif0,hu01,hu02);

		System.out.println("Ahora queremos probar la condicion de Huerta sin localizar");
		Huerta hu03 = new Huerta(3,4);
		System.out.println("  (Utilizamos otra huerta y otro Trifido)");
		System.out.println("Pasamos a plantar Trifido1 en la Huerta3 que no está localizada "+
			hu03.planta(trif1));
		
		System.out.println("Vamos a llenar Huerta3 para ver que pasa cuando el Trifido se desplaza, dejamos hueco en 1,1");
		hu02.planta(plantakiwi9);
		hu02.planta(plantakiwi10);
		hu02.planta(plantakiwi11);
		hu02.planta(plantakiwi12);
		hu02.arranca("plantakiwi",1,1);
		sacameLaInfo2(trif1,hu03,hu02);

		System.out.println("Invocamos abona(int) de Trifido1: "+trif1.abona(10));
		System.out.println("  Devuelve falso porque Trifido1 no tiene frutos");
		System.out.println("  Plantamos una plantamora en Huerta3:"+hu03.planta(plantamora1));
		System.out.println("Invocamos abona() de Trifido1, ha devorado: "+trif1.abona()+" fruto");
		sacameLaInfo2(trif1,hu03,hu02);

		System.out.println("Trifido1 no ha generado fruto porque con la primera planta comida cambia su estado a adulta");
		System.out.println("  Plantamos una plantamora en Huerta3:"+hu03.planta(plantamora2));
		System.out.println("Invocamos abona() de Trifido1, ha devorado: "+trif1.abona()+" fruto");
		sacameLaInfo2(trif1,hu03,hu02);

		hu01.setCuidador(null);
		System.out.println("Invocamos abona(int) de Trifido1: "+trif1.abona(10));
		System.out.println("  Trifido1 se ha desplazado a Huerta2, se planta en primera posicion libre");
		System.out.println("El Inmune se sube en rayoMcQueen:"+rayoMcQueen.sube(crack));
		sacameLaInfo2(trif1,hu03,hu02);	

		hu02.abona(10,"plantakiwi");
		hu02.abona(10,"plantakiwi");
		hu02.abona(10,"plantakiwi");
		hu02.abona(10,"plantakiwi");
		hu02.abona(10,"plantakiwi");

		System.out.println("reposta de Vehiculo:"+rayoMcQueen.repostaje(hu02.recolecta("kiwi")));
		sacameLaInfo2(trif1,hu03,hu02);

		// System.out.println("Invocamos abona() de Trifido1 para que se hinche a comer");
		// System.out.println("En Huerta3 dejamos dos huecos para plantar trifidos, y la localizamos");
		// System.out.println("Plantas devoradas:"+trif1.abona());
		// hu03.planta(plantapera0);
		// hu03.planta(plantapera1);
		// hu03.planta(plantapera2);
		// hu03.planta(plantapera3);
		// hu03.planta(plantapera4);
		// hu03.planta(plantapera5);
		// hu03.planta(plantapera6);
		// hu03.planta(plantapera7);
		// hu03.planta(plantapera8);
		// hu03.planta(plantapera9);
		// hu03.planta(plantapera10);
		// hu03.planta(plantapera11);
		// hu03.arranca("plantapera",1,1);
		// hu03.arranca("plantapera",1,2);
		// hu03.setCuidador(new Persona("Gorotzenea"));
		// hu03.localiza(0,0.4);

		// hu01.setCuidador(new Persona("alguien"));
		// sacameLaInfo2(trif1,hu03,hu02);

		// System.out.println("Invocamos abona(int) de Trifido1: "+trif1.abona(10));

		// sacameLaInfo2(trif1,hu03,hu02);
	}	
}