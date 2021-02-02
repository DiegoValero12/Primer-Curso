import java.util.ArrayList;
public class Prueba {
	public static void main(String[] args) {
		Coordenada corMala1 = new Coordenada(-91, 20); //el primer valor deberia estar entre -90 y 90
		Coordenada corMala2 = new Coordenada(35, 182); //el segundo valor deberia estar entre -180 y 180
		Coordenada corBuena1 = new Coordenada(40, 100);
		Coordenada corBuena2 = new Coordenada(34, 90);
		Coordenada corMala3 = null;
		System.out.println(corBuena1.iguales(corMala3) + " IGUALES COORDENADA FALSE");//Si salta Null pointer en esta linea comprueba que no te puedan meter null en iguales
		System.out.println(corBuena1.distancia(corMala3) + " DISTANCIA COORDENADA -1.0");//Si salta Null pointer en esta linea comprueba que no te puedan meter null en distancia
		
		String s = "Pera";
		double d = -2;
		String s2 = "Piña";
		double d2 = -4.3;
		double d3 = -3;
		String s3 = "kiwi";
		String s4 = "naranja";
		String cadenaMala = null;
		String cadenaMala2 = "";
		double valorMalo = -2;
	
		Valores.add(s4, d2);
		Valores.add(s, d);
		Valores.add(s2, d2);
		Valores.add(s3, d2);
		Valores.add(cadenaMala, valorMalo);//Si te salta error en esta linea deberias comprobar tu constructor de relacion y ver que no te puedan meter valores incorrectos
		
		System.out.println(Valores.consulta(cadenaMala) + " -1.0");//Si te da error aqui comprueba el metodo consulta
		System.out.println(Valores.consulta("alcachofa") + " -1.0");//Aqui el valor deberia ser -1.0
		
		Fruto pera = new Fruto("pera");
		Fruto naranja = new Fruto("naranja");
		Fruto pina = new Fruto("piña");
		Fruto kiwi = new Fruto("kiwi");
		Fruto malo = new Fruto("alcachofa");
		Fruto malo2 = new Fruto(cadenaMala);
		System.out.println("MALO " + malo.getNombre() + " PITAYA " + malo.getPeso() + " 0 " + malo.getEstado() + " INMADURO ");
		System.out.println("MALO2 " + malo2.getNombre() + " PITAYA " + malo2.getPeso() + " 0 " + malo2.getEstado() + " INMADURO ");
		
		System.out.println(kiwi.getPeso() + " PESO 0");
		kiwi.transforma(-2);
		System.out.println(kiwi.getPeso() + " PESO 0");
		kiwi.transforma(10);
		System.out.println(kiwi.getPeso() + " PESO 2");
		
		Planta naranjo= new Planta ("naranjo","naranja",7);
		Planta peral = new Planta("peral", "pera", 5);
		Planta mala1 = new Planta(cadenaMala, "kiwi", 3);
		Planta mala2 = new Planta("actinida", cadenaMala2, 4);
		Planta mala3 = new Planta("planta", "piña", -2);
		Planta plantaNula = null;
		System.out.println("PlantaMala1 " + mala1.getNombre() + " VEGETAL " + mala1.getFruto() + " KIWI " + mala1.getFrutos().length + " 3");
		System.out.println("PlantaMala1 " + mala2.getNombre() + " ACTINIDA " + mala2.getFruto() + " pitaya " + mala2.getFrutos().length + " 4");
		System.out.println("PlantaMala1 " + mala3.getNombre() + " PLANTA " + mala3.getFruto() + " PIÑA " + mala3.getFrutos().length + " 1");
		
		Huerta hu1 = new Huerta(3, 3);
		Huerta hu2 = new Huerta(4, 3);
		Huerta huMala1 = new Huerta(-2, 4);
		Huerta huMala2 = null;
 		hu1.planta(peral);
		hu1.planta(naranjo);
		
		System.out.println(huMala1.getHuerto().length + " 2");
		
		//Preguntar que ocurre si se establece como setPlantada una huerta con valor null
		peral.setPlantada(huMala2);
		peral.abona(30);
		peral.abona(40);
		peral.abona(50);
		peral.abona(60);
		
		hu1.planta(plantaNula);//Si da Null pointer en esta linea debes comprobar que no te puedan pasar una planta con valor null
		hu1.planta(mala3);
		hu1.recolecta(cadenaMala);//Si da Null pointer en esta linea comprueba que no te puedan pasar un valor null en el metodo recolecta
		hu1.abona(-2, "peral");
		hu1.abona(20, cadenaMala);
		System.out.println(hu1.consulta(-2, 3));//Si da Null pointer en esta linea comprueba que no te puedan pasar un null en el metodo consulta de Huerta, si te da un IndexOutOfBounds comprueba que no te puedan pasar numeros mayores que tu matriz
		hu1.arranca(cadenaMala, 2, 2);//Si te da Null pointer aqui comprueba que no te puedan pasar una cadena null o vacia en el metodo arranca
		hu1.arranca("peral", 3, -2);//Si te da Null pointer aqui comprueba que la posicion que te estan pasando para arrancar no sea null
	
		Persona Alicia = new Persona(cadenaMala);//Si te da Null pointer aqui comprueba que no te puedan pasar una cadena null en el constructor de Persona
		Persona David = new Persona("Farravid");
		System.out.println(Alicia.getNombre() + " JOHN DOE " + David.getNombre() + " FARRAVID");
		
		David.planta(peral, huMala2);//Si te da Null pointer comprueba que no te puedan pasar un huerto null en el metodo planta de Persona
		
		David.paseo();
		
	}
}
