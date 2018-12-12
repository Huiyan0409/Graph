package testSuite;
import org.junit.Test;
import pa3.GraphNode;
import pa3.Hashmap;

import static org.junit.Assert.assertTrue;

public class HashmapTest {

	@Test
	public void testSet() {
		Hashmap test = new Hashmap(2);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);
		assertTrue(test.getValue(node2) == 2);
	}

	@Test
	public void testGetValue() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);
		assertTrue(test.getValue(node2) == 2);
	}

	@Test
	public void testGetEntry() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);

		assertTrue(test.getEntry(node2).getValue() == 2);
	}

	@Test
	public void testRemove() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.remove(node2);
		assertTrue(test.hasKey(node2) == false);
	}

	@Test
	public void testRemove2() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e7", true);
		GraphNode node4 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e8", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.set(node3, 2);
		test.set(node4, 2);
		test.remove(node3);
		assertTrue(test.hasKey(node3) == false);
	}

	@Test
	public void testHasKey() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		assertTrue(test.hasKey(node1) == true);
		assertTrue(test.hasKey(node2) == false);
	}

	@Test
	public void testSize() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);
		assertTrue(test.size() == 2);
	}

	@Test
	public void testClear() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.clear();
		assertTrue(test.hasKey(node2) == false);
		assertTrue(test.hasKey(node1) == false);
	}

}
