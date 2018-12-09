package pa3;

public class MinPriorityQueue{

    private Heap heap;

    public MinPriorityQueue(int mx){
        heap=new Heap(mx);
    }

    public void insert(GraphNode g){
        heap.insert(g);
    }

    public GraphNode pullHighestPriorityElement(){
        return heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public void update(GraphNode g, int newPriority){
        heap.update(g,newPriority);
    }

    public boolean hasKey(GraphNode g){
        return heap.hasKey(g);
    }

    public void rebalance(GraphNode g) {heap.heapify(g);}

}
