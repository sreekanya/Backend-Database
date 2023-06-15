class CA{
	void show() {
		System.out.println("this is from parent class CA");
	}
	
}
class CB extends CA{
	void show() {
		System.out.println("this is from child class CB");
	}
	void hello() {
		System.out.println("Saying Hello from child class CB");
	}
	
}

public class PolymorphicStatement {

	public static void main(String[] args) {
		CA refca = new CB();
		refca.show();
		
		CB refcb = (CB)refca;
		refcb.show();
		refcb.hello();
	}

}
