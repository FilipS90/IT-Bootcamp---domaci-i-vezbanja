package paketic;

import java.util.Random;
import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			Niz[i] = rand.nextInt(50) ;
		}
		
		/*for(int i=0; i<Niz.length;i++)
			System.out.println(Niz[i]); provereno */
		
		if(daIliNe(Niz)==true)
			System.out.println("Uneti broj je clan niza.");
		else
			System.out.println("Uneti broj nije clan niza.");
		
		sc.close();
		
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
