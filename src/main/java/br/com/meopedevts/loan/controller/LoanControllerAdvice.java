package br.com.meopedevts.loan.controller;

import br.com.meopedevts.loan.exceptions.CustomerBadCreditException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LoanControllerAdvice {

    @ExceptionHandler(CustomerBadCreditException.class)
    private ResponseEntity<Object> customerBadCreditException() {
        Map<String, Object> res = new HashMap<>();
        res.put("message", "The customer does not have sufficient credit for a loan request.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
    }

}
