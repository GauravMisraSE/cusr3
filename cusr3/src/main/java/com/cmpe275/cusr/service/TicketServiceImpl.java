package com.cmpe275.cusr.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.model.Tickets;
import com.cmpe275.cusr.repositories.TicketRepository;



@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Long bookTicket(Tickets ticket) {
		System.out.println("Service method call");
		ticketRepository.save(ticket);
		return  ticket.getTktid();
	}

	@Override
	public int cancelTicket(Long ticketIdNew, String sysdate) {
		Tickets cancelTicket = ticketRepository.findOne(ticketIdNew);
		LocalDate cancelDate = LocalDate.parse(cancelTicket.getJdate().toString());
		LocalTime cancelTime = LocalTime.parse(cancelTicket.getStime().toString());
		System.out.println("cancelDate"+cancelDate);
		System.out.println("cancelTime"+cancelTime);
		LocalDateTime dt = LocalDateTime.of(cancelDate, cancelTime);
		System.out.println("cancel date"+dt);
		System.out.println("sysdate"+sysdate);
		Timestamp ts = Timestamp.valueOf(sysdate);
		System.out.println("ts"+ts);	
	    Timestamp actual_date = Timestamp.from(dt.toInstant(ZoneOffset.ofHours(0)));
	    long secs = (actual_date.getTime() - ts.getTime()) / 1000;
	    int hours = (int) (secs/3600); 
		System.out.println("hours"+hours);
		if (hours>=2) {
		ticketRepository.delete(ticketIdNew);
		return 1;
		}
		else
			return 0;
	}
	
	

}
