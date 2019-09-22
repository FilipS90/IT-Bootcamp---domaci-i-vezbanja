package paketic;

import java.util.ArrayList;

public class Predstava {
	private String naziv;
	private Pozoriste pozoriste;
	private ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	
	public Predstava(String naziv, Pozoriste pozoriste, Reditelj red) {
		super();
		this.naziv = naziv;
		this.pozoriste = pozoriste;
		zaposleni.add(red);
	}
	
	public boolean dodaj(Glumac g) {
		zaposleni.add(g);
		return true;
	}
	
	public boolean dodaj(Kostimograf k) {
		int q=0;
		for(int i=0;i<zaposleni.size();i++) {
			if(zaposleni.get(i).getClass()==k.getClass())
				q++;
		}
		if(q<2) {
			zaposleni.add(k);
			return true;
		}
		else
			return false;
	}

	public String getNaziv() {
		return naziv;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNaziv()+": ");
		for(int i=0;i<zaposleni.size();i++) {
			sb.append("\n\t "+zaposleni.get(i).getIme()+" ("+zaposleni.get(i).imePosla()+", "+zaposleni.get(i).getPozoriste().getSkraceniNaziv()+")");			
		}
		return sb.toString();
	}
	
	
}
