package paketic;

public class GlavniProgram {

	public static void main(String[] args) {
		Pravougaonik A1 = new Pravougaonik(15, 10, "Veci");
		Pravougaonik A2 = new Pravougaonik(5, "Manji");
		
		System.out.println(A1.getA());
		System.out.println(A1.getB());
		System.out.println(A1.ispisiPravougaonik());
		System.out.println("");
		System.out.println(A2.getA());
		System.out.println(A2.getB());
		System.out.println(A2.ispisiPravougaonik());
		
	}

}
