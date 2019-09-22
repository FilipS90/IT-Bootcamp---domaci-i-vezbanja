package paketic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite ime polaznog aerodroma: ");
		String polazni = sc.nextLine();
		System.out.println("Unesite ime dolaznog aerodroma: ");
		String dolazni = sc.nextLine();
		
		Put put = napravi(polazni, dolazni);

		if(put==null) {
			sc.close();
			return;
		}
		if(put.direktan()) {
			int distanca = distanca(put);
			System.out.println(put.getPolazni().getGrad()+" - "+put.getDolazni().getGrad()+" - "+distanca);
			System.out.println("Ukupno: "+distanca);
		}
		else {
			System.out.println("Radimo na tome.:)");
		}
		
		sc.close();
	}
	
	public static Put napravi(String p, String d) {
		Put put=null;
		try {
			FileReader fr = new FileReader("src" + File.separator + "airports.json");
			JSONParser parser = new JSONParser();
			JSONArray niz = (JSONArray) parser.parse(fr);
			Aerodrom a1=null;
			Aerodrom a2=null;
			
			for(Object o: niz) {
				JSONObject a = (JSONObject) o;
				if(p.equals((String)a.get("name"))) {
					a1 = new Aerodrom((int)(long)a.get("airportID"),(String)a.get("name"), (String)a.get("city"), (String)a.get("country"), (double)a.get("latitude"), (double)a.get("longitude"), (String)a.get("iata"));
				}
				if(d.equals((String)a.get("name"))) {
					a2 = new Aerodrom((int)(long)a.get("airportID"),(String)a.get("name"), (String)a.get("city"), (String)a.get("country"), (double)a.get("latitude"), (double)a.get("longitude"), (String)a.get("iata"));
				}
			}
			if(a1==null) {
				System.out.println("Odabrani prvi aerodrom ne postoji u bazi.");
				return null;
			}
			if(a2==null) {
				System.out.println("Odabrani drugi aerodrom ne postoji u bazi.");
				return null;
			}
			if(a1.getID()==a2.getID()) {
				System.out.println("Greska: Ponovili ste isti aerodrom dva puta.");
				return null;
			}
			
			put = new Put(a1,a2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return put;
		
	}
	
	public static int distanca(Put p) {
		double lat1 = p.getPolazni().getLatitude();
		double lon1 = p.getPolazni().getLongitude();
		double lat2 = p.getDolazni().getLatitude();
		double lon2 = p.getDolazni().getLongitude();
		
		double theta = lon1 - lon2;
		double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		dist*=1.609344;

		return (int) dist;
	}
	
	
}
