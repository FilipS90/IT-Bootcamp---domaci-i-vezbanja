package paketic;

import java.util.Random;

public class Asistent extends Nastavnik {
	private String smerDokStud;
	
	public Asistent(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata, String[] lista, String smerDokStud) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, lista);
		Random rand = new Random();
		this.smerDokStud=lista[rand.nextInt(lista.length)];
	}
	
	public String toString() {
		String ispis="";
		ispis+="\nSmer doktorskih studija: "+smerDokStud;
		return super.toString()+ispis;
	}

}
