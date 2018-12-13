package testSuite;

import org.junit.Test;
import pa3.FindMinPath;
import pa3.GraphNode;
import pa3.GraphWrapper;

import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertTrue;
import static pa3.FindMinPath.run;

public class FindMinPathTest {

	@Test
	public void testShowPath() {
		GraphNode s = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", true);

		GraphNode d  = new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", true);
		d.previousNode = s;
		d.previousDirection="East";
		d.setEast(s,0);
		String rst = FindMinPath.showPath(s,d,"");
		assertTrue(rst.equals("West\n"));

		d.previousDirection="West";
		d.setWest(s,0);
		rst = FindMinPath.showPath(s,d,"");
		assertTrue(rst.equals("East\n"));

		d.previousDirection="South";
		d.setSouth(s,0);
		rst = FindMinPath.showPath(s,d,"");
		assertTrue(rst.equals("North\n"));

		d.previousDirection="North";
		d.setNorth(s,0);
		rst = FindMinPath.showPath(s,d,"");
		assertTrue(rst.equals("South\n"));
	}

	@Test
	public void testRun() {
		GraphWrapper gw = new GraphWrapper(false);
		GraphNode home = gw.getHome();
		String rst = run(gw,home);
		System.out.println(rst);

		String outputStr = "South\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"North\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"West\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"North\n" +
				"East\n" +
				"North\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"South\n" +
				"South\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"South\n" +
				"East\n" +
				"East\n" +
				"East\n" +
				"East\n";
		assertTrue(outputStr.equals(rst));
	}

	@Test
	public void testWriteToFile() {
		String writeStr = "test";
		FindMinPath.writeToFile(writeStr);
		File answer = new File("src/pa3/answer.txt");

		try {
			char cbuf[] = new char[4];
			FileReader reader = new FileReader(answer);
			reader.read(cbuf);
			reader.close();
			String rst = String.valueOf(cbuf);
			assertTrue(writeStr.equals(rst));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
