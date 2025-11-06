package cz.malanak.accounts;

import cz.malanak.Logger;
import cz.malanak.identification.Customer;

import java.math.BigDecimal;

public class SaveAccount extends BaseAccount {
    private BigDecimal _interest_rate;
    public SaveAccount(Customer owner, BigDecimal interest_rate, AccountHelper accountHelper, Logger logger) {
        super(owner, accountHelper, logger);
        _interest_rate = interest_rate;
    }

    public BigDecimal get_interest_rate() { return _interest_rate; };

    public void apply_interest_rate() {
        BigDecimal prev = _balance;
        _balance =_balance.add(_interest_rate.multiply(_balance));
        logger.info(String.format("Added interest for account %s, before: %s, after: %s with an interest of %s", uuid, prev.toString(), _balance.toString(), _interest_rate.toString()));
    }
    @Override
    public void printAccountInfo() {
        logger.debug(String.format("[SaveAccount]: %s, %s, %s, %f", owner.toString(), uuid.toString(), _interest_rate, _balance.floatValue()));
    }
}