package io.github.wkktoria.githubapp;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ErrorHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleUserNotFoundException(UserNotFoundException exception) {
        log.warn("User not found: {}", exception.getMessage());
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponseDto> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException exception) {
        log.warn("HTTP media type not acceptable: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage()));
    }

}
