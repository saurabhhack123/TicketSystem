package com.ticketsystem.command;

import com.ticketsystem.entity.Ticket;
import com.ticketsystem.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create Parking Lot Command.
 * Created by saurabh on 11/02/22.
 */
public class CreateTicket implements Command<Ticket> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTicket.class);
    private TicketService ticketService;
    private String messageType;
    private String messageDescription;

    public TicketService getTicketService() {
        return ticketService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public CreateTicket() {
    }

    /**
     *
     * @return parking slot number.
     */
    public String execute() {

        String result = "";
        if (ticketService != null) {
            result = ticketService.createTicket(messageType, messageDescription);
        } else {
            result = "Error";
            LOGGER.info("" + result);
        }
        return result;
    }

}
