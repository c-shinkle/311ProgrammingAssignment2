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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import WikiCrawler.Node;

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
		String seedUrlHTML = fetchPage(seedUrl);
		if (!hasTopics(seedUrlHTML)) {

		}
		Queue<String> queue = new LinkedList<String>();
		LinkedList<String> visited = new LinkedList<String>();
		queue.add(seedUrl);
		visited.add(seedUrl);
		while (!queue.isEmpty()) {
			String curPage = queue.peek();
			String curPageHTML = fetchPage(curPage);
			ArrayList<String> curPageLinks = extractLinks(curPageHTML);
			for (int i = 0; i < curPageLinks.size(); i++) {
				for (int k = 0; k < visited.size(); k++) {
					if (!(visited.get(k).contains(curPageLinks.get(i)))) {
						queue.add(curPageLinks.get(i));
						visited.add(curPageLinks.get(i));
					}
				}
			}
		}
		File storedFile = new File(this.fileName);

		try {
			storedFile.createNewFile();
			PrintWriter writer = new PrintWriter(storedFile);
			writer.println(h.size());
			Collection col = h.values();
			Object[] nodes = col.toArray();

			for (int x = 0; x < nodes.length; x++) {
				Node tem = (Node) nodes[x];
				for (int y = 0; y < tem.adj.size(); y++) {
					writer.println(tem.link + " " + tem.adj.get(y).link);
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// Checks if the “actual text component” contains all of the topics
	private boolean hasTopics(String subHTML) {
		for (int i = 0; i < topics.size(); i++) {
			if (!subHTML.toLowerCase().contains(topics.get(i).toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	//returns all of the valid links in the “actual text component” of the current page.  
	private ArrayList<String> extractLinks(String subHTML) {
		ArrayList<String> links = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		Scanner words = new Scanner(subHTML);
		while (words.hasNext()) {
			String word = words.next();
			if (word.contains("href") && word.contains("/wiki/")) {
				int first = 0;
				int last = 0;
				for (int x = 0; x < word.length(); x++) {
					if (word.charAt(x) == '"' && word.charAt(x - 1) == '=') {
						first = x + 1;
					}
					if (word.charAt(x) == '"' && word.charAt(x - 1) != '=') {
						last = x;
						break;
					}
				}
				String link = word.substring(first, last);
				if (!link.contains(":") && !link.contains("#") && !set.contains(link)) {
					if (link.contains(".")) {
						if (link.contains(".com") || link.contains(".html")) { // change
							links.add(link);
							set.add(link);
						}
					} else {
						links.add(link);
						set.add(link);
					}
				}
			}
			words.close();
		}
		return links;
	}

	//makes a request to the server to fetch html of the current page and creates a string for the “actual text component” of the page. 
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
		String HTML = a.toString();

		// Create subString starting after first <p>
		String subHTML = null;
		for (int x = 0; x < HTML.length(); x++) {
			if (HTML.charAt(x) == '<') {
				if (HTML.charAt(x + 1) == 'p' && HTML.charAt(x + 2) == '>') {
					subHTML = HTML.substring(x + 3, HTML.length());
					break;
				}
			}
		}
		return subHTML;
	}

	public static void main(String[] args) throws IOException {
		WikiCrawler example = new WikiCrawler("/wiki/Complexity_theory", 20, null, "wikiCC.txt");
		example.crawl();
	}
}