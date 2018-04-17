import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class NetworkInfluenceTest {

	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}
	
	@Test
	public void testAShortestPath() {
		ArrayList<String> actual = new ArrayList<>();
		actual.add("A");
		actual.add("D");
		ArrayList<String> expected = A.shortestPath("A", "D");
		assertEquals(expected, actual);
	}
	
}
