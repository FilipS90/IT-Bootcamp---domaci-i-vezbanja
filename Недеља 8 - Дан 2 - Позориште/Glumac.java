package paketic;

public class Glumac extends Zaposleni {

	public Glumac(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}
	
	public String imePosla() {
		String ispis=getClass().getSimpleName();
		return ispis;
	}
	

}
