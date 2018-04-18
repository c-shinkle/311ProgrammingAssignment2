import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialTests {

	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}
	
	@Test
	public void testMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		ArrayList<String> actual = A.mostInfluentialDegree(1);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMostInfluentialDegree2() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		ArrayList<String> actual = B.mostInfluentialDegree(3);
		assertEquals(expected,actual);
	}
}