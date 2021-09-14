package javaProgram;

import java.util.Scanner;
import java.util.Random;

class Merge
{
	void mergeSort(int a[],int low,int high)
	{
		if(low < high)
		{
			int mid = (low+high)/2;
			mergeSort(a, low, mid);
			mergeSort(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}
	void merge(int a[],int low,int mid,int high)
	{
		int b[] = new int[50000];
		int g,i,k,j=mid+1 ;  //j is a index to first element in a[mid+1:high]
		i=g=low;		   //g is a index to first element in a[low:mid]
		while(g<=mid && j<=high)
		{
			if(a[g]<a[j])
			{
				b[i]=a[g];
				g=g+1;		
			}
			else
			{
				b[i]=a[j];
				j=j+1;		
			}
			i=i+1;			
		}
		if(g>mid)
		{
			for(k=j ; k<=high ;k++)
			{
				b[i]=a[k];
				i++;
			}
		}
		else
		{
			for(k=g ; k<=mid ;k++)
			{
				b[i]=a[k];
				i++;
			}
		}
		for(k=low ; k<=high ; k++)
			a[k]=b[k];
	}
}

public class Lab5 {

	public static void main(String[] args) 
	{
		int n,i;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter array size : ");
		n = in.nextInt();
		int a[] = new int[n];
		Random r = new Random();
		for(i=0 ; i<n ; i++)
			a[i] = r.nextInt(1000); //0-999
		int l=0, h=n-1;
		Merge m = new Merge();
		System.out.print("\nArray before sorting : ");
		for(i=0 ; i<n ; i++)
			System.out.print(a[i]+"\t");
		long start = System.nanoTime();
		m.mergeSort(a, l, h);
		long end = System.nanoTime();
		System.out.print("\n\nArray after sorting  : ");
		for(i=0 ; i<n ; i++)
			System.out.print(a[i]+"\t");
		System.out.print("\n\nThe Time taken by the Merge Sort to sort " + n +" numbers is "+ (end-start) + "ns");
	}

}
