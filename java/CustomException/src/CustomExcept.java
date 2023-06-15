class InvalidPhonenumberException extends Exception{
	
	public InvalidPhonenumberException(String message) {
		System.out.println(message);
	}
}

class InvalidEmailException extends RuntimeException{
	
	public InvalidEmailException(String message) {
		System.out.println(message);
	}
}
public class CustomExcept {

	public static void main(String[] args) throws InvalidPhonenumberException {
		String phone = "";
		String email = "john@example.com";
		
		if(phone.isEmpty()) {
			InvalidPhonenumberException e = new InvalidPhonenumberException("Phone number can not be empty");
			throw e;
		}

	}

}
