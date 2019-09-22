package paketic;

public class Oduzimanje extends BinarnaOperacija {

	public Oduzimanje(Izraz levi, Izraz desni) {
		super(levi, desni);
		
	}
	
	public int izracunaj() {
		int levaStr = levi.izracunaj();
		int desnaStr = desni.izracunaj();
		return levaStr-desnaStr;
	}
	

}
