import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

public class WikiCrawlerTests {

	ArrayList<String> empty = new ArrayList<String>();
	ArrayList<String> ISUtopics = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
	
	WikiCrawler complexityTheory = new WikiCrawler("/wiki/Complexity_theory", 20, empty, "Test.txt");
	WikiCrawler iowaState = new WikiCrawler("/wiki/Iowa_State_University", 100, ISUtopics, "WikiISU.txt");
	WikiCrawler comScience = new WikiCrawler("/wiki/Computer Science", 100, empty, "WikiISU.txt");
	
	
	
	//Test for findLinks helper method
	
//	@Test
//	public void findLinks1() throws IOException, InterruptedException {
//		complexityTheory.crawl();
//		ArrayList<String> expected = new ArrayList<String>();
//		ArrayList<String> actual = complexityTheory.topics;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void findLinks2() throws IOException, InterruptedException {
//		iowaState.crawl();
//		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("IowaState","cyclones"));
//		ArrayList<String> actual = iowaState.topics;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void findLinks3() throws IOException, InterruptedException {
//		comScience.crawl();
//		ArrayList<String> expected = new ArrayList<String>();
//		ArrayList<String> actual = comScience.topics;
//		assertEquals(expected,actual);
//	}
//	
//	
//	//Tests for hasTopics helper method
//	
//	@Test
//	public void hasTopics1() throws IOException, InterruptedException {
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void hasTopics2() throws IOException, InterruptedException {
//		iowaState.crawl();
//		ArrayList<String> expected = null;
//		ArrayList<String> actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void hasTopics3() throws IOException, InterruptedException {
//		comScience.crawl();
//		ArrayList<String> expected = null;
//		ArrayList<String> actual = null;
//		assertEquals(expected,actual);
//	}
//	
//	
	//Tests for fetchPage helper method
	
	
//	@Test
//	public void fetchPage1() throws IOException, InterruptedException {
//		complexityTheory.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void fetchPage2() throws IOException, InterruptedException {
//		iowaState.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void fetchPage3() throws IOException, InterruptedException {
//		comScience.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	
//	
//	
//	// Tests for Crawl method
//	
//	
//	@Test
//	public void Crawl1() throws IOException, InterruptedException {
//		complexityTheory.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void Crawl2() throws IOException, InterruptedException {
//		complexityTheory.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void Crawl3() throws IOException, InterruptedException {
//		iowaState.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void Crawl4() throws IOException, InterruptedException {
//		iowaState.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void Crawl5() throws IOException, InterruptedException {
//		comScience.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}
//	@Test
//	public void Crawl6() throws IOException, InterruptedException {
//		comScience.crawl();
//		String expected = null;
//		String actual = null;
//		assertEquals(expected,actual);
//	}

}
