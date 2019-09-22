package paketic;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi clanove niza: ");
			Niz[i] = sc.nextInt();
		}

		int[]z=minMax(Niz);
		
		for(int i=0;i<=1;i++) {
		System.out.println(z[i]);
		}
		
		sc.close();
	}

	static int[] minMax(int[] a) {
		int min = a[0], max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (min < a[i])
				continue;
			else
				min = a[i];
		}
		int[] b = new int[2];
		b[0] = min;

		for (int i = 0; i < a.length; i++) {
			if (max > a[i])
				continue;
			else
				max = a[i];
		}

		b[1] = max;
		return b;
	}
}
