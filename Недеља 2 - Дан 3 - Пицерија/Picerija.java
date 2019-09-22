package paketic;

import java.util.Scanner;

public class Picerija {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u Brasko++ pametnu kasu!");
		int n=0;
		
		do {
			System.out.println("Koji je danas dan (Pon/Uto/Sre/Cet/Pet/Sub/Ned): ");
			String d=sc.nextLine();
			switch(d) {
			case "Pon": 
			case "Sre":
			case "Pet": kupovina(d);n=1;break;
			case "Uto": kupovina(d);n=1;break;
			case "Cet": kupovina(d);n=1;break;
			case "Sub":	
			case "Ned": kupovina(d);n=1;break;
			default: System.out.println("Los unos, ponovi.");break;
			}
	}while(n!=1);
	}
	
	static void kupovina(String n) {
		Scanner sc = new Scanner(System.in);
		int i = 1, brP=0, id=0, p=1, q=1, sumaC=0, sumaP=0, sumaV=0;
		String pica1="Pizza Capricciosa 320", pica2="Pizza Pepperoni 290", pica3="Pizza Vesuvio 310";
		
		System.out.print("Musterija id#"+i+": ");
		brP=sc.nextInt();
		
		do {
			System.out.println("-- Racun za musteriju id#"+i+" ---");
			while(brP-->0) {
				id=sc.nextInt();			
					if(id==2 || id==3 || id==5) {
					if(id==2) {
						if(p%7==0) {
							System.out.println("AKCIJA #7 Capricciosa 0");
							p++;
							q++;
						}
						else {
							if(q%4==0) {
							System.out.println("AKCIJA 3+1 Capricciosa 0");
							p++;
							q++;
							}
							else {
							System.out.println(pica1);
							sumaC+=320;
							p++;
							q++;
							}
						}
					}
					else if(id==3) {
						if(p%7==0) {
							System.out.println("AKCIJA #7 Pepperoni 0");
							p++;
							q++;
						}
						else {
							if(q%4==0) {
								System.out.println("AKCIJA 3+1 Pepperoni 0");
								p++;
								q++;
							}
							else {
								System.out.println(pica2);
								sumaP+=290;
								p++;
								q++;
							}
						}
					}
					else if(id==5){
						if(p%7==0) {
							System.out.println("AKCIJA #7 Pepperoni 0");
							p++;
							q++;
						}
						else {
							if(q%4==0) {
								System.out.println("AKCIJA 3+1 Pepperoni 0");
								p++;
								q++;
							}
							else {
								System.out.println(pica3);
								sumaV+=310;
								p++;
								q++;
							}
						}
					}
				}
					else {
						sumaC=0;
						sumaP=0;
						sumaV=0;
						if(p>1)p--;
						break;		
					}
			}
			
			double z=sumaC+sumaP+sumaV;
			if(n.equals("Uto") && sumaV>0) {
				double popust=sumaV/10;
				sumaV=(sumaV/10)*9;
				System.out.println("Dnevna 10% Vesuvio: "+(-popust));
				z-=popust;
			}
			else if(n.equals("Cet") && sumaC>0) {
				double popust=sumaC/10;
				sumaV=(sumaV/10)*9;
				System.out.println("Dnevna 10% Cappriciosa: "+(-popust));
				z-=popust;
			}
			else if(n.equals("Sub") || n.equals("Ned")) {
				double popust=(z/100)*15;
				z=(z/100)*85;
				System.out.println("Dnevna 15% sve: "+(-popust));
			}
				
			System.out.println("\tukupno: "+z);
			System.out.println("--------------------------");
			System.out.println("--------------------------");
			sumaC=0;
			sumaP=0;
			sumaV=0;
			i++;
			z=0;
			q=1;
			
			System.out.print("Musterija id#"+i+": ");
			brP=sc.nextInt();
	}while(brP!=-1);
		
	}
			
}