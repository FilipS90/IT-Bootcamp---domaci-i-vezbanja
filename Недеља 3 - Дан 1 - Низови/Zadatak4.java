package paketic;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi element niza: ");
			Niz[i] = sc.nextInt();
		}

		boolean dupli = dupli(Niz);
		if (dupli == true)
			System.out.println("Niz ima clanove sa jednakim vrednostima.");
		else
			System.out.println("Niz nema clanove sa jednakim vrednostima.");

		sc.close();
	}

	static boolean dupli(int[] a) {
		Scanner sc = new Scanner(System.in);
		boolean dupli = false;
		for (int i = 0; i < a.length + 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					dupli = true;
					break;
				}
			}
		}
		return dupli;
	}

}
