package osoba;


public class OsobaJMBG extends Osoba{
	private String JMBG;

	public OsobaJMBG(String ime, String prezime, String adresa, String JMBG) {
		super(ime, prezime, adresa);
		this.JMBG=JMBG;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	
	public void copyOJMBG(OsobaJMBG p) {
		this.JMBG=p.JMBG;
	}
	
	public String toString() {
		String ispis=super.toString()+" - "+getJMBG();
		return ispis;
	}
	
	public String [] JMBGtoDate() {		
		String x = Character.toString(JMBG.charAt(0))+Character.toString(JMBG.charAt(1));
		String b = Character.toString(JMBG.charAt(2))+Character.toString(JMBG.charAt(3));
		String c = "1"+Character.toString(JMBG.charAt(4))+Character.toString(JMBG.charAt(5))+
				Character.toString(JMBG.charAt(6));
		String [] a = {x,b,c};
		
		return a;
		
	}
	
	public int numeroloskiBroj() {
		String [] a = JMBGtoDate();
		String s = a[0]+a[1]+a[2];
		
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
		String [] a = JMBGtoDate();
		String q;
		if(String.valueOf(d.getMesec()).length()==1) {
			q = Integer.toString(d.getDan())+"0"+Integer.toString(d.getMesec())+Integer.toString(d.getGodina());
		}
		else {
			q = Integer.toString(d.getDan())+Integer.toString(d.getMesec())+Integer.toString(d.getGodina());
		}
		
		String p = a[0]+a[1]+a[2];
				
		int x = Integer.parseInt(p);
		int y = Integer.parseInt(q);
		int z = x+y;
		
		if(String.valueOf(z).length()<8)
			z*=10;
			p=Integer.toString(z);
		return p;
	}
}
