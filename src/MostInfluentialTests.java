import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialTests {

	private NetworkInfluence A;
	private NetworkInfluence B;
	private NetworkInfluence C;
	private NetworkInfluence D;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
		C = new NetworkInfluence("testC");
		D = new NetworkInfluence("testD");
	}
	
	@Test
	public void testAMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		ArrayList<String> actual = A.mostInfluentialDegree(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("C");
		expected.add("E");
		ArrayList<String> actual = B.mostInfluentialDegree(3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("G");
		expected.add("E");
		ArrayList<String> actual = C.mostInfluentialDegree(3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void tesDMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		expected.add("C");
		ArrayList<String> actual = D.mostInfluentialDegree(3);
		assertEquals(expected, actual);
	}
}