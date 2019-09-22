package paketic;

public class Kostimograf extends Zaposleni {

	public Kostimograf(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}
	
	public String imePosla() {
		String ispis=this.getClass().getSimpleName();
		return ispis;
	}
	
}
