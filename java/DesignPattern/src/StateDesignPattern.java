interface State{
	String getStateName();
	
}
class Placed implements State{

	@Override
	public String getStateName() {
		return "PLACED";
	}
	
}
class Shipped implements State{

	@Override
	public String getStateName() {
		return "SHIPPED";
	}
	
}
class Delivered implements State{

	@Override
	public String getStateName() {
		return "DELIVERED";
	}
	
}

class Order{
	
	State state;
	
	Order(){
		state = new Placed();
	}
	
	State getState() {
		return state;
	}
	
	void updateState(State newState) {
		state = newState;
	}
}

public class StateDesignPattern {

	public static void main(String[] args) {
		Order order = new Order();
		System.out.println("State of order as of now is ....."+order.getState().getStateName());

	}

}
