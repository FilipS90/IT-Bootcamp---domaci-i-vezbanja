package paketic;

public class Zaposleni extends Covek {
	private int godinaZaposlenja;
	private int plata;
	
	public Zaposleni(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata) {
		super(ime, prezime, godinaRodjenja);
		this.godinaZaposlenja=godinaZaposlenja;
		this.plata=plata;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\n-Zaposleni: ";
		ispis+="\nGodina zaposlenja: "+godinaZaposlenja;
		ispis+="\nPlata: "+plata;
		return super.toString()+ispis;
	}
}
