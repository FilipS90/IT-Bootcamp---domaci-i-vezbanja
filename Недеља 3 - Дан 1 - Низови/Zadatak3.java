package paketic;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi clanove niza: ");
			Niz[i] = sc.nextInt();
		}

		System.out.printf("Aritmeticka sredina elemenata niza je: %.5f", aritmeticka(Niz));
		System.out.println("");
		System.out.println("Medijana niza je: " + (medijana(Niz)));
		sc.close();
	}

	static double aritmeticka(int[] a) {
		Scanner sc = new Scanner(System.in);
		double sum = 0, q = 0, as = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			q++;
		}
		as = sum / q;
		return as;
	}

	static int medijana(int[] a) {
		Scanner sc = new Scanner(System.in);
		int q = 0, m = 0;
		for (int i = 0; i < a.length; i++)
			q++;
		if (q % 2 == 1)
			m = a[(q + 1) / 2 - 1];
		else
			m = (a[q / 2 - 1] + a[(q / 2)]) / 2;
		return m;
	}
}
