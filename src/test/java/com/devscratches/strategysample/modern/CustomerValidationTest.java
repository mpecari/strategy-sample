package com.devscratches.strategysample.modern;

import com.devscratches.strategysample.Customer;
import org.hamcrest.core.Is;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;

public class CustomerValidationTest {

    private CustomerValidation customerValidation = new CustomerValidation(customer -> true, customer -> false);

    @Test
    public void isNotOlderThan31() throws Exception {
        boolean isNotOlderThan31 = customerValidation.test(Customer.build(customer -> customer.setAge(22)));

        assertThat(isNotOlderThan31, Is.is(FALSE));
    }

    @Test
    public void hasSpecificEmail() throws Exception {
        boolean hasSpecificEmail = customerValidation.test(Customer.build(customer -> customer.setAge(32).setEmail("blabla@email.com")));

        assertThat(hasSpecificEmail, Is.is(TRUE));
    }

    @Test
    public void isNotBlackListed() throws Exception {
        customerValidation = new CustomerValidation(customer -> false, customer -> false);
        boolean isNotBlacklisted = customerValidation.test(Customer.build(customer -> customer.setEmail("blabla@email.com").setAge(32)));
        assertThat(isNotBlacklisted, Is.is(FALSE));
    }

    @Test
    public void isTrustedCustomer() throws Exception {
        customerValidation = new CustomerValidation(customer -> false, customer -> true);
        boolean isTrusted = customerValidation.test(Customer.build(customer -> customer.setEmail("blabla@email.com").setAge(32)));
        assertThat(isTrusted, Is.is(TRUE));
    }

}