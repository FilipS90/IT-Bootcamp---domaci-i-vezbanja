package paketic;

public class Main {

	public static void main(String[] args) {
		StudentMasterStudija Bot = new StudentMasterStudija("Milos", "Markovic",1990,5,8.7,"Biologija","Molekularna biologija");
		String [] lista = {"Rimsko pravo", "Krivicno pravo","Porodicno pravo"};
		String [] lista2 = {"Biologija", "Molekularna biologija","Ekologija"};
		Profesor Pera = new Profesor("Petar", "Petrovic", 1959,1998,100000, lista, "redovni");
		Asistent Dragan = new Asistent("Dragan","Misic",1994,2018,78000,lista2,"Ekologija");
		Sluzbenik Mika = new Sluzbenik("Mika", "Jovanovic", 1969, 1999, 90000, "Administracija");
		
		System.out.println(Pera);
		System.out.println("");
		System.out.println(Dragan);
		System.out.println("");
		System.out.println(Mika);
		System.out.println("");
		System.out.println(Bot);
		
		
	}

}
