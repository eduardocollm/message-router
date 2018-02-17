package com.collesoft.messagerouter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Service(value = "commandLineRouterService")
@Slf4j
public class CommandLineMessageRouterImpl implements MessageRouterService {

    @Override
    public String sendMessage(String message) throws Exception {

        Process p;
        StringBuffer output = new StringBuffer();

        try {
            log.info("executing shell command [{}]", message);
            p = Runtime.getRuntime().exec(message);
            p.waitFor(5, TimeUnit.SECONDS);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + '\n');
            }
        } catch (IOException e) {
            log.error("I/O Error reading input stream from command");
            return "no response";
        } catch (Exception e) {
            log.error("error executing command", e);
            throw e;
        }

        return output.toString();
    }
}
