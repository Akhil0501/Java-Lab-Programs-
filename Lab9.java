package javaProgram;

import java.util.Scanner;

class Prims{
	int n,i,j;
	int a[][] = new int[10][10];
	void readWeightMatrix() {
		System.out.print("Enter the number of vertices in the graph : ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the Weight matrix");
		for(i=1; i<=n; i++)
			for(j=1; j<=n; j++)
				a[i][j] = in.nextInt();
	}
	void findMinSpanningTree() {
		int min,u=0,v=0,k=0,count=0,cost=0;
		int visited[] = new int[10];
		int t[][] = new int[10][10];
		visited[1] = 1;
		while(count != (n-1))
		{
			for(i=1,min=999; i<=n ;i++)
				for(j=1; j<=n; j++)
					if(visited[i] == 1  &&  visited[j] == 0  &&  min > a[i][j])
					{
						min = a[i][j];
						u = i;
						v = j;
					}
			if(min == 999) break;
			t[k][0] = u;
			t[k][1] = v;
			t[k][2] = min;
			visited[v] = 1;
			cost += min;
			k++;
			count++;
		}
		if(count == n-1)
		{
			System.out.println("\nMinimum cost spanning tree is");
			System.out.println("Edge\tWeight");
			for(i=0; i<k; i++)
				System.out.println(t[i][0]+"--->"+t[i][1]+"\t"+t[i][2]);
			System.out.print("Cost of Spanning tree is : "+cost);
		}
		else
			System.out.println("Spanning tree doesn't exist");
	}
}

public class Lab9 {

	public static void main(String[] args) {
		Prims p = new Prims();
		p.readWeightMatrix();
		p.findMinSpanningTree();
	}

}
