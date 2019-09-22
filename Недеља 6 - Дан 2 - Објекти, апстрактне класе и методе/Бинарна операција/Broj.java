package paketic;

public class Broj extends Izraz {
	private int vrednost;

	public Broj(int vrednost) {
		super();
		this.vrednost = vrednost;
	}

	public int izracunaj() {
		return vrednost;
	}
	
}
