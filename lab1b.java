package javaProgram;

import java.util.Scanner;

class Stack{
	private final int size=5;
	private int[] a = new int[size];
	private int top = -1;
	
	int checktop()
	{
		if(top == size-1)
			return 0;
		else return 1;
	}
	
	void push(int item)
	{
			a[++top] = item;
	}
	
	void pop() 
	{
		if(top == -1)
			System.out.println("Stack Underflow");
		else {
			System.out.println("Popped item is : "+a[top--]);
		}
	}
	
	void display()
	{
		if(top == -1)
			System.out.println("Stack is EMPTY");
		else {
			for(int i = top; i >= 0; i-- )
				System.out.print(a[i]+"\t");
		}
			
	}
}


public class lab1b {

	public static void main(String[] args) {
		Stack s = new Stack();
		int check,choice,item,a = 1;
		while(a == 1)
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("\n1.PUSH an item to the Stack\n2.POP an item from the Stack\n3.Display Stack items\n4.Exit");
			System.out.print("Enter Your Choice : ");
			choice = in.nextInt();
			switch(choice)
			{
			 case 1 : check = s.checktop();
				      if(check == 0)
				        	System.out.println("Stack Overflow");
				      else {
				    	    System.out.print("Enter an item to be inserted : ");
				    	    item = in.nextInt();
				    	    s.push(item);
				      }
				      break;
			 case 2 : s.pop();
			 		  break;
			 case 3 : s.display();
			 		  break;
			 case 4 : a = 0;
			 		  break;
			 default : System.out.println("Invalid Choice");
			}
		  
		}

	}

}
