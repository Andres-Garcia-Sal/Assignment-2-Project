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
				System.out.println(""+ p + p.getYear());
				if(p.getYear() < releaseYr){
					releaseYr=p.getYear();
					titleAndReleaseYr = p.getTitle() + "is the oldest product, released in" + releaseYr;
					System.out.println("DEBUG: titleAndReleaseYr updated to " + titleAndReleaseYr);
				}
			}
			return titleAndReleaseYr;
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
