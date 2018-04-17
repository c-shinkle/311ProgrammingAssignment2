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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class NetworkInfluence {
	
	String[] masterList;
	HashMap<String, ArrayList<String>> graph;

	// NOTE: graphData is an absolute file path that contains graph data, NOT the
	// raw graph data itself
	@SuppressWarnings("resource")
	public NetworkInfluence(String graphData) {
		graph = new HashMap<String, ArrayList<String>>();
		File graphFile = new File(graphData);
		Scanner reader = null;
		try {
			reader = new Scanner(graphFile);
		} catch (IOException e) {
			System.out.println("File " + graphData + " was not found.");
			return;
		}
		
		String tmp = reader.nextLine();
		int size = Integer.parseInt(tmp);
		masterList = new String[size];
		
		for (int count = 1, index = 0; reader.hasNextLine(); count++) {
			String line = reader.nextLine();
			String[] parts = line.split(" ");
			if (parts.length < 2) {
				throw new RuntimeException("Too few arguements on line: " + count);
			}
			
			String key = parts[0];
			String value = parts[1];
			
			boolean isKeyDup = false;
			boolean isValDup = false;
			
			for (int i = 0; i < index; i++) {
				if (masterList[i].equals(key)) {
					isKeyDup = true;
				}
				if (masterList[i].equals(value)) {
					isValDup = true;
				}
			}
			
			if (!isKeyDup) {
				masterList[index++] = key;
			}
			
			if (!isValDup) {
				masterList[index++] = value;
			}
			
			if (!graph.containsKey(key)) {
				ArrayList<String> edges = new ArrayList<String>();
				edges.add(value);
				graph.put(key, edges);
			} else {
				ArrayList<String> edges2 = graph.get(key);
				if(!edges2.contains(value)) {
					edges2.add(value);
				}
			}
			
			
			
		}
		reader.close();
	}

	public int outDegree(String v) {
		if (graph.get(v) != null)
			return graph.get(v).size();
		return -1;
	}

	public ArrayList<String> shortestPath(String u, String v) {
		ArrayList<String> result = new ArrayList<>();
		PriorityQueue<String> q = new PriorityQueue<String>();
		HashMap<String, String> visited = new HashMap<>();
		HashMap<String, Integer> dist = new HashMap<>(); 
		HashMap<String, String> prev = new HashMap<>();
		
		dist.put(u, 0);
		q.add(u);
		
		for (String s : masterList) {
			if (!s.equals(u)) {
				dist.put(s, Integer.MAX_VALUE);
				q.add(s);
			}
		}
		
		while(!q.isEmpty()) {
			String current = q.poll();
			if (current.equals(v)) {
				Stack<String> stack = new Stack<String>();
				String s = current;
				
				while (s != null) {
					stack.push(s);
					s = prev.get(s);
				}
				
				while (!stack.isEmpty()) {
					result.add(stack.pop());
				}
				
				return result;
			}
			
			visited.put(current, current);
			
			ArrayList<String> outVertices = graph.get(current);
			for (String s : outVertices) {
				int alt = dist.get(current) + 1;
				if (alt < dist.get(s)) {
					dist.put(s, alt);
					prev.put(s, current);
				}
			}
		}
		return result;
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