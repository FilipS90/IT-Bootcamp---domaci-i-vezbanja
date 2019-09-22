package paketic;

import java.util.Scanner;
import java.util.Random;

public class Matrica {
    //NIJE DOZVOLJENO MENJANJE MAIN FUNKCIJE!!!!!!!!!!!!!!
    //NIJE DOZOVLJENO MENJANJE POTPISA FUNKCIJA(POTPIS FUNKCIJE SE SASTOJI OD POVRATNE VREDNOSTI, IMENA FUNKCIJE I PARAMETARA
    //DOZVOLJENO JE ALI NIJE POZELJNO NITI POTREBNO DEFINISATI I DODAVATI NOVE FUNKCIJE
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite dimenziju kvadratne matrice (n): ");
        int n = sc.nextInt();

        int[][] matrica = new int[n][n];
        generisiElementeMatrice(matrica, 100);
        System.out.println("Matrica izgleda ovako: ");
        ispisiMatricu(matrica);
        System.out.println();

        int[] elementiNaglavnoj = elementiNaGlavnojDijagonali(matrica);
        System.out.println("Elementi na glavnoj dijagonali su: ");
        if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
        else System.out.println("Greska u funkciji elementiNaGlavnojDijagonali");
        System.out.println();

        System.out.println("Elementi na sporednoj dijagonali su: ");
        int[] elementiNaSporednoj = elementiNaSporednojDijagonali(matrica);
        if(elementiNaSporednoj!=null) ispisiNiz(elementiNaSporednoj);
        else System.out.println("Greska u funkciji elementiNaSporednojDijagonali");
        System.out.println();

        System.out.println("Elementi iznad glavne dijagonale su: ");
        ispisiElementeIznadGlavneDijagonale(matrica);
        System.out.println();

        System.out.println("Elementi ispod glavne dijagonale su: ");
        ispisiElementeIspodGlavneDijagonale(matrica);
        System.out.println();

        int[][] transponovanaMatrica = transponujMatricu(matrica);
        System.out.println("Transponovana matrica izgleda ovako: ");
        if(transponovanaMatrica!=null)ispisiMatricu(transponovanaMatrica);
        else System.out.println("Greska u funkciji transponujMatricu.");
        System.out.println();

        System.out.println("Pre uklanjanja duplih elemenata niz izgleda ovako: ");
        ispisiNiz(elementiNaglavnoj);
        System.out.println();

        elementiNaglavnoj = ukloniElementeKojiSePonavljajuUnizu(elementiNaglavnoj);
        System.out.println("Nakon uklanjanja duplih elemenata niz izlgeda ovako: ");
        if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
        else System.out.println("Greska u funkcji ukloniElementeKojiSePonavljajuUnizu");
        
        sc.close();
    }

    public static void generisiElementeMatrice(int[][] matrica, int gornjaGranica){
    	Random rand = new Random();
        for(int i=0;i<matrica.length;i++) {
        	for(int j=0;j<matrica.length;j++) {
        		matrica[i][j]=rand.nextInt(gornjaGranica);
        	}
        }
    }

    public static int[] elementiNaGlavnojDijagonali(int[][] matrica){
    	int[] dijagonala = new int[matrica.length];
    	int z=0;
    	for(int i=0;i<matrica.length;i++) {
    			dijagonala[i]=matrica[i][z];
    			z++;
    		}

        return dijagonala;
    }

    public static int[] elementiNaSporednojDijagonali(int[][] matrica){
    	int[] dijagonala = new int[matrica.length];
    	int z=0;
    		for(int i=matrica.length-1;i>=0;i--) {
    				dijagonala[z]=matrica[i][z];
    				z++;
    		}
    		 
    		return dijagonala;
    		}	
    		


    public static int[][] transponujMatricu(int[][] matrica){
    	int[][] transponovana = new int [matrica.length][matrica.length];
        for(int i=0; i<matrica.length;i++) {
        	for(int j=0; j<matrica[i].length;j++) {
        		transponovana[i][j] = matrica[j][i];
        	}
        }

        return transponovana;
    }

    public static void ispisiElementeIznadGlavneDijagonale (int[][] matrica){
    	for(int i=0;i<matrica.length;i++){
    		  for(int j=i+1;j<matrica.length;j++){
    		      System.out.print(matrica[i][j]+" ");
    		  }
    		}
    	System.out.println("");
    	}


    public static void ispisiElementeIspodGlavneDijagonale (int[][] matrica){
    	for(int i=1;i<matrica.length;i++){
  		  for(int j=0;j<=i-1;j++){
  		      System.out.print(matrica[i][j]+" ");
  		  }
  		}	
    	System.out.println("");
	}


    public static void ispisiMatricu(int[][] matrica){
    	for(int i=0;i<matrica.length;i++) {
    		System.out.println("");
        	for(int j=0;j<matrica.length;j++) {
        		System.out.print(matrica[i][j]+ " ");
        	}
        }
    	System.out.println("");
    }

    public static void ispisiNiz(int[] niz){
        for(int i=0;i<niz.length;i++) {
        	System.out.print(niz[i]+" ");
        }
        System.out.println("");
    }

    public static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz){
        int[] noviNiz = new int[niz.length];
        int q=0;
        for(int i=0; i<niz.length; i++) {
        	for(int j=1+i;j<niz.length;j++) {
        		int a = niz[i];
        		int b = niz [j];
        			if(a==b)
        				i++;
        	}		
        	noviNiz[q]+=niz[i];	    
        	q++;
        }
        return noviNiz;
    }


}






