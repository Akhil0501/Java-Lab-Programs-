package javaProgram;

import java.util.Scanner;
import java.util.Random;

class First extends Thread
{
	int n,i,num;
	First(int n)
	{
		this.n=n;
	}
	Random r = new Random(n);
	public void run()
	{
		try {
			
			for(i=0;i<n;i++)
			{
				num=r.nextInt(50);		//range 0-49
				System.out.println("\nFIRST THREAD - Random number is : "+num);
				Thread.sleep(1000); 
				Thread thS = new Thread(new Second(num));
				thS.start();
				Thread.sleep(1000);
				Thread thT = new Thread(new Third(num));
				thT.start();
				Thread.sleep(2000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Execption Occured : "+e);
		}
	}
}

class Second extends Thread
{
	int n;
	Second(int n)
	{
		this.n=n;
	}
	public void run()
	{
		System.out.println("SECOND THREAD - Square of the number is : "+n*n);
	}
}

class Third extends Thread
{
	int n;
	Third(int n)
	{
		this.n=n;
	}
	public void run()
	{
		System.out.println("THIRD THREAD - Cube of the number is : "+n*n*n);
	}
}

public class Lab3b {

	public static void main(String[] args) {
		int n;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the total count of Random numbers : ");
		n = in.nextInt();
		First th = new First(n);
		th.start();
	}

}
