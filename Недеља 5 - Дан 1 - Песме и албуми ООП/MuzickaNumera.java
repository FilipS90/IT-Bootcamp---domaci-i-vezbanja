package paketic;

public class MuzickaNumera {
	private String naziv;
	private String izvodjac;
	private String trajanje;
	
	public MuzickaNumera(String naziv, String izvodjac, String trajanje) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.trajanje = trajanje;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(String izvodjac) {
		this.izvodjac = izvodjac;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	
	public String toString() {
		String a="";
		a+=getIzvodjac()+" - "+getNaziv()+": "+getTrajanje();
		return a;
	}
	
	
	
	
}
