import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		System.out.println("Cash back app started");
		
		int cashback[] = {10,25,35,40,50};
		int luckynum = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your lucky number");
		try {
			luckynum = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Exception"+e);
		}
		
		
		scanner.close();
		int cashbackEarned = 0;
		
		
		try {
			cashbackEarned = cashback[luckynum];
		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("Something went wrong");
//			System.out.println("Exception occured "+e);
//			System.out.println("Message "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("This is important");
		}
		
		System.out.println("Thank you for your participation. You earned a Cash back of $"+cashbackEarned);
		System.out.println("Cash back app finished");

	}

}
