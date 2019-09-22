package paketic;

public class CD extends AlbumArtikal {

	public CD(Album album, String izdavac, double cena, int kolicina) {
		super(album, izdavac, cena, kolicina);
	}
	
	public String ime() {
		StringBuilder sb = new StringBuilder();
		sb.append(album.getIzvodjac()+" - "+album.getNaziv()+" (CD)");
		return sb.toString();
	}

}
