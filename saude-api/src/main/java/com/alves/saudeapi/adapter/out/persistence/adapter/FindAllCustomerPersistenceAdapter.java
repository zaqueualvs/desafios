package com.alves.saudeapi.adapter.out.persistence.adapter;

import com.alves.saudeapi.application.domain.Customer;

import java.util.List;

public interface FindAllCustomerPort {

    List<Customer> findAll();
}
