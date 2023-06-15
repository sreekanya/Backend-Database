package session11;

public class StringMethods {

	public static void main(String[] args) {
		String names = "James Smith Joe Tommy";
		System.out.println("length of the name :"+names.length());
		System.out.println("char at index 6 :"+names.charAt(6));
		System.out.println("Index of J  :"+names.indexOf('J'));
		System.out.println("Index of J  :"+names.lastIndexOf('J'));
		System.out.println("Index of Smith  :"+names.lastIndexOf("Smith"));
		System.out.println("Uppercase of names :"+names.toUpperCase());
		System.out.println("lowerCase of names :"+names.toLowerCase());
		String replaced = names.replace('J', 'K');
		System.out.println("Replaced names :"+replaced);
	}

}
