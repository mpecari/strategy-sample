package com.devscratches.strategysample.modern;

import com.devscratches.strategysample.Customer;

import java.util.function.Predicate;

public final class CustomerValidation implements Predicate<Customer>{

    public static final Predicate<Customer> isOlderThan31 = customer -> customer.getAge() > 31;

    public static final Predicate<Customer> hasSpecificEmail = customer -> customer.getEmail() != null && customer.getEmail().endsWith("@email.com");

    public Predicate<Customer> isNotBlackListed = customer -> !isBlackListed(customer.getFirstName(), customer.getLastName());

    public Predicate<Customer> isTrustedCustomer = customer -> isTrustedCustomer(customer.getId());

    public CustomerValidation() {
    }

    public CustomerValidation(Predicate<Customer> isNotBlackListed, Predicate<Customer> isTrustedCustomer) {
        this.isNotBlackListed = isNotBlackListed;
        this.isTrustedCustomer = isTrustedCustomer;
    }

    @Override
    public boolean test(Customer customer) {
        return isOlderThan31.and(hasSpecificEmail.and(isNotBlackListed)).or(isTrustedCustomer).test(customer);
    }

    public boolean isBlackListed(String firstName, String lastName) {
        return true;
    }

    public boolean isTrustedCustomer(Long id) {
        return true;
    }


}
