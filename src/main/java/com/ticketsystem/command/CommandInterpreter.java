package com.ticketsystem.command;

import com.ticketsystem.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * This class interpret the command on the basis of command line arguments / file lines / provided string.
 * Created by saurabh on 11/02/22.
 */
@Component
public class CommandInterpreter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandInterpreter.class);

    private TicketService ticketService;

    @Autowired
    public CommandInterpreter(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Interpet the {@link Command} on the basis of given command line.
     * @param commandLine
     */
    public void interpretCommand(String commandLine) {

        String [] commandParams = commandLine.split(" ");
        CommandType commandType = CommandType.getCommandType(commandParams[0]);

        if (commandType == null) {
            LOGGER.info("Command " + commandParams[0] + " not supported.");
            return;
        }

        if (commandParams.length < commandType.getParamLimit()) {
            LOGGER.error("INVALID ARGUMENTS :: Minimum Argument Limit [ "+commandType.getParamLimit()+" ]for Command - "+commandType.getName());
            return;
        }

        Map<String, Object> params = new HashMap<>();

        switch (commandType) {

            case CREATE_TICKET:
                params.put("messageType", commandParams[1]);
                params.put("messageDescription", commandParams[2]);
                params.put("ticketService", ticketService);
                break;

        }

        Command command = CommandFactory.newCommand(commandType, params);
        command.execute();

    }
}
