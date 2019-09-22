package paketic;

public class Tacka {
	private double x;
	private double y;

	public Tacka(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double izmeniX(double k) {
		return x=k;
	}
	
	public double izmeniY(double k) {
		return y=k;
	}
	
	public String ispisiTacke() {
		String ispis=" ("+Math.round(x)+","+Math.round(y)+")";
		return ispis;
	}
}
