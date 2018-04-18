import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InfluenceTest {
	
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
	public void testAInfluence() {
		float expected = (float)2.25;
		float actual = A.influence("A");
		assertEquals(expected, actual,.001);
	}
	
	@Test
	public void testBInfluencePath() {
		float expected = (float) 2.5;
		float actual = B.influence("A");
		assertEquals(expected, actual,.001);
	}
	@Test
	public void testCInfluencePath() {
		float expected = (float)2.1875;
		float actual = C.influence("D");
		assertEquals(expected, actual,.001);
	}
	
}