package com.cmpe275.cusr.service;

import com.cmpe275.cusr.model.Cancelledtrains;
//import cusr.model.Tickets2;
import com.cmpe275.cusr.model.Tickets;
import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.repositories.CancelledtrainsRepository;
import com.cmpe275.cusr.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service @Transactional
public class TrainCancellationService {

	public static Long counter = 1L;

	@Autowired
	CancelledtrainsRepository cancelledtrainsRepository;
	@Autowired
	TicketsRepository ticketsRepository;
	@Autowired SearchService2 searchService2;
	@Autowired
	AvailabilityService availabilityService;
	@Autowired ReservationService reservationService;
	@Autowired EmailService emailService;

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean cancelTrain(Cancelledtrains ct){

		String trainName = ct.getName();
		String date = ct.getDate();
//		List<Tickets2> passengers = null;
		List<Tickets> passengers = null;


		passengers = getPassengers(ct);
		if (passengers !=null && !passengers.isEmpty()) {
			cancelTkts(passengers);
			boolean replacePossible = checkReplacements(passengers);
			if (replacePossible == true)
				performReplacements(passengers);
			else
				informPassengers(passengers);
//			return status;
			return true;
		}
		else {
//			return status;
			System.out.println("No passengers found");
			return true;
		}
	}
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cancelTrainObj(Cancelledtrains ct){
		try {
			ct.setCancelid(counter);
			cancelledtrainsRepository.save(ct);
			counter++;
//			return true;
		}
		catch (Exception e){
//			return false;
		}
	}
	//Tickets2
	public List<Tickets> getPassengers(Cancelledtrains ct){
		List<Tickets> passengers = new ArrayList<>();

		try {
			ticketsRepository.findByTrainAndJdate(ct.getName(), ct.getDate()).forEach(passengers::add);
			return passengers;
		}
		catch (NullPointerException e){
			System.out.println("NullPointer occured");
			return null;
		}

	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cancelTkts(List<Tickets> tickets){
		List<Long> tktIds = new ArrayList<>();
		for(Tickets t : tickets) {
			tktIds.add(t.getTktid());
		}

		Iterator<Tickets> iter = ticketsRepository.findAll().iterator();
		while (iter.hasNext()) {
			for (Long id : tktIds) {
				Long iterId = iter.next().getTktid();
//				Long iterId = iter.next().getTid();
				if (iterId == id)
//					ticketsRepository.delete(iter.);
					iter.remove();
			}
		}
			ticketsRepository.deleteAll();
			List<Tickets> newtkts = new ArrayList<>();
			while (iter.hasNext()){
				newtkts.add(iter.next());
			}

				ticketsRepository.save(newtkts);
	}



	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean checkReplacements(List<Tickets> tickets){

		for (Tickets tkts: tickets){
//			System.out.println(tickets.getTid());
			System.out.println(tkts.getTktid());

		}
		String startTime = tickets.get(0).getStime();
		char startStation = (char)((int) tickets.get(0).getStart());
		System.out.println("start station = " + startStation);
		char endStation = (char)((int)tickets.get(0).getEnd());
		System.out.println("end station = " + endStation);
		String endTime = tickets.get(0).getEtime();
		String date = tickets.get(0).getJdate();
		Character trainType = tickets.get(0).getTraintype();

		for (Tickets t: tickets)
			{
				int pcount = t.getPass_count();
				// search train options for a ticket
				List<Trains> options = searchService2.searchTrains(startStation, startTime, endStation, trainType, date);
				int counter = 0;

				// check availability in train options, if any ticket is unavailable for re booking return false, else true
				for (Trains option: options){

					int available = availabilityService.checkAvailability(startStation, endStation, option.getName(), date);
					if (pcount <= available){
						counter = 1;
						break;
					}
				}
				if (counter == 1)
					continue;
				else
					return false;
			}
		return true;
	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void performReplacements(List<Tickets> tickets){

		String startTime = tickets.get(0).getStime();
		char startStation = (char)((int) tickets.get(0).getStart());
		System.out.println("start station = " + startStation);
		char endStation = (char)((int)tickets.get(0).getEnd());
		System.out.println("end station = " + endStation);
		String endTime = tickets.get(0).getEtime();
		String date = tickets.get(0).getJdate();
		Character trainType = tickets.get(0).getTraintype();

		for (Tickets t: tickets)
			{

				int pcount = t.getPass_count();
				// search train options for a ticket
				List<Trains> options = searchService2.searchTrains(startStation, startTime, endStation, trainType, date);

				int len = options.size();
				while (len > 0 && options != null){
					Trains nearestTrain = getNearestTrain(options, startTime, startStation);
					int available = availabilityService.checkAvailability(startStation, endStation, nearestTrain.getName(), date);
					if (pcount <= available){
						// make reservation and send email
						Tickets newtkt = new Tickets();
						newtkt.setTktid(counter);
						counter++;
						System.out.println("************************TN*************************" + nearestTrain.getName());
						System.out.println("************************A*************************" + nearestTrain.getA());
						newtkt.setTrain(nearestTrain.getName()); newtkt.setJdate(t.getJdate());newtkt.setStart(t.getStart());newtkt.setEnd(t.getEnd());
						newtkt.setEmail(t.getEmail()); newtkt.setFare(t.getFare()); newtkt.setPass_count(t.getPass_count());newtkt.setTraintype(t.getTraintype());
						Long newtktId = reservationService.bookTicket(newtkt);
						sendRebookingMail(newtkt);
						break;
					}
					else {
						options.remove(nearestTrain);
						len = len - 1;
					}
				}


	}
}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public Trains getNearestTrain(List<Trains> options, String startTime, Character startStation){

		Trains nearest = new Trains();
//		LocalTime st = LocalTime.parse(startTime);
//		LocalTime first = LocalTime.parse(searchService2.getstationTime(options.get(0).getName(), startStation));
//		Long diff = st.until(first, MINUTES);
//		System.out.println("Difference between start station times" + diff);

		for (Trains t: options){
			LocalTime timeI = LocalTime.parse(searchService2.getstationTime(t.getName(), startStation));
			LocalTime st = LocalTime.parse(startTime);
			Long diffnew = st.until(timeI, MINUTES);
//			if (diffnew < diff)
//				{
//					diff = diffnew;
//					nearest = t;
//				}
			if (diffnew == 15 || diffnew == 30 || diffnew == 45 || diffnew == 60 || diffnew == 75)
				nearest = t;
		}
		return nearest;
	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void informPassengers(List<Tickets> tickets){
		for (Tickets t: tickets)
		{
			sendCancellationMail(t);
		}
	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendRebookingMail(Tickets tkt){

		String message = "Hello! Due to the cancellation of your orignal train, you have been rebooked " +
				"to another train. Details of your new ticket are:" + " Train name:" + tkt.getTrain() + "Ticket ID: " + tkt.getTktid();
		try {
			emailService.sendRebookingConfirmation(tkt.getEmail(), message);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return;
	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendCancellationMail(Tickets tkt){
		String message = "This email is to inform you that your ticket: " + tkt.getTktid() + "has been cancelled due to train " +
				"cancellation, please book another ticket";
		try {
			emailService.sendRebookingConfirmation(tkt.getEmail(), message);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
