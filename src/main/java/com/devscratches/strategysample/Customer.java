package com.devscratches.strategysample;

import java.util.function.Consumer;

public class Customer {
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private Customer() {

    }

    // getters

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Fluent setters

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Customer setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public static Customer build(){
        return new Customer();
    }

    public static Customer build(Consumer<Customer> consumer) {

        Customer customer = build();

        consumer.accept(customer);

        return customer;

    }
}
