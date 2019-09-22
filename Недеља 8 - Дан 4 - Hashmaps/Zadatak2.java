package paketic;

import java.util.HashMap;

public class Zadatak2 {

	public static void main(String[] args) {
		int [] niz = {2,3,5,4,5,2,4,3,5,2,4,4,2};
		
		System.out.println(pronadji(niz));

	}
	
	public static int pronadji(int [] a) {
		HashMap<Integer, Integer> Hash = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(Hash.containsKey(a[i])) {
				int val = Hash.get(a[i]);
				Hash.put(a[i], val+1);
			}
			else
				Hash.put(a[i], 1);
		}
		for(int s : Hash.keySet()) {
			if(Hash.get(s)%2==1)
				return s;
		}
			return -1;

	}	
}



