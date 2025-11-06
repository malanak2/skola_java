package cz.malanak.Services;

import com.google.inject.Inject;
import cz.malanak.History.Transaction;
import cz.malanak.History.TransactionType;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.factories.TransactionFactory;

import java.math.BigDecimal;

public class TransactionService {
    @Inject
    TransactionFactory transactionFactory;
    public BigDecimal applyInterest(SaveAccount account) {
        BigDecimal amount = account.apply_interest_rate();
        Transaction t = transactionFactory.newTransaction(TransactionType.Interest, account.getBalance().subtract(amount), account.getBalance(), account.uuid, true);
        account.transactionHistory.add(t);
        return amount;
    }
}
