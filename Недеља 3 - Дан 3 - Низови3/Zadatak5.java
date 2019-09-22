package paketic;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite vrednost stringa: ");
		String z=sc.nextLine();
		
		int[] slova= brojSlova(z);
		for(int i=0; i<26;i++)
			System.out.print(slova[i]+" ");
		
		sc.close();
	}
	
	static int[] brojSlova(String z) {
		int [] broj = new int [26];
		z = z.toLowerCase();
		for(int i=0; i<z.length(); i++) {
			int num = z.charAt(i);
					if(num>96 && num<123) { //a do z su vrednosti od 97 do 122
						num-=97; //jer je a npr. na [0] mestu
						broj[num]+=1;
					}
		}
		return broj;
	}
}
