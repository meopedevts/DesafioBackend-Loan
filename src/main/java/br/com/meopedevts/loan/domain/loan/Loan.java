package br.com.meopedevts.loan.domain.loan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private LoanType type;
    private int interestRate;
}
