package com.tabdaul.tabanewsapp.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDetails {

    private String message;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ErrorDetails() {
        timestamp = LocalDateTime.now();
    }

    public ErrorDetails(String message, String uri) {
        this.message = message;
        this.uri = uri;
        this.timestamp = LocalDateTime.now();
    }
}
