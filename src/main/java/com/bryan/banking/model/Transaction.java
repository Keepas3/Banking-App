package com.bryan.banking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private int id;
    private int accountId;
    private TransactionType type;
    private BigDecimal amount;
    private BigDecimal balanceAfter;
    private Integer initiatedByEmployeeId;
    private String description;
    private LocalDateTime timestamp;

    public Transaction() {}

    public Transaction(int id, int accountId, TransactionType type,
                       BigDecimal amount, BigDecimal balanceAfter,
                       Integer initiatedByEmployeeId, String description,
                       LocalDateTime timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.initiatedByEmployeeId = initiatedByEmployeeId;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getId()                                         { return id; }
    public void setId(int id)                                  { this.id = id; }

    public int getAccountId()                                  { return accountId; }
    public void setAccountId(int accountId)                    { this.accountId = accountId; }

    public TransactionType getType()                           { return type; }
    public void setType(TransactionType type)                  { this.type = type; }

    public BigDecimal getAmount()                              { return amount; }
    public void setAmount(BigDecimal amount)                   { this.amount = amount; }

    public BigDecimal getBalanceAfter()                        { return balanceAfter; }
    public void setBalanceAfter(BigDecimal balanceAfter)       { this.balanceAfter = balanceAfter; }

    public Integer getInitiatedByEmployeeId()                              { return initiatedByEmployeeId; }
    public void setInitiatedByEmployeeId(Integer initiatedByEmployeeId)   { this.initiatedByEmployeeId = initiatedByEmployeeId; }

    public String getDescription()                             { return description; }
    public void setDescription(String description)             { this.description = description; }

    public LocalDateTime getTimestamp()                        { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp)          { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return String.format("Transaction{id=%d, type=%s, amount=$%.2f, balanceAfter=$%.2f, timestamp=%s}",
                id, type, amount, balanceAfter, timestamp);
    }
}
