package com.alves.saudeapi.application.port.out;

import com.alves.saudeapi.application.domain.Customer;

import java.util.List;

public interface FindAllCustomerUseCase {

    List<Customer> findAll();
}