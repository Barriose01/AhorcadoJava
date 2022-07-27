import java.util.*;
public class AhorcadoMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ahorcado a = new Ahorcado();
		while(true) {
			String opcion = a.menu();
			if(opcion.equals("1")) {
				a.juego();
			}else if(opcion.equals("2")) {
				break;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
		sc.close();
	}

}
