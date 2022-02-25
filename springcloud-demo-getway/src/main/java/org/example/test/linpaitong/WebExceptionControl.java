package org.example.test.linpaitong;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionControl {
    @ExceptionHandler(APIException.class)
    public String APIExceptionHandler(APIException e) {
        return "失败了";
    }
}