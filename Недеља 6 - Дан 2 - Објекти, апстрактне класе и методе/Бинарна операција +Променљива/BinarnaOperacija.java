package paketic;

public abstract class BinarnaOperacija extends Izraz {
	protected Izraz levi, desni;
	protected Promenljiva neka;

	public BinarnaOperacija(Izraz levi, Izraz desni) {
		super();
		this.levi = levi;
		this.desni = desni;
	}
	
	public abstract int izracunaj();
	
}
