package com.devscratches.strategysample.oldschool.validation;

import com.devscratches.strategysample.Customer;

public class TrustValidation implements Validation{
    @Override
    public boolean validate(Customer customer) {
        return true;
    }
}
