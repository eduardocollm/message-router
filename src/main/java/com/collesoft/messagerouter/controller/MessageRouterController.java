package com.collesoft.messagerouter.controller;

import com.collesoft.messagerouter.model.MessageRequest;
import com.collesoft.messagerouter.model.MessageResponse;
import com.collesoft.messagerouter.service.MessageRouterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MessageRouterController {

    private static final String LOG = "LOGGER";
    private static final String COMMAND = "COMMANDLINE";

    @Autowired
    private MessageRouterService loggerRouterService;

    @Autowired
    private MessageRouterService commandLineRouterService;

    @RequestMapping(value = "/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MessageResponse sendMessage(@RequestBody MessageRequest request) throws Exception {

        MessageResponse response = new MessageResponse();

        if (LOG.equalsIgnoreCase(request.getTarget())) {
            response.setResponse(loggerRouterService.sendMessage(request.getMessage()));
        } else if (COMMAND.equalsIgnoreCase(request.getTarget())) {
            response.setResponse(commandLineRouterService.sendMessage(request.getMessage()));
        } else {
            response.setResponse(new StringBuilder("no route target specified for message [").append(request.getMessage()).append("]").toString());
        }

        return response;
    }
}
