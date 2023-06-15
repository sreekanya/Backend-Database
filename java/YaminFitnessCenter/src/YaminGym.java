import java.util.Scanner;

public class YaminGym {

	public static void main(String[] args) {
		
		System.out.println("Please Register the Participant details");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter First Name");
		String fName = scanner.nextLine();
		
		System.out.println("Enter Last Name");
		String lName = scanner.nextLine();
		
		System.out.println("Enter Email");
		String email = scanner.nextLine();
		
		System.out.println("Enter Phone");
		String phone = scanner.nextLine();
		
		System.out.println("Enter Batch Morning/Evening :");
		String batch = scanner.nextLine();
		
		scanner.close();
		
		Participants participant = new Participants(fName, lName,email,phone,batch);
		
		FitnessCenter fitnessCenter = new FitnessCenter();
		fitnessCenter.studentEnrollment(participant);
		
		Notification notification;
		
		if(!(batch.toUpperCase() == "MORNING"))
		{	
			notification = new MorningBatch();
			notification.batchNotification(participant);
			
		}
		else {

			notification = new EveningBatch();
			notification.batchNotification(participant);
		}
		
		

	}

}
