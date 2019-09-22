package paketic;

public class Promenljiva extends Izraz {
	private String ime;
	protected int vrednost;
	
	public Promenljiva(String ime, int vrednost) {
		super();
		this.ime = ime;
		this.vrednost = vrednost;
	}

	public String toString() {
		return ime+" "+ izracunaj();
		
	}

	@Override
	public int izracunaj() {
		// TODO Auto-generated method stub
		return vrednost;
	}
	
	}

	

	


