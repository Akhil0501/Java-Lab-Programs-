package javaProgram;

import java.util.Scanner;

class HamiltonianCycle
{
	void Hamiltonian(int k,int n,int a[][],int x[]){
		int i;
		while(true)
		{
			nextvalue(k,n,a,x);
			if(x[k] == 0)
				return;
			if(k == n)
			{
				System.out.print("Solution : " );
				for(i=1 ; i<=n ; i++)
					System.out.print(x[i]+" ---> ");
				System.out.print(x[1]+"\n" );
			}
			else
				Hamiltonian(k+1,n,a,x);
		}
	}
	void nextvalue(int k,int n,int a[][],int x[]){
		int j;
		while(true)
		{
			x[k] = (x[k]+1) % (n+1);
			if(x[k] == 0)
				return;
			if(a[x[k-1]][x[k]] == 1)
			{
				for(j=1 ; j<=k-1 ; j++)
					if(x[j] == x[k])
						break;
				if(j == k )
					if((k<n)  ||  ((k==n) && (a[x[n]][1] == 1)))
						return;
			}
		}
	}
}

public class Lab12 {

	public static void main(String[] args) {
		int a[][] = new int[20][20];
		int x[] = new int[20];
		int n,i,j,k=2;
		HamiltonianCycle h = new HamiltonianCycle();
		System.out.print("Enter the total number of vertices in the graph : " );
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the adjacency matrix" );
		for(i=1 ; i<=n ; i++)
			for(j=1 ; j<=n ;j++)
				a[i][j] = in.nextInt();
		x[1] = 1;
		for(i=2 ; i<=n ; i++)
			x[i] = 0;
		h.Hamiltonian(k,n,a,x);	
	}

}
