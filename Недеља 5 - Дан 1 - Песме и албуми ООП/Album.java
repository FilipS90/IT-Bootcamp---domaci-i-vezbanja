package paketic;

import java.util.Date;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private MuzickaNumera[] nizPesama = new MuzickaNumera[5];
	private int brPesama=0;
	
	
	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
	}
	
	public boolean brojPesama() {
		if(brPesama == nizPesama.length)
			return true;
		else
			return false;
	}
	
	public void dodajPesmu(MuzickaNumera a) {
		if(brojPesama()) {
			MuzickaNumera[] noviNiz = new MuzickaNumera [2*nizPesama.length];
			for(int i=0;i<nizPesama.length;i++) {
				noviNiz[i]=nizPesama[i];
			}
			noviNiz[nizPesama.length+1]=a;
			nizPesama=noviNiz;
			brPesama++;
		}
		else {
			for(int i=0;i<nizPesama.length;i++) {
				if(nizPesama[i]==null) {
					nizPesama[i]=a;
					brPesama++;
					break;
				}
			}
		}
	}
	
	public void ukloni(int pozicija) {
		pozicija-=1;
		nizPesama[pozicija]=null;
	}
	
	public void dodaj(String name, String trajanje) {
		MuzickaNumera a = new MuzickaNumera(name, izvodjac, trajanje);
		dodajPesmu(a);
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public String getIzvodjac() {
		return izvodjac;
	}
	
	public String getTrajanje() {
		int ukupnoS=0;
		int ukupnoM=0;
		for(int i=0;i<nizPesama.length;i++) {
			if(nizPesama[i]==null)
				break;
			String duzina = nizPesama[i].getTrajanje();
			String [] minisec = duzina.split(":");
			ukupnoM+=Integer.parseInt(minisec[0]);
			ukupnoS+=Integer.parseInt(minisec[1]);
				if(ukupnoS>60) {
					ukupnoS-=60;
					ukupnoM+=1;
		}
	}
		String ukupno="";
		ukupno=Integer.toString(ukupnoM)+":"+Integer.toString(ukupnoS);
		return ukupno;
	
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public MuzickaNumera getMuzickaNumera(int index) {
		MuzickaNumera a = nizPesama[index];
		return a;
	}
	
	public MuzickaNumera getPesma(String ime) {
		MuzickaNumera a = null;
		for(int i=0; i<nizPesama.length;i++) {
			if(ime.equals(nizPesama[i].getNaziv())) {
				a = nizPesama[i];
				return a;
			}
		}
		return a;
	}
	
	public String toString() {
		String ispis="";
		ispis+=izvodjac+" - "+naziv+"("+datum+"):[";
		for(int i=0;i<nizPesama.length;i++) {
			if(nizPesama[i]==null) {
				break;
			}
			ispis+="\n\t"+nizPesama[i].toString();
		}
		ispis+="\n]:"+getTrajanje();
		ispis+="\n";
		return ispis;
	}
	
	
	
}
