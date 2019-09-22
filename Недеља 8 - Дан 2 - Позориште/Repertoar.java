package paketic;

import java.util.ArrayList;

public class Repertoar {
	private Pozoriste pozoriste;
	private ArrayList<Predstava> predstave = new ArrayList<Predstava>();
	
	public Repertoar(Pozoriste pozoriste) {
		super();
		this.pozoriste = pozoriste;
	}
	
	public void dodaj(Predstava p) {
		predstave.add(p);
	}
	
	public void ukloni(String imePredstave) {
		for(int i=0;i<predstave.size();i++) {
			if(imePredstave.equals(predstave.get(i).getNaziv()))
				predstave.remove(i);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(pozoriste.getNaziv()+": [\n");
		for(int i=0;i<predstave.size();i++) {
			sb.append("  "+predstave.get(i)+"\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
