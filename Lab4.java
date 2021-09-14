package javaProgram;

import java.util.Scanner;
import java.util.Random;

class QuickSort
{
	public void qsort(int a[], int low, int high)
	{
		if(low < high)
		{
			int j = partition(a, low, high + 1 );
			qsort(a,low,j - 1);
			qsort(a,j + 1 ,high);
		}
	}
	public int partition(int a[], int l, int h)
	{
		int pivot = a[l], i = l, j = h;
		do {
			do {
				i++;
			}while(a[i] < pivot );
			do {
				j--;
			}while(a[j] > pivot);
			if(i < j)
				interchange(a, i, j);
		}while(i <= j);
		interchange(a, l, j);
		return j;
	}
	public void interchange(int a[], int i, int j)
	{
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

public class Lab4 {

	public static void main(String[] args) {
		int n, i;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of an Array : ");
		n = in.nextInt();
		int l = 0, h = n - 1;
		long start, end;
		int a[] = new int[n+1];
		Random r = new Random();
		for(i = 0; i<n; i++)
			a[i] = r.nextInt(1000);
		a[i] = 9999;		
		QuickSort q = new QuickSort();
		System.out.println("\nBefore Sorting : ");
		for(i = 0; i<n; i++)
			System.out.print(a[i] + "\t ");
		start = System.nanoTime();
		q.qsort(a, l, h);
		end = System.nanoTime();
		System.out.println("\n\nAfter Sorting : ");
		for(i = 0; i<n; i++)
			System.out.print(a[i] + "\t ");
		System.out.print("\n\nThe Time taken by the Quick Sort to sort " + n +" numbers is "+ (end-start) + "ns");
	}

}
