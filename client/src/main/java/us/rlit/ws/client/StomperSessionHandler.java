package us.rlit.ws.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.Date;

public class StomperSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(StomperSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/chat", this);
        logger.info("Subscribed to /chat");
        //session.send("/app/send/message", getSampleMessage());
        session.send("/app/send/message", getMessage());
        logger.info("us.rlit.ws.client.Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }



    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.info("Received : " + payload );

//        Message msg = (Message) payload;
//        logger.info("Received : " + msg.getText() + " from : " + msg.getFrom());
    }

    /**
     * A sample message instance.
     * @return instance of <code>us.rlit.ws.client.Message</code>
     */
    private Message getSampleMessage() {
        Message msg = new Message();
        msg.setFrom("Nicky");
        msg.setText("Howdy!!");
        return msg;
    }

    private String getMessage() {
        return "The date is " + new Date();
    }
}