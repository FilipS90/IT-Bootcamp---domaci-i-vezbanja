package paketic;

public abstract class AlbumArtikal extends Artikal {
	@SuppressWarnings("unused")
	private String izdavac;
	protected Album album;
	
	public AlbumArtikal( Album album, String izdavac, double cena, int kolicina) {
		super(cena, kolicina);
		this.izdavac=izdavac;
		this.album=album;
	}
	
	public abstract String ime();
}
