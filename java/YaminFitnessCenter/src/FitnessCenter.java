
public class FitnessCenter {
	Participants participant;
	
	void studentEnrollment(Participants participant) {
		this.participant = participant;
		//String msg = participant.toString();
		String msg = participant.getStudentFName() + participant.getStudentLName();
		System.out.println(msg +" Successfully enrolled in Yamin Gym");
	}
	
}
