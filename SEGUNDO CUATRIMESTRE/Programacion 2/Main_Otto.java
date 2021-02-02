import java.util.ArrayList;
public class Main_Otto {
	public static void main(String[] args) {
		System.out.println("Vamos a jugar farming Simulator 2.0\n");
		System.out.println("Primero vamos a crear nuestra clasificación de valores: ");
		System.out.println("Creación 1 : " + Valores.add("fresa", 0.6));
		System.out.println("Creación 1 : " + Valores.add("piña", 1.2));
		System.out.println("Creación 1 : " + Valores.add("kiwi", 0.4));
		System.out.println("Creación 1 : " + Valores.add("higo", 0.5));
		System.out.println("Creación 1 : " + Valores.add("mango maracatón", 1.3) + "\n");
		System.out.println("Revisemos nuestra clasificación ;)");
		
		ArrayList<String> nombresV = Valores.getNombres();
		for(int i = 0; i < Valores.getClasificacion().size(); i++) {
			System.out.println("Nombre : " + nombresV.get(i) + " Valor calórico : " + Valores.consulta(nombresV.get(i)));
		}
		
		System.out.println("\nEsto no sería farming Simulator sin nuestras huertas....");
		
		Huerta huPeque = new Huerta(2, 2);
		Huerta huMed = new Huerta(4, 4);
		Huerta huGr = new Huerta(6, 6);
		
		System.out.println("¡HUERTAS CREADAS! Ahora necesitamos gente que nos las cuide\n");
		
		Persona alicia = new Persona("Alicia");
		Persona david = new Persona("David");
		Persona rodro = new Persona("Rodro");
		
		System.out.println("Esta es la gente que hemos contratado: ");
		System.out.println("Cuidador 1 : " + david.getNombre());
		System.out.println("Cuidador 2 : " + alicia.getNombre());
		System.out.println("Cuidador 3 : " + rodro.getNombre());
		
		System.out.println("\nAhora asignémosles una huerta: ");
		System.out.println("David como está to' fuerte lo pondremos a cuidar la huerta grande");
		huGr.localiza(-20, -150);
		david.paseo();
		System.out.println("Rodro es un poco vago cuando quiere, así que lo pondremos a cuidar la huerta pequeña");
		huPeque.localiza(50, 76);
		rodro.paseo();
		
		System.out.println("\nUna huerta no puede cuidarse decentemente si no tiene un lugar donde estar, así que vamos a ponerlas en algún sitio....");
		huMed.localiza(80, 120);
		System.out.println("Ya las hemos colocado, comprobemos dónde está cada una: ");
		System.out.println("Localización de la huerta Grande : " + huGr.getLocalizacion());
		System.out.println("Localización de la huerta Mediana : " + huMed.getLocalizacion());
		System.out.println("Localización de la huerta Pequeña : " + huPeque.getLocalizacion());
		
		System.out.println("\nOH NO!! ALICIA NO TIENE HUERTA! BUSQUEMOS UNA HUERTA PARA ELLA!");
		System.out.println("Le hemos asignado una huerta situada en : " + alicia.paseo());
		
		System.out.println("\nAhora veamos quién cuida cada huerta : ");
		System.out.println("Cuidador de la huerta grande : " + huGr.getCuidador().getNombre());
		System.out.println("Cuidador de la huerta mediana : " + huMed.getCuidador().getNombre());
		System.out.println("Cuidador de la huerta pequeña : " + huPeque.getCuidador().getNombre());
		
		System.out.println("\nYa tenemos nuestras huertas con unos buenos cuidadores, pero necesitamos algunas plantas...");
		Planta actinida1 = new Planta("actinida", "kiwi", 5);
		Planta actinida2 = new Planta("actinida", "kiwi", 5);
		Planta actinida3 = new Planta("actinida", "kiwi", 5);
		Planta fragaria1 = new Planta("fragaria", "fresa", 4);
		Planta fragaria2 = new Planta("fragaria", "fresa", 4);
		Planta fragaria3 = new Planta("fragaria", "fresa", 4);
		Planta fragaria4 = new Planta("fragaria", "fresa", 5);
		Planta higuera = new Planta("higuera", "higo", 6);
		Planta pinya = new Planta("piña", "piña", 1);
		Planta mangifera = new Planta("mangifera", "mango maracatón", 2);
		System.out.println("Hemos conseguido algunas plantas! Pongámoslas en alguna huerta!\n");
		
		System.out.println("David planta actinida1 en su huerta : " + david.planta(actinida1, huGr));
		System.out.println("David planta actinida2 en su huerta : " + david.planta(actinida2, huGr));
		System.out.println("David planta actinida3 en su huerta : " + david.planta(actinida3, huGr));
		System.out.println("Alicia planta fragaria1 en su huerta : " + alicia.planta(fragaria1, huMed));
		System.out.println("Alicia planta fragaria2 en su huerta : " + alicia.planta(fragaria2, huMed));
		System.out.println("Rodro planta higuera1 en su huerta : " + rodro.planta(higuera, huPeque));
		System.out.println("Rodro planta fragaria3 en su huerta : " + rodro.planta(fragaria3, huPeque));
		System.out.println("Rodro planta fragaria4 en su huerta : " + rodro.planta(fragaria4, huPeque));
		System.out.println("Rodro planta mangifera en su huerta : " + rodro.planta(mangifera, huPeque) + " NO SE PUEDE PLANTAR!!");
		
		System.out.println("Ya tenemos alguna planta en nuestras huertas, ES HORA DE ABONARLAS");
		System.out.println("Actínidas abonadas en la huerta de David : " + david.abona(10, "actinida"));
		System.out.println("Fragarias abonadas en la huerta de Alicia : " + alicia.abona(10, "fragaria"));
		System.out.println("Higueras abonadas en la huerta de Rodro : " + rodro.abona(10, "higuera"));
		System.out.println("Fragarias abonadas en la huerta de Rodro : " + rodro.abona(10, "fragaria"));
		System.out.println("\nAhora las iremos abonando y comprobando sus estados");
		System.out.println("Actínida 1 : " + actinida1.getEstado());
		System.out.println("Actínida 2 : " + actinida2.getEstado());
		System.out.println("Actínida 3 : " + actinida3.getEstado());
		System.out.println("Fragaria 1 : " + fragaria1.getEstado());
		System.out.println("Fragaria 2 : " + fragaria2.getEstado());
		System.out.println("Fragaria 3 : " + fragaria2.getEstado());
		System.out.println("Fragaria 4 : " + fragaria2.getEstado());
		System.out.println("Higuera : " + higuera.getEstado());
		
		david.abona(10, "actinida");
		alicia.abona(10, "fragaria");
		rodro.abona(10, "higuera");
		rodro.abona(10, "fragaria");
		System.out.println("\nActínida 1 : " + actinida1.getEstado());
		System.out.println("Actínida 2 : " + actinida2.getEstado());
		System.out.println("Actínida 3 : " + actinida3.getEstado());
		System.out.println("Fragaria 1 : " + fragaria1.getEstado());
		System.out.println("Fragaria 2 : " + fragaria2.getEstado());
		System.out.println("Fragaria 3 : " + fragaria2.getEstado());
		System.out.println("Fragaria 4 : " + fragaria2.getEstado());
		System.out.println("Higuera : " + higuera.getEstado());
		
		david.abona(10, "actinida");
		alicia.abona(10, "fragaria");
		rodro.abona(10, "higuera");
		rodro.abona(10, "fragaria");
		System.out.println("\nActínida 1 : " + actinida1.getEstado());
		System.out.println("Actínida 2 : " + actinida2.getEstado());
		System.out.println("Actínida 3 : " + actinida3.getEstado());
		System.out.println("Fragaria 1 : " + fragaria1.getEstado());
		System.out.println("Fragaria 2 : " + fragaria2.getEstado());
		System.out.println("Fragaria 3 : " + fragaria2.getEstado());
		System.out.println("Fragaria 4 : " + fragaria2.getEstado());
		System.out.println("Higuera : " + higuera.getEstado());
		
		System.out.println("\nAhora que son adultas vamos a ir abonándolas y comprobando sus frutos");
		david.abona(13, "actinida");
		alicia.abona(20, "fragaria");
		rodro.abona(15, "fragaria");
		
		System.out.println("\n**HUERTO GRANDE : ");
		for(int i = 0; i < huGr.getHuerto().length; i++) {
			for(int j = 0; j < huGr.getHuerto()[i].length; j++) {
				if(huGr.getHuerto()[i][j] != null) {
					System.out.println(huGr.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huGr.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huGr.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huGr.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huGr.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huGr.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO MEDIANO : ");
		for(int i = 0; i < huMed.getHuerto().length; i++) {
			for(int j = 0; j < huMed.getHuerto()[i].length; j++) {
				if(huMed.getHuerto()[i][j] != null) {
					System.out.println(huMed.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huMed.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huMed.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huMed.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huMed.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huMed.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO PEQUEÑO : ");
		for(int i = 0; i < huPeque.getHuerto().length; i++) {
			for(int j = 0; j < huPeque.getHuerto()[i].length; j++) {
				if(huPeque.getHuerto()[i][j] != null) {
					System.out.println(huPeque.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huPeque.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huPeque.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huPeque.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huPeque.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huPeque.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		
		System.out.println("\n VOLVEMOS A ABONAR !!!");
		david.abona(13, "actinida");
		alicia.abona(20, "fragaria");
		rodro.abona(15, "fragaria");
		
		System.out.println("\n**HUERTO GRANDE : ");
		for(int i = 0; i < huGr.getHuerto().length; i++) {
			for(int j = 0; j < huGr.getHuerto()[i].length; j++) {
				if(huGr.getHuerto()[i][j] != null) {
					System.out.println(huGr.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huGr.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huGr.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huGr.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huGr.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huGr.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO MEDIANO : ");
		for(int i = 0; i < huMed.getHuerto().length; i++) {
			for(int j = 0; j < huMed.getHuerto()[i].length; j++) {
				if(huMed.getHuerto()[i][j] != null) {
					System.out.println(huMed.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huMed.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huMed.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huMed.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huMed.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huMed.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO PEQUEÑO : ");
		for(int i = 0; i < huPeque.getHuerto().length; i++) {
			for(int j = 0; j < huPeque.getHuerto()[i].length; j++) {
				if(huPeque.getHuerto()[i][j] != null) {
					System.out.println(huPeque.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huPeque.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huPeque.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huPeque.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huPeque.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huPeque.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		
		System.out.println("\n VOLVEMOS A ABONAR !!!");
		david.abona(13, "actinida");
		alicia.abona(20, "fragaria");
		rodro.abona(15, "fragaria");
		
		System.out.println("\n**HUERTO GRANDE : ");
		for(int i = 0; i < huGr.getHuerto().length; i++) {
			for(int j = 0; j < huGr.getHuerto()[i].length; j++) {
				if(huGr.getHuerto()[i][j] != null) {
					System.out.println(huGr.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huGr.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huGr.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huGr.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huGr.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huGr.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO MEDIANO : ");
		for(int i = 0; i < huMed.getHuerto().length; i++) {
			for(int j = 0; j < huMed.getHuerto()[i].length; j++) {
				if(huMed.getHuerto()[i][j] != null) {
					System.out.println(huMed.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huMed.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huMed.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huMed.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huMed.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huMed.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		System.out.println("\n**HUERTO PEQUEÑO : ");
		for(int i = 0; i < huPeque.getHuerto().length; i++) {
			for(int j = 0; j < huPeque.getHuerto()[i].length; j++) {
				if(huPeque.getHuerto()[i][j] != null) {
					System.out.println(huPeque.getHuerto()[i][j].getNombre());
					for(int k = 0; k < huPeque.getHuerto()[i][j].getFrutos().length; k ++) {
						if(huPeque.getHuerto()[i][j].getFrutos()[k] != null) {
							System.out.println("Fruto " + k + " Nombre : " + huPeque.getHuerto()[i][j].getFrutos()[k].getNombre() + " Peso : " + huPeque.getHuerto()[i][j].getFrutos()[k].getPeso() + " Estado : " + huPeque.getHuerto()[i][j].getFrutos()[k].getEstado());
						}
					}
				}
			}
		}
		
		System.out.println("\nSomos unos magníficos videojugadores de farming Simulator 2.0\n");
		
		System.out.println("Rodro ha recibido un encargo!! TIENE QUE PLANTAR UNA MANGIFERA PERO SE HA DORMIDO!!!");
		System.out.println("David tendrá que ir a hacer el encargo, pero no sabe cuánta distancia hay de su huerta hasta la de Rodro, vamos a calcularla : ");
		System.out.println("Distancia entre la huerta de David y la de Rodro : " + String.format("%.2f", david.getHuerta().getLocalizacion().distancia(rodro.getHuerta().getLocalizacion())) + "m");
		System.out.println("David ha llegado a la huerta de Rodro, pero no hay sitio para plantar, así que despierta a Rodro y le dice que arranque una planta que no tenga frutos");
		System.out.println("Rodro arranca las plantas sin frutos (malas hierbas)");
		ArrayList<Planta> arrancadas = new ArrayList<>();
		arrancadas = rodro.malasHierbas();
		System.out.println("\nPlantas arrancadas : ");
		for(int i = 0; i < arrancadas.size(); i++) {
			System.out.println(arrancadas.get(i).getNombre());
		}
		System.out.println("\nAhora que hemos arrancado la planta David puede plantar la otra");
		System.out.println("David planta la mangifera en la huerta de Rodro : " + david.planta(mangifera, rodro.getHuerta()));
		System.out.println("David vuelve a su huerta");
		
		System.out.println("Alicia se ha dado una vuelta por su huerto y ha visto que hay algunas fresas que parece que ya están maduras así que va a recolectarlas");
		ArrayList<Fruto> recolectados = new ArrayList<>();
		recolectados = alicia.getHuerta().recolecta("fresa");
		System.out.println("\nVamos a ver qué frutos ha conseguido recolectar el npc Alicia");
		for(int i = 0; i < recolectados.size(); i++) {
			System.out.println("Nombre : " + recolectados.get(i).getNombre() + i + "    Peso : " + recolectados.get(i).getPeso());
		}
		
		System.out.println("\nDavid quiere saber qué plantas de su huerta son adultas");
		System.out.println("Plantas adultas del huerto de David");
		ArrayList<String> adultas = new ArrayList<>();
		adultas = david.getHuerta().getAdultas();
		for(int i = 0; i < adultas.size(); i++) {
			System.out.println("Nombre : " + adultas.get(i));
		}
 		System.out.println("\nGUARDANDO PARTIDA...");
		System.out.println("SALIENDO AL ESCRITORIO...");
	}
}
