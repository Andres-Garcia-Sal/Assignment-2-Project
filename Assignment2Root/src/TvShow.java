
public class TvShow extends Product {
	private String director;
	private String Country;
	private String ratingTv;
	private String seasonNum;
	private String description;
	
	public TvShow(int ID, String type, String title, String director, String Country,int releaseYear, String ratingTv, String seasonNum, String description) {
		super(ID,type,title,releaseYear);
		this.director = director;
		this.Country = Country;
		this.ratingTv = ratingTv;
		this.seasonNum = seasonNum;
		this.description = description;
	}

	public String getDirector() {
		return this.director;
	}
	
	public String getCountry() {
		return this.Country;
	}
	
	public String getRatings() {
		return this.ratingTv;
	}
	
	public String getSeasonNum() {
		return this.seasonNum;
	}
	
	public String getDescription() {
		return this.description;
	}
	
}
