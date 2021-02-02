import java.util.ArrayList;

public class MainTrifido2 {
	//se comprueban los metodos abonar teniendo cuidador inmune y sin estar localizada
	//recolectar sin estar localizada la huerta ni el trifido plantado
	//arranca sin ser inmune
	//otea sin estar plantada y la huerta localizada sin cuidador
	//otea sin posiciones libres
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------TRIFIDOOOOO 2-----------------------------");
		Huerta huerto1=new Huerta(2,4);
		Huerta huerto2=new Huerta(2,2);
		Valores.add("Platanero", 3);
		Planta plata1=new Trifido("Platanero","Platano",3);
		Planta plata2=new Trifido("Platanero","Platano",8);
		Persona cuid1=new Inmune("Natsu");
		Persona aux=new Persona("Happy");
		Persona cuid2=new Zombie(aux);
		Persona cuid3=new Persona("Gray");
		
		huerto1.planta(plata1);
		System.out.println("***HUERTO 1***");
		System.out.println("-----------------------------RECOLECTA-----------------------------");
		System.out.println("(no deberia salir ningun nombre)");
		ArrayList<Fruto> frutos=((Trifido)plata1).recolecta();//huerta no localizada
		System.out.println("Frutos recolectados Platanero1: ");
		for(int i=0;i<frutos.size();i++) {
			System.out.println("  "+frutos.get(i).getNombre());
		}
		System.out.println("Frutos recolectados Platanero2: ");
		frutos=((Trifido)plata2).recolecta();//trifido no plantado
		for(int i=0;i<frutos.size();i++) {
			System.out.println("  "+frutos.get(i).getNombre());
		}
		mostrarHuertos(huerto1);
		huerto1.localiza(2, 3);
		
		System.out.println("-----------------------------ARRANCA-----------------------------");
		System.out.println("Si el cuidador es zombie: ");
		huerto1.setCuidador(cuid2);
		plata1.arranca();
		mostrarHuertos(huerto1);
		System.out.println("Si el cuidador es normal: ");
		huerto1.setCuidador(cuid3);
		plata1.arranca();
		System.out.print("  Ahora es :");
		if(huerto1.getCuidador() instanceof Zombie)
			System.out.println("Zombie");
		else if(huerto1.getCuidador() instanceof Inmune)
			System.out.println("Inmune");
		else
			System.out.println("Normal");
		mostrarHuertos(huerto1);
		System.out.println("Si el cuidador es Inmune");
		huerto1.setCuidador(cuid1);
		plata1.arranca();
		mostrarHuertos(huerto1);
		
		System.out.println("***HUERTO 2***");
		System.out.println("-----------------------------OTEA-----------------------------");
		huerto2.localiza(1,3);
		System.out.println("Platanero1: "+((Trifido)plata1).otea()+"  Estado:"+plata1.getEstado());//true
		mostrarHuertos(huerto2);
		//Lleno el huerto2
		System.out.println("Lleno huerto");
		Planta plata3=new Planta("Platanero","Platano",6);
		Planta nogal1=new Planta("Nogal","Nuez",6);
		Planta nogal2=new Planta("Nogal","Nuez",4);
		huerto2.planta(plata3);
		huerto2.planta(nogal1);
		huerto2.planta(nogal2);
		System.out.println("Platanero2: "+((Trifido)plata2).otea()+"  Estado:"+plata2.getEstado());//false
		
		System.out.println("-----------------------------ABONA-----------------------------");
		System.out.println("***HUERTO 3***");
		Huerta huerto3=new Huerta(1,1);
		huerto3.setCuidador(cuid2);
		Planta manza1=new Trifido("Manzano","Manzana",4);
		System.out.println("Planto Manzano 1:"+huerto3.planta(manza1)+" Estado:"+manza1.getEstado());
		mostrarHuertos(huerto3);
		System.out.println("Tiene cuidador Zombie");//para que cree frutos
		System.out.println("Abono Manzano 1: "+manza1.abona(2));
		System.out.println("Cambio cuidador a Inmune");//ahora que tiene frutos puede
		huerto3.setCuidador(cuid1);
		System.out.println("Abono Manzano 1: "+manza1.abona(2));
		
		System.out.println("-----------------------------MUESTRO HUERTOS FINALES-----------------------------");
		System.out.println("***HUERTO 1***");
		mostrarHuertos(huerto1);
		System.out.println("***HUERTO 2***");
		mostrarHuertos(huerto2);
		System.out.println("***HUERTO 3***");
		mostrarHuertos(huerto3);
		
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
		System.out.println("\n");
	}
}
