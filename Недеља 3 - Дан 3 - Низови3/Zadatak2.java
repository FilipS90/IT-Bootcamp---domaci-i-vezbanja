package paketic;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Unesi broj redova u nizu: ");
			int y = sc.nextInt();
			System.out.println("Unesi broj kolona u nizu: ");
			int x = sc.nextInt();
			int[][] Niz = new int[y][x];

			for (int i = 0; i<y; i++) {
				for( int j=0; j<x; j++) {
				System.out.println("Element: ");
				Niz[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<y;i++) {
				System.out.println(" ");
				for(int j=0; j<x;j++) {
					System.out.print(Niz[i][j]+" ");
				}		
			}
			
			System.out.println("");
			System.out.println("Oznacite red ciju sumu zelite: ");
			int o=sc.nextInt();
			o-=1;
			System.out.println(suma(Niz,o));
			
			sc.close();

}
	static int suma(int[][] a, int y) {
		Scanner sc = new Scanner(System.in);
		int suma=0;
		for(int i=0; i<a[y].length; i++) {
			suma+=a[y][i];
				
		}
		return suma;
	}
	
}
