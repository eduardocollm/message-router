package com.collesoft.messagerouter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service(value = "loggerRouterService")
@Slf4j
public class LogMessageRouterServiceImpl implements MessageRouterService {
    @Override
    public String sendMessage(String message) {

        log.info("the message routed is [{}]", message);
        return "message successfully routed to target";
    }
}
