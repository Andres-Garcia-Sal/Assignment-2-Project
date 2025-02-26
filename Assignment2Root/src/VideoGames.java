
public class VideoGames extends Product{
	private String platform;
	private String genre;
	private String publisher;
	private double copySold;
	
	public VideoGames(int ID, String type, String title, int releaseYear,String platform, String genre, String publisher, double copySold){
		super(ID, type, title, releaseYear);
		this.platform = platform;
		this.genre = genre;
		this.publisher = publisher;
		this.copySold = copySold;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	
	public String getGenre() {
		return genre;
	}
	

	public String getPublish() {
		return publisher;
	}
	
	
	public double getCopySold () {
		return copySold;
	}
	

}
