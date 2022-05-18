package hibernate_assessment4.MovieDirector;

import java.util.Scanner;

import MovieDAO.MovieDirectorDAO;
import pDirector.Director;
import pHollywood.Hollywood;
import pMovie.Movie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Project Started....");
    	
    	
    	System.out.println("Enter 1 for addDetails");
    	System.out.println("Enter 2 for Display the details of the movies whose language is given");
    	System.out.println("Enter 3 for Display the details of movies for the given director");
    	System.out.println("Enter 4 for Increment the revenue of the movie");
    	System.out.println("Enter 5 for Delete the record corresponding to the movie name");
    	System.out.println("Enter 6 for Retrieve the list of distinct language available");
    	System.out.println("Enter the no.: ");
    	
    	int num = sc.nextInt();
    	sc.nextLine();
    	MovieDirectorDAO mov = new MovieDirectorDAO();
    	
    	switch(num) {
    	case 1:
    	{
    		Movie m1 = new Movie();
    		System.out.print("Enter the movie Id:");
    		String movieId = sc.nextLine();
    		System.out.println("Enter the movie Name:");
    		String movieName = sc.nextLine();
    		System.out.println("Enter the movie language: ");
    		String language = sc.next();
    		System.out.println("Enter the released In");
    		Integer releasedIn = sc.nextInt();
    		sc.nextLine();
    		System.out.println("Enter the revenue in Dollars");
    		Long revenueInDollars = sc.nextLong();
    		sc.nextLine();
    		Director d1 = new Director();
    		System.out.println("Enter the Director Id");
    		String directorId = sc.nextLine();
    		System.out.println("Enter the director Name");
    		String directorName = sc.nextLine();
    		System.out.println("Enter the director born year");
    		String born = sc.next();
//    		System.out.println(born.toString().equalsIgnoreCase("null"));
    		Integer bornIn = born.toString().equalsIgnoreCase("null") ? null : Integer.parseInt(born);
    		
    		m1.setMovieId(movieId);
    		m1.setMovieName(movieName);
    		m1.setLanguage(language);
    		m1.setReleasedIn(releasedIn);
    		m1.setRevenueInDollars(revenueInDollars);
    		
    		d1.setDirectorId(directorId);
    		d1.setDirectorName(directorName);
    		d1.setBornIn(bornIn);
    		m1.setDirector(d1);
    		System.out.println(m1.getLanguage());
    		
    		mov.add(m1, d1);
    	
    		break;
    	}
    	case 2: 
    		System.out.println("Enter the Language:");
    		String Lang = sc.nextLine();
    		mov.MovieDetails_language(Lang);
    		break;
    		
    	case 3:
    		System.out.println("Enter the Director Id");
    		String Direc = sc.nextLine();
    		mov.MovieDetails_Director(Direc);
    		break;
    	case 4:
    		System.out.println("Enter the movie Id you want to increase the revenue");
    		String movId = sc.nextLine();
    		mov.updateRevenue(movId);
    		break;
    		
    	case 5:
    		System.out.println("Give the movie name You want to delete");
    		String moviName = sc.nextLine();
    		mov.deleteMovie(moviName);
    		break;
    		
    	case 6:
    		mov.distinctLanguage();
    		break;
    	}
    	
    }
}
