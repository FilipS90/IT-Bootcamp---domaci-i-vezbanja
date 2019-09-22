package fss;

public class Main {

	public static void main(String[] args) {
		FSS fss = new FSS("jdbc:sqlite:C:\\Users\\Filip\\Desktop\\FSS\\FudbalskiSavezRad.db");
		
		fss.connect();
		fss.ispisIgracTim();
		System.out.println("");
		fss.ispisMancester();
		System.out.println("");
		fss.brojGolova();
		System.out.println("");
		fss.maxGol();
		System.out.println("");
		fss.brojKartona();
		System.out.println("");
		fss.gradovi(5);
		System.out.println("");
		fss.dodajTim("FK Rad", "Beograd");
		System.out.println("");
		fss.dodajIgraca("Fica", "FK Rad");
		fss.dodajIgraca("Milos", "FK Rad");
		fss.dodajIgraca("Nikola", "FK Rad");
		System.out.println("");
		fss.ispisIgracTim();
		System.out.println("");
		fss.dodajUtakmicu("FK Rad", "Arsenal", 1, "1", 2021);
		fss.obrisiTim("Manchester United");
		
		
	}

}
