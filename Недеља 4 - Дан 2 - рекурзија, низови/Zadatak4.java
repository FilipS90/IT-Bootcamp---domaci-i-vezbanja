package paketic;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj stringova u nizu:");
		int n=sc.nextInt();
		String[] niz = new String [n];

		for(int i=0;i<niz.length;i++) {
			System.out.println("Unesi string:");
			niz[i]=sc.next();
		}
		
		String[] novi = zajednicki(niz);
		
		for(int i=0; i<novi.length;i++) {
			System.out.println(novi[i]);
		}
		
	}
	
	static String[] zajednicki(String[] a) {
		String A = a[0];
		char[] prvi = new char[a[0].length()];
		String[] novi = new String[10];
		
		for(int i=0; i<a[0].length();i++) {
			prvi[i]=A.charAt(i);
		}
		int q=0;
		for(int z=0; z<a.length-1;z++) {
			for(int i=0;i<prvi.length;i++) {
				for(int j=0; j<a[z+1].length();j++) {
				String B = a[z+1];
				if(prvi[i]==B.charAt(j)) {
					for(int x=0;x<novi.length;x++) {
						if(novi[x]==Character.toString(prvi[i])) 
							break;
						else {
							novi[q]=Character.toString(B.charAt(j));
							q++;
							break;
						}
					}
				}
			
			}
		}
	}
		return novi;
	}
	
	}
	
