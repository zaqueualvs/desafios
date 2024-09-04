package com.alves.saudeapi.application.port.out;

import com.alves.saudeapi.application.domain.Customer;

public interface SaveCustomerUseCase {

    Customer save(Customer customer);

}
