package paketic;

import java.util.Random;

public class GlavniProgram {

	public static void main(String[] args) {
		Tacka [] o = new Tacka[10];
		randomTacke(o);
		
		Trougao a = new Trougao (10,14,15,o[1]);
		Trougao b = new Trougao (12,15,12,o[3]);
		Trougao c = new Trougao (5,7,10,o[7]);
		
		System.out.println(a.ispisiTrougao());
		System.out.println("");
		b.jednakokraki();
		a.jednakokraki();
		System.out.println("");
		System.out.println(c.ispisiTrougao());
		System.out.println("");
		
		Trougao d = new Trougao (14,9,10,o[7]);
		
		d.uporedi(c);
		a.uporedi(b);
	}

	static void randomTacke(Tacka[]o) {
		Random rand = new Random();
	for(int i=0;i<o.length;i++) {
		o[i] = new Tacka(rand.nextDouble()+rand.nextInt(10), rand.nextDouble()+rand.nextInt(10));
		}
	}

}
