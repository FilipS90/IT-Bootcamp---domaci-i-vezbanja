package paketic;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];
		int suma = 0;

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi clanove niza: ");
			Niz[i] = sc.nextInt();
			suma += Niz[i];
		}

		int zbir = nedostaje(Niz);
		System.out.println("Broj koji nedostaje iz niza je " + (zbir - suma));
		
		sc.close();
	}

	static int nedostaje(int[] a) {
		int min = a[0], max = a[0], suma = 0, b = 1;
		for (int i = 0; i < a.length; i++) {
			if (min < a[i])
				continue;
			else
				min = a[i];
			suma = min;
		}

		for (int i = 0; i < a.length; i++) {
			if (max > a[i])
				continue;
			else
				max = a[i];
		}

		while (max > min) {
			suma += min + b;
			max--;
			b++;
		}
		return suma;
	}
}
