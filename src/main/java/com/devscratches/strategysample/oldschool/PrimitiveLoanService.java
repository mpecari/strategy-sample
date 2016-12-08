package com.devscratches.strategysample.oldschool;

import com.devscratches.strategysample.Customer;

public class PrimitiveLoanService {

    public boolean giveLoan(Customer customer) {

        if ((customer.getAge() > 31 && customer.getEmail() != null && customer.getEmail().endsWith("@email.com")
                && !isBlackListed(customer.getFirstName(), customer.getLastName())) || isTrustedCustomer(customer.getId())) {

            // send money
            return true;
        }
        return false;
    }

    public boolean isBlackListed(String firstName, String lastName) {
        return false;
    }

    public boolean isTrustedCustomer(Long id) {
        return false;
    }

}
