package com.bpb.publications.authors.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoRecordsException extends RuntimeException {

    public NoRecordsException(String message) {
        super(message);
    }
}

