import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
 

// PRUEBAS PARA COMPROBAR ZOMBIE

public class p06 {

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
	  private static ArrayList<Planta> creaSemillas(){
	    String[] fruta={"ciruela","tomate","papaya","fresa","naranja","mandarina","platano","manzana","uva","cereza"};
	    String[] planta={"ciruelo","tomatera","carica","fragaria","naranjo","mandarino","platanero","manzano","vid","cerezo"};
	    ArrayList<Planta> plantas=new ArrayList<>();
	    int cont=0;
	    for(int i=0;i<fruta.length&&i<planta.length;i++)
	     if(i%5==0)
	      plantas.add(new Trifido(new String(planta[i]),new String(fruta[i]),i));
	     else
	      plantas.add(new Planta(new String(planta[i]),new String(fruta[i]),i));
	    cont=5;
	    for(int i=0;i<fruta.length&&i<planta.length;i++){
	      plantas.add(new Planta(new String(planta[i]),new String(fruta[i]),cont));
	    }
	    cont=1;
	    for(int i=fruta.length-1;i>=planta.length/2;i--){
	      plantas.add(new Planta(new String(planta[i]),new String(fruta[i]),cont));
	      cont++;
	    }
	    return plantas;
	  }

	  private static void generaRelaciones(){
	    String[] fruta={"ciruela","tomate","papaya","fresa","naranja","mandarina","platano","manzana","uva","cereza"};
	    double valor=0;
	    for(int i=0;i<fruta.length;i++){
	       valor=(fruta[i].length()*0.5)/100.0;
	       Valores.add(fruta[i],valor);
	    }
	  }
	  private static void consultaFruto(Fruto f){
	    if(f!=null){
	      System.out.print("nombre: "+f.getNombre()+"; peso: "+p06.mrf(f.getPeso())+"; estado: "+f.getEstado());
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
	           p06.consultaFruto(producted[i]);
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
	          p06.consultaPlanta(h[i][j]);
	        }
	      }
	    }
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
	
	public static void main(String[] args) 
	{
		ArrayList<Planta> plantitas=p06.creaSemillas();
	    p06.generaRelaciones();
	    Huerta finca=new Huerta(8,4);
	    Huerta campo=new Huerta(2,2);
	    Persona tontito = new Persona("Perez");
	    Persona tontito2 = new Persona("Marin");
	    p06.localiza(finca,campo);
	    tontito.paseo();
	    tontito2.paseo();
	    Trifido p1 = new Trifido("a","a", 1); 
	    Planta p2 = new Planta("b","b", 2);
	    System.out.println("Se ha plantado "+ p1.getNombre() +"? -> "+ tontito.planta(p1, finca));
	    System.out.println("Se ha plantado "+ p2.getNombre() +"? -> "+ tontito.planta(p2, finca));
	    boolean change=false;
	    for(int i=0;i<plantitas.size();i++){
	      change=finca.planta(plantitas.get(i));
	      if(change)
	       System.out.println("Se ha plantado la "+plantitas.get(i).getNombre()+"? -> "+change);
	      else{
	        change=campo.planta(plantitas.get(i));
	        System.out.println("Se ha plantado la "+plantitas.get(i).getNombre()+"? -> "+change);
	      }
	    }
	    System.out.println("-------- Estado de las fincas despues de plantar ------------------------");
	    System.out.println("ORIGEN:");
	    p06.consultaCuidador(finca);
	    p06.consultaHuerto(finca.getHuerto());
	    System.out.println("DESTINO:");
	    p06.consultaCuidador(campo);
	    p06.consultaHuerto(campo.getHuerto());
	    
	   
	    System.out.println(tontito2.abona(10,"mandarino"));
	    
	    System.out.println("-------- Estado de las fincas despues de abonar zombie ------------------------");
	    
	    System.out.println("ORIGEN:");
	    p06.consultaCuidador(finca);
	    p06.consultaHuerto(finca.getHuerto());
	    System.out.println("DESTINO:");
	    p06.consultaCuidador(campo);
	    p06.consultaHuerto(campo.getHuerto());
	    
	    Zombie temp = (Zombie) finca.getCuidador();
	    System.out.println(temp.abona());
	    
	    System.out.println("-------- Estado de las fincas despues de abonar x 2 zombie ------------------------");
	    System.out.println("ORIGEN:");
	    p06.consultaCuidador(finca);
	    p06.consultaHuerto(finca.getHuerto());
	    System.out.println("DESTINO:");
	    p06.consultaCuidador(campo);
	    p06.consultaHuerto(campo.getHuerto());
	   
	    System.out.println("-------- Paseo de zombie ------------------------");
	    Coordenada prueba = new Coordenada(0,39);
	    System.out.println("0 , 39 ? : " + temp.paseo().iguales(prueba));
	    
	    System.out.println("-------- Se abona el huerto (fragaria) y se arrancan las malas hierbas por zombie ------------------------");
	    finca.abona(10, "fragaria");
	    finca.abona(10, "fragaria");
	    finca.abona(10, "fragaria");
	    finca.abona(10, "fragaria");
	    
	    ArrayList<Planta> malas = temp.malasHierbas();
	    
	    
	    System.out.println("\nMalas: ");
	    for (int i = 0; i < malas.size(); i++) 
			p06.consultaPlanta(malas.get(i));
	    
	    System.out.println("\nORIGEN:");
	    p06.consultaHuerto(finca.getHuerto());
	    
	    
	    
	}

}
