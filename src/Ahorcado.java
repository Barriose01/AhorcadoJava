import java.util.*;
public class Ahorcado {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	String opcion = "";
	int parseOpcion = 0;
	
	private String obtenerPalabraSecreta() {
		String[] palabras = {"informatica", "programacion", "analisis", "codigo"
				, "programa", "software", "hardware", "binario", "lenguaje", "sistema", "computacion",
				"computadora"};
		int posicionEnArray = rd.nextInt(((palabras.length - 1) - 0) + 1) + 0;
		return palabras[posicionEnArray];
	}
	
	private boolean verificarEspacios(String[] espacios) {
		boolean hayEspacios = false;
		for(int i = 0; i < espacios.length; i++) {
			if(espacios[i].equals("_ ")) {
				hayEspacios = true;
				break;
			}
		}
		return hayEspacios;
	}
	
	private String[] generarEspacios(String palabraSecreta) {
		String[] espacios = new String[palabraSecreta.length()];
		for(int i = 0; i < espacios.length; i++) {
			espacios[i] = "_" + " ";
		}
		return espacios;
		
	}
	
	public void juego() {
		String adivino = "";
		String palabraSecreta = this.obtenerPalabraSecreta();
		String[] espacios = this.generarEspacios(palabraSecreta);
		int vidas = 6;
		while(vidas > 0) {
			int posicionesGanadas = 0;
			System.out.println("\nTrate de adivinar la palabra. Tiene " + vidas + " vidas");
			System.out.println("Ingrese una letra o la palabra completa");
			System.out.println("Ingrese el numero cero (0) en cualquier momento para salir\n");
			for(String espacio:espacios) {
				System.out.print(espacio);
			}
			opcion = sc.nextLine().toLowerCase().strip();
			if(opcion.equals("0")) {break;}
			else if(opcion.length() > 1) {
				if(opcion.equals(palabraSecreta)) {
					adivino = "V";
					break;
				}else {
					vidas -=1;
					if(vidas != 0) {
						System.out.println("'"+opcion + "' no es la palabra secreta. Siga intentandolo");
					}else {adivino = "F";}
				}
				
			}else {
				for(int i = 0; i < espacios.length; i++) {
					if(opcion.equals(Character.toString(palabraSecreta.charAt(i)))){
						espacios[i] = opcion;
						posicionesGanadas +=1;
					}
				}
				boolean hayEspacios = this.verificarEspacios(espacios);
				if(!hayEspacios) {adivino = "V"; break;}
				if(posicionesGanadas > 0) {
					System.out.println("\nBien. '" + opcion + "' aparece en " + posicionesGanadas + " posiciones");
				}else {
					vidas -= 1;
					if(vidas != 0) {
						System.out.println("\nSigue intentandolo. '" + opcion + "' no esta dentro de la palabra secreta");
					}else {adivino = "F";}
				}
			}	
		}
		this.resultados(adivino, palabraSecreta);
	}
	
	private void resultados(String resultado, String palabra) {
		if(resultado == "V") {
			System.out.println("\nFelicitaciones! La palabra secreta era '" + palabra + "'.");
		}else if(resultado == "F") {
			System.out.println("\nLo siento. No adivinaste. La palabra secreta era '" + palabra + "'.");
		}
	}
	
	public String menu() {
		System.out.println("\n(1): Jugar");
		System.out.println("(2): Salir");
		opcion = sc.nextLine().strip();
		return opcion;
	}
}
