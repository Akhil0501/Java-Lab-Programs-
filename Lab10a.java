package javaProgram;

import java.util.Scanner;

class Floyd{
	void readWeightMatrix() {
		int i,j,n;
		int cost[][] = new int[20][20];
		System.out.print("Enter the number of vertices : ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the weight matrix");
		for(i=1 ;i<=n ; i++)
			for(j=1 ;j<=n ;j++)
				cost[i][j] = in.nextInt();
		computeDistMatrix(cost,n);
	}
	void computeDistMatrix(int cost[][],int n) {
		int i,j,k;
		for(k=1 ;k<=n ; k++)
			for(i=1 ;i<=n ; i++)
				for(j=1 ;j<=n ; j++)
					cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]);
		System.out.println("The Shortest distance matrix is");
		for(i=1 ;i<=n ; i++) {
			for(j=1 ;j<=n ;j++)
				System.out.print(cost[i][j]+" ");
			System.out.println();
		}
	}
}

public class Lab10a {

	public static void main(String[] args) {
		Floyd f = new Floyd();
		f.readWeightMatrix();
	}

}
