import java.text.DecimalFormat;
	import java.text.DecimalFormatSymbols;
	import java.util.ArrayList;
	import java.util.Locale;
	
	//PRUEBAS PARA COMPROBAR INMUNE

public class p08 {

	private static String mrf(double db){
		Locale lengua=new Locale("en");
		DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
		DecimalFormat formato=new DecimalFormat("0.000",chars);

		return(formato.format(db).toString());
	}
	private static void localiza(Huerta a,Huerta b){
		  b.localiza(0,38);
		  a.localiza(0,39);
	  }

	  private static void consultaFruto(Fruto f){
	    if(f!=null){
	      System.out.print("nombre: "+f.getNombre()+"; peso: "+p08.mrf(f.getPeso())+"; estado: "+f.getEstado());
	    }
	    System.out.println();
	  }
	  private static void consultaPlanta(Planta p){
	    if(p!=null){
	      System.out.println("Trifido: "+(p instanceof Trifido));
	      System.out.println("Nombre: "+p.getNombre());
	      System.out.println("Estado: "+p.getEstado());
	      System.out.println("Nombre de sus frutos: "+p.getFruto());
	      Fruto[] producted=p.getFrutos();
	      if(producted!=null){
	        System.out.println("Num. max: "+producted.length);
	        for(int i=0;i<producted.length;i++){
	           System.out.print("pos. "+i+" -> ");
	           p08.consultaFruto(producted[i]);
	        }
	      }
	    }
	  }
	  private static void consultaHuerto(Planta[][] h){
	    System.out.println("Estado de la finca");
	    if(h!=null){
	      for(int i=0;i<h.length;i++){
	        for(int j=0;j<h[i].length;j++){
	          System.out.println("["+i+","+j+"]");
	          p08.consultaPlanta(h[i][j]);
	        }
	      }
	    }
	  }
	  
	  public static void mostrarGrafico(Huerta h) 
	  {
		  for (int i = 0; i < h.getHuerto().length; i++) {
			for (int j = 0; j < h.getHuerto()[i].length; j++) {
				if(h.getHuerto()[i][j] != null)
					System.out.print(h.getHuerto()[i][j].getNombre() + " ");
				else
					System.out.print("- ");
			}
			
			System.out.println();
		}
	  }
	  
	  public static void mostrarHuertas(Huerta h1, Huerta h2) 
	  {
		 System.out.println("Huerta 1: ");
		 p08.mostrarGrafico(h1);
		 p08.consultaCuidador(h1);
		 p08.consultaHuerto(h1.getHuerto());

		 System.out.println("\nHuerta 2: ");
		 p08.mostrarGrafico(h2);
		 p08.consultaCuidador(h2);
		 p08.consultaHuerto(h2.getHuerto());
		 
	  }
	  
	  public static void mostrarHuertas(Huerta h1) 
	  {
		 System.out.println("Huerta 3: ");
		 p08.mostrarGrafico(h1);
		 p08.consultaCuidador(h1);
		 p08.consultaHuerto(h1.getHuerto());
		 
	  }
	  
	  public static void consultaCuidador(Huerta h) 
	  {
		  if(h.getCuidador() != null) 
		  {
			  if(h.getCuidador() instanceof Inmune) 
				  System.out.println("Cuidador Inmune: " + h.getCuidador().getNombre());
			  else if(h.getCuidador() instanceof Zombie) 
				  System.out.println("Cuidador Zombie: " + h.getCuidador().getNombre());
			  else
				  System.out.println("Cuidador Persona: " + h.getCuidador().getNombre());
		  }
		  else
			  System.out.println("Cuidador: null");
		  
	  }
	
	public static void main(String[] args) {
		Valores.add("a", 1);
		Valores.add("b", 2);
		Valores.add("c", 3);
		Valores.add("d", 4);
		Valores.add("e", 5);
		Valores.add("f", 6);
		
		Trifido p1 = new Trifido("a","a", 1);
		Planta p2 = new Planta("b","a", 2);
		Planta p3 = new Planta("a","b", 3);
		Trifido p4 = new Trifido("b","a", 4);
		Planta p5 = new Planta("b","b", 5);
		Planta p6 = new Planta("b","c", 6);
		Trifido p7 = new Trifido("c","c",7);
		
		Trifido p8 = new Trifido("c","h",8);
		Trifido p9 = new Trifido("c","a",9);
		Trifido p10 = new Trifido("c","a",10);
		
		Huerta h1 = new Huerta(3,3);
		Huerta h2 = new Huerta(3,3);
		
		p08.localiza(h1, h2);
		
		Inmune per1 = new Inmune("Jotaro");
		Inmune per2 = new Inmune("Dio");
		
		System.out.println("Jotaro planta p1 en la h1: " + per1.planta(p1, h1));
		System.out.println("Jotaro planta p2 en la h1: " + per1.planta(p2, h1));
		System.out.println("Jotaro planta p3 en la h1: " + per1.planta(p3, h1));
		System.out.println("Jotaro planta p4 en la h1: " + per1.planta(p4, h1));
		System.out.println("Jotaro planta p5 en la h1: " + per1.planta(p5, h1));
		System.out.println("Jotaro planta p6 en la h1: " + per1.planta(p6, h1));
		System.out.println("Jotaro planta p7 en la h1: " + per1.planta(p7, h1));
		
		System.out.println("p7 otea: " + p7.otea());
		System.out.println("p8 otea: " + p8.otea());
		
		per1.paseo();
		
		System.out.println("p9 otea: " + p9.otea());
		System.out.println("p10 otea: " + p10.otea());
		
		per2.paseo();
		
		
		System.out.println("\n\n------------ Inicio ---------------\n\n");
		p08.mostrarHuertas(h1, h2);
		
		ArrayList<Planta> r1 = per1.malasHierbas();
		
		System.out.println("\n\n------------ Malas hierbas por Jotaro ---------------\n\n");
		p08.mostrarHuertas(h1, h2);
		System.out.println("\n Recolecta: ");
		for (int i = 0; i < r1.size(); i++) 
			p08.consultaPlanta(r1.get(i));
		
		System.out.println("\n\n------------ Dio abona su huerta ---------------\n\n");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas");
		System.out.println("Se abonan 'a' ? "+per2.abona(10, "a")+" plantas\n");
		
		System.out.println("Se abonan 'b' ? "+per2.abona(10, "b")+" plantas");
		System.out.println("Se abonan 'b' ? "+per2.abona(10, "b")+" plantas");
		System.out.println("Se abonan 'b' ? "+per2.abona(10, "b")+" plantas");
		System.out.println("Se abonan 'b' ? "+per2.abona(10, "b")+" plantas");
		System.out.println("Se abonan 'b' ? "+per2.abona(10, "b")+" plantas\n");
		
		System.out.println("Se abonan 'c' ? "+per2.abona(10, "c")+" plantas");
		System.out.println("Se abonan 'c' ? "+per2.abona(10, "c")+" plantas");
		System.out.println("Se abonan 'c' ? "+per2.abona(10, "c")+" plantas");
		System.out.println("Se abonan 'c' ? "+per2.abona(10, "c")+" plantas");
		System.out.println("Se abonan 'c' ? "+per2.abona(10, "c")+" plantas\n");
		p08.mostrarHuertas(h1, h2);
		
		System.out.println("\n\n------------ Dio se apropia de un coche ---------------\n\n");
		Vehiculo zawardo = new Vehiculo(6);
		System.out.println("Dio se apropia del vehiculo: "+per2.apropia(zawardo));
		System.out.println("Dio zawardo: "+ per2.getVehiculo().equals(zawardo));
		
		System.out.println("\n\n------------ Dio resposta el vehiculo y lo abandona ---------------\n\n");
		ArrayList<String> rep = per2.repostaje(); 
		
		System.out.println("RESPOSTAJE:");
		for (int i = 0; i < rep.size(); i++) 
			System.out.print(rep.get(i) + " ");
		
		System.out.println();
		boolean[] comb = zawardo.getCombustible();
		
		for (int i = 0; i < comb.length; i++) 
		{
			if(comb[i] == true)
				System.out.print("| ");
			else
				System.out.print("- ");
		}
		
		p08.mostrarHuertas(h1, h2);
		
		
		System.out.println("\n\n------------ Dio se pasea ---------------\n\n");
		Huerta h3 = new Huerta(2,2);
		h3.localiza(0, 39);
		
		Trifido t1 = new Trifido("a","a",1);
		Trifido t2 = new Trifido("a","a",1);
		Trifido t3 = new Trifido("a","a",1);
		Trifido t4 = new Trifido("a","a",1);
		Trifido t5 = new Trifido("a","a",1);
		Trifido t6 = new Trifido("a","a",1);
		Trifido t7 = new Trifido("a","a",1);
		Trifido t8 = new Trifido("a","a",1);
		Trifido t9 = new Trifido("a","a",1);
		
		Planta pp1 = new Planta("b","b",2);
		Planta pp2 = new Planta("b","b",2);
		Planta pp3 = new Planta("b","b",2);
		Planta pp4 = new Planta("b","b",2);
		Planta pp5 = new Planta("b","b",2);
		
		System.out.println("Jotaro planta p1 en la h3: " + per1.planta(pp1, h3));
		
		System.out.println("t1 otea: " + t1.otea());
		System.out.println("t2 otea: " + t2.otea());
		
		System.out.println("Jotaro planta p2 en la h3: " + per1.planta(pp2, h3));
		System.out.println("Jotaro planta p3 en la h3: " + per1.planta(pp3, h3));
		
		System.out.println("t3 otea: " + t3.otea());
		
		System.out.println("Jotaro planta p4 en la h3: " + per1.planta(pp4, h3));
		
		System.out.println("t4 otea: " + t4.otea());
		System.out.println("t5 otea: " + t5.otea());
		System.out.println("t6 otea: " + t6.otea());
		System.out.println("t7 otea: " + t7.otea());
		
		System.out.println("Jotaro planta p5 en la h3: " + per1.planta(pp5, h3));
		
		System.out.println("t8 otea: " + t8.otea());
		System.out.println("t9 otea: " + t9.otea());
		
		System.out.println("\n\n------------ Antes de pasear ---------------\n\n");
		
		p08.mostrarHuertas(h1, h2);
		System.out.println();
		p08.mostrarHuertas(h3);
		
		
		Coordenada c = new Coordenada(0, 39);
		per2.paseo(c);
		
		System.out.println("\n\n------------ Despues de pasear ---------------\n\n");
		
		
		p08.mostrarHuertas(h1, h2);
		System.out.println();
		p08.mostrarHuertas(h3);
		
		System.out.println("\nCombustible: ");
		for (int i = 0; i < per2.getVehiculo().getCombustible().length; i++)
		{
			if(per2.getVehiculo().getCombustible()[i] == true)
				System.out.print("| ");
			else
				System.out.print("- ");
		}
		
		System.out.println("\n\n------------ Jotaro se pasea ---------------\n\n");
		
		Huerta egipto = new Huerta(10,10);
		Coordenada c2 = new Coordenada(10,60);
		
		egipto.localiza(10, 60);
		
		Vehiculo star = new Vehiculo(50);
		
		per1.apropia(star);
		
		Planta stand1 = new Planta("a","a",3);
		Planta stand2 = new Planta("a","a",3); 
		Planta stand3 = new Planta("a","a",3); 
		Planta stand4 = new Planta("a","a",3); 
		Planta stand5 = new Planta("a","a",3); 
		Planta stand6 = new Planta("a","a",3); 
		Planta stand7 = new Planta("a","a",3); 
		Planta stand8 = new Planta("a","a",3); 
		
		System.out.println("Jotaro planta p1 en la h2: " + per1.planta(stand1, h2));
		System.out.println("Jotaro planta p2 en la h2: " + per1.planta(stand2, h2));
		System.out.println("Jotaro planta p3 en la h2: " + per1.planta(stand3, h2));
		System.out.println("Jotaro planta p4 en la h2: " + per1.planta(stand4, h2));
		System.out.println("Jotaro planta p5 en la h2: " + per1.planta(stand5, h2));
		System.out.println("Jotaro planta p6 en la h2: " + per1.planta(stand6, h2));
		System.out.println("Jotaro planta p7 en la h2: " + per1.planta(stand7, h2));
		System.out.println("Jotaro planta p7 en la h2: " + per1.planta(stand8, h2));
		
		System.out.println("Se abonan 'a' "+per1.abona(3, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(0, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(5, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(2, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(5, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(9, "a")+" plantas");
		System.out.println("Se abonan 'a' "+per1.abona(5, "a")+" plantas");
		
		per1.repostaje();
		
		System.out.println("\nCombustible: ");
		for (int i = 0; i < per1.getVehiculo().getCombustible().length; i++)
		{
			if(per1.getVehiculo().getCombustible()[i] == true)
				System.out.print("| ");
			else
				System.out.print("- ");
		}
		
		System.out.println("\nt1 otea: " + t1.otea());
		System.out.println("t2 otea: " + t2.otea());
		System.out.println("t3 otea: " + t3.otea());
		System.out.println("t4 otea: " + t4.otea());
		System.out.println("t5 otea: " + t5.otea());
		System.out.println("t6 otea: " + t6.otea());
		System.out.println("t7 otea: " + t7.otea());
		System.out.println("t8 otea: " + t8.otea());
		
		Trifido t10 = new Trifido("a","a",5);
		Trifido t11 = new Trifido("a","a",5);
		Trifido t12 = new Trifido("a","a",5);
		Trifido t13 = new Trifido("a","a",5);
		Trifido t14 = new Trifido("a","a",5);
		Trifido t15 = new Trifido("a","a",5);
		Trifido t16 = new Trifido("a","a",5);
		Trifido t17 = new Trifido("a","a",5);
		Trifido t18 = new Trifido("a","a",5);
		Trifido t19 = new Trifido("a","a",5);
		
		Persona perro = new Persona("Iggy");
		perro.paseo();
		Persona p = new Persona("Kakyoin");
		p.paseo();
		
		Zombie tonto = new Zombie(p);
		
		System.out.println("\nKakyoin planta trifidos 1: " + tonto.planta(t10, egipto));
		System.out.println("Kakyoin planta trifidos 2: " + tonto.planta(t11, egipto));
		System.out.println("Kakyoin planta trifidos 3: " + tonto.planta(t12, egipto));
		System.out.println("Kakyoin planta trifidos 4: " + tonto.planta(t13, egipto));
		System.out.println("Kakyoin planta trifidos 5: " + tonto.planta(t14, egipto));
		System.out.println("Kakyoin planta trifidos 6: " + tonto.planta(t15, egipto));
		System.out.println("Kakyoin planta trifidos 7: " + tonto.planta(t16, egipto));
		System.out.println("Kakyoin planta trifidos 8: " + tonto.planta(t17, egipto));
		System.out.println("Kakyoin planta trifidos 9: " + tonto.planta(t18, egipto));
		System.out.println("Kakyoin planta trifidos 10: " + tonto.planta(t19, egipto));
		
		System.out.println("\n\n------------ Antes de pasear ---------------\n\n");
		p08.mostrarHuertas(h1, h2);
		System.out.println();
		p08.mostrarHuertas(h3, egipto);
		
		per1.paseo(c2);
		
		System.out.println("\n\n------------ Despues de pasear ---------------\n\n");
		p08.mostrarHuertas(h1, h2);
		System.out.println();
		p08.mostrarHuertas(h3, egipto);
		
		System.out.println("\nCombustible: ");
		for (int i = 0; i < per1.getVehiculo().getCombustible().length; i++)
		{
			if(per1.getVehiculo().getCombustible()[i] == true)
				System.out.print("| ");
			else
				System.out.print("- ");
		}
		
		System.out.println("\nDistancia: "+c.distancia(c2));
		
	}

}
