package paketic;

public class Pice extends Namirnica {
	private double kolicina;
	private double enVr;
	
	
	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina=kolicina;
		this.enVr=enVr;
	}
	
	public double energVr() {
		double ukupno=enVr*kolicina;
		return ukupno;
	}

	public double getKolicina() {
		return kolicina;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()+"("+getKolicina()+"l, "+energVr()+"kJ)");
		return sb.toString();
	}
}
