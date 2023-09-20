package desafios;
import java.util.Scanner;

public class Desafio1 {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese fecha dd/mm/yyyy:");
		String fecha = entrada.nextLine();

		int dd = 0;
		int mm = 0;
		int yyyy = 0;
		int flagNow = 0;

		for (char caracter : fecha.toCharArray()) {
			if (caracter == '/') {

				flagNow++;
				continue;
			}

			int valorCaracter = caracter - '0';

			if (flagNow == 0) {
				dd = dd * 10 + valorCaracter;
			} else if (flagNow == 1) {
				mm = mm * 10 + valorCaracter;
			} else {
				yyyy = yyyy * 10 + valorCaracter;
			}
		}

		boolean bisiest = (yyyy % 4 == 0 && (yyyy % 100 != 0 || yyyy % 400 == 0));
		boolean diaValido = (dd >= 1 && dd <= 31);
		boolean mesValido = (mm >= 01 && mm <= 12);
		boolean añoValido = (yyyy >= 1900 && yyyy <= 2099);

		if (diaValido && mesValido && añoValido) {
			if (mm == 2) {
				if (bisiest ? dd <= 29 : dd <= 28) {
					System.out.println("Fecha válida");
				} else {
					System.out.println("Fecha inválida");
				}

			} else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
				if (dd <= 30) {
					System.out.println("Fecha válida");
				} else {
					System.out.println("Fecha inválida");
				}
			} else {
				System.out.println("Fecha válida");
			}
		} else {
			System.out.println("Fecha inválida");
		}

		entrada.close();
	}
}

		