package com.alves.saudeapi.application.port.out;

import com.alves.saudeapi.application.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer findById(Long id);
}
