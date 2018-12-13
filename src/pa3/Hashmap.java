package pa3;
/**
 * This class implements the Hashmap data structure, which allows to add items and test if they are elements of the heap
 * @author Huiyan Zhang; nicolezhang@brandeis.edu
 */
public class Hashmap {

    private static final float FACTOR = 0.75f;
    private int threshold;
    private int size;

    private Entry[] eList;

    /**
     * Constructor
     * @param size
     */
    public Hashmap(int size) {
        eList = new Entry[size];
        threshold = (int) (size * FACTOR);
        size = 0;
    }
    
   /**
    * Hash function
    * @param key, a graphNode
    * @return the index of the key
    * The running time is O(1)
    */
    private int index(GraphNode key) {
        return (key.getId().hashCode() & 0x7FFFFFFF) % eList.length;
    }

    /**
     * check the hashmap to see if there is an Entry for the key,
     * if there is, change its value to “value”, 
     * if there isn't, add it to the hashmap with that value.
     * @param key, a GraphNode key
     * @param value, the value that would be changed to
     * The running time is O(1)
     */
    public void set(GraphNode key, int value) {
        if (key == null) return;
        int index = index(key);
        Entry entry = eList[index];
        while (entry != null) {
            if (entry.getKey().getId().equals(key.getId())) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        add(index, key, value);
    }
    
    /**
     * Add a new element to the hashmap
     * @param index, the index of that element
     * @param key, the graphNode
     * @param value, the value
     * The running time is O(1)
     */
    private void add(int index, GraphNode key, int value) {
        Entry entry = new Entry(key, value, eList[index]);
        eList[index] = entry;
        if (size++ >= threshold) {//rehashing
            resize(eList.length * 2);
        }
    }

    /**
     * Rehashing if the space is not enough
     * @param capacity, the current space
     * The running time is O(n)
     */
    private void resize(int capacity) {
        if (capacity <= eList.length) return;
        Entry[] neweList = new Entry[capacity];
        for (int i = 0; i < eList.length; i++) {
            Entry old = eList[i];
            while (old != null) {
                Entry next = old.getNext();
                int index = (old.getKey().getId().hashCode() & 0x7FFFFFFF) % neweList.length;//use new array length
                old.setNext(neweList[index]);
                neweList[index] = old;
                old = next;
            }
        }
        eList = neweList;
        threshold = (int) (eList.length * FACTOR);
    }

    /**
     * Gets the value for the entry with g as the key
     * @param g, the graphNode
     * @return the value for the entry if exists
     * The running time is O(1)
     */
    public int getValue(GraphNode g) {
        if (g == null) return -1;
        Entry entry = getEntry(g);
        return entry == null ? -1 : entry.getValue();
    }

    /**
     * Gets the entry of the graphNode key
     * @param key, the graphNode
     * @return entry if exists; null if not
     * The running time is O(1)
     */
    public Entry getEntry(GraphNode key) {
        int a = index(key);
        Entry entry = eList[index(key)];
        while (entry != null) {
            if (entry.getKey().getId().equals(key.getId())) {
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }

    /**
     * Remove an element from the hashmap
     * @param key, a graphNode as the key 
     * The running time is O(1)
     */
    public void remove(GraphNode key) {
        if (key == null) return;
        int index = index(key);
        Entry pre = null;
        Entry entry = eList[index];
        while (entry != null) {
            if (entry.getKey().getId().equals(key.getId())) {
                if (pre == null) eList[index] = entry.getNext();
                else pre.setNext(entry.getNext());
                size--;
                return;
            }
            pre = entry;
            entry = entry.getNext();
        }
    }
    
    /**
     * Distinguish if the hashmap has the key
     * @param key, a graphNode as the key
     * @return true if the hasmap has the key; false if not
     * The running time is O(1)
     */
    public boolean hasKey(GraphNode key) {
        if (key == null) return false;
        return getEntry(key) != null;
    }

    /**
     * Get the size of the hashmap
     * @return the size of the hashmap
     * The running time is O(1)
     */
    public int size() {
        return this.size;
    }

    /**
     * Clean the whole hashmap
     * The running time is O(n)
     */
    public void clear() {
        for (int i = 0; i < eList.length; i++) {
            eList[i] = null;
        }
        this.size = 0;
    }
}