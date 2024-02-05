package de.ithoc.springboot.exceptionhandling.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemAdvice {

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<Error> notFound(ItemNotFoundException e) {

        Error error = new Error("Item not found.");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
