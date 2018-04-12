import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class WikiCrawlerTests {

	ArrayList<String> topics = new ArrayList<String>();
	WikiCrawler complexityTheory = new WikiCrawler("/wiki/Complexity_theory", 20, topics, "wikiCC.txt");
	
	
	@Test
	void hasTopics1() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void hasTopics2() throws IOException {
		complexityTheory.crawl();
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
		complexityTheory.crawl();
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
		complexityTheory.crawl();
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
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl4() throws IOException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	

}
