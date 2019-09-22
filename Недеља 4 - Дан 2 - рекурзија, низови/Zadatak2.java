package paketic;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj clanova niza A: ");
		int n=sc.nextInt();
		int[] nizA = new int [n];
		
		for(int i=0;i<n;i++) {
			System.out.println("Unesi element niza A:");
			nizA[i]=sc.nextInt();
		}
		
		System.out.println("Unesi broj clanova niza B: ");
		int x=sc.nextInt();
		int[] nizB = new int[x];
		
		for(int i=0;i<x;i++) {
			System.out.println("Unesi element niza B:");
			nizB[i]=sc.nextInt();
		}
		
		if(podskup(nizA,nizB))
			System.out.println("Niz A je podskup niza B.");
		else
			System.out.println("Niz A nije podskup niza B.");
		
		sc.close();
		
	}
	
	static boolean podskup(int[] a, int[] b) {
		Scanner sc = new Scanner(System.in);
		int[] novi = new int[a.length];
		int q=0; //brojac
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<b.length;j++) {
				if(a[i]!=b[j])
					continue;
				else {
					novi[i]=a[i];
					break;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			if(novi[i]==a[i]) {
				continue;
			}
			else
				return false;
		}
		return true;

	}
	
}

