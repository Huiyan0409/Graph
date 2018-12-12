/**
 * 
 */
package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import pa3.Entry;
import pa3.GraphNode;

/**
 * This class tests the Entry class
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class EntryTest {

	/**
	 * This method tests the constructor of Entry
	 */
	@Test
	public void testCreateEntry() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		Entry test = new Entry(node1, 1,null);
		assertTrue(test.getKey() == node1);
		assertTrue(test.getNext() == null);
		assertTrue(test.getValue() == 1);
	}
	
	/**
	 * This method tests the getKey method of Entry
	 */
	@Test
	public void testGetKey() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		Entry test = new Entry(node1, 1,null);
		assertTrue(test.getKey() == node1);
	}
	
	/**
	 * This method tests the getValue method of Entry
	 */
	@Test
	public void testGetValue() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		Entry test = new Entry(node1, 1,null);
		assertTrue(test.getValue() == 1);
	}
	
	/**
	 * This method tests the setValue method of Entry
	 */
	@Test
	public void testSetValue() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		Entry test = new Entry(node1, 1,null);
		test.setValue(5);
		assertTrue(test.getValue() == 5);
	}
	
	/**
	 * This method tests the getNext method of Entry
	 */
	@Test
	public void testGetNext() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		Entry test = new Entry(node1, 1,null);
		Entry test2 = new Entry(node2, 3, test);
		assertTrue(test2.getNext() == test);
	}
	
	/**
	 * This method tests the setNext method of Entry
	 */
	@Test
	public void testSetNext() {
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		Entry test = new Entry(node1, 1,null);
		Entry test2 = new Entry(node2, 3, null);
		test2.setNext(test);
		assertTrue(test2.getNext() == test);
	}

}
