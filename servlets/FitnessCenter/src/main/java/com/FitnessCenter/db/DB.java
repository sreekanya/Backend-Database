package com.FitnessCenter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FitnessCenter.model.Batch;
import com.FitnessCenter.model.Participants;

public class DB implements DAO{
	public Connection connection;
	Statement statement;
	public PreparedStatement preparedStatement;
	
	final String TAG = getClass().getPackageName();
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(TAG+" Driver Loaded");
		} catch (Exception e) {
			System.out.println("Exception occured "+e);
		}
		
		
	}

	@Override
	public void createConnection() {
		try {
			String uname = "sreekanya";
			String password = "Ax23*dVgNOws";
			String url = "jdbc:mysql://localhost/YaminGym";
			
			connection = DriverManager.getConnection(url,uname,password);
			System.out.println(TAG+" Connected to the database YaminGym");
			
		} catch (Exception e) {
			System.out.println("Connection error");
			System.out.println("Exception Occured "+e);
		}
		
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
			System.out.println(TAG+" disconnected from the database YaminGym");
		} catch (Exception e) {
			System.out.println("not able to disconnect ");
			System.out.println("Exception Occured "+e);
		}
		
	}

	@Override
	public int createBatch(Batch batch) {
		int val=0;
		try {
			
			//SimpleDateFormat timePattern = new SimpleDateFormat("hh-mm-ss");
			//LocalTime lt = LocalTime.parse("8:00");
		
			String sql = "insert into Batch values(null, ?,?,?)";
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setTime(1, batch.getTimeSlot());
			preparedStatement.setInt(2, batch.getTotalslots());
			preparedStatement.setInt(3, batch.getAvailslots());
			
			val = preparedStatement.executeUpdate();
			String msg = (val>0) ? "Inseted a new Batch details successfully " : "Not able to insert";
			System.out.println(TAG+msg);
			
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
		}
		return val;
	}

	@Override
	public int updateBatch(Batch batch) {
		System.out.println("Inside updateBatch");
		int val=0;
		try {
			
			String sql = "update Batch set totalslots= ?,availslots= ? where batchid =? && timeslot =?";
			
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, batch.getTotalslots());
			preparedStatement.setInt(2, batch.getAvailslots());
			
			preparedStatement.setInt(3, batch.getBatchId());
			preparedStatement.setTime(4, batch.getTimeSlot());

			val = preparedStatement.executeUpdate();
			
			String msg = (val>0) ? "Updated Batch record successfully " : "Not able to update Batch details";
			System.out.println(TAG+msg);
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		
		return val;
	}

	@Override
	public int deleteBatch(int batchId) {
		int val=0;
		try {
			String sql = "delete from Batch where batchId="+batchId;
			preparedStatement = connection.prepareStatement(sql);
			
			val = preparedStatement.executeUpdate(sql);
			String msg = (val>0) ? "Deleted Batch record successfully " : "Not able to delete Batch details";
			System.out.println(TAG+msg);
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		return val;
	}

	@Override
	public ArrayList<Batch> getAllBatches() {
		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			String sql = "select * from Batch";
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery(sql);
			
			while(set.next()) {
				Batch batch = new Batch();
				
				batch.setBatchId(set.getInt(1));
				batch.setTimeSlot((set.getTime(2)));
				batch.setTotalslots(set.getInt(3));
				batch.setAvailslots(set.getInt(4));
				
				batches.add(batch);
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
		return batches;
		
	}
	
	@Override
	public Batch getBatch(int batchId) {
		Batch batch = new Batch();
		System.out.println("inside getbatch....batchid"+batchId);
		
		try {
			
			String sql = "select * from Batch where batchId="+batchId;
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery(sql);
			
			if(set.next()) {
			
				batch.setBatchId(set.getInt(1));
				batch.setTimeSlot(set.getTime(2));
				batch.setTotalslots(set.getInt(3));
				batch.setAvailslots(set.getInt(4));
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
		return batch;
	}


	@Override
	public int createParticipant(Participants participant) {
		int val =0;
		try {
			String sql = "insert into Participants values(null, ?,?,?,?,?)";
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, participant.getStudentFName());
			preparedStatement.setString(2, participant.getStudentLName());
			preparedStatement.setString(3, participant.getStudentEmail());
			preparedStatement.setString(4, participant.getStudentPhone());
			preparedStatement.setInt(5, participant.getBatchId());
			
			val = preparedStatement.executeUpdate();
			String msg = (val>0) ? "Inserted a new Participant details successfully " : "Not able to insert";
			System.out.println(TAG+msg);
		
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
		}
		return val;
	}

	@Override
	public int updateParticipant(Participants participant) {
		int val=0;
		try {
			
			String sql = "update Participants set studentEmail= ?,studentPhone= ?,batchId=? where pid =?";
			
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, participant.getStudentEmail());
			preparedStatement.setString(2, participant.getStudentPhone());	
			preparedStatement.setInt(3, participant.getBatchId());
			
			preparedStatement.setInt(4, participant.getPid());

			val = preparedStatement.executeUpdate();
			
			String msg = (val>0) ? "Updated Participant record successfully " : "Not able to update Participant details";
			System.out.println(TAG+msg);
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		return val;
		
	}

	@Override
	public int deleteParticipant(int pid) {
		int val =0;
		try {
			String sql = "delete from Participants where pid="+pid;
			preparedStatement = connection.prepareStatement(sql);
			
			val = preparedStatement.executeUpdate(sql);
			String msg = (val>0) ? "Deleted Participant record successfully " : "Not able to delete Participant details";
			System.out.println(TAG+msg);
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		return val;
	}

	@Override
	public ArrayList<Participants> getAllParticipant() {
		
		ArrayList<Participants> participants = new ArrayList<Participants>();
		
		try {
			String sql = "select * from Participants";
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery(sql);
			
			while(set.next()) {
				Participants participant = new Participants();
				
				participant.setPid((set.getInt(1)));
				participant.setStudentFName(set.getString(2));
				participant.setStudentLName(set.getString(3));
				participant.setStudentEmail(set.getString(4));
				participant.setStudentPhone(set.getString(5));
				participant.setBatchId(set.getInt(6));
				
				participants.add(participant);
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
		return participants;
	}

	@Override
	public Participants getParticipants(int pId) {
		Participants student = new Participants();
		System.out.println("inside getbatch....batchid"+pId);
		
		try {
			
			String sql = "select * from Participants where pid="+pId;
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery(sql);
			
			if(set.next()) {
				
				student.setPid(set.getInt(1));
				student.setStudentFName(set.getString(2));
				student.setStudentLName(set.getString(3));
				student.setStudentEmail(set.getString(4));
				student.setStudentPhone(set.getString(5));
				student.setBatchId(set.getInt(6));
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
		return student;
	}

	

}
