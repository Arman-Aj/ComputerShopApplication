package com.armanaj.computershop.payload.response;

import lombok.Getter;
import lombok.Setter;

public class MessageResponse {
    @Getter
    @Setter
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}