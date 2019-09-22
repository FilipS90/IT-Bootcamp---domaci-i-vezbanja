package paketic;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi broj clanova niza: ");
		int n = sc.nextInt();
		int[] Niz = new int[n];

		for (int i = 0; i < Niz.length; i++) {
			System.out.println("Unesi element niza: ");
			Niz[i] = sc.nextInt();
		}

		parniNiz(Niz);

		sc.close();

	}

	static void parniNiz(int[] a) {
		Scanner sc = new Scanner(System.in);
		int q = 0, c = 0, x = 0;
		for (int i = 0; i < a.length; i++) {
			q = 0; //brojac ponavljanja parnih brojeva u podnizu
			if (a[i] % 2 == 0)
				while (i < a.length) {
					if (a[i] % 2 == 0) {
						q++;
						i++;
							if(i==a.length && q>c) { //petlja je ubacena u slucaju da je najduzi parni podniz na kraju niza
								x=i; //indeks poslednjeg broja u parnom podnizu
								c=q; //najveci broj ponavljanja parnog podniza
								break;
							}
						continue;
					} else if (q > c) { //ukoliko je sledeci broj u ifu ispod while neparan
						c = q; //najveci broj ponavljanja parnog podniza
						q = 0; //reset brojaca ponavljanja u parnom podnizu
						x = i; //indeks poslednjeg broja u parnom podnizu
						break;
					} else
						break;
				}

		}
			for (int i = 0; i < c; i++)
			System.out.print(a[x - c + i] + " ");
		}

	}
