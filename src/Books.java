package library;
import java.util.Scanner;
public class Books {
	Scanner input = new Scanner(System.in);
	
	Book[] theBooks =new Book[50];
	
	public static int count;
	public int compareBookObjects(Book b1, Book b2) {
		if(b1.bookName.equalsIgnoreCase(b2.bookName)) {
			System.out.println("Book of this Name already Exists");
			return 0;
		}
		if(b1.sNo==b2.sNo) {
			System.out.println("Book of the Serial No Already Exists");
			return 0;
		}
		return 1;
	}
public void addBook(Book b) {
	for(int i=0; i<count;i++) {
		if(this.compareBookObjects(b, this.theBooks[i])==0)
			return;
	}
	if (count<50) {
		theBooks[count]=b;
		count++;
	}
	else {
		System.out.println("No space to Add More Books");
		
	}
}
	public void searchBySno() {
		System.out.println("Search by Serial Number");
		
		int sNo;
		System.out.println("Enter serial No of Book ");
		sNo =input.nextInt();
		int flag =0;
		 System.out.println("S.no name Author Available QtyinTotal Qty");
		 for(int i =0; i<count;i++) {
			 if(sNo == theBooks[i].sNo) {
				 System.out.println(theBooks[i].sNo+"\t"+theBooks[i].bookName+"\t"+theBooks[i].authorName+"\t"+theBooks[i].bookQtyCopy+"\t"+theBooks[i].bookQty);
				 flag++;
				 return;
			 }
		 }
		 if(flag==0)
			 System.out.println("No book for Serial Number "+sNo+" Found");
	
		}
	public void serchByAuthorName() {
		System.out.println("Search By Authors Name");
		input.nextLine();
		System.out.println("Enter Author Name");
		String authorName = input.nextLine();
		int flag = 0;
		System.out.println("S.No\t\t\t Author \t\t\t Available Qty \t\t\t Total Qty");
		for(int i=0;i<count;i++) {
			if(authorName.equalsIgnoreCase(theBooks[i].authorName)) {
				System.out.println(theBooks[i].sNo+"\t\t"+theBooks[i].bookName+"\t\t\t"+theBooks[i].authorName+"\t\t\t"+theBooks[i].bookQtyCopy+"\t\t"+theBooks[i].bookQty);
				flag++;
			}
		}
		if(flag==0)
			System.out.println("No books of "+authorName+" Found");
		
		
	}
	public void showAllBooks() {
		System.out.println("Show All Books");
		System.out.println("S No \t\t Name \t\t\t\t\t Author \t\t\t Available Qty \t\t\t Total Qty");
		for(int i=0;i<count;i++) {
			System.out.println(theBooks[i].sNo+ "\t\t\t"+theBooks[i].bookName +"\t\t\t\t\t" +theBooks[i].authorName+"\t\t\t"+theBooks[i].bookQtyCopy+"\t\t\t"+theBooks[i].bookQty);
			
		}
	}
	
	public void upgradeBookQty() {
		System.out.println("Upgrade Quantity of Book\n");
		System.out.println("Enter serial No of Book");
		int sNo = input.nextInt();
		for(int i=0;i<count;i++) {
			if(sNo==theBooks[i].sNo) {
			System.out.println("Enter No of Books To be Added");
			int addingQty=input.nextInt();
			theBooks[i].bookQty+=addingQty;
			theBooks[i].bookQtyCopy+= addingQty;
			return;
			}
			
		}
	}
	public void dispMenu() {
		System.out.println("---------------------");
		System.out.println("Enter 0 to Exit Application");
		System.out.println("Enter 1 to Add new Book");
		System.out.println("Enter 2 to Update Quantity of a Book");
		System.out.println("Enter 3 to Search a Book");
		System.out.println("Enter 4 to Show All Books");
		System.out.println("Enter 5 to Register Student");
		System.out.println("Enter 6 to Show All Registered Students");
		System.out.println("Enter 7 to Check Out Book");
		System.out.println("Enter 8 to Check in Book");
		System.out.println("---------------------");
		System.out.print("Enter your choice: ");

	}
	public int isAvailable(int sNo) {
		for(int i=0;i<count;i++) {
			if(sNo == theBooks[i].sNo) {
				if(theBooks[i].bookQtyCopy>0) {
					System.out.println("Book is Available");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number "+"Available in library");
		return -1;
	}
	
	public Book checkOutBook() {
		System.out.println("Enter serial No of Book to be Check Out ");
		int sNo = input.nextInt();
		int bookindex = isAvailable(sNo);
		if(bookindex != -1) {
			theBooks[bookindex].bookQtyCopy--;
			return theBooks[bookindex];
		}
		return null;
	}
	public void checkinBook(Book b) {
		for(int i=0; i<count;i++) {
			if(b.equals(theBooks[i])) {
				theBooks[i].bookQtyCopy++;
				return;
			}
		}
	}
}
