package cz.malanak.accounts;

import cz.malanak.identification.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class BaseAccount {
    protected BigDecimal _balance;
    public UUID uuid;
    public final Customer _owner;
    public BaseAccount(Customer owner) {
        _owner = owner;
        _balance = new BigDecimal(0);
        uuid = UUID.randomUUID();
    }

    public abstract void printAccountInfo();
}
