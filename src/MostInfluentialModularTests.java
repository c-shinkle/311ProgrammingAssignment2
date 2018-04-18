import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialModularTests {
	
	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
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

}
