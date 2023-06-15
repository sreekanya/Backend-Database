
public class Participants extends FitnessCenter  {
	String studentFName;
	String studentLName;
	String studentEmail;
	String studentPhone;
	String batchTime;
	
	public Participants() {
		
	}
	
	public Participants(String studentFName, String studentLName, String studentEmail, String studentPhone,String batchTime) {
		
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.batchTime = batchTime;
		
	}

	@Override
	public String toString() {
		return "Participants [studentFName=" + studentFName + ", studentLName=" + studentLName + ", studentEmail="
				+ studentEmail + ", studentPhone=" + studentPhone + ", batchTime=" + batchTime + "]";
	}

	public String getStudentFName() {
		return studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public String getBatchTime() {
		return batchTime;
	}

	

	
	

	
}