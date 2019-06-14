package us.rlit.ws.client;

import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;


@Component
public class StompClient {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StompClient.class);
    private static String URL = "ws://localhost:8888/socket";


    public static void main(String[] args) {
        run(args);
    }

    public static void run(String... args)  {

        LOGGER.info("In run Chat Client");
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        //stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setMessageConverter(new StringMessageConverter());
        StompSessionHandler sessionHandler = new StomperSessionHandler();
        stompClient.connect(URL, sessionHandler);

        new Scanner(System.in).nextLine(); // Don't close immediately.

    }

}
