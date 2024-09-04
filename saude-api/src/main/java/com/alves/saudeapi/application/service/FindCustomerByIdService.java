package com.alves.saudeapi.application.service;

import com.alves.saudeapi.application.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer findById(Long id);
}
