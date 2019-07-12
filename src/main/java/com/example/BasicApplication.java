package com.example;

import ch.qos.logback.classic.LoggerContext;
import com.example.component.TestComponent;
import com.example.component.TestComponent2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

    private static final Logger logger = LoggerFactory.getLogger("com.example");

    public static void main(String[] args) {
        
        ApplicationContext context = SpringApplication.run(BasicApplication.class, args);
        TestComponent testCom = context.getBean(TestComponent.class);
        testCom.processStep();

        TestComponent2 testCom2 = context.getBean(TestComponent2.class);
        testCom2.processStep();
        String filePath = "/Users/surajit.samui/Desktop/payload_11.json";
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
        String payloadText = readAllBytesJava7(filePath);
        logger.debug(payloadText);
        TestComponent2 testCom3 = context.getBean(TestComponent2.class);
        testCom3.processStep();
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.stop();

        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
    }

    private static String readAllBytesJava7(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
