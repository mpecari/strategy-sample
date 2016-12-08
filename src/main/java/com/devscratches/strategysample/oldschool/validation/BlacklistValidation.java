package com.devscratches.strategysample.oldschool.validation;

import com.devscratches.strategysample.Customer;

public class BlacklistValidation implements Validation{
    @Override
    public boolean validate(Customer customer) {
        return true;
    }
}
