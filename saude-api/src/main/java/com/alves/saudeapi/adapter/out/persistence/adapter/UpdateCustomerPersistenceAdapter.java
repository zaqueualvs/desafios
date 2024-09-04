package com.alves.saudeapi.adapter.out.persistence.adapter;

import com.alves.saudeapi.application.domain.Customer;

public interface UpdateCustomerPort {

    Customer update(Customer customer);
}
