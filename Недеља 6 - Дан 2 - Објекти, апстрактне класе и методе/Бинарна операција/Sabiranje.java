package paketic;

public class Sabiranje extends BinarnaOperacija {
	
	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}

	public int izracunaj() {
		int levaStr = levi.izracunaj();
		int desnaStr = desni.izracunaj();
		return levaStr+desnaStr;
	}
}
