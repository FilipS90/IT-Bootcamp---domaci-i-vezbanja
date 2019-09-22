package paketic;

public class Polica {
	private Knjiga[] q = new Knjiga [4];
	
	public Polica(Knjiga[] q) {
		this.q = q;
	}
	
	public void dodajKnjigu(int i,Knjiga a) {
		if(q[i]!=null)
			System.out.println("Mesto je zauzeto.");
		else
			q[i]=a;
	}
	
	public void uzmiKnjigu(int i) {
		if(q[i]==null)
			System.out.println("Ne postoji knjiga na toj poziciji.");
		else {
			System.out.println("Knjiga "+q[i].getNaziv()+" je uzeta sa police.");
			q[i]=null;
		}
	}
	
	public void uzmiKnjiguIme(String a) {
		for(int i=0;i<q.length;i++) {
			if(q[i].getNaziv().equals(a)) {
				q[i]=null;
				break;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<q.length;i++) {
			if(q[i]==null)
				continue;
			sb.append(q[i].toString()+"\n");
		}
		return sb.toString();
		
		
	}
	
	
	
	
	
	
}
