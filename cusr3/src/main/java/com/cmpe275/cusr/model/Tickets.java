package com.cmpe275.cusr.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;


// station numbers start from 1:A to 26:Z
@Entity
public class Tickets {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long tktid;
	String train;

	public Tickets(Long tktid) {
		this.tktid = tktid;
	}

	public Tickets() {
	}

	String jdate;

	public Tickets(String train, String jdate, Integer start, Integer end, String email, Double fare, Integer pass_count, String stime, String etime, Character traintype) {
		this.train = train;
		this.jdate = jdate;
		this.start = start;
		this.end = end;
		this.email = email;
		this.fare = fare;
		this.pass_count = pass_count;
		this.stime = stime;
		this.etime = etime;
		this.traintype = traintype;
	}

	Integer start;
	Integer end;
	String email;
	Double fare;
	@Column(name="pass_count")
	Integer pass_count;
	String stime;
	String etime;
	Character traintype;

	public Character getTraintype() {
		return traintype;
	}

	public void setTraintype(Character traintype) {
		this.traintype = traintype;
	}


	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String et) {
		this.etime = et;
	}

	public Long getTktid() {
		return tktid;
	}

	public void setTktid(Long tktid) {
		this.tktid = tktid;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getPass_count() {
		return pass_count;
	}

	public void setPass_count(Integer pass_count) {
		this.pass_count = pass_count;
	}
}

