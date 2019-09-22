package paketic;

public class Album {
	private String naziv;
	private String izvodjac;
	private Numera[] lista = new Numera [4];
	
	public Album(String naziv, String izvodjac) {
	this.naziv=naziv;
	this.izvodjac=izvodjac;
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
		for(int i=0;i<lista.length;i++) {
			if(lista[i]==null)
				break;
			String duzina = lista[i].getTrajanje();
			String [] p = duzina.split(":");
			ukupnoM+=Integer.parseInt(p[0]);
			ukupnoS+=Integer.parseInt(p[1]);
				if(ukupnoS>60) {
					ukupnoM++;
					ukupnoS-=60;
				}
		}
		String ukupno="";
		ukupno = Integer.toString(ukupnoM)+":"+Integer.toString(ukupnoS);
		return ukupno;
	}

	public void dodaj(Numera a) {
		boolean k = false;
		for(int i=0;i<lista.length;i++) {
			if(lista[i]!=null) {
				continue;
			}
			else {
				lista[i]=a;
				k = true;
				break;
			}
		}
		if(k==false) {
			Numera [] b = new Numera [lista.length+1];
			for(int i=0;i<lista.length;i++) {
				lista[i]=b[i];
			}
			b[lista.length]=a;
			lista=b;
		}
	}
	
	public void dodaj(String ime, String trajanje) {
		Numera a = new Numera (ime, getIzvodjac(), trajanje);
		dodaj(a);		
	}
	
	public Numera getNumera(int index) {
		index--;
		Numera a = lista[index];
		return a;
	}
	
	public String toString() {
		String ispis="";
		ispis+=izvodjac+" - "+naziv+":[";
		for(int i=0;i<lista.length;i++) {
			if(lista[i]==null) {
				break;
			}
			ispis+="\n\t"+lista[i].toString();
		}
		ispis+="\n]:"+getTrajanje();
		ispis+="\n";
		return ispis;
	}
}
