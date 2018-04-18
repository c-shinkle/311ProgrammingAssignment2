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
		float expected = (float)1.25;
		float actual = A.influence("A");
		assertEquals(expected, actual,.001);
	}
	
	@Test
	public void testBShortedPath() {
		float expected = (float) 1.5;
		float actual = B.influence("A");
		assertEquals(expected, actual,.001);
	}
}
