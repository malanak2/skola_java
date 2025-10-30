package cz.malanak.accounts;

import com.google.gson.annotations.SerializedName;
import cz.malanak.Logger;
import cz.malanak.identification.Customer;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.UUID;


public abstract class BaseAccount {
    protected AccountHelper accountHelper;
    protected Logger logger;

    @SerializedName("balance")
    protected BigDecimal _balance;
    @SerializedName("balance")
    public UUID uuid;
    @SerializedName("owner")
    public final Customer owner;
    public BaseAccount(Customer owner, AccountHelper accountHelper, Logger logger) {
        this.owner = owner;
        this.accountHelper = accountHelper;
        this.logger = logger;
        _balance = new BigDecimal(0);
        uuid = UUID.randomUUID();
    }

    public abstract void printAccountInfo();
    public void addBalance(BigDecimal value) {
        if (!accountHelper.validateDeposit(this, value)) {
            throw new IllegalArgumentException("Value not depositable");
        }
        _balance = _balance.add(value);
    }

    public BigDecimal removeBalance(BigDecimal value) throws IllegalArgumentException {
        if (!accountHelper.validateWithdraw(_balance, value)) {
            throw new IllegalArgumentException("Not possible to withdraw");
        }
        _balance = _balance.subtract(value);
        return value;
    }

    public BigDecimal getBalance() { return _balance;}
}
