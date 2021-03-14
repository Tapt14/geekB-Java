package messages;

import java.io.Serializable;

public class CommandMessages implements Serializable {

    private final Commands command;
    private Message objectMessage;
    private String message;

    public CommandMessages(Commands command) {
        this.command = command;
    }

    public CommandMessages(Commands command, String message) {
        this.command = command;
        this.message = message;
    }

    public CommandMessages(Commands command, Message objectMessage) {
        this.command = command;
        this.objectMessage = objectMessage;
    }

    public Commands getCommand() {
        return command;
    }

    public Message getObjectMessage() {
        return objectMessage;
    }

    public String getMessage() {
        return message;
    }
}
