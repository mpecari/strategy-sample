package com.devscratches.strategysample.oldschool.validation;

import com.devscratches.strategysample.Customer;

public class EmailValidation implements Validation{
    @Override
    public boolean validate(Customer customer) {
        return customer.getEmail() != null && customer.getEmail().endsWith("@email.com");
    }
}
