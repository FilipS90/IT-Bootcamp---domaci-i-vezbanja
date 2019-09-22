package paketic;

public class Knjiga {
	private String naziv;
	private List[] nizListova = new List[5];
	
	public Knjiga(String naziv) {
		this.naziv = naziv;
		
	}

	public String getNaziv() {
		return naziv;
	}

	public int getNizListova() {
		return nizListova.length;
	}

	public void dodajList(int i, List a) {
		if(i==0)
			i++;
		nizListova[i]=a;
		a.setBrojStrane(i);
	}
	
	public List getList(int i) {
		return nizListova[i];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv+":\n");
		for(int i=0;i<nizListova.length;i++) {
			if(nizListova[i]!=null) {
				sb.append("\t"+nizListova[i].toString()+"\n");
			}				
		}	
		return sb.toString();
	}
}
