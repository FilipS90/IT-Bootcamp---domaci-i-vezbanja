package paketic;

public class Pravougaonik {
	private double a;
	private double b;
	private String ime;
	
	public Pravougaonik(double a, double b, String ime) {
		this.a=a;
		this.b=b;
		this.ime=ime;
	}
	
	public Pravougaonik(double a, String ime) {
		this.a=a;
		this.b=a;
		this.ime=ime;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public String getIme() {
		return ime;
	}
	
	public double getObim() {
		double o=2*a+2*b;
		return o;
	}
	
	public double getPovrsina() {
		double p=a*b;
		return p;
	}
	
	public String ispisiPravougaonik() {
		String ispis ="";
		ispis+="Ime pravouganonika: "+ ime;
		ispis+="\nDuzina prve stranice: "+a;
		ispis+="\nDuzina druge stranice: "+b;
		ispis+="\nPovrsina pravougaonika je: "+getPovrsina();;
		ispis+="\nObim pravougaonika je: "+getObim();
		
		return ispis;
		
	}
	
	
	
}
