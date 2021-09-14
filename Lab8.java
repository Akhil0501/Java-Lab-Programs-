package javaProgram;

import java.util.Scanner;

class Kruskal{
	int n,i,j,min,a=0,b=0,nedges=1,u=0,v=0,mincost=0,m=0;
	int parent[] = new int[10];
	int cost[][] = new int[10][10];
	void readCostMatrix() {
		System.out.print("Enter the number of vertices in the graph :");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the cost matrix :");
		for(i=1; i<=n; i++)
			for(j=1 ; j<=n ; j++)
			{
				cost[i][j] = in.nextInt();
				if(cost[i][j] == 0)
					cost[i][j] = 999;
			}
	}
	void findMST() {
		System.out.println("The edges of Minimum Spanning tree are");
		while(nedges < n)
		{
			min = 999;
			for(i=1; i<=n; i++)
				for(j=1 ; j<=n ; j++)
					if(cost[i][j] < min)
					{
						min = cost[i][j];
						a = u = i;
						b = v = j;
					}
			u = find(u);
			v = find(v);
			if(u != v)
			{
				union();
				System.out.println("Edge "+a+"--->"+b+" cost = "+min);
				mincost = mincost + min;
				nedges++;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.print("Minimum cost is "+mincost);
	}
	int find(int i) {
		m=i;
		while(parent[m] > 0)
			m = parent[m];
		return m;
	}
	void union() {
		parent[v] = u;
	}
}

public class Lab8 {

	public static void main(String[] args) {
		Kruskal k = new Kruskal();
		k.readCostMatrix();
		k.findMST();
	}

}
