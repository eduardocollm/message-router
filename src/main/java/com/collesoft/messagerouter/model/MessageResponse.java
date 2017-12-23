package com.collesoft.messagerouter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude
@Data
public class MessageResponse {

    @JsonProperty
    private String response;
}
