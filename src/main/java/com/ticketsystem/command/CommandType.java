package com.ticketsystem.command;

/**
 * Enum contains {@link Command} type and details.
 * Created by saurabh on 11/02/22.
 */
public enum CommandType {

    CREATE_TICKET("create-ticket", CreateTicket.class, 3);

    private String name;
    private Class classType;
    private Integer paramLimit;

    CommandType(String name, Class classType, Integer paramLimit){
        this.name = name;
        this.classType = classType;
        this.paramLimit = paramLimit;
    }

    public Command getCommand(CommandType commandType) {

        Command command = null;
        try {
            command = (Command)commandType.getClassType().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return command;
    }

    public static CommandType getCommandType(String command) {

        CommandType commandType = null;

        for (CommandType commandTypeValue : CommandType.values()) {
            if (command.equalsIgnoreCase(commandTypeValue.getName())) {
                commandType = commandTypeValue;
                break;
            }
        }
        return commandType;
    }

    public String getName() {
        return name;
    }

    public Class getClassType() {
        return classType;
    }

    public Integer getParamLimit() {
        return paramLimit;
    }
}
