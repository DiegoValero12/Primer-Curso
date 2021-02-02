import java.util.ArrayList;

public class MainZombie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------ZOMBIE---------------------------");
		Valores.add("Girasol", 2);
		Valores.add("Nogal", 3);
		Planta gira1=new Planta("Girasol","Pipas",5);
		Planta gira2=new Planta("Girasol","Pipas",3);
		Planta nogal1=new Trifido("Nogal","Nuez",3);
		Planta nogal2=new Trifido("Nogal","Nuez",2);
		Huerta huerto1=new Huerta(2,2);
		Persona aux=new Persona("Baymax");
		huerto1.setCuidador(aux);
		aux.setHuerta(huerto1);
		Persona cuid1=new Zombie(aux);
		huerto1.planta(gira1);
		
		System.out.print("Nombre del cuidador: "+cuid1.getNombre());//Baymax
		if(cuid1.getHuerta()!=null)
			System.out.println(" Tiene huerta");//si
		else
			System.out.println(" No tiene huerta");
		
		System.out.println("---------------------------PLANTA---------------------------");
		System.out.println("Planto nogal1 (trifido): "+cuid1.planta(nogal1, huerto1));//true
		System.out.println("Planto nogal2 (trifido): "+cuid1.planta(nogal2, huerto1));//true
		System.out.println("Planto girasol1: "+cuid1.planta(gira1, huerto1));//ya estaba plantado
		System.out.println("Planto girasol1: "+cuid1.planta(gira2, huerto1));//true
		mostrarHuertos(huerto1);
		
		
		System.out.println("---------------------------PASEO---------------------------");
		if(cuid1.paseo()!=null)
			System.out.println("Tiene una huerta");
		else
			System.out.println("No tiene huerta o no esta localizada");
		huerto1.localiza(2, 3);
		System.out.println("Vuelvo a pasear");
		if(cuid1.paseo()!=null)
			System.out.println("Tiene una huerta");
		else
			System.out.println("No tiene huerta o no esta localizada");
		
		System.out.println("---------------------------ABONA DE PERSONA---------------------------");
		System.out.println("Se han abonado "+cuid1.abona(3, "Cactus"));//3
		
		System.out.println("---------------------------MALASHIERBAS---------------------------");
		mostrarHuertos(huerto1);
		System.out.println("Plantas arrancadas:");//no hay adultas
		ArrayList<Planta> arrancadas=cuid1.malasHierbas();
		for(int i=0;i<arrancadas.size();i++) {
			System.out.println("  "+arrancadas.get(i).getNombre());
		}
		while(gira1.getEstado()!="adulta") {
			gira1.abona(2);
		}
		System.out.println("Vuelvo a arrancar");
		arrancadas=cuid1.malasHierbas();
		System.out.println("Plantas arrancadas:");//solo girasol
		for(int i=0;i<arrancadas.size();i++) {
			System.out.println("  "+arrancadas.get(i).getNombre());
		}
		mostrarHuertos(huerto1);
		
		System.out.println("---------------------------ABONA DE ZOMBIE---------------------------");
		Planta gira3=new Planta("Girasol","Pipas",4);
		System.out.println("Planto un nuevo girasol: "+huerto1.planta(gira3));
		mostrarHuertos(huerto1);
		System.out.println("Los trifidos han devorado: "+((Zombie)cuid1).abona());
		mostrarHuertos(huerto1);
		
		System.out.println("FIN");
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
