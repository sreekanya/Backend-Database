package session3;

import java.util.Scanner;

public class RelationalOperations {

	public static void main(String[] args) {
		int a=10;
		char b=20;
		boolean result = a>b;
		System.out.println("compare a and b :"+ (a<b));
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter value :");
		int read = scanner.nextInt();		
		System.out.println("new value :"+read);
		scanner.close();

	}

}
