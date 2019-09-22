package paketic;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj clanova niza: ");
		int n=sc.nextInt();
		int[] Niz = new int[n];
		
		for(int i=0;i<Niz.length;i++) {
			System.out.println("Unesi element niza: ");
			Niz[i]=sc.nextInt();
		}
		
		dvaUJednom(Niz);
		
		sc.close();
		
	}
	
	static void dvaUJednom(int[] a) {
		Scanner sc = new Scanner (System.in);
		int sv=0,q=0,b=0;
		for(int i=0;i<a.length;i++) {
			sv+=a[i];
			q++;
		}
		sv/=q;
		//System.out.println(sv); isprobano
		System.out.println("Clanovi niza iznad srednje vrednosti su: ");
		
		for(int i=0;i<a.length;i++) {
			if(a[i]>sv)
				System.out.print(a[i]+ " ");
		}
	
		
		int min = Math.abs(sv-a[0]);
		for(int i=1;i<a.length;i++) {
			if(min>Math.abs(sv-a[i])) {
				min=sv-a[i];
				b=a[i];
				continue;
			}
			
		}
		System.out.println("");
		System.out.println("Po vrednosti, najblizi clan niza srednjoj vrednosti je "+b);
}
}
