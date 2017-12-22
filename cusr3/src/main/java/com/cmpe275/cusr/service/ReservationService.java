package com.cmpe275.cusr.service;

import com.cmpe275.cusr.model.Tickets;
import com.cmpe275.cusr.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationService {

	@Autowired
	private TicketsRepository ticketsRepository;

	public Long bookTicket(Tickets ticket) {
		System.out.println("Saving a ticket into Tickets table");
		ticketsRepository.save(ticket);
		return  ticket.getTktid();
	}
}
