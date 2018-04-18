import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InfluenceTest {
	
	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}
	
	@Test
	public void testAShortestPath() {
		float expected = (float)1.5;
		float actual = A.influence("A");
		assertEquals(expected, actual,.001);
	}
	@Test
	public void testOutDegree() {
		int expected = 2;
		int actual = A.outDegree("A");
		assertEquals(expected,actual);
	}
	@Test
	public void testMostInfluentialDegree() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		ArrayList<String> actual = A.mostInfluentialDegree(1);
		assertEquals(expected,actual);
	}
	@Test
	public void testMostInfluentialModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		ArrayList<String> actual = A.mostInfluentialModular(2);
		assertEquals(expected,actual);
	}
	@Test
	public void testMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = A.mostInfluentialSubModular(2);
		assertEquals(expected,actual);
	}
}
