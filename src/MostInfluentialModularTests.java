import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialModularTests {
	
	private NetworkInfluence A;
	private NetworkInfluence B;
	private NetworkInfluence C;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
		C = new NetworkInfluence("testC");
	}
	
	@Test
	public void testAMostInfluentialModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		ArrayList<String> actual = A.mostInfluentialModular(2);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBMostInfluentialModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		expected.add("C");
		ArrayList<String> actual = B.mostInfluentialModular(3);
		assertEquals(expected,actual);
	}
	@Test
	public void testCMostInfluentialModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("G");
		expected.add("E");
		expected.add("F");
		expected.add("D");
		expected.add("C");
		expected.add("B");
		expected.add("H");
		expected.add("I");
		ArrayList<String> actual = C.mostInfluentialModular(9);
		assertEquals(expected,actual);
	}

}
