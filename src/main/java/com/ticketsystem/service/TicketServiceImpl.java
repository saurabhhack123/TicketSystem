package com.ticketsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketsystem.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService  {

    private UserService userService;

    @Autowired
    public TicketServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public String createTicket(String messageType, String messageDescription){
        Ticket ticket = new Ticket();
        return ticket.createTicket();
    }

    public String status(){
        return "Success";
    }
}
