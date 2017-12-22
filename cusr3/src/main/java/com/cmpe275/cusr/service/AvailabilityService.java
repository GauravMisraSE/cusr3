package com.cmpe275.cusr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cmpe275.cusr.repositories.TicketsRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AvailabilityService {

	@Autowired
	TicketsRepository ticketsRepository;

	@Value("${traincapacity}")
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int checkAvailability(Character from, Character upto, String train, String journeyDate){
		//journeyDate = "2017-12-19";
		int start = from;
		int end = upto;
		System.out.println("capacity: " + capacity);
		Integer available = capacity;
		
		System.out.println("checking availability with" + "start:"+from + " upto:"+upto + " train:"+train+" date:"+journeyDate);
		if (start - end < 0) // onward journey
			{
				try {
						Integer reservedBetweenStations = ticketsRepository.checkEmptyBetweenOnward(start, end, train, journeyDate);
						available = available - reservedBetweenStations;
				}
				catch (NullPointerException n){
					System.out.println("No reservations found for the searched train for the query, returning availability");
				}
				try {
						Integer reservedBetweenStations2 = ticketsRepository.checkEmptyBetweenOnward2(start, end, train, journeyDate);
						available = available - reservedBetweenStations2;
				}
				catch (NullPointerException n){
					System.out.println("No reservations found for the searched train for the query, returning availability");
				}
				return available;
			}

		if (start - end > 0) // backward journey
			{

				try {
					Integer reservedBetweenStations = ticketsRepository.checkEmptyBetweenReturn(start, end, train, journeyDate);
					available = available - reservedBetweenStations;
				}
				catch (NullPointerException n){
					System.out.println("No reservations found for the searched train for the query, returning availability");
				}
				try {
					Integer reservedBetweenStations2 = ticketsRepository.checkEmptyBetweenReturn2(start, end, train, journeyDate);
					available = available - reservedBetweenStations2;
				}
				catch (NullPointerException n){
					System.out.println("No reservations found for the searched train for the query, returning availability");
				}
				return available;
			}

		//return -400; // will never be returned
		return capacity;
	}
}
