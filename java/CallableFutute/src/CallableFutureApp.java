import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MovieTicket{
	
	String movieName;
	String seatNumber;
	boolean isTicketBooked;
	String emailUser;
	static int ticketNumber = 1;
	
	public MovieTicket() {

	}

	public MovieTicket(String movieName, String seatNumber, boolean isTicketBooked, String emailUser) {
		super();
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.isTicketBooked = isTicketBooked;
		this.emailUser = emailUser;
	}

	@Override
	public String toString() {
		return "MovieTicket [movieName=" + movieName + ", seatNumber=" + seatNumber + ", isTicketBooked="
				+ isTicketBooked + ", emailUser=" + emailUser + "]";
	}
	
	
}
class MovieTicketBookingTask implements Callable<String>{
	
	MovieTicket ticket;
	
	public MovieTicketBookingTask(MovieTicket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Paying for the Ticket seat "+ticket.seatNumber+" for user "+ticket.emailUser);
		Thread.sleep(3000);
		ticket.seatNumber = "A"+MovieTicket.ticketNumber++;
		
		ticket.isTicketBooked = true;
		System.out.println("Ticket Booked for  "+ticket.emailUser);
		System.out.println();
		return "Ticket Booked for "+ticket.emailUser+" with seat number "+ticket.seatNumber;
	}
	
}

public class CallableFutureApp {

	public static void main(String[] args) {
		System.out.println("Movie Ticket Booking App Started");
		
		MovieTicket ticket1 = new MovieTicket("Avengers", "", false, "john@example.com");
		MovieTicket ticket2 = new MovieTicket("Avengers", "", false, "jim@example.com");
		MovieTicket ticket3 = new MovieTicket("Avengers", "", false, "jake@example.com");
		MovieTicket ticket4 = new MovieTicket("Avengers", "", false, "james@example.com");
		MovieTicket ticket5 = new MovieTicket("Avengers", "", false, "johnny@example.com");
		
		System.out.println("MovieTicket1 : "+ticket1);
		System.out.println("MovieTicket2 : "+ticket2);
		System.out.println("MovieTicket3 : "+ticket3);
		System.out.println("MovieTicket4 : "+ticket4);
		System.out.println("MovieTicket5 : "+ticket5);
		System.out.println("Processor "+Runtime.getRuntime().availableProcessors());
		
		Callable task1 = new MovieTicketBookingTask(ticket1);
		Callable task2 = new MovieTicketBookingTask(ticket2);
		Callable task3 = new MovieTicketBookingTask(ticket3);
		Callable task4 = new MovieTicketBookingTask(ticket4);
		Callable task5 = new MovieTicketBookingTask(ticket5);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<String> future1 = service.submit(task1);
		Future<String> future2 = service.submit(task2);
		Future<String> future3 = service.submit(task3);
		Future<String> future4 = service.submit(task4);
		Future<String> future5 = service.submit(task5);
		
		try {
			System.out.println("Task1 Result "+future1.get());
			System.out.println("Task2 Result "+future2.get());
			System.out.println("Task3 Result "+future3.get());
			System.out.println("Task4 Result "+future4.get());
			System.out.println("Task5 Result "+future5.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Movie Ticket Booking App Finished");
	}

}
