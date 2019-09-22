package paketic;

public class Main {

	public static void main(String[] args) {
		Broj b2 = new Broj(2);
		Broj bn11 = new Broj(-11);
		
		Promenljiva x = new Promenljiva ("x1", 10);
		Promenljiva x2 = new Promenljiva ("x1", 20);
		
		Sabiranje s1 = new Sabiranje(b2, x);
		Oduzimanje o1 = new Oduzimanje(s1, bn11);
		Sabiranje s2 = new Sabiranje(o1, x2);
		
		
		System.out.println(b2);
		System.out.println(s1);
		System.out.println(x);
		System.out.println(o1);
		System.out.println(s2);
		System.out.println("Rezultat: " + s2.izracunaj());

	}

}
