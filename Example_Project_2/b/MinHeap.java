// Java's in built priority queue uses minimizing heap, but we shall code our own cos why not :D
package b;

public class MinHeap {
    private int theoreticalSize; // since we are not using the inbuilt heap, we need to handle our own memory
    private int size; // running size of the heap, not the upper limit of size of array for the heap; last element in the heap; for better documentation, it is better to put actual size, as in, empty index to store HeapItem
    private HeapItem[] heap;

    public MinHeap(int theoreticalSize) {
        this.theoreticalSize = theoreticalSize;
        this.size = -1; // heap index start from 0
        this.heap = new HeapItem[theoreticalSize];
        for (int i = 0; i < theoreticalSize; i++)
            heap[i] = new HeapItem();
    }

    public HeapItem[] getHeap() {
        return heap;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == -1);
    }
 
    public int getLeftChild(int i) { // returns index of left child of parent HeapItem with index i
        return (2 * i) + 1;
    }
 
    public int getRightChild(int i) { // returns index of right child of parent HeapItem with index i
        return (2 * i) + 2;
    }

    public HeapItem getMin() {
        return heap[0];
    }

    public HeapItem deleteMin() {
        HeapItem min = heap[0];
        // copyHeapItem(heap[0], heap[size]);
        heap[0] = heap[size];
        size--;
        fixHeap(0, heap[0]);
        return min;
    }

    public void insert(int vertexID, int weight) { // add HeapItem into heap
        size++;
        HeapItem newItem = new HeapItem(vertexID, weight);
        heap[size] = newItem;
    }

    public void heapify(int subHeap) {
        if (getLeftChild(subHeap) <= size || getRightChild(subHeap) <= size) {
            heapify(getLeftChild(subHeap));
            heapify(getRightChild(subHeap));
            HeapItem k = new HeapItem();
            k = heap[subHeap];
            fixHeap(subHeap, k);
        }
    }

    public void fixHeap(int subHeap, HeapItem k) {
        System.out.println("lol: " + k.getWeight());
        int smallerSubHeap = subHeap;
        if (getLeftChild(subHeap) > size && getRightChild(subHeap) > size) { // end of subtree
            heap[subHeap] = k;
        }
        else {
            if (getLeftChild(subHeap) <= size && getRightChild(subHeap) <= size) { // both children exists
                if (heap[getLeftChild(subHeap)].getWeight() <= heap[getRightChild(subHeap)].getWeight()) // prioritise left
                    smallerSubHeap = getLeftChild(subHeap);
                else
                    smallerSubHeap = getRightChild(subHeap);
            }
            else if (getLeftChild(subHeap) <= size && getRightChild(subHeap) > size) // only left child exist
                smallerSubHeap = getLeftChild(subHeap);
            else if (getLeftChild(subHeap) > size && getRightChild(subHeap) <= size) // only right child exist
                smallerSubHeap = getRightChild(subHeap);

            if (k.getWeight() <= heap[smallerSubHeap].getWeight()) { // subHeap is the minimum; end fixHeap
                heap[subHeap] = k;
            }
            else { // one of the children has the smaller weight
                heap[subHeap] = heap[smallerSubHeap];
                fixHeap(smallerSubHeap, k); // make sure the swap still maintains the heap property
            }
        }
    }

    public void printHeap() {
        System.out.print("Current State of Heap in Weight: ");
        for (int i = 0; i < size + 1; i++) {
            System.out.print(heap[i].getWeight() + " ");
        }
        System.out.println();
    }
}
