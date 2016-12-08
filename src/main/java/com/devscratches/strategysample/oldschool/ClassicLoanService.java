package com.devscratches.strategysample.oldschool;

import com.devscratches.strategysample.Customer;
import com.devscratches.strategysample.oldschool.validation.Validation;

import static java.lang.Boolean.FALSE;

public class ClassicLoanService {

    private Validation validation;

    public ClassicLoanService(Validation validation) {
        this.validation = validation;
    }

    public boolean giveLoan(Customer customer) {

        if (validation.validate(customer) == FALSE)
            return false;

        // send money

        return true;
    }

}
