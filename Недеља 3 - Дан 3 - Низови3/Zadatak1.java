package paketic;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi x osu clanova niza: ");
		int x = sc.nextInt();
		System.out.println("Unesi y osu clanova niza: ");
		int y = sc.nextInt();
		int[][] Niz = new int[x][y];

		for (int i = 0; i<x; i++) {
			for( int j=0; j<y; j++) {
			System.out.println("Element: ");
			Niz[i][j] = sc.nextInt();
			}
		}

		int [] rez = minMax(Niz, y);
		for(int i=0; i<rez.length; i++)
			System.out.print((rez[i])+" ");

		sc.close();

	}

	static int[] minMax(int[][] a, int y) {
		Scanner sc = new Scanner(System.in);
		int max=a[0][0], min=a[0][0];
		for (int i = 0; i<a.length; i++) {
			for(int j=0; j<y; j++) {
				if(a[i][j]>max)
					max=a[i][j];
				if(a[i][j]<min)
					min=a[i][j];
			}
		}
		int []rez = {min,max};
		return rez;
		
}
}
