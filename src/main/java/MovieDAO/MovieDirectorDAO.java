package MovieDAO;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import hibernate_assessment4.MovieDirector.ConnectionBuilder;
import pDirector.Director;
import pHollywood.Hollywood;
import pMovie.Movie;


public class MovieDirectorDAO {
	
	public static List<Movie> MovieDetails_language(String Language) {
	    	
			Session session = ConnectionBuilder.getSession();
			session.beginTransaction();
	//		SQLQuery<Assest> query = session.createSQLQuery("Select a. assestId ,a.assestLocation,a.assestPrice,a.assestType, a.printNo, a.serialNo from assest a where a.assestPrice = (Select max(assestPrice) from assest); ");
			
			Query<Movie> query = session.createQuery(" FROM Movie where language = :language");
			query.setParameter("language", Language);
			
			List<Movie> list = query.list();
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			session.getTransaction().commit();
	
	        session.close();
			
		
		return list;
		
	}
	public static void MovieDetails_Director(String d1) {
    	
		Session session = ConnectionBuilder.getSession();
		session.beginTransaction();
//		SQLQuery<Assest> query = session.createSQLQuery("Select a. assestId ,a.assestLocation,a.assestPrice,a.assestType, a.printNo, a.serialNo from assest a where a.assestPrice = (Select max(assestPrice) from assest); ");
		
		Query<Movie> query = session.createQuery(" FROM Movie where directorId = :directorId");
		query.setParameter("directorId", d1);
		
		List<Movie> list = query.list();
//		EmployeeDetails emp = (EmployeeDetails)session.get(EmployeeDetails.class , EmpId);
		System.out.println(list);
		session.getTransaction().commit();

        session.close();

	
}
	public static void add(Movie movieDetails, Director directorDetails) {
		Session session = ConnectionBuilder.getSession();
		session.beginTransaction();
		if(movieDetails.getLanguage().equals("English")) {
			Hollywood h1= new Hollywood();
			h1.setMovieId(movieDetails.getMovieId());
    		h1.setMovieName(movieDetails.getMovieName());
    		h1.setLanguage(movieDetails.getLanguage());
    		h1.setReleasedIn(movieDetails.getReleasedIn());
    		h1.setRevenueInDollars(movieDetails.getRevenueInDollars());
		
		session.save(h1);
		
        System.out.println(h1);
		}
		session.save(movieDetails);
		session.save(directorDetails);
		session.getTransaction().commit();

        session.close();
		System.out.println(movieDetails);
		System.out.println(directorDetails);
		
		return;
	}
	
	public static void updateRevenue(String movieId) {
		try {
			Session session = ConnectionBuilder.getSession();
	        session.beginTransaction();
			Movie m1 = session.load(Movie.class, movieId);
			m1.setRevenueInDollars(m1.getRevenueInDollars()+10000);;
			
			session.update(m1);
			System.out.println("updated!");
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public static void deleteMovie(String movieName) {
		try {
			Session session = ConnectionBuilder.getSession();
	        session.beginTransaction();
	        Query<String> query = session.createQuery("Select movieId from Movie where movieName= :movieName");
			query.setParameter("movieName", movieName);
			List<String> list = query.list();
			Movie a1 = session.load(Movie.class, list.get(0));
			String directId = a1.getDirector().getDirectorId();
			
			Director d1 = session.load(Director.class, directId);
			
			Hollywood h1 = session.load(Hollywood.class, list.get(0));
			
	        if(a1.getLanguage().equals("English")) {
	        	session.delete(h1);
	        }
			session.delete(a1);
			session.delete(d1);
			session.getTransaction().commit();
			session.close();
			System.out.println("deleted!");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public static void distinctLanguage() {
		try {
			Session session = ConnectionBuilder.getSession();
	        session.beginTransaction();
	        Query<String> query = session.createQuery("Select DISTINCT language from Movie");
			
			List<String> list = query.list();
			
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			session.getTransaction().commit();
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public static void getDetails() {
    	try {
    		Session session = ConnectionBuilder.getSession();
			session.beginTransaction();
			Query<String> query = session.createQuery("movieName from Movie");
			
			List<String> list1 = query.list();
			
			Query<String> query2 = session.createQuery("directorName from Director");
			
			List<String> list2 = query.list();
			
			for(int i=0;i<list1.size();i++) {
				System.out.print(list1.get(i)+" ");
				System.out.println(list2);
			}
			
			session.getTransaction().commit();
	
	        session.close();
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("No Details found");
    	}
    	
	}
	
}
