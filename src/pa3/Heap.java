package pa3;

public class Heap {

    private GraphNode[] nodeArray;
    private int maxSize;
    private int currentSize;
    private Hashmap hmap;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        nodeArray = new GraphNode[maxSize];
        hmap = new Hashmap(maxSize);
    }

    public boolean hasKey(GraphNode g){
        return hmap.hasKey(g);
    }

    public boolean isEmpty() {
        return (currentSize == 0)? true : false;
    }

    public boolean isFull() {
        return (currentSize == maxSize)? true : false;
    }

    public boolean insert(GraphNode g) {
        if(isFull()) {
            return false;
        }
        nodeArray[currentSize] = g;
        hmap.set(nodeArray[currentSize],currentSize);
        heapifyUp(currentSize++);
        return true;
    }

    public void heapify(GraphNode g){
        int index = (int)hmap.getValue(g);
        heapifyUp(index);
        heapifyDown(index);
    }

    private void heapifyUp(int i) {
        int p = (i - 1) / 2;
        GraphNode bottom = nodeArray[i];
        while(i > 0 && nodeArray[p].priority > bottom.priority) {
            nodeArray[i] = nodeArray[p];
            hmap.set(nodeArray[i],i);
            i = p;
            p = (p - 1) / 2;
        }
        nodeArray[i] = bottom;
        hmap.set(nodeArray[i],i);
    }

    public GraphNode remove() {
        GraphNode root = nodeArray[0];
        nodeArray[0] = nodeArray[--currentSize];
        hmap.set(nodeArray[0],0);
        heapifyDown(0);
        return root;
    }

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
            if(top.priority <= nodeArray[target].priority) {
                break;
            }

            nodeArray[i] = nodeArray[target];
            hmap.set(nodeArray[i],i);
            i = target;
        }

        nodeArray[i] = top;
        hmap.set(nodeArray[i],i);
    }

    public boolean update(GraphNode g,int newPriority) {
        return change((int)hmap.getValue(g),newPriority);
    }

    private boolean change(int i, int newValue) {
        if(i < 0 || i >= currentSize) {
            return false;
        }
        int oldValue = nodeArray[i].priority;
        nodeArray[i].priority = newValue;
        if(oldValue < newValue) {
            heapifyUp(i);
        }
        else {
            heapifyDown(i);
        }
        return true;
    }
}