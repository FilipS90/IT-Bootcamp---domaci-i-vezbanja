package paketic;

public class Student extends Covek {
	private int godinaStudija;
	private double prosek;
	
	public Student(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek) {
		super(ime, prezime, godinaRodjenja);
		this.godinaStudija=godinaStudija;
		this.prosek=prosek;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\n-Student:";
		ispis+="\nTrenutna godina studija: "+godinaStudija;
		ispis+="\nProsek: "+prosek;
		return super.toString()+ispis;
	}
	
	
}
