package osoba;


public class OsobaD extends Osoba {
	private Datum datumRodjenja;

	public OsobaD(String ime, String prezime, String adresa, Datum datumRodjenja) {
		super(ime, prezime, adresa);
		this.datumRodjenja=datumRodjenja;
	}

	public Datum getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Datum datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public void copyOD(OsobaD p) {
		this.datumRodjenja=p.datumRodjenja;
	}
	
	public String toString() {
		String ispis=super.toString()+" - "+getDatumRodjenja();
		return ispis;
	}
	
	public int numeroloskiBroj() {
		String s = Integer.toString(getDatumRodjenja().getDan())+
				Integer.toString(getDatumRodjenja().getMesec())+
				Integer.toString(getDatumRodjenja().getGodina());
		int x=0;
		
		for(int i=0;i<s.length();i++) {
				String l=Character.toString(s.charAt(i));
				x+=Integer.parseInt(l);
		}
		int o = x%10;
		x=(x-o)/10;
		x+=o;
		if(x>=10) {
			int y=x%10;
			x=(x-y)/10;
			x+=y;
			return x;
		}
		return x;
	}
	
	public String metabolizam(final Datum d) {
		String [] q = {Integer.toString(d.getDan()), Integer.toString(d.getMesec()),Integer.toString(d.getGodina())};
		String [] p = {Integer.toString(getDatumRodjenja().getDan()),Integer.toString(getDatumRodjenja().getMesec()),
				Integer.toString(getDatumRodjenja().getGodina())};
		String g = "";
		String t = "";
		
		for(int i=0;i<q.length-1;i++) {
			if(q[i].length()==1)
				q[i]="0"+q[i];
				g+=q[i];
			if(p[i].length()==1)
				p[i]="0"+p[i];
				t+=p[i];
		}
		g += Integer.toString(d.getGodina());
		t += Integer.toString(getDatumRodjenja().getGodina());
		
		int x = Integer.parseInt(g);
		int y = Integer.parseInt(t);
		int z = x+y;
		
		if(String.valueOf(z).length()<8)
			z*=10;
			g=Integer.toString(z);
		return g;
	}

}
