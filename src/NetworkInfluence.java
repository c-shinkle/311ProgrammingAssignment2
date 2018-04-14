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
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class NetworkInfluence {

	HashMap<String, ArrayList<String>> graph;

	// NOTE: graphData is an absolute file path that contains graph data, NOT the
	// raw graph data itself
	public NetworkInfluence(String graphData) throws IOException {
		this.graph = new HashMap<String, ArrayList<String>>();
		File graphFile = new File(graphData);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(graphFile));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ", 2);
			String key = parts[0];
			String value = parts[1];
			if (graph == null || !graph.containsKey(key)) {
				ArrayList<String> edges = new ArrayList<String>();
				edges.add(value);
				graph.put(key, edges);
			}
			else {
				ArrayList<String> edges2 = graph.get(key);
				if(!edges2.contains(value)) {
					edges2.add(value);
					graph.put(key, edges2);
				}
			}
		}
		reader.close();
	}

	public int outDegree(String v) {
		// implementation

		// replace this:
		return -1;
	}

	public ArrayList<String> shortestPath(String u, String v) {
		// implementation

		// replace this:
		return null;
	}

	public int distance(String u, String v) {
		// implementation:

		// replace this:
		return -1;
	}

	public int distance(ArrayList<String> s, String v) {
		// implementation

		// replace this:
		return -1;
	}

	public float influence(String u) {
		// implementation

		// replace this:
		return -1f;
	}

	public float influence(ArrayList<String> s) {
		// implementation

		// replace this:
		return -1f;
	}

	public ArrayList<String> mostInfluentialDegree(int k) {
		// implementation

		// replace this:
		return null;
	}

	public ArrayList<String> mostInfluentialModular(int k) {
		// implementation

		// replace this:
		return null;
	}

	public ArrayList<String> mostInfluentialSubModular(int k) {
		// implementation

		// replace this:
		return null;
	}

	public static void main(String[] args) throws IOException {
		NetworkInfluence example2 = new NetworkInfluence("wikiCC.txt");
		example2.outDegree(null);
	}
}