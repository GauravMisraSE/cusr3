package com.cmpe275.cusr.service;

import java.util.List;

import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.model.Tickets;

public interface TicketService {


	Long bookTicket(Tickets ticket);
	int cancelTicket(Long ticketIdNew, String sysdate);

}