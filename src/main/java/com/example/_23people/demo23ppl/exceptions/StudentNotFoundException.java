package com.example._23people.demo23ppl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The specified student could not be found")
public class StudentNotFoundException extends RuntimeException {
    static final long serialVersionUID = 123412341234L;
}
