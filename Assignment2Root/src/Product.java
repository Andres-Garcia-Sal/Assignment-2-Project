
public class Product {
	protected int ID;
	protected String type;
	protected String title;
	protected int releaseYear;
	
	public Product(int ID,String type, String title, int releaseYear) {
		this.ID = ID;
		this.type = type;
		this.title = title;
		this.releaseYear = releaseYear;
	}
	
	public int getID() {
		return this.ID;
	}

	public String getType() {
		return this.type;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getYear() {
		return this.releaseYear;
	}
	
}
