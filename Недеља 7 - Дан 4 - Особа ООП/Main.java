package osoba;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
			Datum datum;
			Scanner sc = new Scanner(System.in);
			System.out.println("Unesite koliko objekata tipa OsobaD/JMBG zelite: ");
			int n=sc.nextInt();
			Osoba [] o = new Osoba [n];
			
			for(int i=0;i<n;i++) {
				System.out.println("Ime:");
				String ime = sc.next();
				System.out.println("Prezime: ");
				String pre = sc.next();
				System.out.println("Adresa:");
				String adr=sc.next();
				
				System.out.println("Unesi JMBG ili datum rodjenja (u formatu dd.mm.gggg.):");
				
				String dat = sc.next();
				
				if(dat.charAt(2)=='.' && dat.charAt(5)=='.' && dat.charAt(10)=='.') {
					String dan = dat.substring(0, 2);
					String mesec = dat.substring(3, 5);
					String godina = dat.substring(6, 10);
					int d = Integer.parseInt(dan);
					int m = Integer.parseInt(mesec);
					int g = Integer.parseInt(godina);
					datum = new Datum(d,m,g);
					
					OsobaD Fi = new OsobaD (ime,pre,adr,datum);
					o[i]=Fi;
				}
				else {
					OsobaJMBG Fi = new OsobaJMBG (ime,pre,adr,dat);
					o[i]=Fi;
				}
			}
			
			System.out.println("Unesite danasnji datum: ");
			String DanDat = sc.next();
			String dan = DanDat.substring(0, 2);
			String mesec = DanDat.substring(3, 5);
			String godina = DanDat.substring(6, 10);
			int d = Integer.parseInt(dan);
			int m = Integer.parseInt(mesec);
			int g = Integer.parseInt(godina);
			datum = new Datum(d,m,g);
			
			for(int i=0;i<n;i++) {
				if(o[i].numeroloskiBroj()!=7) {
					for(int j=0;j<o[i].metabolizam(datum).length();j++) {
						char c = o[i].metabolizam(datum).charAt(j);
						if(c=='0')
							break;
						if(c!='0' && j!=o[i].metabolizam(datum).length()-1)
							continue;
						if(c!='0' && j==o[i].metabolizam(datum).length()-1)
							System.out.println(o[i]);
							System.out.println(o[i].numeroloskiBroj());
							System.out.println(o[i].metabolizam(datum));
							System.out.println("");
					}
			}	
	}
			sc.close();
}
}
