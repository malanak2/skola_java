package cz.malanak.accounts;

import cz.malanak.identification.Customer;

import java.math.BigDecimal;

public class SaveAccount extends BaseAccount {
    private BigDecimal _interest_rate;
    public SaveAccount(Customer owner, BigDecimal interest_rate) {
        super(owner);
        _interest_rate = interest_rate;
    }

    public BigDecimal get_interest_rate() { return _interest_rate; };

    @Override
    public void printAccountInfo() {
        System.out.println(String.format("[SaveAccount]: %s, %s, %s, %f", owner.toString(), uuid.toString(), _interest_rate, _balance.floatValue()));
    }
}