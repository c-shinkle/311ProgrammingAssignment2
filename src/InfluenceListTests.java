import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InfluenceListTests {

	private NetworkInfluence A;
	private NetworkInfluence B;
	
	@Before
	public void setup() {
		A = new NetworkInfluence("testA");
		B = new NetworkInfluence("testB");
	}

	@Test
	public void testAInfluenceList() {
		ArrayList<String> ab = new ArrayList<String>();
		ab.add("A");
		ab.add("D");
		
		float expected = (float) 4.5;
		float actual = A.influence(ab);
		assertEquals(expected, actual,.001);
	}
	
	@Test
	public void testBInfluenceList() {
		ArrayList<String> ab = new ArrayList<String>();
		ab.add("A");
		ab.add("B");
		float expected = (float)3.25;
		float actual = B.influence(ab);
		assertEquals(expected, actual,.001);
	}
}
