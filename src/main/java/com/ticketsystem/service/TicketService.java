package com.ticketsystem.service;
//
//import com.ticketsystem.entity.Ticket;
//import com.ticketsystem.entity.TicketStore;

/**
 * Created by saurabh on 11/02/22.
 */
public interface TicketService {


    String createTicket(String messageType, String messageDescription);
    /**
     * Display the current status of parking lot.
     */
    String status();

}
