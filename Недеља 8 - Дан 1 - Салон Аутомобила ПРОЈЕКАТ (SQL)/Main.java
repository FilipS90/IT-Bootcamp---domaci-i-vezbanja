package projekat;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Zadatak zd = new Zadatak("jdbc:sqlite:C:\\Users\\Filip\\Desktop\\ozb\\Prodavnica.db");
		
		//zd.registracija();
		zd.connect();
		String log = zd.logovanje();
		if(log.equals("admin")) {
			zd.admin(log);
			return;
		}
		System.out.println("Za kupovinu automobila odaberite opciju 1, za placanje opciju 2");
		int q=sc.nextInt();
		if(q==1) 
			zd.kupovina(log);
		else if(q==2)
			zd.uplata(log);
		else
			System.out.println("Los unos, izlazak iz programa");
		
	}
	
}
