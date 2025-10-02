package cz.malanak.accounts;

import cz.malanak.identification.Customer;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.util.UUID;

import static cz.malanak.Logger.warn;

public abstract class BaseAccount {
    protected BigDecimal _balance;
    public UUID uuid;
    public final Customer owner;
    public BaseAccount(Customer owner) {
        this.owner = owner;
        _balance = new BigDecimal(0);
        uuid = UUID.randomUUID();
    }

    public abstract void printAccountInfo();
    public void addBalance(BigDecimal value) {
        if (!AccountHelper.validateDeposit(this, value)) {
            throw new IllegalArgumentException("Value not depositable");
        }
        _balance = _balance.add(value);
    }

    public BigDecimal removeBalance(BigDecimal value) throws Exception {
        if (!AccountHelper.validateWithdraw(_balance, value)) {
            throw new IllegalArgumentException("Not possible to withdraw");
        }
        _balance = _balance.subtract(value);
        return value;
    }

    public BigDecimal getBalance() { return _balance;}
}
