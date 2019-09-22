package paketic;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj redova niza: ");
		int y=sc.nextInt();
		System.out.println("Unesite broj kolona niza: ");
		int x=sc.nextInt();
		int[][] Niz = new int [y][x];
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.println("Element niza: ");
				Niz[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(Niz[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Unesite broj kolone ciju sumu zelite: ");
		int o = sc.nextInt()-1;
		System.out.println(sumaKolone(Niz,o));
		
		
		sc.close();
	}
	
	static int sumaKolone(int[][] a, int n) {
		Scanner sc = new Scanner(System.in);
		int suma=0;
		for(int i=0; i<a.length; i++) {
			suma+=a[i][n];
		}
		return suma;
		
	}

}
