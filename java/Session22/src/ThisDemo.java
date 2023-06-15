class User{
	static int objectSrlNumber = 0;
	
	String name;
	String email;
	String phone;
	
	User() {
		objectSrlNumber++;
		name = "";
		email = "";
		phone = "";
		System.out.println("User object constructed with serialnumber :"+objectSrlNumber);
	}
}

public class ThisDemo {

	public static void main(String[] args) {
		User userr1 = new User();
		User userr2 = new User();
		

	}

}
