package paketic;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi clana niza: ");
			Niz[i] = sc.nextInt();
		}

		System.out.println(daIliNe(Niz)); // nisam pisao if equals to true, itd itd, izlaz je samo true ili false

	}

	static boolean daIliNe(int[] a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj za proveru: ");
		int n = sc.nextInt();
		boolean y = false;

		for (int i = 0; i < a.length; i++)
			if (a[i] != n)
				continue;
			else {
				y = true;
				break;
			}
		return y;
	}

}
