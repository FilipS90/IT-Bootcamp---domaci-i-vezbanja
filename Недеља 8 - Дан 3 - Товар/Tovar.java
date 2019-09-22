package paketic;

public abstract class Tovar {
	protected abstract double tezina();
	protected abstract String vrsta();
	
	
	public String toString() {
		String ispis=vrsta()+"("+tezina()+")";
		return ispis;
	}
	
	
}
