package desafio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Escada {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o tamanho da escada: ");
		try {
			int n = sc.nextInt();
			escada(n);
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Valor invalido!");
		} finally {
			sc.close();
		}
	}

	public static void escada(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");

			}
			for (int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
