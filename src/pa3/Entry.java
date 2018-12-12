package pa3;

/**
 * This class creates Entry object including a key and a value in order to store in the hashmap later
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class Entry {
    private final GraphNode key;//key which is the mentioned graphNode
    private int value; // value which is the index of the graphNode in the heap array
    private Entry next; //the next Entry

    /**
     * Constructor
     * @param key, the graphNode
     * @param value, the index of the graphNode in the heap array
     * @param next, the next entry
     */
    public Entry(GraphNode key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Get the key of the entry
     * @return the key of the entry
     * The running time is O(1)
     */
    public GraphNode getKey() {
        return key;
    }

    /**
     * Get the value of the entry
     * @return the value of the entry
     * The running time is O(1)
     */
    public int getValue() {
        return value;
    }
    /**
     * Set the value of the entry
     * @param value, the value of the GraphNode which is the index of the graphNode in the heap array
     * The running time is O(1)
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Get the next entry of the entry
     * @return the next entry
     * The running time is O(1)
     */
    public Entry getNext() {
        return next;
    }
    
    /**
     * Set the next entry of the current entry
     * @param next, the next entry of the current entry
     * The running time is O(1)
     */
    public void setNext(Entry next) {
        this.next = next;
    }
}

