package paketic;

public class Sluzbenik extends Zaposleni {
	private String odsek;
	
	public Sluzbenik(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata, String odsek) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		this.odsek=odsek;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\n-Sluzbenik: \nOdsek: "+odsek;
		return super.toString()+ispis;

	}
	
	
}
