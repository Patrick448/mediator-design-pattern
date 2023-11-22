package MessageService;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageServerTest {

    @Test
    void deveEnviarMensagem(){
        MessageServer messageServer = MessageServer.getInstance();
        messageServer.reset();
        User user1 = new User("user1", "x");
        User user2 = new User("user2", "y");

        messageServer.sendMessage(user1, user2, "Hello");
        List<String> messages = Arrays.asList("user1:Hello");
        assertEquals(messages, messageServer.getMessages(user2));

    }

    @Test
    void naoDeveReceberMensagem(){
        MessageServer messageServer = MessageServer.getInstance();
        messageServer.reset();
        User user1 = new User("user1", "x");
        User user2 = new User("user2", "y");
        User user3 = new User("user3", "z");

        messageServer.sendMessage(user1, user2, "Hello");
        messageServer.sendMessage(user1, user2, "How are you?");
        List<String> messages =  new ArrayList<>();
        assertEquals(messages, messageServer.getMessages(user3));

    }

    @Test
    void deveEnviarMensagens(){
        MessageServer messageServer = MessageServer.getInstance();
        messageServer.reset();
        User user1 = new User("user1", "x");
        User user2 = new User("user2", "y");

        messageServer.sendMessage(user1, user2, "Hello");
        messageServer.sendMessage(user1, user2, "How are you?");
        List<String> messages = Arrays.asList("user1:Hello", "user1:How are you?");
        assertEquals(messages, messageServer.getMessages(user2));

    }

}