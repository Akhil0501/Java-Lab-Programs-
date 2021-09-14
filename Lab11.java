package javaProgram;

import java.util.Scanner;

public class Lab11 {
	static int c = 0;
	public static void main(String[] args) {
		int i,n,d,sum=0;
		int x[] = new int[50];
		int a[] = new int[50];
		System.out.print("Enter the number of elements : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("Enter the set of elements in ascending order");
		for(i=0 ; i<n ; i++) {
			a[i] = in.nextInt();
			sum += a[i];
		}
		for(i=0 ; i<n ; i++)
			x[i] = 0;
		System.out.print("Enter the d value : ");
		d = in.nextInt();
		if(sum<d || a[0]>d )
			System.out.println("No Solution");
		else {
			findSubset(0,0,sum,x,a,d);
			if(c == 0)
				System.out.println("No Solution");
		}
			
	}
	static void findSubset(int csum,int k,int sum,int[] x,int[] a,int d)
	{
		x[k] = 1;
		if(csum+a[k] == d)
		{
			c++;
			System.out.print("\nSolution "+c+" is { ");
			for(int i=0 ; i<=k ; i++)
				if(x[i] == 1)
					System.out.print(a[i]+" ");
			System.out.println("}");
		}
		else if(csum+a[k]+a[k+1] <= d)
				findSubset(csum+a[k],k+1,sum-a[k],x,a,d);
		if((csum+sum-a[k]) >= d  &&  (csum+a[k+1]) <= d )
		{
			x[k] = 0;
			findSubset(csum,k+1,sum-a[k],x,a,d);
		}
	}

}
