package a;

class PriorityQueueArray extends PriorityQueueItem {
    private PriorityQueueItem priorityQueue[];
    private int size;
    private int tail;

    public PriorityQueueArray(int size) {
        this.size = size;
        this.tail = 0;
        priorityQueue = new PriorityQueueItem[size];
        for (int i = 0; i < size; i++) {
            priorityQueue[i] = new PriorityQueueItem();
        }
    }

    public void enqueue(int vertexID, int weight) { // add entry to tail of array
        if (tail == size - 1) 
            System.out.println("Priority Queue is full!");
        else {
            priorityQueue[tail].setVertexID(vertexID);
            priorityQueue[tail].setWeight(weight);
            tail++;
            // call mergesort to sort updated queue in descending order
            Mergesort.mergeSort(priorityQueue, 0, tail-1);
        }
    }

    public PriorityQueueItem dequeue() { // remove least weight entry from the array
        PriorityQueueItem item = this.getTail();
        tail--;
        return item;
    }

    public PriorityQueueItem getTail() { // modified to return the PriorityQueueItem at the tail of queue
        return this.priorityQueue[this.tail-1];
    }
    
    public boolean isEmpty() { // makes more sense to call a method called isEmpty than getTail
    	if(this.tail == 0) {
    		return true;
    	}
    	return false;
    }

    public PriorityQueueItem[] getPriorityQueue() {
        return priorityQueue;
    }
}
