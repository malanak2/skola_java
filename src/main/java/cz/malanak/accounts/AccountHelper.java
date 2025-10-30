package cz.malanak.accounts;

import com.google.inject.Inject;
import cz.malanak.Logger;

import java.math.BigDecimal;

public class AccountHelper {
    @Inject
        private Logger logger;
        public boolean validateDeposit(BaseAccount account, BigDecimal amount) {
            if (amount.floatValue() < 0) {
                return false;
            }
            if (amount.compareTo(new BigDecimal(100000)) > 0) {
                logger.warn("Suspicious deposit on account " + account.uuid + account.owner.name);
                return true;
            }
            return true;
        }

        public boolean validateWithdraw(BigDecimal balance, BigDecimal amount) {
            if (amount.floatValue() < 0) {
                return false;
            }
            return true;
    }
}
