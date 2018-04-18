import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MostInfluentialSubModularTest {

	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}
	
	@Test
	public void testAMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = A.mostInfluentialSubModular(2);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBMostInfluentialSubModular() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = B.mostInfluentialSubModular(3);
		assertEquals(expected,actual);
	}
}
