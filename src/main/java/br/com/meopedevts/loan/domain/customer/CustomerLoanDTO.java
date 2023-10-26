package br.com.meopedevts.loan.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public record CustomerLoanDTO(
        int age,
        String document,
        String name,
        BigDecimal income,
        String location
) {
}
