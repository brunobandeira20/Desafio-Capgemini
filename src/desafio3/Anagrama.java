package desafio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Digite a palavra:");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine().toLowerCase();

		System.out.println(separateWord(word));
		scanner.close();
	}

	static int separateWord(String word) {
		// Break the word into pieces and add it to the list
		List<String> list = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j <= word.length(); j++)
				list.add(word.substring(i, j));
		}

		// Test all word pieces to check if it contains an anagram
		int anagrams = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (containsAnagrams(list.get(i), list.get(j)))
					anagrams++;
			}
		}
		return anagrams;
	}

	static boolean containsAnagrams(String piece1, String piece2) {
		// Checks if word pieces has same length
		if (piece1.length() != piece2.length())
			return false;

		int counter = 0;
		boolean[] visit = new boolean[piece2.length()];
		for (int i = 0; i < piece1.length(); i++) {
			for (int j = 0; j < piece2.length(); j++) {
				if (piece1.charAt(i) == piece2.charAt(j) && !visit[j]) {
					counter++;
					visit[j] = true;
					break;
				}
			}
		}
		return counter == piece2.length() ? true : false;
	}
}
