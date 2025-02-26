
public class Product {
	private int ID;
	private String type;
	private String title;
	private int releaseYear;
	
	public Product(int ID,String type, String title, int releaseYear) {
		this.ID = ID;
		this.type = type;
		this.title = title;
		this.releaseYear = releaseYear;
	}
	
	public int getID() {
		return ID;
	}

	public String getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return releaseYear;
	}
	
}
