class Cab{
	int baseFare = 0;
	Cab(){
		baseFare = 20;
		System.out.println("Cab object constructed");
	}
	void bookCab(String from, String to) {
		System.out.println("Cab booked from "+from +" to "+to +"location. Please pay $"+baseFare);
	}
	
}

class MiniCab extends Cab{
	boolean isStreamingAvailable;
	public MiniCab() {
		baseFare +=10;
		isStreamingAvailable = true;
		System.out.println("Mini Cab object constructed");
	}
	void bookCab(String from, String to) {
		System.out.println("Cab booked from "+from +" to "+to +" location. Please pay $"+baseFare);
		System.out.println("On the way you can use the TAB placed next");
	}
	
}
class SharedCab extends Cab{
	int numOfPeople;
	public SharedCab() {
		baseFare -=10;
		numOfPeople = 4;
		System.out.println("Shared Cab object constructed");
	}
	void bookCab(String from, String to) {
		System.out.println("Cab booked from "+from +" to "+to +"location. Please pay $"+baseFare);
		System.out.println("On this way you will shre the cab with "+(numOfPeople-1) +"number of people");
	}
	
}
class LuxuryCab extends Cab{
	int softDrinks;
	int chips;
	public LuxuryCab() {
		System.out.println("Luxury Cab object constructed");
		softDrinks = 3;
		chips = 2;
		baseFare +=20;
	}
	void bookCab(String from, String to) {
		System.out.println("Cab booked from "+from +" to "+to +"location. Please pay $"+baseFare);
		System.out.println("On the way you can enjoy having chips and softdrinks");
	}
	
}

class CabBookingApp{
	static Cab book(int type){
		
	Cab cab = null;
	
	if(type == 1) {
		cab = new MiniCab();
	}else if(type == 2) {
		cab = new SharedCab();
	}else if(type == 3) {
		cab = new LuxuryCab();
	}else {
		System.out.println("Invalid Cab Selection");
	}

	return cab;
	}
}
public class RunTimePoly {

	public static void main(String[] args) {
//		Cab cab = new Cab();
//		Cab cab;
//		cab = new MiniCab();
//		cab.bookCab("Home", "Office");
		
		Cab cab =CabBookingApp.book(2);
		cab.bookCab("Home", "Office");
		
	}

}
