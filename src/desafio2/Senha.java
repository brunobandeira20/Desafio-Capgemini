package desafio2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Senha {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Crie sua senha:");

		String senha = sc.nextLine();

		senhaForte(senha);
		sc.close();
	}

	public static void senhaForte(String senha) {

		int senhaTamanho = 6;

		int maisculo = 0, minuscula = 0, specialCarac = 0, digitos = 0;
		char ch;

		Set<Character> set = new HashSet<Character>(
				Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

		if (senha.length() < senhaTamanho) {
			int caractFaltando = senhaTamanho - senha.length();
			System.out.println("Adicione mais " + caractFaltando + " caracteres.");
			return;
		} else {
			for (int i = 0; i < senha.length(); i++) {
				ch = senha.charAt(i);
				if (Character.isLowerCase(ch))
					minuscula++;
				else if (Character.isUpperCase(ch))
					maisculo++;
				else if (set.contains(ch))
					specialCarac++;
				else if (Character.isDigit(ch))
					digitos++;

			}
		}

		if (maisculo != 0 && minuscula != 0 && digitos != 0 && specialCarac != 0) {

			int minimumStrongPassword = 8;

			if (senha.length() >= minimumStrongPassword) {
				System.out.println("\nFor�a da Senha: Forte.");
			} else {
				System.out.println("\nFor�a da Senha: M�dio.");
			}

			System.out.println("\n--- A senha dispoem ---");
			System.out.println("Letras Mai�sculas: " + maisculo);
			System.out.println("Letras Min�sculas: " + minuscula);
			System.out.println("D�gitos: " + digitos);
			System.out.println("Caracteres especiais: " + specialCarac);
		} else {
			if (maisculo == 0)
				System.out.println("\nA senha deve conter pelo menos um caractere mai�sculo.");
			if (minuscula == 0)
				System.out.println("\nA senha deve conter pelo menos um caractere min�sculo.");
			if (digitos == 0)
				System.out.println("\nA senha deve conter pelo menos um d�gito.");
			if (specialCarac == 0)
				System.out.println("\nA senha deve conter pelo menos um caractere especial.");
		}
	}
}
