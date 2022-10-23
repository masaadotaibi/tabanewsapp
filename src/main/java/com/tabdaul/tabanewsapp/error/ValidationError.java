package com.tabdaul.tabanewsapp.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ValidationError {

    private List<String> errors;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ValidationError() {
        this.errors = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public void addError(String error) {
        this.errors.add(error);
    }
}
