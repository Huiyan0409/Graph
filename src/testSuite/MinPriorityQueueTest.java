package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import pa3.GraphNode;
import pa3.Heap;
import pa3.MinPriorityQueue;

public class MinPriorityQueueTest {


	@Test
	public void testInsert() {
		MinPriorityQueue test = new MinPriorityQueue(2);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=15;
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.hasKey(node1) == true);
		assertTrue(test.hasKey(node2) == true);
	}

	@Test
	public void testPullHighestPriorityElement() {
		MinPriorityQueue test = new MinPriorityQueue(2);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=15;
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.pullHighestPriorityElement().getId().equals(node2.getId()));
	}

	@Test
	public void testIsEmpty() {
		MinPriorityQueue test = new MinPriorityQueue(2);
		assertTrue(test.isEmpty() == true);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		test.insert(node1);
		assertTrue(test.isEmpty() == false);
	}

	@Test
	public void testUpdate() {
		MinPriorityQueue test = new MinPriorityQueue(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		test.insert(node1);
		test.update(node1,21);
		assertTrue(node1.priority==21);
	}

	@Test
	public void testHasKey() {
		MinPriorityQueue test = new MinPriorityQueue(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		test.insert(node1);
		test.insert(node2);
		assertTrue(test.hasKey(node1) == true);
		assertTrue(test.hasKey(node3) == false);
	}

	@Test
	public void testRebalance() {
		MinPriorityQueue test = new MinPriorityQueue(3);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		node1.priority=20;
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		node2.priority=10;
		GraphNode node3 = new GraphNode("66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1", true);
		node3.priority=30;
		test.insert(node1);
		test.insert(node2);
		test.insert(node3);
		test.rebalance(node3);
		assertTrue(test.heap.remove().getId().equals(node2.getId()));
	}

}
