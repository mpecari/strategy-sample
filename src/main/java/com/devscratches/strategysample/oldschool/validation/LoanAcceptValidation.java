package com.devscratches.strategysample.oldschool.validation;

import com.devscratches.strategysample.Customer;

public class LoanAcceptValidation implements Validation{

    private Validation ageValidation;

    private Validation emailValidation;

    private Validation blacklistValidation;

    private Validation trustValidation;

    public LoanAcceptValidation() {
        this.ageValidation = new AgeValidation();
        this.emailValidation = new EmailValidation();
        this.blacklistValidation = new BlacklistValidation();
        this.trustValidation = new TrustValidation();
    }

    @Override
    public boolean validate(Customer customer) {
        return (ageValidation.validate(customer) && emailValidation.validate(customer)
                && !blacklistValidation.validate(customer)) || trustValidation.validate(customer);
    }
}
