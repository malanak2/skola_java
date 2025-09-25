package cz.malanak.accounts;

import cz.malanak.identification.Customer;

import java.math.BigDecimal;

public class SaveAccount extends BankAccount {
    private BigDecimal _interest_rate;
    public SaveAccount(Customer owner, BigDecimal interest_rate) {
        super(owner);
        _interest_rate = interest_rate;
    }

    public BigDecimal get_interest_rate() { return _interest_rate; };
}