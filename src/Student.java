package library;

import java.util.Scanner;

public class Student {
	Scanner input = new Scanner(System.in);
	
	String studentName, address;
	String regNum;
	String contact;
	
	Book borrowedBooks[] = new Book[3];
	public int booksCount=0;
	
	public Student() {
		System.out.println("Enter student Name");
		this.studentName = input.nextLine();
		
		System.out.println("Enter reg Number");
		this.regNum=input.nextLine();
		
		System.out.println("Enter Contact");
		this.contact=input.nextLine();
		
		System.out.println("Enter Address ");
		this.address = input.nextLine();
	}

}
