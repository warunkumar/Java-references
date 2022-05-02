package com.basic_concept.sorting;

import java.util.*;
 
// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie>
{
    private double rating;
    private String name;
    private int year;
 
    // Used to sort movies by year
    public int compareTo(Movie m)
    {
        return this.name.compareTo(m.name);
    }
 
    // Constructor
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
 
    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}
 
// Driver class
class ComparableExa
{
    public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("A", 8.3, 2015));
        list.add(new Movie("b", 8.7, 1977));
        list.add(new Movie("c", 8.8, 1980));
        list.add(new Movie("d", 8.4, 1983));
 
        Collections.sort(list);
 
        System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }
    }
}