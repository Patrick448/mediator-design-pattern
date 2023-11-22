package MessageService;

import java.util.ArrayList;
import java.util.List;

public class MessageServer {

    private List<Message> messages;
    private static MessageServer instance = new MessageServer();

    private MessageServer() {
        messages = new ArrayList<Message>();
    }

    public void reset() {
        messages.clear();
    }

    public static MessageServer getInstance() {
        return instance;
    }

    public void sendMessage(User sender, User receiver, String message) {
        Message newMessage = new Message(message, sender, receiver);
        messages.add(newMessage);
    }

    public List<String> getMessages(User user) {
        List<String> userMessages = new ArrayList<String>();
        for (Message message : messages) {
            if (message.getReceiver().equals(user)) {
                userMessages.add(message.getSender().getName() + ":" + message.getMessage());
            }
        }
        return userMessages;
    }
}
