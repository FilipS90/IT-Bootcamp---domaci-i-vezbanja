package sql;

public class Main {

	public static void main(String[] args) {
		Fakultet PMF = new Fakultet("jdbc:sqlite:C:\\Users\\Filip\\Desktop\\New folder\\studentskabaza.db");
		
		PMF.connect();
		//PMF.dodajStudenta( 2009153, "Filip", "Stojiljkovic", "01-10-2009", "15-03-1990", "Beograd"); VEC DODATO
		PMF.ispisStudenata();
		System.out.println("");
		PMF.ispisPredmeta();
		System.out.println("");
		PMF.ispisBeograd();
		System.out.println("");
		PMF.ispisMesta();
		PMF.predmeti6Plus();
		System.out.println("");
		PMF.predmeti8I15(); // rezultat je null
		PMF.bodoviImaTacno();
		System.out.println("");
		PMF.bodoviNemaTacno();
		System.out.println("");
		PMF.cena();
		PMF.brisi();
		PMF.setDatumRodjenja(20130023, "17.09.1992");
		System.out.println("");
		PMF.ispisStudenata();
	}

}
