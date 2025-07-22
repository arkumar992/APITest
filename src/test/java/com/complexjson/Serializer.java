package com.complexjson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		
		SuperHeroMoviesAndTVseries heromoviesandTVseries  = new SuperHeroMoviesAndTVseries();
		heromoviesandTVseries.setCategory("Super Hero Movies And TV series");
		List<String> acceptedFranchies = new ArrayList<String>();
		acceptedFranchies.add("DC");
		acceptedFranchies.add("Marvel");
		heromoviesandTVseries.setAcceptedFranchises(acceptedFranchies);
		
		List<String> genres = new ArrayList<String>();
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Heroic");
		genres.add("Dark");
		genres.add("Funny");
		heromoviesandTVseries.setGenres(genres);
		
		List<Movies> allmovies = new ArrayList<Movies>();
		List<Tvseries> alltvseries = new ArrayList<Tvseries>();
		
		Movies batman = new Movies();
		batman.setTitle("batman: The Dark Knight");
		batman.setYear(2009);
		List<String> batmancast = new ArrayList<String>();
		batmancast.add("Christian Bale");
		batmancast.add("Heath Ledger");
		batman.setCast(batmancast);
		allmovies.add(batman);
		
		Movies jl = new Movies();
		jl.setTitle("Justice League: Snyder Cut");
		jl.setYear(2010);
		List<String> jl1 = new ArrayList<String>();
		jl1.add("Henry Carnival");
		jl1.add("Gal Gadot");
		jl.setCast(jl1);
		allmovies.add(jl);
		
		Movies tamil = new Movies();
		tamil.setTitle("Tamil Movie: Gilli");
		tamil.setYear(2005);
		List<String> actors = new ArrayList<String>();
		actors.add("Vijay");
		actors.add("Thrisha");
		tamil.setCast(actors);
		allmovies.add(tamil);
		
		Tvseries flash = new Tvseries();
		flash.setTitle("Flash");
		flash.setYear(2011);
		
		alltvseries.add(flash);
		
		Tvseries tamiltv = new Tvseries();
		tamiltv.setTitle("Mettioli");
		tamiltv.setYear(2006);
		alltvseries.add(tamiltv);
		
		OtherDetails otd = new OtherDetails();
		otd.setCountry("india");
		otd.setLanguage("Tamil");
		
		heromoviesandTVseries.setMovies(allmovies);
		heromoviesandTVseries.setTvseries(alltvseries);
		heromoviesandTVseries.setOtherdetails(otd);
		
		ObjectMapper maper = new ObjectMapper();
		
		
		File newJsonfile = new File("complex.json");
		maper.writerWithDefaultPrettyPrinter().writeValue(newJsonfile, heromoviesandTVseries);
		
		
		
		
		
		
	}

}
