import java.util.*;
import java.io.*;

public class Manager {
	  private ArrayList<String[]> insertData = new ArrayList<>();
	  
    public ArrayList<String[]> loadData(String filePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] values = line.split(",");
                insertData.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception, could log or throw as needed
        } finally {
            try {
                if (br != null) {
                    br.close();  // Ensure the BufferedReader is closed
                }
            } catch (IOException e) {
                e.printStackTrace();  // Handle the exception during close
            }
        }
        return insertData;
    }
    public ArrayList<Product> inventory = new ArrayList<>();
    public void createInventory(){
			for(String[] str : insertData){
				switch (str[1]) {
					case "Movie":
						inventory.add(new Movie(Integer.parseInt(str[0]), str[1] ,str[2], str[3], str[4], Integer.parseInt(str[5]), str[6], Integer.parseInt(str[7]), str[8]));
						                //Movie(int ID, String type, String title, String Director, String Country, int releaseYear,  String rating, int minDuration, String description)
						break;
					case "Music Album":
					inventory.add(new Music(Integer.parseInt(str[0]), str[1] ,Integer.parseInt(str[2]), str[3], str[4], Integer.parseInt(str[5]), Integer.parseInt(str[6]), Double.parseDouble(str[7]), str[8]));
					                //Music(int ID, String type,int releaseYear, String artist, String title, int globalSales, int trackNum, double duration, String genre)
						break;
					case "TV Show":
					inventory.add(new TvShow(Integer.parseInt(str[0]), str[1] ,str[2], str[3], str[4], Integer.parseInt(str[5]), str[6], str[7], str[8]));						
					                //TvShow(int ID, String type, String title, String director, String Country,int releaseYear, String ratingTv, String seasonNum, String description)
						break;
					case "Video Game":
					inventory.add(new VideoGames(Integer.parseInt(str[0]), str[1] ,str[2], str[3],Integer.parseInt(str[4]) , str[5], str[6], Double.parseDouble(str[7])));			
					                //VideoGames(int ID, String type, String title, String platform,int releaseYear, String genre, String publisher, double copySold)				
						break;				
					default:
						break;
				}
			}
		}
		public int countProduct() {
    	return insertData.size();
    }
    public int countMovies() {
    	int movieCount = 0;
    	
    	for(String[] row: insertData) {
    		if(row.length > 1 && row[1].equalsIgnoreCase("Movie")) {
    			movieCount++;
    		}
    	}
    	return movieCount;
	}
    
    public int countGames() {
    	int gameCount = 0;
    	
    	for(String[] row: insertData) {
    		
    		if(row.length > 1 && row[1].equalsIgnoreCase("Video Game")) {
    			gameCount++;
    		}
    	}
    	return gameCount;
	}
    
    public int countMusic() {
    	int musicCount = 0;
    	
    	for(String[] row: insertData) {
    		if(row.length > 1 && row[1].equalsIgnoreCase("Music Album")) {
    			musicCount++;
    		}
    	}
    	return musicCount;	
    }
    
    public int countShows() {
    	int showCount = 0;
    	
    	for(String[] row: insertData) {
    		if(row.length > 1 && row[1].equalsIgnoreCase("Tv Show")) {
    			showCount++;
    		}
    	}
    	return showCount;
    }
    
		public String oldProduct(){
			String titleAndReleaseYr="";
			int releaseYr=2025; 

			for(Product p : inventory){
				if(p.getYear() < releaseYr){
					releaseYr=p.getYear();
					titleAndReleaseYr = p.getTitle() + "is the oldest product, released in " + releaseYr;
				}
			}
			return titleAndReleaseYr;
		}

		public String popMusic(){
			String titleAndSales="";
			int maxSales=0;
			for(Product p : inventory){
				if(p instanceof Music){
				Music m = (Music) p;
					if(m.getGlobalSale()>maxSales){
						maxSales=m.getGlobalSale();
						titleAndSales=m.getTitle() + " by " + m.getArtist() + " is the most sold music album on the inventory, with " + maxSales + " sales globally.";
					}
				}
			}
			return titleAndSales;
		}

		public String popGame(){
			String titleAndSales = "";
			double maxSales=0;
			for(Product p : inventory){
				if(p instanceof VideoGames){
				VideoGames v = (VideoGames) p;
					if(v.getCopySold()>maxSales){
						maxSales=v.getCopySold();
						titleAndSales= v.getTitle() + ", published by " + v.getPublish() + " for the "+ v.getPlatform() +" is the most sold videogame on the inventory, with " + maxSales + " million sales globally.";
					}
				}
			}
			return titleAndSales;
		}

		public String commonRate(){
			String result = "";
			int PG13Count=0;
			int TVMACount=0;
			int TV14Count=0;
			int TVPGCount=0;
			int TVY7Count=0;


			
			for(Product p : inventory){
				if(p instanceof TvShow){
					TvShow t = (TvShow) p;
					switch (t.getRating()) {
						case "PG-13":
							PG13Count++;
							break;
						case "TV-MA":
							TVMACount++;
							break;
						case "TV-14":
							TV14Count++;
							break;
						case "TV-PG":
							TVPGCount++;
							break;
						case "TV-Y7":
							TVY7Count++;
							break;
						default:
							break;
					}
				}else	if(p instanceof Movie){
					Movie m = (Movie) p;
					switch (m.getRating()) {
						case "PG-13":
							PG13Count++;
							break;
						case "TV-MA":
							TVMACount++;
							break;
						case "TV-14":
							TV14Count++;
							break;
						case "TV-PG":
							TVPGCount++;
							break;
						case "TV-Y7":
							TVY7Count++;
							break;
						default:
							break;
					}
				}
				if(PG13Count>=TVMACount&&PG13Count>=TV14Count&&PG13Count>=TVPGCount&&PG13Count>=TVY7Count){
					result = "PG-13 is the most frequent age rating in movies and TV shows in our inventory. Our inventory has "+PG13Count;
				} else if(TVMACount>=PG13Count&&TVMACount>=TV14Count&&TVMACount>=TVPGCount&&TVMACount>=TVY7Count){
					result = "TV-MA is the most frequent age rating in movies and TV shows in our inventory. Our inventory has "+TVMACount;
				} else if(TV14Count>=PG13Count&&TV14Count>=TVMACount&&TV14Count>=TVY7Count&&TV14Count>=TVPGCount){
					result = "TV-14 is the most frequent age rating in movies and TV shows in our inventory. Our inventory has "+TV14Count;
				} else if(TVPGCount>=PG13Count&&TVPGCount>=TVMACount&&TVPGCount>=TVY7Count&&TVPGCount>=TV14Count){
					result = "TV-14 is the most frequent age rating in movies and TV shows in our inventory. Our inventory has "+TV14Count;
				} else if(TVY7Count>=PG13Count&&TVY7Count>=TVMACount&&TVY7Count>=TVPGCount&&TVY7Count>=TV14Count){
					result = "TV-14 is the most frequent age rating in movies and TV shows in our inventory. Our inventory has "+TV14Count;
				}
		}
			return result;
	}
	public String shortMovie(){
		int currMinDuration = 500;
		String result = "";
			for(Product p : inventory){
				if(p instanceof Movie){
					Movie m = (Movie) p;
					if(m.getDuration()<currMinDuration){
						currMinDuration = m.getDuration();
						result = m.getTitle() + " is the shortest movie in our inventory, with a runtime of "+currMinDuration+" minutes.";
					}
				}
			}
			return result;
	}
	public String shortAlbum(){
		double currMinDuration = 5000.0;
		String result = "";
			for(Product p : inventory){
				if(p instanceof Music){
					Music m = (Music) p;
					if(m.getDuration()<currMinDuration){
						currMinDuration = m.getDuration();
						result = m.getTitle() + " by "+ m.getArtist() +" is the shortest music album in our inventory, with a duration of "+currMinDuration+" minutes.";
					}
				}
			}
			return result;
	}
}
		
	/*
	
	//Create different functions for the call in the Driver
	public int countProduct() {
		return media.size(); //temp values
	}
	public int countMovies() {
		return 0;  //temp values
	}
	public int countGames() {
		return 0;	//temp values
	}
	public int countShows() {
		return 0;	//temp values
	}
	public int countMusic() {
		return 0;	//temp values
	}
	
}
*/
