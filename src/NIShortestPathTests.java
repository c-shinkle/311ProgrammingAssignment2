import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class NIShortestPathTests {

	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}
	
	@Test
	public void testAShortestPath() {
		ArrayList<String> expected = new ArrayList<>();
		expected.add("A");
		expected.add("D");
		ArrayList<String> actual = A.shortestPath("A", "D");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBShortestPath() {
		ArrayList<String> expected = new ArrayList<>();
		expected.add("A");
		expected.add("E");
		expected.add("D");
		ArrayList<String> actual = B.shortestPath("A", "D");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAOutDegree() {
		int expected = 2;
		int actual = A.outDegree("A");
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBOutDegree() {
		int expected = 2;
		int actual = B.outDegree("A");
		assertEquals(expected,actual);
	}
	
}
