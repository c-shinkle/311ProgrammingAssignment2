import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class MSTTests {
	
	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}

	@Test
	public void testA() {
		HashMap<String, ArrayList<String>> actual = A.buildMST("A");
		HashMap<String, ArrayList<String>> expected = new HashMap<>();
		ArrayList<String> Achildren = new ArrayList<>();
		ArrayList<String> Bchildren = new ArrayList<>();
		ArrayList<String> Cchildren = new ArrayList<>();
		ArrayList<String> Dchildren = new ArrayList<>();
		
		Achildren.add("B");
		Achildren.add("D");
		Bchildren.add("C");
		
		expected.put("A", Achildren);
		expected.put("B", Bchildren);
		expected.put("C", Cchildren);
		expected.put("D", Dchildren);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testB() {
		HashMap<String, ArrayList<String>> actual = B.buildMST("A");
		HashMap<String, ArrayList<String>> expected = new HashMap<>();
		ArrayList<String> Achildren = new ArrayList<>();
		ArrayList<String> Bchildren = new ArrayList<>();
		ArrayList<String> Cchildren = new ArrayList<>();
		ArrayList<String> Dchildren = new ArrayList<>();
		ArrayList<String> Echildren = new ArrayList<>();
		
		Achildren.add("B");
		Achildren.add("E");
		Bchildren.add("C");
		Echildren.add("D");
		
		expected.put("A", Achildren);
		expected.put("B", Bchildren);
		expected.put("C", Cchildren);
		expected.put("D", Dchildren);
		expected.put("E", Echildren);
		
		assertEquals(expected, actual);
	}
	
}
