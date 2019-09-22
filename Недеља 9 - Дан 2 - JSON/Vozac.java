package paketic;

public class Vozac {
	private String ime;
	private String prezime;
	private int godine;
	private int pozicija;
	
	public Vozac(String ime, String prezime, int godine, int pozicija) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godine = godine;
		this.pozicija = pozicija;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}
	
	
	
	
	
}
