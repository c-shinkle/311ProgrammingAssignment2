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
	public void testAInfluence1() {
		float expected = (float) 2.25;
		float actual = A.influence("A");
		assertEquals(expected, actual,.001);
	}
	
	@Test
	public void testAInfluence2() {
		float expected = 1;
		float actual = A.influence("Z");
		assertEquals(expected, actual,.001);
	}
	
	@Test
	public void testBInfluencePath() {
		float expected = (float) 2.5;
		float actual = B.influence("A");
		assertEquals(expected, actual,.001);
	}
	
}