class Parent{
	String fname;
	String lname;
	int wealth;
	
	Parent() {
		fname = "John";
		lname = "Marry";
		wealth = 100000;
		System.out.println("[Parent] -- object constructed with default parameters");
	}
	void showDetails() {
		System.out.println("[Parent] Name is : "+fname +lname+" wealth :"+wealth);
	}
	
}

class Child extends Parent {
	String fname;
	int wealth;
	String companyName;
	Child(){
		fname = "Fiona";
		wealth = 500000;
		companyName = "ABCVentures";
		System.out.println("[Child] -- object constructed with default constructor.");
	}
	void showDetails() {
		super.showDetails();
		System.out.println("[Child] Name is : "+fname +lname+" Company name :"+ companyName +" wealth :"+wealth);
	}
	
}

public class WhatIsInheritance {

	public static void main(String[] args) {
//		Parent parent = new Parent();
//		parent.showDetails();

		Child child = new Child();
		child.wealth = 5000;
		child.showDetails();
	}

}
