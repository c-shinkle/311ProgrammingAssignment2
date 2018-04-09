import java.util.ArrayList;

public class NetworkInfluence {
	
	/*/	graphData holds the absolute path of a file that stores a
	directed graph. This file will be of the following format: First line indicates number of vertices.
	Each subsequent line lists a directed edge of the graph. The vertices of this graph are represented
	as strings. For example contents of the file may look like
	/*/
	NetworkInfluence(String graphData) {
		
	}
	
	//Returns the out degree of v.
	public int outDegree(String v){
		return 0;
	}
	
	/*/Returns a BFS path from u to v. This method returns an array
	list of strings that represents a shortest path from u to v. Note that this method must return an
	array list of Strings. First vertex in the path must be u and the last vertex must be v. If there is no
	path from u to v, then this method returns an empty list. The return type is ArrayList<String>
	/*/
	public ArrayList<String> shortestPath(String u, String v){
		return null;
	}

	//Returns dist(u, v). Type is int.
	public int distance(String u, String v){
		return 0;
	}
	
	//Here s a subset of vertices. This method returns dist(s, v). Type is int.
	public int distance(ArrayList<String> s, String v){
		return 0;
	}
	
	//Returns Inf(x). Return type is float.
	public float influence(String u){
		return 0;
	}
	
	//Here s holds a set of vertices of G. This method returns Inf(s) whose type is float.
	public float influence(ArrayList<String> s){
		return 0;
	}
	
	//Returns a set of k nodes obtained by using Degree Greedy algorithm. Return type must be ArrayList<String>
	public ArrayList<String> mostInfluentialDegree(int k){
		return null;
	}
	
	//Returns a set of k nodes obtained by using Modular Greedy algorithm. Return type must be ArrayList<String>.
	public ArrayList<String> mostInfluentialModular(int k){
		return null;
	}
	
	//Returns a set of k nodes obtained by using SubModular Greedy algorithm. Return type must be ArrayList<String>.
	public ArrayList<String> mostInfluentialSubModular(int k){
		return null;
	}
}
