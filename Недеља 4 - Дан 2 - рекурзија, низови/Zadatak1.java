package paketic;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		
		do {
			System.out.println("Unesi vrednost za n: ");
			n =sc.nextInt();
		}while(n>37);
		System.out.println(tribonacci(n));
	}
	
	static int tribonacci(int n) {
		if(n==1 || n==2) return 1;
		else if(n==0) return 0;
		return tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
	}
}
