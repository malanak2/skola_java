package cz.malanak.accounts;

import cz.malanak.Logger;
import cz.malanak.identification.Customer;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount extends BaseAccount {

    public BankAccount(Customer owner, AccountHelper accountHelper, Logger logger) {
        super(owner, accountHelper, logger);
    }

    public void printAccountInfo() {
        logger.debug(String.format("[BankAccount]: %s, %s, %f", owner.toString(), uuid.toString(), _balance.floatValue()));
    }
}
