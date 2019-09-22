package paketic;

public class Profesor extends Nastavnik{
	private String titula;
	
	public Profesor(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata, String [] lista, String titula) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, lista);
		this.titula=titula;
	}
	
	public String toString() {
		String ispis="";
		ispis+="\nProfesor: "+titula;
		return super.toString()+ispis;
	}
	
}
