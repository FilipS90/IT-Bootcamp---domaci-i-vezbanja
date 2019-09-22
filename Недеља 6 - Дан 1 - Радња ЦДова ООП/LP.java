package paketic;

public class LP extends AlbumArtikal {
	private int tezina;
	
	public LP(Album album, String izdavac, double cena, int kolicina, int tezina) {
		super(album, izdavac, cena, kolicina);
		this.tezina=tezina;
	}
	
	public String ime() {
		StringBuilder sb = new StringBuilder();
		sb.append(album.getIzvodjac()+" - "+album.getNaziv()+" ("+tezina+"[g] LP)");
		return sb.toString();
	}
	
}
