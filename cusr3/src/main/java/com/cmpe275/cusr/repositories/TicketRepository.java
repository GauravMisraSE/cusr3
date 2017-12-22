package com.cmpe275.cusr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.model.Tickets;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {


}
