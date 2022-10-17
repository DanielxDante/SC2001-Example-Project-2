package a;

import java.util.Scanner;

class DijkstraMatrix {
        private static int numVertices;
        private static GraphMatrix gm; // adjacency matrix graph implementation
        private static PriorityQueueArray priorityQueue; // priority queue array implementation
        private static int solutionSet[]; // store binary if vertex is in solution set
        private static int shortestDistances[]; // store distances from source for algo
        private static int predecessors[]; // store running path
        
        public static void main(String[] args) {
                int i;
                Scanner sc = new Scanner(System.in);
                
                initialise();
                System.out.println("Adjacency Matrix:");
                gm.printMatrix();

                System.out.print("Enter Source Vertex: ");
                int source = sc.nextInt();

                long startTime = System.nanoTime();
                Dijkstra(gm.getMatrix(), source);
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
                gm = new GraphMatrix(numVertices);
                solutionSet = new int[numVertices];
                shortestDistances = new int[numVertices];
                predecessors = new int[numVertices];
                priorityQueue = new PriorityQueueArray(numVertices * 2); // max size = ?

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
                        gm.addEdge(v1 - 1, v2 - 1, weight);
                }
                
                System.out.println("Graph Initialised");
        }

        /* 
        1. Initialise data structures needed for Dijkstra
        2. Set distance from source to itself to 0
        3. Start the algo by putting edges from source to other vectices into queue
        4. Setup a while loop to loop the queue until it is empty
              4a. Check the queue for the vertex with least distance from source
              4b. Add that vertex to solution set
              4c. Explore that vertex and update shortest distances
        */ 


        public static void Dijkstra(int graph[][], int source) { // source starts from vertex 1
                int i;
                PriorityQueueItem nextVertex;

                for (i = 0; i < numVertices; i++) {
                        shortestDistances[i] = Integer.MAX_VALUE; // infinity
                        predecessors[i] = -1; // -1 as null pointer
                        solutionSet[i] = 0; // 1 is vertex is in S
                }

                shortestDistances[source - 1] = 0;
                solutionSet[source - 1] = 1;

                for (i = 0; i < numVertices; i++) { // loop edges from source
                        if (graph[source - 1][i] != -1) { // edge found
                                shortestDistances[i] = shortestDistances[source - 1] + graph[source - 1][i]; // updating shortest distance
                                priorityQueue.enqueue(i + 1, shortestDistances[i]); // add vertex to priority queue
                                predecessors[i] = source; // update predecessors
                        }
                }
                

                while (!priorityQueue.isEmpty()) { // while priorityQueue not empty
                        nextVertex = priorityQueue.dequeue(); // find next vertex to explore
                        while (solutionSet[nextVertex.getVertexID() - 1] == 1) { // dequeue if vertex is already in solution set
                                nextVertex = priorityQueue.dequeue();
                        }

                        int currentVertexID = nextVertex.getVertexID(); // we assign another variable here instead of referring to nextVertex because we will overwrite the memory position in PriorityQueueArray
                        solutionSet[currentVertexID - 1] = 1; // add to solution set
                        
                        for (i = 0; i < numVertices; i++) { // loop edges from nextVertex
                                if (solutionSet[i] == 0 && graph[currentVertexID - 1][i] != -1  && shortestDistances[i] > shortestDistances[currentVertexID - 1] + graph[currentVertexID - 1][i]) { 
                                        shortestDistances[i] = shortestDistances[currentVertexID - 1] + graph[currentVertexID - 1][i]; // updating shortest distance
                                        priorityQueue.enqueue(i + 1, shortestDistances[i]); // add vertex to priority queue
                                        predecessors[i] = currentVertexID;
                                }
                        }
                }      
        }
}