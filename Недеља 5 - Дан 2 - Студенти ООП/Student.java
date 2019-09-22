package paketic;

import java.util.Calendar;

public class Student {
	private String potpis;
	private String JMBG;
	private Ocena[]x;
	
	public Student(String potpis, String jMBG, Ocena[] x) {
		super();
		this.potpis = potpis;
		JMBG = jMBG;
		this.x = x;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Ocena[] getX() {
		return x;
	}

	public void setX(Ocena[] x) {
		this.x = x;
	}
	
	public double getProsecnaOcena() {
		double sum=0;
		int q=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].getOcena()<=5 || x[i]==null) {
				continue;
			}
			else {
				sum+=x[i].getOcena();
				q++;
			}
		} 	
			sum=sum/q;
			return sum;
			}
	
	public String getDatumRodjenja() {
		String datum="";
		datum+=JMBG.substring(0,2)+"."+JMBG.substring(2,4)+".";
		int dat=0;
		dat = Integer.parseInt(JMBG.substring(4,7));
			if(dat<890)
				dat+=2000;
			else
				dat+=1000;
		datum += Integer.toString(dat)+".";
		return datum;
	}
	
	public String[] imePrezime() {
		String[] imePrezime = new String[2];
		imePrezime = potpis.split(" ");
		return imePrezime;
	}
	
	public String getIme() {
		String ime = imePrezime()[0];
		return ime;
	}
	
	public String getPrezime() {
		String prezime = imePrezime()[1];
		return prezime;
	}
	
	public String najboljaOcena() {
		int broj=0;
		String predmet="";
		for(int i=0;i<x.length;i++) {
			if(broj<x[i].getOcena()) {
				broj=x[i].getOcena();
				predmet=x[i].getPr().getIme();
			}
		}
		return predmet;
	}
	
	static boolean starijiOd(Student s, int god) {
		String a = s.getDatumRodjenja();
		a = a.substring(6,10);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int b = year-Integer.parseInt(a);
		if(b>=god)
			return true;
		else
			return false;
	}
	
	static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		int q=0;
		Student [] iznad = new Student [1];
		for(int i=0;i<nizStudenata.length;i++) {
			if(q==iznad.length && nizStudenata[i].getProsecnaOcena()>ocena) {
				Student [] novi = new Student [iznad.length+1];
				for(int j=0;j<iznad.length;j++) {
					novi[j]=iznad[j];
				}
				iznad=novi;
			}
			if(nizStudenata[i].getProsecnaOcena()>ocena) {
				iznad[q]=nizStudenata[i];
				q++;
		}
		}
		return iznad;
	}
}