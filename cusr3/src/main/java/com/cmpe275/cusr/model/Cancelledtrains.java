package com.cmpe275.cusr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cancelledtrains {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cancelid;
	String name;
	String date;

	public Cancelledtrains() {
	}

	public Cancelledtrains(String name, String date) {
		this.name = name;
		this.date = date;
	}

	public Long getCancelid() {
		return cancelid;
	}

	public void setCancelid(Long cancelID) {
		this.cancelid = cancelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
