package paketic;

public class Trougao {
	private Tacka o;
	private int a;
	private int b;
	private int c;
	
	public Trougao(int a, int b, int c, Tacka o) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.o = o;
		
		if(a<=0 || b<=0 || c <=0)
			System.out.println("Trougao ne moze imati negativnu stranicu ili stranicu duzine 0.");
		if(a+b<c || a+c<b || b+c<a)
			System.out.println("Trougao nije validan, zbir dve stranice uvek mora biti veci od trece.");
	}
	
	public void jednakokraki() {
		if(a==b || a==c || b==c)
			System.out.println("Trougao je jednokraki.");
		else
			System.out.println("Trougao nije jednakokraki.");
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public int getObim() {
		int o = a+b+c;
		return o;
	}
	
	public double getPovrsina() {
		double p=Math.sqrt(getObim()*(getObim()-a)*(getObim()-b)*(getObim()-c));
		return p;
	}
	
	public void izmeniA(int k) {
		if(k<0)
			System.out.println("Trougao ne moze imati negativnu stranicu.");
		if(k+b<=c || k+c<=b || b+c<=k)
			System.out.println("Trougao nije validan, zbir dve stranice uvek mora biti veci od trece.");
		if(k>0 && k+b>c && k+c>b && b+c>k) {
			this.a=k;
			System.out.println("Stranica uspesno promenjena.");
		}
	}
	
	public void izmeniB(int k) {
		if(k<0)
			System.out.println("Trougao ne moze imati negativnu stranicu.");
		if(a+k<=c || a+c<=k || k+c<=a)
			System.out.println("Trougao nije validan, zbir dve stranice uvek mora biti veci od trece.");
		if(k>0 && a+k>c && a+c>k && k+c>a) {
			System.out.println("Stranica uspesno promenjena.");
			this.b=k;
		}
	}
	
	public void izmeniC(int k) {
		if(k<0)
			System.out.println("Trougao ne moze imati negativnu stranicu.");
		if(a+b<=k || a+k<=b || b+k<=a)
			System.out.println("Trougao nije validan, zbir dve stranice uvek mora biti veci od trece.");
		if(k>0 && a+b>k && a+k>b && b+k>a) {
			System.out.println("Stranica uspesno promenjena.");
			this.c=k;
		}
	}
	
	public boolean pravilo() {
		if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a)
			return true;
		else
			return false;
	}
	
	public void izmeniSve(int a, int b, int c) {
		if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a) {
			System.out.println("Stranice uspesno promenjene.");
			this.a=a;
			this.b=b;
			this.c=c;
		}
		else
			System.out.println("Unos neuspesan.");
	}
	
	public Tacka getTacka() {
		return o;
	}
	
	public void izmeniTacke(double a, double b) {
		getTacka().izmeniX(a);
		getTacka().izmeniY(b);
	}
	
	public void uporedi(Trougao q) {
		if(getTacka().getX() == q.getTacka().getX() && getTacka().getY() == q.getTacka().getY())
			System.out.println("Trouglovi imaju istu pocetnu tacku.");
		else
			System.out.println("Trouglovi nemaju istu pocetnu tacku");		
	}
	
	public String ispisiTrougao() {
		String ispis="";
		if(pravilo()) {
			ispis+="Trougao je sa pocetkom u"+o.ispisiTacke();
			ispis+="\nStranice trougla su duzina: "+getA()+" "+getB()+" "+getC();
			ispis+="\nPovrsina i obim: P = "+getPovrsina()+", O = "+getObim();
			return ispis;
		}
		else
			ispis+="Trougao nije kreiran pravilno.";
			return ispis;
			
	
	}
	
	
	
}
