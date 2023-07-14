package com.YaminGym.FitnessCenter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import com.YaminGym.FitnessCenter.db.DB;
import com.YaminGym.FitnessCenter.model.Batch;
import com.YaminGym.FitnessCenter.model.Participants;

public class App {

	public static void main(String[] args) {
		System.out.println( "Welcome to FitnessCenter App" );
		
		Batch batch = new Batch();
		
		Participants participant;
		participant = new Participants("John","Watson","john@example.com","4089345367",4);
		
		
		//Time lt = Time.valueOf("8:00");
		batch.setTimeSlot(Time.valueOf("8:00:00"));
		batch.setTotalslots(10);
		batch.setAvailslots(4);
		batch.setBatchId(4);
		
		System.out.println("connecting to DB.....");
		DB db = new DB();
      
		db.createConnection();
		
		//db.createBatch(batch);
		
		//db.deleteBatch(2);
		
		//db.updateBatch(batch);
		
		ArrayList<Batch> batchList = db.getAllBatches();
		System.out.println("Batches........");
		batchList.forEach(bl -> {
			System.out.println("Batch details ..........");
			System.out.println(bl.getBatchId());
			System.out.println(bl.getTimeSlot());
			System.out.println(bl.getTotalslots());
			System.out.println(bl.getAvailslots());
			});
		
		db.createParticipant(participant);
		
		ArrayList<Participants> participantsList = db.getAllParticipant();
		System.out.println("Participants........");
		participantsList.forEach(pl -> {
			System.out.println("Participant details ..........");
			System.out.println(pl.getPid());
			System.out.println(pl.getStudentFName());
			System.out.println(pl.getStudentLName());
			System.out.println(pl.getStudentEmail());
			System.out.println(pl.getStudentPhone());
			System.out.println(pl.getBatchId());
		
		});
		
		db.closeConnection();

	}

}
