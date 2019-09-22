package paketic;

public class Aerodrom {
	private int ID;
	private String naziv;
	private String grad;
	private String drzava;
	private double latitude;
	private double longitude;
	private String skracenica;
	
	public Aerodrom(int iD, String naziv, String grad, String drzava, double latitude, double longitude, String skracenica) {
		super();
		ID = iD;
		this.naziv = naziv;
		this.grad = grad;
		this.drzava = drzava;
		this.latitude = latitude;
		this.longitude = longitude;
		this.skracenica= skracenica;
	}

	public int getID() {
		return ID;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getGrad() {
		return grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	public String getSkracenica() {
		return skracenica;
	}
	
	
	
	
}
