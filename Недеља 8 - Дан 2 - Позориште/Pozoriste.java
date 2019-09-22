package paketic;

public class Pozoriste {
	private static int ID=1;
	private int id=ID++;
	private String naziv;
	
	public Pozoriste(String naziv) {
		super();
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}
	
	public String getSkraceniNaziv() {
		String skraceni="";
		for(int i=0;i<naziv.length();i++) {
			if(i==0) {
				skraceni+=Character.toString(naziv.charAt(i));
			}
			if(naziv.charAt(i)==' ') {
				skraceni+=naziv.charAt(i+1);
			}
				
		}
		skraceni=skraceni.toUpperCase();
		return skraceni;
	}
	
	public String toString() {
		String ispis = getNaziv() + " " + getId();
		return ispis;
	}
	
	
}
