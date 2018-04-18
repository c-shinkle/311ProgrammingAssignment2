import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialSubModularTest {

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
	public void testAMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		ArrayList<String> actual = A.mostInfluentialSubModular(2);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("C");
		expected.add("B");
		ArrayList<String> actual = B.mostInfluentialSubModular(3);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("A");
		expected.add("E");
		expected.add("C");
		ArrayList<String> actual = C.mostInfluentialSubModular(3);
		assertEquals(expected,actual);
	}
	
	
}
