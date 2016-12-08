package com.devscratches.strategysample.modern;

import com.devscratches.strategysample.Customer;

import java.util.function.Predicate;

public class LoanService {

    private final Predicate<Customer> isClearForLoan;

    public LoanService(Predicate<Customer> isClearForLoan) {
        this.isClearForLoan = isClearForLoan;
    }

    public void giveLoan(Customer customer) {

        giveLoan(customer, this.isClearForLoan);

    }

    public boolean giveLoan(Customer customer, Predicate<Customer> isClearForLoan) {

        if (isClearForLoan.negate().test(customer))
            return false;

        // send money

        return true;
    }

}
