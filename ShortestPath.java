import java.util.*;

class ShortestPath {
    
    static final int V = 9; // Number of vertices in the graph

    // A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in the shortest path tree
    int minDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[]) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    // Function that implements Dijkstra's single source shortest path algorithm
    // for a graph represented using adjacency matrix representation
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // Output array. dist[i] will hold the shortest distance from src to i
        boolean sptSet[] = new boolean[V]; // sptSet[i] will be true if vertex i is included in the shortest path tree

        // Initialize all distances as INFINITE and sptSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // Update dist[v] if it is not in sptSet, there is an edge from u to v,
                // and total weight of path from src to v through u is smaller than the current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE 
                    && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { 
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
        };

        ShortestPath sp = new ShortestPath();
        sp.dijkstra(graph, 0); // Starting vertex is 0
    }
}
