package testSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa3.GraphNode;
import pa3.Hashmap;
import pa3.Heap;

/**
 * This class is a Junit test on Heap
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class HeapTest {
	
	/**
	 * Test the hasKey method
	 */
	@Test
	public void testHasKey() {
		Heap test = new Heap(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.hasKey(node1) == true);
		assertTrue(test.hasKey(node3) == false);
	}
	
	/**
	 * Test the isEmpty method
	 */
	@Test
	public void testIsEmpty() {
		Heap test = new Heap(5);
		assertTrue(test.isEmpty() == true);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		test.insert(node1);
		assertTrue(test.isEmpty() == false);
	}
	
	/**
	 * Test the isFull method
	 */
	@Test
	public void testIsFull() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.isFull() == false);
		test.insert(node3);
		assertTrue(test.isFull() == true);
	}
	
	/**
	 * Test the insert method when insertion cannot be done successfully
	 */
	@Test
	public void testInsert1() {
		Heap test = new Heap(2);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.insert(node3) == false);
	}
	
	/**
	 * Test the insert method when the insertion can be done successfully
	 */
	@Test
	public void testInsert2() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.insert(node3) == true);
	}
	
	@Test
	public void testHeapify() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		Heap.heapify(node3);
	}
	
	@Test
	public void testHeapifyUp() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		heapifyUp(node2);
	}
	
	@Test
	public void testRemove() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		assertTrue(test.remove() == node3);
	}
	
	@Test
	public void testHeapifyDown() {
		Heap test = new Heap(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		heapifyDown(node2);
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	
	

}
