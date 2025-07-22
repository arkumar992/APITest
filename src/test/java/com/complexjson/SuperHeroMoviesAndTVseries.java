package com.complexjson;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter  // this is write in back end all get methods for declared variable
@Setter  //this is write in back end all set methods for declared variable
public class SuperHeroMoviesAndTVseries {
	
	private String Category;
	private List<String> acceptedFranchises;
	private List<String> genres;
	private List<Movies> movies;
	private List<Tvseries> tvseries;
	private OtherDetails otherdetails;
	
	/*public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public List<String> getAcceptedFranchises() {
		return acceptedFranchises;
	}
	public void setAcceptedFranchises(List<String> acceptedFranchises) {
		this.acceptedFranchises = acceptedFranchises;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<Movies> getMovies() {
		return movies;
	}
	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}
	public List<Tvseries> getTvseries() {
		return tvseries;
	}
	public void setTvseries(List<Tvseries> tvseries) {
		this.tvseries = tvseries;
	}
	public OtherDetails getOtherdetails() {
		return otherdetails;
	}
	public void setOtherdetails(OtherDetails otherdetails) {
		this.otherdetails = otherdetails;
	}
	*/
}
