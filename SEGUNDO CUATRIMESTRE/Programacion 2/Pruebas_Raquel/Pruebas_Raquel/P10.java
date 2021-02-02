import java.util.ArrayList;

/*
 * Se crean varias huertas y distintas coordenadas. Se invoca el método localiza de
las distintas huertas con las distintas coordenadas, algunas más de una vez. Se
muestra por pantalla el resultado de cada acción.
 */
public class P10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//crear huertas y coordenadas
		Huerta huerto1=new Huerta(3,6);
		Huerta huerto2=new Huerta(2,0);
		Huerta huerto3=new Huerta(-1,4);
		Huerta huerto4=new Huerta(1,2);
		
		Coordenada coord1=new Coordenada(-97,45);
		Coordenada coord2=new Coordenada(0,180);
		Coordenada coord3=new Coordenada(15,181);
		Coordenada coord4=new Coordenada(78,-22);
		
		System.out.println(coord1);
		System.out.println(coord2);
		System.out.println(coord3);
		System.out.println(coord4);
		
		//localizo
		huerto1.localiza(0, 180);
		huerto2.localiza(0, 45);
		huerto3.localiza(0, 180);
		huerto4.localiza(15, 0);
		if(huerto3.getLocalizacion()==null)
			huerto3.localiza(78, -22);
		
		ArrayList<Huerta> localizadas=Huerta.getLocalizadas();
		for(int i=0;i<localizadas.size();i++) {
			System.out.println(localizadas.get(i).getHuerto()+" "+localizadas.get(i).getLocalizacion());
		}
	}

}
