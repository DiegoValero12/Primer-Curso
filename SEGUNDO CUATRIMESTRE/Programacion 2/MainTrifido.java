import java.util.ArrayList;

public class MainTrifido {
	//se comprueban todos los metodos de trifido
	//todas las plantas estan plantadas y todas las huertas localizadas

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//primero creo relaciones
		System.out.println("-------------------------------TRIFIDOOOOO-------------------------------");
		Valores.add("Manzano", 3);
		Valores.add("Peral", 3);
		Valores.add("Cerezo", 3);
		Valores.add("Almendro", 3);
		//Voy a crear dos huertas, dos trifidos y tres plantas diferentes
		Huerta huerto1=new Huerta(3,3);
		Huerta huerto2=new Huerta(4,2);
		Trifido trif1=new Trifido("Manzano","Manzana",4);
		Trifido trif2=new Trifido("Peral","Pera",7);
		Planta peral1=new Planta("Peral","Pera",6);
		Planta peral2=new Planta("Peral","Pera",4);
		Planta cerezo1=new Planta("Cerezo","Cereza",6);
		Planta almendro1=new Planta("Almendro","Almendras",9);
		Planta almendro2=new Planta("Almendro","Almendras",5);
		Planta nogal1=new Planta("Nogal","nuez",5);
		Planta nogal2=new Planta("Nogal","nuez",9);
		Planta nogal3=new Planta("Nogal","nuez",7);
		
		//creo cuidadores
		Persona cuid2=new Persona("Mario");
		Persona cuid1=new Inmune("Luigi");
		
		//localizo huertas y les anyado cuiador
		huerto1.localiza(10, 5);
		huerto2.localiza(4, 0);
		huerto1.setCuidador(cuid1);
		huerto2.setCuidador(cuid2);
		
		//planto plantas//a nivel de huerta porque inmune aun no esta bien
		huerto1.planta(nogal1);
		huerto1.planta(cerezo1);
		huerto1.planta(peral1);
		huerto1.planta(trif2);
		huerto1.planta(peral2);
		
		
		huerto2.planta(trif1);
		huerto2.planta(nogal2);
		huerto2.planta(nogal3);
		huerto2.planta(almendro1);
		huerto2.planta(almendro2);
		
		//muestro los huertos
		System.out.println("---HUERTOS---");
		System.out.print("Huerto 1 Cuidador: "+huerto1.getCuidador().getNombre());
		mostrarHuertos(huerto1);
		
		System.out.print("\nHuerto 2 Cuidador: "+huerto2.getCuidador().getNombre());
		mostrarHuertos(huerto2);
		
		//abono plantas normales hasta que tengan frutos
		System.out.println("-------------------------------VAMOS A ABONAR-------------------------------");
		System.out.println("Abonando...");
		int ser=0;
		while(cerezo1.getEstado().equalsIgnoreCase("adulta")==false) {
			System.out.println("Abono Cerezo: "+huerto1.abona(2, "cerezo"));//1
			System.out.println("Abono Peral: "+huerto1.abona(2, "peral"));//2->trifido es adulta pero sin frutos
			System.out.println("Abono Nogal: "+huerto1.abona(2, "nogal")+" "+huerto2.abona(2, "nogal"));//1 2
			System.out.println("Abono Almendro: "+huerto2.abona(2, "almendro"));//2
			System.out.println("Abono Manzano: "+huerto2.abona(2, "manzano"));//1
			if(huerto2.getCuidador() instanceof Zombie&&ser==0) {
				System.out.println("  Mario ahora es Zombie");
				ser=1;
			}
		}
		
		//abono una mas para que creen frutos las normales
		System.out.println("Abono Cerezo: "+huerto1.abona(2, "cerezo"));//1
		System.out.println("Abono Peral: "+huerto1.abona(2, "peral"));//2->trifido es adulta pero sin frutos->cuidador inmune
		System.out.println("Abono Nogal: "+huerto1.abona(2, "nogal")+" "+huerto2.abona(2, "nogal"));//1 2
		System.out.println("Abono Almendro: "+huerto2.abona(2, "almendro"));//2
		System.out.println("Abono Manzano: "+huerto2.abona(2, "manzano"));//1->trifido cuidador no inmune
		System.out.println("ABONADO");
		
		//abono de trifido
		int frutos2=0;
		int frutos1=0;
		System.out.println("-------------------------------ABONO DE TRIFIDO-------------------------------");
		System.out.println("Abono Peral (trifido): Devoro: "+trif2.abona());//3
		for(int i=0;i<trif2.getFrutos().length;i++) {
			if(trif2.getFrutos()[i]!=null) {
				frutos2++;
				System.out.println(" 	Fruto: "+frutos2+" Peso: "+trif2.getFrutos()[i].getPeso());//3
			}
		}
		

		System.out.println("Abono Manzano (trifido): Devoro: "+trif1.abona());//2
		for(int i=0;i<trif1.getFrutos().length;i++) {
			if(trif1.getFrutos()[i]!=null) {
				frutos1++;
				System.out.println(" 	Fruto: "+frutos1+" Peso: "+trif1.getFrutos()[i].getPeso());//4
			}
		}
		
		System.out.println("---HUERTOS---");
		System.out.print("Huerto 1 Cuidador: "+huerto1.getCuidador().getNombre());
		mostrarHuertos(huerto1);
		
		System.out.print("\nHuerto 2 Cuidador: "+huerto2.getCuidador().getNombre());
		mostrarHuertos(huerto2);
		
		//getposicion
		System.out.println("-------------------------------GETPOSICION-------------------------------");
		System.out.println("Posiciones:");
		System.out.println("	trif2:"+trif2.getPosicion()[0]+" "+trif2.getPosicion()[1]);//0 1
		System.out.println("	trif1:"+trif1.getPosicion()[0]+" "+trif1.getPosicion()[1]);//3 1
		
		//falta abonar con inmune y no localizada, recolectar, arranca, otea
		//como cuidador inmune y huertas localizadas es el caso 1
		System.out.println("-------------------------------ABONA-------------------------------");
		int f=0;
		for(int i=0;i<trif2.getFrutos().length;i++) {
			if(trif2.getFrutos()[i]!=null) {
				f++;
			}
		}
		System.out.println("Frutos que tiene antes: "+f);

		
		System.out.println("trif2: "+trif2.abona(2)+" cuidador huerto nuevo: "+trif2.getPlantada().getCuidador().getNombre()+" posicion: "+trif2.getPosicion()[0]+" "+trif2.getPosicion()[1]);
		f=0;
		for(int i=0;i<trif2.getFrutos().length;i++) {
			if(trif2.getFrutos()[i]!=null) {
				f++;
			}
		}
		System.out.println("Frutos que tiene despues: "+f);

		
		
		System.out.println("---HUERTOS---");
		System.out.print("Huerto 1 Cuidador: "+huerto1.getCuidador().getNombre());
		mostrarHuertos(huerto1);
		
		System.out.print("\nHuerto 2 Cuidador: "+huerto2.getCuidador().getNombre());
		mostrarHuertos(huerto2);
		
		
		System.out.println("-------------------------------RECOLECTO-------------------------------");
		
		ArrayList<Fruto> recogidos=new ArrayList<Fruto>();
		System.out.println("Recolecto Manzano (trifido1): ");
		recogidos=trif1.recolecta();
		System.out.println("  Peso frutos:");
		for(int i=0;i<recogidos.size();i++) {//no recoje ninguno
			System.out.println("  "+recogidos.get(i).getPeso());
		}
		System.out.println("Posicion: "+trif1.getPosicion()[0]+" "+trif1.getPosicion()[1]);
		
		recogidos=trif2.recolecta();//recoge 0->no tiene frutos
		System.out.println("Recolecto Peral (trifido2): ");
		System.out.println("  Peso frutos:");
		for(int i=0;i<recogidos.size();i++) {//recoge 0
			System.out.println("  "+recogidos.get(i).getPeso());
		}
		System.out.println("Posicion: "+trif2.getPosicion()[0]+" "+trif2.getPosicion()[1]);
		
		trif2.abona();//abono para que cree dos frutos y pueda huir
		
		System.out.println("Despues de volver a abonar el trifido...");
		recogidos=trif2.recolecta();
		System.out.println("Recolecto Peral (trifido2): ");
		System.out.println("  Peso frutos:");
		for(int i=0;i<recogidos.size();i++) {//recoge 4
			System.out.println("  "+recogidos.get(i).getPeso());
		}
		System.out.println("Posicion: "+trif2.getPosicion()[0]+" "+trif2.getPosicion()[1]);
		
		System.out.println("---HUERTOS---");
		System.out.print("Huerto 1 Cuidador: "+huerto1.getCuidador().getNombre());
		mostrarHuertos(huerto1);
		
		System.out.print("\nHuerto 2 Cuidador: "+huerto2.getCuidador().getNombre());	
		mostrarHuertos(huerto2);
		
		System.out.println("-------------------------------OTEA-------------------------------");
		System.out.println("Se ha plantado el Peral (trifido2): "+trif2.otea());//false->esta plantada
		System.out.println("Se ha plantado el Manzano (trifido1): "+trif1.otea());//false->todas las huertas tienen cuidador
		
		System.out.println("-------------------------------ARRANCA-------------------------------");
		System.out.println("Datos Peral (trifido2):");
		if(trif2.getPosicion()==null&&trif2.getPlantada()==null&&encontrar(trif2,huerto1)==false) {
			System.out.println("  Sin posicion");
		}
		else {
			System.out.println("  Con posicion");
		}
		trif2.arranca();
		System.out.println("Arranco Peral (trifido2)");
		System.out.println("Datos Peral (trifido2):");
		if(trif2.getPosicion()==null&&trif2.getPlantada()==null&&encontrar(trif2,huerto1)==false) {
			System.out.println("  Sin posicion");
		}
		else {
			System.out.println("  Con posicion");
		}
		
		
		System.out.println("-------------------------------HUERTOS FINAL-------------------------------");
		System.out.print("Huerto 1 Cuidador: "+huerto1.getCuidador().getNombre());
		mostrarHuertos(huerto1);
		
		System.out.print("\nHuerto 2 Cuidador: "+huerto2.getCuidador().getNombre());	
		mostrarHuertos(huerto2);
		
		System.out.println("\n-------------------------------FIIIIIIIN-------------------------------------");
		
	}
	
	public static boolean encontrar(Planta trif,Huerta huerto) {
		boolean result=false;
		if(huerto!=null) {
			for(int i=0;i<huerto.getHuerto().length&&result==false;i++){
				for(int c=0;c<huerto.getHuerto()[i].length&&result==false;c++) {
					if(huerto.getHuerto()[i][c]!=null) {
						if(huerto.getHuerto()[i][c].equals(trif)) {//se busca
							result=true;
						}
					}
					
				}
			}
		}
		return result;
	}
	
	public static void mostrarHuertos(Huerta huerto) {
		for(int i=0;i<huerto.getHuerto().length;i++) {
			System.out.print("\n[ "+i+" ] :");
			for(int j=0;j<huerto.getHuerto()[i].length;j++) {
				if(huerto.getHuerto()[i][j]!=null) {
					System.out.print(" "+huerto.getHuerto()[i][j].getNombre());
				}
				else
					System.out.print(" null");
			}
		}
		System.out.println("");
	}

}
