-- Customers
CREATE TABLE IF NOT EXISTS customers (
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name     VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    phone         VARCHAR(20),
    created_at    TIMESTAMP    NOT NULL DEFAULT NOW()
);

-- Employees
CREATE TABLE IF NOT EXISTS employees (
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name     VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    created_at    TIMESTAMP    NOT NULL DEFAULT NOW()
);

-- Bank Accounts
CREATE TABLE IF NOT EXISTS accounts (
    id          SERIAL PRIMARY KEY,
    customer_id INT          NOT NULL REFERENCES customers(id),
    type        VARCHAR(10)  NOT NULL CHECK (type IN ('CHECKING', 'SAVINGS')),
    status      VARCHAR(10)  NOT NULL DEFAULT 'ACTIVE'
                             CHECK (status IN ('ACTIVE', 'FROZEN', 'CLOSED')),
    balance     NUMERIC(15,2) NOT NULL DEFAULT 0.00
                             CHECK (balance >= 0),
    created_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);

-- Transactions
CREATE TABLE IF NOT EXISTS transactions (
    id                      SERIAL PRIMARY KEY,
    account_id              INT            NOT NULL REFERENCES accounts(id),
    type                    VARCHAR(20)    NOT NULL
                            CHECK (type IN ('DEPOSIT','WITHDRAWAL','TRANSFER_IN','TRANSFER_OUT','WIRE_TRANSFER')),
    amount                  NUMERIC(15,2)  NOT NULL CHECK (amount > 0),
    balance_after           NUMERIC(15,2)  NOT NULL,
    initiated_by_employee_id INT           REFERENCES employees(id),
    description             VARCHAR(255),
    timestamp               TIMESTAMP      NOT NULL DEFAULT NOW()
);

-- Indexes
CREATE INDEX IF NOT EXISTS idx_accounts_customer_id    ON accounts(customer_id);
CREATE INDEX IF NOT EXISTS idx_transactions_account_id ON transactions(account_id);
CREATE INDEX IF NOT EXISTS idx_transactions_timestamp  ON transactions(timestamp);
CREATE INDEX IF NOT EXISTS idx_transactions_type       ON transactions(type);
