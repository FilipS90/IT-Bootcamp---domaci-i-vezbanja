package paketic;

import java.util.Random;

public class Nastavnik extends Zaposleni {
	private String omiljPred;
	private String[] lista;
	
	public Nastavnik(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata, String[] lista) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		Random rand = new Random();
		this.omiljPred=lista[rand.nextInt(lista.length)];
		this.lista=lista;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\n-Predavac: ";
		ispis+="\nOmiljeni predmet: "+omiljPred;
		ispis+="\nLista predmeta na kojima predaje: ";
		for(int i=0;i<lista.length;i++) {
			if(i>0 && i-1!=lista.length)
				ispis+=", ";
		ispis+=lista[i];
		}
		return super.toString()+ispis;
	}
}
