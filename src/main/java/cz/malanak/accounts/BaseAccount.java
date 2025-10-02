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
        if (value.floatValue() < 0) {
            throw new IllegalArgumentException("Negative/0 values cannot be added balance");
        }
        if (value.compareTo(new BigDecimal(100000)) > 0) {
            warn(String.format("Customer %s has deposited %f to his account with id %s", owner.toString(), value.floatValue(), uuid));
        }
        _balance = _balance.add(value);
    }

    public BigDecimal removeBalance(BigDecimal value, boolean exact) throws Exception {
        if (value.floatValue() < 0) {
            throw new IllegalArgumentException("Negative/0 values cannot be added balance");
        }
        if (exact && _balance.compareTo(value) < 0) {
            throw new Exception("Not enough balance");
        }
        if (_balance.compareTo(value) < 0) {
            BigDecimal ret = _balance;
            _balance = new BigDecimal(0);
            return ret;
        }
        _balance = _balance.subtract(value);
        return value;
    }
}
