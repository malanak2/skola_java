package cz.malanak.accounts;

import cz.malanak.identification.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount extends BaseAccount {

    public BankAccount(Customer owner) {
        super(owner);
    }

    public void printAccountInfo() {
        System.out.println(String.format("[BankAccount]: %s, %s, %f", owner.toString(), uuid.toString(), _balance.floatValue()));
    }
}
