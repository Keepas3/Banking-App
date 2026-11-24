package com.bryan.banking.dao.interfaces;

import com.bryan.banking.model.Account;
import com.bryan.banking.model.AccountStatus;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    Account create(Account account);

    Optional<Account> findById(int id);

    List<Account> findByCustomerId(int customerId);

    void updateStatus(int accountId, AccountStatus status);

    void updateBalance(int accountId, BigDecimal newBalance);

    void closeAccount(int accountId);
}
