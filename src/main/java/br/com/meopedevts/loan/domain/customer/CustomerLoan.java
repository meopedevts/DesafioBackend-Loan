package br.com.meopedevts.loan.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoan {
    private int age;
    private String document;
    private String name;
    private BigDecimal income;
    private String location;

}
