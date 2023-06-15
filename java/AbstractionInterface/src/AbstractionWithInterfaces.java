
//abstract class GooglePay{
interface GooglePay{
	default void payFromGoogle(int amount) {
		System.out.println("[GooglePay] Amount Paid : "+amount);
	}
	abstract void onSuccess(int code, String message);
	abstract void onFailure(int code, String message);
	
}

//abstract class ApplePay{
interface ApplePay{
	default void payFromApple(int amount) {
		System.out.println("[ApplePay] Amount Paid : "+amount);
	}
	abstract void onSuccess(String message);
	abstract void onFailure(String message);
	
}

interface Payments extends GooglePay, ApplePay{
	
}
class FoodDeliveryApp implements Payments      //GooglePay, ApplePay{
{
	@Override
	public void onSuccess(int code, String message) {
		System.out.println("[FDA] Payment Received. We will deliver the order soon.."+code+" "+message);
		
	}

	@Override
	public void onFailure(int code, String message) {
		System.out.println("[FDA] Something went Wrong... Please order later.."+code+" "+message);
		
	}

	@Override
	public void onSuccess(String message) {
		System.out.println("[FDA] Payments successful"+message);
		
	}

	@Override
	public void onFailure(String message) {
		System.out.println("[FDA] Payments failed"+message);
		
	}
	
}

public class AbstractionWithInterfaces {

	public static void main(String[] args) {
//		GooglePay ref = new FoodDeliveryApp();
//		ref.payFromGoogle(3000);
		
		Payments ref = new FoodDeliveryApp();
		ref.payFromApple(3000);
		ref.payFromGoogle(5000);
	}

}
