package paketic;

public class Reditelj extends Zaposleni {

	public Reditelj(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}
	
	public String imePosla() {
		String ispis=this.getClass().getSimpleName();
		return ispis;
	}
	
	
}
