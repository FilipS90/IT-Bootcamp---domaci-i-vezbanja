package osoba;

public abstract class Osoba{
		private String ime;
		private String prezime;
		private String adresa;
		
		public Osoba(String ime, String prezime, String adresa) {
			this.ime = ime;
			this.prezime = prezime;
			this.adresa = adresa;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getPrezime() {
			return prezime;
		}

		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}
		
		public void copyO(Osoba p) {
			this.ime=p.ime;
		}
		
		public String toString() {
			String ispis=getIme()+" - "+getPrezime()+" - "+getAdresa();
			return ispis;
		}
		
		public abstract int numeroloskiBroj();
		
		public abstract String metabolizam(final Datum d);
		
		
}
