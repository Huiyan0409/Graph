package pa3;

public class Hashmap {

    private static final float FACTOR = 0.75f;
    private int threshold;
    private int size;

    private Entry[] eList;

    public Hashmap(int size) {
        eList = new Entry[size];
        threshold = (int) (size * FACTOR);
        size = 0;
    }

    private int index(GraphNode key) {
        return (key.hashCode() & 0x7FFFFFFF) % eList.length;
    }

    public void set(GraphNode key, int value) {
        if (key == null) return;
        int index = index(key);
        Entry entry = eList[index];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        add(index, key, value);
    }

    private void add(int index, GraphNode key, int value) {
        Entry entry = new Entry(key, value, eList[index]);
        eList[index] = entry;
        if (size++ >= threshold) {
            resize(eList.length * 2);
        }
    }

    private void resize(int capacity) {
        if (capacity <= eList.length) return;
        Entry[] neweList = new Entry[capacity];
        for (int i = 0; i < eList.length; i++) {
            Entry old = eList[i];
            while (old != null) {
                Entry next = old.getNext();
                int index = index(old.getKey());
                old.setNext(neweList[index]);
                neweList[index] = old;
                old = next;
            }
        }
        eList = neweList;
        threshold = (int) (eList.length * FACTOR);
    }

    public Object getValue(GraphNode key) {
        if (key == null) return null;
        Entry entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    public Entry getEntry(GraphNode key) {
        int a = index(key);
        Entry entry = eList[index(key)];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }

    public void remove(GraphNode key) {
        if (key == null) return;
        int index = index(key);
        Entry pre = null;
        Entry entry = eList[index];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                if (pre == null) eList[index] = entry.getNext();
                else pre.setNext(entry.getNext());
                size--;
                return;
            }
            pre = entry;
            entry = entry.getNext();
        }
    }

    public boolean hasKey(GraphNode key) {
        if (key == null) return false;
        return getEntry(key) != null;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < eList.length; i++) {
            eList[i] = null;
        }
        this.size = 0;
    }
}

