package paketic;

public class Predmet extends Tovar{
	private String vrsta;
	private double tezina;
	
	public Predmet(String vrsta, double tezina) {
		super();
		this.vrsta = vrsta;
		this.tezina = tezina;
	}
	
	public double tezina() {
		return this.tezina;
	}
	
	public String vrsta() {
		return this.vrsta;
	}
	
	
	
	
	
	
}
