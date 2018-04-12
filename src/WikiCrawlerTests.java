import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WikiCrawlerTests {

	ArrayList<String> complexTheorytopics = new ArrayList<String>();
	ArrayList<String> ISUtopics = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
	
	WikiCrawler complexityTheory = new WikiCrawler("/wiki/Complexity_theory", 20, complexTheorytopics, "wikiCC.txt");
	WikiCrawler iowaState = new WikiCrawler("/wiki/Iowa_State_University", 100, ISUtopics, "WikiISU.txt");
	
	@Test
	void hasTopics1() throws IOException {
		complexityTheory.crawl();
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void hasTopics2() throws IOException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void extractLinks1() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void extractLinks2() throws IOException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void fetchPage1() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void fetchPage2() throws IOException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl1() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl2() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl3() throws IOException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl4() throws IOException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	

}
