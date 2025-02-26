import java.util.*;
import java.io.*;

public class Manager {
	  private List<String[]> insertData = new ArrayList<>();
	  
    public List<String[]> loadData(String filePath) {
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
