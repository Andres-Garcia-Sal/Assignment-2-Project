
public class Music extends Product{
	private String artist;
	private int globalSales;
	private int trackNum;
	private double duration;
	private String genre;
	
	public Music(int ID, String type, String title, int releaseYear,String artist, int globalSales, int trackNum, double duration, String genre) {
		super(ID,type,title,releaseYear);
		this.artist = artist;
		this.globalSales = globalSales;
		this.trackNum = trackNum;
		this.duration = duration;
		this.genre = genre;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getGlobalSale() {
		return globalSales;
	}
	
	public int getTrackNum() {
		return trackNum;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String getGenre() {
		return genre;
	}
	
}
