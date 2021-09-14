package javaProgram;

import java.util.Scanner;

class KnapSack{
	void greedyKnapsack(float[] weight,float[] profit,int n,float capacity)
	{
		float p=0, u;
		float x[] = new float[10];
		int i;
		for(i=0 ; i<n ;i++)
			x[i] = 0;
		u = capacity;
		for(i=0 ; i<n ;i++)
		{
			if(weight[i] > u) break;
			x[i] = 1;
			u = u - weight[i];
		}
		if(i < n)
			x[i] = (float) u/weight[i];
		System.out.print("\nSolution Vector is : ");
		for(i=0 ; i<n ;i++)
			System.out.print("\t"+x[i]);
		for(i=0 ; i<n ;i++)
			p = p + (profit[i]*x[i]);
		System.out.println("\nMaximum profit : "+p);
	}
	
}

public class Lab6b {

	public static void main(String[] args) {
		int i,n,capacity,j;
		float profit[] = new float[100];
		float weight[] = new float[100];
		float ratio[] = new float[100];
		System.out.print("Enter the number of items : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("\nEnter the profit of each item ");
		for(i=0 ; i<n ; i++)
			profit[i] = in.nextInt();
		System.out.println("\nEnter the weight of each item ");
		for(i=0 ; i<n ; i++)
			weight[i] = in.nextInt();
		System.out.print("\nEnter the maximum capacity : ");
		capacity = in.nextInt();
		for(i=0 ; i<n ; i++)
			ratio[i] = profit[i]/weight[i];
		for(i=0 ; i<n ; i++)
			for(j=0 ; j<n ; j++)
				if(ratio[j] <= ratio[j+1])
				{
					float tempr = ratio[j+1];
					ratio[j+1] = ratio[j];
					ratio[j] = tempr;
					float tempp = profit[j+1];
					profit[j+1] = profit[j];
					profit[j] = tempp;
					float tempw = weight[j+1];
					weight[j+1] = weight[j];
					weight[j] = tempw;
				}
		System.out.println("\nItems after rearranging in decreasing order of their ratio (profit/weight) ");
		System.out.println("\nItem\tWeight\tProfit\tRatio");
		j=0;
		for(i=0 ; i<n ; i++)
			System.out.println(" x"+j+++"\t"+weight[i]+"\t"+profit[i]+"\t"+ratio[i]);
		KnapSack k = new KnapSack();
		k.greedyKnapsack(weight,profit,n,capacity);
	}

}
