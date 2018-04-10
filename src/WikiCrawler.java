// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may only include libraries of the form java.*)

/**
* @author Christian Shinkle, Alec Harrison, Benjamin Trettin
*/

import java.util.ArrayList;

public class WikiCrawler {
	
	public static final String BASE_URL = "https://en.wikipedia.org";

	private int max;

	private String url;

	private ArrayList<String> topics;

	private String fileName;

	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName) {
		this.max = max;
		this.url = seedUrl;
		this.topics = topics;
		this.fileName = fileName;
	}

	public void crawl(){
		
	}
	
	
}
