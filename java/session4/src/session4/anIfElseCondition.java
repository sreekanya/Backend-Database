package session4;

import java.util.Scanner;

public class anIfElseCondition {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter amount : ");
		double amount = scanner.nextDouble();
		
		System.out.println("Enter promocode : ");
		int promocode = scanner.nextInt();
		
		scanner.close();
		
		System.out.println("Amount = "+amount +"promocode = "+promocode);
		
		switch(promocode) {
		case 1001 :
				if(amount >= 1000) {
					System.out.println("BINGO Promocode applied.");
					double discount = 0.25*amount;
					System.out.println("Discount amount = "+discount);
					System.out.println("Final amount = "+(amount-discount));
				}
				else {
					System.out.println("Amount is less can't apply discount");
					System.out.println("Final amount = "+amount);
				}
				break;
		
		case 2002 :
				if(amount >= 3000) {
					System.out.println("JUMBO Promocode applied.");
					double discount = 0.35*amount;
					System.out.println("Discount amount = "+discount);
					System.out.println("Final amount = "+(amount-discount));
				}
				else {
					System.out.println("Amount is less can't apply discount");
					System.out.println("Final amount = "+amount);
				}
				break;
		default :
				System.out.println("Can't apply promocode");

	}

}
}
