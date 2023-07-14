package com.FitnessCenter.db;

import java.util.ArrayList;

import com.FitnessCenter.model.Batch;
import com.FitnessCenter.model.Participants;

public interface DAO {
	void createConnection();
	void closeConnection();
	
	int createBatch(Batch batch);
	int updateBatch(Batch batch);
	int deleteBatch(int batchId);
	ArrayList<Batch> getAllBatches();
	Batch getBatch(int batchId);
	
	int createParticipant(Participants participant);
	int updateParticipant(Participants participant);
	int deleteParticipant(int pid);
	ArrayList<Participants> getAllParticipant();
	Participants getParticipants(int pId);

}
