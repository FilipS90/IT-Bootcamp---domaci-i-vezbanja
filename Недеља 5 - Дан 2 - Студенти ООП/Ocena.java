package paketic;

public class Ocena {
	private int bodovi;
	private Predmet pr;
	
	public Ocena(int bodovi, Predmet pr) {
		super();
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getBodovi() {
		return bodovi;
	}

	public Predmet getPr() {
		return pr;
	}
	
	public int getOcena() {
		int a=0;
		if(bodovi<=50)
			a=5;
		if(bodovi>50 && bodovi<=60)
			a=6;
		if(bodovi>60 && bodovi<=70)
			a=7;
		if(bodovi>70 && bodovi<=80)
			a=8;
		if(bodovi>80 && bodovi<=90)
			a=9;
		if(bodovi>90 && bodovi<=100)
			a=10;
		return a;
	}
	
	public String ispis() {
		String ispis="";
		ispis+="Predmet: "+getPr() +", Ocena: "+getOcena();
		return ispis;
	}

	
}
