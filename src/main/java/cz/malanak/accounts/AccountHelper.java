package cz.malanak.accounts;

import java.math.BigDecimal;

import static cz.malanak.Logger.warn;

public class AccountHelper {

        public static boolean validateDeposit(BaseAccount account, BigDecimal amount) {
            if (amount.floatValue() < 0) {
                return false;
            }
            if (amount.compareTo(new BigDecimal(100000)) > 0) {
                warn("Suspicious deposit on account " + account.uuid + account.owner.name);
                return true;
            }
            return true;
        }

        public static boolean validateWithdraw(BigDecimal balance, BigDecimal amount) {
            if (amount.floatValue() < 0) {
                return false;
            }
            return true;
    }
}
