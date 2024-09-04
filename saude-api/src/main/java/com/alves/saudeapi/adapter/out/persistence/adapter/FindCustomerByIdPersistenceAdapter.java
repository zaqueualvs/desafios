package com.alves.saudeapi.adapter.out.persistence.adapter;

import com.alves.saudeapi.application.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdPort {

    Optional<Customer> findById(Long id);
}
