package com.devscratches.strategysample.oldschool.validation;

import com.devscratches.strategysample.Customer;

public class AgeValidation implements Validation{
    @Override
    public boolean validate(Customer customer) {
        return customer.getAge() > 31;
    }
}
