package practicepackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparablePractice {
	static class Movie implements Comparable<Movie> {
		// Rating of movie, name of movie, and year that movie was released
		private double rating;
		private String name;
		private int year;
		
		// Constructor
		public Movie(String name, double rating, int year) {
			this.name = name;
			this.rating = rating;
			this.year = year;
		}
		
		// Override the compareTo method to define how to compare movies to one another
		public int compareTo(Movie m) {
			// The natural order will be defined based on release date
			return this.year - m.year;
		}
		
		// Getter methods for the given movie
		public double getRating() {
			return this.rating;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getYear() {
			return this.year;
		}
		
		public String toString() {
			return this.name + ", " + this.rating + ", " + this.year;
		}
	}
	
	static class YearComparator implements Comparator<Movie> {
		public int compare(Movie m1, Movie m2) {
			return m1.year - m2.year;
		}
	}
	
	static class RatingsComparator implements Comparator<Movie> {
		public int compare(Movie m1, Movie m2) {
			return Double.compare(m1.rating, m2.rating);
		}
	}
	
	static class NameComparator implements Comparator<Movie> {
		public int compare(Movie m1, Movie m2) {
			return m1.name.compareTo(m2.name);
		}
	}

	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Force Awakens", 8.3, 2015));
		movies.add(new Movie("Star Wars", 8.7, 1977));
		movies.add(new Movie("Empire Strikes Back", 8.8, 1980));
		movies.add(new Movie("Return of the Jedi", 8.4, 1983));
		
		YearComparator yearComp = new YearComparator();
		RatingsComparator ratingsComp = new RatingsComparator();
		NameComparator nameComp = new NameComparator();
		
		// This should sort the movies by release year ascending
		Collections.sort(movies, new Comparator<Movie>() {
			public int compare(Movie m1, Movie m2) {
				return Double.compare(m1.rating, m2.rating);
			}
		});
		
		System.out.println("Movies after sorting : ");
		for (Movie m : movies) {
			System.out.println(m);
		}
	}

}
