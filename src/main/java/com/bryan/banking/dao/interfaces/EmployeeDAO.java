package com.bryan.banking.dao.interfaces;

import com.bryan.banking.model.Employee;
import java.util.Optional;

public interface EmployeeDAO {

    Optional<Employee> findById(int id);

    Optional<Employee> findByUsername(String username);
}
