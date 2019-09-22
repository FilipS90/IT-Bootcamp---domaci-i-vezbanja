package paketic;

public class StudentOsnovnihStudija extends Student {
	private String smerOsnStud;
	
	public StudentOsnovnihStudija(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek, String smerOsnStud) {
		super(ime, prezime, godinaRodjenja, godinaStudija, prosek);
		this.smerOsnStud=smerOsnStud;
		
}
	public String toString() {
		String ispis="";
		ispis+="\nSmer osnovnih studija: "+smerOsnStud;
		return super.toString()+ispis;
	}
	
}
