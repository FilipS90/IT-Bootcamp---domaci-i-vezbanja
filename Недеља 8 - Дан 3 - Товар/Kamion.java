package paketic;

import java.util.ArrayList;

public class Kamion {
	private String regBroj;
	private ArrayList<Tovar> tovar = new ArrayList <Tovar>();
	private double nosivost;
	private double teret;
	
	public Kamion(String regBroj, double nosivost) {
		super();
		this.regBroj = regBroj;
		this.nosivost = nosivost;
	}
	
	public boolean stavi(Tovar a) {
		if(a.tezina()+teret>nosivost) {
			return false;
		}
		else {
			tovar.add(tovar.size(), a);
			teret+=a.tezina();
			return true;
		}
	}
	
	public void skini() {
		tovar.remove(tovar.size()-1);
	}
	
	public String toString() {
		String ispis=regBroj+"("+teret+"/"+nosivost+")\n";
		for(int i=0;i<tovar.size();i++) {
			ispis+="  "+tovar.get(i)+"\n";
		}
		return ispis;
		
	}
	
	
	
	
}