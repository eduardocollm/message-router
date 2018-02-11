package com.collesoft.messagerouter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service(value = "commandLineRouterService")
@Slf4j
public class CommandLineMessageRouterImpl implements MessageRouterService {

    @Override
    public String sendMessage(String message) throws Exception {

        Process p;
        StringBuffer output = new StringBuffer();

        try {
            p = Runtime.getRuntime().exec(message);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + '\n');
            }
        } catch (Exception e) {
            log.error("error executing command", e);
            throw e;
        }

        return output.toString();
    }
}
