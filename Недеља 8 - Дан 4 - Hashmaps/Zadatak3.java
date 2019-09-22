package paketic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Zadatak3 {

	public static void main(String[] args) {
		ArrayList<String> svaDeca = new ArrayList<String>();
		svaDeca.add("Pera");
		svaDeca.add("Mika");
		svaDeca.add("Zika");
		svaDeca.add("Laza");
		svaDeca.add("Aca");
		svaDeca.add("Zile");
		svaDeca.add("Bogi");
		
		ArrayList<String> dobraDeca = new ArrayList<String>();
		dobraDeca.add("Bogi");
		dobraDeca.add("Aca");
		dobraDeca.add("Zile");
		dobraDeca.add("Pera");
		dobraDeca.add("Laza");
		
		HashMap<String,Integer> mraz = dedaMraz(svaDeca, dobraDeca);
		System.out.println(mraz);
		
		for(String z : mraz.keySet()) {
			if(mraz.get(z)>1)
				System.out.println(z+" je ucinio "+mraz.get(z)+" lepa dela.");
		}
	}
	
	public static HashMap<String, Integer> dedaMraz(ArrayList<String> a, ArrayList<String> b){
		Random rand = new Random();
		HashMap<String, Integer> mraz = new HashMap<>();
		for(String i: a) {
			if(b.contains(i)) {
				mraz.put(i, rand.nextInt(2)+1);
			}
			else {
				mraz.put(i, 0);
			}
		}
		return mraz;
		
	}

}
