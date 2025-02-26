import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Manager manage = new Manager();
        List<String[]> data = manage.loadData("./dataset.csv");
        
        // Check if data is not empty before printing
        
        if (!data.isEmpty()) {
        	for(int i = 0; i < 41; i++) {
        		System.out.println(Arrays.toString(data.get(i)));
        	}
            System.out.println("Total number of products: " + manage.countProduct());
            System.out.println("Total number of Movies: " + manage.countMovies());
            System.out.println("Total number of Video Games: " + manage.countGames());
            System.out.println("Total number of Music Albums: " + manage.countMusic());
            System.out.println("Total number of TV Shows: " + manage.countShows());
            
            }
        else {
            System.out.println("No data found.");
        }
    }
}
			/*
			System.out.println("Oldest Product: " + manage.oldProduct);
			System.out.println("Popular Music Album: " + manage.popMusic);
			System.out.println("Popular Video Game: " + manage.popGame);
			System.out.println("Common Rating: " + manage.commonRate);
			System.out.println("Shortest Movie: " + manage.shortMovie);
			System.out.println("Shortest Music Album: " + manage.shortAlbum);
			*/
		
	

