package paketic;

public class StudentMasterStudija extends StudentOsnovnihStudija {
	private String smerMasStud;
	
	public StudentMasterStudija(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek,
			String smerOsnStud, String smerMasStud) {
		super(ime, prezime, godinaRodjenja, godinaStudija, prosek, smerOsnStud);
		this.smerMasStud=smerMasStud;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\nSmer master studija: "+smerMasStud;
		return super.toString()+ispis;
	}

}
