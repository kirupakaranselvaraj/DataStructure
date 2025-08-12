package graph;
import java.util.*;

public class DijkstraGraphMatrixoperation {
    static int[][] adjacencyMatrix;
    static int numVertices;
    public DijkstraGraphMatrixoperation(int numVertices) {
        DijkstraGraphMatrixoperation.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }
    public static void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
    }
    public static void removeEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 0;
    }
    public static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    public static void dijkstra(int src) {
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int count = 0; count < numVertices - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjacencyMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjacencyMatrix[u][v];
                }
            }
        }
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " distance from source: " + dist[i]);
        }
    }
    public static void main(String[] args) {
        DijkstraGraphMatrixoperation graph = new DijkstraGraphMatrixoperation(5);
        addEdge(0, 1, 10);
        addEdge(0, 4, 5);
        addEdge(1, 2, 1);
        addEdge(1, 4, 2);
        addEdge(2, 3, 4);
        addEdge(3, 0, 7);
        addEdge(3, 2, 6);
        addEdge(4, 1, 3);
        addEdge(4, 2, 9);
        addEdge(4, 3, 2);
        removeEdge(4, 2);
        dijkstra(0);
    }
}
