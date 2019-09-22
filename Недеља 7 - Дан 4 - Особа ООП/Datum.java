package osoba;

public class Datum {
	private int dan;
	private int mesec;
	private int godina;
	
	public Datum(int dan, int mesec, int godina) {
		super();
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

	public int getMesec() {
		return mesec;
	}

	public void setMesec(int mesec) {
		this.mesec = mesec;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	public String toString() {
		String ispis=dan+"."+mesec+"."+godina+".";
		return ispis;
	}
	
	
}
