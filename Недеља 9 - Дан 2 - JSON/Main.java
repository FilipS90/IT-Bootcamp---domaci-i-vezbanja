package paketic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Tim> timovi = ucitaj();
		String upit="", ime1="", prez1="", ime2="", prez2="",naziv="";
		int godine1=0, godine2=0, pozicija1=0,pozicija2=0;
		System.out.println("Da li zelite da dodate tim?");
		upit=sc.nextLine();
		
		while(upit.equals("da")) {
			System.out.println("Zadajte naziv za vas tim: ");
			naziv=sc.nextLine();
			System.out.println("Dodajte ime, prezime, godine i poziciju prvog igraca:");
			ime1=sc.nextLine();
			prez1=sc.nextLine();
			godine1=Integer.parseInt(sc.nextLine());
			pozicija1=Integer.parseInt(sc.nextLine());
			System.out.println("Dodajte ime, prezime, godine i poziciju drugog igraca:");
			ime2=sc.nextLine();
			prez2=sc.nextLine();
			godine2=Integer.parseInt(sc.nextLine());
			pozicija2=Integer.parseInt(sc.nextLine());
			
			Vozac V1 = new Vozac(ime1,prez1,godine1,pozicija1);
			Vozac V2 = new Vozac(ime2,prez2,godine2,pozicija2);
			Tim Novi = new Tim(naziv,V1,V2);
			
			if(ok(Novi, timovi)) {
				upis(Novi);
				System.out.println("Prijava uspesna.");
				timovi.add(Novi);
				System.out.println("Da li zelite da dodate tim?");
				upit=sc.nextLine();
			}
			else {
				System.out.println("Prijava neuspesna, pokusajte opet.");
				System.out.println("Da li zelite da dodate tim?");
				upit=sc.nextLine();
			}
			}
		}
	
	public static boolean ok(Tim t, ArrayList<Tim> a) {
		int x = a.size();
		for(int i=0;i<x;i++) {
			if(t.getV1().getIme().equals(a.get(i).getV1().getIme()) && t.getV1().getPrezime().equals(a.get(i).getV1().getPrezime())){
				return false;
			}
			if(t.getV2().getIme().equals(a.get(i).getV2().getIme()) && t.getV2().getPrezime().equals(a.get(i).getV2().getPrezime())){
				return false;
			}
			if(t.getV2().getIme().equals(a.get(i).getV1().getIme()) && t.getV2().getPrezime().equals(a.get(i).getV1().getPrezime())){
				return false;
			}
			if(t.getV1().getIme().equals(a.get(i).getV2().getIme()) && t.getV1().getPrezime().equals(a.get(i).getV2().getPrezime())){
				return false;
			}
			if(t.getNaziv().equals(a.get(i).getNaziv())) {
				return false;
			}
			
		}
		return true;
		
	}
	
	public static void upis(Tim t) {
		JSONObject tim = new JSONObject();
		JSONObject V1 = new JSONObject();
		JSONObject V2= new JSONObject();
		
		V1.put("ime", t.getV1().getIme());
		V1.put("prezime", t.getV1().getPrezime());
		V1.put("godine", t.getV1().getGodine());
		V1.put("pozicija", t.getV1().getPozicija());
		V2.put("ime2", t.getV2().getIme());
		V2.put("prezime2", t.getV2().getPrezime());
		V2.put("godine2", t.getV2().getGodine());
		V2.put("pozicija2", t.getV2().getPozicija());
		
		tim.put("naziv", t.getNaziv());
		tim.put("vozac1", V1);
		tim.put("vozac2", V2);
		
		try {
			FileWriter fw = new FileWriter("timovi", true);
			fw.write(tim.toString()+"\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Tim> ucitaj() {
		ArrayList<Tim> timovi = new ArrayList<Tim>();
		
		try {
			JSONParser parser = new JSONParser();
			FileReader fr = new FileReader("timovi");
			BufferedReader br = new BufferedReader(fr);
			String linija = br.readLine();
		
			
			while(linija!=null) {
				JSONObject obj = (JSONObject) parser.parse(linija);
				String nazivT = (String) obj.get("naziv");
				JSONObject V1 = (JSONObject) obj.get("vozac1");
				JSONObject V2 = (JSONObject) obj.get("vozac2");
				
				String ime1 = (String) V1.get("ime");
				String prez1= (String) V1.get("prezime");
				int godine = (int) (long) V1.get("godine");
				int pozicija = (int) (long)V1.get("pozicija");
				String ime2 = (String) V2.get("im2");
				String prez2= (String) V2.get("prezime2");
				int godine2 = (int) (long)V2.get("godine2");
				int pozicija2 = (int) (long)V2.get("pozicija2");
				
				Vozac f1 = new Vozac (ime1, prez1, godine, pozicija);
				Vozac f2 = new Vozac (ime2, prez2, godine2, pozicija2);
				Tim Moto = new Tim(nazivT, f1, f2);
				
				timovi.add(Moto);
				linija = br.readLine();
				
			}
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timovi;

	}

}
