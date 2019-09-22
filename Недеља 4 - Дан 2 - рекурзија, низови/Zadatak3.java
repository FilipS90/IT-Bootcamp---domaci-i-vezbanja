package paketic;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj clanova za niz A: ");
		int n=sc.nextInt();
		int[] niz = new int [n];
		
		for(int i=0; i<n;i++) {
			System.out.println("Unesi element");
			niz[i]=sc.nextInt();
		}
		
		for(int i=0; i<n;i++) {
			System.out.print(niz[i]+" ");
		}
		System.out.println("");
		
		int[] novi = sortiraj(niz);
		
		for(int i=0;i<novi.length;i++) {
			System.out.print(novi[i]+" ");
		}
		
		
	}
	
	static int[] sortiraj(int[] a) {
		int[] novi = new int [a.length];
		int q=0,z=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==0) {
				novi[0+z]=a[i];
				q++;
				z++;
			}
			else
				continue;
		}
		int b=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==1) {
				novi[q+b]=a[i];
				b++;
			}
			else
				continue;
		}
		return novi;
	}

}
