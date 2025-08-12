package graph;
import java.util.*;

public class DijkstraGraphMatrix {
	static int[][]adjacencyMatrix;
	static int numVertices;
	public DijkstraGraphMatrix(int numVertices) {
		DijkstraGraphMatrix.numVertices = numVertices;
		adjacencyMatrix = new int[numVertices][numVertices];
	}
	public static void addEdge(int src,int dest,int weight) {
		adjacencyMatrix[src][dest] = weight;
	}
	public static void dijkstra(int start) {
		int[] dist=new int[numVertices];
		boolean[] vist=new boolean[numVertices];
	    Arrays.fill(dist,Integer.MAX_VALUE);
		dist[start]=0;
	    
	    for(int count=0;count<numVertices-1;count++) {
	    	int mind=minDistance(dist,vist);
	    	if(mind == -1) break;
	    	vist[mind]=true;
	    	
	    	for(int v=0;v<numVertices;v++) {
	    		if(!vist[v] && adjacencyMatrix[mind][v]!=0 && 
dist[mind]!=Integer.MAX_VALUE){
	    			int newDist = dist[mind] + adjacencyMatrix[mind][v];
	    			if(newDist < dist[v]) {
	    				dist[v]= newDist;
	    			}
	    		}
	    	}
	    }
	    print(dist,start);
	}
	public static void print(int[] dist,int start) {
		System.out.println("Starting Place:"+start);
		for(int i=0;i<numVertices;i++) {
			System.out.println(start+" -> "+ i+" = "+dist[i]);
		}
	}
	public static int minDistance(int[] dis,boolean[] vist) {
		int min=Integer.MAX_VALUE,minIndex=-1;
		for(int v=0;v<numVertices;v++) {
			if(!vist[v] && dis[v] < min) {
				min = dis[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		DijkstraGraphMatrix ds=new DijkstraGraphMatrix(6);
		addEdge(0,1,4);
		addEdge(0,2,2);
		addEdge(1,2,5);
		addEdge(1,3,10);
		addEdge(3,4,4);
		addEdge(3,5,11);
		dijkstra(0);
	}
	
}
