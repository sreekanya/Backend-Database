//interface PaytmPaymentGateway{
//	
//}
//
//interface RazonPay{
//	
//}
//
//interface Paypal{
//	
//}
//
//class MyPaymentPage implements PaytmPaymentGateway,RazonPay, Paypal{
//	
//	
//}

interface Notification{
	void notifyMessage(String message);
}

interface ElectricityBillPayment{
	int bullAccNumber = 12345;
	
	void billGenerated();
	void payBillNotification();
}
class User implements Notification,ElectricityBillPayment{
	String name;
	String accnumber;
	int amount;
	public User() {
		System.out.println("[User] object is created");
	}
	
	public User(String name, String accnumber, int amount) {
		this.name = name;
		this.accnumber = accnumber;
		this.amount = amount;
		System.out.println("[User] name = "+this.name);
	}
	@Override
	public void notifyMessage(String message) {
		System.out.println("A new notification message ......."+message);
		
	}
	@Override
	public void billGenerated() {
		System.out.println("[user] Electricity Bill Generated . Please Pay intime");
		
	}
	@Override
	public void payBillNotification() {
		System.out.println("[User] Thank you for paying the bill");
		
	}
}
class ElectricityApp{
	ElectricityBillPayment payment;
	
	void subscribeForBill(ElectricityBillPayment payment) {
		this.payment = payment;
		System.out.println("[ElectricityApp] "+payment.getClass());
	}
	void broadcastBills() {
		payment.billGenerated();
		payment.payBillNotification();
	}
}
public class InterfaceDemo {

	public static void main(String[] args) {
		Notification ref1 = new User();
		ElectricityBillPayment ref2 = new User();
		
		System.out.println("Bill Account number "+ElectricityBillPayment.bullAccNumber);
		
		ElectricityApp electricityapp = new ElectricityApp();
		User john = new User("john", "ac123", 234);
		
		electricityapp.subscribeForBill(john);
		electricityapp.broadcastBills();

	}

}
