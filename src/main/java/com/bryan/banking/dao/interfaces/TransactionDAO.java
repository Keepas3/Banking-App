package com.bryan.banking.dao.interfaces;

import com.bryan.banking.model.Transaction;
import com.bryan.banking.model.TransactionType;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionDAO {

    Transaction create(Transaction transaction);

    List<Transaction> findByAccountId(int accountId);

    List<Transaction> findByAccountIdAndType(int accountId, TransactionType type);

    List<Transaction> findByAccountIdAndDateRange(int accountId,
                                                   LocalDateTime from,
                                                   LocalDateTime to);
}
