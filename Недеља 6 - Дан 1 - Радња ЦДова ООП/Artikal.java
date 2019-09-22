package paketic;

public abstract class Artikal {
	private static int global=1;
	private int id=global++;
	private double cena;
	private int kolicina;
	
	public Artikal( double cena, int kolicina) {
		super();
		this.cena = cena;
		this.kolicina = kolicina;
	}
	
	public int getID() {
		return id;
	}
	
	public int getKolicina() {
		return kolicina;
	}
	
	public double getCena() {
		return cena;
	}
	
	public boolean kupi() {
		if(kolicina>0) {
			kolicina--;
			return true;
		}
		else
			return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#"+getID()+": "+ime()+" - "+getCena()+" [kol: "+getKolicina()+"]");
		return sb.toString();
	}
	
	public abstract String ime();
	
}
