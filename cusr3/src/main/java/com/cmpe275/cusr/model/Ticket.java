package com.cmpe275.cusr.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_TICKET")
public class Ticket implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USER_ID")
	private Long userId;

	@Column(name="DEPARTURE_TRAIN_NO")
	private String depTrainNo;
	
	@Column(name="DEPARTURE_FROM")
	private String depFrom;

	@Column(name="DEPARTURE_TO")
	private String depTo;

	@Column(name="DEPARTURE_DATE")
	private String depDate;	
	
	@Column(name="DEPARTURE_FROM_TIME")
	private String depFromTime;	

	@Column(name="DEPARTURE_TO_TIME")
	private String depToTime;	

	@Column(name="RETURN_TRAIN_NO")
	private String retTrainNo;
	
	@Column(name="RETURN_FROM")
	private String retFrom;	
	
	@Column(name="RETURN_TO")
	private String retTo;	

	@Column(name="RETURN_DATE")
	private String retDate;	
	
	@Column(name="RETURN_FROM_TIME")
	private String retFromTime;

	@Column(name="RETURN_TO_TIME")
	private String retToTime;

	@Column(name="NO_OF_PASSENGERS", nullable=false)
	private int noOfPassengers;

	@Column(name="TOTAL_FARE", nullable=false)
	private int totalFare;

	@Transient
	private String passengerList;
	
	@Override
	public boolean equals(Object o) {
		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result =1;
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserID() {
		return userId;
	}

	public void setUserID(Long userID) {
		this.userId = userID;
	}

	public String getDepTrainNo() {
		return depTrainNo;
	}

	public String getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(String passengerList) {
		this.passengerList = passengerList;
	}

	public void setDepTrainNo(String depTrainNo) {
		this.depTrainNo = depTrainNo;
	}

	public String getDepFrom() {
		return depFrom;
	}

	public void setDepFrom(String depFrom) {
		this.depFrom = depFrom;
	}

	public String getDepTo() {
		return depTo;
	}

	public void setDepTo(String depTo) {
		this.depTo = depTo;
	}

	public String getDepDate() {
		return depDate;
	}

	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}

	public String getDepFromTime() {
		return depFromTime;
	}

	public void setDepFromTime(String depFromTime) {
		this.depFromTime = depFromTime;
	}

	public String getDepToTime() {
		return depToTime;
	}

	public void setDepToTime(String depToTime) {
		this.depToTime = depToTime;
	}

	public String getRetTrainNo() {
		return retTrainNo;
	}

	public void setRetTrainNo(String retTrainNo) {
		this.retTrainNo = retTrainNo;
	}

	public String getRetFrom() {
		return retFrom;
	}

	public void setRetFrom(String retFrom) {
		this.retFrom = retFrom;
	}

	public String getRetTo() {
		return retTo;
	}

	public void setRetTo(String retTo) {
		this.retTo = retTo;
	}

	public String getRetDate() {
		return retDate;
	}

	public void setRetDate(String retDate) {
		this.retDate = retDate;
	}

	public String getRetFromTime() {
		return retFromTime;
	}

	public void setRetFromTime(String retFromTime) {
		this.retFromTime = retFromTime;
	}

	public String getRetToTime() {
		return retToTime;
	}

	public void setRetToTime(String retToTime) {
		this.retToTime = retToTime;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", userID=" + userId + ", depTrainNo=" + depTrainNo + ", depFrom=" + depFrom
				+ ", depTo=" + depTo + ", depDate=" + depDate + ", depFromTime=" + depFromTime + ", depToTime="
				+ depToTime + ", retTrainNo=" + retTrainNo + ", retFrom=" + retFrom + ", retTo=" + retTo + ", retDate="
				+ retDate + ", retFromTime=" + retFromTime + ", retToTime=" + retToTime + ", noOfPassengers="
				+ noOfPassengers + ", totalFare=" + totalFare + "]";
	}




}
