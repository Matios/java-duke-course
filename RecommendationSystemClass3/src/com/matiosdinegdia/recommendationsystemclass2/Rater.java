package com.matiosdinegdia.recommendationsystemclass2;

import java.util.ArrayList;

public interface Rater {
	public void addRating(String item, double rating);
	public boolean hasRating(String item);
	public String getID();
	public double getRating(String item);
	public int numRating();
	public ArrayList<String> getItemsRated();
	
}
