package javaProgram;

import java.util.Scanner;

class Staff
{
	protected int StaffId, Salary;
	protected String Name;
	protected long Phone;
	Scanner in = new Scanner(System.in);
	Staff()
	{
		System.out.print("Enter the ID : ");
		StaffId = in.nextInt();
		System.out.print("Enter the Name : ");
		Name = in.next();
		System.out.print("Enter the Phone : ");
		Phone = in.nextLong();
		System.out.print("Enter the Salary : ");
		Salary = in.nextInt();
	}
	void display()
	{
		System.out.print(StaffId+"\t"+Name+"\t"+Phone+"\t"+Salary);
	}
}

class Teaching extends Staff
{
	private String domain, publications;
	Teaching()
	{
		super();
		System.out.print("Enter the Domain : ");
		domain = super.in.next();
		System.out.print("Enter the Publications : ");
		publications = super.in.next();
	}
	void displayTeaching()
	{
		super.display();
		System.out.print("\t"+domain+"\t"+publications+"\n");
	}
}

class Technical extends Staff
{
	private String skills;
	Technical()
	{
		System.out.print("Enter the Skills : ");
		skills = in.next();
	}
	void displayTechnical()
	{
		super.display();
		System.out.print("\t"+skills+"\n");
	}
}

class Contract extends Staff
{
	private String period;
	Contract()
	{
		System.out.print("Enter the Period : ");
		period = in.next();
	}
	void displayContract()
	{
		super.display();
		System.out.print("\t"+period+"\n");
	}
}

public class Lab2a {

	public static void main(String[] args) {
		int i,n;
		System.out.print("Enter the number of Staffs(minimum 3 each) : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		Teaching T[] = new Teaching[n];
		Technical TE[] = new Technical[n];
		Contract C[] = new Contract[n];
		System.out.println("Enter the "+n+" Teaching Staff Details");
		for(i=0; i<n; i++)
		{
			System.out.println("\nEnter the "+(i+1)+" Teaching Staff Details");
			T[i] = new Teaching();
		}
		System.out.println("\nEnter the "+n+" Technical Staff Details");
		for(i=0; i<n; i++)
		{
			System.out.println("\nEnter the "+(i+1)+" Technical Staff Details");
			TE[i] = new Technical();
		}
		System.out.println("\nEnter the "+n+" Contract Staff Details");
		for(i=0; i<n; i++)
		{
			System.out.println("\nEnter the "+(i+1)+" Contract Staff Details");
			C[i] = new Contract();
		}
		System.out.println("\n\t*****Teaching Staff Details*****");
		System.out.println("StaffID\tName\tPhone\t\tSalary\tDomain\tPublications");
		for(i=0; i<n; i++)
		{
			T[i].displayTeaching();
		}
		System.out.println("\n\t*****Teachnical Staff Details*****");
		System.out.println("StaffID\tName\tPhone\t\tSalary\tSkills");
		for(i=0; i<n; i++)
		{
			TE[i].displayTechnical();
		}
		System.out.println("\n\t*****Contract Staff Details*****");
		System.out.println("StaffID\tName\t\tPhone\tSalary\tPeriod");
		for(i=0; i<n; i++)
		{
			C[i].displayContract();
		}
		
	}

}
