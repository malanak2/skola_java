package cz.malanak.accounts;

import cz.malanak.identification.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private BigDecimal _balance;
    public UUID uuid;
    public final Customer _owner;
    public BankAccount(Customer owner) {
        _owner = owner;
        _balance = new BigDecimal(0);
        uuid = UUID.randomUUID();
    }

    public void printAccountInfo() {
        System.out.println(String.format("[BankAccount]: %s, %s, %d", _owner.toString(), uuid.toString(), _balance.floatValue()));
    }
}
