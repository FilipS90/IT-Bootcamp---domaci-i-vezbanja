package paketic;

public abstract class Namirnica extends Energent {
	private String ime;
	private static int global=1;
	private int ID=global++;
	
	public Namirnica(String ime) {
		super();
		this.ime = ime;
	}

	public String getIme() {
		return ime;
	}

	public int getID() {
		return ID;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("["+getID()+"] "+getIme());
		return sb.toString();
	}
	
	
	
}
