package com.collesoft.messagerouter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MessageRequest {

    @JsonProperty
    private String target;

    @JsonProperty
    private String message;
}
