package javaProgram;

import java.util.Scanner;

public class Lab10b {
	static int cost[][];
	int tsp(int[] tour,int start,int n) {
		int i,j,k,ccost;
		int mtour[] = new int[n+1];
		int temp[] = new int[n+1];
		if(start == n-2)
			return cost[tour[n-2]][tour[n-1]]+cost[tour[n-1]][0];
		int mcost = 999;
		for(i=start+1 ;i<n ; i++)
		{
			for(j=0 ;j<n ; j++)
				temp[j] = tour[j];
			temp[start+1] = tour[i];
			temp[i] = tour[start+1];
			if(cost[tour[start]][tour[i]]+(ccost = tsp(temp,start+1,n))<mcost)
			{
				mcost = cost[tour[start]][tour[i]]+ccost;
				for(k=0 ;k<n ; k++)
					mtour[k] = temp[k];
			}
		}
		for(i=0 ;i<n ; i++)
			tour[i] = mtour[i];
		return mcost;
	}
	public static void main(String[] args) {
		int mcost, n, i, j;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of cities : ");
		n = in.nextInt();
		int tour[] = new int[n];
		cost = new int[n][n];
		System.out.println("Enter the cost matrix");
		for(i=0 ;i<n ; i++)
			for(j=0 ;j<n ;j++)
				cost[i][j] = in.nextInt();
		for(i=0 ;i<n ; i++)
			tour[i] = i;
		int k=0;
		Lab10b obj = new Lab10b();
		mcost = obj.tsp(tour, k, n);
		System.out.println("Optimal tour is ");
		for(i=0 ;i<n ; i++)
			System.out.print(tour[i]+"--->");
		System.out.println("0");
		System.out.println("Tour cost = "+mcost);
	}

}
