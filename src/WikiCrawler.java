// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//(i.e., DO NOT add 'package cs311.pa1;' or similar)

//DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//(you may, however, add member fields and additional methods)

//DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//(i.e., you may only include libraries of the form java.*)

/**
* @author Christian Shinkle, Alec Harrison, Benjamin Trettin
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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

	private ArrayList<String> foundLinks;

	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName) {
		this.max = max;
		this.seedUrl = seedUrl;
		this.topics = topics;
		this.fileName = fileName;
		foundLinks = new ArrayList<String>();
		foundLinks.add(seedUrl);
	}

	public void crawl() throws IOException, InterruptedException {
		LinkedHashMap<String, ArrayList<String>> graph = new LinkedHashMap<String, ArrayList<String>>();
		if (hasTopics(seedUrl)) {
			Queue<String> queue = new LinkedList<String>();
			LinkedList<String> visited = new LinkedList<String>();
			queue.add(seedUrl);
			visited.add(seedUrl);
			while (!queue.isEmpty()) {
				String curPage = queue.poll();
				String curPageHTML = fetchPage(curPage);
				ArrayList<String> curPageLinks = findLinks(curPageHTML, curPage);
				ArrayList<String> pageLinks = new ArrayList<String>();
				for (int i = 0; i < curPageLinks.size(); i++) {
					if (!hasVisited(curPageLinks.get(i), visited)) {
						if (hasTopics(curPageLinks.get(i))) {
							queue.add(curPageLinks.get(i));
						}
						visited.add(curPageLinks.get(i));
					}
					pageLinks.add(curPageLinks.get(i));
					graph.put(curPage, pageLinks);
				}
			}
		}
		writeToFile(graph);
	}

	// checks if the link is within the visited arrayList.
	private boolean hasVisited(String link, LinkedList<String> visited) {
		for (int i = 0; i < visited.size(); i++) {
			if (visited.get(i).equals(link)) {
				return true;
			}
		}
		return false;
	}

	// Checks if the “actual text component” contains all of the topics
	private boolean hasTopics(String url) throws IOException, InterruptedException {
		String subHTML = fetchPage(url);
		for (int i = 0; i < topics.size(); i++) {
			if (!subHTML.toLowerCase().contains(topics.get(i).toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	// returns all of the valid links in the “actual text component” of the current
	// page.
	private ArrayList<String> findLinks(String subHTML, String url) {
		ArrayList<String> links = new ArrayList<String>();
		Scanner scan = new Scanner(subHTML);
		String wiki = "/wiki/";
		String href = "href";
		String org = ".org";
		while (scan.hasNext()) {
			String next = scan.next();
			int startIndex = 0;
			int endIndex = 0;
			if (next.contains(wiki) && next.contains(href)) {
				for (int i = 0; i < next.length(); i++) {
					if (next.charAt(i) == '"' && next.charAt(i - 1) == '=') {
						startIndex = i + 1;
					}
					if (next.charAt(i) == '"' && next.charAt(i - 1) != '=') {
						endIndex = i;
						break;
					}
				}
				String possibleLink = next.substring(startIndex, endIndex);
				if (!possibleLink.contains("#") && !possibleLink.contains(":") && !possibleLink.contains(org) && !links.contains(possibleLink )
						&& !possibleLink.equals(url)) {
						if (foundLinks.size() < max) {
							if (!foundLinks.contains(possibleLink)) {
								foundLinks.add(possibleLink);
							}
							links.add(possibleLink);
						} else if (foundLinks.size() == max && foundLinks.contains(possibleLink)) {
							links.add(possibleLink);
						}
					}
				}
			}
		scan.close();
		return links;
	}

	// makes a request to the server to fetch html of the current page and creates a
	// string for the “actual text component” of the page.
	private String fetchPage(String currentPage) throws IOException, InterruptedException, UnknownHostException {
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
	private void writeToFile(LinkedHashMap<String, ArrayList<String>> graph) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(foundLinks.size());
		printWriter.println();
		for (Map.Entry<String, ArrayList<String>> entry : graph.entrySet()) {
			String key = entry.getKey();
		    ArrayList<String> value = entry.getValue();
		    for(int i=0; i<value.size();i++) {
		    	String vertice = value.get(i);
		    	printWriter.print(key + " " + vertice);
				printWriter.println();
		    }
		}
		printWriter.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<String> topics = new ArrayList<String>();
		WikiCrawler example = new WikiCrawler("/wiki/Complexity_theory", 20, topics, "wikiCC.txt");
		example.crawl();
		System.out.println("cheese");
	}
}