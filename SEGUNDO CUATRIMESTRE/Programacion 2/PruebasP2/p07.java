	import java.text.DecimalFormat;
	import java.text.DecimalFormatSymbols;
	import java.util.Locale;
	
	// PRUEBAS PARA COMPROBAR TRIFIDO
	
public class p07 {

	
	private static String mrf(double db){
		Locale lengua=new Locale("en");
		DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
		DecimalFormat formato=new DecimalFormat("0.000",chars);

		return(formato.format(db).toString());
	}
	  private static void consultaFruto(Fruto f){
	    if(f!=null){
	      System.out.print("nombre: "+f.getNombre()+"; peso: "+p07.mrf(f.getPeso())+"; estado: "+f.getEstado());
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
	           p07.consultaFruto(producted[i]);
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
	          p07.consultaPlanta(h[i][j]);
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
		 p07.mostrarGrafico(h1);
		 p07.consultaCuidador(h1);
		 p07.consultaHuerto(h1.getHuerto());

		 System.out.println("\nHuerta 2: ");
		 p07.mostrarGrafico(h2);
		 p07.consultaCuidador(h2);
		 p07.consultaHuerto(h2.getHuerto());
		 
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
		
		Planta p1 = new Trifido("a","a", 1);
		Planta p2 = new Planta("b","b", 2);
		Planta p3 = new Planta("a","c", 3);
		Planta p4 = new Trifido("b","d", 4);
		Planta p5 = new Planta("b","e", 5);
		Planta p6 = new Planta("b","f", 6);
		Trifido p7 = new Trifido("c","g",7);
		
		Huerta h1 = new Huerta(3,3);
		Huerta h2 = new Huerta(3,3);
		
		Persona per1 = new Persona("Jonathan");
		Persona per2 = new Persona("Dio");
		
		h1.localiza(1, 1);
		h2.localiza(2, 2);
		
		
		
		System.out.println("Se planta " + p1.getNombre() + "1 : " + h1.planta(p1));
		System.out.println("Se planta " + p2.getNombre() + "2 : " + h1.planta(p2));
		System.out.println("Se planta " + p3.getNombre() + "3 : " + h1.planta(p3));
		System.out.println("Se planta " + p4.getNombre() + "4 : " + h1.planta(p4));
		System.out.println("Se planta " + p5.getNombre() + "5 : " + h1.planta(p5));
		System.out.println("Se planta " + p6.getNombre() + "6 : " + h1.planta(p6));
		System.out.println("Otea " + p6.getNombre() + "7 : " + p7.otea());
		System.out.println();
		
		System.out.println("\n\n---------  Inicio ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
		p1.abona(10);
		System.out.println("\n\n---------  Sin ningun cuidador ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
	    per1.paseo();
	    per2.paseo();
		
		((Trifido)p1).abona();
		System.out.println("\n\n---------  Despues de abonar() el Trifido 1 ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
		p1.abona(10);
		System.out.println("\n\n---------  Despues de abonar(int n) el Trifido 1  ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
		
		((Trifido) p4).abona();
		p4.abona(10);
		System.out.println("\n\n--------- Ahora la h1 tiene cuidador y p4 se ha comido plantas. Se abona(int n)  ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
		h1.getHuerto()[1][1].recolecta();
		System.out.println("\n\n--------- Recolecta en h1  ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
		
		h2.getHuerto()[0][0].arranca();
		System.out.println("\n\n--------- Arranca en h2  ----------------\n\n");
		p07.mostrarHuertas(h1, h2);
	}

}
