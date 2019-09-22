package paketic;

public class Main {

	public static void main(String[] args) {
		List w = new List ("Hello");
		List q = new List("There");
		List a = new List("My");
		List b = new List("Friend");
		List bw = new List ("Howdy");
		List xq = new List("There");
		List rt= new List("My");
		List gf = new List("Zooom");
		List op = new List ("Dylan");
		List kj = new List("Chap");
		List yt = new List("Code");
		List ol = new List("Life");
		
		Knjiga Hari = new Knjiga("Hari");
		Knjiga Troter = new Knjiga("Troter");
		Knjiga Blaber = new Knjiga("Blaber");
		
		Hari.dodajList(1, b);
		Hari.dodajList(2, w);
		Hari.dodajList(3, q);
		Hari.dodajList(4, a);
		
		Troter.dodajList(3, bw);
		Troter.dodajList(2, xq);
		Troter.dodajList(1, rt);
		Troter.dodajList(4, gf);
		
		Blaber.dodajList(4, op);
		Blaber.dodajList(1, kj);
		Blaber.dodajList(2, yt);
		Blaber.dodajList(3, ol);
		
		Knjiga [] X = {Hari, Troter, Blaber};
		Polica Pol = new Polica(X);
		
		
		System.out.println(Pol);
		
	}

}
