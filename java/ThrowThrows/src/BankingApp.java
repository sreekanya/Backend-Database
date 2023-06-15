class BankAccount{
	int balance;
	int minBalance;
	int attempts = 0;
	
	public BankAccount() {
		balance = 10000;
		minBalance = 2000;
	}
	
	void withdraw(int amount) throws BankingException{

		balance -= amount;
		
		if(balance<minBalance) {
			balance +=amount;
			System.out.println("Withdraw Failed.Please Deposit money and Balance is ..."+balance);
			attempts++;
		}
		else {
			System.out.println("After withdrawing the "+amount +"Balance is ..."+balance);
		}
		
		if(attempts == 3) {
			BankingException exception = new BankingException("Illegal attempts .... "+attempts);
			throw exception;
			
		}
	}
}
class BankingException extends Exception{
	public BankingException(String message) {
		super(message);
	}
}

public class BankingApp {

	public static void main(String[] args) {
		System.out.println("Banking App Starting.....");
		
		BankAccount johnAccount = new BankAccount();
		try {	
			for(int i=0;i<10;i++) {
				johnAccount.withdraw(3000);
			}
		} catch (BankingException e) {
			System.out.println("Exception is .... "+e);
		}
	
		
		System.out.println("Banking App Ended");

	}

}
