abstract class PaytmPaymetGateway{
	public PaytmPaymetGateway() {
		System.out.println("[Paytm] PaytmPaymentGateway object constructed");
	}
	
	private boolean isBankInterfaceUp = true;
	
	void pay(int amount) {
		if(isBankInterfaceUp) {
			System.out.println("[Paytm] payment successfullt done for Amount "+ amount);
			onSuccess("[Paytm] 101 - Payment Success");
		}
		else {
			System.out.println("[Paytm] payment failed ..... Please try again later");
			onFailure("[Paytm] 401 - Payment Failure");
		}
	}
	
	abstract void onSuccess(String message);
	abstract void onFailure(String message);
	
}
class EstorePayments extends PaytmPaymetGateway{
	public EstorePayments() {
		System.out.println("[Estore] EstorePayments object constructed");
	}
	void onSuccess(String message) {
		System.out.println(message);
		System.out.println("[Estore] Thank you for shopping with us....\n Item will be dispatched soon :)");
	}
	void onFailure(String message) {
		System.out.println(message);
		System.out.println("[Estore] Something went wrong......\n Please try again later :)");
	}
	
}

public class PaymentApp {

	public static void main(String[] args) {
		EstorePayments estorepayments = new EstorePayments();
		estorepayments.pay(5000);

	}

}
