package paketic;

public class Meni {
	@SuppressWarnings("unused")
	private int duzina;
	private Namirnica [] a;

	public Meni(int duzina) {
		super();
		this.duzina=duzina;
		this.a=new Namirnica [duzina];
	}
	
	public void dodaj(Namirnica q) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==null) {
				a[i]=q;
				break;
			}
		}
	}
	
	public double ukupnaVr() {
		double sum=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==null)
				continue;
			sum+=a[i].energVr();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Meni ("+ukupnaVr()+"kJ) \n");
		for(int i=0;i<a.length;i++) {
			if(a[i]==null)
				continue;
			sb.append(a[i].toString()+"\n");
		}
		return sb.toString();
	}
}
	
