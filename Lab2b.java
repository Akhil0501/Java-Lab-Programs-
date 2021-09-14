package javaProgram;

import java.util.Scanner;
import java.util.StringTokenizer;

class Customer
{
	private String name,dob;
	public void read()
			{
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				System.out.print("Enter the customer's name : ");
				name = in.next();
				System.out.print("Enter the customer's date of birth as dd/mm/yyyy : ");
				dob = in.next();	
			}
	public void display()
			{
				StringTokenizer st = new StringTokenizer(dob,"/");
				System.out.print("Customer's Details in the format name,dd,mm,yyyy : ");
				System.out.print(name);
				while(st.hasMoreTokens())
				{
					System.out.print("," +st.nextToken() );
				}
			}
}

public class Lab2b {

	public static void main(String[] args) {
		
		Customer c = new Customer();
		c.read();
		c.display();

	}

}
