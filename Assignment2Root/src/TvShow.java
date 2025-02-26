
public class TvShow extends Product {
	private String director;
	private String Country;
	private String ratingTv;
	private String seasonNum;
	private String description;
	
	public TvShow(int ID, String type, String title, int releaseYear,String director, String Country, String ratingTv, String seasonNum, String description) {
		super(ID,type,title,releaseYear);
		this.director = director;
		this.Country = Country;
		this.ratingTv = ratingTv;
		this.seasonNum = seasonNum;
		this.description = description;
	}

	public String getDirector() {
		return director;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public String getRatings() {
		return ratingTv;
	}
	
	public String getSeasonNum() {
		return seasonNum;
	}
	
	public String getDescription() {
		return description;
	}
	
}
