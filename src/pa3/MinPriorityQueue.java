package pa3;

/**
 * This class implement the minPriorityQueue data structure
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class MinPriorityQueue{

    public Heap heap;
    
    /**
     * Constructor
     * @param mx, the size of the queue
     */
    public MinPriorityQueue(int mx){
        heap=new Heap(mx);
    }

    /**
     * insert g into the queue with its priority
     * @param g, a graphNode which is an element in the queue
     * The running time is O(logn)
     */
    public void insert(GraphNode g){
        heap.insert(g);
    }

    /**
     * return and remove from the priority queue the GraphNode with the highest priority in the queue
     * @return the graphNode with the highest prioirty
     * The running time is O(logn)
     */
    public GraphNode pullHighestPriorityElement(){
        return heap.remove();
    }

    /**
     * Distinguish if the queue is empty
     * @return true if the queue is empty; false if not
     * The running time is O(1)
     */
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    /**
     * Update the graphNode with a new Priority
     * @param g, a graphNode 
     * @param newPriority, the new priority
     * The running time is O(logn)
     */
    public void update(GraphNode g, int newPriority){
        heap.update(g,newPriority);
    }

    /**
     * Distinguish if a graphNode has key
     * @param g, a graphNode
     * @return true if has key; false if not
     * The running time is O(1)
     */
    public boolean hasKey(GraphNode g){
        return heap.hasKey(g);
    }

    /**
     * call the heapify method
     * @param g, a graphNode
     * The running time is O(logn)
     */
    public void rebalance(GraphNode g) {heap.heapify(g);}

}
