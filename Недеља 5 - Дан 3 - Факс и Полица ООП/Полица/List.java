package paketic;

public class List {
	private int brojStrane;
	private String tekst;
	
	public List(String tekst) {
		this.tekst = tekst;
	}
	
	public int getBrojStrane() {
		return brojStrane;
	}
	
	public void setBrojStrane(int i) {
		brojStrane=i;
	}

	public void setTekst(String a) {
		tekst=a;
	}
	
	public static void uporediStat(List a, List b) {
		if(a.getBrojStrane()>b.getBrojStrane())
			System.out.println("Prva stranica je veca od druge.");
		if(a.getBrojStrane()<b.getBrojStrane())
			System.out.println("Druga stranica je veca od prve.");
		if(a.getBrojStrane()==b.getBrojStrane())
			System.out.println("Stranice su jednake.");
		
	}
	
	public void uporedi(List a) {
		if(brojStrane>a.brojStrane)
			System.out.println("Broj strane "+brojStrane+" je veci od "+a.brojStrane);
		if(brojStrane<a.brojStrane)
			System.out.println("Broj strane "+brojStrane+" je manji od "+a.brojStrane);
		else
			System.out.println("Stranice su jednake");
	}
	
	public String toString() {
		String ispis="";
		ispis+=tekst+"("+Integer.toString(brojStrane)+")";
		return ispis;
	}
	

}
