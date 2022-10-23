package com.tabdaul.tabanewsapp.error;

import org.springframework.http.HttpStatus;

public class MissingFieldException extends ApiBaseException {

    public MissingFieldException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
