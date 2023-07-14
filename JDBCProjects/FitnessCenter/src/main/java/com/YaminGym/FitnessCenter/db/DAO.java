package com.YaminGym.FitnessCenter.db;

import java.util.ArrayList;

import com.YaminGym.FitnessCenter.model.Batch;
import com.YaminGym.FitnessCenter.model.Participants;

public interface DAO {
	
	void createConnection();
	void closeConnection();
	
	void createBatch(Batch batch);
	void updateBatch(Batch batch);
	void deleteBatch(int batchId);
	ArrayList<Batch> getAllBatches();
	
	void createParticipant(Participants participant);
	void updateParticipant(Participants participant);
	void deleteParticipant(int pid);
	ArrayList<Participants> getAllParticipant();
	
	
	

}
