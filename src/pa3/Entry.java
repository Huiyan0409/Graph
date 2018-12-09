package pa3;

class Entry {
    private final GraphNode key;
    private int value;
    private Entry next;

    public Entry(GraphNode key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public GraphNode getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}

