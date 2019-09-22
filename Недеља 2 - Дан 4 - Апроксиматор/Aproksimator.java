package paketic;

import java.util.Scanner;

public class Aproksimator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double t=0, pol=2, id=0, q=0, suma=0, BAC=0;;
		
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		System.out.print("Unesite vasu tezinu (kg): ");
		t=sc.nextDouble();
		
		do {
			System.out.print("Unesite vas pol(ako ste musko unesite 1, ako ste zensko unesite 0): ");
			pol=sc.nextDouble();
		}while(pol!=0 && pol!=1);
		
		do {
		System.out.print("Unesite ID pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste pili: ");
		id=sc.nextDouble();
		}while(id!=1 && id!=2 && id!=3 && id!=4);
		
		do {
		do {
			System.out.print("Unesite koliko mililitara pica ste popili: ");
			q=sc.nextDouble();
			suma+=sumaAlkohola(id, q);
			System.out.print("Unesite ID pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste pili: ");
			id=sc.nextDouble();
		}while(id==1 && id==2 && id==3 && id==4 && id==-1);
			while(id!=1 && id!=2 && id!=3 && id!=4 && id!=-1) {
				System.out.print("Unesite ID pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste pili: ");
				id=sc.nextDouble();
			}
		}while(id!=-1);
		
		BAC=procenat(t,suma,pol);
		
		
		if(BAC>=0 && BAC<=0.2) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Nealkoholisano stanje",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 0");
			System.out.println("Kazneni poeni: 0 ");
			System.out.println("Zabrana voznje: 0 meseci");
		}
		else if(BAC>=0.21 && BAC<=0.5) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Umerena alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 10.000");
			System.out.println("Kazneni poeni: 0 ");
			System.out.println("Zabrana voznje: 0 meseci");
		}
		else if(BAC>=0.51 && BAC<=0.8) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Srednja alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 10.000-20.000");
			System.out.println("Kazneni poeni: 6 ");
			System.out.println("Zabrana voznje: 3 meseca");
		}
		else if(BAC>=0.81 && BAC<=1.2) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Visoka alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 20.000-40.000");
			System.out.println("Kazneni poeni: 8 ");
			System.out.println("Zabrana voznje: 4 meseca");
		}
		else if(BAC>=1.21 && BAC<=1.6) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Teska alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 100.000-120.000");
			System.out.println("Kazneni poeni: 9 ");
			System.out.println("Zabrana voznje: 8 meseca");
		}
		else if(BAC>=1.61 && BAC<2) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Vrlo teska alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 100.000-120.000");
			System.out.println("Kazneni poeni: 14 ");
			System.out.println("Zabrana voznje: 8 meseci");
		}
		else {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f  Potpuna alkoholisanost",BAC);
			System.out.println("");
			System.out.println("--------------------");
			System.out.println("Kazna: 30-60 dana zatvora");
			System.out.println("Kazneni poeni: 15 ");
			System.out.println("Zabrana voznje: 9 meseci");
		}
		
	
	}
	
	static double  sumaAlkohola(double a, double b) {
		Scanner sc = new Scanner(System.in);
		double suma=0;
		if (a==1)
			a=0.5;
		else if(a==2)
			a=0.4;
		else if(a==3)
			a=0.047;
		else
			a=0.11;
		suma=a*b;
		return suma;
	}
	
	static double procenat(double tezina, double suma, double pol) {
		Scanner sc = new Scanner(System.in);
		Double BAC;
		if(pol==1)
			pol=0.55;
		else
			pol=0.68;
		tezina*=1000;
		BAC=(suma/(tezina*pol)*1000);
		return BAC;
	}
	
	

}