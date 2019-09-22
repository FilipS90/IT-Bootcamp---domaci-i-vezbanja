package paketic;

public class Hrana extends Namirnica {
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;

	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		this.tezina=tezina;
		this.belancevine=belancevine;
		this.masti=masti;
		this.ugljHidrati=ugljHidrati;
	}
	
	public double energVr() {
		double bel=(belancevine*0.167)*tezina;
		double mas=(masti*0.376)*tezina;
		double uglj=(ugljHidrati*0.172)*tezina;
		double ukup=(bel+mas+uglj);
		return Math.round(ukup*100)/100.0;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()+"("+tezina+"g,"+(Math.round(energVr()*10))/10.0+"kJ)");
		return sb.toString();
	}

}
