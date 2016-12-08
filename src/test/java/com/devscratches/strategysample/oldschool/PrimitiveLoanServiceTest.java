package com.devscratches.strategysample.oldschool;

import com.devscratches.strategysample.Customer;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;

public class PrimitiveLoanServiceTest {

    private PrimitiveLoanService primitiveLoanService = new PrimitiveLoanService();

    @Test
    public void isNotOlderThan31() throws Exception {
        boolean isNotOlderThan31 = primitiveLoanService.giveLoan(Customer.build(customer -> customer.setAge(22).setEmail("blabla@email.com")));

        assertThat(isNotOlderThan31, Is.is(FALSE));
    }

    @Test
    public void hasSpecificEmail() throws Exception {
        boolean hasSpecificEmail = primitiveLoanService.giveLoan(Customer.build(customer -> customer.setAge(32).setEmail("blabla@email.com")));

        assertThat(hasSpecificEmail, Is.is(TRUE));
    }

    @Ignore("Need mock framework!")
    @Test
    public void isNotBlackListed() throws Exception {
        boolean isNotBlacklisted = primitiveLoanService.giveLoan(Customer.build(customer -> customer.setEmail("blabla@email.com").setAge(32)));
        assertThat(isNotBlacklisted, Is.is(FALSE));
    }

    @Ignore("Need mock framework!")
    @Test
    public void isTrustedCustomer() throws Exception {
        boolean isTrusted = primitiveLoanService.giveLoan(Customer.build(customer -> customer.setEmail("blabla@email.com").setAge(22)));
        assertThat(isTrusted, Is.is(TRUE));
    }
}