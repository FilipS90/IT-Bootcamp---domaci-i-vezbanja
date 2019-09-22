package paketic;

public class Tim {
	private String naziv;
	private Vozac v1;
	private Vozac v2;
	
	public Tim(String naziv, Vozac v1, Vozac v2) {
		super();
		this.naziv = naziv;
		this.v1 = v1;
		this.v2 = v2;
	}

	public String getNaziv() {
		return naziv;
	}

	public Vozac getV1() {
		return v1;
	}

	public Vozac getV2() {
		return v2;
	}
	
	
	
	
}
