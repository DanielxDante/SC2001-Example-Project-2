package b;

import java.util.Scanner;

public class DijkstraList {
        private static int numVertices;
        private static GraphList gl; // adjacency list graph implementation
        private static MinHeap priorityQueue; // priority queue heap implementation
        private static int solutionSet[]; // store binary if vertex is in solution set
        private static int shortestDistances[]; // store distances from source for algo
        private static int predecessors[]; // store running path
        public static void main(String[] args) {
            int i;
            Scanner sc = new Scanner(System.in);
            
            initialise();
            System.out.println("Adjacency List:");
            gl.printList();

            System.out.print("Enter Source Vertex: ");
            int source = sc.nextInt();

            long startTime = System.nanoTime();
            Dijkstra(gl.getList(), source);
            long endTime = System.nanoTime();

            System.out.println("After Dijkstra's Algorithm:");
            System.out.print("Solution Set S: ");
            for (i = 0; i < numVertices; i++) {
                    System.out.print(solutionSet[i] + " ");
            }
            System.out.println();
            System.out.print("Array of Distances d: ");
            for (i = 0; i < numVertices; i++) {
                    System.out.print(shortestDistances[i] + " ");
            }
            System.out.println();
            System.out.print("Array of Predecessors p: ");
            for (i = 0; i < numVertices; i++) {
                    System.out.print(predecessors[i] + " ");
            }
            System.out.println();
            
            long totalTime = endTime - startTime;
            System.out.println("Program time taken: " + totalTime/1000000000);
        }

        public static void initialise() {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Initialising Graph");
            System.out.print("Enter number of vertices: ");
            numVertices = sc.nextInt();
            gl = new GraphList(numVertices);
            solutionSet = new int[numVertices];
            shortestDistances = new int[numVertices];
            predecessors = new int[numVertices];
            priorityQueue = new MinHeap(numVertices * 3); // max size = ?

            System.out.print("Enter number of edges: ");
            int numEdges = sc.nextInt();

            for (int i = 0; i < numEdges; i++) {
                    System.out.println("=== Edge " + (i + 1) + " ===");
                    System.out.print("Start Vertex: ");
                    int v1 = sc.nextInt();
                    System.out.print("End Vertex: ");
                    int v2 = sc.nextInt();
                    System.out.print("Weight: ");
                    int weight = sc.nextInt();
                    gl.addEdge(v1, v2, weight);
            }
            
            System.out.println("Graph Initialised");
        }

        public static void Dijkstra(LinkedList[] graph, int source) { // source starts from vertex 1
            int i;
            HeapItem nextVertex;
            ListNode nextNode;

            for (i = 0; i < numVertices; i++) {
                    shortestDistances[i] = Integer.MAX_VALUE; // infinity
                    predecessors[i] = -1; // -1 as null pointer
                    solutionSet[i] = 0; // 1 is vertex is in S
            }

            shortestDistances[source - 1] = 0;
            solutionSet[source - 1] = 1;

            nextNode = graph[source - 1].getHead(); // first edge in source's linked list
            for (i = 0; i < graph[source - 1].getSize(); i++) { // loop edges in source's linked list
                shortestDistances[nextNode.getVertexID() - 1] = shortestDistances[source - 1] + nextNode.getWeight();
                priorityQueue.insert(nextNode.getVertexID(), nextNode.getWeight());
                predecessors[nextNode.getVertexID() - 1] = source;
                nextNode = nextNode.getNext();
            }
            priorityQueue.heapify(0);

            while (!priorityQueue.isEmpty()) { // while priorityQueue not empty
                    nextVertex = priorityQueue.deleteMin(); // find next vertex to explore; fixHeap later
                    while (solutionSet[nextVertex.getVertexID() - 1] == 1) { // dequeue if vertex is already in solution set
                        if (priorityQueue.isEmpty())
                                break;
                        nextVertex = priorityQueue.deleteMin();
                    }
                    
                    int currentVertexID = nextVertex.getVertexID();
                    solutionSet[currentVertexID - 1] = 1; // add to solution set
                    
                    nextNode = graph[currentVertexID - 1].getHead(); // first edge in current vertex's linked list
                    for (i = 0; i < graph[currentVertexID - 1].getSize(); i++) { // loop edges in current vertex's linked list
                        if (solutionSet[nextNode.getVertexID() - 1] == 0 && shortestDistances[nextNode.getVertexID() - 1] > shortestDistances[currentVertexID - 1] + nextNode.getWeight()) {
                                shortestDistances[nextNode.getVertexID() - 1] = shortestDistances[currentVertexID - 1] + nextNode.getWeight();
                                priorityQueue.insert(nextNode.getVertexID(), nextNode.getWeight());
                                predecessors[nextNode.getVertexID() - 1] = currentVertexID;
                                nextNode = nextNode.getNext();
                        }
                    }
                    priorityQueue.heapify(0);
            }
            
        }
}
