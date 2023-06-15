abstract class Cab{
	Cab(){
		System.out.println("Cab object constructed");
	}
	abstract void bookCab(String source, String destination) ;
	/*{
		System.out.println("Cab booked from "+source+" to "+destination);
	}*/
}
class MiniCab extends Cab{
	public MiniCab() {
		System.out.println("MiniCab object is constructed");
	}
	void bookCab(String source, String destination) 
	{
		System.out.println("Cab booked from "+source+" to "+destination);
	}
}

abstract class Notification{
	abstract void notifyMessage(String message);
}

class YoutubeChannel{
	Notification notification;
	void subscribe(Notification nf) {
		notification = nf;
	}
	
}
class User extends Notification {
	@Override
	void notifyMessage(String message) {
		System.out.println("--------------------------");
		System.out.println("A New Notification.....!!");
		System.out.println("Message is :"+message);
		System.out.println("--------------------------");
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
		Cab cab;
//		cab = new Cab();
		
		cab = new MiniCab();
		cab.bookCab("Home", "Office");
		
		User john = new User();
		
		YoutubeChannel channel = new YoutubeChannel();
		channel.subscribe(john);

	}

}
