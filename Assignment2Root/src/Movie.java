
public class Movie extends Product {
	private String Director;
	private String Country;
	private String rating;
	private int minDuration;
	private String description;
	
	public Movie(int ID, String type, String title, int releaseYear, String Director, String Country, String rating, int minDuration, String description) {
		super(ID,type,title,releaseYear);
		this.Director = Director;
		this.Country = Country;
		this.rating = rating;
		this.minDuration = minDuration;
		this.description = description;
	}
	
	public String getDirector() {
		return Director;
	}
	
	
	public String getCountry() {
		return Country;
	}
	
	
	public String getRating() {
		return rating;
	}
	
	public int getDuration() {
		return minDuration;
	}
	
	public String getDescription() {
		return description;
	}
	
}
