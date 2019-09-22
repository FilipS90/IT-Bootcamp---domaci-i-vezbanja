package paketic;

import java.util.ArrayList;

public class Paket extends Tovar {
	private ArrayList<Tovar> tovar = new ArrayList<Tovar>();

	public double tezina() {
		double q=0;
		for(int i=0;i<tovar.size();i++) {
			q+=tovar.get(i).tezina();
		}
		return q;
	}
	
	public String vrsta() {
		StringBuilder sb = new StringBuilder();
		sb.append("paket[");
		for(int i=0;i<tovar.size();i++) {
			sb.append(tovar.get(i).vrsta());
			if(i!=tovar.size()-1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void dodaj(Tovar a) {
		tovar.add(0, a);
	}
	
	
	

	

	
	
	
}
