package pMovie;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import pDirector.Director;

@Entity
public class Movie {
	@Id
	private String movieId;
	private String movieName;
	private String language;
	private Integer releasedIn;
	private Long revenueInDollars;
	@OneToOne
	@JoinColumn(name ="directorId")
	private Director director;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getReleasedIn() {
		return releasedIn;
	}


	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}


	public Long getRevenueInDollars() {
		return revenueInDollars;
	}


	public void setRevenueInDollars(Long revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}


	public Director getDirector() {
		return director;
	}


	public void setDirector(Director director) {
		this.director = director;
	}


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + ", director=" + director + "]";
	}
	
	
	
}
