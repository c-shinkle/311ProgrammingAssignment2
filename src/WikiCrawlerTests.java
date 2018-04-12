import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WikiCrawlerTests {

	ArrayList<String> empty = new ArrayList<String>();
	ArrayList<String> ISUtopics = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
	
	WikiCrawler complexityTheory = new WikiCrawler("/wiki/Complexity_theory", 20, empty, "wikiCC.txt");
	WikiCrawler iowaState = new WikiCrawler("/wiki/Iowa_State_University", 100, ISUtopics, "WikiISU.txt");
	WikiCrawler comScience = new WikiCrawler("/wiki/Computer Science", 100, empty, "WikiISU.txt");
	
	
	
	//Test for extractLinks helper method
	
	@Test
	void extractLinks1() throws IOException, InterruptedException {
		complexityTheory.crawl();
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
		ArrayList<String> actual = complexityTheory.extractLinksTest;
		assertEquals(expected,actual);
	}
	@Test
	void extractLinks2() throws IOException, InterruptedException {
		iowaState.crawl();
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
		ArrayList<String> actual = iowaState.extractLinksTest;
		assertEquals(expected,actual);
	}
	@Test
	void extractLinks3() throws IOException, InterruptedException {
		comScience.crawl();
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
		ArrayList<String> actual = comScience.extractLinksTest;
		assertEquals(expected,actual);
	}
	
	
	//Tests for hasTopics helper method
	
	@Test
	void hasTopics1() throws IOException, InterruptedException {
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void hasTopics2() throws IOException, InterruptedException {
		iowaState.crawl();
		ArrayList<String> expected = null;
		ArrayList<String> actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void hasTopics3() throws IOException, InterruptedException {
		comScience.crawl();
		ArrayList<String> expected = null;
		ArrayList<String> actual = null;
		assertEquals(expected,actual);
	}
	
	
	//Tests for fetchPage helper method
	
	
	@Test
	void fetchPage1() throws IOException, InterruptedException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void fetchPage2() throws IOException, InterruptedException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void fetchPage3() throws IOException, InterruptedException {
		comScience.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	
	
	
	// Tests for Crawl method
	
	
	@Test
	void Crawl1() throws IOException, InterruptedException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl2() throws IOException, InterruptedException {
		complexityTheory.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl3() throws IOException, InterruptedException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl4() throws IOException, InterruptedException {
		iowaState.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl5() throws IOException, InterruptedException {
		comScience.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}
	@Test
	void Crawl6() throws IOException, InterruptedException {
		comScience.crawl();
		String expected = null;
		String actual = null;
		assertEquals(expected,actual);
	}

}
