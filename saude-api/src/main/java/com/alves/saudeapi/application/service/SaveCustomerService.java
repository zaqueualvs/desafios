package com.alves.saudeapi.application.service;

import com.alves.saudeapi.application.domain.Customer;

public interface SaveCustomerUseCase {

    Customer save(Customer customer);

}
