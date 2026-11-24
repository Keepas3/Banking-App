package com.bryan.banking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {

    private int id;
    private int customerId;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    public Account() {}

    public Account(int id, int customerId, AccountType type,
                   AccountStatus status, BigDecimal balance,
                   LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.status = status;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getId()                             { return id; }
    public void setId(int id)                      { this.id = id; }

    public int getCustomerId()                     { return customerId; }
    public void setCustomerId(int customerId)      { this.customerId = customerId; }

    public AccountType getType()                   { return type; }
    public void setType(AccountType type)          { this.type = type; }

    public AccountStatus getStatus()               { return status; }
    public void setStatus(AccountStatus status)    { this.status = status; }

    public BigDecimal getBalance()                 { return balance; }
    public void setBalance(BigDecimal balance)     { this.balance = balance; }

    public LocalDateTime getCreatedAt()                { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt)  { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return String.format("Account{id=%d, type=%s, status=%s, balance=$%.2f}",
                id, type, status, balance);
    }
}
