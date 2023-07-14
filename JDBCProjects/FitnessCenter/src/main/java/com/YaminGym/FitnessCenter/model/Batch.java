package com.YaminGym.FitnessCenter.model;

import java.sql.Time;
import java.time.LocalTime;

public class Batch {
	
	Integer batchId;
	Time timeSlot;
	Integer totalslots;
	Integer availslots;
	
	public Batch() {
		
	}

	public Batch( Time timeSlot, Integer totalslots, Integer availslots) {
		super();
		this.timeSlot = timeSlot;
		this.totalslots = totalslots;
		this.availslots = availslots;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Time getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Time lt) {
		this.timeSlot = lt;
	}

	public Integer getTotalslots() {
		return totalslots;
	}

	public void setTotalslots(Integer totalslots) {
		this.totalslots = totalslots;
	}

	public Integer getAvailslots() {
		return availslots;
	}

	public void setAvailslots(Integer availslots) {
		this.availslots = availslots;
	}
	
	

}
