package us.rlit.ws.server;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        LOG.info("Starting application.run...");
        SpringApplication.run(Application.class);


    }
}

