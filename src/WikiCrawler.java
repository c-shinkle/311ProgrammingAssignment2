// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may only include libraries of the form java.*)

/**
* @author Christian Shinkle, Alec Harrison, Benjamin Trettin
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WikiCrawler {

	public static final String BASE_URL = "https://en.wikipedia.org";

	private int max;

	private String seedUrl;

	private ArrayList<String> topics;

	private String fileName;

	private static int requests;

	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName) {
		this.max = max;
		this.seedUrl = seedUrl;
		this.topics = topics;
		this.fileName = fileName;
	}

	public void crawl() throws IOException {
		Queue<String> queue = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		queue.add(seedUrl);
		visited.add(seedUrl);
		while (!queue.isEmpty()) {
			String currentPage = queue.peek();
			String currentPageHTML = fetchPage(currentPage);
			ArrayList<String> currentPageLinks = extractLinks(currentPageHTML);
			for (int i = 0; i < currentPageLinks.size(); i++) {
				for (int k = 0; k < visited.size(); k++) {
					if (!(visited.get(k).contains(currentPageLinks.get(i)))) {
							queue.add(currentPageLinks.get(i));
							visited.add(currentPageLinks.get(i));
					}
				}
			}
		}
	}

	private ArrayList<String> extractLinks(String currentPageHTML) {
		ArrayList<String> currentPageLinks = new ArrayList<String>();
		//TODO
		return currentPageLinks;
	}

	private String fetchPage(String currentPage) throws IOException {
		URL url = null;
		InputStream is = null;
		try {
			url = new URL(BASE_URL + currentPage);
			is = url.openStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = br.readLine()) != null) {
			a.append(inputLine);
		}
		br.close();
		return a.toString();
	}

	public static void main(String[] args) throws IOException {
		WikiCrawler example = new WikiCrawler("/wiki/Complexity_theory", 20, null, "wikiCC.txt");
		example.crawl();
	}
}