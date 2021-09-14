package javaProgram;

import java.util.Scanner;

class Student{
	private String USN;
	private String Name;
	private String Branch;
	private long Phone;
	public Student(String USN, String Name, String b, long ph) {
		this.USN = USN;
		this.Name = Name;
		Branch = b;
		Phone = ph;		
	}
	void display(int i) {
		System.out.println(i+"\t"+USN+"\t"+Name+"\t"+Branch+"\t"+Phone);
	}
	
}

public class lab1a {

	public static void main(String[] args) {
		int n,i;
		String USN,Name,Br;
		long Phone;
		System.out.print("Enter the total number of Students : ");
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
		Student[] s = new Student[n];
		for(i = 0; i < n; i++) {
			System.out.println("Enter the "+(i+1)+" student details");
			System.out.print("USN : ");
			USN = in.next();
			System.out.print("Name : ");
			Name = in.next();
			System.out.print("Branch : ");
			Br = in.next();
			System.out.print("Phone : ");
			Phone = in.nextLong();
			System.out.print("\n");
			s[i] = new Student(USN,Name,Br,Phone);
		   }
		System.out.println("THE "+n+" STUDENT DETAILS");
		System.out.println("SI.No. \tUSN \t\tName \tBranch \tPhone No.");
		for(i = 0; i < n; i++) {
			s[i].display(i+1);
		}
	  }
		
	}

}
