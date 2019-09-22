package paketic;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite string: ");
		String n = sc.nextLine();
		
		niz(n);
		
		sc.close();
	}
	
	static void niz(String n) {
		Scanner sc = new Scanner(System.in);
		n=n.replaceAll("\\s+", ""); //nije definisano da li razmaci treba da razdvajaju nizove
		int q=0, sum=0, x=0, a=n.length()-1;
		
		for(int i = 0; i<n.length();i++) {
			char h = n.charAt(i);
			if(h=='a' || h=='e' || h=='i' || h=='o' || h=='u' || h=='A' || h=='E' || h=='I' || h=='O' || h=='U') {
				q++; //brojac
				if(i==a && sum<q) { //ako je poslednji niz samoglasnika najduzi
					sum=q;
					x=i;
				}
			}
			else {
				if(sum<q) { //ako je niz samoglasnika duzi od brojaca
					sum=q;
					q=0;
					x=i-1;
				}
				else
					q=0; //ako je sum vece od niza samoglasnika, a znak jeste samoglasnik
			}
		}
		sum-=1;
		for(int i=0; i<sum+1;i++) {
			System.out.print(n.charAt(x-sum+i));
		}
		
		
	}

}
