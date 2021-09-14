package javaProgram;

import java.util.Scanner;

class Dijkstras{
	int i,j,n,src;
	int a[][] = new int[50][50];
	Scanner in = new Scanner(System.in);
	void readCostAdjacencyMatrix() {
		System.out.print("Enter number of vertices : ");
		n = in.nextInt();
		System.out.println("Enter the Adjacency matrix");
		for(i=1 ; i<=n ; i++)
			for(j=1 ; j<=n ; j++)
				a[i][j] = in.nextInt();
		System.out.print("Enter source vertices : ");
		src = in.nextInt();
	}
	int findMinDistance(int[] d, int[] visited) {
		int minDistance = 999;
		int minDistanceVertex = -1;
		for(int i=1 ; i<=n ; i++)
			if(visited[i] == 0 && d[i]<minDistance) {
				minDistance = d[i];
				minDistanceVertex = i;
			}
		return minDistanceVertex;
	}
	void dijkrasmethod() {
		int[] visited = new int[100];;
		int[] d = new int[100];
		for(int i=1 ; i<=n ; i++) {
			visited[i] = 0;
			d[i] = 999;
		}
		d[src] = 0;
		for(int i=1 ; i<=n ;i++) {
			int u = findMinDistance(d,visited);
			visited[u] = 1;
			for(int v=1; v<=n ; v++)
				if(visited[v] == 0 && (d[u]+a[u][v])<d[v])
					d[v] = d[u]+a[u][v];
		}
		System.out.println();
		for(int i=1 ; i<=n ; i++)
			System.out.println("Shortest Distance from source vertex "+src+" to vertex "+i+" is "+d[i]);
	}
}

public class Lab7 {

	public static void main(String[] args) {
		Dijkstras d = new Dijkstras();
		d.readCostAdjacencyMatrix();
		d.dijkrasmethod();
	}

}
