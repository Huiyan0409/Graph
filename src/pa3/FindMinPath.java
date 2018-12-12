package pa3;

import java.io.File;
import java.io.FileWriter;

/**
 * This is the main class of the program, coming up with the minimum path
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class FindMinPath {

	
    public static String showPath(GraphNode s,GraphNode d, String str){
        if(!s.getId().equals(d.getId())) {
            String direction = "";
            switch (d.previousDirection) {
                case "West":
                    d = d.getWest();
                    direction = "East";
                    break;
                case "East":
                    d = d.getEast();
                    direction = "West";
                    break;
                case "North":
                    d = d.getNorth();
                    direction = "South";
                    break;
                case "South":
                    d = d.getSouth();
                    direction = "North";
                    break;
            }
            return showPath(s,d,str) + direction + "\n";
        }
        return str;
    }

    public static String run(GraphWrapper gw,GraphNode home) {
        MinPriorityQueue Q = new MinPriorityQueue(10000);
        home.priority = 0;
        Q.insert(home);
        while(!Q.isEmpty()){
            GraphNode curr = Q.pullHighestPriorityElement();
            if(curr.isGoalNode()){
                String s = "";
                return showPath(home,curr,s);
            } else{
                if(curr.hasEast()){
                    GraphNode neighbor = curr.getEast();
                    int x = curr.priority + curr.getEastWeight();
                    if(!Q.hasKey(neighbor)){
                        neighbor.priority = x;
                        neighbor.previousDirection = "West";
                        Q.insert(neighbor);
                    }
                    if(Q.hasKey(neighbor) && x < neighbor.priority){
                        Q.update(neighbor,x);
                        neighbor.priority = x;
                        neighbor.previousDirection = "West";
                    }
                }
                if(curr.hasWest()){
                    GraphNode neighbor = curr.getWest();
                    int x = curr.priority + curr.getWestWeight();
                    if(!Q.hasKey(neighbor)){
                        neighbor.priority = x;
                        neighbor.previousDirection = "East";
                        Q.insert(neighbor);
                    }
                    if(Q.hasKey(neighbor) && x < neighbor.priority){
                        Q.update(neighbor,x);
                        Q.rebalance(neighbor);
                        neighbor.priority = x;
                        neighbor.previousDirection = "East";
                    }
                }

                if(curr.hasNorth()){
                    GraphNode neighbor = curr.getNorth();
                    int x = curr.priority + curr.getNorthWeight();
                    if(!Q.hasKey(neighbor)){
                        neighbor.priority = x;
                        neighbor.previousDirection = "South";
                        Q.insert(neighbor);
                    }
                    if(Q.hasKey(neighbor) && x < neighbor.priority){
                        Q.update(neighbor,x);
                        neighbor.priority = x;
                        neighbor.previousDirection = "South";
                    }
                }

                if(curr.hasSouth()){
                    GraphNode neighbor = curr.getSouth();
                    int x = curr.priority + curr.getSouthWeight();
                    if(!Q.hasKey(neighbor)){
                        neighbor.priority = x;
                        neighbor.previousDirection = "North";
                        Q.insert(neighbor);
                    }
                    if(Q.hasKey(neighbor) && x < neighbor.priority){
                        Q.update(neighbor,x);
                        neighbor.priority = x;
                        neighbor.previousDirection = "North";
                    }
                }
            }
        }
        return "";
    }
    
    public static void writeToFile(String str) {
    	File answer = new File("src/pa3/answer.txt");
    	if(!answer.exists()) {
    		try {
    			answer.createNewFile();
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	try {
			FileWriter writer = new FileWriter(answer);
			writer.write(str);
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    public static void main(String args[]) {
        GraphWrapper gw = new GraphWrapper();
        GraphNode home = gw.getHome();
        writeToFile(run(gw,home));
        //System.out.println(run(gw,home));
    }
}
