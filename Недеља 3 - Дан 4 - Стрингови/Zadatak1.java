package paketic;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite string: ");
		String n = sc.nextLine();

		palindrom(n);

		sc.close();
	}

	static void palindrom(String n) {
		n = n.replaceAll("\\s+", "");
		n = n.toLowerCase();
		boolean tacno = true;
		for (int i = 0, j = n.length() - 1; i < n.length(); i++, j--) {
			char h = n.charAt(i);
			char z = n.charAt(j);
			if (h == z)
				continue;
			else
				System.out.println("String nije palindrom.");
				tacno = false;
				break;
		}
		if (tacno)
			System.out.println("String je palindrom.");

	}
}
