
public class Movie extends Product {
	private String Director;
	private String Country;
	private String rating;
	private int minDuration;
	private String description;
	
	public Movie(int ID, String type, String title, String Director, String Country, int releaseYear,  String rating, int minDuration, String description) {
		super(ID,type,title,releaseYear);
		this.Director = Director;
		this.Country = Country;
		this.rating = rating;
		this.minDuration = minDuration;
		this.description = description;
	}
	
	public String getDirector() {
		return this.Director;
	}
	
	
	public String getCountry() {
		return this.Country;
	}
	
	
	public String getRating() {
		return this.rating;
	}
	
	public int getDuration() {
		return this.minDuration;
	}
	
	public String getDescription() {
		return this.description;
	}
	
}
