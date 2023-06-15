
abstract class Notification {
	
	abstract void batchNotification(Participants participant); 

}

class MorningBatch extends Notification {
	Participants participant;
	
	void batchNotification(Participants prf) {
		this.participant = prf;
		System.out.println(prf.getStudentFName()+ prf.getStudentLName()+" enrolled for the Morning sessions ");
		System.out.println("Email notification will be sent to your email "+prf.getStudentEmail());
	}
	
}

class EveningBatch extends Notification {
	Participants participant;
	void batchNotification(Participants prf) {
		this.participant = prf;
		System.out.println(prf.getStudentFName()+prf.getStudentLName()+" enrolled for the Evening sessions ");
		System.out.println("Email notification will be sent to your email "+prf.getStudentEmail());
	}
	
}
