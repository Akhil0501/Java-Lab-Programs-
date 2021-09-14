package javaProgram;

import java.util.Scanner;

public class Lab3a {

	public static void main(String[] args) {
	
		int a,b,result,error;
		do {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter numerator : ");
		a = in.nextInt();
		System.out.print("Enter denominator : ");
		b = in.nextInt();
			try {
		
			result = a/b;
			System.out.print("Result : "+result);
			error = 0;
		}
		catch(ArithmeticException e) {
			error = 1;
			System.out.println("DENOMINATOR CANNOT BE ZERO (divide by 0 exception) | "+e);
			System.out.println("\nPlease Enter a valid DENOMINATOR");
		}
	  }while(error != 0);
	}

}
