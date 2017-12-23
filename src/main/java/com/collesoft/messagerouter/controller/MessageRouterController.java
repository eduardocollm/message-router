package com.collesoft.messagerouter.controller;

import com.collesoft.messagerouter.model.MessageRequest;
import com.collesoft.messagerouter.model.MessageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageRouterController {

    @RequestMapping(value = "/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MessageResponse sendMessage(@RequestBody MessageRequest request) {

        MessageResponse response = new MessageResponse();

        // TODO route message and return response
        response.setResponse(new StringBuilder("done sending message [").append(request.getMessage()).append("]").toString());

        return response;
    }
}
