package paketic;

public class Covek {
	private String ime;
	private String prezime;
	private int godinaRodjenja;
	
	public Covek(String ime, String prezime, int godinaRodjenja) {
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
	}
	
	public String toString() {
		String ispis="";
		ispis+="Ime: "+ime;
		ispis+="\nPrezime: "+prezime;
		ispis+="\nGodina rodjenja: "+godinaRodjenja;
		return ispis;
	}
	
	

}
