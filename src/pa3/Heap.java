package pa3;

/**
 * This class implements the heap data structure
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class Heap {

    private GraphNode[] nodeArray;
    private int maxSize;
    private int currentSize;
    private Hashmap hmap;
    
    /**
     * Constructor
     * @param mx, the maxSize of the heap
     */
    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        nodeArray = new GraphNode[maxSize];
        hmap = new Hashmap(maxSize);
    }
    
    /**
     * Distinguish whether the graphNode has key
     * @param g, a graghNode
     * @return true if the GraphNode has key in the heap, false if not
     * The running time is O(1)
     */
    public boolean hasKey(GraphNode g){
        return hmap.hasKey(g);
    }

    /**
     * Distinguish whether the heap is empty
     * @return true if the heap is empty; false if not
     * The running time is O(1)
     */
    public boolean isEmpty() {
        return (currentSize == 0)? true : false;
    }

    /**
     * Distinguish whether the heap is already full
     * @return true if the heap is already full; false if not
     * The running time is O(1)
     */
    public boolean isFull() {
        return (currentSize == maxSize)? true : false;
    }
    
    /**
     * Insert the graphNode to the heap
     * @param g, the graphNode that is going to be inserted
     * @return true if insert successfully; false if not
     * The running time is O(logn)
     */
    public boolean insert(GraphNode g) {
        if(isFull()) {
            return false;//if the heap is already full, return false since insert cannot be success
        }
        nodeArray[currentSize] = g;
        hmap.set(nodeArray[currentSize],currentSize);
        heapifyUp(currentSize++);
        return true;
    }
    
    /**
     * Heapify the inserting graphNode in the heap
     * @param g, the graphNode
     * The running time is O(logn)
     */
    public void heapify(GraphNode g){
        int index = (int)hmap.getValue(g);
        heapifyUp(index);
        heapifyDown(index);
    }

    /**
     * HeaifyUp a node in the heap
     * @param i, the index of a graphNode
     * The running time is O(logn)
     */
    public  void heapifyUp(int i) {
        int p = (i - 1) / 2;
        GraphNode bottom = nodeArray[i];
        while(i > 0 && nodeArray[p].priority >=bottom.priority) {
            nodeArray[i] = nodeArray[p];
            hmap.set(nodeArray[i],i);
            i = p;
            p = (p - 1) / 2;
        }
        nodeArray[i] = bottom;
        hmap.set(nodeArray[i],i);
    }
    
    /**
     * Remove a graphNode from the heap
     * @return the graphNode that is removed
     * The running time is O(logn)
     */
    public GraphNode remove() {
        GraphNode root = nodeArray[0];
        nodeArray[0] = nodeArray[--currentSize];
        hmap.set(nodeArray[0],0);
        heapifyDown(0);
        return root;
    }
    
    /**
     * HeapifyDown a graphNode in the heap
     * @param i, the index of a graphNode
     * The running time is O(logn)
     */
    public void heapifyDown(int i) {
        GraphNode top = nodeArray[i];
        int target;
        while(i < currentSize/2) {
            int l = 2 * i + 1;
            int r = l + 1;
            if(r < currentSize &&
                    nodeArray[l].priority > nodeArray[r].priority) {
                target = r;
            }
            else {
                target = l;
            }
            if(top.priority < nodeArray[target].priority) {
                break;
            }

            nodeArray[i] = nodeArray[target];
            hmap.set(nodeArray[i],i);
            i = target;
        }

        nodeArray[i] = top;
        hmap.set(nodeArray[i],i);
    }
    
    /**
     * update a graphNode with a newPriority
     * @param g, a graphNode
     * @param newPriority, the new value that wants to be changed to
     * @return true if the change succeed; false if not
     * The running time is O(logn)
     */
    public boolean update(GraphNode g,int newPriority) {
        return change((int)hmap.getValue(g),newPriority);
    }
    
    /**
     * change the value of the node and make related adjusting
     * @param i, the index of the node
     * @param newValue, the new value that wants to be changed to
     * @return true if the change succeed; false if not
     * The running time is O(logn)
     */
    private boolean change(int i, int newValue) {
        if(i < 0 || i >= currentSize) {
            return false;
        }
        int oldValue = nodeArray[i].priority;
        nodeArray[i].priority = newValue;
        if(oldValue < newValue) {
            heapifyUp(i);//heapifyUp if new value is larger
        }
        else {
            heapifyDown(i);//heapifyDown if new value is smaller
        }
        return true;
    }
}