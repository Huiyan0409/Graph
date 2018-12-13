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
		GraphNode node3 = null;
		test.set(node1, 1);
		test.set(node2, 2);
		assertTrue(test.getValue(node2) == 2);
		test.set(node2, 5);
		assertTrue(test.getValue(node2) == 5);
		test.set(node3, 3);
		assertTrue(test.hasKey(node3) == false);
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
		GraphNode node6 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e8", true);
		assertTrue(test.hasKey(node6) == true);
	}

	@Test
	public void testRemoveForHashCrash() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a92", true);
		GraphNode node3 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a93", true);
		GraphNode node4 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a94", true);
		GraphNode node5 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a95", true);
		GraphNode node6 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a96", true);
		GraphNode node7 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a97", true);
		GraphNode node8 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a98", true);
		GraphNode node9 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a99", true);
		GraphNode node10 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a10", true);
		GraphNode node11 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a11", true);
		GraphNode node12 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a12", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.set(node3, 2);
		test.set(node4, 2);
		test.set(node5, 2);
		test.set(node6, 1);
		test.set(node7, 2);
		test.set(node8, 2);
		test.set(node9, 2);
		test.set(node10, 2);
		test.set(node11, 1);
		test.set(node12, 2);
		test.remove(node1);
		test.remove(node2);
		test.remove(node3);
		test.remove(node4);
		test.remove(node5);
		test.remove(node6);
		test.remove(node7);
		test.remove(node8);
		test.remove(node9);
		test.remove(node10);
		test.remove(node11);
		test.remove(node12);

		assertTrue(test.hasKey(node3) == false);
	}
	
	@Test
	public void testRemove3() {
		Hashmap test = new Hashmap(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("", true);
		GraphNode node4 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e8", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.set(node3, 2);
		test.set(node4, 2);
		test.remove(node4);
		assertTrue(test.hasKey(node4) == false);
	}

	@Test
	public void testRemoveForRemoveNull() {
		Hashmap test = new Hashmap(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("", true);
		GraphNode node4 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e8", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.set(node3, 2);
		test.set(node4, 2);
		test.remove(null);
		assertTrue(test.hasKey(node4) == true);
	}

	@Test
	public void testRemoveForRemoveNotExsit() {
		Hashmap test = new Hashmap(5);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = new GraphNode("", true);
		GraphNode node4 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e8", true);
		test.set(node1, 1);
		test.set(node2, 2);
		test.set(node3, 2);

		test.remove(node4);
		assertTrue(test.hasKey(node4) == false);
	}

	@Test
	public void testHasKey() {
		Hashmap test = new Hashmap(1);
		GraphNode node1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);
		GraphNode node2 = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		GraphNode node3 = null;
		test.set(node1, 1);
		assertTrue(test.hasKey(node1) == true);
		assertTrue(test.hasKey(node2) == false);
		assertTrue(test.hasKey(node3) == false);
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