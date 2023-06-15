package session3;

public class ArithmaticOperations {

	public static void main(String[] args) {
		int valA = 23;
		int valB = 50;
		int add = valA + valB;
		System.out.println("Addition : "+add);
		int a = valA++;
		System.out.println("value of a : "+a);
		System.out.println("value of valA : "+valA);
		int b = --valB;
		System.out.println("value of b : "+b);
		System.out.println("value of valB : "+valB);
		valA +=10;
		System.out.println("value of valA : "+valA);
	}

}
