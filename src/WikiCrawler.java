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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class WikiCrawler {

	public static final String BASE_URL = "https://en.wikipedia.org";

	private int max;

	private String seedUrl;

	private ArrayList<String> topics;

	private String fileName;

	private int requests;

	public ArrayList<String> findLinksTest;
	
	private int numOfCrawls;

	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName) {
		this.max = max;
		this.seedUrl = seedUrl;
		this.topics = topics;
		this.fileName = fileName;
	}

	public void crawl() throws IOException, InterruptedException {

		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

		String seedUrlHTML = fetchPage(seedUrl);
		// If seedUrl does not contain all words from topics, then the graph constructed
		// is empty graph
		if (hasTopics(seedUrlHTML)) {

			// initialize queue and visited and add root to each
			Queue<String> queue = new LinkedList<String>();
			LinkedList<String> visited = new LinkedList<String>();
			queue.add(seedUrl);
			visited.add(seedUrl);

			while (!queue.isEmpty()) {
				String curPage = queue.poll();
				String curPageHTML = fetchPage(curPage);
				numOfCrawls++;
				ArrayList<String> curPageLinks = findLinks(curPageHTML);
				if (numOfCrawls < max) {
					for (int i = 0; i < curPageLinks.size(); i++) {
						for (int k = 0; k < visited.size(); k++) {
							if (!(visited.get(k).contains(curPageLinks.get(i)))) {
								ArrayList<String> pageLinks = new ArrayList<String>();
								if (hasTopics(curPageLinks.get(i))) {
									queue.add(curPageLinks.get(i));
									pageLinks.add(curPageLinks.get(i));
									graph.put(curPage, pageLinks);
								}
								visited.add(curPageLinks.get(i));
							}
						}
					}
				}
			}
		}
		writeToFile(graph);
	}

	// Checks if the �actual text component� contains all of the topics
	private boolean hasTopics(String url) throws IOException, InterruptedException {
		String subHTML = fetchPage(url);
		for (int i = 0; i < topics.size(); i++) {
			if (!subHTML.toLowerCase().contains(topics.get(i).toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	// returns all of the valid links in the �actual text component� of the current
	// page.
	private ArrayList<String> findLinks(String subHTML) {
		HashSet<String> linkz = new HashSet<String>();
		Scanner scan = new Scanner(subHTML);
		String wiki = "/wiki/";
		while (scan.hasNext()) {
			String next = scan.next();
			if (next.contains("/wiki/")) {
				int startIndex = next.indexOf(wiki);
				int endIndex = next.length() - 1;
				String possibleLink = next.substring(startIndex, endIndex);
				if (!possibleLink.contains("#") && !possibleLink.contains(":")) {
					if (!linkz.contains(possibleLink)) {
						linkz.add(possibleLink);
					}
				}
			}
		}
		scan.close();
		ArrayList<String> links = new ArrayList<String>(linkz);
		return links;
	}

	// makes a request to the server to fetch html of the current page and creates a
	// string for the �actual text component� of the page.
	private String fetchPage(String currentPage) throws IOException, InterruptedException {
		requests++;
		int mod = requests % 25;
		if (mod == 0) {
			Thread.sleep(3000);
		}
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
		String input;
		StringBuilder builder = new StringBuilder();
		while ((input = br.readLine()) != null) {
			builder.append(input);
		}
		br.close();
		String HTML = builder.toString();

		// Create subString starting after first <p>
		String p1 = "<p>";
		int startIndex = HTML.indexOf(p1);
		String subHTML = HTML.substring(startIndex, HTML.length());
		return subHTML;
	}

	// Takes the graph and saves it to a file by listing out all of the edges.
	private void writeToFile(HashMap<String, ArrayList<String>> digraph) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(max);
		for (Map.Entry<String, ArrayList<String>> entry : digraph.entrySet()) {
			printWriter.print(entry.getKey() + " " + entry.getValue());
		}
		printWriter.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<String> topics = new ArrayList<String>();
		WikiCrawler example = new WikiCrawler("/wiki/Complexity_theory", 20, topics, "wikiCC.txt");
		example.crawl();
	}
}