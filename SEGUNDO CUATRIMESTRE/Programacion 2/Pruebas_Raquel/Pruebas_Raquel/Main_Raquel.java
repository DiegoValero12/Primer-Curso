import java.util.ArrayList;

//usar ArrayList
//import java.util.ArrayList;

//ArrayList
/*
ArrayList<String> coleccion=new ArrayList<String>();//equivale a un array dinamico de cadenas
//.set para poner donde quiera
coleccion.add("Pepe");
coleccion.add("Eva");
int tamanyo=coleccion.size();
for(int i=0;i<tamanyo;i++) {
	System.out.println(coleccion.get(i));
}
*/
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Coordenada
		System.out.println("**COORDENADA**");
		Coordenada coordenada= new Coordenada(0.0, 0.0);
		System.out.println("0,0 igual a 1,2: "+coordenada.iguales(new Coordenada(1,2)));
		System.out.println("0,0 igual a 3,1: "+coordenada.iguales(new Coordenada(3,1)));
		System.out.println("0,0 igual a 0,0: "+coordenada.iguales(new Coordenada(0,0)));
		
		System.out.println("Distancia entre 0,0 y 1,2: "+coordenada.distancia(new Coordenada(1,2)));
		System.out.println("Distancia entre 0,0 y 3,1: "+coordenada.distancia(new Coordenada(3,1)));
		System.out.println("Distancia entre 0,0 y 0,0: "+coordenada.distancia(new Coordenada(0,0)));
		
		
		
		//Valores
		System.out.println("**VALORES**");
		String cadena="";
		double valor=1;
		String fresa="";
		double valor2=0.035;
		System.out.println("Anyadido "+Valores.add(cadena,valor));
		System.out.println("Anyadido "+Valores.add(fresa,valor2));
		System.out.println("Anyadido "+Valores.add("naranja",0));

		System.out.println("Resultado consulta planta: "+Valores.consulta("planta"));
		System.out.println("Resultado consulta naranja: "+Valores.consulta("naranja"));
		
		System.out.println("Nombres y valor:");
		ArrayList<String> nombres=new ArrayList<String>();
		nombres=Valores.getNombres();
		int longitud=nombres.size();
		for(int i=0;i<longitud;i++) {
			System.out.print("	"+nombres.get(i));
			System.out.println("	"+Valores.consulta(nombres.get(i)));
		}
		
		
		
		//Fruto
		System.out.println("**FRUTO**");
		Fruto fruto=new Fruto("pitaya");
		Fruto fruto2=new Fruto("fresa");
		Fruto fruto3=new Fruto("platano");
		
		System.out.println("--Fruto 1--");
		System.out.println("Datos fruto antes de transformar: "+ "Nombre: "+fruto.getNombre()+" Estado: "+fruto.getEstado()+" Peso: "+fruto.getPeso()+" ValorCalorico: "+fruto.valorCalorico());
		System.out.println("Transformar 1: "+fruto.transforma(1));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto.getNombre()+" Estado: "+fruto.getEstado()+" Peso: "+fruto.getPeso()+" ValorCalorico: "+fruto.valorCalorico());//peso y valor calorico igual
		System.out.println("Transformar 2: "+fruto.transforma(2));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto.getNombre()+" Estado: "+fruto.getEstado()+" Peso: "+fruto.getPeso()+" ValorCalorico: "+fruto.valorCalorico());//peso y valor calorico igual
		
		System.out.println("--Fruto 2--");
		System.out.println("Datos fruto antes de transformar: "+ "Nombre: "+fruto2.getNombre()+" Estado: "+fruto2.getEstado()+" Peso: "+fruto2.getPeso()+" ValorCalorico: "+fruto2.valorCalorico());
		System.out.println("Transformar: 1"+fruto2.transforma(3));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto2.getNombre()+" Estado: "+fruto2.getEstado()+" Peso: "+fruto2.getPeso()+" ValorCalorico: "+fruto2.valorCalorico());//peso y valor calorico distinto
		System.out.println("Transformar: 2"+fruto2.transforma(2));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto2.getNombre()+" Estado: "+fruto2.getEstado()+" Peso: "+fruto2.getPeso()+" ValorCalorico: "+fruto2.valorCalorico());//peso y valor calorico distinto
	
		System.out.println("--Fruto 3--");
		System.out.println("Datos fruto antes de transformar: "+ "Nombre: "+fruto3.getNombre()+" Estado: "+fruto3.getEstado()+" Peso: "+fruto3.getPeso()+" ValorCalorico: "+fruto3.valorCalorico());
		System.out.println("Transformar 1: "+fruto3.transforma(3));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto3.getNombre()+" Estado: "+fruto3.getEstado()+" Peso: "+fruto3.getPeso()+" ValorCalorico: "+fruto3.valorCalorico());//peso y valor calorico igual
		System.out.println("Transformar 2: "+fruto3.transforma(3));
		System.out.println("Datos fruto: "+ "Nombre: "+fruto3.getNombre()+" Estado: "+fruto3.getEstado()+" Peso: "+fruto3.getPeso()+" ValorCalorico: "+fruto3.valorCalorico());//peso y valor calorico igual
		
		
		//Planta
		System.out.println("**PLANTA**");
		System.out.println("Nota:Como aun no esta plantada no deberia poderse abonar y el estado se mantiene en semilla");
		Planta peral1=new Planta("peral","pera",3);
		System.out.println("Abonando...");//no esta plantada no se abona
		System.out.println("Abono 1");
		peral1.abona(3);
		System.out.println("Abono 2");
		peral1.abona(3);
		System.out.println("ABONADO");
		System.out.println("Estado de la planta: "+peral1.getEstado());//estado
		System.out.println("Mostrar frutos recolectados: ");
		ArrayList<Fruto> recolectado=peral1.recolecta();//recolecta esta vacio porque no esta plantada
		for(int i=0;i<recolectado.size();i++) {		
			System.out.println("	Posicion "+i+": "+recolectado.get(i).getNombre()+" "+recolectado.get(i).getPeso()+" "+recolectado.get(i).getEstado());
		}
		
		System.out.print("Nombre del fruto: "+peral1.getFruto());//fruto
		System.out.print(" Nombre de la planta: "+peral1.getNombre());//nombre
		System.out.println(" Planta plantada: "+peral1.getPlantada());//plantada
		
		System.out.println("Frutos de la planta:");//no esta plantada entonces no tiene frutos
		for(int i=0;i<peral1.getFrutos().length;i++) {
			if(peral1.getFrutos()[i]!=null)
				System.out.println("	Fruto "+i+": Nombre: "+peral1.getFrutos()[i].getNombre()+" Estado: "+peral1.getFrutos()[i].getEstado()+" Peso: "+peral1.getFrutos()[i].getPeso());
		}
		//abona, arranca, recolecta y getFrutos se comprobara despues en Huerta
		
		System.out.println("**HUERTA**");
		Huerta huerto1=new Huerta(2,4);
		Huerta huerto2=new Huerta(0,2);
		Planta manza1=new Planta("manzano","manzana",2);
		Planta manza2=new Planta("manzano","manzana",3);
		Planta nogal1=new Planta("nogal","nuez",2);
		Planta nogal2=new Planta("nogal","nuez",2);
		Planta nogal3=new Planta("nogal","nuez",2);
		Planta peral2=new Planta("peral","pera",4);
		Planta peral3=new Planta("peral","pera",1);
		Planta peral4=new Planta("peral","pera",1);
		Planta peral5=new Planta("peral","pera",4);
		Planta plata1=new Planta("platanero","platano",3);

		System.out.println("Plantar "+peral1.getNombre()+": "+huerto1.planta(peral1));//true
		System.out.println("Plantar "+manza1.getNombre()+": "+huerto1.planta(manza1));//true
		System.out.println("Plantar "+peral2.getNombre()+": "+huerto1.planta(peral2));//true
		System.out.println("Plantar "+peral3.getNombre()+": "+huerto1.planta(peral3));//true
		System.out.println("Plantar "+peral1.getNombre()+": "+huerto1.planta(peral1));//plantada ya//false
		System.out.println("Plantar "+nogal1.getNombre()+": "+huerto1.planta(nogal1));//no cabe en el huerto//false
		System.out.println("Plantar "+peral4.getNombre()+": "+huerto1.planta(peral4));//true
		System.out.println("Plantar "+peral5.getNombre()+": "+huerto1.planta(peral5));//falsa//no cabe fila
		
		System.out.println("Plantar "+nogal2.getNombre()+": "+huerto2.planta(nogal2));//true
		System.out.println("Plantar "+manza2.getNombre()+": "+huerto2.planta(manza2));//true
		System.out.println("Plantar "+nogal1.getNombre()+": "+huerto2.planta(nogal1));//true
		System.out.println("Plantar "+nogal3.getNombre()+": "+huerto2.planta(nogal3));//no cabe en la fila//false
		System.out.println("Plantar "+plata1.getNombre()+": "+huerto2.planta(plata1));//no cabe en el huerto//false (no se planta en ningun momento)
		
		System.out.print("Huerto 1:");
		for(int i=0;i<huerto1.getHuerto().length;i++) {
			System.out.print("\n[ "+i+" ] :");
			for(int j=0;j<huerto1.getHuerto()[i].length;j++) {
				if(huerto1.getHuerto()[i][j]!=null) {
					System.out.print(" "+huerto1.getHuerto()[i][j].getNombre());
				}
				else
					System.out.print(" null");
			}
		}
		
		System.out.print("\nHuerto 2:");
		for(int i=0;i<huerto2.getHuerto().length;i++) {
			System.out.print("\n[ "+i+" ] :");
			for(int j=0;j<huerto2.getHuerto()[i].length;j++) {
				if(huerto2.getHuerto()[i][j]!=null) {
					System.out.print(" "+huerto2.getHuerto()[i][j].getNombre());
				}
				else
					System.out.print(" null");
			}
		}
		
		System.out.println("\nConsulta huerto1 fila 2 columna 3: "+huerto1.consulta(2, 3));//debe devolver null, la fila demasiado grande
		System.out.println("Consulta huerto1 fila 0 columna 3: "+huerto1.consulta(0, 3));//manzano
		System.out.println("Consulta huerto1 fila 1 columna 1: "+huerto1.consulta(1, 1));//peral
		System.out.println("Consulta huerto1 fila 0 columna 1: "+huerto1.consulta(0, 1));//null
		
		System.out.println("A ver si arranca las plantas...");
		if(manza1.getPlantada()!=null)
			System.out.println("manza1 plantada");
		else
			System.out.println("manza1 no plantada");
		System.out.println("Planta arrancada: "+huerto1.arranca("manzano", 0, 3).getNombre());
		if(manza1.getPlantada()!=null)
			System.out.println("manza1 plantada");
		else
			System.out.println("manza1 no plantada");
		
		System.out.println("VAMOS A ABONAR");
		System.out.println("Abonando...");
		System.out.print("Abono 1: ");
		System.out.println(huerto2.abona(3, "nogal"));//germinado
		System.out.print("Abono 2: ");
		System.out.println(huerto2.abona(3, "nogal"));//brote
		System.out.print("Abono 3: ");
		System.out.println(huerto2.abona(3, "nogal"));//adulta
		System.out.print("Abono 4: ");
		System.out.println(huerto2.abona(3, "nogal"));//1 fruto
		System.out.print("Abono 5: ");
		System.out.println(huerto2.abona(3, "nogal"));//0.6
		System.out.print("Abono 6: ");
		System.out.println(huerto2.abona(3, "nogal"));//1.2 0.6
		System.out.print("Abono 7: ");
		System.out.println(huerto2.abona(1, "nogal"));//suelo 0.8
		System.out.print("Abono 8: ");
		System.out.println(huerto2.abona(4, "nogal"));//frutos 1.6
		System.out.print("Abono 9: ");
		System.out.println(huerto2.abona(4, "manzano"));//germinado
		System.out.print("Abono 10: ");
		System.out.println(huerto2.abona(4, "manzano"));//brote
		System.out.print("Abono 11: ");
		System.out.println(huerto2.abona(4, "manzano"));//adulta
		System.out.print("Abono 12: ");
		System.out.println(huerto2.abona(4, "manzano"));//fruto
		System.out.print("Abono 13: ");
		System.out.println(huerto2.abona(5, "platano"));//-> no esta dentro del huerto
		//abono frutos individuales para ver la diferencia de peso
		System.out.print("Abono 14: ");
		System.out.println(nogal1.abona(5));
		
		System.out.println("ABONADO");
		System.out.println("Estado de la nogal1: "+nogal1.getEstado()+" Fruto: "+nogal1.getFruto());
		System.out.println("Estado de la nogal2: "+nogal2.getEstado()+" Fruto: "+nogal2.getFruto());
		System.out.println("Estado de la plata1: "+plata1.getEstado()+" Fruto: "+plata1.getFruto());
		
		System.out.println("Plantas adultas:");
		for(int i=0;i<huerto2.getAdultas().size();i++) {
			System.out.println("Adulta "+(i+1)+": "+huerto2.getAdultas().get(i));
		}
		
		System.out.println(huerto2.getHuerto()[1][1].getFruto());
		String recojo="nuez";
		System.out.println("Mostrar frutos recolectados: ");
		ArrayList<Fruto> recolectado2=huerto2.recolecta(recojo);
		for(int i=0;i<recolectado2.size();i++) {
			System.out.println("	Posicion "+i+": "+recolectado2.get(i).getNombre()+" "+recolectado2.get(i).getPeso()+" "+recolectado2.get(i).getEstado());
		}
		
		huerto1.localiza(2, 3);
		huerto2.localiza(20, -10);
		System.out.println("Localizacion huerto1: "+huerto1.getLocalizacion());
		System.out.println("Localizacion huerto2: "+huerto2.getLocalizacion());
		
		System.out.println("Localizadas:");
		for(int i=0;i<Huerta.getLocalizadas().size();i++) {
			System.out.println("	Huerto "+i+": "+Huerta.getLocalizadas().get(i));
		}
		
		System.out.println("**PERSONA**");
		String persona=new String("Miguel");
		Persona jhon=new Persona(null);
		Persona lara=new Persona("Lara");
		Persona miguel=new Persona(persona);
		
		Huerta huerto3=new Huerta(1,1);
		huerto3.localiza(10, 5);
		System.out.println("Localizacion huerto3: "+huerto3.getLocalizacion());
		
		System.out.println(jhon.getNombre()+" planta en huerta 3: "+jhon.planta(plata1, huerto3));//true
		System.out.println("Coordenadas Jhon: "+jhon.paseo()+" Cuidador de huerto1: "+huerto1.getCuidador().getNombre());//coincide con huerto1
		System.out.println("Coordenadas Lara: "+lara.paseo()+" Cuidador de huerto2: "+huerto2.getCuidador().getNombre());//coincide con huerto2
		System.out.println("Coordenadas Miguel: "+miguel.paseo()+" Cuidador de huerto3: "+huerto3.getCuidador().getNombre());//coincide con huerto3
		
		System.out.println("Huerta Jhon: "+jhon.getHuerta());
		System.out.println("Huerta Lara: "+lara.getHuerta());
		System.out.println("Huerta Miguel: "+miguel.getHuerta());
		
		//malasHierbas
		System.out.println("VAMOS A ABONAR");
		System.out.println("Abonando...");
		System.out.print("Abona 1: ");
		System.out.println(jhon.abona(3, "nogal"));//0
		System.out.print("Abona 2: ");
		System.out.println(jhon.abona(3, null));//0
		System.out.print("Abona 3: ");
		System.out.println(jhon.abona(3, "peral"));//4<-germinado
		System.out.print("Abona 4: ");
		System.out.println(jhon.abona(3, "peral"));//4<-brote
		System.out.print("Abona 5: ");
		System.out.println(jhon.abona(3, "peral"));//4<-adulta
		System.out.print("Abona 6: ");
		System.out.println(miguel.abona(3, "platanero"));//1<-germinado
		System.out.print("Abona 7: ");
		System.out.println(miguel.abona(3, "platanero"));//1<-brote
		System.out.print("Abona 8: ");
		System.out.println(miguel.abona(3, "platanero"));//1<-adulta
		System.out.println("ABONADO");
	
		System.out.println("Malas hierbas:");
		ArrayList<Planta> malas=new ArrayList<Planta>();
		malas=jhon.malasHierbas();
		
		for(int i=0;i<malas.size();i++) {
			System.out.println("i: "+i);
			System.out.println(malas.get(i).getNombre()+" "+malas.get(i).getPlantada()+" "+malas.get(i).getEstado());
		}
		//persona puede plantar en una huerta que no es suya??
		//comprobar el orden de recoleta si hay dos pesos iguales
	}

}
