package com.alves.saudeapi.application.port.in;

import com.alves.saudeapi.application.domain.Customer;

import java.util.List;

public interface FindCustomerWithRisk {

    List<Customer> findCustomerWithRisk(Customer customer);
}
