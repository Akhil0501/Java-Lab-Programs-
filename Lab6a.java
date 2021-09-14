package javaProgram;

import java.util.Scanner;

class KnapS{
	void knap(int w[],int value[],int n,int m)
	{
		int i,j;
		int a[][] = new int[n+1][m+1];
		int x[] = new int[10];
		for(i=0 ; i<=n ; i++)
			for(j=0 ; j<=m ; j++)
			{
				if(i==0 || j==0)
					a[i][j] = 0;
				else if(j < w[i])
						a[i][j] = a[i-1][j];
				else
					a[i][j] = Math.max(a[i-1][j],(value[i]+a[i-1][j-w[i]]));
			}
		System.out.println("\nSolution Matrix");
		for(i=0 ; i<=n ; i++)
		{
			for(j=0 ; j<=m ; j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println("Optimal Solution is : "+a[n][m]);
		for(i=0 ; i<=n ; i++)
			x[i] = 0;
		i=n;
		j=m;
		while(i>0 && j>0)
		{
			if(a[i][j] != a[i-1][j])
			{
				x[i] = 1;
				j = j - w[i];
			}
			i--;
		}
		System.out.print("The Solution Vector is : ");
		for(i=1 ; i<=n ; i++)
			System.out.print(x[i]+" ");
		System.out.print("\nSelected items are : ");
		for(i=0 ; i<=n ; i++)
			if(x[i] == 1)
				System.out.print(i+" ");
	}
}

public class Lab6a {

	public static void main(String[] args) {
		int w[] = new int[100];
		int value[] = new int[100];
		int i,n,m;
		System.out.print("Enter the number of items : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the weight of each item");
		for(i=1 ; i<=n ; i++)
			w[i] = in.nextInt();
		System.out.println("Enter the value of each item");
		for(i=1 ; i<=n ; i++)
			value[i] = in.nextInt();
		System.out.print("Enter the capacity of knapsack : ");
		m = in.nextInt();
		KnapS k = new KnapS();
		k.knap(w,value,n,m);
	}

}
