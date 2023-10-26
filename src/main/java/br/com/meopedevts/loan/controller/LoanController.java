package br.com.meopedevts.loan.controller;

import br.com.meopedevts.loan.domain.customer.CustomerLoanDTO;
import br.com.meopedevts.loan.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

    @Autowired
    private LoanServices service;

    @PostMapping()
    private ResponseEntity<Object> getLoans(@RequestBody CustomerLoanDTO customerLoan) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getLoans(customerLoan));
    }
}
