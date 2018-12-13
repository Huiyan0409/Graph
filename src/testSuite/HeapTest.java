package testSuite;

import org.junit.Test;
import pa3.GraphNode;
import pa3.Heap;

import static org.junit.Assert.assertTrue;

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
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=30;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.heapify(node3);
		GraphNode node4 = test.remove();
		assertTrue(node4.getId().equals(node2.getId()));
	}
	
	@Test
	public void testHeapifyUp() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=30;
		GraphNode node4 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a4", true);
		node4.priority=15;
		GraphNode node5 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a5", true);
		node5.priority=9;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.insert(node4);
		test.insert(node5);
		test.heapifyUp(2);
		GraphNode node8 = test.remove();
		node8.toString();
		assertTrue(node8.getId().equals(node5.getId()));
	}
	
	@Test
	public void testRemove() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=30;
		GraphNode node4 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a4", true);
		node4.priority=15;
		GraphNode node5 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f056", true);
		node5.priority=9;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.insert(node4);
		test.insert(node5);
		assertTrue(test.remove().getId().equals(node5.getId()));
		assertTrue(test.remove().getId().equals(node2.getId()));
	}



	
	@Test
	public void testHeapifyDown() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=30;
		GraphNode node4 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a4", true);
		node4.priority=15;
		GraphNode node5 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f056", true);
		node5.priority=5;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.insert(node4);
		test.insert(node5);
		test.heapifyDown(2);
		GraphNode node9 = test.remove();
		assertTrue(node9.getId().equals(node5.getId()));
	}


	@Test
	public void testHeapifyDown2() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=5;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=15;
		GraphNode node4 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a4", true);
		node4.priority=20;
		GraphNode node5 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f056", true);
		node5.priority=30;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.insert(node4);
		test.insert(node5);
		test.heapifyDown(2);
		GraphNode node9 = test.remove();
		assertTrue(node9.getId().equals(node1.getId()));
	}

	/**
	 * Test Update when needs to heapify up
	 */
	@Test
	public void testUpdate() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		test.insert(node1);
		test.update(node1,21);
		GraphNode node8 = test.remove();
		assertTrue(node8.priority==21);
	}
	
	/**
	 * Test Update when needs to heapify down
	 */
	@Test
	public void testUpdate2() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		test.insert(node1);
		test.update(node1,19);
		GraphNode node8 = test.remove();
		assertTrue(node8.priority==19);
	}
	
	/**
	 * Test Update when change cannot be done
	 */
	@Test
	public void testUpdate3() {
		Heap test = new Heap(10);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node1.priority=20;
		test.insert(node1);
		test.update(node2,19);
		assertTrue(test.hasKey(node2) == false);
	}
	
	
	

}