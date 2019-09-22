package paketic;

import java.util.HashMap;
import java.util.TreeMap;

public class Zadatak1 {

	public static void main(String[] args) {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("Aleksa", 25);
		mapa.put("Zarko", 87);
		mapa.put("Lidija", 3);
		mapa.put("Ivan", 11);
		mapa.put("Dragana", 37);
		mapa.put("Vuk", 55);
		mapa.put("Bojan", 55);
		mapa.put("Stefan", 55);
		
		
		sortiraj(mapa);
		
	}
	
	public static void sortiraj(HashMap<String,Integer> a) {
		TreeMap<String,Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(a);
		
		for(String s : sortedMap.keySet()) {
			System.out.println(s+" "+sortedMap.get(s));
		}
	}
}
