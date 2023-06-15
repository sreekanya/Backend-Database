class PaymentGateWay{
	final void pay(int amount) {
		System.out.println("Payment Gateway Transaction Successful");
	}
}

class MyPayment extends PaymentGateWay{
//	void pay(int amount) {
//		System.out.println("Payment Gateway Transaction is Finished");
//	}
}

public class FinalKeyword {

	public static void main(String[] args) {
		int age=20;
		age = 50;
		
		final int score = 98;
//		score = 78;
		final int distance;
		distance = 11;
	}

}
