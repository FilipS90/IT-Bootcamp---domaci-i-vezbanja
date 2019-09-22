package paketic;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c ='c';
		System.out.println("Unesi vrednost za string s: ");
		String s=sc.nextLine();
		
		System.out.println(brojKaraktera(s,c));

	}
	
	static int brojKaraktera(String s, char c) {
		int x=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == c)
				x++;		
		}
		return x;
	}

}
