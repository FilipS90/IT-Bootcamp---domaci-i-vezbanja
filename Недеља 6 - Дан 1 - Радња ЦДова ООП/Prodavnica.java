package paketic;

public class Prodavnica {
	private String ime;
	private String lokacija;
	private Artikal[] inventar = new Artikal[10];
	
	public Prodavnica(String ime, String lokacija) {
		super();
		this.ime = ime;
		this.lokacija = lokacija;
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}
	
	public Artikal[] pretrazi(String tekst) {
		int q=0;
		tekst = tekst.toLowerCase();
		for(int i=0;i<inventar.length;i++) {
			if(inventar[i]==null)
				break;
			String temp = inventar[i].ime();
			temp = temp.toLowerCase();
			if(temp.contains(tekst))
				q++;
		}
		Artikal [] nov = new Artikal [q];
		int k=q;
		for(int i=0;i<inventar.length;i++) {
			if(inventar[i]==null)
				break;
			String temp = inventar[i].ime();
			temp = temp.toLowerCase();
			if(temp.contains(tekst))
				nov[k-q--]=inventar[i];
		}
		return nov;
		
	}
	
	public void dodaj(Artikal a) {
		boolean k = false;
		for(int i=0;i<inventar.length;i++) {
			if(inventar[i]!=null) {
				continue;
			}
			else {
				inventar[i]=a;
				k = true;
				break;
			}
		}
		if(k==false) {
			Artikal [] b = new Artikal [inventar.length*2];
			for(int i=0;i<inventar.length;i++) {
				
				inventar[i]=b[i];
			}
			b[inventar.length]=a;
			inventar=b;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime+": "+lokacija+" [");
		for(int i=0;i<inventar.length;i++) {
			if(inventar[i]==null)
				break;
			sb.append("\n\t"+inventar[i]);
		}
		sb.append("\n]");
		return sb.toString();
	}
	
	
}
