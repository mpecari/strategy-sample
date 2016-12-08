package com.devscratches.strategysample.modern;

import com.devscratches.strategysample.Customer;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.devscratches.strategysample.modern.CustomerValidation.hasSpecificEmail;
import static com.devscratches.strategysample.modern.CustomerValidation.isOlderThan31;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LoanServiceTest {

    LoanService loanService;

    @Before
    public void setUp() throws Exception {
        CustomerValidation customerValidation = new CustomerValidation();

        loanService = new LoanService(customerValidation);
    }


    @Test
    public void returnFalseForInvalidLoan() throws Exception {
        boolean result = loanService.giveLoan(Customer.build(), customer -> false);

        Assert.assertThat(result, Is.is(FALSE));

    }

    @Test
    public void returnTrueForValidLoan() throws Exception {

        boolean result = loanService.giveLoan(Customer.build(), customer -> true);

        Assert.assertThat(result, Is.is(TRUE));

    }

    @Test
    public void returnFalseForChainValidLoan() throws Exception {

        loanService.giveLoan(Customer.build(customer -> customer.setAge(32).setEmail("wrong")), customer -> customer.getAge() > 31);

        loanService.giveLoan(Customer.build(customer -> customer.setAge(32).setEmail("wrong")), customer -> customer.getEmail() != null && customer.getEmail().endsWith("@email.com"));

        boolean result = loanService.giveLoan(Customer.build(customer -> customer.setAge(32).setEmail("wrong")), hasSpecificEmail.and(isOlderThan31));

        Assert.assertThat(result, Is.is(FALSE));

    }
}