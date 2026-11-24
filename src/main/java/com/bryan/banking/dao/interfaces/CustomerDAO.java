package com.bryan.banking.dao.interfaces;

import com.bryan.banking.model.Customer;
import java.util.Optional;

public interface CustomerDAO {

    Customer create(Customer customer);

    Optional<Customer> findById(int id);

    Optional<Customer> findByUsername(String username);

    void updateProfile(Customer customer);

    void updatePassword(int customerId, String newPasswordHash);
}
