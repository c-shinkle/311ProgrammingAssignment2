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
import java.util.Comparator;
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
	int influenceCounter = 0;
	float influenceNumber = 0;

	// NOTE: graphData is an absolute file path that contains graph data, NOT
	// the
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
				if (!edges2.contains(value)) {
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
		ArrayList<String> outVertices;
		PriorityQueue<Tuple> q = new PriorityQueue<Tuple>();
		HashMap<String, Tuple> dist = new HashMap<>();
		HashMap<String, String> prev = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();

		q.add(new Tuple(u, 0));

		for (String s : masterList) {
			visited.put(s, false);
			if (!s.equals(u)) {
				Tuple t = new Tuple(s, Integer.MAX_VALUE);
				dist.put(s, t);
				q.add(t);
			}
		}

		for (Tuple current = q.poll(); !q.isEmpty(); current = q.poll()) {
			// If we've already visited this node, we can skip over it. This can
			// happen because there is a very good chance vertices will appear
			// more than once in the priority queue. See details below.
			if (visited.get(current.string)) {
				continue;
			}

			// Mark the vertex as visited
			visited.replace(current.string, true);

			// If we find the node we're looking for,
			// we can stop early.
			if (current.string.equals(v)) {
				buildPath(current, result, prev);
				return result;
			}

			outVertices = graph.get(current.string);
			if (outVertices == null)
				continue;

			int alt = current.dist + 1;
			for (String s : outVertices) {
				Tuple t = dist.get(s);
				if (alt < t.dist) {
					dist.get(s).dist = alt;
					prev.put(s, current.string);
					// I know this seems odd, but the priority queue in Java
					// doesn't have a decrease key method so my work around is
					// to re-insert the vertex but with a lower distance. That
					// way, it will get bumped up in priority. This is why it is
					// necessary to check if the vertex has been visited earlier
					// in the method.
					q.add(new Tuple(s, alt));
				}
			}

		}
		return result;
	}

	private void buildPath(Tuple current, ArrayList<String> result, HashMap<String, String> prev) {
		Stack<String> stack = new Stack<String>();
		String s = current.string;

		while (s != null) {
			stack.push(s);
			s = prev.get(s);
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

	}

	public int distance(String u, String v) {
		ArrayList<String> list = shortestPath(u, v);
		int distance = list.size();
		return distance;
	}

	public int distance(ArrayList<String> s, String v) {
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < s.size(); i++) {
			ArrayList<String> list = shortestPath(s.get(i), v);
			int distance2 = list.size();
			if (distance2 < distance) {
			}
		}
		return distance;
	}

	public float influence(String u) {
		// implementation

		int size = 0;

		if (graph.get(u) == null) {
			return 1 / (powerFunction(influenceCounter));
		} else {
			int i = 0;
			size = graph.get(u).size();
			while (i < size) {
				influenceNumber += influence(graph.get(u).get(i));
				i++;
				influenceCounter++;
			}

		}
		return influenceNumber;
	}

	public int powerFunction(int pow) {
		int total = 1;
		for (int i = 0; i < pow; i++) {
			total = total * 2;
		}
		return total;
	}

	public float influence(ArrayList<String> s) {
		// implementation

		// replace this:
		return -1f;
	}

	public ArrayList<String> mostInfluentialDegree(int k) {
		ArrayList<String> list = new ArrayList<String>();
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(k, new Comparator<Tuple>() {
			public int compare(Tuple lhs, Tuple rhs) {
				if (lhs.dist < rhs.dist)
					return 1;
				else if (lhs.dist > rhs.dist)
					return -1;
				return 0;
			}
		});
		for (int i = 0; i < masterList.length; i++) {
			Tuple element = new Tuple(masterList[i], outDegree(masterList[i]));
			pq.add(element);
		}
		for (int i = 0; i < k; i++) {
			String s = pq.poll().string;
			list.add(s);
		}
		return list;
	}

	public ArrayList<String> mostInfluentialModular(int k) {
		ArrayList<String> list = new ArrayList<String>();
		PriorityQueue<Tuple2> pq = new PriorityQueue<Tuple2>(k, new Comparator<Tuple2>() {
			public int compare(Tuple2 lhs, Tuple2 rhs) {
				if (lhs.dist < rhs.dist)
					return 1;
				else if (lhs.dist > rhs.dist)
					return -1;
				return 0;
			}
		});
		for (int i = 0; i < masterList.length; i++) {
			Tuple2 element = new Tuple2(masterList[i], influence(masterList[i]));
			pq.add(element);
		}
		for (int i = 0; i < k; i++) {
			String s = pq.poll().string;
			list.add(s);
		}
		return list;
	}

	public ArrayList<String> mostInfluentialSubModular(int k) {
		ArrayList<String> list = new ArrayList<String>();
		String[] masterTemp = new String[masterList.length];

		// do the loop k times
		for (int x = 0; x < k; x++) {
			
			PriorityQueue<Tuple2> pq = new PriorityQueue<Tuple2>(k, new Comparator<Tuple2>() {
				public int compare(Tuple2 lhs, Tuple2 rhs) {
					if (lhs.dist < rhs.dist)
						return 1;
					else if (lhs.dist > rhs.dist)
						return -1;
					return 0;
				}
			});
			for (int i = 0; i < masterTemp.length; i++) {
				ArrayList<String> vList = list;
				vList.add(masterTemp[i]);
				Tuple2 vInf = new Tuple2(masterTemp[i],influence(vList));
				pq.add(vInf);
				
			}
			
			// add found vertice to the list and remove it from masterTemp.
			String s = pq.poll().string;
			list.add(s);
			for (int i=0;i<masterTemp.length;i++) {
			    if (masterTemp[i].equals(s)) {
			        masterTemp[i] = null;
			        break;
			    }
			}
		}
		return list;
	}

	private class Tuple implements Comparable<Tuple> {

		String string;
		int dist;

		public Tuple(String s, int i) {
			string = s;
			dist = i;
		}

		@Override
		public int compareTo(Tuple other) {
			if (this.dist < other.dist)
				return -1;
			else if (this.dist > other.dist)
				return 1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "(" + string + ", " + dist + ")";

		}

	}

	private class Tuple2 implements Comparable<Tuple2> {

		String string;
		float dist;

		public Tuple2(String s, float i) {
			string = s;
			dist = i;
		}

		@Override
		public int compareTo(Tuple2 other) {
			if (this.dist < other.dist)
				return -1;
			else if (this.dist > other.dist)
				return 1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "(" + string + ", " + dist + ")";

		}

	}

	public static void main(String[] args) throws IOException {
		NetworkInfluence example2 = new NetworkInfluence("wikiCC.txt");
		example2.outDegree(null);
	}
}

