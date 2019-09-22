package paketic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Put {
	private Aerodrom polazni;
	private Aerodrom dolazni;
	
	public Put(Aerodrom polazni, Aerodrom dolazni) {
		super();
		this.polazni = polazni;
		this.dolazni = dolazni;
	}

	public Aerodrom getPolazni() {
		return polazni;
	}

	public Aerodrom getDolazni() {
		return dolazni;
	}
	
	public boolean direktan() {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr= new FileReader("src" + File.separator + "routes.json");
			JSONArray array = (JSONArray) parser.parse(fr);
			
			for(Object o:array) {
				JSONObject rute = (JSONObject) o;
				if(rute.get("fromAirport").equals(polazni.getSkracenica()) && rute.get("toAirport").equals(dolazni.getSkracenica())){
					return true;
				}
				if(rute.get("toAirport").equals(polazni.getSkracenica()) && rute.get("fromAirport").equals(dolazni.getSkracenica())){
					return true;
				}
			}
				
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
		return false;
		
	}
	
	
}
