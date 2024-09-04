package com.alves.saudeapi.application.port.out;

import com.alves.saudeapi.application.domain.Customer;

public interface UpdateCustomerUseCase {

    Customer update(Customer customer);
}
