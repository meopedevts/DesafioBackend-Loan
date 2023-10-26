package br.com.meopedevts.loan.services;

import br.com.meopedevts.loan.domain.customer.CustomerLoanDTO;
import br.com.meopedevts.loan.domain.loan.Loan;
import br.com.meopedevts.loan.domain.loan.LoanType;
import br.com.meopedevts.loan.exceptions.CustomerBadCreditException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanServices {

    private Loan createLoan(String type) {

        Loan newLoan = new Loan();

        if (type.toLowerCase().equals("personal")) {
            newLoan.setType(LoanType.PERSONAL);
            newLoan.setInterestRate(4);
        } else if (type.toLowerCase().equals("guaranteed")) {
            newLoan.setType(LoanType.GUARANTEED);
            newLoan.setInterestRate(3);
        } else if (type.toLowerCase().equals("consignment")) {
            newLoan.setType(LoanType.CONSIGNMENT);
            newLoan.setInterestRate(2);
        }

        return newLoan;
    }

    private boolean isPersonalLoanValid(int age, BigDecimal income, String location) {
        if (income.compareTo(new BigDecimal(3000)) <= 0) return true;
        return income.compareTo(new BigDecimal(3000)) > 0 && income.compareTo(new BigDecimal(5000)) < 0 && age < 30 && location.equalsIgnoreCase("SP");
    }

    private boolean isConsignmentLoanValid(BigDecimal income) {
        return income.compareTo(new BigDecimal(5000)) >= 0;
    }

    private boolean isGuaranteedLoanValid(int age, BigDecimal income, String location) {
        if (income.compareTo(new BigDecimal(3000)) <= 0) return true;
        return income.compareTo(new BigDecimal(3000)) > 0 && income.compareTo(new BigDecimal(5000)) < 0 && age < 30 && location.equalsIgnoreCase("SP");
    }

    public Map<String, Object> getLoans(CustomerLoanDTO customerLoan) throws Exception {
        List<Loan> loanList = new ArrayList<>();

        if (isPersonalLoanValid(customerLoan.age(), customerLoan.income(), customerLoan.location())) {
            loanList.add(createLoan("personal"));
        }

        if (isGuaranteedLoanValid(customerLoan.age(), customerLoan.income(), customerLoan.location())) {
            loanList.add(createLoan("guaranteed"));
        }

        if (isConsignmentLoanValid(customerLoan.income())) {
            loanList.add(createLoan("consignment"));
        }

        if (loanList.isEmpty()) {
            throw new CustomerBadCreditException();
        }

        Map<String, Object> res = new HashMap<>();
        res.put("customer", customerLoan.name());
        res.put("loans", loanList);

        return res;
    }
}
